public class Zuckerberg extends Wizard {
    public Zuckerberg(int health, int mana, int speed, int armor, String name,Weapons w,String t) {
        super(health, mana, speed, armor, name,w,t);
    }
    public int roboticStare(){return this.returnWeapon().rollForDamage();}
    public int digitalFury(){return (int) (roboticStare()*2.2);}
}
