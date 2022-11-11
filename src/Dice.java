import java.util.Random;

public class Dice {
    private int sides;

    public Dice(int sides){
        this.sides = sides;
    }

    public int rollDie(){
        Random randomNum = new Random();
        return randomNum.nextInt(sides);
    }
}
