/**
 * This is the class for the hero character.
 */
public class Slime extends Players{
    private String type = "Slime";
    /**
     * This is the Constructor for the Slime character
     * @param health - the amount of health the Slime will start with
     * @param mana - the amount of mana the Slime will start with
     * @param speed - the amount of speed the Slime will start with
     * @param armor - the strength of armor the Slime will start with
     * @param name - the name of the Slime
     * @param w - the type of weapon the character has
     */
    public Slime(int health, int mana, int speed, int armor, String name, Weapons w) {
        super(health, mana, speed, armor, name, w);
//        type = "Slime";
    }

    /**
     * Copy constructor for Slime class
     * @param other - Slime player to copy from
     */
    public Slime(Slime other) {
        super(other.getMaxHealth(),other.getMaxMana(),other.getSpeed(),other.getArmorClass(),other.getName(),new Weapons(other.returnWeapon()));
    }

    /**
     * This method restores 5% of the players maxHealth
     */
    public int healthToRestore() {
        int max = getMaxHealth();
        return (int) (max*0.05);
    }

    /**
     * This method is the basic attack for the Slime
     * @return - the amount of damage dealt by the attack
     */
    @Override
    int attack() {
        return this.returnWeapon().rollForDamage() + returnWeapon().getWeaponStrength();
    }

    /**
     * Returns the players type
     * @return - Either the player's type or if they are dead
     */
    @Override
    public String returnType() {
        return type;
    }

    /**
     * Changes player's type to "Dead"
     */
    @Override
    public void deadReturnType() {
        type = "Dead";
    }

    /**
     * Critical hit method for Slime base or special attack
     * @param dmg - damage from base or special attack
     * @return - the amount of damage dealt by the critical hit
     */
    @Override
    public int criticalHit(int dmg) {
        int totalDmg = (int)(dmg * 1.5);
        return totalDmg;
    }

    /**
     * This method is the special attack for the Slime which deals more than the basic attack
     * @return - the damage dealt by the special attack
     */
    public int specialAttack(){ return (int) ((this.returnWeapon().rollForDamage())*1.5 + returnWeapon().getWeaponStrength()); }

    /**
     * This method overrides the equals method for the Slime class
     * @param object - takes in an object to compare the current Slime class to
     * @return - returns whether the two Slime classes are equal
     */
    @Override
    public boolean equals(Object object){
        return super.equals(object);
    }
}
