package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Простой графический интерфейс для выбора стратегии перемещения
public class SwingMovementUI {
    private Hero hero;
    private String result;

    public SwingMovementUI(Hero hero) {
        this.hero = hero;
    }

    public void createAndShowUI() {

        JFrame frame = new JFrame("Hero Movement");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JComboBox<String> strategyComboBox = new JComboBox<>(new String[]{"Пешком", "На лошади", "Лететь"});
        JButton moveButton = new JButton("Двигаться");
        JTextField answer = new JTextField();

        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedStrategy = (String) strategyComboBox.getSelectedItem();
                switch (selectedStrategy) {
                    case "Пешком":
                        hero.setMovementStrategy(new WalkStrategy());
                        break;
                    case "На лошади":
                        hero.setMovementStrategy(new HorseRideStrategy());
                        break;
                    case "Лететь":
                        hero.setMovementStrategy(new FlyStrategy());
                        break;
                }
                result = hero.move();
                answer.setText(result);
            }
        });


        frame.add(new JLabel("Выберите способ перемещения:"));
        frame.add(strategyComboBox);
        frame.add(moveButton);

        answer.setBounds(20, 60, 200, 200);
        answer.setColumns(100);
        answer.setEditable(false);
        frame.add(answer);

        frame.pack();
        frame.setVisible(true);

    }
}
