/**
 * Parent class for all the types of players in the game
 */
public abstract class Players {
    private String name;
    private int playerHealth;
    private int playerMana;
    private int maxHealth;
    private int maxMana;
    private int speed;
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
    public Players (int health,int mana,int speed,int armor,String name,Weapons w){
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
        this.name = p.name;
        this.speed = p.speed;
        this.armorClass = p.armorClass;
    }

    /**
     * Subtracts from the player's health the amount of damage taken
     * @param amountOfDamage - the amount of damage a player is taking
     */
    public void takeDamage(int amountOfDamage){//need to figure out what to do when the players health equals zero
        playerHealth -= amountOfDamage;
    }

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
     * Returns the users current weapon
     * @return - the users Weapon
     */
    public Weapons returnWeapon(){
        return this.myWeapon;
    }

    /**
     * Method for the base attack of a player
     * @return - the amount of damage dealt
     */
    abstract int attack();

    abstract String returnType();

    public String getName() {
        return name;
    }
    public int getMaxMana() {
        return maxMana;
    }
    public int getSpeed() {
        return speed;
    }
    public int getArmorClass() {
        return armorClass;
    }
    public abstract int criticalHit(int diceHit);
    public abstract int specialAttack();
}