import java.util.ArrayList;
import java.util.HashMap;

public class Game extends Levels{
    private ArrayList<Players> listPlayers;
    private HashMap<Integer,Players> turnOrder;
    private boolean gameFlag;

    public Game(Levels levelNumber) {
        super(levelNumber);
        turnOrder = new HashMap<>();
        for (Enemies enemy: listEnemies) {
            turnOrder.put(enemy.speed, enemy);
        }
    }

    public void run() {
        System.out.println(storyPrompt);

    }

    public void setTurnOrder() {
    }
}
