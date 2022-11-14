/**
 * This class is for the warrior who is the base enemy. The warrior has two moves, an attack and a block
 */
public class Warrior extends Enemies {
    /**
     * This is the Constructor for the Warrior
     * @param health - the amount of health the Warrior will start with
     * @param mana - the amount of mana the Warrior will start with
     * @param speed - the amount of speed the Warrior will start with
     * @param armor - the strength of armor the Warrior will start with
     * @param name - the name of the Warrior
     * @param w - the type of weapon the character has
     */
    public Warrior(int health, int mana, int speed, int armor, String name,Weapons w) {
        super(health, mana, speed, armor, w,name);
    }

    /**
     * This is the basic attack of the warrior
     * @param dieRoll - the die roll which determines whether the attack will hit or not
     * @return - returns the amount of damage dealt
     */
    public int attack (int dieRoll){ return -1; }

    /**
     * This method serves as a way for the Warrior to block an attack from the hero.
     * @param dieRoll - the die roll which determines whether the attack will hit or not
     * @return - returns the amount of damage dealt
     */
    public boolean block (int dieRoll){ return false; }
}
