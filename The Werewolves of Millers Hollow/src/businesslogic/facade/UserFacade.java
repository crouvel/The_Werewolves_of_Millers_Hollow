/**
 * package businesslogic.facade
 */
package businesslogic.facade;

import java.sql.Date;
/**
 * Imported classes and libraries.
 */
import java.sql.SQLException;
import java.util.ArrayList;

import businesslogic.domain.User;
import businesslogic.domain.Administrator;
import businesslogic.domain.Player;
import model.dao.factory.AbstractFactoryDAO;
import model.dao.mysql.UserDAO;


/**
 * @author Tiffany Dumaire
 */
public class UserFacade {

    /**
     * 
     */
    private User currentUser;


    /**
     * Allows the user to log in using their email and password.
     * @param email 
     * @param password 
     * @return
     * @throws SQLException 
     */
    public User login(String email, String password) throws SQLException {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		UserDAO userDAO  = factoryTest.createUserDAO();
    		return userDAO.getUserByLogin(email,password);
    	}catch(SQLException e) {
    		return null;
    	}
    }

    public Player getPlayer(User user) throws SQLException {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		UserDAO userDAO  = factoryTest.createUserDAO();
    		return userDAO.getPlayer(user);
    	}catch(SQLException e) {
    		return null;
    	} 
    }
    
    public Administrator getAdmin(User user) throws SQLException {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		UserDAO userDAO  = factoryTest.createUserDAO();
    		return userDAO.getAdmin(user);
    	}catch(SQLException e) {
    		return null;
    	} 
    }
    
    
    /**
     * 
     * @param email 
     * @param password 
     * @return
     * @throws SQLException 
     */
    public User register(String email, String password) throws SQLException {
        //@Not Implemented    	
    	return currentUser;
    }

    /**
     * 
     * @return
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * 
     * @return
     */
    public int getCurrentUserId() {
        return currentUser.getId();
    }

    /**
     * 
     * @return
     */
    public String getCurrentUserEmail() {
        return currentUser.getEmail();
    }
    
    /**
     * @param username 
     * @param email 
     * @param password 
     * @param country 
     * @return
     */
    public boolean modifyPlayerProfile(String username, String email, String password, String country) {
        // TODO implement here
        return false;
    }

    /**
     * @param email 
     * @param password 
     * @return
     */
    public boolean modifyAdministratorProfile(String email, String password) {
        // TODO implement here
        return false;
    }

    /**
     * @param playerEmail 
     * @return
     */
    public boolean deleteUserByEmail(String playerEmail) {
        // TODO implement here
        return false;
    }

    /**
     * @param username 
     * @return
     */
    public boolean deletePlayerByUsername(String username) {
        // TODO implement here
        return false;
    }

    /**
     * 
     */
    public void registerAdministrator() {
        // TODO implement here
    }

    /**
     * 
     */
    public void registerPlayer() {
        // TODO implement here
    }

    /**
     * @param adminEmail
     */
    public void deleteAdministratorByEmail(String adminEmail) {
        // TODO implement here
    }

    /**
     * @param username 
     * @param email 
     * @param password 
     * @param dateOfBirth 
     * @param gender 
     * @param country 
     * @return
     */
    public boolean registerPlayer(String username, String email, String password, Date dateOfBirth, String gender, String country) {
        // TODO implement here
        return false;
    }

    /**
     * @param email 
     * @param password 
     * @return
     */
    public boolean registerAdministrator(String email, String password) {
        // TODO implement here
        return false;
    }

    /**
     * @param username 
     * @return
     */
    public boolean searchPlayerStats(String username) {
        // TODO implement here
        return false;
    }

    /**
     * @param username 
     * @param player 
     * @param win 
     * @param lost 
     * @param maxPlayed 
     * @param maxWin 
     * @param maxLost 
     * @return
     */
    public ArrayList<Player> getCorrespondingPlayers(String username, int player, int win, int lost, boolean maxPlayed, boolean maxWin, boolean maxLost) {
        // TODO implement here
        return null;
    }


}