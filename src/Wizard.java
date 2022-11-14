public class Wizard extends Enemies {
    public Wizard(int health, int mana, int speed, int armor, String name,Weapons w) {
        super(health, mana, speed, armor,w,name);
    }
    public int fireball(int dieRoll){return -1;}
    public int lighting(int dieRoll){return -1;}
}
