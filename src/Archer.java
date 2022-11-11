public class Archer extends Enemies {
    public Archer (int health,int mana,int speed,int armor,String typeOfWeapon,int strengthOfWeapon){
        super(health,mana,speed,armor,typeOfWeapon,strengthOfWeapon);
    }
    public int stab (int dieRoll){ return -1; }
    public int shoot (int dieRoll){ return -1; }
}
