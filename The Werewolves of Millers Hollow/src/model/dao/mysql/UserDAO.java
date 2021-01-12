/**
 * package model.dao.mysql
 */
package model.dao.mysql;

/**
 * Imported classes and libraries.
 */
import java.sql.SQLException;
import java.util.*;
import businesslogic.domain.User;
import businesslogic.domain.Administrator;
import businesslogic.domain.Player;

/**
 * @author Tiffany Dumaire, Aaron Lazaroo
 */
public abstract class UserDAO {

    /**
     * Default constructor
     */
    public UserDAO() {}

    /**
     * Search and return the user corresponding to the userId in parameter.
     * @param userId 
     * @return a user
     * @throws SQLException 
     */
    public abstract User getUserById(int userId) throws SQLException;

    /**
     * Search and return the user corresponding to the email in parameter.
     * @param email 
     * @return a user
     * @throws SQLException 
     */
    public abstract User getUserByEmail(String email) throws SQLException;

    /**
     * Search and return the user corresponding to the login information in parameter.
     * @param email 
     * @param password 
     * @return a user
     * @throws SQLException 
     */
    public abstract User getUserByLogin(String email, String password) throws SQLException;

    /**
     * Search and return the user corresponding to the email in parameter exists.
     * @param email 
     * @return true if the user exists, else false.
     * @throws SQLException 
     */
    public abstract boolean existsByEmail(String email) throws SQLException;

    /**
     * Search and return the username in parameter exists.
     * @param username 
     * @return true if the player username exists, else false
     * @throws SQLException 
     */
    public abstract boolean existsUsername(String username) throws SQLException;

    /**
     * Allows to delete a user
     * @param email 
     * @return
     * @throws SQLException 
     */
    public abstract boolean deleteUserByEmail(String email) throws SQLException;

    /**
     * Allows to delete a player
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean deletePlayerByUsername(String username) throws SQLException;

    /**
     * Allows to udpdate an administrator profile
     * @param email 
     * @param password 
     * @return
     * @throws SQLException 
     */
    public abstract boolean updateAdministratorProfile(String email, String password) throws SQLException;

    /**
     * Allows to block a player in the database
     * @param username 
     * @return
     * @throws SQLException 
     */
    public abstract boolean updateBlockPlayer(String username) throws SQLException;

    /**
     * Allows the update of the player profile in the database
     * @param username 
     * @param email 
     * @param password 
     * @param country 
     * @return
     * @throws SQLException 
     */
    public abstract boolean updatePlayerProfile(String username, String email, String password, String country) throws SQLException;

    /**
     * Allows to add a player (creation of a player)
     * @param username 
     * @param email 
     * @param password 
     * @param dateOfBirth 
     * @param gender 
     * @param country 
     * @return
     * @throws SQLException 
     */
    public abstract boolean addAPlayer(String username, String email, String password, java.sql.Date dateOfBirth, String gender, String country) throws SQLException;

    /**
     * 
     * @param email 
     * @param password 
     * @return
     * @throws SQLException 
     */
    public abstract boolean addAnAdministrator(String email, String password) throws SQLException;

    /**
     * Search and return the list of players corresponding to the research parameters.
     * @param username 
     * @param played 
     * @param win 
     * @param lost 
     * @param maxPlayed 
     * @param maxWin 
     * @param maxLost 
     * @return the list of player usernames
     * @throws SQLException 
     */
    public abstract ArrayList<String> getCorrespondingPlayer(String username, int played, int win, int lost, boolean maxPlayed, boolean maxWin, boolean maxLost) throws SQLException;
    
    /**
     * Search and return the player corresponding to the user in parameter.
     * @param user
     * @return a player
     * @throws SQLException 
     */
	public abstract Player getPlayer(User user) throws SQLException;

	/**
	 * Search and return the administrator corresponding to the user in parameter.
	 * @param user
	 * @return an administrator
	 * @throws SQLException
	 */
	public abstract Administrator getAdmin(User user) throws SQLException;
	
	/**
	 * Search and return the player corresponding to the username in parameter.
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public abstract Player getPlayerByUsername(String username) throws SQLException;

	/**
	 * Search and return the user exists.
	 * @param user
	 * @return true if exists, else false.
	 * @throws SQLException
	 */
	public abstract boolean exist(User user) throws SQLException;

	/**
	 * Search and return the userId of a player corresponding to the username in parameter.
	 * @param username
	 * @return a userId
	 * @throws SQLException
	 */
	public abstract int getUserIdByUsername(String username) throws SQLException ;
	
	/**
	 * Search and return the administrator corresponding to the login information in parameter.
     * @param email 
     * @param password 
     * @return an administrator
     * @throws SQLException 
     */
	public abstract Administrator getAdminByLogin(String email,String password) throws SQLException;
	
}