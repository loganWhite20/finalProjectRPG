import java.util.Random;

/**
 * This class is meant to simulate the roll of dice.
 */
public class Dice {
    private int sides;

    // Constructor
    public Dice(int sides){
        this.sides = sides;
    }

    // Copy Constructor
    public Dice(Dice d) {
        this.sides = d.sides;
    }

    /**
     * This method is what rolls the dice itself.
     * @return an integer value of the die rolled.
     */
    public int rollDie(){
        Random randomNum = new Random();
        return randomNum.nextInt(sides)+1;
    }
}
