package model.dao.mysql;

import java.sql.SQLException;
import java.util.*;
import businesslogic.domain.User;
import businesslogic.domain.Administrator;
import businesslogic.domain.Player;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public abstract class UserDAO {

    /**
     * Default constructor
     */
    public UserDAO() {
    }


    /**
     * @param userId 
     * @return
     * @throws SQLException 
     */
    public abstract User getUserById(int userId) throws SQLException;

    /**
     * @param email 
     * @return
     * @throws SQLException 
     */
    public abstract User getUserByEmail(String email) throws SQLException;

    /**
     * @param email 
     * @param password 
     * @return
     * @throws SQLException 
     */
    public abstract User getUserByLogin(String email, String password) throws SQLException;

    /**
     * @param email 
     * @return
     */
    public abstract boolean existsByEmail(String email);

    /**
     * @param username 
     * @return
     */
    public abstract boolean existsUsername(String username);

    /**
     * @param email 
     * @return
     */
    public abstract User deleteUserByEmail(String email);

    /**
     * @param username 
     * @return
     */
    public abstract boolean deletePlayerByUsername(String username);

    /**
     * @param email 
     * @param password 
     * @return
     */
    public abstract boolean updateAdministratorProfile(String email, String password);

    /**
     * @param username 
     * @return
     */
    public abstract boolean updateBlockPlayer(String username);

    /**
     * @param username 
     * @param email 
     * @param password 
     * @param country 
     * @return
     */
    public abstract boolean udaptePlayerProfile(String username, String email, String password, String country);

    /**
     * @param username 
     * @param email 
     * @param password 
     * @param dateOfBirth 
     * @param gender 
     * @param country 
     * @return
     */
    public boolean addAPlayer(String username, String email, String password, Date dateOfBirth, String gender, String country) {
        // TODO implement here
        return false;
    }

    /**
     * @param email 
     * @param password 
     * @return
     */
    public boolean addAnAdministrator(String email, String password) {
        // TODO implement here
        return false;
    }

    /**
     * @param username 
     * @return
     */
    public boolean searchPlayerStats(String username) {
        // TODO implement here
        return false;
    }

    /**
     * @param username 
     * @param played 
     * @param win 
     * @param lost 
     * @param maxPlayed 
     * @param maxWin 
     * @param maxLost 
     * @return
     */
    public ArrayList<Player> getCorrespondingPlayer(String username, int played, int win, int lost, boolean maxPlayed, boolean maxWin, boolean maxLost) {
        // TODO implement here
        return null;
    }

    /**
     * 
     * @param user
     * @return
     * @throws SQLException 
     */
	public abstract Player getPlayer(User user) throws SQLException;

	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public abstract Administrator getAdmin(User user) throws SQLException;

}