package businesslogic.domain;

import java.util.*;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class Player extends User {

    /**
     * Default constructor
     */
    public Player(int userId,String email, String password,int isAdmin) {
    	super(userId,email,password,isAdmin);
    }

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private Date dateOfBirth;

    /**
     * 
     */
    private String country;

    /**
     * 
     */
    private Gender gender;

    /**
     * 
     */
    public Set<Player> friendsList;

    /**
     * 
     */
    public Set<Player> invitedPlayer;


    /**
     * 
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * 
     */
    public void setUsername() {
        // TODO implement here
    }

    /**
     * 
     */
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * 
     */
    public Gender getGender() {
        return this.gender;
    }

    /**
     * 
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * 
     */
    public void setCountry() {
        // TODO implement here
    }


}