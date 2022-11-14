public class Archer extends Enemies {
    public Archer(int health, int mana, int speed, int armor, String name,Weapons w) {
        super(health, mana, speed, armor, w,name);
    }
    public int stab (int dieRoll){ return -1; }
    public int shoot (int dieRoll){ return -1; }
}
