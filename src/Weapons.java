/**
 * This method creates a weapon object that players will use in combat.
 * The weapons have a name, strength, and dmg die to determine damage in a fight.
 */
public class Weapons {
    private String weaponType;
    private int weaponStrength;
    private Dice dmgDie;

    // Constructor
    public Weapons (String type,int strength,int numSidesForDice){
        weaponType = type;
        weaponStrength = strength;
        dmgDie = new Dice(numSidesForDice);
    }

    // Copy Constructor
    public Weapons (Weapons w) {
        this.weaponType = w.weaponType;
        this.weaponStrength = w.weaponStrength;
        this.dmgDie = new Dice(w.dmgDie);
    }

    // gets weapon type.
    public String getWeaponType(){
        return weaponType;
    }

    // gets weapon strength
    public int getWeaponStrength(){
        return weaponStrength;
    }
}
