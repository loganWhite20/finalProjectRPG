/**
 * Class for enemy character Thief
 */
public class Thief extends Enemies{
    /**
     * Constructor for the Thief class
     * @param health - beginning health
     * @param mana - beginning mana
     * @param speed - enemy speed
     * @param armor - enemy armor strength
     * @param name - name of Thief
     * @param w - beginning weapon
     * @param t - type of enemy
     */
    public Thief(int health, int mana, int speed, int armor, String name,Weapons w,String t) {
        super(health, mana, speed, armor, name, w,t);
    }

    /**
     * Base attack for Thief
     * @return - amount of damage dealt
     */
    public int stab (){ return this.returnWeapon().rollForDamage() + returnWeapon().getWeaponStrength(); }

    /**
     * Special attack for Thief. Multiplies base attack by 1.2
     * @return
     */
    public int sneakAttack (){ return (int) (stab()*1.2 + returnWeapon().getWeaponStrength()); }

}