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
     * Allows the player to create a game
     * @param numberOfPlayers 
     * @param status 
     * @return
     * @throws SQLException 
     */
    public abstract boolean createGame(int nbplayers, boolean status, String creator) throws SQLException;

    /**
     * Returns the game corresponding to the gameId
     * @param game_id 
     * @return
     * @throws SQLException 
     */
    public abstract Game getGame(int game_id) throws SQLException;

    /**
     * Allows the game creator to modify the role inside the game
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
     * Allows the player to invite a friend to play
     * @param game_id 
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean inviteFriendToPlay(int game_id, String username1, String username2) throws SQLException;

    /**
     * Allows the player to cancel a game request
     * @param game_id 
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean cancelRequest(int game_id, String username1, String username2) throws SQLException;

    /**
     * Allows the game creator to kick player out of game
     * @param game_id 
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean kickPlayerOutOfTheGame(int game_id, String username) throws SQLException;

    /**
     * Allows the game creator to delete the game
     * @param game_id 
     * @return
     * @throws SQLException 
     */
    public abstract boolean deleteGame(int game_id) throws SQLException;

    /**
     * Returns the game corresponding to the creator username in parameter
     * @param creator
     * @return
     * @throws SQLException
     */
    public abstract Game getGameByCreator( String creator) throws SQLException;
    
    /**
     * Return the list of invited players in the game
     * @param gameId
     * @param username
     * @return
     * @throws SQLException
     */
    public abstract ArrayList<String> getInvitedFriend(int gameId, String username) throws SQLException;
    
    /**
     * Returns the players in the game
     * @param gameId
     * @return
     * @throws SQLException
     */
    public abstract ArrayList<String> getPlayer(int gameId) throws SQLException;

    /**
     * Returns true if the game exists, else false
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
	 * Returns true if the game exists, else false
	 * @param game_id
	 * @param username1
	 * @param username2
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean existsGameRequest(int game_id, String username1, String username2) throws SQLException;

	/**
	 * Returns true if the game exists, else false
	 * @param username
	 * @return	
	 * @throws SQLException
	 */
	public abstract boolean existsGame2(String username) throws SQLException;

	/**
	 * Returns true if the game exists, else false
	 * @param game_id
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean existsGame(int game_id) throws SQLException;

	/**
	 * Returns true if the player in game exists, else false
	 * @param username
	 * @param game_id
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean existsPlayerInGame(String username, int game_id) throws SQLException;

	/**
	 * Allows the player to delete game
	 * @param creatorUsername
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean deleteGame2(String creatorUsername) throws SQLException;

	/**
	 * Allows the game creator to update a game
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean updatePlayerInGame(int gameId, String username, String role) throws SQLException;

}