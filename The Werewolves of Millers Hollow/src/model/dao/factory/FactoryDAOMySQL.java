/**
 * package model.dao.factory
 */
package model.dao.factory;

/**
 * Imported classes and libraries.
 */
import java.sql.SQLException;
import model.dao.mysql.*;

/**
 * @author Tiffany Dumaire
 */
public class FactoryDAOMySQL extends AbstractFactoryDAO {

    /**
     * Default constructor
     */
    public FactoryDAOMySQL() {
    	super();
    }

    /**
     * @return
     * @throws SQLException
     */
    public UserDAO createUserDAO() throws SQLException {
		return new UserDAOMySQL();
    }
    
    /**
     * @return
     */
    public ReportDAO createReportDAO() {
    	return new ReportDAOMySQL();
    }

    /**
     * @return
     */
    public GameManagementDAO createGameManagementDAO() {
    	return new GameManagementDAOMySQL() ;
    }

    /**
     * @return
     */
    public PlayerInGameDAO createPlayerInGameDAO(){
    	return new PlayerInGameDAOMySQL() ;
    }

    /**
     * @return
     */
    public FriendManagementDAO createFriendManagementDAO() {
    	return new FriendManagementDAOMySQL();
    }

    /**
     * @return
     */
    public SelectAndJoinAGameDAO createSelectAndJoinAGameDAO() {
    	return new SelectAndJoinAGameDAOMySQL();
    }

}