public class Warrior extends Enemies {
    public Warrior(int health, int mana, int speed, int armor, String name,Weapons w) {
        super(health, mana, speed, armor, w,name);
    }
    public int attack (int dieRoll){ return -1; }
    public boolean block (int dieRoll){ return false; }
}
