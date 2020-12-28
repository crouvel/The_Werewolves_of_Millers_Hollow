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
import java.util.Date;

import businesslogic.domain.Administrator;
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
	public boolean deleteUserByEmail(String email) {
		boolean res = true;
        try {
        	String sqlRequest="DELETE FROM User WHERE email=?";
    		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
        	request.setString(1, email);
            request.executeUpdate();
            res = existsByEmail(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return res;
	}

	/**
     * @param username 
     * @return
     */
	public boolean deletePlayerByUsername(String username) {
		boolean res = true;
        try {
        	String sqlRequest="DELETE FROM User WHERE username=?";
    		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
        	request.setString(1, username);
            request.executeUpdate();
            res = existsUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return res;
	}

    /**
     * @param email 
     * @param password 
     * @return
     */
	public boolean updateAdministratorProfile(String email, String password) throws SQLException,IOException{
		try {
			Administrator ad = AdministratorMenuController.getCurrentAdmin();
			String sqlRequest = "UPDATE User SET email=?,password=? WHERE userId=?";
	    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
	    	request.setString(1, password);
	    	request.setString(2, email);
	    	request.setInt(3, ad.getId());
	    	request.executeUpdate();
	    	return true;
		}catch(SQLException|IOException e) {
			e.getStackTrace();
			return false;
		}
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
	public boolean updatePlayerProfile(String username, String email, String password, String country) throws SQLException,IOException{
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
     * @param username 
     * @param email 
     * @param password 
     * @param country 
     * @param dateOfBirth
     * @param gender
     * @return
     */
	public boolean addAPlayer(String username, String email, String password, Date dateOfBirth, String gender,String country) {
		try {
			String sqlRequest = "INSERT INTO USER(email,password) VALUES(?,?)";
	    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
	    	request.setString(1, email);
	    	request.setString(2, password);
	    	request.executeUpdate();
	    	User u = getUserByEmail(email);
	    	String sqlRequest2 = "INSERT INTO PLAYER(userID,username,dateOfBirth,gender,country) VALUES(?,?,?,?,?)";
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

	/**
     * @param email 
     * @param password 
     * @return
     */
	public boolean addAnAdministrator(String email, String password) {
		try {
			String sqlRequest = "INSERT INTO USER(email,password,isAdmin) VALUES(?,?,?)";
	    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
	    	request.setString(1, email);
	    	request.setString(2, password);
	    	request.setBoolean(3, true);
	    	request.executeUpdate();
	    	return true;
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}
	}

}