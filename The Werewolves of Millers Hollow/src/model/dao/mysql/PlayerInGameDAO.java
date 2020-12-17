package model.dao.mysql;

import java.util.*;

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
     */
    public abstract boolean proposeAsASheriff(String username);

}