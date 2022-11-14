public class Thief extends Enemies{
    public Thief(int health, int mana, int speed, int armor, String name,Weapons w) {
        super(health, mana, speed, armor, w,name);
    }
    public int stab (int dieRoll){ return -1; }
    public boolean sneak (int dieRoll){ return false; }

}