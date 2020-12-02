package model.dao.factory;

import java.sql.Connection;

import model.dao.mysql.UserDAO;

/**
 * @author Tiffany Dumaire
 */
public class FactoryDAOMySQL extends AbstractFactoryDAO {

    /**
     * Default constructor
     */
    public FactoryDAOMySQL() {
    }

    /**
     * 
     */
    protected Connection connection;

    /**
     * @return
     */
    public Connection getConnection() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public UserDAO createUserDAO() {
    	return null;
    }

}