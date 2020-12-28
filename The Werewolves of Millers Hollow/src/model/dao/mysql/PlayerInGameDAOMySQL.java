package model.dao.mysql;


/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class PlayerInGameDAOMySQL extends PlayerInGameDAO {

    /**
     * Default constructor
     */
    public PlayerInGameDAOMySQL() {
    }

    /**
     * @param username 
     * @return
     */
    
    public boolean proposeAsASheriff(String username) {
    	return true;
    }

}