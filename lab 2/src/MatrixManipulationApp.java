import java.io.*;
import java.util.Random;

public class MatrixManipulationApp {
    public static void main(String[] args) {
        try {
            int size = readMatrixSize("D:\\ProgramJaVa\\lab 2\\src\\matrix_size.txt");
            int[][] matrix = createRandomMatrix(size);
            writeMatrixToFile("D:\\ProgramJaVa\\lab 2\\src\\original_matrix.txt", matrix);

            int[][] rotatedMatrix90 = rotateMatrix(matrix, 90);
            int[][] rotatedMatrix180 = rotateMatrix(matrix, 180);
            int[][] rotatedMatrix270 = rotateMatrix(matrix, 270);

            int[][] dividedMatrix90 = divideMatrix(rotatedMatrix90);
            int[][] dividedMatrix180 = divideMatrix(rotatedMatrix180);
            int[][] dividedMatrix270 = divideMatrix(rotatedMatrix270);

            writeMatrixToFile("D:\\ProgramJaVa\\lab 2\\src\\result90.txt", dividedMatrix90);
            writeMatrixToFile("D:\\ProgramJaVa\\lab 2\\src\\result180.txt", dividedMatrix180);
            writeMatrixToFile("D:\\ProgramJaVa\\lab 2\\src\\result270.txt", dividedMatrix270);

            System.out.println("Результаты записаны в файлы result90.txt, result180.txt и result270.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Произошла ошибка при чтении/записи файла");
        }
    }

    private static int readMatrixSize(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            return Integer.parseInt(line);
        }
    }

    private static int[][] createRandomMatrix(int size) {
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

                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k >= 0 && k < size && l >= 0 && l < size && (k != i || l != j)) {
                            sum += matrix[k][l];
                        }
                    }
                }

                if (sum == 0) {
                    dividedMatrix[i][j] = 0;
                } else {
                    dividedMatrix[i][j] = matrix[i][j] / sum;
                }
            }
        }

        return dividedMatrix;
    }
}
