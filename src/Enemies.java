public class Enemies extends Players {
    public Enemies (int health,int mana,int speed,int armor,String typeOfWeapon,int strengthOfWeapon,String name,int numSidesDice){
        super(health,mana,speed,armor,typeOfWeapon,strengthOfWeapon,name,numSidesDice);
    }
    @Override
    void restoreHealth(int dieRoll) {    }
    @Override
    int attack(int dieRoll) {
        return 0;
    }
    public Enemies(Enemies e){
        super(e);
    }
}

