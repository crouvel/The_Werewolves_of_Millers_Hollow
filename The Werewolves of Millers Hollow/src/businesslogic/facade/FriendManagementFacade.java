package businesslogic.facade;

import java.util.*;
import businesslogic.domain.Player;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class FriendManagementFacade {

    /**
     * Default constructor
     */
    public FriendManagementFacade() {
    }



    /**
     * 
     */
    private Player currentPlayer;

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean sendRequest(String username1, String username2) {
        // TODO implement here
        return false;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean acceptFriendRequest(String username1, String username2) {
        // TODO implement here
        return false;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean cancelFriendRequest(String username1, String username2) {
        // TODO implement here
        return false;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean deleteFriend(String username1, String username2) {
        // TODO implement here
        return false;
    }

    /**
     * @param username1 
     * @param username2 
     * @return
     */
    public boolean refuseFriendRequest(String username1, String username2) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public Player getCurrentPlayer() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getCurrentPlayerUsername() {
        // TODO implement here
        return "";
    }

    /**
     * @param username 
     * @return
     */
    public ArrayList<Player> getFriendList(String username) {
        // TODO implement here
        return null;
    }

    /**
     * @param username 
     * @return
     */
    public ArrayList<Player> getFriendRequests(String username) {
        // TODO implement here
        return null;
    }

}