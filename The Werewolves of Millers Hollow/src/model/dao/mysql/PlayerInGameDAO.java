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
     * 
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean proposeAsASheriff(int gameId,String username) throws SQLException;

    /**
     * 
     * @param gameId
     * @param username
     * @return
     * @throws SQLException
     */
	public abstract PlayerInGame getPlayerInGame(int gameId, String username) throws SQLException;

	/**
	 * 
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean becomeLover(int gameId,String username) throws SQLException;

	/**
	 * 
	 * @param gameId
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean existsLover(int gameId, String username) throws SQLException;

	/**
	 * 
	 * @param gameId
	 * @return
	 * @throws SQLException
	 */
	public abstract ArrayList<String> getRoleList(int gameId) throws SQLException;

	/**
	 * 
	 * @param gameId
	 * @return
	 * @throws SQLException
	 */
	public abstract ArrayList<String> getPlayerList(int gameId) throws SQLException;

	/**
	 * 
	 * @param gameId
	 * @return
	 * @throws SQLException
	 */
	public abstract ArrayList<String> getPlayerInLove(int gameId) throws SQLException;

	/**
	 * 
	 * @param gameId
	 * @return
	 * @throws SQLException
	 */
	public abstract ArrayList<PlayerInGame> getPlayerInGameList(int gameId) throws SQLException;

	/**
	 * 
	 * @param gameId
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean existsCandidate(int gameId, String username) throws SQLException;

}