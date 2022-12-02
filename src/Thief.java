public class Thief extends Enemies{
    public Thief(int health, int mana, int speed, int armor, String name,Weapons w,String t) {
        super(health, mana, speed, armor, name, w,t);
    }
    public int stab (){ return this.returnWeapon().rollForDamage(); }
    public boolean sneak (int dieRoll){ return false; }

}