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

import businesslogic.domain.Administrator;
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
    public UserDAOMySQL() {
    }

    /**
     * 
     * @param email 
     * @return
     * @throws SQLException
     */
    public int getUserIdByUsername(String username) throws SQLException {
		String sqlRequest="SELECT * FROM Player WHERE username=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username);
    	ResultSet resultSet = request.executeQuery();
    	resultSet.first();
    	return resultSet.getInt("userId");
    }
    
    /**
     * 
     * @param userId 
     * @return
     * @throws SQLException
     */
    public User getUserById(int userId) throws SQLException {
    	return null;
    }

    /**
     * 
     * @param email 
     * @return
     * @throws SQLException
     */
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
    
    /**
     * 
     * @param user
     * @return true if the User belongs in parameter exists, else false.
     * @throws SQLException
     */
    public boolean exist(User user) throws SQLException {
    	String sqlRequest = "SELECT * FROM User WHERE email=? AND userId=? AND password=? AND ";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, user.getEmail());
    	request.setInt(2, user.getId());
    	request.setString(3, user.getPassword());
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
    }

    /**
     * 
     * @param email
     * @param password
     * @return
     * @throws SQLException
     */
	public User getUserByLogin(String email, String password) throws SQLException{
		String sqlRequest="SELECT * FROM User WHERE email=? AND password=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, email);
    	request.setString(2, password);
    	ResultSet resultSet = request.executeQuery();
    	boolean exist = resultSet.first();
    	if(exist){
    		return new User(resultSet.getInt("userId"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("isAdmin"));
    	}
    	else{
    		return null;
    	}
	}

	/**
     * @param email 
     * @return
     * @throws SQLException
     */
	public boolean existsByEmail(String email) throws SQLException {
		String sqlRequest = "SELECT * FROM User WHERE email=?";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, email);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
	}

	/**
     * @param username 
     * @return
	 * @throws SQLException 
     */
	public boolean existsUsername(String username) throws SQLException {
		String sqlRequest = "SELECT * FROM Player WHERE username=?";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
	}

	/**
     * @param email 
     * @return
     */
	public User deleteUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * @param username 
     * @return
     */
	public boolean deletePlayerByUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

    /**
     * @param email 
     * @param password 
     * @return
     */
	public boolean updateAdministratorProfile(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}


    /**
     * @param username 
     * @return
     * @throws SQLException
     */
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

    /**
     * @param username 
     * @param email 
     * @param password 
     * @param country 
     * @return
     */
	public boolean udaptePlayerProfile(String username, String email, String password, String country) {
		// TODO Auto-generated method stub
		return false;
	}

    /**
     * 
     * @param user
     * @return
     * @throws SQLException 
     */
	public Player getPlayer(User user) throws SQLException {
		String sqlRequest="SELECT * FROM Player WHERE userId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, user.getId());
    	ResultSet resultSet = request.executeQuery();
    	boolean exist = resultSet.first();
    	if(exist){
    		return new Player(resultSet.getInt("userId"),user.getEmail(),user.getPassword(),user.isAdmin(),resultSet.getString("username"),resultSet.getDate("dateOfBirth"),resultSet.getString("gender"),resultSet.getString("country"));
    	}
    	else{
    		return null;
    	}
	}

	/**
     * 
     * @param user
     * @return
     * @throws SQLException 
     */
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
	
	/**
	 * 
	 * @param username
	 * @param played
	 * @param won
	 * @param lost
	 * @param maxPlayed
	 * @param maxWon
	 * @param maxLost
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<String> getCorrespondingPlayer(String username, int played, int won, int lost, boolean maxPlayed, boolean maxWon, boolean maxLost) throws SQLException {
		ArrayList<String> players = new ArrayList<String>();
		PreparedStatement request;
		String sqlRequest = "SELECT * FROM Player WHERE username LIKE '%";
		if(username.isBlank()) {
			sqlRequest += "%' AND playedGames ";
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
			System.out.println("request debut");
			sqlRequest += "?%' AND playedGames ";
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
				System.out.println(">= 0 ");
				sqlRequest += ">= ? AND wonGames ";
				if(maxWon) {
					sqlRequest += "<= ? AND lostGames ";
					if(maxLost) {
						sqlRequest += "<= ?";
					}else {
						sqlRequest += ">= ?";
					}
				}else {
					System.out.println(">= 0 ");
					sqlRequest += ">= ? AND lostGames ";
					if(maxLost) {
						sqlRequest += "<= ?";
					}else {
						System.out.println(">= 0 ");
						sqlRequest += ">= ?";
					}
				}
			}
			request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);	
	    	request.setString(1, username);
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

}