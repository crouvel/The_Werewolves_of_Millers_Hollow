package model.dao.factory;

import java.sql.Connection;

import model.dao.mysql.UserDAO;
import util.ConnectionUtil;

/**
 * @author Tiffany Dumaire
 */
public class FactoryDAOMySQL extends AbstractFactoryDAO {

    /**
     * Default constructor
     */
    public FactoryDAOMySQL() {
    	if(connection==null) {
    		connection=ConnectionUtil.connectionDatabase();
    	}
    }

    /**
     * 
     */
    private static Connection connection=null;

    /**
     * @return
     */
    public static Connection getConnection() {
    	Connection getStaticConnectionAttribute = FactoryDAOMySQL.connection;
        return getStaticConnectionAttribute;
    }

    /**
     * @return
     */
    public UserDAO createUserDAO() {
    	return null;
    }

}