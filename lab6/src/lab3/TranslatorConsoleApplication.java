package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TranslatorConsoleApplication extends JFrame {
    private String pathToInputDictionaryFile = "";
    private String pathToInputTextFile = "";

    private String exception = "";

    public TranslatorConsoleApplication() {
        super("lab_3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 1000);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel pathToInputDictionaryFileLabel = new JLabel("Please specify the location of the input dictionary file:");
        pathToInputDictionaryFileLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pathToInputDictionaryFileLabel.setBounds(27, 16, 400, 23);
        contentPane.add(pathToInputDictionaryFileLabel);

        JTextField pathToInputDictionaryFileField = new JTextField();
        pathToInputDictionaryFileField.setBounds(27, 39, 500, 23);
        pathToInputDictionaryFileField.setColumns(500);
        pathToInputDictionaryFileField.setEditable(false);
        contentPane.add(pathToInputDictionaryFileField);

        JButton btnSelectInputDictionaryFile = new JButton("Select a path to input file");
        btnSelectInputDictionaryFile.setBounds(527, 39, 100, 23);
        contentPane.add(btnSelectInputDictionaryFile);

        JFileChooser pathInputDictionaryFileChooser = new JFileChooser("./src/lab3/");
        btnSelectInputDictionaryFile.addActionListener(e -> {
            pathInputDictionaryFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = pathInputDictionaryFileChooser.showOpenDialog(TranslatorConsoleApplication.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                pathToInputDictionaryFileField.setText(String.valueOf(pathInputDictionaryFileChooser.getSelectedFile()));
                pathToInputDictionaryFile = pathToInputDictionaryFileField.getText();
            }
        });

        JLabel pathToInputTextFileLabel = new JLabel("Please specify the location of the input text for translation file:");
        pathToInputTextFileLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pathToInputTextFileLabel.setBounds(27, 78, 400, 23);
        contentPane.add(pathToInputTextFileLabel);

        JTextField pathToInputTextFileField = new JTextField();
        pathToInputTextFileField.setBounds(27, 101, 500, 23);
        pathToInputTextFileField.setColumns(500);
        pathToInputTextFileField.setEditable(false);
        contentPane.add(pathToInputTextFileField);

        JButton btnSelectInputTextFile = new JButton("Select a path to input file");
        btnSelectInputTextFile.setBounds(527, 101, 100, 23);
        contentPane.add(btnSelectInputTextFile);

        JFileChooser pathInputTextFileChooser = new JFileChooser("./src/lab3/");
        btnSelectInputTextFile.addActionListener(e -> {
            pathInputTextFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = pathInputTextFileChooser.showOpenDialog(TranslatorConsoleApplication.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                pathToInputTextFileField.setText(String.valueOf(pathInputTextFileChooser.getSelectedFile()));
                pathToInputTextFile = pathToInputTextFileField.getText();
            }
        });

        JLabel calculationResultsLabel = new JLabel("Translation results:");
        calculationResultsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        calculationResultsLabel.setBounds(27, 180, 400, 23);
        contentPane.add(calculationResultsLabel);

        JLabel exceptionLabel = new JLabel("Exceptions when the program is running:");
        exceptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        exceptionLabel.setBounds(27, 203, 400, 23);
        contentPane.add(exceptionLabel);

        JTextField exceptionField = new JTextField();
        exceptionField.setBounds(27, 226, 500, 23);
        exceptionField.setColumns(500);
        exceptionField.setEditable(false);
        contentPane.add(exceptionField);

        JLabel translatedTextLabel = new JLabel("Translated text:");
        translatedTextLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        translatedTextLabel.setBounds(27, 250, 400, 23);
        contentPane.add(translatedTextLabel);

        JTextArea translatedTextField = new JTextArea();
        translatedTextField.setBounds(27, 273, 600, 150);
        translatedTextField.setColumns(500);
        translatedTextField.setEditable(false);
        contentPane.add(translatedTextField);

        JButton btnTranslate = new JButton("Translate");
        btnTranslate.addActionListener(arg0 -> {
            if(arg0.getSource() == btnTranslate) {
                try {

                    Map<String, String> dictionary = readDictionary(pathToInputDictionaryFile);

                    try (BufferedReader reader = new BufferedReader(new FileReader(pathToInputTextFile))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String translation = translateText(line, dictionary);
                            translatedTextField.setText(translation);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        exception = "Произошла ошибка при чтении/записи файла";
                        exceptionField.setText(exception);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    exception = "Произошла ошибка при чтении словаря";
                    exceptionField.setText(exception);
                }

            }
            setVisible(true);
        });
        btnTranslate.setBounds(27, 140, 600, 40);
        contentPane.add(btnTranslate);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener((ActionEvent e) -> {
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        });
        btnExit.setBounds(552, 425, 75, 23);
        contentPane.add(btnExit);
    }
    private static Map<String, String> readDictionary(String filePath) throws IOException {
        Map<String, String> dictionary = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 2) {
                    String word = parts[0].trim().toLowerCase();
                    String translation = parts[1].trim();
                    dictionary.put(word, translation);
                }
            }
        }

        return dictionary;
    }
    private static String translateText(String text, Map<String, String> dictionary) {
        String[] words = text.split("\\s+");
        StringBuilder translation = new StringBuilder();

        for (String word : words) {
            word = word.toLowerCase();
            String translatedWord = dictionary.get(word);

            if (translatedWord != null) {
                translation.append(translatedWord).append(" ");
            } else {
                translation.append(word).append(" ");
            }
        }

        return translation.toString().trim();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TranslatorConsoleApplication frame = new TranslatorConsoleApplication();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
