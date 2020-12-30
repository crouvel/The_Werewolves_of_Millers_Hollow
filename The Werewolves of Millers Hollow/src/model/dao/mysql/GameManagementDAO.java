/**
 * package model.dao.mysql
 */
package model.dao.mysql;

import java.sql.SQLException;
import java.util.ArrayList;

import businesslogic.domain.Game;
import businesslogic.domain.Phase;

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
    public abstract boolean createGame(int nbplayers, boolean status, String creator) throws SQLException;

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
    public abstract boolean modifyRole(int game_id, int numberOfWerewolves, boolean hasWitch, boolean hasFortuneTeller, boolean hasLittleGirl, boolean hasCupid, boolean hasHunter) throws SQLException;

    /**
     * 
     * @param game_id 
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean inviteFriendToPlay(int game_id, String username1, String username2) throws SQLException;

    /**
     * 
     * @param game_id 
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean cancelRequest(int game_id, String username1, String username2) throws SQLException;

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
    public abstract boolean deleteGame(int game_id, String username) throws SQLException;

    public abstract Game getGameByCreator( String creator) throws SQLException;
    
    public abstract ArrayList<String> getInvitedFriend(int gameId, String username) throws SQLException;
    
    
    public abstract ArrayList<String> getPlayer(int gameId) throws SQLException;
    
    
}