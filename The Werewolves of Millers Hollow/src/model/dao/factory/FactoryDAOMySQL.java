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
    public ReportDAO createReportDAO() throws SQLException {
    	return new ReportDAOMySQL();
    }

    /**
     * @return
     */
    public GameManagementDAO createGameManagementDAO() throws SQLException {
    	return new GameManagementDAOMySQL() ;
    }

    /**
     * @return
     */
    public PlayerInGameDAO createPlayerInGameDAO() throws SQLException {
    	return new PlayerInGameDAOMySQL() ;
    }

    /**
     * @return
     */
    public FriendManagementDAO createFriendManagementDAO() throws SQLException {
    	return new FriendManagementDAOMySQL();
    }

    /**
     * @return
     */
    public SelectAndJoinAGameDAO createSelectAndJoinAGameDAO() throws SQLException {
    	return new SelectAndJoinAGameDAOMySQL();
    }

	@Override
	public GameDAO createGameDAO() throws SQLException {
		return new GameDAOMySQL();
	}

}