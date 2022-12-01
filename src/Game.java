import java.util.*;

/**
 * This class is what the players will be interacting with in combat.
 * The class takes in the players and the level the players will enter.
 * The class takes in ever players speeds and sorts the players in a turn
 * order where the players with the most speed goes first.
 */
public class Game extends Levels {
    private ArrayList<Players> listPlayers;
    private Set<Integer> turnOrderSet;
    private TreeMap<Integer, Players> turnOrder;
    private boolean gameFlag;
    private Slime SlimeHero;
    private Dice hitDice;

    // Cosntructor
    public Game(Levels levelNumber, Slime user) {
        super(levelNumber);
        turnOrder = new TreeMap<>();
        turnOrderSet = new HashSet<>();
        gameFlag = false;
        for (Enemies enemy : levelNumber.listEnemies) {
            Enemies newEnemy = new Enemies(enemy);
            turnOrder.put(newEnemy.getSpeed(), newEnemy);
            //listEnemies.add(newEnemy);
        }
        SlimeHero = new Slime(user);
        turnOrder.put(SlimeHero.getSpeed(), SlimeHero);
        hitDice = new Dice(20);
    }

    /**
     * This method will run the actual combat itself. It will loop through a turn
     * order and await for action from users and attack if it is an AI enemy.
     */
    public void run() {
        // TODO LOGAN WHITE & BEN ANASTASI
        System.out.println(storyPrompt);
        setTurnOrder();
        /**
         * This loop should go through the turn order and take
         * a System.in input from users to take an action
         */
        while (!gameFlag) {
            System.out.println("Congrats, we are here");
            int input = 0;

            for (Integer key : turnOrderSet) {
                Players currentPlayer = turnOrder.get(key);

                // THIS IS THE SLIMES TURN
                if (currentPlayer.returnType().equals("Slime")) {//turn for hero
                    Scanner scnr = new Scanner(System.in);

                    //THIS BLOCK DECIDES THE ACTION
                    while (input != 1 && input != 2) {
                        System.out.println("Slime: Enter 1 for base attack. Enter 2 for special attack.");
                        try {
                            input = scnr.nextInt();
                            System.out.println();
                            if (input < 1 || input > 2) {
                                throw new IllegalArgumentException();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Incorrect input");
                            scnr.next();
                        } catch (IllegalArgumentException e) {
                            System.out.println("Incorrect input");
                        }
                    }

                    //THIS CALCULATES DAMAGE FOR DECISION
                    int damage;
                    if (input == 1) {
                        damage = SlimeHero.attack();
                    } else {
                        damage = SlimeHero.specialAttack();
                    }

                    // THIS DECIDES WHO TO ATTACK WITH THE ACTION
                    boolean intFlag = false;
                    input = 0;
                    while (!intFlag == true) {
                        try {
                            System.out.println("Select who to attack");
                            printListEnemies();

                            input = scnr.nextInt() - 1;
                            System.out.println();
                            if (!(input >= 0 && input < listEnemies.size())) {
                                //System.out.println("Illegal argument");
                                throw new IllegalArgumentException();
                            }
                            intFlag = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Illegal argument.");
                            scnr.next();
                        } catch (IllegalArgumentException e) {
                            System.out.println("Illegal argument.");
                        }
                    }

                    // THIS BLOCK DELIVERS THE RESULTS
                    int hitRoll = hitDice.rollDie();
                    if (hitRoll >= listEnemies.get(input).getArmorClass()) {
                        listEnemies.get(input).takeDamage(damage);
                        System.out.println(listEnemies.get(input).getName() + " took " + damage + " damage.");
                        if (listEnemies.get(input).getPlayerHealth() <= 0) {
                            System.out.println(listEnemies.get(input).getName() + " has been knocked out.");
                            listEnemies.remove(input);
                        }
                    } else {
                        System.out.println(SlimeHero.getName() + " missed.");
                    }
                    System.out.println();
                }

                    // ENEMIES TURN
//                  else if (currentPlayer.returnType().equals("Warrior")){//turn for hero
//                    int input;
//                    Random randGen = new Random();
//                    input = randGen.nextInt(20);
//                    int damage = currentPlayer.criticalHit(input);
//                    if(input==1){
//                        damage = currentPlayer.attack();
//                    } else {
//                        damage = currentPlayer.specialAttack();
//                    }
//
//                    boolean intFlag = false;
//                    int in = 0;
//                    while (!intFlag == true) {
//                        try {
//                            System.out.println("Select who to attack");
//                            printListEnemies();
//                            in = scnr.nextInt()-1;
//                            if (!(in >= 0 && in < listEnemies.size())) {
//                                System.out.println("Illegal argument");
//                                throw new IllegalArgumentException();
//                            }
//                            intFlag = true;
//                        } catch (IllegalArgumentException e) {
//                            System.out.println("Illegal argument.");
//                        }
//                    }
//                    int hitRoll = hitDice.rollDie();
//                    if (hitRoll>=listEnemies.get(in).getArmorClass()) {
//                        listEnemies.get(in).takeDamage(damage);
//                        System.out.println(listEnemies.get(in).getName() + " took " + damage + "damage");
//                        if (listEnemies.get(in).getPlayerHealth() <= 0) {
//                            System.out.println(listEnemies.get(in).getName() + " has been knocked out.");
//                            listEnemies.remove(in);
//                        }
//                    }
//                    else {
//                        System.out.println(SlimeHero.getName() + " missed.");
//                    }
                    if (listEnemies.size() == 0) {
                        System.out.println("The enemies have been vanquished!");
                        gameFlag = true;
                        break;
                    }
                    if (SlimeHero.getPlayerHealth() <= 0) {
                        System.out.println("You have fallen...");
                        gameFlag = true;
                        break;
                    }
                }
            }
        }


    /**
     * This method will print out the names of each enemy.
     */
    public void printListEnemies() {
        int i = 1;
        for (Enemies e : listEnemies) {
            System.out.println(i + ". " + e.getName());
            i++;
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


