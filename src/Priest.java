import java.util.Random;

public class Priest extends Enemies {
    public Priest(int health, int mana, int speed, int armor, String name,Weapons w,String t) {
        super(health, mana, speed, armor, name, w,t);
    }
    public int indHeal(){
        Random dieRoll = new Random();
        return dieRoll.nextInt(11) + 3;
    }
    public int indMana(int dieRoll){ return -1; }
    public int groupHeal(){
        Random dieRoll = new Random();
        return dieRoll.nextInt(10) + 1;
    }
    public int groupMana(int dieRoll){ return -1; }
}
