package model.dao.mysql;

import businesslogic.systemelement.User;

/**
 * @author Tiffany Dumaire
 */
public class UserDAOMySQL extends UserDAO{

    /**
     * Default constructor
     */
    public UserDAOMySQL() {
    }

    /**
     * @param userId 
     * @return
     */
    public User getUserById(int userId) {
    	return null;
    }

    /**
     * @param email 
     * @return
     */
    public User getUserByEmail(String email) {
    	return null;
    }
    
    public boolean exist(String email) {
    	return false;
    }

}