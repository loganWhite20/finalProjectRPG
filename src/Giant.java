public class Giant extends Enemies {
    public Giant(int health, int mana, int speed, int armor, String name,Weapons w,String t) {
        super(health, mana, speed, armor, name, w,t);
    }
    public int stomp (int dieRoll){ return -1; }
    public int bash (int dieRoll){ return -1; }
}
