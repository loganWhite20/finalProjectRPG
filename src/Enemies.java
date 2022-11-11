public class Enemies extends Players {
    public Enemies (int health,int mana,int speed,int armor,String typeOfWeapon,int strengthOfWeapon){
        super(health,mana,speed,armor,typeOfWeapon,strengthOfWeapon);
    }
    @Override
    void restoreHealth(int dieRoll) {    }
    @Override
    int attack(int dieRoll) {
        return 0;
    }
}

