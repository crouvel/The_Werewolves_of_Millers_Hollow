/**
 * package model.dao.mysql
 */
package model.dao.mysql;

import java.io.IOException;
/**
 * Imported classes and libraries.
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.domain.Administrator;
import businesslogic.domain.Gender;
import businesslogic.domain.Player;
import businesslogic.domain.User;
import gui.controller.AdministratorMenuController;
import gui.controller.PlayerMenuController;
import model.dao.factory.AbstractFactoryDAO;

/**
 * @author Tiffany Dumaire
 */
public class UserDAOMySQL extends UserDAO{

	/**
	 * Default constructor
	 */
    public UserDAOMySQL() {}
    
	@Override
    public int getUserIdByUsername(String username) throws SQLException {
		String sqlRequest="SELECT * FROM Player WHERE username=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username);
    	ResultSet resultSet = request.executeQuery();
    	resultSet.first();
    	return resultSet.getInt("userId");
    }
    
    @Override
    public User getUserById(int userId) throws SQLException {
    	String sqlRequest="SELECT * FROM User WHERE userId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	ResultSet resultSet = request.executeQuery();
    	if(resultSet.wasNull()||!resultSet.first()){
    		return null;
    	}
    	else{
    		return new User(resultSet.getInt("userId"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("idAdmin"));
    	}
    }

    @Override
    public User getUserByEmail(String email) throws SQLException {
		String sqlRequest="SELECT * FROM User WHERE email=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, email);
    	ResultSet resultSet = request.executeQuery();
    	if(resultSet.wasNull()||!resultSet.first()){
    		return null;
    	}
    	else{
    		return new User(resultSet.getInt("userId"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("idAdmin"));
    	}
    }
    
    @Override
    public boolean exist(User user) throws SQLException {
    	String sqlRequest = "SELECT * FROM User WHERE email=? AND userId=? AND password=? AND ";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, user.getEmail());
    	request.setInt(2, user.getId());
    	request.setString(3, user.getPassword());
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
    }

    @Override
	public User getUserByLogin(String email, String password) throws SQLException{
		String sqlRequest="SELECT * FROM User WHERE email=? AND password=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, email);
    	request.setString(2, password);
    	ResultSet resultSet = request.executeQuery();
    	boolean exist = resultSet.first();
    	if(exist){
    		return new User(resultSet.getInt("userId"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("isAdmin"),resultSet.getBoolean("isLockedAccount"));
    	}
    	else{
    		return null;
    	}
	}

	@Override
	public boolean existsByEmail(String email) throws SQLException {
		String sqlRequest = "SELECT * FROM User WHERE email=?";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, email);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
	}

	@Override
	public boolean existsUsername(String username) throws SQLException {
		String sqlRequest = "SELECT * FROM Player WHERE username=?";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
	}

	@Override
	public boolean deleteUserByEmail(String email) throws SQLException{
        try {
        	String sqlRequest="DELETE FROM User WHERE email=?";
    		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
        	request.setString(1, email);
            request.executeUpdate();
            return !existsByEmail(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deletePlayerByUsername(String username) throws SQLException{
        try {
        	String sqlRequest="DELETE FROM User WHERE username=?";
    		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
        	request.setString(1, username);
            request.executeUpdate();
            return !existsUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

    @Override
	public boolean updateAdministratorProfile(String email, String password) throws SQLException{
		try {
			Administrator ad = AdministratorMenuController.getCurrentAdmin();
			String sqlRequest = "UPDATE User SET email=?,password=? WHERE userId=?";
	    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
	    	request.setString(2, password);
	    	request.setString(1, email);
	    	request.setInt(3, ad.getId());
	    	request.executeUpdate();
	    	return true;
		}catch(SQLException|IOException e) {
			e.getStackTrace();
			return false;
		}
	}


	@Override
	public boolean updateBlockPlayer(String username) throws SQLException {
		try {
			String sqlRequest = "UPDATE User SET isLockedAccount=? WHERE userId=?";
			int a = getUserIdByUsername(username);
	    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
	    	request.setBoolean(1, true);
	    	request.setInt(2, a);
	    	request.executeUpdate();
	    	return true;
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}
	}

    @Override
	public boolean updatePlayerProfile(String username, String email, String password, String country) throws SQLException{
		try {
			Player p = PlayerMenuController.getCurrentPlayer();
			String sqlRequest = "UPDATE User SET username=?,email=?,password=?,country=? WHERE userId=?";
	    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
	    	request.setString(1, username);
	    	request.setString(2, password);
	    	request.setString(3, email);
	    	request.setString(4, country);
	    	request.setInt(5, p.getId());
	    	request.executeUpdate();
	    	return true;
		}catch(SQLException|IOException e) {
			e.getStackTrace();
			return false;
		}
	}

	@Override
	public Player getPlayer(User user) throws SQLException {
		String sqlRequest="SELECT * FROM Player WHERE userId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, user.getId());
    	ResultSet resultSet = request.executeQuery();
    	boolean exist = resultSet.first();
    	if(exist){
    		return new Player(resultSet.getInt("userId"),user.getEmail(),user.getPassword(),user.isAdmin(),resultSet.getString("username"),resultSet.getDate("dateOfBirth"),Gender.get(resultSet.getString("gender")),resultSet.getString("country"),resultSet.getInt("status"));
    	}
    	else{
    		return null;
    	}
	}

	@Override
	public Administrator getAdmin(User user) throws SQLException {
		String sqlRequest="SELECT * FROM User WHERE userId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, user.getId());
    	ResultSet resultSet = request.executeQuery();
    	boolean exist = resultSet.first();
    	if(exist){
    		return new Administrator(resultSet.getInt("userId"),user.getEmail(),user.getPassword(),user.isAdmin());
    	}
    	else{
    		return null;
    	}
	}
	
	@Override
	public ArrayList<String> getCorrespondingPlayer(String username, int played, int won, int lost, boolean maxPlayed, boolean maxWon, boolean maxLost) throws SQLException {
		ArrayList<String> players = new ArrayList<String>();
		PreparedStatement request;
		String sqlRequest = "SELECT * FROM Player WHERE username LIKE ";
		if(username.isBlank()) {
			sqlRequest += "'%%' AND playedGames ";
			if(maxPlayed) {
				sqlRequest += "<= ? AND wonGames ";
				if(maxWon) {
					sqlRequest += "<= ? AND lostGames ";
					if(maxLost) {
						sqlRequest += "<= ?";
					}else {
						sqlRequest += ">= ?";
					}
				}else {
					sqlRequest += ">= ? AND lostGames ";
					if(maxLost) {
						sqlRequest += "<= ?";
					}else {
						sqlRequest += ">= ?";
					}
				}
			}else {
				sqlRequest += ">= ? AND wonGames ";
				if(maxWon) {
					sqlRequest += "<= ? AND lostGames ";
					if(maxLost) {
						sqlRequest += "<= ?";
					}else {
						sqlRequest += ">= ?";
					}
				}else {
					sqlRequest += ">= ? AND lostGames ";
					if(maxLost) {
						sqlRequest += "<= ?";
					}else {
						sqlRequest += ">= ?";
					}
				}
			}
			request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);	
	    	request.setInt(1, played);
	    	request.setInt(2, won);
	    	request.setInt(3, lost);
		}else {
			sqlRequest += "? ESCAPE '!' AND playedGames ";
			if(maxPlayed) {
				sqlRequest += "<= ? AND wonGames ";
				if(maxWon) {
					sqlRequest += "<= ? AND lostGames ";
					if(maxLost) {
						sqlRequest += "<= ?";
					}else {
						sqlRequest += ">= ?";
					}
				}else {
					sqlRequest += ">= ? AND lostGames ";
					if(maxLost) {
						sqlRequest += "<= ?";
					}else {
						sqlRequest += ">= ?";
					}
				}
			}else {
				sqlRequest += ">= ? AND wonGames ";
				if(maxWon) {
					sqlRequest += "<= ? AND lostGames ";
					if(maxLost) {
						sqlRequest += "<= ?";
					}else {
						sqlRequest += ">= ?";
					}
				}else {
					sqlRequest += ">= ? AND lostGames ";
					if(maxLost) {
						sqlRequest += "<= ?";
					}else {
						sqlRequest += ">= ?";
					}
				}
			}
			request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);	
	    	request.setString(1, "%"+ username+ "%");
	    	request.setInt(2, played);
	    	request.setInt(3, won);
	    	request.setInt(4, lost);
		}
    	ResultSet resultSet = request.executeQuery();
    	while(resultSet.next()) {
    		players.add(resultSet.getString("username"));
    	}
		return players;
    }

	@Override
	public boolean addAPlayer(String username, String email, String password, Date dateOfBirth, String gender,String country) {
		try {
			String sqlRequest = "INSERT INTO User(email,password) VALUES(?,?)";
	    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
	    	request.setString(1, email);
	    	request.setString(2, password);
	    	request.executeUpdate();
	    	User u = getUserByEmail(email);
	    	String sqlRequest2 = "INSERT INTO Player(userID,username,dateOfBirth,gender,country) VALUES(?,?,?,?,?)";
	    	PreparedStatement request2 = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest2);
	    	request2.setInt(1, u.getId());
	    	request2.setString(2, username);
	    	request2.setDate(3, (java.sql.Date) dateOfBirth);
	    	request2.setString(4, gender);
	    	request2.setString(5, country);
	    	request2.executeUpdate();
	    	return true;
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAnAdministrator(String email, String password) {
		try {
			String sqlRequest = "INSERT INTO User(email,password,isAdmin,isLockedAccount) VALUES(?,?,?,?)";
	    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
	    	request.setString(1, email);
	    	request.setString(2, password);
	    	request.setBoolean(3, true);
	    	request.setBoolean(4, false);
	    	request.executeUpdate();
	    	return true;
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}
	}


	@Override
	public Player getPlayerByUsername(String username) throws SQLException {
		String sqlRequest = "SELECT * FROM Player,User WHERE Player.userId = User.userId AND username=?";
        PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
        request.setString(1, username);
        ResultSet resultSet = request.executeQuery();
        if(resultSet.first()) {
            return new Player(resultSet.getInt("User.userId"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("isAdmin"),resultSet.getString("username"),resultSet.getDate("dateOfBirth"),Gender.get(resultSet.getString("gender")),resultSet.getString("country"),resultSet.getInt("playedGames"),resultSet.getInt("wonGames"),resultSet.getInt("lostGames"),resultSet.getInt("status"));
        }else {
            return null;
        }
	}
	
	@Override
	public Administrator getAdminByLogin(String email,String password) throws SQLException {
        String sqlRequest="SELECT * FROM User WHERE email=? AND password=?";
        PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
        request.setString(1, email);
        request.setString(2, password);
        ResultSet resultSet = request.executeQuery();
        boolean exist = resultSet.first();
        if(exist){
            return new Administrator(resultSet.getInt("userId"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("isAdmin"));
        }
        else{
            return null;
        }
    }

}