public class Weapons {
    String weaponType;
    int weaponStrength;
    public Weapons (String type,int strength){
        weaponType = type;
        weaponStrength = strength;
    }

    public String getWeaponType(){
        return weaponType;
    }

    public int getWeaponStrength(){
        return weaponStrength;
    }
}
