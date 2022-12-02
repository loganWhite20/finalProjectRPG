public class Zuckerberg extends Wizard {
    public Zuckerberg(int health, int mana, int speed, int armor, String name,Weapons w,String t) {
        super(health, mana, speed, armor, name,w,t);
    }
    public int heal(int dieRoll){return -1;}
    public int digitalFury(){return this.returnWeapon().rollForDamage();}
}
