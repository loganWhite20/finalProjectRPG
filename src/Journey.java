import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class holds the levels that the heroes will go through on a journey.
 * The levels are held in an ArrayList, so the heroes will jump through this list
 * as they progress through the game.
 */
public class Journey {
    private ArrayList<Levels> listLevels;
    private  Slime userCharacter;
    private int lives = 3;

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
        userCharacter = new Slime(30,10,10,10,"Slime Hero", new Weapons("Sword",5,8));
    }

    /**
     * This method creates a game object and will run a level through the object.
     * @param levelNumber - the level the heroes are on.
     */
    public boolean startLevel(int levelNumber) {
        Game level = new Game(listLevels.get(levelNumber-1), userCharacter);
        boolean result = level.run();
        return result;
    }

    /**
     * This method will import levels from a txt file that will be used
     * in the journey.
     * @param fileName
     */
    public void importLevel(String fileName) throws FileNotFoundException {
        // TODO COLTON MIDDAUGH
        File file = new File(fileName);
        Scanner scnr = new Scanner(file);
        StringBuilder story = new StringBuilder();
        ArrayList<Enemies> enemiesList = new ArrayList<>();
        while(!scnr.hasNextInt()){
            story.append(scnr.nextLine()).append(" \n");
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

        ArrayList<String> fileSet = new ArrayList<>();
        fileSet.add("Level1.txt");
        fileSet.add("Level1Test.txt");
        for (String file: fileSet) {
            importLevel(file);
        }

        Scanner scnr = new Scanner(System.in);
        String input = null;
        printSlow("Are you ready to begin your journey? [yes,no]");
        input = scnr.next();
        while (!input.equals("yes") && !input.equals("Yes") && !input.equals("YES")) {
            printSlow("Are you ready to begin your journey? [yes,no]");
            input = scnr.next();
        }
        printSlow("Beginning your journey...");

        for (int i = 0; i < listLevels.size(); i++) {
            printMap(i);
            printSlow("Starting level " + i+1 + "...");
            System.out.println();
            wait(1000);
            boolean result = startLevel(i+1);
            if (result == false && lives > 0) {
                printSlow("Total lives left: " + lives);
                printSlow("Would you like to try again? [yes,no]");
                input = scnr.next();
                if (input.equals("yes") || input.equals("Yes") || input.equals("YES")) {
                    i--;
                    lives--;
                    printSlow("Total lives: " + lives);
                }
                else {
                    printSlow("Quitting...");
                }
            }
        }
        System.out.println();
        printSlow("Congradulations! You have beaten the game!");
    }

    public void printMap(int currLevel) {
        String text1 = " ";
        String text2 = "|";
        String text3 = "|";
        String text4 = "|";
        System.out.println("Map:");
        for (int i = 0; i < listLevels.size(); i++) {
            if (i >= currLevel) {

                    text1 += "-----";
                    text2 += "  _  ";
                    text3 += " |_| ";
                    text4 += "  " + (i + 1) + "  ";

            }
            else {

                text1 += "-----";
                text2 += "     ";
                text3 += "  X  ";
                text4 += "  " + (i + 1) + "  ";

            }
        }
        text2 += "|";
        text3 += "|";
        text4 += "|";
        System.out.println(text1);
        System.out.println(text2);
        System.out.println(text3);
        System.out.println(text4);
        System.out.println(text1);
    }

    /**
     * prints string input on a delay.
     * @param input
     */
    public void printSlow(String input) {
        Scanner story = new Scanner(input);
        while(story.hasNextLine()) {
            Scanner in = new Scanner(story.nextLine());
            in.useDelimiter("");
            while (in.hasNext()) {
                System.out.print(in.next());
                try {
                    Thread.sleep(75);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println();
        }
    }

    /**
     * delays the code in milliseconds.
     * @param milliseconds
     */
    public void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
