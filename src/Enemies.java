public class Enemies extends Players {
    public Enemies (int health,int mana,int speed,int armor,Weapons w,String name){
        super(health,mana,speed,armor,w,name);
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

