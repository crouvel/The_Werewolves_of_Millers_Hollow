package model.dao.mysql;

import java.sql.SQLException;
import java.util.*;

/**
 * @author Tiffany Dumaire, Aaron Lazaroo, Clarence Rouvel
 */
public abstract class FriendManagementDAO {

    /**
     * Default constructor
     */
    public FriendManagementDAO() {
    }

    /**
     * Returns the list of player username which the player had received the request
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract ArrayList<String> getReceivedFriendRequests(String username) throws SQLException;

    /**
     * Returns the list of player username in the player friends list
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract ArrayList<String> getFriendList(String username) throws SQLException;

    /**
     * Allows the player to delete a friend request
     * @param username1 
     * @param username2 
     * @return
     * @throws SQLException 
     */
    public abstract boolean deleteRequest(String username1, String username2) throws SQLException;

    /**
     * Allows the player to delete a friend 
     * @param username1 
     * @param username2 
     * @return
     * @throws SQLException 
     */
    public abstract boolean deleteFromFriendList(String username1, String username2) throws SQLException;

    /**
     * Allows the player to refuse a friend request
     * @param username1 
     * @param username2 
     * @return
     * @throws SQLException 
     */
    public abstract boolean refuseRequest(String username1, String username2) throws SQLException;

    /**
     * Allows the player to accept a friend request
     * @param username1 
     * @param username2 
     * @return
     * @throws SQLException 
     */
    public abstract boolean addFriendInList(String username1, String username2) throws SQLException;

    /**
     * Returns the list of username of player in the player sent request
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract ArrayList<String> getRequestSent(String username) throws SQLException;

    /**
     * Allows the player to send a friend request
     * @param username1 
     * @param username2 
     * @return
     * @throws SQLException 
     */
    public abstract boolean sendFriendRequest(String username1, String username2) throws SQLException;

    /**
	 * Returns true if the sent friend request exists, else false
	 * @param username1
	 * @param username2
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean existsSentFriendRequest(String username1, String username2) throws SQLException;

	/**
	 * Returns true if the friend exists, else false
	 * @param username1
	 * @param username2
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean existsFriend(String username1, String username2) throws SQLException;

    /**
     * Returns true if the received friend request exists, else false
     * @param username1
     * @param username2
     * @return
     * @throws SQLException
     */
	public abstract boolean existsReceivedFriendRequest(String username1, String username2) throws SQLException;

	/**
	 * Return the userId of the player
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public abstract int getUserIdByUsername(String username) throws SQLException;

	/**
	 * Return the username of the player
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public abstract String getUsernameByUserId(int userId) throws SQLException;
	
}