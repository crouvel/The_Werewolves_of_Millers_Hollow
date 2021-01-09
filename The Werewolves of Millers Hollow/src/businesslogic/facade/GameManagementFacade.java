/**
 * package businesslogic.facade
 */
package businesslogic.facade;

/**
 * Imported classes and libraries.
 */
import java.sql.SQLException;
import java.util.ArrayList;

import businesslogic.domain.Game;
import model.dao.factory.AbstractFactoryDAO;
import model.dao.mysql.GameManagementDAO;

/**
 * @author Tiffany Dumaire, Aaron Lazaroo, Clarence Rouvel
 */
public class GameManagementFacade {

	/**
	 * Default constructor
	 */
	public GameManagementFacade() {}

	/**
	 * Creates a game trough delegation to the GameManagementDAO.
	 * @param numberOfPlayers 
	 * @param status 
	 * @return boolean which is true if the action was made, otherwise false is returned.
	 */
	public boolean createGame(int nbplayers, boolean status, String creator) {
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();	
			return gameManagementDAO.createGame(nbplayers, status, creator);
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}    
	}

	/**
	 * Deletes a game through delegation to the GameManagementDAO.
	 * @param game_id 
	 * @return boolean which is true if the action was made, otherwise false is returned.
	 */
	public boolean deleteGame(int game_id) {
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();	
			return gameManagementDAO.deleteGame(game_id);
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}  
	}
	
	/**
	 * Deletes a game through delegation to the GameManagementDAO.
	 * @param game_id 
	 * @return boolean which is true if the action was made, otherwise false is returned.
	 */
	public boolean deleteGame2(String creatorUsername) {
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();	
			return gameManagementDAO.deleteGame2(creatorUsername);
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}  
	}

	/**
	 * Creates a game request through delegation to the GameManagementDAO.
	 * @param game_id 
	 * @param username 
	 * @return boolean which is true if the action was made, otherwise false is returned.
	 */
	public boolean inviteFriendToPlay(int game_id, String username1, String username2) {
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();	
			return gameManagementDAO.inviteFriendToPlay(game_id, username1, username2);
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}      
	}

	/**
	 * Deletes a game request through delegation to the GameManagementDAO.
	 * @param game_id 
	 * @param username 
	 * @return a boolean which is true if the wanted action is made, otherwise false is returned.
	 */
	public boolean cancelRequest(int game_id, String username1, String username2) {
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();	
			return gameManagementDAO.cancelRequest(game_id, username1, username2);
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}    
	}

	/**
	 * Creates PlayerInGame from a game through delegation to the GameManagementDAO.
	 * @param game_id 
	 * @param username 
	 * @return a boolean which is true if the action is made, otherwise false is returned.
	 */
	public boolean kickPlayerOfTheGame(int game_id, String username) {
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();	
			return gameManagementDAO.kickPlayerOutOfTheGame(game_id, username);
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}    
	}

	/**
	 * Modifies a game roles through delegation to the GameManagementDAO.
	 * @param numberOfWerewolves 
	 * @param hasWitch 
	 * @param hasFortuneTeller 
	 * @param hasLittleGirl 
	 * @param hasCupid 
	 * @param hasHunter 
	 * @return a boolean which is true if the action is made, otherwise false is returned.
	 * 
	 */
	public boolean modifyRole(int game_id, int numberOfWerewolves, boolean hasWitch, boolean hasFortuneTeller, boolean hasLittleGirl, boolean hasCupid, boolean hasHunter) {
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();	
			return gameManagementDAO.modifyRole(game_id, numberOfWerewolves, hasWitch, hasFortuneTeller, hasLittleGirl, hasCupid, hasHunter);
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}   
	}

	/**
	 * Searches the game through delegation to the GameManagementDAO.
	 * @param username
	 * @return the Game corresponding to its game creator.
	 * @catch SQLException
	 * 
	 */
	public Game getGameByCreator(String username) {
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();	
			return gameManagementDAO.getGameByCreator(username);
		}catch(SQLException e) {
			e.getStackTrace();
			return null;
		}  
	}
	
	/**
	 * Gets the game through delegation to the GameManagementDAO.
	 * @param username
	 * @return the Game corresponding to its game id.
	 * @catch SQLException
	 * 
	 */
	public Game getGame(int gameId) {
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();	
			return gameManagementDAO.getGame(gameId);
		}catch(SQLException e) {
			e.getStackTrace();
			return null;
		}  
	}


	/**
	 * Gets all the PlayerInGame invited to a game by another one through delegation to the GameManagementDAO.
	 * @param username 
	 * @return an ArrayList of all the Players invited in the game for each PlayerInGame.
	 * @throws SQLException
	 * 
	 */
	public ArrayList<String> getInvitedFriendList(int gameId, String username) throws SQLException{
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();
			return gameManagementDAO.getInvitedFriend(gameId, username);
		}catch(SQLException e) {
			return null;
		}    	
	}

	/**
	 * Gets all the PlayerInGame in a game through delegation to the GameManagementDAO.
	 * @param username 
	 * @return an ArrayList of all the PlayerInGame in the Game Management view for all the PlayerInGame. 
	 * @throws SQLException
	 * 
	 */
	public ArrayList<String> getPlayerList(int game_id) throws SQLException {
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();
			return gameManagementDAO.getPlayer(game_id);
		}catch(SQLException e) {
			return null;
		}   
	}
	
	/**
	 * Checks if game exists through delegation to the GameManagementDAO.
	 * @param creatorUsername
	 * @return a boolean which is true if the action is made, otherwise false is returned.
	 * @catch SQLException
	 * 
	 */
	public boolean existsGameByUsername(String creatorUsername) {
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();
			return gameManagementDAO.existsGame2(creatorUsername);
		}catch(SQLException e) {
			return false;
		} 
	}
	
	/**
	 * Modify the PlayerInGame information through delegation to the GameManagementDAO.
	 * @param gameId
	 * @param username
	 * @param role
	 * @return a boolean which is true if the action is made, otherwise false is returned.
	 * @catch SQLException
	 * 
	 */
	public boolean modifyPlayerInGame(int gameId, String username, String role) {
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();
			return gameManagementDAO.updatePlayerInGame(gameId, username,role);
		}catch(SQLException e) {
			return false;
		} 
	}

}