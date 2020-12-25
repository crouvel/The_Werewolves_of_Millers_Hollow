package model.dao.mysql;

import java.util.*;
import businesslogic.domain.Player;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class FriendManagementDAOMySQL extends FriendManagementDAO {

    /**
     * Default constructor
     */
    public FriendManagementDAOMySQL() {
    }

    /**
     * @param username 
     * @return
     */
    public ArrayList<Player> getReceivedFriendRequests(String username){
    	return new ArrayList<Player>();
    }

    /**
     * @param username 
     * @return
     */
    public ArrayList<Player> getFriendList(String username){
    	return new ArrayList<Player>();
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean deleteRequest(String username1, String username2) {
    	return true;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean deleteFromFriendList(String username1, String username2) {
    	return true;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean refuseRequest(String username1, String username2) {
    	return true;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean addFriendInList(String username1, String username2) {
    	return true;
    }

    /**
     * @param username 
     * @return
     */
    public ArrayList<Player> getRequestSent(String username){
    	return new ArrayList<Player>();
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean sendFriendRequest(String username1, String username2) {
    	return true;
    }

}