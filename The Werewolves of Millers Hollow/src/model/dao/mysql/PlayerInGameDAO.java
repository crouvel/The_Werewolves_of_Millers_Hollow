/**
 * package model.dao.mysql
 */
package model.dao.mysql;

/**
 * Imported classes and libraries.
 */
import java.sql.SQLException;
import java.util.ArrayList;

import businesslogic.domain.PlayerInGame;

/**
 * @author Tiffany Dumaire
 */
public abstract class PlayerInGameDAO {

    /**
     * Default constructor
     */
    public PlayerInGameDAO() {}

    /**
     * Return true if the player candidate for the post of sheriff is modify in the database
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean proposeAsASheriff(int gameId,String username) throws SQLException;

    /**
     * Return player in game
     * @param gameId
     * @param username
     * @return
     * @throws SQLException
     */
	public abstract PlayerInGame getPlayerInGame(int gameId, String username) throws SQLException;

	/**
	 * Return true if the player which has the username in parameter become lover, else false
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean becomeLover(int gameId,String username) throws SQLException;

	/**
	 * Return true if exists lover, else return false
	 * @param gameId
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean existsLover(int gameId, String username) throws SQLException;

	/**
	 * Return the list of role in the game
	 * @param gameId
	 * @return
	 * @throws SQLException
	 */
	public abstract ArrayList<String> getRoleList(int gameId) throws SQLException;

	/**
	 * Return the username player list in the game
	 * @param gameId
	 * @return
	 * @throws SQLException
	 */
	public abstract ArrayList<String> getPlayerList(int gameId) throws SQLException;

	/**
	 * Return usernames of the lovers
	 * @param gameId
	 * @return
	 * @throws SQLException
	 */
	public abstract ArrayList<String> getPlayerInLove(int gameId) throws SQLException;

	/**
	 * Return the list of player in game of the game
	 * @param gameId
	 * @return
	 * @throws SQLException
	 */
	public abstract ArrayList<PlayerInGame> getPlayerInGameList(int gameId) throws SQLException;

	/**
	 * Return if a candidate exists 
	 * @param gameId
	 * @param username
	 * @return true if exists, else false
	 * @throws SQLException
	 */
	public abstract boolean existsCandidate(int gameId, String username) throws SQLException;

	/**
	 * Remove a player in game
	 * @param gameId
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean removePlayerInGame(int gameId, String username) throws SQLException;
}