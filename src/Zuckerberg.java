public class Zuckerberg extends Wizard {
    public Zuckerberg(int health, int mana, int speed, int armor, String name,Weapons w) {
        super(health, mana, speed, armor,name,w);
    }
    public int heal(int dieRoll){return -1;}
    public int digitalFury(int dieRoll){return -1;}
}
