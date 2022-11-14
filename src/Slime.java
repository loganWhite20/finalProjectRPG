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
    public Slime(int health, int mana, int speed, int armor, String name,Weapons w) {
        super(health, mana, speed, armor, w,name);
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
     * @param dieRoll - die roll which determines how much damage is dealt
     * @return - the amount of damage dealt by the attack
     */
    @Override
    int attack(int dieRoll) {
        if(dieRoll<20){
            return 0;
        } else if(dieRoll <15){
            return 0;
        } else if(dieRoll<10 && dieRoll>4){
            return 0;
        } else {
            return 0;
        }
    }

    /**
     * This method is the special attack for the Slime which deals more than the basic attack
     * @param dieRoll - the die roll which determines the strength of the attack
     * @return - the damage dealt by the special attack
     */
    int specialAttack(int dieRoll){ return -1;}

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
