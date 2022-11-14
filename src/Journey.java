import java.util.ArrayList;

/**
 * This class holds the levels that the heroes will go through on a journey.
 * The levels are held in an ArrayList, so the heroes will jump through this list
 * as they progress through the game.
 */
public class Journey {
    private ArrayList<Levels> listLevels;

    // Constructor
    public Journey(ArrayList<Levels> otherLevels) {
        listLevels = new ArrayList<>();
        for (Levels other: otherLevels) {
            listLevels.add(new Levels(other));
        }
    }

    // Constructor
    public Journey(Levels levelOne) {
        listLevels = new ArrayList<>();
        listLevels.add(new Levels(levelOne));
    }

    // Constructor
    public Journey() {
        listLevels = new ArrayList<>();
    }

    /**
     * This method creates a game object and will run a level through the object.
     * @param levelNumber - the level the heroes are on.
     */
    public void startLevel(int levelNumber) {
        Game level = new Game(listLevels.get(levelNumber-1));
        level.run();
    }

    /**
     * This method will import levels from a txt file that will be used
     * in the journey.
     * @param filename
     */
    public void importLevels(String filename) {
        // TODO COLTON MIDDAUGH
    }

    /**
     * This method will be initialized after creating a Journey class.
     * The method will give the first story prompt, then navigate through the levels here.
     * The story is essentially handled here.
     */
    public void journeyLoop() {
        // TODO CREATE METHOD LOGAN WHITE
    }
}
