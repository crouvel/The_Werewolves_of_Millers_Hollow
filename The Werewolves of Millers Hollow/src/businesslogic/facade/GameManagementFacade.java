package businesslogic.facade;

import java.sql.SQLException;

import businesslogic.domain.Game;
import model.dao.factory.AbstractFactoryDAO;
import model.dao.mysql.FriendManagementDAO;

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
    private Game currentGame;



    /**
     * @param numberOfPlayers 
     * @param status 
     * @return
     */
    public Game createGame(int numberOfPlayers, String status) {
        // TODO implement here
        return null;
    }

    /**
     * @param game_id 
     * @return
     */
    public boolean deleteGame(int game_id) {
        // TODO implement here
        return false;
    }

    /**
     * @param game_id 
     * @param username 
     * @return
     */
    public boolean inviteFriendToPlay(int game_id, String username) {
        // TODO implement here
        return false;
    }

    /**
     * @param game_id 
     * @param username 
     * @return
     */
    public boolean cancelRequest(int game_id, String username) {
        // TODO implement here
        return false;
    }

    /**
     * @param game_id 
     * @param username 
     * @return
     */
    public boolean kickPlayerOfTheGame(int game_id, String username) {
    	
    		return false;
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
    public boolean modifyRole(int numberOfWerewolves, boolean hasWitch, boolean hasFortuneTeller, boolean hasLittleGirl, boolean hasCupid, boolean hasHunter) {
        // TODO implement here
        return false;
    }

	/**
	 * @return the currentGame
	 */
	public Game getCurrentGame() {
		return currentGame;
	}

	/**
	 * @param currentGame the currentGame to set
	 */
	public void setCurrentGame(Game currentGame) {
		this.currentGame = currentGame;
	}

}