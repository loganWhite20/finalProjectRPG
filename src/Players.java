public abstract class Players {
    private String name;
    private int playerHealth;
    private int playerMana;
    private int maxHealth;
    private int maxMana;
    private int speed;
    private int armorClass;
    private Weapons myWeapon;
    public Players (int health,int mana,int speed,int armor,String typeOfWeapon,int strengthOfWeapon,String name){
        playerHealth = health;
        playerMana = mana;
        maxHealth = health;
        maxMana = mana;
        this.speed = speed;
        armorClass = armor;
        myWeapon = new Weapons(typeOfWeapon,strengthOfWeapon);
        this.name = name;
    }

    public void updateHealth(int value){
        playerHealth += value;
    }

    public int getPlayerHealth(){
        return playerHealth;
    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public Players(Players p){//Copy constructor
        this.playerHealth = p.playerHealth;
        this.playerMana = p.playerMana;
        this.maxHealth = p.maxHealth;
        this.maxMana = p.maxMana;
        this.speed = p.speed;
        this.armorClass = p.armorClass;
    }
    public void takeDamage(int amountOfDamage){//need to figure out what to do when the players health equals zero
        playerHealth = playerHealth-amountOfDamage;
    }

    abstract void restoreHealth(int dieRoll);

    //public void criticalChance(){}

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

    abstract int attack(int dieRoll);

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