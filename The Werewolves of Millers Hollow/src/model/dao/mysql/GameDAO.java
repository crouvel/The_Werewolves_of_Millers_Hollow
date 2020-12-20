package model.dao.mysql;

import java.util.*;
import businesslogic.domain.PlayerInGame;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public abstract class GameDAO {

    /**
     * Default constructor
     */
    public GameDAO() {
    }

    /**
     * @param game_id 
     * @return
     */
    public abstract ArrayList<PlayerInGame> getPlayerInGameList(int game_id);

    /**
     * @param game_id 
     * @return
     */
    public abstract ArrayList<String> getAllVotes(int game_id);

    /**
     * @param username1 
     * @param username2 
     * @param game_id 
     * @return
     */
    public abstract boolean sendVote(String username1, String username2, int game_id);

}