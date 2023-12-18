package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main extends JFrame {
    private String exception = "";


    public Main() {
        super("lab_4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 550);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel ResultsLabel = new JLabel("Results:");
        ResultsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ResultsLabel.setBounds(27, 40, 400, 23);
        contentPane.add(ResultsLabel);

        JLabel exceptionLabel = new JLabel("Exceptions when the program is running:");
        exceptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        exceptionLabel.setBounds(27, 63, 400, 23);
        contentPane.add(exceptionLabel);

        JTextField exceptionField = new JTextField();
        exceptionField.setBounds(27, 86, 500, 23);
        exceptionField.setColumns(500);
        exceptionField.setEditable(false);
        contentPane.add(exceptionField);

        JLabel translatedTextLabel = new JLabel("Translated text:");
        translatedTextLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        translatedTextLabel.setBounds(27, 110, 400, 23);
        contentPane.add(translatedTextLabel);

        JTextArea methodTextField = new JTextArea();
        methodTextField.setBounds(27, 133, 600, 300);
        methodTextField.setColumns(500);
        methodTextField.setEditable(false);
        contentPane.add(methodTextField);

        JButton btnGetMethod = new JButton("Get methods");
        btnGetMethod.addActionListener(arg0 -> {
            if(arg0.getSource() == btnGetMethod) {
                for (Method method : Methods.class.getDeclaredMethods()) {
                    if (method.isAnnotationPresent(IntegerAnnotation.class)) {
                        IntegerAnnotation annotation = method.getAnnotation(IntegerAnnotation.class);
                        method.setAccessible(true);
                        for (int j = 0; j < annotation.count(); j++) {
                            try {
                                if (method.getModifiers() == 2 || method.getModifiers() == 4) {
                                    method.invoke(new Methods(methodTextField));
                                }
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                exceptionField.setText("IllegalAccessException | InvocationTargetException");
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            setVisible(true);
        });
        btnGetMethod.setBounds(27, 20, 600, 40);
        contentPane.add(btnGetMethod);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener((ActionEvent e) -> {
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        });
        btnExit.setBounds(552, 450, 75, 23);
        contentPane.add(btnExit);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Main frame = new Main();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
