package model.dao.mysql;

import businesslogic.domain.Game;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class GameManagementDAOMySQL extends GameManagementDAO {

    /**
     * Default constructor
     */
    public GameManagementDAOMySQL() {
    }

    /**
     * @param numberOfPlayers 
     * @param status 
     * @return
     */
    public Game createGame(int numberOfPlayers, String status) {
    	return new Game();
    }

    /**
     * @param game_id 
     * @return
     */
    public Game getGame(int game_id) {
    	return new Game();
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
    	return true;
    }

    /**
     * @param game_id 
     * @param username 
     * @return
     */
    public boolean inviteFriendToPlay(int game_id, String username) {
    	return true;
    }

    /**
     * @param game_id 
     * @param username 
     * @return
     */
    public boolean cancelRequest(int game_id, String username) {
    	return true;
    }

    /**
     * @param game_id 
     * @param username 
     * @return
     */
    public boolean kickPlayerOutOfTheGame(int game_id, String username) {
    	return true;
    }

    /**
     * @param game_id 
     * @return
     */
    public boolean deleteGame(int game_id) {
    	return true;
    }

}