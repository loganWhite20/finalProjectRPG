public class Warrior extends Enemies {
    public Warrior(int health, int mana, int speed, int armor, String typeOfWeapon, int strengthOfWeapon) {
        super(health, mana, speed, armor, typeOfWeapon, strengthOfWeapon);
    }
    public int attack (int dieRoll){ return -1; }
    public boolean block (int dieRoll){ return false; }
}
