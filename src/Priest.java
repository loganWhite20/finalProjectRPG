public class Priest extends Enemies {
    public Priest(int health, int mana, int speed, int armor, String typeOfWeapon, int strengthOfWeapon,String name,int numSidesDice) {
        super(health, mana, speed, armor, typeOfWeapon, strengthOfWeapon,name,numSidesDice);
    }
    public int indHeal(int dieRoll){ return -1; }
    public int indMana(int dieRoll){ return -1; }
    public int groupHeal(int dieRoll){ return -1; }
    public int groupMana(int dieRoll){ return -1; }
}
