package model.dao.mysql;

import java.sql.SQLException;
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
     * @throws SQLException 
     */
    public abstract ArrayList<PlayerInGame> getPlayerInGameList(int game_id) throws SQLException;

    /**
     * @param game_id 
     * @return
     * @throws SQLException 
     */
    public abstract ArrayList<String> getAllVotes(int game_id) throws SQLException;

    /**
     * @param username1 
     * @param username2 
     * @param game_id 
     * @return
     * @throws SQLException 
     */
    public abstract boolean sendVote(String username1, String username2, int game_id) throws SQLException;

}