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
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract ArrayList<String> getReceivedFriendRequests(String username) throws SQLException;

    /**
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract ArrayList<String> getFriendList(String username) throws SQLException;

    /**
     * @param username1 
     * @param username2 
     * @return
     * @throws SQLException 
     */
    public abstract boolean deleteRequest(String username1, String username2) throws SQLException;

    /**
     * @param username1 
     * @param username2 
     * @return
     * @throws SQLException 
     */
    public abstract boolean deleteFromFriendList(String username1, String username2) throws SQLException;

    /**
     * @param username1 
     * @param username2 
     * @return
     * @throws SQLException 
     */
    public abstract boolean refuseRequest(String username1, String username2) throws SQLException;

    /**
     * @param username1 
     * @param username2 
     * @return
     * @throws SQLException 
     */
    public abstract boolean addFriendInList(String username1, String username2) throws SQLException;

    /**
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract ArrayList<String> getRequestSent(String username) throws SQLException;

    /**
     * @param username1 
     * @param username2 
     * @return
     * @throws SQLException 
     */
    public abstract boolean sendFriendRequest(String username1, String username2) throws SQLException;

    /**
	 * 
	 * @param username1
	 * @param username2
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean existsSentFriendRequest(String username1, String username2) throws SQLException;

	/**
	 * 
	 * @param username1
	 * @param username2
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean existsFriend(String username1, String username2) throws SQLException;

    /**
     * 
     * @param username1
     * @param username2
     * @return
     * @throws SQLException
     */
	public abstract boolean existsReceivedFriendRequest(String username1, String username2) throws SQLException;

	/**
	 * 
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public abstract int getUserIdByUsername(String username) throws SQLException;

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public abstract String getUsernameByUserId(int userId) throws SQLException;
	
}