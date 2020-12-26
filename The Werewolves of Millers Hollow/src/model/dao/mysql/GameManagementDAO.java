package model.dao.mysql;

import java.sql.SQLException;

import businesslogic.domain.Game;
import businesslogic.domain.Phase;

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
    public abstract boolean createGame(int nbplayers, int status) throws SQLException;

    /**
     * @param game_id 
     * @return
     */
    public abstract Game getGame(int game_id) throws SQLException;

    /**
     * @param numberOfWerewolves 
     * @param hasWitch 
     * @param hasFortuneTeller 
     * @param hasLittleGirl 
     * @param hasCupid 
     * @param hasHunter 
     * @return
     */
    public abstract boolean modifyRole(int game_id, int numberOfWerewolves, int hasWitch, int hasFortuneTeller, int hasLittleGirl, int hasCupid, int hasHunter) throws SQLException;

    /**
     * @param game_id 
     * @param username 
     * @return
     */
    public abstract boolean inviteFriendToPlay(int game_id, String username1, String username2) throws SQLException;

    /**
     * @param game_id 
     * @param username 
     * @return
     */
    public abstract boolean cancelRequest(int game_id, String username1, String username2) throws SQLException;

    /**
     * @param game_id 
     * @param username 
     * @return
     */
    public abstract boolean kickPlayerOutOfTheGame(int game_id, String username) throws SQLException;

    /**
     * @param game_id 
     * @return
     */
    public abstract boolean deleteGame(int game_id) throws SQLException;

}