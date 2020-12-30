/**
 * package model.dao.mysql
 */
package model.dao.mysql;

/**
 * Imported classes and libraries.
 */
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
    public GameDAO() {}

    /**
     * Search and returns the list of players in game corresponding to game_id.
     * @param game_id 
     * @return the list of present players in the game.
     * @throws SQLException 
     */
    public abstract ArrayList<PlayerInGame> getPlayerInGameList(int game_id) throws SQLException;

    /**
     * Search and returns the list of vote issued during the game corresponding to game_id.
     * @param game_id 
     * @return the list of votes.
     * @throws SQLException 
     */
    public abstract ArrayList<String> getAllVotes(int game_id) throws SQLException;

    /**
     * Sends vote of username1, voting for username2 in the game corresponding to game_id.
     * @param username1 
     * @param username2 
     * @param game_id 
     * @return true if sending the vote is successful, else false.
     * @throws SQLException 
     */
    public abstract boolean sendVote(String username1, String username2, int game_id) throws SQLException;

}