package businesslogic.facade;

import java.util.*;
import businesslogic.domain.Game;
import businesslogic.domain.PlayerInGame;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class GameFacade {

    /**
     * Default constructor
     */
    public GameFacade() {
    }






    /**
     * 
     */
    private Game currentGame;


    /**
     * @param badPlayerUsername 
     * @param reason 
     * @param description 
     * @return
     */
    public boolean sendPlayerReport(String badPlayerUsername, String reason, String description) {
        // TODO implement here
        return false;
    }

    /**
     * @param username 
     * @return
     */
    public boolean proposeAsASheriff(String username) {
        // TODO implement here
        return false;
    }

    /**
     * @param username1 
     * @param username2 
     * @param game_id 
     * @return
     */
    public boolean makeAVote(String username1, String username2, int game_id) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public PlayerInGame getCurrentPlayerInGame() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getCurrentPlayerInGameUsername() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public int getGameId() {
        // TODO implement here
        return 0;
    }

    /**
     * @param game_id 
     * @return
     */
    public ArrayList<String> getAllVotes(int game_id) {
        // TODO implement here
        return null;
    }

}