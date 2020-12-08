/**
 * 
 */
package model.dao.mysql;

/**
 * 
 */
import java.sql.SQLException;

import businesslogic.systemelement.User;
/**
 * @author Tiffany Dumaire
 */
public abstract class UserDAO {

    /**
     * Default constructor
     */
    public UserDAO() {
    
    }

    /**
     * @param userId 
     * @return
     */
    public abstract User getUserById(int userId);

    /**
     * @param email 
     * @return
     * @throws SQLException 
     */
    public abstract User getUserByEmail(String email) throws SQLException;
    
    /**
     * @param email 
     * @param password
     * @return
     * @throws SQLException 
     */
    public abstract User getUserByLogin(String email,String password) throws SQLException;
    
    /**
     * 
     * @param email
     * @return
     * @throws SQLException 
     */
    public abstract boolean exist(String email) throws SQLException;

}