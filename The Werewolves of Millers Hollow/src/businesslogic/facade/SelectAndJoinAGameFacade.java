/**
 * package businesslogic.facade
 */
package businesslogic.facade;

import java.sql.SQLException;
/**
 * Imported classes and libraries.
 */
import java.util.*;
import businesslogic.domain.Game;
import model.dao.factory.AbstractFactoryDAO;
import model.dao.mysql.SelectAndJoinAGameDAO;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class SelectAndJoinAGameFacade {

    /**
     * Default constructor
     */
    public SelectAndJoinAGameFacade() {}

    /**
     * 
     * @param gameId
     * @return
     */
    public Game getGame(int gameId) {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		SelectAndJoinAGameDAO joinAGameDAO  = factoryTest.createSelectAndJoinAGameDAO();
    		return joinAGameDAO.getGameById(gameId);
    	}catch(SQLException e) {
    		return null;
    	}
    }

    /**
     * @return
     */
    public ArrayList<Game> getGamesList() {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		SelectAndJoinAGameDAO joinAGameDAO  = factoryTest.createSelectAndJoinAGameDAO();
    		return joinAGameDAO.getAvailableGameList();
    	}catch(SQLException e) {
    		return null;
    	}
    }
    
    /**
     * @param game_id 
     * @return
     */
    public boolean joinAGame(int game_id) {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		SelectAndJoinAGameDAO joinAGameDAO  = factoryTest.createSelectAndJoinAGameDAO();
    		return joinAGameDAO.makePlayerJoinAGameByGameId(game_id);
    	}catch(SQLException e) {
    		return false;
    	}
    }

}