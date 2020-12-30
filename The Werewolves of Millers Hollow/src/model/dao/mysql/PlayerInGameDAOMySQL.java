/**
 * package model.dao.mysql
 */
package model.dao.mysql;

import java.sql.SQLException;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
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