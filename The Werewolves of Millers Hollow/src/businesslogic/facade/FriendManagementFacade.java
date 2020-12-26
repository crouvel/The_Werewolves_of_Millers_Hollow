package businesslogic.facade;

import java.sql.SQLException;
import java.util.*;
import model.dao.factory.AbstractFactoryDAO;
import model.dao.mysql.FriendManagementDAO;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class FriendManagementFacade {

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean sendRequest(String username1, String username2) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		FriendManagementDAO friendManagementDAO  = factory.createFriendManagementDAO();	
    		return friendManagementDAO.sendFriendRequest(username1,username2);
    	}catch(SQLException e) {
    		e.getStackTrace();
    		return false;
    	}  
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean acceptFriendRequest(String username1, String username2) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		FriendManagementDAO friendManagementDAO  = factory.createFriendManagementDAO();	
    		return friendManagementDAO.addFriendInList(username1,username2);
    	}catch(SQLException e) {
    		e.getStackTrace();
    		return false;
    	}
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean cancelFriendRequest(String username1, String username2) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		FriendManagementDAO friendManagementDAO  = factory.createFriendManagementDAO();	
    		return friendManagementDAO.deleteRequest(username1,username2);
    	}catch(SQLException e) {
    		e.getStackTrace();
    		return false;
    	} 
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean deleteFriend(String username1, String username2) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		FriendManagementDAO friendManagementDAO  = factory.createFriendManagementDAO();	
    		return friendManagementDAO.deleteFromFriendList(username1,username2);
    	}catch(SQLException e) {
    		e.getStackTrace();
    		return false;
    	}  
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean refuseFriendRequest(String username1, String username2) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		FriendManagementDAO friendManagementDAO  = factory.createFriendManagementDAO();	
    		return friendManagementDAO.refuseRequest(username1,username2);
    	}catch(SQLException e) {
    		e.getStackTrace();
    		return false;
    	}
    }

    /**
     * @param username 
     * @return
     * @throws SQLException
     */
    public ArrayList<String> getFriendList(String username) throws SQLException{
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		FriendManagementDAO friendManagementDAO  = factory.createFriendManagementDAO();
    		return friendManagementDAO.getFriendList(username);
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
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		FriendManagementDAO friendManagementDAO  = factory.createFriendManagementDAO();
    		return friendManagementDAO.getReceivedFriendRequests(username);
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
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		FriendManagementDAO friendManagementDAO  = factory.createFriendManagementDAO();
    		return friendManagementDAO.getRequestSent(username);
    	}catch(SQLException e) {
    		return null;
    	}   
    }

}