/**
 * package businesslogic.facade
 */
package businesslogic.facade;

import java.io.IOException;
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
     * @param username 
     * @param email 
     * @param password 
     * @param country 
     * @return
     * @throws IOException 
     */
    public boolean modifyPlayerProfile(String username, String email, String password, String country) throws IOException {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		UserDAO userDAO  = factoryTest.createUserDAO();
    		return userDAO.updatePlayerProfile(username,email,password,country);
    	}catch(SQLException e) {
    		return false;
    	}
    }

    /**
     * @param email 
     * @param password 
     * @return
     * @throws IOException 
     */
    public boolean modifyAdministratorProfile(String email, String password) throws IOException {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		UserDAO userDAO  = factoryTest.createUserDAO();
    		return userDAO.updateAdministratorProfile(email,password);
    	}catch(SQLException e) {
    		return false;
    	}
    }

    /**
     * @param playerEmail 
     * @return
     */
    public boolean deleteUserByEmail(String playerEmail) {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		UserDAO userDAO  = factoryTest.createUserDAO();
    		return userDAO.deleteUserByEmail(playerEmail);
    	}catch(SQLException e) {
    		return false;
    	}
    }

    /**
     * @param username 
     * @return
     */
    public boolean deletePlayerByUsername(String username) {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		UserDAO userDAO  = factoryTest.createUserDAO();
    		return userDAO.deletePlayerByUsername(username);
    	}catch(SQLException e) {
    		return false;
    	}
    }

    /**
     * @param adminEmail
     * @return 
     */
    public boolean deleteAdministratorByEmail(String adminEmail) {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		UserDAO userDAO  = factoryTest.createUserDAO();
    		return userDAO.deleteUserByEmail(adminEmail);
    	}catch(SQLException e) {
    		return false;
    	}
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
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		UserDAO userDAO  = factoryTest.createUserDAO();
    		return userDAO.addAPlayer(username,email,password,dateOfBirth,gender,country);
    	}catch(SQLException e) {
    		return false;
    	}
    }

    /**
     * @param email 
     * @param password 
     * @return
     */
    public boolean registerAdministrator(String email, String password) {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		UserDAO userDAO  = factoryTest.createUserDAO();
    		return userDAO.addAnAdministrator(email,password);
    	}catch(SQLException e) {
    		return false;
    	}
    }

    /**
     * @param username 
     * @return
     */
    public Player searchPlayerStats(String username) {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		UserDAO userDAO  = factoryTest.createUserDAO();
    		return userDAO.getPlayerByUsername(username);
    	}catch(SQLException e) {
    		return null;
    	} 
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
    public ArrayList<String> getCorrespondingPlayers(String username, int played, int won, int lost, boolean maxPlayed, boolean maxWin, boolean maxLost) throws SQLException {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		UserDAO userDAO  = factoryTest.createUserDAO();
    		return userDAO.getCorrespondingPlayer(username,played,won,lost,maxPlayed,maxWin,maxLost);
    	}catch(SQLException e) {
    		return null;
    	} 
    }
    
    public Administrator getAdminByLogin(String username, String password) throws SQLException {
        AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
        try {
            UserDAO userDAO  = factoryTest.createUserDAO();
            return userDAO.getAdminByLogin(username,password);
        }catch(SQLException e) {
            return null;
        }
    }
    
}