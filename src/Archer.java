/**
 *This class is for the enemy character Archer who has a long rang attack and a close range attack
 */
public class Archer extends Enemies {
    /**
     * Constructor for the archer
     * @param health - the amount of health the Archer will start with
     * @param mana - the amount of mana the Archer will start with
     * @param speed - the amount of speed the Archer will start with
     * @param armor - the strength of armor the Archer will start with
     * @param name - the name of the Archer
     * @param w - the type of weapon the character has
     */
    public Archer(int health, int mana, int speed, int armor, String name,Weapons w) {
        super(health, mana, speed, armor, w,name);
    }

    /**
     * This method is for the short range, low strength melee attach
     * @param dieRoll - the roll of the die which will determine if the attack hits
     * @return - the amount of damage dealt
     */
    public int stab (int dieRoll){ return -1; }

    /**
     * This method is for the long range attack of the Archer
     * @param dieRoll - the roll of the die which will determine if the attack hits
     * @return - the amount of damage dealt
     */
    public int shoot (int dieRoll){ return -1; }
}
