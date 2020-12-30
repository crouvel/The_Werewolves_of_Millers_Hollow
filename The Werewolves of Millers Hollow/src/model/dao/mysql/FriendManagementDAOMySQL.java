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
    public FriendManagementDAOMySQL() {}

    @Override
    public ArrayList<String> getReceivedFriendRequests(String username) throws SQLException{
    	String sqlRequest="SELECT * FROM FriendRequest WHERE invitedId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, getUserIdByUsername(username));
    	ResultSet resultSet = request.executeQuery();
    	ArrayList<String> requests = new ArrayList<String>();
        while (resultSet.next()) {
            requests.add(getUsernameByUserId(resultSet.getInt("requesterId")));
        }
        return requests;
    }

    @Override
    public ArrayList<String> getFriendList(String username) throws SQLException {
		String sqlRequest="SELECT id2 FROM Friends WHERE id1=? UNION SELECT id1 FROM Friends WHERE id2=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, getUserIdByUsername(username));
    	request.setInt(2, getUserIdByUsername(username));
    	ResultSet resultSet = request.executeQuery();
    	ArrayList<String> friends = new ArrayList<String>();
        while (resultSet.next()) {
            friends.add(getUsernameByUserId(resultSet.getInt(1)));
        }
        return friends;
    }

    @Override
    public boolean deleteRequest(String username1, String username2) throws SQLException {
    	String sqlRequest="DELETE FROM FriendRequest WHERE requesterId=? AND invitedId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, getUserIdByUsername(username1));
    	request.setInt(2, getUserIdByUsername(username2));
        request.executeUpdate();
        return !existsSentFriendRequest(username1,username2);
    }

    @Override
    public boolean deleteFromFriendList(String username1, String username2) throws SQLException {
    	String sqlRequest="DELETE FROM Friends WHERE id1=? AND id2=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, getUserIdByUsername(username1));
    	request.setInt(2, getUserIdByUsername(username2));
        request.executeUpdate();
        String sqlRequest2="DELETE FROM Friends WHERE id1=? AND id2=?";
		PreparedStatement request2 = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest2);
		request2.setInt(1, getUserIdByUsername(username2));
    	request2.setInt(2, getUserIdByUsername(username1));
        request2.executeUpdate();
        return !existsFriend(username1,username2);
    	
    }

    @Override
    public boolean refuseRequest(String username1, String username2) throws SQLException {
    	String sqlRequest="DELETE FROM FriendRequest WHERE requesterId=? AND invitedId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, getUserIdByUsername(username2));
    	request.setInt(2, getUserIdByUsername(username1));
        request.executeUpdate();
        return !existsReceivedFriendRequest(username1,username2);    	
    }

    @Override
    public boolean addFriendInList(String username1, String username2) throws SQLException {
    	String sqlRequest="DELETE FROM FriendRequest WHERE requesterId=? AND invitedId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, getUserIdByUsername(username2));
    	request.setInt(2, getUserIdByUsername(username1));
        request.executeUpdate();
        String sqlRequest2="INSERT INTO Friends(id1,id2) VALUES (?,?)";
		PreparedStatement request2 = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest2);
		request2.setInt(1, getUserIdByUsername(username1));
    	request2.setInt(2, getUserIdByUsername(username2));
        request2.executeUpdate();
        return existsFriend(username1,username2) && !existsReceivedFriendRequest(username1,username2);
    }

    @Override
    public ArrayList<String> getRequestSent(String username) throws SQLException{
    	String sqlRequest="SELECT * FROM FriendRequest WHERE requesterId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, getUserIdByUsername(username));
    	ResultSet resultSet = request.executeQuery();
    	ArrayList<String> requests = new ArrayList<String>();
        while (resultSet.next()) {
            requests.add(getUsernameByUserId(resultSet.getInt("invitedId")));
        }
        return requests;
    }

    @Override
    public boolean sendFriendRequest(String username1, String username2) throws SQLException {
    	String sqlRequest="INSERT INTO FriendRequest(requesterId, invitedId) VALUES (?,?)";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, getUserIdByUsername(username1));
    	request.setInt(2, getUserIdByUsername(username2));
        request.execute();
        return existsSentFriendRequest(username1,username2);
    }
    
    @Override
    public boolean existsFriend(String username1,String username2) throws SQLException {
    	String sqlRequest="(SELECT * FROM Friends WHERE id1=? AND id2=?) UNION (SELECT * FROM Friends WHERE id1=? AND id2=?)";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, getUserIdByUsername(username1));
    	request.setInt(2, getUserIdByUsername(username2));
    	request.setInt(3, getUserIdByUsername(username2));
    	request.setInt(4, getUserIdByUsername(username1));
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
    }
    
    @Override
    public boolean existsSentFriendRequest(String username1,String username2) throws SQLException {
    	String sqlRequest="SELECT * FROM FriendRequest WHERE requesterId=? AND invitedId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, getUserIdByUsername(username1));
    	request.setInt(2, getUserIdByUsername(username2));
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
    }
    
    @Override
    public boolean existsReceivedFriendRequest(String username1,String username2) throws SQLException {
    	String sqlRequest="SELECT * FROM FriendRequest WHERE requesterId=? AND invitedId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, getUserIdByUsername(username1));
    	request.setInt(2, getUserIdByUsername(username2));
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
    }
    
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
    public String getUsernameByUserId(int userId) throws SQLException {
		String sqlRequest="SELECT * FROM Player WHERE userId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, userId);
    	ResultSet resultSet = request.executeQuery();
    	resultSet.first();
    	return resultSet.getString("username");
    }

}