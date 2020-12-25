package model.dao.mysql;

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


    /**
     * @param game_id 
     * @return
     */
    public abstract Game getGame(int game_id);



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