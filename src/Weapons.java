public class Weapons {
    private String weaponType;
    private int weaponStrength;
    private Dice dmgDie;
    private int dmgModifier;
    public Weapons (String type,int strength,int numSidesForDice){
        weaponType = type;
        weaponStrength = strength;
        dmgDie = new Dice(numSidesForDice);
    }

    public Weapons (Weapons w) {
        this.weaponType = w.weaponType;
        this.weaponStrength = w.weaponStrength;
        this.dmgDie = new Dice(w.dmgDie);
    }

    public String getWeaponType(){
        return weaponType;
    }

    public int getWeaponStrength(){
        return weaponStrength;
    }
}
