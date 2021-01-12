/**
 * package businesslogic.facade
 */
package businesslogic.facade;

/**
 * Imported classes and libraries.
 */
import businesslogic.domain.Administrator;
import model.dao.factory.AbstractFactoryDAO;
import model.dao.mysql.UserDAO;
import java.sql.SQLException;


/**
 * @author Tiffany Dumaire, Aaron Lazaroo, Clarence Rouvel
 */
public class BlockAPlayerFacade {

    /**
     * Default constructor
     */
    public BlockAPlayerFacade() {
    }

    /**
     * 
     */
    private Administrator currentAdmin;

    /**
     * Allows the administrator to block a player
     * @param username 
     * @return true if it's done, else false
     */
    public boolean blockAPlayer(String username) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		UserDAO userDAO  = factory.createUserDAO();	
    		return userDAO.updateBlockPlayer(username);
    	}catch(SQLException e) {
    		e.getStackTrace();
    		return false;
    	}  
    }
    
    /**
     * Search and return if the Player exists
     * @param username
     * @return true if exists, else false
     */
    public boolean existsPlayer(String username) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		UserDAO userDAO  = factory.createUserDAO();	
    		return userDAO.existsUsername(username);
    	}catch(SQLException e) {
    		e.getStackTrace();
    		return false;
    	}  
    }

	/**
	 * @return the currentAdmin
	 */
	public Administrator getCurrentAdmin() {
		return currentAdmin;
	}

	/**
	 * @param currentAdmin the currentAdmin to set
	 */
	public void setCurrentAdmin(Administrator currentAdmin) {
		this.currentAdmin = currentAdmin;
	}

}