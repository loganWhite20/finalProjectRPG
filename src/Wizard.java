public class Wizard extends Enemies {
    public Wizard(int health, int mana, int speed, int armor, String typeOfWeapon, int strengthOfWeapon) {
        super(health, mana, speed, armor, typeOfWeapon, strengthOfWeapon);
    }
    public int fireball(int dieRoll){return -1;}
    public int lighting(int dieRoll){return -1;}
}
