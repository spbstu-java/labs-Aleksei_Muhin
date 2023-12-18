package lab4;

import javax.swing.*;

public class Methods {
    private final JTextArea jTextArea;

    public Methods(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    @IntegerAnnotation(count = 1)
    public void getFirstPublicMethod(){
        System.out.println("I first public method");
    }

    @IntegerAnnotation(count = 2)
    public void getSecondPublicMethod(){
        jTextArea.setText(jTextArea.getText() + '\n' + "I second public method");
        System.out.println("I second public method");
    }

    @IntegerAnnotation(count = 3)
    public void getThirdPublicMethod(){
        jTextArea.setText(jTextArea.getText() + '\n' + "I third public method");
        System.out.println("I third public method");
    }

    @IntegerAnnotation(count = 1)
    private void getFirstPrivateMethod(){
        jTextArea.setText(jTextArea.getText() + '\n' + "I first private method");
        System.out.println("I first private method");
    }

    @IntegerAnnotation(count = 2)
    private void getSecondPrivateMethod(){
        jTextArea.setText(jTextArea.getText() + '\n' + "I second private method");
        System.out.println("I second private method");
    }

    @IntegerAnnotation(count = 3)
    private void getThirdPrivateMethod(){
        jTextArea.setText(jTextArea.getText() + '\n' + "I third private method");
        System.out.println("I third private method");
    }

    @IntegerAnnotation(count = 1)
    protected void getFirstProtectedMethod(){
        jTextArea.setText(jTextArea.getText() + '\n' + "I first protected method");
        System.out.println("I first protected method");
    }

    @IntegerAnnotation(count = 2)
    protected void getSecondProtectedMethod(){
        jTextArea.setText(jTextArea.getText() + '\n' + "I second protected method");
        System.out.println("I second protected method");
    }

    @IntegerAnnotation(count = 3)
    protected void getThirdProtectedMethod(){
        jTextArea.setText(jTextArea.getText() + '\n' + "I third protected method");
        System.out.println("I third protected method");
    }
/*
    private JTextArea setTextField(String text) {
        JTextArea methodTextField = new JTextArea();
        methodTextField.setBounds(27, 273, 600, 500);
        methodTextField.setColumns(500);
        methodTextField.setText(text);
        methodTextField.setEditable(false);
        contentPane.add(methodTextField);
        return methodTextField;
    }

 */
}
