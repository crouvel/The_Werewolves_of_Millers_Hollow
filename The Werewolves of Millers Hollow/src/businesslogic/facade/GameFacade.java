/**
 * package businesslogic.facade
 */
package businesslogic.facade;

/**
 * Imported classes and libraries.
 */
import java.sql.SQLException;
import java.util.*;

import businesslogic.domain.PlayerInGame;
import model.dao.factory.AbstractFactoryDAO;
import model.dao.mysql.PlayerInGameDAO;
import model.dao.mysql.ReportDAO;

/**
 * @author Tiffany Dumaire
 */
public class GameFacade {

    /**
     * Default constructor
     */
    public GameFacade() {}

    /**
     * Send the player report through delegation to the ReportDAO.
     * @param badPlayerUsername 
     * @param reason 
     * @param description 
     * @return boolean true, if the action is executed.
     */
    public boolean sendPlayerReport(String badPlayerUsername, String reason, String description) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			ReportDAO reportDAO  = factory.createReportDAO();
			return reportDAO.createPlayerReport(badPlayerUsername, reason, description);
		}catch(SQLException e) {
			return false;
		} 
    }

    /**
     * 
     * @param username 
     * @return
     */
    public boolean proposeAsASheriff(int gameId, String username) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			PlayerInGameDAO playerInGameDAO  = factory.createPlayerInGameDAO();	
			return playerInGameDAO.proposeAsASheriff(gameId, username);
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}  
    }

    /**
     * 
     * @param username1 
     * @param username2 
     * @param game_id 
     * @return
     */
    public boolean makeAVote(String username1, String username2, int game_id) {
        // TODO implement here
        return false;
    }

    /**
     * 
     * @param game_id 
     * @return
     */
    public ArrayList<String> getAllVotes(int game_id) {
        // TODO implement here
        return null;
    }
    
    /**
     * 
     * @param gameId
     * @param username
     * @return
     */
    public PlayerInGame getPlayerInGame(int gameId,String username) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			PlayerInGameDAO playerInGameDAO  = factory.createPlayerInGameDAO();	
			return playerInGameDAO.getPlayerInGame(gameId, username);
		}catch(SQLException e) {
			e.getStackTrace();
			return null;
		}  
    }

    /**
     * 
     * @param gameId
     * @param username
     * @return
     */
    public boolean becomeLover(int gameId, String username) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			PlayerInGameDAO playerInGameDAO  = factory.createPlayerInGameDAO();	
			return playerInGameDAO.becomeLover(gameId, username);
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}  
    }
    
    /**
     * 
     * @param game_id 
     * @return
     */
    public ArrayList<String> getRoleList(int gameId) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			PlayerInGameDAO playerInGameDAO  = factory.createPlayerInGameDAO();	
			return playerInGameDAO.getRoleList(gameId);
		}catch(SQLException e) {
			e.getStackTrace();
			return null;
		}
    }
    
    /**
     * 
     * @param game_id 
     * @return
     */
    public ArrayList<String> getPlayerList(int gameId) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			PlayerInGameDAO playerInGameDAO  = factory.createPlayerInGameDAO();	
			return playerInGameDAO.getPlayerList(gameId);
		}catch(SQLException e) {
			e.getStackTrace();
			return null;
		}
    }
    
    /**
     * 
     * @param gameId
     * @return
     */
    public ArrayList<String> getPlayerInLove(int gameId) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			PlayerInGameDAO playerInGameDAO  = factory.createPlayerInGameDAO();	
			return playerInGameDAO.getPlayerInLove(gameId);
		}catch(SQLException e) {
			e.getStackTrace();
			return null;
		}
    }
    
    /**
     * 
     * @param game_id 
     * @return
     */
    public ArrayList<PlayerInGame> getPlayerInGameList(int gameId) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			PlayerInGameDAO playerInGameDAO  = factory.createPlayerInGameDAO();	
			return playerInGameDAO.getPlayerInGameList(gameId);
		}catch(SQLException e) {
			e.getStackTrace();
			return null;
		}
    }
}