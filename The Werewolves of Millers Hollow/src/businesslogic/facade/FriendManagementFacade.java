package businesslogic.facade;

import java.sql.SQLException;
import java.util.*;
import businesslogic.domain.Player;
import model.dao.factory.AbstractFactoryDAO;
import model.dao.mysql.FriendManagementDAO;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class FriendManagementFacade {

    /**
     * 
     */
    private Player currentPlayer;

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean sendRequest(String username1, String username2) {
    	// TODO implement here
        return false;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean acceptFriendRequest(String username1, String username2) {
        // TODO implement here
        return false;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean cancelFriendRequest(String username1, String username2) {
        // TODO implement here
        return false;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean deleteFriend(String username1, String username2) {
        // TODO implement here
        return false;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean refuseFriendRequest(String username1, String username2) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * @return
     */
    public String getCurrentPlayerUsername() {
        return this.currentPlayer.getUsername();
    }

    /**
     * @param username 
     * @return
     * @throws SQLException
     */
    public ArrayList<String> getFriendList(String username) throws SQLException{
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		FriendManagementDAO frienManagementDAO  = factoryTest.createFriendManagementDAO();
    		return frienManagementDAO.getFriendList(username);
    	}catch(SQLException e) {
    		return null;
    	}    	
    }

    /**
     * @param username 
     * @return
     * @throws SQLException
     */
    public ArrayList<String> getReceivedFriendRequests(String username) throws SQLException {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		FriendManagementDAO frienManagementDAO  = factoryTest.createFriendManagementDAO();
    		return frienManagementDAO.getReceivedFriendRequests(username);
    	}catch(SQLException e) {
    		return null;
    	}   
    }
    
    /**
     * @param username 
     * @return
     * @throws SQLException
     */
    public ArrayList<String> getSentFriendRequests(String username) throws SQLException {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		FriendManagementDAO frienManagementDAO  = factoryTest.createFriendManagementDAO();
    		return frienManagementDAO.getRequestSent(username);
    	}catch(SQLException e) {
    		return null;
    	}   
    }

}