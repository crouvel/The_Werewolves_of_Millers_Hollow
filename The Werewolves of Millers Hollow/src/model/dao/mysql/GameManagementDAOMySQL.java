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
    }

    /**
     * @param game_id 
     * @return
     */
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
    public boolean modifyRole(int numberOfWerewolves, int hasWitch, int hasFortuneTeller, int hasLittleGirl, int hasCupid, int hasHunter) {
    	
    	
    	return true;
    }

    /**
     * @param game_id 
     * @param username 
     * @return
     */
    public boolean inviteFriendToPlay(int game_id, String username1, String username2) throws SQLException {
    	String sqlRequest="INSERT INTO GameRequest(gamId, requesterUsername, invitedUsername) VALUES (?,?,?)";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, game_id);
		request.setString(2, username1);
    	request.setString(3, username2);
        request.execute();
        return existsGameRequest(game_id,username1,username2);
    }

    private boolean existsGameRequest(int game_id, String username1, String username2) throws SQLException{
    	String sqlRequest="SELECT * FROM GameRequest WHERE requesterUsername=? AND invitedUsername=? AND gamId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, game_id);
		request.setString(2, username1);
    	request.setString(3, username2);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
	}

	/**
     * @param game_id 
     * @param username 
     * @return
     */
    public boolean cancelRequest(int game_id, String username1, String username2) throws SQLException{
    	String sqlRequest="DELETE FROM GameRequest WHERE requesterUsername=? AND invitedUsername=? AND gamId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, game_id);
		request.setString(2, username1);
    	request.setString(3, username2);
        request.executeUpdate();
        return !existsGameRequest(game_id,username1,username2);
    }

    /**
     * @param game_id 
     * @param username 
     * @return
     */
    public boolean kickPlayerOutOfTheGame(int game_id, String username) throws SQLException{
    	String sqlRequest="DELETE FROM PlayerInGame WHERE gameId=? AND username=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, game_id);
    	request.setString(2, username);
        request.executeUpdate();
        return !existsPlayerInGame(username,game_id);
    }

    private boolean existsPlayerInGame(String username, int game_id) throws SQLException {
    	String sqlRequest="(SELECT * FROM PlayerInGame WHERE gameId=? and username=?)";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, game_id);
    	request.setString(2, username);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
	}

	/**
     * @param game_id 
     * @return
     */
    public boolean deleteGame(int game_id) throws SQLException{
    	String sqlRequest="DELETE FROM Game WHERE gameId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, game_id);
        request.executeUpdate();
        return !existsGame(game_id);
    	
    }

    public boolean existsGame(int game_id) throws SQLException {
    	String sqlRequest="(SELECT * FROM Game WHERE gameId=?)";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, game_id);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
    }




}