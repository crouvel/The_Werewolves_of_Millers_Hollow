package businesslogic.facade;

import java.util.*;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class GameFacade {

    /**
     * Default constructor
     */
    public GameFacade() {}

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
     * @param game_id 
     * @return
     */
    public ArrayList<String> getAllVotes(int game_id) {
        // TODO implement here
        return null;
    }

}