package model.dao.mysql;

import java.util.*;
import businesslogic.domain.Game;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class SelectAndJoinAGameDAOMySQL extends SelectAndJoinAGameDAO {

    /**
     * Default constructor
     */
    public SelectAndJoinAGameDAOMySQL() {
    }

    /**
     * @param game_id 
     * @return
     */
    public Game getGameById(int game_id) {
    	return new Game();
    }

    /**
     * @return
     */
    public ArrayList<Game> getAvailableGameList(){
    	return new ArrayList<Game>();
    }

    /**
     * @param game_id 
     * @return
     */
    public boolean makePlayerJoinAGameByGameId(int game_id) {
    	return true;
    }

}