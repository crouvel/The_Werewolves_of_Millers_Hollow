package businesslogic.facade;

import java.sql.SQLException;

import businesslogic.systemelement.User;
import model.dao.factory.FactoryDAOMySQL;
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
     * @param email 
     * @param password 
     * @return
     * @throws SQLException 
     */
    public User login(String email, String password) throws SQLException {
    	UserDAO userDAOMySQL = FactoryDAOMySQL.getInstance().createUserDAO();
        return userDAOMySQL.getUserByLogin(email,password);
    }

    /**
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
     * @return
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * @return
     */
    public int getCurrentUserId() {
        return currentUser.getId();
    }

    /**
     * @return
     */
    public String getCurrentUserEmail() {
        return currentUser.getEmail();
    }

}