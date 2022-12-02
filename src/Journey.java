import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

/**
 * This class holds the levels that the heroes will go through on a journey.
 * The levels are held in an ArrayList, so the heroes will jump through this list
 * as they progress through the game.
 */
public class Journey {
    private ArrayList<Levels> listLevels;
    private  Slime userCharacter;

    // Constructor
    public Journey(String filename) {

    }

    // Constructor
    public Journey(ArrayList<Levels> otherLevels) {
        listLevels = new ArrayList<>();
        for (Levels other: otherLevels) {
            listLevels.add(new Levels(other));
        }
        userCharacter = new Slime(10,10,10,10,"Slime Hero", new Weapons("Sword",5,8));
    }

    // Constructor
    public Journey(Levels levelOne) {
        listLevels = new ArrayList<>();
        listLevels.add(new Levels(levelOne));
        userCharacter = new Slime(10,10,10,10,"Slime Hero", new Weapons("Sword",5,8));
    }

    // Constructor
    public Journey() {
        listLevels = new ArrayList<>();
        userCharacter = new Slime(10,10,10,10,"Slime Hero", new Weapons("Sword",5,8));
    }

    /**
     * This method creates a game object and will run a level through the object.
     * @param levelNumber - the level the heroes are on.
     */
    public void startLevel(int levelNumber) {
        Game level = new Game(listLevels.get(levelNumber-1), userCharacter);
        level.run();
    }

    /**
     * This method will import levels from a txt file that will be used
     * in the journey.
     * @param fileName
     */
    public void importLevels(String fileName) throws FileNotFoundException {
        // TODO COLTON MIDDAUGH
        File file = new File(fileName);
        Scanner scnr = new Scanner(file);
        StringBuilder story = new StringBuilder();
        ArrayList<Enemies> enemiesList = new ArrayList<>();
        while(!scnr.hasNextInt()){
            story.append(scnr.nextLine()).append(" ");
        }
//        int numEnemies = scnr.nextInt();
        while(scnr.hasNextLine()){
            int health = scnr.nextInt();
            int mana = scnr.nextInt();
            int speed = scnr.nextInt();
            int armor = scnr.nextInt();
            String name = scnr.next();
            String weaponType = scnr.next();
            int weaponStrength = scnr.nextInt();
            int weaponDiceSides = scnr.nextInt();
            String enemyType = scnr.next();
            Weapons testWeapon = new Weapons(weaponType,weaponStrength,weaponDiceSides);
            //TODO throw if statements for type of enemy - Colton
            if(enemyType.equals("Warrior")){
                Warrior enemy = new Warrior(health,mana,speed,armor,name, testWeapon,enemyType);
                enemiesList.add(enemy);
            }else if(enemyType.equals("Archer")){
                Archer enemy = new Archer(health,mana,speed,armor,name, testWeapon,enemyType);
            }else if(enemyType.equals("Thief")){
                Thief enemy = new Thief(health,mana,speed,armor,name, testWeapon,enemyType);
            }else if(enemyType.equals("Wizard")){
                Wizard enemy = new Wizard(health,mana,speed,armor,name, testWeapon,enemyType);
            }else if(enemyType.equals("Giant")){
                Giant enemy = new Giant(health,mana,speed,armor,name, testWeapon,enemyType);
            }else if(enemyType.equals("Priest")){
                Priest enemy = new Priest(health,mana,speed,armor,name, testWeapon,enemyType);
            }else{

            }
        }
        Levels level1 = new Levels(String.valueOf(story), enemiesList);
        listLevels.add(level1);
    }

    /**
     * This method will be initialized after creating a Journey class.
     * The method will give the first story prompt, then navigate through the levels here.
     * The story is essentially handled here.
     */
    public void journeyLoop() throws FileNotFoundException {
        // TODO CREATE METHOD LOGAN WHITE
        String fileName = "Level1Test.txt";
        importLevels(fileName);
        startLevel(1);

    }
}
