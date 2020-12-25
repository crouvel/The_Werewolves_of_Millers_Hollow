package model.dao.mysql;

<<<<<<< HEAD

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import businesslogic.domain.Game;
import businesslogic.domain.Phase;
import model.dao.factory.AbstractFactoryDAO;
=======
import businesslogic.domain.Game;
>>>>>>> parent of 3326ad8... kick player out of game + invite friend to play + begin game management

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
<<<<<<< HEAD
    
	
	
	
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
=======
    public Game createGame(int numberOfPlayers, String status) {
    	return new Game();
>>>>>>> parent of 3326ad8... kick player out of game + invite friend to play + begin game management
    }

    /**
     * @param game_id 
     * @return
     */
<<<<<<< HEAD
    public Game getGame(int game_id) throws SQLException{
    	String sqlRequest="SELECT * FROM Game WHERE gameId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, game_id);
    	ResultSet resultSet = request.executeQuery();
    	boolean exist = resultSet.first();
    	if(exist){
    		return new Game(resultSet.getInt("gameId"),resultSet.getInt("numberOfPlayers"),resultSet.getInt("status"),resultSet.getInt("numberOfWerewolves"),resultSet.getInt("hasWitch"),resultSet.getInt("hasLittleGirl"), 
    				resultSet.getInt("hasCupid"), resultSet.getInt("hasHunter"), resultSet.getInt("hasFortuneTeller"), resultSet.getInt("finish"), Phase.valueOf(resultSet.getString("currentPhase")), resultSet.getInt("availableGame"));
    	}
    	else{
    		return null;
    	}
        
    	
=======
    public Game getGame(int game_id) {
    	return new Game();
>>>>>>> parent of 3326ad8... kick player out of game + invite friend to play + begin game management
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
<<<<<<< HEAD
    public boolean modifyRole(int numberOfWerewolves, int hasWitch, int hasFortuneTeller, int hasLittleGirl, int hasCupid, int hasHunter) {
    	
    	
=======
    public boolean modifyRole(int numberOfWerewolves, boolean hasWitch, boolean hasFortuneTeller, boolean hasLittleGirl, boolean hasCupid, boolean hasHunter) {
>>>>>>> parent of 3326ad8... kick player out of game + invite friend to play + begin game management
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