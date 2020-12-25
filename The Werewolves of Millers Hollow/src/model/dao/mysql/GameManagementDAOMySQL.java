package model.dao.mysql;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import businesslogic.domain.Game;
import businesslogic.domain.Phase;
import model.dao.factory.AbstractFactoryDAO;

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

    
	
	
	
	public boolean createGame(int nbplayers, int status) throws SQLException{
		
		new Game(nbplayers, status);
		String sqlRequest = "INSERT INTO Game(gameId, numberOfPlayers, status, numberOfWerewolves, hasWitch, hasFortuneTeller, hasLittleGirl, hasCupid, hasHunter, finish, currentPhase, availableGame) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, Game.getNbgames());
		request.setInt(2, nbplayers);
		request.setInt(3, status);
		request.setInt(4, 0);
		request.setInt(5, 0);
		request.setInt(6, 0);
		request.setInt(7, 0);
		request.setInt(8, 0);
		request.setInt(9, 0);
		request.setInt(10, 0);
		request.setString(11, Phase.NIGHT.name());
		request.setInt(12, 0);
		request.executeUpdate();
       
        return existsGame(Game.getNbgames());

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