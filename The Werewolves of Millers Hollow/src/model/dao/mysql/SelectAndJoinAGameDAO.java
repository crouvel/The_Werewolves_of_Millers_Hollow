package model.dao.mysql;

import java.io.IOException;
import java.sql.SQLException;
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
     * @throws SQLException 
     */
    public abstract Game getGameById(int game_id) throws SQLException;

    /**
     * @return
     * @throws SQLException 
     */
    public abstract ArrayList<Game> getAvailableGameList() throws SQLException;

    /**
     * @param game_id 
     * @return
     * @throws SQLException 
     * @throws IOException 
     */
    public abstract boolean makePlayerJoinAGameByGameId(int game_id) throws SQLException, IOException;

}