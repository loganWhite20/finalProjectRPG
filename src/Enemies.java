/**
 * Class for enemy players
 */
public class Enemies extends Players {
    /**
     * Constructor for enemy players
     * @param health - amount of health to begin with
     * @param mana - amount of mana to begin with
     * @param speed - amount of speed to begin with
     * @param armor - strength of armor to begin with
     * @param w - weapon the enemy begins with
     * @param name - name of the enemy
     */
    public Enemies (int health,int mana,int speed,int armor,Weapons w,String name){
        super(health,mana,speed,armor,w,name);
    }

    /**
     * Attack method for enemy characters
     * @param dieRoll - die roll which determines how much damage the attack deals
     * @return - the amount of damage dealt
     */
    @Override
    int attack(int dieRoll) {
        return 0;
    }

    /**
     * Copy constructor for enemy characters
     * @param e - the enemy which you are copying
     */
    public Enemies(Enemies e){
        super(e);
    }
}

