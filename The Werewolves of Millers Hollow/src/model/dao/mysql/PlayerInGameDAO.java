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
public abstract class PlayerInGameDAO {

    /**
     * Default constructor
     */
    public PlayerInGameDAO() {}

    /**
     * 
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean proposeAsASheriff(String username) throws SQLException;

}