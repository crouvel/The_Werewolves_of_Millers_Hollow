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

    @Override
    public UserDAO createUserDAO() throws SQLException {
		return new UserDAOMySQL();
    }
    
    @Override
    public ReportDAO createReportDAO() throws SQLException {
    	return new ReportDAOMySQL();
    }

    @Override
    public GameManagementDAO createGameManagementDAO() throws SQLException {
    	return new GameManagementDAOMySQL() ;
    }

    @Override
    public PlayerInGameDAO createPlayerInGameDAO() throws SQLException {
    	return new PlayerInGameDAOMySQL() ;
    }

    @Override
    public FriendManagementDAO createFriendManagementDAO() throws SQLException {
    	return new FriendManagementDAOMySQL();
    }

    @Override
    public SelectAndJoinAGameDAO createSelectAndJoinAGameDAO() throws SQLException {
    	return new SelectAndJoinAGameDAOMySQL();
    }

	@Override
	public GameDAO createGameDAO() throws SQLException {
		return new GameDAOMySQL();
	}

}