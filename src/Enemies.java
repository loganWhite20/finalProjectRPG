/**
 * Class for enemy players
 */
public class Enemies extends Players {
    private String enemyType;
    private String returnType;
    /**
     * Constructor for enemy players
     * @param health - amount of health to begin with
     * @param mana - amount of mana to begin with
     * @param speed - amount of speed to begin with
     * @param armor - strength of armor to begin with
     * @param w - weapon the enemy begins with
     * @param name - name of the enemy
     */
    public Enemies (int health,int mana,int speed,int armor,String name,Weapons w,String t){
        super(health,mana,speed,armor,name,w);
        enemyType = t;
        returnType = "Enemy";
    }
    /**
     * Copy constructor for enemy characters
     * @param e - the enemy which you are copying
     */
    public Enemies(Enemies e){
        super(e);
        this.enemyType = e.getEnemyType();
        this.returnType = e.returnType;
    }

    /**
     * Attack method for enemy characters
     * @return - the amount of damage dealt
     */
    @Override
    int attack() {
        return 0;
    }
    public int specialAttack() {
        return 0;
    }

    /**
     * Returns is the enemy is dead or not
     * @return - returns the returnType which will either be the type of enemy or "Dead"
     */
    @Override
    String returnType() {
        return returnType;
    }

    /**
     * Sets the returnType of an enemy to "Dead"
     */
    @Override
    public void deadReturnType() {
        returnType = "Dead";
    }


    /**
     * Returns the type of enemy this method is called on
     * @return - the enemy type
     */
    //@Override
    public String getEnemyType() {return enemyType;}

    /**
     * Returns critical damage on the base or special attack if this method is called
     * @param dmg - the current damage, either from base or special attack
     * @return - the amount of damage dealt
     */
    public int criticalHit(int dmg) {
        int totalDmg = ((int)((double)dmg * 1.5));
        return totalDmg;
    }
}

