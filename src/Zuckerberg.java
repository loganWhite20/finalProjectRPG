public class Zuckerberg extends Wizard {
    public Zuckerberg(int health, int mana, int speed, int armor, String typeOfWeapon, int strengthOfWeapon,String name) {
        super(health, mana, speed, armor, typeOfWeapon, strengthOfWeapon,name);
    }
    public int heal(int dieRoll){return -1;}
    public int digitalFury(int dieRoll){return -1;}
}
