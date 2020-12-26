package model.dao.mysql;

import java.util.*;
import businesslogic.domain.Game;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public abstract class SelectAndJoinAGameDAO {

    /**
     * Default constructor
     */
    public SelectAndJoinAGameDAO() {
    }


    /**
     * @param game_id 
     * @return
     */
    public abstract Game getGameById(int game_id);

    /**
     * @return
     */
    public abstract ArrayList<Game> getAvailableGameList();

    /**
     * @param game_id 
     * @return
     */
    public abstract boolean makePlayerJoinAGameByGameId(int game_id);

}