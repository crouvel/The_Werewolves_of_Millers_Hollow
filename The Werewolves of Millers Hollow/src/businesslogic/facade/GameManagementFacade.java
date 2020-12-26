package businesslogic.facade;

import java.sql.SQLException;

import businesslogic.domain.Game;
import businesslogic.domain.Phase;
import model.dao.factory.AbstractFactoryDAO;
import model.dao.mysql.GameManagementDAO;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class GameManagementFacade {

    /**
     * Default constructor
     */
    public GameManagementFacade() {
    }

    /**
     * 
     */
    




    
    /**
     * @param numberOfPlayers 
     * @param status 
     * @return
     */
    public boolean createGame(int nbplayers, int status) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();	
    		return gameManagementDAO.createGame(nbplayers, status);
    	}catch(SQLException e) {
    		e.getStackTrace();
    		return false;
    	}    
    }

    /**
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
    	}      }

    /**
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
     * @param numberOfWerewolves 
     * @param hasWitch 
     * @param hasFortuneTeller 
     * @param hasLittleGirl 
     * @param hasCupid 
     * @param hasHunter 
     * @return
     */
    public boolean modifyRole(int game_id, int numberOfWerewolves, int hasWitch, int hasFortuneTeller, int hasLittleGirl, int hasCupid, int hasHunter) {
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
	 * @return the currentGame
	 */
	

}