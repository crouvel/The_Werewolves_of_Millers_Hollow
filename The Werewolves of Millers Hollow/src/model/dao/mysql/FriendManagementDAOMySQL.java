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
     * @throws SQLException 
     */
    public boolean deleteRequest(String username1, String username2) throws SQLException {
    	String sqlRequest="DELETE FROM FriendRequest WHERE requesterUsername=? AND invitedUsername=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username1);
    	request.setString(2, username2);
        request.executeUpdate();
        return !existsSentFriendRequest(username1,username2);
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     * @throws SQLException 
     */
    public boolean deleteFromFriendList(String username1, String username2) throws SQLException {
    	String sqlRequest="DELETE FROM Friends WHERE username=? AND username2=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username1);
    	request.setString(2, username2);
        request.executeUpdate();
        String sqlRequest2="DELETE FROM Friends WHERE username=? AND username2=?";
		PreparedStatement request2 = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest2);
    	request2.setString(1, username2);
    	request2.setString(2, username1);
        request2.executeUpdate();
        return !existsFriend(username1,username2);
    	
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     * @throws SQLException 
     */
    public boolean refuseRequest(String username1, String username2) throws SQLException {
    	String sqlRequest="DELETE FROM FriendRequest WHERE requesterUsername=? AND invitedUsername=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username2);
    	request.setString(2, username1);
        request.executeUpdate();
        return !existsReceivedFriendRequest(username1,username2);    	
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     * @throws SQLException 
     */
    public boolean addFriendInList(String username1, String username2) throws SQLException {
    	String sqlRequest="DELETE FROM FriendRequest WHERE requesterUsername=? AND invitedUsername=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username2);
    	request.setString(2, username1);
        request.executeUpdate();
        String sqlRequest2="INSERT INTO Friends(username,username2) VALUES (?,?)";
		PreparedStatement request2 = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest2);
    	request2.setString(1, username1);
    	request2.setString(2, username2);
        request2.executeUpdate();
        return existsFriend(username1,username2) && !existsReceivedFriendRequest(username1,username2);
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
     * @throws SQLException 
     */
    public boolean sendFriendRequest(String username1, String username2) throws SQLException {
    	String sqlRequest="INSERT INTO FriendRequest(requesterUsername, invitedUsername) VALUES (?,?)";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username1);
    	request.setString(2, username2);
        request.execute();
        return existsSentFriendRequest(username1,username2);
    }
    
    /**
     * 
     * @param username1
     * @param username2
     * @return
     * @throws SQLException
     */
    public boolean existsFriend(String username1,String username2) throws SQLException {
    	String sqlRequest="(SELECT * FROM Friends WHERE username=? AND username2=?) UNION (SELECT * FROM Friends WHERE username=? AND username2=?)";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username1);
    	request.setString(2, username2);
    	request.setString(3, username2);
    	request.setString(4, username1);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
    }
    
    /**
     * 
     * @param username1
     * @param username2
     * @return
     * @throws SQLException
     */
    public boolean existsSentFriendRequest(String username1,String username2) throws SQLException {
    	String sqlRequest="SELECT * FROM FriendRequest WHERE requesterUsername=? AND invitedUsername=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username1);
    	request.setString(2, username2);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
    }
    
    /**
     * 
     * @param username1
     * @param username2
     * @return
     * @throws SQLException
     */
    public boolean existsReceivedFriendRequest(String username1,String username2) throws SQLException {
    	String sqlRequest="SELECT * FROM FriendRequest WHERE requesterUsername=? AND invitedUsername=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setString(1, username2);
    	request.setString(2, username1);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
    }

}