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
     * @return - the amount of damage dealt
     */
    @Override
    int attack() {
        return 0;
    }

    @Override
    String returnType() {
        return "Enemies";
    }

    public int criticalHit(int diceRoll) {
        int damage;
        if(diceRoll>=15){
            damage = attack()*2;
        }
        else {
            damage = attack();
        }
        return damage;
    }

    /**
     * Copy constructor for enemy characters
     * @param e - the enemy which you are copying
     */
    public Enemies(Enemies e){
        super(e);
    }
}

