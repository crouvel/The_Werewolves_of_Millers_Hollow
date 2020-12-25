package businesslogic.facade;

import businesslogic.domain.Game;
<<<<<<< HEAD
<<<<<<< HEAD
import businesslogic.domain.Phase;
import model.dao.factory.AbstractFactoryDAO;
import model.dao.mysql.GameManagementDAO;
=======
>>>>>>> parent of 3326ad8... kick player out of game + invite friend to play + begin game management
=======
>>>>>>> parent of 3326ad8... kick player out of game + invite friend to play + begin game management

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
    private static Game currentGame;




    
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
<<<<<<< HEAD
<<<<<<< HEAD
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();	
    		return gameManagementDAO.kickPlayerOutOfTheGame(game_id, username);
    	}catch(SQLException e) {
    		e.getStackTrace();
    		return false;
    	}    
=======
        // TODO implement here
        return false;
>>>>>>> parent of 3326ad8... kick player out of game + invite friend to play + begin game management
=======
        // TODO implement here
        return false;
>>>>>>> parent of 3326ad8... kick player out of game + invite friend to play + begin game management
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
    public boolean modifyRole(int numberOfWerewolves, int hasWitch, int hasFortuneTeller, int hasLittleGirl, int hasCupid, int hasHunter) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();	
    		return gameManagementDAO.modifyRole(numberOfWerewolves, hasWitch, hasFortuneTeller, hasLittleGirl, hasCupid, hasHunter);
    	}catch(SQLException e) {
    		e.getStackTrace();
    		return false;
    	}   
    }

	/**
	 * @return the currentGame
	 */
	public static Game getCurrentGame() {
		return GameManagementFacade.currentGame;
	}

	/**
	 * @param currentGame the currentGame to set
	 */
	public void setCurrentGame(Game currentGame) {
		GameManagementFacade.currentGame = currentGame;
	}

}