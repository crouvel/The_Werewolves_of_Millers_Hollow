/**
 * package model.dao.mysql
 */
package model.dao.mysql;

/**
 * Imported classes and libraries.
 */
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * Imported classes and libraries.
 */
import java.sql.SQLException;
/**
 * Imported classes and libraries.
 */
import java.util.*;
import businesslogic.domain.Game;
import businesslogic.domain.Phase;
import gui.controller.PlayerMenuController;
import model.dao.factory.AbstractFactoryDAO;

/**
 * @author Tiffany Dumaire, Aaron Lazaroo, Clarence Rouvel
 */
public class SelectAndJoinAGameDAOMySQL extends SelectAndJoinAGameDAO {

    /**
     * Default constructor
     */
    public SelectAndJoinAGameDAOMySQL() {}

    @Override
    public Game getGameById(int game_id) throws SQLException {
    	String sqlRequest="SELECT * FROM Game WHERE gameId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, game_id);
    	ResultSet resultSet = request.executeQuery();
    	if(resultSet.first()) {
    		return new Game(resultSet.getInt("gameId"),resultSet.getInt("numberOfPlayers"),resultSet.getBoolean("status"),resultSet.getInt("numberOfWerewolves"),resultSet.getBoolean("hasWitch"),resultSet.getBoolean("hasLittleGirl"),resultSet.getBoolean("hasCupid"),resultSet.getBoolean("hasHunter"),resultSet.getBoolean("hasFortuneTeller"),resultSet.getBoolean("finish"),Phase.get(resultSet.getString("currentPhase")),resultSet.getBoolean("availableGame"),resultSet.getString("creatorUsername"));
    	}else{
    		return null;
    	}
    }

    @Override
    public ArrayList<Game> getAvailableGameList() throws SQLException {
    	String sqlRequest="SELECT * FROM Game WHERE status=1 AND availableGame=1";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	ResultSet resultSet = request.executeQuery();
    	ArrayList<Game> games = new ArrayList<Game>();
        while (resultSet.next()) {
            games.add(new Game(resultSet.getInt("gameId"),resultSet.getInt("numberOfPlayers"),resultSet.getBoolean("status"),resultSet.getInt("numberOfWerewolves"),resultSet.getBoolean("hasWitch"),resultSet.getBoolean("hasLittleGirl"),resultSet.getBoolean("hasCupid"),resultSet.getBoolean("hasHunter"),resultSet.getBoolean("hasFortuneTeller"),resultSet.getBoolean("finish"),Phase.get(resultSet.getString("currentPhase")),resultSet.getBoolean("availableGame"),resultSet.getString("creatorUsername")));
        }
        return games;
    }

    @Override
    public boolean makePlayerJoinAGameByGameId(int game_id) throws SQLException, IOException {
    	String sqlRequest = "INSERT INTO PlayerInGame(gameId,username,creator,proposeAsASheriff,isAlive,role,isSheriff) VALUES (?,?,?,?,?,?,?)";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, game_id);
    	request.setString(2, PlayerMenuController.getCurrentPlayer().getUsername());
    	request.setBoolean(3, false);
    	request.setBoolean(4, false);
    	request.setBoolean(5, true);
    	request.setString(6,"");
    	request.setBoolean(7, false);
    	request.executeUpdate();
    	return existsPlayerInGame(game_id,PlayerMenuController.getCurrentPlayer().getUsername());
    }
    
    @Override
    public boolean existsPlayerInGame(int gameid, String username) throws SQLException {
    	String sqlRequest="SELECT * FROM PlayerInGame WHERE gameId=? AND username=?";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, gameid);
    	request.setString(2, username);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();	
    }

}