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
        gameFlag = false;
        for (Enemies enemy: listEnemies) {
            turnOrder.put(enemy.speed, enemy);
        }
    }

    /**
     * This method will run the actual combat itself. It will loop through a turn
     * order and await for action from users and attack if it is an AI enemy.
     */
    public void run() {
        // TODO LOGAN WHITE & BEN ANASTASI
        System.out.println(storyPrompt);

        /**
         * This loop should go through the turn order and take
         * a System.in input from users to take an action
         */
        while(!gameFlag) {
            for (Integer key: turnOrderSet){
                turnOrder.get(key);
            }
            gameFlag = true;
        }
    }

    /**
     * This method will set the turn order for combat. The run() function will run
     * through the turnOrderSet to take players turns. Once a player is defeated, they
     * will be removed from this set.
     */
    public void setTurnOrder() {
        turnOrderSet = turnOrder.descendingKeySet();
    }
}
