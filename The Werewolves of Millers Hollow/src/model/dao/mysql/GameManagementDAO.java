/**
 * package model.dao.mysql
 */
package model.dao.mysql;

/**
 * GameManagementDAOMySQL
 * Imported classes and libraries.
 */
import java.sql.SQLException;
import java.util.ArrayList;

import businesslogic.domain.Game;

/**
 * @author Tiffany Dumaire, Aaron Lazaroo, Clarence Rouvel
 */
public abstract class GameManagementDAO {

    /**
     * Default constructor
     */
    public GameManagementDAO() {}

    /**
     * Creates a game with the corresponding number of players, status, and game creator username.
     * @param numberOfPlayers which corresponds to the number of players chosen for a game to be generated.
     * @param status which corresponds privacy status chosen for a game to be generated.
     * @return a boolean which is true if the corresponding database modification is made, otherwise returns false.
     * @throws SQLException
     *  
     */
    public abstract boolean createGame(int nbplayers, boolean status, String creator) throws SQLException;

    /**
     * Gets the game in the database by its corresponding id.
     * @param game_id which refers to the game id.
     * @return a boolean which is true if the corresponding database modifications were made, otherwise returns false.
     * @throws SQLException  
     */
    public abstract Game getGame(int game_id) throws SQLException;

    /**
     * Method that updates the game information in the database referring to the chosen roles.
     * @param numberOfWerewolves which is the number of Werewolves in the game. 
     * @param hasWitch which tells if there is the Witch special role in the game.
     * @param hasFortuneTeller which tells if there is the Fortune teller special role in the game.
     * @param hasLittleGirl which tells if there is the Little Girl special role in the game.
     * @param hasCupid which tells if there is the Cupid special role in the game.
     * @param hasHunter which tells if there is the Hunter special role in the game.
     * @return a boolean which is true if the corresponding database modifications were made, otherwise returns false.
     * @throws SQLException 
     */
    public abstract boolean modifyRole(int game_id, int numberOfWerewolves, boolean hasWitch, boolean hasFortuneTeller, boolean hasLittleGirl, boolean hasCupid, boolean hasHunter) throws SQLException;

    /**
     * Method that creates a gameRequest in the database.
     * @param game_id which refers to the id of the Game.
     * @param username1 which refers to the username of the PlayerInGame who made the invitation.
     * @param username2 which refers to the username of the Player who made is invited to join the game.
     * @return a boolean which is true if the corresponding database modifications were made, otherwise returns false.
     * @throws SQLException 
     */
    public abstract boolean inviteFriendToPlay(int game_id, String username1, String username2) throws SQLException;

    /**
     * Method that deletes the corresponding game request in the database.  
     * @param game_id which refers to the id of the game.
     * @param username1 which refers to the username of the PlayerInGame who sent the request.
     * @param username2  which refers to the username of the Player who received the request.  
     * @return a boolean which is true if the corresponding database modifications were made, otherwise returns false.
     * @throws SQLException 
     */
    public abstract boolean cancelRequest(int game_id, String username1, String username2) throws SQLException;

    /**
     * Method that deletes the corresponding PlayerIngame from a Game through the database.
     * @param game_id which refers to the id of the game.
     * @param username which refers to the PlayerInGame selected to be kicked by the game creator.
     * @return a boolean which is true if the corresponding database modifications were made, otherwise returns false.
     * @throws SQLException 
     */
    public abstract boolean kickPlayerOutOfTheGame(int game_id, String username) throws SQLException;

    /**
     * Method that deletes the corresponding game in the database.
     * @param game_id which refers to the id of the game.
     * @return a boolean which is true if the corresponding database modifications were made, otherwise returns false.
     * @throws SQLException 
     */
    public abstract boolean deleteGame(int game_id) throws SQLException;

    /**
     * Method that gets the corresponding Game by its creator. The method also checks if the game is available
     * to return the correct game and not the previous games created by the same Player which are not available anymore.
     * @param creator which refers the the creator of the game.
     * @return the corresponding Game by its creator.
     * @throws SQLException
     */
    public abstract Game getGameByCreator( String creator) throws SQLException;
    
