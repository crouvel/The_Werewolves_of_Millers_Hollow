/**
 * package businesslogic.facade
 */
package businesslogic.facade;

/**
 * Imported classes and libraries.
 */
import java.io.IOException;
import java.sql.SQLException;
/**
 * Imported classes and libraries.
 */
import java.util.*;
import businesslogic.domain.Game;
import businesslogic.domain.PlayerInGame;
import model.dao.factory.AbstractFactoryDAO;
import model.dao.mysql.SelectAndJoinAGameDAO;

/**
 * @author Tiffany Dumaire, Aaron Lazaroo, Clarence Rouvel
 */
public class SelectAndJoinAGameFacade {

    /**
     * Default constructor
     */
    public SelectAndJoinAGameFacade() {}

    /**
     * Return the game representing by the game Id in parameter
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
     * Return the list of available games
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
     * Allows the player to join a game
     * @param game_id 
     * @return
     * @throws IOException 
     */
    public boolean joinAGame(int game_id) throws IOException {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		SelectAndJoinAGameDAO joinAGameDAO  = factoryTest.createSelectAndJoinAGameDAO();
    		return joinAGameDAO.makePlayerJoinAGameByGameId(game_id);
    	}catch(SQLException e) {
    		return false;
    	}
    }
    
    /**
     * Allows the game creator to join his created game
     * @param game_id 
     * @return
     * @throws IOException 
     */
    public boolean joinAGameCreator(int game_id) throws IOException {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		SelectAndJoinAGameDAO joinAGameDAO  = factoryTest.createSelectAndJoinAGameDAO();
    		return joinAGameDAO.makePlayerJoinAGameByGameIdCreator(game_id);
    	}catch(SQLException e) {
    		return false;
    	}
    }
    
    /**
     * Returns a player in game corresponding to the parameters
     * @param gameId
     * @param username
     * @return
     */
    public PlayerInGame getPlayerInGame(int gameId, String username) {
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		SelectAndJoinAGameDAO joinAGameDAO  = factoryTest.createSelectAndJoinAGameDAO();
    		return joinAGameDAO.getPlayerInGame(gameId,username);
    	}catch(SQLException e) {
    		return null;
    	}
    }

}