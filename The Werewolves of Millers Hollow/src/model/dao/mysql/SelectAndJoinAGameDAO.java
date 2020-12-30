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
     * Search and return the game corresponding to the game_id parameter.
     * @param game_id 
     * @return the game corresponding to the game_id parameter.
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
     * Allows the player to join an available game corresponding to the game_id parameter.
     * @param game_id 
     * @return true if the player joins the game successfully, else false.
     * @throws SQLException 
     * @throws IOException 
     */
    public abstract boolean makePlayerJoinAGameByGameId(int game_id) throws SQLException, IOException;

    /**
     * Search if the game corresponding to gameid and creator=username exists.
     * @param gameid
     * @param username
     * @return true if the game exists, else false.
     * @throws SQLException
     */
	public abstract boolean existsPlayerInGame(int gameid, String username) throws SQLException;

}