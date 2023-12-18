package lab1;

// Класс для представления героя
public class Hero {
    private MovementStrategy movementStrategy;

    public void setMovementStrategy(MovementStrategy strategy) {
        this.movementStrategy = strategy;
    }

    public String move() {
        String result = "";
        if (movementStrategy != null) {
            result = movementStrategy.move();
        } else {
            result = "Герой не может двигаться";
        }
        return result;
    }

}
