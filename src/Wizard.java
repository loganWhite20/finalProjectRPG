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
    public Wizard(int health, int mana, int speed, int armor, String name,Weapons w,String t) {
        super(health, mana, speed, armor, name, w,t);
    }

    /**
     * Fireball attack for the wizard
     * * @return - the amount of damage dealt
     */
    public int fireball(){return this.returnWeapon().rollForDamage();}

    /**
     * Lightning attack for the Wizard
     * @return - the amount of damage dealt
     */
    public int lighting(){return (int) (fireball()*1.6);}
}
