public class Giant extends Enemies {
    public Giant(int health, int mana, int speed, int armor, String typeOfWeapon, int strengthOfWeapon) {
        super(health, mana, speed, armor, typeOfWeapon, strengthOfWeapon);
    }
    public int stomp (int dieRoll){ return -1; }
    public int bash (int dieRoll){ return -1; }
}
