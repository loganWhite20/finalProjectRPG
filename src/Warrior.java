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
     * @param t - the type of enemy
     */
    public Warrior(int health, int mana, int speed, int armor, String name,Weapons w,String t) {
        super(health, mana, speed, armor, name, w,t);
    }

    /**
     * This is the basic attack of the warrior.
     * @return - returns the amount of damage dealt
     */
    int attack (){ return this.returnWeapon().rollForDamage(); }

    /**
     * This is the special attack for the warrior. Multiplies base attack by 1.4
     * @return - returns the amount of damage dealt
     */
    public int specialAttack (){
        return (int) (attack()*1.4);
    }
}
