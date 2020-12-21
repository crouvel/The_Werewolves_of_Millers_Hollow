package model.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.dao.factory.AbstractFactoryDAO;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class FriendManagementDAOMySQL extends FriendManagementDAO {

    /**
     * Default constructor
     */
    public FriendManagementDAOMySQL() {
    }

    /**
     * @param username 
     * @return
     * @throws SQLException 
     */
    public ArrayList<String> getReceivedFriendRequests(String username) throws SQLException{
    	String sqlRequest="SELECT * FROM FriendRequest WHERE invitedUsername=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username);
    	ResultSet resultSet = request.executeQuery();
    	ArrayList<String> requests = new ArrayList<String>();
        while (resultSet.next()) {
            requests.add(resultSet.getString("requesterUsername"));
        }
        return requests;
    }

    /**
     * @param username 
     * @return
     * @throws SQLException
     */
    public ArrayList<String> getFriendList(String username) throws SQLException {
		String sqlRequest="SELECT username2 FROM Friends WHERE username=? UNION SELECT username FROM Friends WHERE username2=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username);
    	request.setString(2, username);
    	ResultSet resultSet = request.executeQuery();
    	ArrayList<String> friends = new ArrayList<String>();
        while (resultSet.next()) {
            friends.add(resultSet.getString(1));
        }
        return friends;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean deleteRequest(String username1, String username2) {
    	return true;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean deleteFromFriendList(String username1, String username2) {
    	return true;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean refuseRequest(String username1, String username2) {
    	return true;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean addFriendInList(String username1, String username2) {
    	return true;
    }

    /**
     * @param username 
     * @return
     * @throws SQLException 
     */
    public ArrayList<String> getRequestSent(String username) throws SQLException{
    	String sqlRequest="SELECT * FROM FriendRequest WHERE requesterUsername=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username);
    	ResultSet resultSet = request.executeQuery();
    	ArrayList<String> requests = new ArrayList<String>();
        while (resultSet.next()) {
            requests.add(resultSet.getString("invitedUsername"));
        }
        return requests;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean sendFriendRequest(String username1, String username2) {
    	return true;
    }

}