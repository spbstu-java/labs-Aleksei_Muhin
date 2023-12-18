package lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class MatrixConsoleApplication extends JFrame {
    private String pathToInputFile = "";
    private String exception;
    private final boolean append = true; //Параметр для очистки выходного файла, чтобы не чистить руками

    private final String pathToOutputFile = "./src/lab2/matrixOutput.txt";

    public MatrixConsoleApplication() {
        super("lab_2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 1000);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel pathToInputFileLabel = new JLabel("Please specify the location of the input data file:");
        pathToInputFileLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pathToInputFileLabel.setBounds(27, 16, 400, 23);
        contentPane.add(pathToInputFileLabel);

        JTextField pathToInputFileField = new JTextField();
        pathToInputFileField.setBounds(27, 39, 500, 23);
        pathToInputFileField.setColumns(500);
        pathToInputFileField.setEditable(false);
        contentPane.add(pathToInputFileField);

        JButton btnSelectInputFile = new JButton("Select a path to input file");
        btnSelectInputFile.setBounds(527, 39, 100, 23);
        contentPane.add(btnSelectInputFile);

        JFileChooser pathInputFileChooser = new JFileChooser("./src/lab2/");
        btnSelectInputFile.addActionListener(e -> {
            // Определение режима - только каталог
            pathInputFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = pathInputFileChooser.showOpenDialog(MatrixConsoleApplication.this);
            // Если директория выбрана, покажем ее в сообщении
            if (result == JFileChooser.APPROVE_OPTION) {
                pathToInputFileField.setText(String.valueOf(pathInputFileChooser.getSelectedFile()));
                pathToInputFile = pathToInputFileField.getText();
            }
        });

        JLabel calculationResultsLabel = new JLabel("Calculation results:");
        calculationResultsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        calculationResultsLabel.setBounds(27, 120, 400, 23);
        contentPane.add(calculationResultsLabel);

        JLabel exceptionLabel = new JLabel("Exceptions when the program is running:");
        exceptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        exceptionLabel.setBounds(27, 150, 400, 23);
        contentPane.add(exceptionLabel);

        JTextField exceptionField = new JTextField();
        exceptionField.setBounds(27, 173, 500, 23);
        exceptionField.setColumns(500);
        exceptionField.setEditable(false);
        contentPane.add(exceptionField);

        JLabel pathToOutputFileLabel = new JLabel("Path of the output file:");
        pathToOutputFileLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pathToOutputFileLabel.setBounds(27, 200, 400, 23);
        contentPane.add(pathToOutputFileLabel);

        JTextField pathToOutputFileField = new JTextField();
        pathToOutputFileField.setBounds(27, 223, 500, 23);
        pathToOutputFileField.setColumns(500);
        pathToOutputFileField.setEditable(false);
        contentPane.add(pathToOutputFileField);

        JLabel originalMatrixLabel = new JLabel("The original matrix:");
        originalMatrixLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        originalMatrixLabel.setBounds(727, 46, 450, 23);
        contentPane.add(originalMatrixLabel);

        JTextArea originalMatrixField = new JTextArea();
        originalMatrixField.setBounds(727, 69, 138, 138);
        originalMatrixField.setColumns(500);
        originalMatrixField.setEditable(false);
        contentPane.add(originalMatrixField);

        JLabel rotatedMatrix90Label = new JLabel("The matrix is rotated by 90 degrees:");
        rotatedMatrix90Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rotatedMatrix90Label.setBounds(27, 246, 300, 23);
        contentPane.add(rotatedMatrix90Label);

        JTextArea rotatedMatrix90Field = new JTextArea();
        rotatedMatrix90Field.setBounds(27, 269, 138, 138);
        rotatedMatrix90Field.setColumns(500);
        rotatedMatrix90Field.setEditable(false);
        contentPane.add(rotatedMatrix90Field);

        JLabel rotatedMatrix90DevidedLabel = new JLabel("A matrix rotated by 90 degrees and with elements divided by the sum of adjacent elements");
        rotatedMatrix90DevidedLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rotatedMatrix90DevidedLabel.setBounds(300, 246, 600, 23);
        contentPane.add(rotatedMatrix90DevidedLabel);

        JTextArea rotatedMatrix90DevidedField = new JTextArea();
        rotatedMatrix90DevidedField.setBounds(300, 269, 138, 138);
        rotatedMatrix90DevidedField.setColumns(500);
        rotatedMatrix90DevidedField.setEditable(false);
        contentPane.add(rotatedMatrix90DevidedField);

        JLabel rotatedMatrix180Label = new JLabel("The matrix is rotated by 180 degrees:");
        rotatedMatrix180Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rotatedMatrix180Label.setBounds(27, 410, 300, 23);
        contentPane.add(rotatedMatrix180Label);

        JTextArea rotatedMatrix180Field = new JTextArea();
        rotatedMatrix180Field.setBounds(27, 430, 138, 138);
        rotatedMatrix180Field.setColumns(500);
        rotatedMatrix180Field.setEditable(false);
        contentPane.add(rotatedMatrix180Field);

        JLabel rotatedMatrix180DevidedLabel = new JLabel("A matrix rotated by 180 degrees and with elements divided by the sum of adjacent elements");
        rotatedMatrix180DevidedLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rotatedMatrix180DevidedLabel.setBounds(300, 410, 600, 23);
        contentPane.add(rotatedMatrix180DevidedLabel);

        JTextArea rotatedMatrix180DevidedField = new JTextArea();
        rotatedMatrix180DevidedField.setBounds(300, 430, 138, 138);
        rotatedMatrix180DevidedField.setColumns(500);
        rotatedMatrix180DevidedField.setEditable(false);
        contentPane.add(rotatedMatrix180DevidedField);

        JLabel rotatedMatrix270Label = new JLabel("The matrix is rotated by 270 degrees:");
        rotatedMatrix270Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rotatedMatrix270Label.setBounds(27, 568, 300, 23);
        contentPane.add(rotatedMatrix270Label);

        JTextArea rotatedMatrix270Field = new JTextArea();
        rotatedMatrix270Field.setBounds(27, 591, 138, 138);
        rotatedMatrix270Field.setColumns(500);
        rotatedMatrix270Field.setEditable(false);
        contentPane.add(rotatedMatrix270Field);

        JLabel rotatedMatrix270DevidedLabel = new JLabel("A matrix rotated by 270 degrees and with elements divided by the sum of adjacent elements");
        rotatedMatrix270DevidedLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rotatedMatrix270DevidedLabel.setBounds(300, 568, 600, 23);
        contentPane.add(rotatedMatrix270DevidedLabel);

        JTextArea rotatedMatrix270DevidedField = new JTextArea();
        rotatedMatrix270DevidedField.setBounds(300, 591, 138, 138);
        rotatedMatrix270DevidedField.setColumns(500);
        rotatedMatrix270DevidedField.setEditable(false);
        contentPane.add(rotatedMatrix270DevidedField);

        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(arg0 -> {
            if(arg0.getSource() == btnCalculate) {
                pathToOutputFileField.setText("");
                originalMatrixField.setText("");
                rotatedMatrix90Field.setText("");
                rotatedMatrix90DevidedField.setText("");
                rotatedMatrix180Field.setText("");
                rotatedMatrix180DevidedField.setText("");
                rotatedMatrix270Field.setText("");
                rotatedMatrix270DevidedField.setText("");

                MatrixManipulationApp workingOnMatrix = new MatrixManipulationApp();
                try {
                    String basePath = "src/lab2";  // Adjust this base path according to your project structure
                    int size = workingOnMatrix.readMatrixSize(basePath + File.separator + "matrix_size.txt");

                    try {
                        workingOnMatrix.checkMatrixSize(size);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                        return;
                    }
                    //pathToOutputFileField.setText(pathToOutputFile);

                   // originalMatrixField.setText(workingOnMatrix.printMatrix(matrix, pathToOutputFile, "Original matrix\n", append));

                    int[][] matrix = workingOnMatrix.createRandomMatrix(size);
                    workingOnMatrix.writeMatrixToFile(pathToOutputFile, matrix);

                    pathToOutputFileField.setText(pathToOutputFile);
                    originalMatrixField.setText(workingOnMatrix.printMatrix(matrix, pathToOutputFile, "Original matrix\n"));

                    int[][] rotatedMatrix90 = workingOnMatrix.rotateMatrix(matrix, 90);
                    int[][] rotatedMatrix180 = workingOnMatrix.rotateMatrix(matrix, 180);
                    int[][] rotatedMatrix270 = MatrixManipulationApp.rotateMatrix(matrix, 270);

                    int[][] dividedMatrix90 = workingOnMatrix.divideMatrix(rotatedMatrix90);
                    int[][] dividedMatrix180 = workingOnMatrix.divideMatrix(rotatedMatrix180);
                    int[][] dividedMatrix270 = workingOnMatrix.divideMatrix(rotatedMatrix270);

                    rotatedMatrix90Field.setText(workingOnMatrix.printMatrix(rotatedMatrix90, pathToOutputFile, "Matrix rotated 90 degrees counterclockwise\n"));
                    rotatedMatrix90DevidedField.setText(workingOnMatrix.printMatrix(dividedMatrix90, pathToOutputFile, "A matrix rotated by 90 degrees and with elements divided by the sum of adjacent elements\n"));

                    workingOnMatrix.writeMatrixToFile(pathToOutputFile, dividedMatrix90);

                    rotatedMatrix180Field.setText(workingOnMatrix.printMatrix(rotatedMatrix180, pathToOutputFile, "Matrix rotated 180 degrees counterclockwise\n"));
                    rotatedMatrix180DevidedField.setText(workingOnMatrix.printMatrix(dividedMatrix180, pathToOutputFile, "A matrix rotated by 180 degrees and with elements divided by the sum of adjacent elements\n"));

                    workingOnMatrix.writeMatrixToFile(pathToOutputFile, dividedMatrix180);

                    rotatedMatrix270Field.setText(workingOnMatrix.printMatrix(rotatedMatrix270, pathToOutputFile, "Matrix rotated 270 degrees counterclockwise\n"));
                    rotatedMatrix270DevidedField.setText(workingOnMatrix.printMatrix(dividedMatrix270, pathToOutputFile, "A matrix rotated by 270 degrees and with elements divided by the sum of adjacent elements\n"));

                    workingOnMatrix.writeMatrixToFile(pathToOutputFile, dividedMatrix270);

                    System.out.println("Результаты записаны в файлы result90.txt, result180.txt и result270.txt");

                    exception = "";

                } catch (IOException e) {
                    e.printStackTrace();
                    exception = "Произошла ошибка при чтении/записи файла";
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    exception = "Произошла ошибка, введены некорректные исходные данные";
                } catch (ArithmeticException e) {
                    e.printStackTrace();
                    exception = "Произошло деление на ноль во время обработки матрицы";
                }

            }
            exceptionField.setText(exception);

            setVisible(true);
        });
        btnCalculate.setBounds(27, 80, 600, 40);
        contentPane.add(btnCalculate);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener((ActionEvent e) -> {
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        });
        btnExit.setBounds(727, 706, 75, 23);
        contentPane.add(btnExit);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MatrixConsoleApplication frame = new MatrixConsoleApplication();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}