public class Archer extends Enemies {
    public Archer (int health,int mana,int speed,int armor,String typeOfWeapon,int strengthOfWeapon,String name,int numSidesDice){
        super(health,mana,speed,armor,typeOfWeapon,strengthOfWeapon,name,numSidesDice);
    }
    public int stab (int dieRoll){ return -1; }
    public int shoot (int dieRoll){ return -1; }
}
