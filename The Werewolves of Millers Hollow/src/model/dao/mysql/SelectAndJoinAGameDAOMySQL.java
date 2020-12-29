/**
 * package model.dao.mysql
 */
package model.dao.mysql;

import java.sql.SQLException;
/**
 * Imported classes and libraries.
 */
import java.util.*;
import businesslogic.domain.Game;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class SelectAndJoinAGameDAOMySQL extends SelectAndJoinAGameDAO {

    /**
     * Default constructor
     */
    public SelectAndJoinAGameDAOMySQL() {}

    @Override
    public Game getGameById(int game_id) throws SQLException {
    	return null;
    }

    @Override
    public ArrayList<Game> getAvailableGameList() throws SQLException {
    	return new ArrayList<Game>();
    }

    @Override
    public boolean makePlayerJoinAGameByGameId(int game_id) throws SQLException {
    	return true;
    }

}