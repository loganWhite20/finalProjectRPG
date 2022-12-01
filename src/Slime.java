/**
 * This is the class for the hero character.
 */
public class Slime extends Players{
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
    }
    public Slime(Slime other) {
        super(other.getMaxHealth(),other.getMaxMana(),other.getSpeed(),other.getArmorClass(),other.getName(),new Weapons(other.returnWeapon()));
    }

    /**
     * This method determines if or how much the Slime character will restore health.
     * The amount of health that is restored is based off of a die roll
     * @param dieRoll - the die roll value which determines how much health is restored
     */
    void restoreHealth(int dieRoll) {
        if(dieRoll<20){
            int max = getMaxHealth();
            int add = (int) (max*0.15);
            addHealth(add);
        } else if(dieRoll <15){
            int max = getMaxHealth();
            int add = (int) (max*0.1);
            addHealth(add);
        } else if(dieRoll<10 && dieRoll>4){
            int max = getMaxHealth();
            int add = (int) (max*0.05);
            addHealth(add);
        }
    }

    /**
     * This method is the basic attack for the Slime
     * @return - the amount of damage dealt by the attack
     */
    @Override
    int attack() {
        return this.returnWeapon().rollForDamage();
    }

    @Override
    public String returnType() {
        return "Slime";
    }

    //TODO fix
    @Override
    public int criticalHit(int diceRoll) {
        return 1;
    }
    public int criticalHit(int diceRoll, int typeOfAttack) {
        int damage;
        if(diceRoll>=15 && typeOfAttack==1){
            damage = attack()*2;
        }
        else if(diceRoll>=15 && typeOfAttack==2){
            damage = specialAttack()*2;
        }
        else if (diceRoll<15 && typeOfAttack==2){
            damage = specialAttack();
        }
        else {
            damage = attack();
        }
        return damage;
    }

    /**
     * This method is the special attack for the Slime which deals more than the basic attack
     * @return - the damage dealt by the special attack
     */
    public int specialAttack(){ return (int) ((this.returnWeapon().rollForDamage())*1.5); }

    public String getEnemyType() {
        return null;
    }

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
