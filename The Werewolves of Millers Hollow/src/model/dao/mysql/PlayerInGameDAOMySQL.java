/**
 * package model.dao.mysql
 */
package model.dao.mysql;

/**
 * Imported classes and libraries.
 */
import java.sql.SQLException;

/**
 * @author Tiffany Dumaire
 */
public class PlayerInGameDAOMySQL extends PlayerInGameDAO {

    /**
     * Default constructor
     */
    public PlayerInGameDAOMySQL() {}

    @Override
    public boolean proposeAsASheriff(String username) throws SQLException {
    	return true;
    }

}