/**
 * package model.dao.mysql
 */
package model.dao.mysql;

/**
 * Imported classes and libraries.
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import businesslogic.domain.Game;
import businesslogic.domain.Phase;
import model.dao.factory.AbstractFactoryDAO;

/**
 * @author Tiffany Dumaire, Aaron Lazaroo, Clarence Rouvel
 */
public class GameManagementDAOMySQL extends GameManagementDAO {

	/**
	 * Default constructor
	 */
	public GameManagementDAOMySQL() {}

	@Override
	public boolean createGame(int nbplayers, boolean status, String creator) throws SQLException{

		new Game(nbplayers, status, 1, false, false ,false,false,false,false, Phase.SET_UP, true, creator);
		String sqlRequest = "INSERT INTO Game(numberOfPlayers, status, numberOfWerewolves, hasWitch, hasFortuneTeller, hasLittleGirl, hasCupid, hasHunter, finish, currentPhase, availableGame, creatorUsername) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, nbplayers);
		request.setBoolean(2, status);
		request.setInt(3, 1);
		request.setBoolean(4, false);
		request.setBoolean(5, false);
		request.setBoolean(6, false);
		request.setBoolean(7, false);
		request.setBoolean(8, false);
		request.setBoolean(9, false);
		request.setString(10, Phase.SET_UP.getName());
		request.setBoolean(11, true);
		request.setString(12, creator);
		request.executeUpdate();
		return existsGame2(creator);  
	}

	@Override
	public Game getGame(int game_id) throws SQLException{
		String sqlRequest="SELECT * FROM Game WHERE gameId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, game_id);

		ResultSet resultSet = request.executeQuery();
		boolean exist = resultSet.first();
		if(exist){
			return new Game(resultSet.getInt("gameId"),resultSet.getInt("numberOfPlayers"),resultSet.getBoolean("status"),resultSet.getInt("numberOfWerewolves"),resultSet.getBoolean("hasWitch"),resultSet.getBoolean("hasLittleGirl"),resultSet.getBoolean("hasCupid"), resultSet.getBoolean("hasHunter"), resultSet.getBoolean("hasFortuneTeller"), resultSet.getBoolean("finish"), Phase.get(resultSet.getString("currentPhase")), resultSet.getBoolean("availableGame"), resultSet.getString("creatorUsername"));
		}
		else{
			return null;
		}
	}

	@Override
	public Game getGameByCreator( String creator) throws SQLException{
		String sqlRequest="SELECT * FROM Game WHERE creatorUsername=? and availableGame =1";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setString(1, creator);
		ResultSet resultSet = request.executeQuery();
		boolean exist = resultSet.first();
		if(exist){
			Game game = new Game(resultSet.getInt("gameId"),resultSet.getInt("numberOfPlayers"),resultSet.getBoolean("status"),resultSet.getInt("numberOfWerewolves"),resultSet.getBoolean("hasWitch"),resultSet.getBoolean("hasLittleGirl"),  resultSet.getBoolean("hasCupid"), resultSet.getBoolean("hasHunter"), resultSet.getBoolean("hasFortuneTeller"), resultSet.getBoolean("finish"), Phase.get(resultSet.getString("currentPhase")), resultSet.getBoolean("availableGame"));
			return game;
		}
		else{
			return null;
		}


	}

	@Override
	public boolean modifyRole(int game_id, int numberOfWerewolves, boolean hasWitch, boolean hasFortuneTeller, boolean hasLittleGirl, boolean hasCupid, boolean hasHunter) throws SQLException {
		String sqlRequest="UPDATE Game SET numberOfWerewolves=?, hasWitch=?, hasLittleGirl=?, hasCupid=?, hasHunter=?, hasFortuneTeller=?, currentPhase=?, availableGame=? WHERE gameId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, numberOfWerewolves);
		request.setBoolean(2, hasWitch);
		request.setBoolean(3, hasLittleGirl);
		request.setBoolean(4, hasCupid);
		request.setBoolean(5, hasHunter);
		request.setBoolean(6, hasFortuneTeller);
		request.setString(7, "NIGHT");
		request.setBoolean(8, false);
		request.setInt(9, game_id);
		request.executeUpdate();
		return existsGamewithParams(game_id, numberOfWerewolves, hasWitch, hasFortuneTeller, hasLittleGirl, hasCupid, hasHunter);


	}

