import java.util.ArrayList;

public class Levels {
    protected String storyPrompt;
    protected ArrayList<Enemies> listEnemies;


    // Constructor
    public Levels(String storyPrompt, Enemies enemy) {
        listEnemies = new ArrayList<>();
        this.storyPrompt = storyPrompt;
        listEnemies.add(new Enemies(enemy));
    }
    // Constructor
    public Levels(String storyPrompt, ArrayList<Enemies> other) {
        listEnemies = new ArrayList<>();
        this.storyPrompt = storyPrompt;
        for (Enemies otherEnemy: other) {
            Enemies thisEnemy = new Enemies(otherEnemy);
            this.listEnemies.add(thisEnemy);
        }
    }

    // Empty Constructor
    public Levels() {
        storyPrompt = "Empty Level: No enemies";
        listEnemies = new ArrayList<>();
    }

    // Copy Constructor
    public Levels(Levels other) {
        this.storyPrompt = other.storyPrompt;
        this.listEnemies = new ArrayList<>();
        for (Enemies otherEnemy: other.listEnemies) {
            Enemies thisEnemy = new Enemies(otherEnemy);
            this.listEnemies.add(thisEnemy);
        }
    }
}