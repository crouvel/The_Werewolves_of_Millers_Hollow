/**
 * package model.dao.factory
 */
package model.dao.factory;

/**
 * Imported classes and libraries.
 */
import java.sql.Connection;
import java.sql.SQLException;

import model.dao.mysql.*;
import util.ConnectionUtil;

/**
 * @author Tiffany Dumaire
 */
public abstract class AbstractFactoryDAO {

    /**
     * 
     */
    public static AbstractFactoryDAO instance = null;

    /**
     * 
     */
    private static Connection connection=null;

    /**
     * Constructor of AbstractFactoryDAO
     */
    public AbstractFactoryDAO() {
    	if(getConnection()==null) {
    	    connection=ConnectionUtil.connectionDatabase();
    	}
    }
    
    /**
     * @return
     */
    public static Connection getConnection() {
        return AbstractFactoryDAO.connection;
    }
    
    
    /**
     * @return
     */
    public static AbstractFactoryDAO getInstance() {
    	if(instance==null) {
    		instance = new FactoryDAOMySQL();
    	}
        return instance;
    }

    /**
     * @param factory
     */
    public void setInstance(AbstractFactoryDAO factory) {
        instance=factory;
    }

    /**
     * Create a userDAO
     * @return
     */
    public abstract UserDAO createUserDAO() throws SQLException;

    /**
     * Create a reportDAO
     * @return
     * @throws SQLException 
     */
    public abstract ReportDAO createReportDAO() throws SQLException;


    /**
     * Create a gameManagementDAO
     * @return
     * @throws SQLException 
     */
    public abstract GameManagementDAO createGameManagementDAO() throws SQLException;
    
    /**
     * create a gameDAO
     * @return
     * @throws SQLException 
     */
    public abstract GameDAO createGameDAO() throws SQLException;

    /**
     * Create a playerInGameDAO
     * @return
     * @throws SQLException 
     */
    public abstract PlayerInGameDAO createPlayerInGameDAO() throws SQLException;

    /**
     * Create a friendManagementDAO
     * @return
     * @throws SQLException 
     */
    public abstract FriendManagementDAO createFriendManagementDAO() throws SQLException;

    /**
     * Create a selectAndJoinAGameDAO
     * @return
     * @throws SQLException 
     */
    public abstract SelectAndJoinAGameDAO createSelectAndJoinAGameDAO() throws SQLException;
}