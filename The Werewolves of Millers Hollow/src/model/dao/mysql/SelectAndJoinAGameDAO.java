/**
 * package model.dao.mysql
 */
package model.dao.mysql;

/**
 * Imported classes and libraries.
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import businesslogic.domain.Game;

/**
 * @author Tiffany Dumaire, Aaron Lazaroo, Clarence Rouvel
 */
public abstract class SelectAndJoinAGameDAO {

    /**
     * Default constructor
     */
    public SelectAndJoinAGameDAO() {}


    /**
     * 
     * @param game_id 
     * @return
     * @throws SQLException 
     */
    public abstract Game getGameById(int game_id) throws SQLException;

    /**
     * Search and returns the list of available and public games.
     * @return the list of available and public games.
     * @throws SQLException 
     */
    public abstract ArrayList<Game> getAvailableGameList() throws SQLException;

    /**
     * 
     * @param game_id 
     * @return true if the player joins the game successfully, else false.
     * @throws SQLException 
     * @throws IOException 
     */
    public abstract boolean makePlayerJoinAGameByGameId(int game_id) throws SQLException, IOException;

    /**
     * 
     * @param gameid
     * @param username
     * @return
     * @throws SQLException
     */
	public abstract boolean existsPlayerInGame(int gameid, String username) throws SQLException;

}