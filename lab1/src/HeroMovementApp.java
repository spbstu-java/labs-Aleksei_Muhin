import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Интерфейс для различных стратегий перемещения героя
interface MovementStrategy {
    void move();
}

// Конкретная стратегия: Перемещение пешком
class WalkStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Герой пошуршал на своих двоих");
    }
}

// Конкретная стратегия: Перемещение на лошади
class HorseRideStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Герою стало лень идти он украл лошадь у цыган и поскакал");
    }
}

// Конкретная стратегия: Полет
class FlyStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Герою стало мало лошади поэтому он спер вертолет на котором полетл в светлое будущие");
    }
}

public class HeroMovementApp {
    public static void main(String[] args) {
        // Создаем героя
        Hero hero = new Hero();

        // Создаем графический интерфейс
        SwingMovementUI movementUI = new SwingMovementUI(hero);
        movementUI.createAndShowUI();
    }
}

// Класс для представления героя
class Hero {
    private MovementStrategy movementStrategy;

    public void setMovementStrategy(MovementStrategy strategy) {
        this.movementStrategy = strategy;
    }

    public void move() {
        if (movementStrategy != null) {
            movementStrategy.move();
        } else {
            System.out.println("Герой не может двигаться");
        }
    }
}

// Простой графический интерфейс для выбора стратегии перемещения
class SwingMovementUI {
    private Hero hero;

    public SwingMovementUI(Hero hero) {
        this.hero = hero;
    }

    public void createAndShowUI() {
        JFrame frame = new JFrame("Hero Movement");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JComboBox<String> strategyComboBox = new JComboBox<>(new String[]{"Пешком", "На лошади", "Лететь"});
        JButton moveButton = new JButton("Двигаться");

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
                hero.move();
            }
        });

        frame.add(new JLabel("Выберите способ перемещения:"));
        frame.add(strategyComboBox);
        frame.add(moveButton);

        frame.pack();
        frame.setVisible(true);
    }
}
