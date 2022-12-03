/**
 * Class for enemy character Zuckerberg
 */
public class Zuckerberg extends Wizard {
    /**
     * Constructor for the Zuckerberg class
     * @param health - beginning health
     * @param mana - beginning mana
     * @param speed - beginning speed
     * @param armor - beginning armor strength
     * @param name - name of the Zuckerberg
     * @param w - beginning weapon
     * @param t - type of enemy
    */
    public Zuckerberg(int health, int mana, int speed, int armor, String name,Weapons w,String t) {
        super(health, mana, speed, armor, name,w,t);
    }

    /**
     * base attack for Zuckerberg
     * @return - the amount of damage dealt
     */
    public int roboticStare(){return this.returnWeapon().rollForDamage();}

    /**
     * The special attack for Zuckerberg. Multiplies base attack by 2.2
     * @return - the amount of damage dealt
     */
    public int digitalFury(){return (int) (roboticStare()*2.2);}
}
