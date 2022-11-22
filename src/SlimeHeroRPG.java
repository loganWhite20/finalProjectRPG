import java.io.FileNotFoundException;

/**
 * This program is an RPG where the Hero is a Slime. The game
 * starts where the Slime's village was ransacked by Lizardfolk,
 * and the Slime sets off to get payback.
 */
public class SlimeHeroRPG {
    public static void main(String[] args) throws FileNotFoundException {
        Journey story = new Journey();
        story.journeyLoop();
    }
}
