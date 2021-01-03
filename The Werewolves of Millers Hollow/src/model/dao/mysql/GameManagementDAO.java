/**
 * package model.dao.mysql
 */
package model.dao.mysql;

/**
 * Imported classes and libraries.
 */
import java.sql.SQLException;
import java.util.ArrayList;

import businesslogic.domain.Game;

/**
 * @author Tiffany Dumaire, Aaron Lazaroo, Clarence Rouvel
 */
public abstract class GameManagementDAO {

    /**
     * Default constructor
     */
    public GameManagementDAO() {}

    /**
     * 
     * @param numberOfPlayers 
     * @param status 
     * @return
     * @throws SQLException 
     */
    public abstract boolean createGame(int nbplayers, boolean status, String creator) throws SQLException;

    /**
     * 
     * @param game_id 
     * @return
     * @throws SQLException 
     */
    public abstract Game getGame(int game_id) throws SQLException;

    /**
     * 
     * @param numberOfWerewolves 
     * @param hasWitch 
     * @param hasFortuneTeller 
     * @param hasLittleGirl 
     * @param hasCupid 
     * @param hasHunter 
     * @return
     * @throws SQLException 
     */
    public abstract boolean modifyRole(int game_id, int numberOfWerewolves, boolean hasWitch, boolean hasFortuneTeller, boolean hasLittleGirl, boolean hasCupid, boolean hasHunter) throws SQLException;

    /**
     * 
     * @param game_id 
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean inviteFriendToPlay(int game_id, String username1, String username2) throws SQLException;

    /**
     * 
     * @param game_id 
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean cancelRequest(int game_id, String username1, String username2) throws SQLException;

    /**
     * 
     * @param game_id 
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean kickPlayerOutOfTheGame(int game_id, String username) throws SQLException;

    /**
     * 
     * @param game_id 
     * @return
     * @throws SQLException 
     */
    public abstract boolean deleteGame(int game_id) throws SQLException;

    /**
     * 
     * @param creator
     * @return
     * @throws SQLException
     */
    public abstract Game getGameByCreator( String creator) throws SQLException;
    
    /**
     * 
     * @param gameId
     * @param username
     * @return
     * @throws SQLException
     */
    public abstract ArrayList<String> getInvitedFriend(int gameId, String username) throws SQLException;
    
    /**
     * 
     * @param gameId
     * @return
     * @throws SQLException
     */
    public abstract ArrayList<String> getPlayer(int gameId) throws SQLException;

    /**
     * 
     * @param game_id
     * @param numberOfWerewolves
     * @param hasWitch
     * @param hasFortuneTeller
     * @param hasLittleGirl
     * @param hasCupid
     * @param hasHunter
     * @return
     * @throws SQLException
     */
	public abstract boolean existsGamewithParams(int game_id, int numberOfWerewolves, boolean hasWitch, boolean hasFortuneTeller, boolean hasLittleGirl, boolean hasCupid, boolean hasHunter) throws SQLException;

	/**
	 * 
	 * @param game_id
	 * @param username1
	 * @param username2
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean existsGameRequest(int game_id, String username1, String username2) throws SQLException;

	/**
	 * 
	 * @param username
	 * @return@Override
	
	 * @throws SQLException
	 */
	public abstract boolean existsGame2(String username) throws SQLException;

	/**
	 * 
	 * @param game_id
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean existsGame(int game_id) throws SQLException;

	/**
	 * 
	 * @param username
	 * @param game_id
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean existsPlayerInGame(String username, int game_id) throws SQLException;

	/**
	 * 
	 * @param creatorUsername
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean deleteGame2(String creatorUsername) throws SQLException;

	/**
	 * 
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean updatePlayerInGame(int gameId, String username, String role) throws SQLException;

}