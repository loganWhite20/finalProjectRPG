import java.util.Random;

/**
 * This class creates a Die object that has a number of sides
 * @author Colton Middaugh
 */
public class Dice {
    private int sides;

    //constructor
    public Dice(int sides){

        this.sides = sides;
    }

    //copy constructor
    public Dice(Dice d) {
        this.sides = d.sides;
    }

    /**
     * "Rolls a die" - gets a random number from the amount of sides the die has
     * @return int random number from sides
     */
    public int rollDie(){
        Random randomNum = new Random();
        return randomNum.nextInt(sides);
    }
}
