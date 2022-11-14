import java.util.ArrayList;

public class Journey {
    private ArrayList<Levels> listLevels;

    public Journey(ArrayList<Levels> otherLevels) {
        listLevels = new ArrayList<>();
        for (Levels other: otherLevels) {
            listLevels.add(new Levels(other));
        }
    }
    public Journey(Levels levelOne) {
        listLevels = new ArrayList<>();
        listLevels.add(new Levels(levelOne));
    }

    public Journey() {
        listLevels = new ArrayList<>();
    }
    public void startLevel(int levelNumber) {
        Game level = new Game(listLevels.get(levelNumber-1));
    }
}
