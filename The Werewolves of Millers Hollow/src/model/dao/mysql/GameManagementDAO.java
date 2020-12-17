package model.dao.mysql;

import businesslogic.domain.Game;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public abstract class GameManagementDAO {

    /**
     * Default constructor
     */
    public GameManagementDAO() {
    }



    /**
     * @param numberOfPlayers 
     * @param status 
     * @return
     */
    public abstract Game createGame(int numberOfPlayers, String status);

    /**
     * @param game_id 
     * @return
     */
    public abstract Game getGame(int game_id);

    /**
     * @param numberOfWerewolves 
     * @param hasWitch 
     * @param hasFortuneTeller 
     * @param hasLittleGirl 
     * @param hasCupid 
     * @param hasHunter 
     * @return
     */
    public abstract boolean modifyRole(int numberOfWerewolves, boolean hasWitch, boolean hasFortuneTeller, boolean hasLittleGirl, boolean hasCupid, boolean hasHunter);

    /**
     * @param game_id 
     * @param username 
     * @return
     */
    public abstract boolean inviteFriendToPlay(int game_id, String username);

    /**
     * @param game_id 
     * @param username 
     * @return
     */
    public abstract boolean cancelRequest(int game_id, String username);

    /**
     * @param game_id 
     * @param username 
     * @return
     */
    public abstract boolean kickPlayerOutOfTheGame(int game_id, String username);

    /**
     * @param game_id 
     * @return
     */
    public abstract boolean deleteGame(int game_id);

}