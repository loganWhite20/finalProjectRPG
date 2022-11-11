import java.util.ArrayList;

public class Board {
    private ArrayList<Players> players = new ArrayList<Players>();
    private ArrayList<Enemies> enemies = new ArrayList<Enemies>();

    public void addPlayer(Players player){
        players.add(player);
    }

    public void addEnemy(Enemies enemy){
        enemies.add(enemy);
    }

    public void removePlayer(Players player){
        players.remove(player);
    }

    public void removeEnemy(Enemies enemy){
        enemies.remove(enemy);
    }
}
