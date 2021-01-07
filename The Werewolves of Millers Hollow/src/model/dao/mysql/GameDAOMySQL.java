/**
 * package model.dao.mysql
 */
package model.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Imported classes and libraries.
 */
import java.util.*;

import businesslogic.domain.PlayerInGame;
import model.dao.factory.AbstractFactoryDAO;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class GameDAOMySQL extends GameDAO {

    /**
     * Default constructor
     */
    public GameDAOMySQL() {}
    
    @Override
    public ArrayList<PlayerInGame> getPlayerInGameList(int game_id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<String> getAllVotes(int game_id) throws SQLException {
        return null;
    }

    @Override
    public boolean sendVote(String username1, String username2, int game_id) throws SQLException {
    	String sqlRequest = "INSERT INTO Vote(gameId,voterUsername,votedUsername) VALUES(?,?,?)";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1,game_id);
    	request.setString(2, username1);
    	request.setString(3, username2);
    	request.executeUpdate();
    	return existsVote(username1,username2,game_id);
    }
    
    public boolean existsVote(String username1,String username2,int gameId) throws SQLException {
    	String sqlRequest = "SELECT * FROM Vote WHERE gameId=? AND voterUsername=? AND votedUsername=?";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1,gameId);
    	request.setString(2, username1);
    	request.setString(3, username2);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
    }


}