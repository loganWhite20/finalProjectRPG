public class Slime extends Players{
    public Slime(int health,int mana,int speed,int armor,String typeOfWeapon,int strengthOfWeapon){
        super(health,mana,speed,armor,typeOfWeapon,strengthOfWeapon);
    }
    @Override
    void restoreHealth(int dieRoll) {
        if(dieRoll<20){
            int max = getMaxHealth();
            int add = (int) (max*0.15);
            updateHealth(add);
        } else if(dieRoll <15){
            int max = getMaxHealth();
            int add = (int) (max*0.1);
            updateHealth(add);
        } else if(dieRoll<10 && dieRoll>4){
            int max = getMaxHealth();
            int add = (int) (max*0.05);
            updateHealth(add);
        }
    }
    @Override
    int attack(int dieRoll) {
        if(dieRoll<20){
            return 0;
        } else if(dieRoll <15){
            return 0;
        } else if(dieRoll<10 && dieRoll>4){
            return 0;
        } else {
            return 0;
        }
    }

    int specialAttack(int dieRoll){ return -1;}

    @Override
    public boolean equals(Object object){
        return super.equals(object);
    }
}
