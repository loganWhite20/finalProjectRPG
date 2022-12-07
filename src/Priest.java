import java.util.Random;

/**
 * this class is an enemy who specializes in healing allies.
 */
public class Priest extends Enemies {
    public Priest(int health, int mana, int speed, int armor, String name,Weapons w,String t) {
        super(health, mana, speed, armor, name, w,t);
    }
    // returns value to heal a target.
    public int indHeal(){
        Random dieRoll = new Random();
        return dieRoll.nextInt(11) + 3;
    }
    public int indMana(int dieRoll){ return -1; }
    // not used
    public int groupHeal(){
        Random dieRoll = new Random();
        return dieRoll.nextInt(10) + 1;
    }
    // not used
    public int groupMana(int dieRoll){ return -1; }
}
