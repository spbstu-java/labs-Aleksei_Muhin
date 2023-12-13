package PACKAGE_NAME;

import java.io.*;
import java.util.Random;

public class MatrixManipulationApp {
    private static final int MAX_MATRIX_SIZE = 1000000;

    public static void main(String[] args) {
        try {
            String basePath = "lab2/src";  // Adjust this base path according to your project structure
            int size = readMatrixSize(basePath + File.separator + "matrix_size.txt");

            try {
                checkMatrixSize(size);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return;
            }

            int[][] matrix = createRandomMatrix(size);
            writeMatrixToFile(basePath + File.separator + "original_matrix.txt", matrix);

            int[][] rotatedMatrix90 = rotateMatrix(matrix, 90);
            int[][] rotatedMatrix180 = rotateMatrix(matrix, 180);
            int[][] rotatedMatrix270 = rotateMatrix(matrix, 270);

            int[][] dividedMatrix90 = divideMatrix(rotatedMatrix90);
            int[][] dividedMatrix180 = divideMatrix(rotatedMatrix180);
            int[][] dividedMatrix270 = divideMatrix(rotatedMatrix270);

            writeMatrixToFile(basePath + File.separator + "result90.txt", dividedMatrix90);
            writeMatrixToFile(basePath + File.separator + "result180.txt", dividedMatrix180);
            writeMatrixToFile(basePath + File.separator + "result270.txt", dividedMatrix270);

            System.out.println("Результаты записаны в файлы result90.txt, result180.txt и result270.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Произошла ошибка при чтении/записи файла");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Произошла ошибка, введены некорректные исходные данные");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("Произошло деление на ноль во время обработки матрицы");
        }
    }

    private static void checkMatrixSize(int size) {
        if (size > MAX_MATRIX_SIZE) {
            throw new IllegalArgumentException("Размер матрицы не может превышать " + MAX_MATRIX_SIZE);
        }
    }

    private static int readMatrixSize(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            return Integer.parseInt(line);
        }
    }

    private static int[][] createRandomMatrix(int size) {
        if (size > MAX_MATRIX_SIZE) {
            throw new IllegalArgumentException("Размер матрицы не может превышать " + MAX_MATRIX_SIZE);
        }

        int[][] matrix = new int[size][size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(2 * size + 1) - size;
            }
        }

        return matrix;
    }

    private static void writeMatrixToFile(String fileName, int[][] matrix) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int[] row : matrix) {
                for (int value : row) {
                    writer.write(value + "\t");
                }
                writer.write("\n");
            }
            writer.write("####################\n");
        }
    }

    private static int[][] rotateMatrix(int[][] matrix, int degrees) {
        int size = matrix.length;
        int[][] rotatedMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (degrees == 90) {
                    rotatedMatrix[i][j] = matrix[size - 1 - j][i];
                } else if (degrees == 180) {
                    rotatedMatrix[i][j] = matrix[size - 1 - i][size - 1 - j];
                } else if (degrees == 270) {
                    rotatedMatrix[i][j] = matrix[j][size - 1 - i];
                }
            }
        }

        return rotatedMatrix;
    }

    private static int[][] divideMatrix(int[][] matrix) {
        int size = matrix.length;
        int[][] dividedMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                boolean divideByZero = false;

                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k >= 0 && k < size && l >= 0 && l < size && (k != i || l != j)) {
                            sum += matrix[k][l];
                            if (matrix[k][l] == 0) {
                                divideByZero = true;
                            }
                        }
                    }
                }

                if (divideByZero) {
                    throw new ArithmeticException("Деление на ноль в позиции (" + i + ", " + j + ")");
                } else {
                    dividedMatrix[i][j] = sum == 0 ? 0 : matrix[i][j] / sum;
                }
            }
        }

        return dividedMatrix;
    }
}
