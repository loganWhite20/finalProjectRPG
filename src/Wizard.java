/**
 * Class for the enemy character Wizard
 */
public class Wizard extends Enemies {
    /**
     * Constructor for the Wizard class
     * @param health - beginning health
     * @param mana - beginning mana
     * @param speed - beginning speed
     * @param armor - beginning armor strength
     * @param name - name of the Wizard
     * @param w - beginning weapon
     */
    public Wizard(int health, int mana, int speed, int armor, String name,Weapons w) {
        super(health, mana, speed, armor,w,name);
    }

    /**
     * Fireball attack for the wizard
     * @param dieRoll - the die roll which determines how much damage is dealt
     * @return - the amount of damage dealt
     */
    public int fireball(int dieRoll){return -1;}

    /**
     * Lightning attack for the Wizard
     * @param dieRoll - the die roll which determines how much damage is dealt
     * @return - the amount of damage dealt
     */
    public int lighting(int dieRoll){return -1;}
}
