/**
 * package model.dao.mysql
 */
package model.dao.mysql;

import java.sql.SQLException;

/**
 * Imported classes and libraries.
 */
import businesslogic.domain.Game;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class GameManagementDAOMySQL extends GameManagementDAO {

    /**
     * Default constructor
     */
    public GameManagementDAOMySQL() {}

    @Override
    public Game createGame(int numberOfPlayers, String status) throws SQLException {
    	return null;
    }

    @Override
    public Game getGame(int game_id) throws SQLException {
    	return null;
    }

    @Override
    public boolean modifyRole(int numberOfWerewolves, boolean hasWitch, boolean hasFortuneTeller, boolean hasLittleGirl, boolean hasCupid, boolean hasHunter) throws SQLException {
    	return true;
    }

    @Override
    public boolean inviteFriendToPlay(int game_id, String username) throws SQLException {
    	return true;
    }

    @Override
    public boolean cancelRequest(int game_id, String username) throws SQLException {
    	return true;
    }

    @Override
    public boolean kickPlayerOutOfTheGame(int game_id, String username) throws SQLException {
    	return true;
    }

    @Override
    public boolean deleteGame(int game_id) throws SQLException {
    	return true;
    }

}