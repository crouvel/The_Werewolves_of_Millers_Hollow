package model.dao.mysql;

import java.util.*;

import businesslogic.domain.PlayerInGame;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class GameDAOMySQL extends GameDAO {

    /**
     * Default constructor
     */
    public GameDAOMySQL() {
    }
    
    /**
     * @param game_id 
     * @return
     */
    public ArrayList<PlayerInGame> getPlayerInGameList(int game_id) {
        // TODO implement here
        return null;
    }

    /**
     * @param game_id 
     * @return
     */
    public ArrayList<String> getAllVotes(int game_id) {
        // TODO implement here
        return null;
    }

    /**
     * @param username1 
     * @param username2 
     * @param game_id 
     * @return
     */
    public boolean sendVote(String username1, String username2, int game_id) {
        // TODO implement here
        return false;
    }


}