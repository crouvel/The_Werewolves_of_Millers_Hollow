/**
 * package model.dao.mysql
 */
package model.dao.mysql;

import java.sql.SQLException;
/**
 * Imported classes and libraries.
 */
import java.util.*;

import businesslogic.domain.PlayerInGame;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class GameDAOMySQL extends GameDAO {

    /**
     * Default constructor
     */
    public GameDAOMySQL() {}
    
    @Override
    public ArrayList<PlayerInGame> getPlayerInGameList(int game_id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<String> getAllVotes(int game_id) throws SQLException {
        return null;
    }

    @Override
    public boolean sendVote(String username1, String username2, int game_id) throws SQLException {
        return false;
    }


}