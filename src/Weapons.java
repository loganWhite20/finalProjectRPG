/**
 * The weapons class allows the user to create any type of weapon of any type of weapon strength
 * Then these weapons are used by the individual characters in the game
 */
public class Weapons {
    private String weaponType;
    private int weaponStrength;
    private Dice dmgDie;
    private int dmgModifier;

    /**
     * This si the constructor for the weapons class
     * @param type - type of weapon, for example "sword"
     * @param strength - how much max damage the weapon can deal
     * @param numSidesForDice - how many sides the dice will have which is used to determine how much damage
     *                        the weapon will deal
     */
    public Weapons (String type,int strength,int numSidesForDice){
        weaponType = type;
        weaponStrength = strength;
        dmgDie = new Dice(numSidesForDice);
    }

    /**
     * Copy constructor for the weapons class
     * @param w - takes in an already existing weapon and creates a copy
     */
    public Weapons (Weapons w) {
        this.weaponType = w.weaponType;
        this.weaponStrength = w.weaponStrength;
        this.dmgDie = new Dice(w.dmgDie);
    }

    /**
     * Gets the type of an already existing weapon
     * @return - the type of an already existing weapon
     */
    public String getWeaponType(){
        return weaponType;
    }
    /**
     * Gets the strength of an already existing weapon
     * @return - the strength of an already existing weapon
     */
    public int getWeaponStrength(){
        return weaponStrength;
    }

    /**
     * This method rolls for dmg of a weapon.
     * @return - int value for damage dealt.
     */
    public int rollForDamage() {
        int dmg = dmgDie.rollDie();
        dmg += weaponStrength;
        return dmg;
    }
}
