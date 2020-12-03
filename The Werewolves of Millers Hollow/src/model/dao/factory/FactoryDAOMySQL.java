package model.dao.factory;

import java.sql.SQLException;
import model.dao.mysql.UserDAO;
import model.dao.mysql.UserDAOMySQL;

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
     */
    public UserDAO createUserDAO() throws SQLException {
		return new UserDAOMySQL();
    }

}