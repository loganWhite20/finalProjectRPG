import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * This class is what the players will be interacting with in combat.
 * The class takes in the players and the level the players will enter.
 * The class takes in ever players speeds and sorts the players in a turn
 * order where the players with the most speed goes first.
 */
public class Game extends Levels{
    private ArrayList<Players> listPlayers;
    private Set<Integer> turnOrderSet;
    private TreeMap<Integer,Players> turnOrder;
    private boolean gameFlag;

    // Cosntructor
    public Game(Levels levelNumber) {
        super(levelNumber);
        turnOrder = new TreeMap<>();
        turnOrderSet = new HashSet<>();
        for (Enemies enemy: listEnemies) {
            turnOrder.put(enemy.speed, enemy);
        }
    }

    public void run() {
        System.out.println(storyPrompt);

    }

    public void setTurnOrder() {
        turnOrderSet = turnOrder.descendingKeySet();
    }
}
