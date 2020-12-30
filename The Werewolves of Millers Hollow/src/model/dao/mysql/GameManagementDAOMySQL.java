/**
 * package model.dao.mysql
 */
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
	public boolean createGame(int nbplayers, int status, String creator) throws SQLException{
		
		new Game(nbplayers, status, 0,0,0,0,0,0,0, Phase.NIGHT, 0);
		String sqlRequest = "INSERT INTO Game(numberOfPlayers, status, numberOfWerewolves, hasWitch, hasFortuneTeller, hasLittleGirl, hasCupid, hasHunter, finish, currentPhase, availableGame, creatorUsername) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, nbplayers);
		request.setInt(2, status);
		request.setInt(3, 1);
		request.setInt(4, 0);
		request.setInt(5, 0);
		request.setInt(6, 0);
		request.setInt(7, 0);
		request.setInt(8, 0);
		request.setInt(9, 0);
		request.setString(10, Phase.NIGHT.name());
		request.setInt(11, 1);
		request.setString(12, creator);
		request.executeUpdate();
		 return existsGame2(creator);  
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
    
    public Game getGameByCreator( String creator) throws SQLException{
    	String sqlRequest="SELECT * FROM Game WHERE creatorUsername=? and availableGame =1";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, creator);
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
    public boolean modifyRole(int game_id, int numberOfWerewolves, int hasWitch, int hasFortuneTeller, int hasLittleGirl, int hasCupid, int hasHunter) throws SQLException {
    	String sqlRequest="UPDATE Game SET numberOfWerewolves=?, hasWitch=?, hasLittleGirl=?, hasCupid=?, hasHunter=?, hasFortuneTeller=? WHERE gameId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(7, game_id);
		request.setInt(1, numberOfWerewolves);
    	request.setInt(2, hasWitch);
    	request.setInt(3, hasLittleGirl);
    	request.setInt(4, hasCupid);
    	request.setInt(5, hasHunter);
    	request.setInt(6, hasFortuneTeller);
        request.executeUpdate();
        return existsGamewithParams(game_id, numberOfWerewolves, hasWitch, hasFortuneTeller, hasLittleGirl, hasCupid, hasHunter);
    	
    	
    }

    public boolean existsGamewithParams(int game_id, int numberOfWerewolves, int hasWitch, int hasFortuneTeller, int hasLittleGirl, int hasCupid, int hasHunter) throws SQLException {
    	String sqlRequest="(SELECT * FROM Game WHERE gameId=? AND numberOfWerewolves=? AND hasWitch=? AND hasLittleGirl=? AND hasCupid=? AND hasHunter=? AND hasFortuneTeller=?)";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, game_id);
    	request.setInt(2, numberOfWerewolves);
    	request.setInt(3, hasWitch);
    	request.setInt(4, hasLittleGirl);
    	request.setInt(5, hasCupid);
    	request.setInt(6, hasHunter);
    	request.setInt(7, hasFortuneTeller);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
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
        request.executeUpdate();
        return existsGameRequest(game_id,username1,username2);
    }

    private boolean existsGameRequest(int game_id, String username1, String username2) throws SQLException{
    	String sqlRequest="SELECT * FROM GameRequest WHERE requesterUsername=? AND invitedUsername=? AND gamId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(3, game_id);
		request.setString(1, username1);
    	request.setString(2, username2);
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
		request.setInt(3, game_id);
		request.setString(1, username1);
    	request.setString(2, username2);
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
    	String sqlRequest="SELECT * FROM PlayerInGame WHERE gameId=? and username=?";
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
    public boolean deleteGame(int game_id, String username) throws SQLException{
    	String sqlRequest="DELETE FROM Game WHERE gameId=? AND creatorUsername=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, game_id);
    	request.setString(2, username);
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
    
    public boolean existsGame2(String username) throws SQLException {
    	String sqlRequest = "SELECT * FROM Game WHERE creatorUsername =? AND availableGame=1";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
    }

	/**
	 * @return the gameGenerated
	 */
	
    public ArrayList<String> getInvitedFriend(int gameId, String username) throws SQLException{
    	String sqlRequest="SELECT * FROM GameRequest WHERE requesterUsername=? AND gamId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username);
    	request.setInt(2, gameId);
    	ResultSet resultSet = request.executeQuery();
    	ArrayList<String> invited = new ArrayList<String>();
    	while (resultSet.next()) {
            invited.add(resultSet.getString("invitedUsername"));
    	}
        return invited;
    }

   
	public ArrayList<String> getPlayer(int gameId) throws SQLException{
    	String sqlRequest="SELECT * FROM PlayerInGame WHERE gameId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, gameId);
    	ResultSet resultSet = request.executeQuery();
    	ArrayList<String> players = new ArrayList<String>();
    	
    	while (resultSet.next()) {
            players.add(resultSet.getString("username"));
    	}
            return players;
    
    }

    }
    
    