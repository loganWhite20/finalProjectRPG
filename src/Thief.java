public class Thief extends Enemies{
    public Thief(int health, int mana, int speed, int armor, String typeOfWeapon, int strengthOfWeapon) {
        super(health, mana, speed, armor, typeOfWeapon, strengthOfWeapon);
    }
    public int stab (int dieRoll){ return -1; }
    public boolean sneak (int dieRoll){ return false; }

}