	@Override
	public boolean existsGamewithParams(int game_id, int numberOfWerewolves, boolean hasWitch, boolean hasFortuneTeller, boolean hasLittleGirl, boolean hasCupid, boolean hasHunter) throws SQLException {
		String sqlRequest="(SELECT * FROM Game WHERE gameId=? AND numberOfWerewolves=? AND hasWitch=? AND hasLittleGirl=? AND hasCupid=? AND hasHunter=? AND hasFortuneTeller=?)";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, game_id);
		request.setInt(2, numberOfWerewolves);
		request.setBoolean(3, hasWitch);
		request.setBoolean(4, hasLittleGirl);
		request.setBoolean(5, hasCupid);
		request.setBoolean(6, hasHunter);
		request.setBoolean(7, hasFortuneTeller);
		ResultSet resultSet = request.executeQuery();
		return resultSet.first();
	}

	@Override
	public boolean inviteFriendToPlay(int game_id, String username1, String username2) throws SQLException {
		String sqlRequest="INSERT INTO GameRequest(gamId, requesterUsername, invitedUsername) VALUES (?,?,?)";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, game_id);
		request.setString(2, username1);
		request.setString(3, username2);
		request.executeUpdate();
		return existsGameRequest(game_id,username1,username2);
	}

	@Override
	public boolean existsGameRequest(int game_id, String username1, String username2) throws SQLException {
		String sqlRequest="SELECT * FROM GameRequest WHERE requesterUsername=? AND invitedUsername=? AND gamId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(3, game_id);
		request.setString(1, username1);
		request.setString(2, username2);
		ResultSet resultSet = request.executeQuery();
		return resultSet.first();
	}

	@Override
	public boolean cancelRequest(int game_id, String username1, String username2) throws SQLException{
		String sqlRequest="DELETE FROM GameRequest WHERE requesterUsername=? AND invitedUsername=? AND gamId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(3, game_id);
		request.setString(1, username1);
		request.setString(2, username2);
		request.executeUpdate();
		return !existsGameRequest(game_id,username1,username2);
	}

	@Override
	public boolean kickPlayerOutOfTheGame(int game_id, String username) throws SQLException{
		String sqlRequest="DELETE FROM PlayerInGame WHERE gameId=? AND username=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, game_id);
		request.setString(2, username);
		request.executeUpdate();
		return !existsPlayerInGame(username,game_id);
	}

	@Override
	public boolean existsPlayerInGame(String username, int game_id) throws SQLException {
		String sqlRequest="SELECT * FROM PlayerInGame WHERE gameId=? and username=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, game_id);
		request.setString(2, username);
		ResultSet resultSet = request.executeQuery();
		return resultSet.first();
	}

	@Override
	public boolean deleteGame(int game_id) throws SQLException{
		String sqlRequest="DELETE FROM Game WHERE gameId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, game_id);
		request.executeUpdate();
		return !existsGame(game_id);

	}

	@Override
	public boolean existsGame(int game_id) throws SQLException {
		String sqlRequest="(SELECT * FROM Game WHERE gameId=?)";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, game_id);
		ResultSet resultSet = request.executeQuery();
		return resultSet.first();
	}

	@Override
	public boolean existsGame2(String username) throws SQLException {
		String sqlRequest = "SELECT * FROM Game WHERE creatorUsername =? AND availableGame=1";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setString(1, username);
		ResultSet resultSet = request.executeQuery();
		return resultSet.first();
	}

	@Override
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

	@Override
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
	
	@Override
	public boolean deleteGame2(String creatorUsername) throws SQLException{
		String sqlRequest="DELETE FROM Game WHERE creatorUsername=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setString(1, creatorUsername);
		request.executeUpdate();
		return !existsGame2(creatorUsername);

	}

}    