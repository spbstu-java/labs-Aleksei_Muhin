


import lab1.Hero;
import lab1.SwingMovementUI;
import lab2.MatrixConsoleApplication;
import lab3.TranslatorConsoleApplication;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    JMenu menu;
    JMenuItem a1,a2;
    Main(){
        super("lab_6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 700);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnLab1 = new JButton("Lab1");
        btnLab1.addActionListener(arg0 -> {
            if(arg0.getSource() == btnLab1) {
                EventQueue.invokeLater(() -> {
                    try {
                        Hero hero = new Hero();

                        SwingMovementUI movementUI = new SwingMovementUI(hero);
                        movementUI.createAndShowUI();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            setVisible(true);
        });
        btnLab1.setBounds(27, 20, 250, 100);
        contentPane.add(btnLab1);

        JButton btnLab2 = new JButton("Lab 2");
        btnLab2.addActionListener(arg0 -> {
            if(arg0.getSource() == btnLab2) {
                EventQueue.invokeLater(() -> {
                    try {
                        MatrixConsoleApplication frame = new MatrixConsoleApplication();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            setVisible(true);
        });
        btnLab2.setBounds(27, 130, 250, 100);
        contentPane.add(btnLab2);

        JButton btnLab3 = new JButton("Lab 3");
        btnLab3.addActionListener(arg0 -> {
            if(arg0.getSource() == btnLab3) {
                EventQueue.invokeLater(() -> {
                    try {
                        TranslatorConsoleApplication frame = new TranslatorConsoleApplication();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            setVisible(true);
        });
        btnLab3.setBounds(27, 240, 250, 100);
        contentPane.add(btnLab3);

        JButton btnLab4 = new JButton("Lab 4");
        btnLab4.addActionListener(arg0 -> {
            if(arg0.getSource() == btnLab4) {
                EventQueue.invokeLater(() -> {
                    try {
                        lab4.Main frame = new lab4.Main();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            setVisible(true);
        });
        btnLab4.setBounds(27, 350, 250, 100);
        contentPane.add(btnLab4);

        JButton btnLab5 = new JButton("Lab 5");
        btnLab5.addActionListener(arg0 -> {
            if(arg0.getSource() == btnLab5) {
                EventQueue.invokeLater(() -> {
                    try {
                        lab5.Main frame = new lab5.Main();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            setVisible(true);
        });
        btnLab5.setBounds(27, 460, 250, 100);
        contentPane.add(btnLab5);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(e -> System.exit(0));
        btnExit.setBounds(202, 570, 75, 30);
        contentPane.add(btnExit);
    }

    public static void main(String args[]){
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
