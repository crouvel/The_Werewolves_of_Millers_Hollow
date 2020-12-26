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
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
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
     * @param username 
     * @return
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
     * 
     * @param username
     * @return
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