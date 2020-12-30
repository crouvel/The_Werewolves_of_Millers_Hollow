/**
 * package model.dao.mysql
 */
package model.dao.mysql;

/**
 * Imported classes and libraries.
 */
import java.sql.SQLException;

import businesslogic.domain.Game;

/**
 * @author Tiffany Dumaire, Aaron Lazaroo, Clarence Rouvel
 */
public abstract class GameManagementDAO {

    /**
     * Default constructor
     */
    public GameManagementDAO() {}

    /**
     * 
     * @param numberOfPlayers 
     * @param status 
     * @return
     * @throws SQLException 
     */
    public abstract Game createGame(int numberOfPlayers, String status) throws SQLException;

    /**
     * 
     * @param game_id 
     * @return
     * @throws SQLException 
     */
    public abstract Game getGame(int game_id) throws SQLException;

    /**
     * 
     * @param numberOfWerewolves 
     * @param hasWitch 
     * @param hasFortuneTeller 
     * @param hasLittleGirl 
     * @param hasCupid 
     * @param hasHunter 
     * @return
     * @throws SQLException 
     */
    public abstract boolean modifyRole(int numberOfWerewolves, boolean hasWitch, boolean hasFortuneTeller, boolean hasLittleGirl, boolean hasCupid, boolean hasHunter) throws SQLException;

    /**
     * 
     * @param game_id 
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean inviteFriendToPlay(int game_id, String username) throws SQLException;

    /**
     * 
     * @param game_id 
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean cancelRequest(int game_id, String username) throws SQLException;

    /**
     * 
     * @param game_id 
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean kickPlayerOutOfTheGame(int game_id, String username) throws SQLException;

    /**
     * 
     * @param game_id 
     * @return
     * @throws SQLException 
     */
    public abstract boolean deleteGame(int game_id) throws SQLException;

}