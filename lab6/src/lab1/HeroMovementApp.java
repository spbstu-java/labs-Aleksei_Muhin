package lab1;

// Интерфейс для различных стратегий перемещения героя
interface MovementStrategy {
    String move();
}

// Конкретная стратегия: Перемещение пешком
class WalkStrategy implements MovementStrategy {
    @Override
    public String move() {
        return "Герой пошуршал на своих двоих";
    }
}

// Конкретная стратегия: Перемещение на лошади
class HorseRideStrategy implements MovementStrategy {
    @Override
    public String move() {
        return "Герою стало лень идти он украл лошадь у цыган и поскакал";
    }
}

// Конкретная стратегия: Полет
class FlyStrategy implements MovementStrategy {
    @Override
    public String move() {
        return "Герою стало мало лошади поэтому он спер вертолет на котором полетл в светлое будущие";
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

