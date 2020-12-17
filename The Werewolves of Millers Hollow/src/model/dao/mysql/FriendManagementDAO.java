package model.dao.mysql;

import java.util.*;
import businesslogic.domain.Player;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
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
     */
    public abstract ArrayList<Player> getReceivedFriendRequests(String username);

    /**
     * @param username 
     * @return
     */
    public abstract ArrayList<Player> getFriendList(String username);

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public abstract boolean deleteRequest(String username1, String username2);

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public abstract boolean deleteFromFriendList(String username1, String username2);

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public abstract boolean refuseRequest(String username1, String username2);

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public abstract boolean addFriendInList(String username1, String username2);

    /**
     * @param username 
     * @return
     */
    public abstract ArrayList<Player> getRequestSent(String username);

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public abstract boolean sendFriendRequest(String username1, String username2);

}