    /**
     * Method that returns all the Players friends invited by the same PlayerInGame in the corresponding game. 
     * @param gameId which refers to the id of the game.
     * @param username which refers to the invited friend list Player username.  
     * @return the ArrayList of the PlayerInGame friends invited in the game.
     * @throws SQLException
     */
    public abstract ArrayList<String> getInvitedFriend(int gameId, String username) throws SQLException;
    
    /**
     * Method that returns all the PlayerInGame in a Game.
     * @param gameId which refers to the id of the game.
     * @return the ArrayList of all the PlayerInGame who are in the game lobby.
     * @throws SQLException
     */
    public abstract ArrayList<String> getPlayer(int gameId) throws SQLException;

    /**
     * Method that checks of the corresponding game with parameters exists in the database.
     * @param game_id which refers to the id of the game.
     * @param numberOfWerewolves which is the number of Werewolves in the game.
     * @param hasWitch which tells if there is the Witch special role in the game.
     * @param hasFortuneTeller which tells if there is the Fortune teller special role in the game.
     * @param hasLittleGirl which tells if there is the Little Girl special role in the game.
     * @param hasCupid which tells if there is the Cupid special role in the game.
     * @param hasHunter which tells if there is the Hunter special role in the game.
     * @return a boolean which is true if the corresponding game with parameters is in the database, otherwise returns false.
     * @throws SQLException
     */
	public abstract boolean existsGamewithParams(int game_id, int numberOfWerewolves, boolean hasWitch, boolean hasFortuneTeller, boolean hasLittleGirl, boolean hasCupid, boolean hasHunter) throws SQLException;

	/**
	 * Method that checks if the corresponding game requesdt exists in the database.
	 * @param game_id which refers to the id of the game.
	 * @param username1 which refers to the username of the PlayerInGame who sent the request.
	 * @param username2 which refers to the username of the Player who received the request.
	 * @return a boolean which is true if the corresponding game request is in the database, otherwise returns false.
	 * @throws SQLException
	 */
	public abstract boolean existsGameRequest(int game_id, String username1, String username2) throws SQLException;

	/**
	 * Method that checks if the corresponding game exists in the database by its game creator username.
	 * @param username which refers to the username of the game creator. 
	 * @return a boolean which is true if the corresponding game is in the database, otherwise returns false.
	 * @throws SQLException
	 */
	public abstract boolean existsGame2(String username) throws SQLException;

	/**
	 * Method that checks if the corresponding game exists in the database by its id.
	 * @param game_id which refers to the id of the game. 
	 * @return a boolean which is true if the corresponding game is in the database, otherwise returns false.
	 * @throws SQLException
	 */
	public abstract boolean existsGame(int game_id) throws SQLException;

	/**
	 * Method that checks if the PlayerInGame exists in the corresponding game.
	 * @param username which refers to the PlayerInGame username.
	 * @param game_id which refers to the id of the game.
	 * @return a boolean which is true if the corresponding game PlayerInGame exists in the database, otherwise returns false.
	 * @throws SQLException
	 */
	public abstract boolean existsPlayerInGame(String username, int game_id) throws SQLException;

	/**
	 * Method that deletes the game in the database by its corresponding creator username.
	 * @param creatorUsername which refers to the username of the game creator. 
	 * @return a boolean which is true if the corresponding database modifications were made, otherwise returns false.
	 * @throws SQLException
	 */
	public abstract boolean deleteGame2(String creatorUsername) throws SQLException;

	/**
	 * Method that updates PlayerInGame information by adding a role to him.
	 * @param username which refers to the PlayerInGame username. 
	 * @return a boolean which is true if the corresponding database modifications were made, otherwise returns false.
	 * @throws SQLException
	 */
	public abstract boolean updatePlayerInGame(int gameId, String username, String role) throws SQLException;

}