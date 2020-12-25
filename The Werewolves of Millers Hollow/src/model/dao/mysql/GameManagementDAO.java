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
<<<<<<< HEAD
<<<<<<< HEAD
    public abstract boolean createGame(int nbplayers, int status) throws SQLException;
=======
    public abstract Game createGame(int numberOfPlayers, String status);
>>>>>>> parent of 3326ad8... kick player out of game + invite friend to play + begin game management
=======
    public abstract Game createGame(int numberOfPlayers, String status);
>>>>>>> parent of 3326ad8... kick player out of game + invite friend to play + begin game management

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
<<<<<<< HEAD
<<<<<<< HEAD
    public abstract boolean modifyRole(int numberOfWerewolves, int hasWitch, int hasFortuneTeller, int hasLittleGirl, int hasCupid, int hasHunter) throws SQLException;
=======
    public abstract boolean modifyRole(int numberOfWerewolves, boolean hasWitch, boolean hasFortuneTeller, boolean hasLittleGirl, boolean hasCupid, boolean hasHunter);
>>>>>>> parent of 3326ad8... kick player out of game + invite friend to play + begin game management
=======
    public abstract boolean modifyRole(int numberOfWerewolves, boolean hasWitch, boolean hasFortuneTeller, boolean hasLittleGirl, boolean hasCupid, boolean hasHunter);
>>>>>>> parent of 3326ad8... kick player out of game + invite friend to play + begin game management

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