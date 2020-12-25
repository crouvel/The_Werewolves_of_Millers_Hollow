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
     * 
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
     * @return
     */
    public abstract UserDAO createUserDAO() throws SQLException;

    /**
     * @return
     */
    public abstract ReportDAO createReportDAO();


    /**
     * @return
     */
    public abstract GameManagementDAO createGameManagementDAO();

    /**
     * @return
     */
    public abstract PlayerInGameDAO createPlayerInGameDAO();

    /**
     * @return
     */
    public abstract FriendManagementDAO createFriendManagementDAO();

    /**
     * @return
     */
    public abstract SelectAndJoinAGameDAO createSelectAndJoinAGameDAO();
}