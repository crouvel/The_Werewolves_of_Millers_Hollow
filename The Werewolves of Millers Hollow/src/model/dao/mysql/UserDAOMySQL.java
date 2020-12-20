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
     * @param email
     * @return true if the User to which the email belongs in parameter exists, else false.
     * @throws SQLException
     */
    public boolean exist(String email) throws SQLException {
    	String sqlRequest = "SELECT COUNT(*) FROM User WHERE email=?";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, email);
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
     */
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
     * @param username 
     * @return
     */
	public boolean existsUsername(String username) {
		// TODO Auto-generated method stub
		return false;
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
     */
	public boolean updateBlockPlayer(String username) {
		// TODO Auto-generated method stub
		return false;
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
}