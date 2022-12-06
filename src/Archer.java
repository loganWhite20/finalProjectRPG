/**
 *This class is for the enemy character Archer who has a long rang attack and a weak close-range attack
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
     * @param t - the type of enemy
     */
    public Archer(int health, int mana, int speed, int armor, String name,Weapons w,String t) {
        super(health, mana, speed, armor, name, w,t);
    }

    /**
     * This method is for the short range, low strength melee attach
     * @return - the amount of damage dealt
     */
    public int stab (){
        int damage = this.returnWeapon().rollForDamage() + returnWeapon().getWeaponStrength();
        if (damage >= 2) {//takes two damage off the attack if it's equal to 2 or more
            damage = damage - 2;
        }
        return damage;
    }

    /**
     * This method is for the long range attack of the Archer. Multiplies base attack by 1.8
     * @return - the amount of damage dealt
     */
    public int shoot (){ return (int) ((this.returnWeapon().rollForDamage())*1.8 + returnWeapon().getWeaponStrength()); }
}
