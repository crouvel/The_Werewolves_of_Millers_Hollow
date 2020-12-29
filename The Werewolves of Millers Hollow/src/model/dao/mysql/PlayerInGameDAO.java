package model.dao.mysql;

import java.sql.SQLException;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public abstract class PlayerInGameDAO {

    /**
     * Default constructor
     */
    public PlayerInGameDAO() {
    }



    /**
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean proposeAsASheriff(String username) throws SQLException;

}