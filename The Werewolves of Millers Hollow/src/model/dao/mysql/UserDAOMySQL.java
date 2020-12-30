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
import java.sql.Date;

import businesslogic.domain.Administrator;
import businesslogic.domain.Gender;
import businesslogic.domain.Player;
import businesslogic.domain.User;
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
    	return null;
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
	public User deleteUserByEmail(String email) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePlayerByUsername(String username) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAdministratorProfile(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		return false;
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
	public boolean updatePlayerProfile(String username, String email, String password, String country) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player getPlayer(User user) throws SQLException {
		String sqlRequest="SELECT * FROM Player WHERE userId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, user.getId());
    	ResultSet resultSet = request.executeQuery();
    	boolean exist = resultSet.first();
    	if(exist){
    		return new Player(resultSet.getInt("userId"),user.getEmail(),user.getPassword(),user.isAdmin(),resultSet.getString("username"),resultSet.getDate("dateOfBirth"),Gender.get(resultSet.getString("gender")),resultSet.getString("country"),resultSet.getInt("playedGames"),resultSet.getInt("wonGames"),resultSet.getInt("lostGames"),resultSet.getInt("status"));
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
	public boolean addAPlayer(String username, String email, String password, Date dateOfBirth, String gender,String country) throws SQLException {
		System.out.println(username);
		System.out.println(dateOfBirth);
		System.out.println(gender);
		System.out.println(country);
		String sqlRequest = "INSERT INTO User(email,password,isAdmin,isLockedAccount) VALUES(?,?,false,false)";
         PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
         request.setString(1, email);
         request.setString(2, password);
         request.executeUpdate();
         User u = getUserByLogin(email,password);
         System.out.println(u);
         String sqlRequest2 = "INSERT INTO Player(userId,username,dateOfBirth,gender,country,playedGames,wonGames,lostGames,status) VALUES(?,?,?,?,?,?,?,?,true)";
         PreparedStatement request2 = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest2);
         request2.setInt(1, u.getId());
         request2.setString(2, username);
         request2.setDate(3, dateOfBirth);
         request2.setString(4, gender);
         request2.setString(5, country);
         request2.setInt(6, 0);
         request2.setInt(7, 0);
         request2.setInt(8, 0);
         request2.executeUpdate();
         return existsUsername(username);
	}

	@Override
	public boolean addAnAdministrator(String email, String password) throws SQLException {
		return false;
	}

}