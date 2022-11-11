import java.util.ArrayList;

public class Board {
    private ArrayList<Player> players = new ArrayList<Players>();
    private ArrayList<Enemy> enemies = new ArrayList<Enemies>();

    public void addPlayer(Player player){
        players.add(player);
    }

    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }

    public void removePlayer(Player player){
        players.remove(player);
    }

    public void removeEnemy(Enemy enemy){
        enemies.remove(enemy)
    }
}
