import java.util.Random;

/**
 * Player class for enemy character, Priest
 */
public class Priest extends Enemies {
    /**
     * Constructor for Priest class
     * @param health - beginning and max health
     * @param mana - beginning and max mana
     * @param speed - Priest's speed
     * @param armor - Priest's armor class
     * @param name - Priest's name
     * @param w - Priest's weapon
     * @param t - Priest's player type
     */
    public Priest(int health, int mana, int speed, int armor, String name,Weapons w,String t) {
        super(health, mana, speed, armor, name, w,t);
    }

    /**
     * Method which returns the healing for an individual character
     * @return - the amount of health points to be received
     */
    public int indHeal(){
        Random dieRoll = new Random();
        return dieRoll.nextInt(11) + 3;
    }

    /**
     * Method which returns the amount mana to be restored for an individual character
     * @return - the amount of mana to be received
     */
    public int indMana(int dieRoll){ return -1; }
}
