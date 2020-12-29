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
/**
 * Imported classes and libraries.
 */
import java.util.*;
import businesslogic.domain.Game;
import businesslogic.domain.Phase;
import model.dao.factory.AbstractFactoryDAO;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class SelectAndJoinAGameDAOMySQL extends SelectAndJoinAGameDAO {

    /**
     * Default constructor
     */
    public SelectAndJoinAGameDAOMySQL() {}

    @Override
    public Game getGameById(int game_id) throws SQLException {
    	String sqlRequest="SELECT * FROM Game WHERE gameId=game_id";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	ResultSet resultSet = request.executeQuery();
    	if(resultSet.first()) {
    		return new Game(resultSet.getInt("gameId"),resultSet.getInt("numberOfPlayers"),resultSet.getBoolean("status"),resultSet.getInt("numberOfWerewolves"),resultSet.getBoolean("hasWitch"),resultSet.getBoolean("hasLittleGirl"),resultSet.getBoolean("hasCupid"),resultSet.getBoolean("hasHunter"),resultSet.getBoolean("hasFortuneTeller"),resultSet.getBoolean("finish"),Phase.get(resultSet.getString("currentPhase")),resultSet.getBoolean("availableGame"),resultSet.getString("creatorUsername"));
    	}else{
    		return null;
    	}
    }

    @Override
    public ArrayList<Game> getAvailableGameList() throws SQLException {
    	String sqlRequest="SELECT * FROM Game WHERE availableGame=1";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	ResultSet resultSet = request.executeQuery();
    	ArrayList<Game> games = new ArrayList<Game>();
        while (resultSet.next()) {
            games.add(new Game(resultSet.getInt("gameId"),resultSet.getInt("numberOfPlayers"),resultSet.getBoolean("status"),resultSet.getInt("numberOfWerewolves"),resultSet.getBoolean("hasWitch"),resultSet.getBoolean("hasLittleGirl"),resultSet.getBoolean("hasCupid"),resultSet.getBoolean("hasHunter"),resultSet.getBoolean("hasFortuneTeller"),resultSet.getBoolean("finish"),Phase.get(resultSet.getString("currentPhase")),resultSet.getBoolean("availableGame"),resultSet.getString("creatorUsername")));
        }
        return games;
    }

    @Override
    public boolean makePlayerJoinAGameByGameId(int game_id) throws SQLException {
    	//String sqlRequest = "INSERT INTO PlayerInGame() VALUES";
    	return false;
    }

}