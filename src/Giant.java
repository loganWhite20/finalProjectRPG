/**
 * Class for enemy character Giant
 */
public class Giant extends Enemies {
    /**
     * Constructor for Giant class
     * @param health - beginning health
     * @param mana - beginning mana
     * @param speed - Giant's speed
     * @param armor - Giant's armor strength
     * @param name - name of Giant
     * @param w - beginning weapon
     * @param t - type of enemy
     */
    public Giant(int health, int mana, int speed, int armor, String name,Weapons w,String t) {
        super(health, mana, speed, armor, name, w,t);
    }

    /**
     * Base attack for Giant
     * @return - amount of damage dealt
     */
    public int stomp (){ return this.returnWeapon().rollForDamage()  + returnWeapon().getWeaponStrength(); }

    /**
     * Special attack for Giant. Multiplies the stomp attack by 2
     * @return - the amount of damage dealt
     */
    public int bash (){ return (int) (this.returnWeapon().rollForDamage()*2 + returnWeapon().getWeaponStrength()); }
}
