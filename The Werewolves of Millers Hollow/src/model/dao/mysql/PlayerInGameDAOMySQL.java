/**
 * package model.dao.mysql
 */
package model.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * Imported classes and libraries.
 */
import java.sql.SQLException;
import java.util.ArrayList;

import businesslogic.domain.PlayerInGame;
import businesslogic.domain.Role;
import model.dao.factory.AbstractFactoryDAO;

/**
 * @author Tiffany Dumaire
 */
public class PlayerInGameDAOMySQL extends PlayerInGameDAO {

    /**
     * Default constructor
     */
    public PlayerInGameDAOMySQL() {}

    @Override
    public boolean proposeAsASheriff(int gameId, String username) throws SQLException {
    	String sqlRequest = "UPDATE PlayerInGame SET proposeAsASheriff=? WHERE gameId=? AND username=?";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setBoolean(1, true);
    	request.setInt(2,gameId);
    	request.setString(3, username);
    	request.executeUpdate();
    	return existsCandidate(gameId,username);
    }
    
    @Override
    public PlayerInGame getPlayerInGame(int gameId,String username) throws SQLException {
    	String sqlRequest = "SELECT * FROM PlayerInGame WHERE gameId=? AND username=?";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, gameId);
    	request.setString(2, username);
    	ResultSet resultSet = request.executeQuery();
    	if(resultSet.first()) {
    		return new PlayerInGame(resultSet.getInt("gameId"),resultSet.getString("username"),resultSet.getBoolean("creator"),resultSet.getBoolean("isAlive"),resultSet.getBoolean("proposeAsASheriff"),Role.get(resultSet.getString("role")),resultSet.getBoolean("isSheriff"),resultSet.getBoolean("inLove"));
    	}else {
    		return null;
    	} 	
    }
    
    @Override
    public boolean becomeLover(int gameId, String username) throws SQLException {
    	String sqlRequest = "UPDATE PlayerInGame SET inLove=? WHERE gameId=? AND username=?";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setBoolean(1, true);
    	request.setInt(2,gameId);
    	request.setString(3, username);
    	request.executeUpdate();
    	return existsLover(gameId,username);
    }
    
	@Override
    public boolean existsLover(int gameId, String username) throws SQLException {
    	String sqlRequest = "SELECT * FROM PlayerInGame WHERE gameId=? AND username=? AND inLove=?";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, gameId);
    	request.setString(2, username);
    	request.setBoolean(3, true);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
    }
	
	@Override
	public ArrayList<String> getRoleList(int gameId) throws SQLException {
		String sqlRequest = "SELECT * FROM PlayerInGame WHERE gameId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, gameId);
		ResultSet resultSet = request.executeQuery();
		ArrayList<String> roleList = new ArrayList<String>();
		while(resultSet.next()) {
			roleList.add(resultSet.getString("role"));
		}
		return roleList;
	}
	
	@Override
	public ArrayList<String> getPlayerList(int gameId) throws SQLException {
		String sqlRequest = "SELECT * FROM PlayerInGame WHERE gameId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, gameId);
		ResultSet resultSet = request.executeQuery();
		ArrayList<String> playerList = new ArrayList<String>();
		while(resultSet.next()) {
			playerList.add(resultSet.getString("username"));
		}
		return playerList;
	}

	@Override
	public ArrayList<String> getPlayerInLove(int gameId) throws SQLException {
		String sqlRequest = "SELECT * FROM PlayerInGame WHERE gameId=? AND inLove=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, gameId);
		request.setBoolean(2, true);
		ResultSet resultSet = request.executeQuery();
		ArrayList<String> playerList = new ArrayList<String>();
		while(resultSet.next()) {
			playerList.add(resultSet.getString("username"));
		}
		return playerList;
	}
	
	@Override
	public ArrayList<PlayerInGame> getPlayerInGameList(int gameId) throws SQLException {
		String sqlRequest = "SELECT * FROM PlayerInGame WHERE gameId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, gameId);
		ResultSet resultSet = request.executeQuery();
		ArrayList<PlayerInGame> playerList = new ArrayList<PlayerInGame>();
		while(resultSet.next()) {
			playerList.add(new PlayerInGame(resultSet.getInt("gameId"),resultSet.getString("username"),resultSet.getBoolean("creator"),resultSet.getBoolean("isAlive"),resultSet.getBoolean("proposeAsASheriff"),Role.get(resultSet.getString("role")),resultSet.getBoolean("isSheriff"),resultSet.getBoolean("inLove")));
		}
		return playerList;
	}
	
	@Override
    public boolean existsCandidate(int gameId, String username) throws SQLException {
    	String sqlRequest = "SELECT * FROM PlayerInGame WHERE gameId=? AND username=? AND proposeAsASheriff=?";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, gameId);
    	request.setString(2, username);
    	request.setBoolean(3, true);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
    }
	
}