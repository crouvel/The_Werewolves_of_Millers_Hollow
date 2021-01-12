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
import model.dao.mysql.GameDAO;
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
     * Allows the user to candidate to the sheriff post.
     * @param username 
     * @return true if it's done, else false
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
     * Remove player of the game
     * @param username 
     * @return true if it's done, else false
     */
    public boolean removePlayerInGame(int gameId, String username) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			PlayerInGameDAO playerInGameDAO  = factory.createPlayerInGameDAO();	
			return playerInGameDAO.removePlayerInGame(gameId, username);
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}  
    }

    /**
     * Make a vote from username 1 voted for username2 in the game of game_id
     * @param username1 
     * @param username2 
     * @param game_id 
     * @return true if it's done, else false
     */
    public boolean makeAVote(String username1, String username2, int game_id) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameDAO gameDAO  = factory.createGameDAO();	
			return gameDAO.sendVote(username1, username2,game_id);
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}  
    }

    /**
     * Search and return the list of usernames for which the players are voted.
     * @param game_id 
     * @return all the username voted
     */
    public ArrayList<String> getAllVotes(int game_id) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameDAO gameDAO  = factory.createGameDAO();	
			return gameDAO.getAllVotes(game_id);
		}catch(SQLException e) {
			e.getStackTrace();
			return null;
		}  
    }
    
    /**
     * Return the player in game with the username in parameter who played in the game of gameId in parameter
     * @param gameId
     * @param username
     * @return a PlayerInGame
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
     * Allows two player in game to become lover
     * @param gameId
     * @param username
     * @return true if it's done, else false
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
     * Search and return the list of roles present in the game
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
     * Return an arraylist of string (all the player username in the game)
     * @param game_id 
     * @return an arraylist of string
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
     * Returns the arraylist of usernames of lovers.
     * @param gameId
     * @return an arraylist of string
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
     * Returns the arraylist of player in game in the game.
     * @param game_id 
     * @return an arraylist of player in game
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