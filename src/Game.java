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
            turnOrder.put(enemy.getSpeed(), enemy);
            //listEnemies.add(newEnemy);
        }
        listPlayers = new ArrayList<>();
        SlimeHero = new Slime(user);
        listPlayers.add(SlimeHero);
        turnOrder.put(SlimeHero.getSpeed(), SlimeHero);
        hitDice = new Dice(20);
    }

    /**
     * This method will run the actual combat itself. It will loop through a turn
     * order and await for action from users and attack if it is an AI enemy.
     */
    public boolean run() {
        boolean result = false;

        printSlow(storyPrompt);
        System.out.println();
        printSlow("Beginning battle...");

        setTurnOrder();
        /**
         * This loop should go through the turn order and take
         * a System.in input from users to take an action
         */
        while (!gameFlag) {
            int input = 0;  // scanner system.in input
            int remove = -1;    // used for removing a player from the turn order
            boolean canRemove = false; // flag for removing a player from the turn order

            //cycles through turns here.
            for (Integer key : turnOrderSet) {
                Players currentPlayer = turnOrder.get(key);

                // THIS IS THE SLIMES TURN
                if (currentPlayer.returnType().equals("Slime")) {//turn for hero
                    Scanner scnr = new Scanner(System.in);

                    //THIS BLOCK DECIDES THE ACTION
                    while (input != 1 && input != 2) {
                        printSlow("Slime: Enter 1 for base attack. Enter 2 for special attack.");
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
                    } // End of deciding action.

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
                            printSlow("Select who to attack:");
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
                    } // End of decision to attack.

                    // THIS BLOCK DELIVERS THE RESULTS
                    int hitRoll = hitDice.rollDie();
                    Enemies chosenEnemy = listEnemies.get(input);
                    printSlow(currentPlayer.getName() + " is attacking " + chosenEnemy.getName() + "...");
                    if (hitRoll >= chosenEnemy.getArmorClass()) {
                        if (hitRoll == 20) { // critical hit
                            int crit = chosenEnemy.criticalHit(damage);
                            chosenEnemy.takeDamage(crit);
                            printSlow(chosenEnemy.getName() + " took " + damage + " damage... a critical hit!");
                        } else { // normal hit
                            chosenEnemy.takeDamage(damage);
                            printSlow(chosenEnemy.getName() + " took " + damage + " damage...");
                        }
                        if (chosenEnemy.getPlayerHealth() <= 0) { // if enemy is beaten
                            printSlow(chosenEnemy.getName() + " has been knocked out.");
                            String name = chosenEnemy.getName();
                            listEnemies.remove(chosenEnemy);
                            turnOrder.get(chosenEnemy.getSpeed()).deadReturnType(); // removing them from turn order
                            remove = chosenEnemy.getSpeed();
                            canRemove = true;
                        }
                    } else { // missed attack
                        printSlow(SlimeHero.getName() + " missed.");
                    } // End of final results from turn.
                    System.out.println();
                    //Slime hero heals
                    if (currentPlayer.getPlayerHealth() <= currentPlayer.getMaxHealth() * .95) {
                        int restoredHealth = SlimeHero.healthToRestore();
                        SlimeHero.addHealth(restoredHealth);
                        printSlow(SlimeHero.getName() + " healed " + restoredHealth + " health point(s). " +
                                SlimeHero.getName() + " now has " + SlimeHero.returnHealth() + " health.");
                    }
                } // End of Slimes turn

                // ENEMIES TURN
                if (currentPlayer.returnType().equals("Enemy")) {//turn for enemy

                    printSlow(currentPlayer.getName() + "'s turn...");
                    wait(1000);


                    //THIS BLOCK DECIDES THE ACTION
                    Random generator = new Random();
                    int action = generator.nextInt(21);

                    // more likely to use action 1.
                    if (action < 15) {
                        input = 1;
                    } else {
                        input = 2;
                    }

                    //THIS CALCULATES DAMAGE FOR DECISION
                    int damage = 0;
                    int heal = 0;
                    if (input == 1) { // action 1 for each enemy
                        if (((Enemies) currentPlayer).getEnemyType().equals("Warrior")) {//done
                            damage = ((Warrior) currentPlayer).attack();
                        } else if (((Enemies) currentPlayer).getEnemyType().equals("Archer")) {//done
                            damage = ((Archer) currentPlayer).stab();
                        } else if (((Enemies) currentPlayer).getEnemyType().equals("Giant")) {//done
                            damage = ((Giant) currentPlayer).stomp();
                        } else if (((Enemies) currentPlayer).getEnemyType().equals("Thief")) {//done
                            damage = ((Thief) currentPlayer).stab();
                        } else if (((Enemies) currentPlayer).getEnemyType().equals("Wizard")) {//done
                            damage = ((Wizard) currentPlayer).fireball();
                        } else if (((Enemies) currentPlayer).getEnemyType().equals("Zuckerberg")) {//done
                            damage = ((Zuckerberg) currentPlayer).roboticStare();
                        } else if (((Enemies) currentPlayer).getEnemyType().equals("Priest")) {
                            heal = ((Priest) currentPlayer).indHeal();
                        } else {
                            damage = -1;
                        }
                    } else { // action 2 for every enemy.
                        if (((Enemies) currentPlayer).getEnemyType().equals("Warrior")) {//done
                            damage = ((Warrior) currentPlayer).specialAttack();
                        } else if (((Enemies) currentPlayer).getEnemyType().equals("Archer")) {//done
                            damage = ((Archer) currentPlayer).shoot();
                        } else if (((Enemies) currentPlayer).getEnemyType().equals("Giant")) {//done
                            damage = ((Giant) currentPlayer).bash();
                        } else if (((Enemies) currentPlayer).getEnemyType().equals("Thief")) {//done
                            damage = ((Thief) currentPlayer).sneakAttack();
                        } else if (((Enemies) currentPlayer).getEnemyType().equals("Wizard")) {//done
                            damage = ((Wizard) currentPlayer).lighting();
                        } else if (((Enemies) currentPlayer).getEnemyType().equals("Zuckerberg")) {//done
                            damage = ((Zuckerberg) currentPlayer).digitalFury();
                        } else if (((Enemies) currentPlayer).getEnemyType().equals("Priest")) {
                            heal = ((Priest) currentPlayer).indHeal();
                        } else {
                            damage = -1;
                        }
                    } // end of action decision.

                    // THIS BLOCK DELIVERS THE RESULTS

                    /**
                     * priest decision-making.
                     */
                    if (((Enemies) currentPlayer).getEnemyType().equals("Priest")) {
                        // THIS DECIDES WHO TO HEAL WITH THE ACTION ONLY PRIEST ACTION
                        double minHealth = 1;
                        int index = 0;
                        for (Enemies enemy : listEnemies) {
                            if ((double) enemy.getPlayerHealth() / enemy.getMaxHealth() < minHealth) {
                                minHealth = (double) enemy.getPlayerHealth() / enemy.getMaxHealth();
                                index = listEnemies.indexOf(enemy);
                            }
                        }
                        Enemies healingEnemy = listEnemies.get(index);
                        healingEnemy.addHealth(heal);
                        if (healingEnemy.getPlayerHealth() > healingEnemy.getMaxHealth()) {
                            healingEnemy.takeDamage(healingEnemy.getPlayerHealth() - healingEnemy.getMaxHealth());
                        }
                        printSlow(currentPlayer.getName() + " has healed " + healingEnemy.getName() + " for " + heal + " points...");
                        System.out.println();
                    } else {
                        // THIS DECIDES WHO TO ATTACK WITH THE ACTION
                        Random generator2 = new Random();
                        input = generator2.nextInt(listPlayers.size());
                        printSlow(currentPlayer.getName() + " is attacking " + listPlayers.get(input).getName() + "...");

                        int hitRoll = hitDice.rollDie();
                        hitRoll = 20;
                        Players chosenPlayer = listPlayers.get(input);
                        if (hitRoll >= chosenPlayer.getArmorClass()) {
                            if (hitRoll == 20) {
                                int crit = chosenPlayer.criticalHit(damage);
                                chosenPlayer.takeDamage(crit);
                                printSlow(chosenPlayer.getName() + " took " + crit + " damage... a critical hit!");
                            } else {
                                chosenPlayer.takeDamage(damage);
                                printSlow(chosenPlayer.getName() + " took " + damage + " damage.");
                            }
                            if (chosenPlayer.getPlayerHealth() <= 0) {
                                printSlow(chosenPlayer.getName() + " has been knocked out.");
                                listPlayers.remove(input);
                                turnOrderSet.remove(input);
                                turnOrder.remove(input);
                            }
                        } else {
                            printSlow(currentPlayer.getName() + " missed.");
                        }
                        System.out.println();
                    }
                } // END OF ENEMY TURN.

                // win condition
                if (listEnemies.size() == 0) {
                    System.out.println();
                    printSlow("The enemies have been vanquished!");
                    result = true;
                    gameFlag = true;
                    break;
                }
                // lose condition
                if (listPlayers.size() == 0) {
                    printSlow("You have fallen...");
                    result = false;
                    gameFlag = true;
                    break;
                }
            }
            if (canRemove) {
                turnOrder.remove(remove);
                turnOrderSet.remove(remove);
            }
        }
        return result;
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


