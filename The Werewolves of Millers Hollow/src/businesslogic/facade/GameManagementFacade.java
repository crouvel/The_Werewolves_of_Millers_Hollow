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
	 * 
	 * @param numberOfPlayers 
	 * @param status 
	 * @return
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
	 * 
	 * @param game_id 
	 * @return
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
	 * 
	 * @param game_id 
	 * @return
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
	 * 
	 * @param game_id 
	 * @param username 
	 * @return
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
	 * 
	 * @param game_id 
	 * @param username 
	 * @return
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
	 * 
	 * @param game_id 
	 * @param username 
	 * @return
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
	 * 
	 * @param numberOfWerewolves 
	 * @param hasWitch 
	 * @param hasFortuneTeller 
	 * @param hasLittleGirl 
	 * @param hasCupid 
	 * @param hasHunter 
	 * @return
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
	 * 
	 * @param username
	 * @return
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
	 * 
	 * @param username
	 * @return
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
	 * 
	 * @param username 
	 * @return
	 * @throws SQLException
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
	 * 
	 * @param username 
	 * @return
	 * @throws SQLException
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
	
	public boolean existsGameByUsername(String creatorUsername) {
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();
			return gameManagementDAO.existsGame2(creatorUsername);
		}catch(SQLException e) {
			return false;
		} 
	}

}