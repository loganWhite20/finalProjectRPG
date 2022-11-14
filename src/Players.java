/**
 * Parent class for all the types of players in the game
 */
public abstract class Players {
    private String name;
    private int playerHealth;
    private int playerMana;
    private int maxHealth;
    private int maxMana;
    protected int speed;
    private int armorClass;
    private Weapons myWeapon;

    /**
     * Constructor for a player
     * @param health - the amount of health the player starts with
     * @param mana - the amount of mana the player stars with
     * @param speed - the amount of speed the player starts with
     * @param armor - the strength of the armor the player starts with
     * @param w - the weapon a player starts with
     * @param name - the name of the player
     */
    public Players (int health,int mana,int speed,int armor,Weapons w,String name){
        playerHealth = health;
        playerMana = mana;
        maxHealth = health;
        maxMana = mana;
        this.speed = speed;
        armorClass = armor;
        myWeapon = new Weapons(w);
        this.name = name;
    }

    /**
     * Adds to a players health
     * @param value - the amount of health to add or subtract from the current players health
     */
    public void addHealth(int value){
        playerHealth += value;
    }

    /**
     * Gets the players current health
     * @return - the players current health
     */
    public int getPlayerHealth(){
        return playerHealth;
    }

    /**
     * Gets a players max health
     * @return - players max health
     */
    public int getMaxHealth(){
        return maxHealth;
    }

    /**
     * Copy constructor for the players class
     * @param p - the player to create a copy from
     */
    public Players(Players p){//Copy constructor
        this.playerHealth = p.playerHealth;
        this.playerMana = p.playerMana;
        this.maxHealth = p.maxHealth;
        this.maxMana = p.maxMana;
        this.speed = p.speed;
        this.armorClass = p.armorClass;
    }

    /**
     * Subtracts from the player's health the amount of damage taken
     * @param amountOfDamage - the amount of damage a player is taking
     */
    public void takeDamage(int amountOfDamage){//need to figure out what to do when the players health equals zero
        playerHealth = playerHealth-amountOfDamage;
    }

    /**
     * Abstract method that allows a character to restore health
     * @param dieRoll - the die roll which determines how much health will be restored
     */
    abstract void restoreHealth(int dieRoll);

    /**
     * Equals method for comparing to players to see if they are equal
     * @param c - the object you are trying to compare
     * @return - whether the object in the parameter and the current player are equal
     */
    public boolean equals(Object c){
        if (this==c){
            return true;
        }
        if(!(c instanceof Players)){
            return false;
        }
        Players other = (Players) c;
        return ((this.playerHealth==other.playerHealth) &&
                (this.playerMana==other.playerMana) &&
                (this.armorClass==other.armorClass) &&
                (this.speed==other.speed) &&
                (this.maxHealth==other.maxHealth) &&
                (this.maxMana==other.maxMana));
    }

    /**
     * Method for the base attack of a player
     * @param dieRoll - die roll which determines how much damage the attack deals
     * @return - the amount of damage dealt
     */
    abstract int attack(int dieRoll);

    /**
     * Determines whether a player makes a critical hit when attacking another player
     * @param diceRoll - the dice roll which determines if a critical hit is achieved
     * @return - the amount of damage dealt
     */
    public int criticalHit(int diceRoll){
        int attackVal;
        if(diceRoll==20){
            attackVal = (attack(diceRoll))*2;
        } else {
            attackVal = attack(diceRoll);
        }
        return attackVal;
    }


}