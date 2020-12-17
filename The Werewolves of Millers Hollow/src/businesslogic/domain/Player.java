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
    private int playedGames;
    
    /**
     * 
     */
    private int wonGames;
    
    /**
     * 
     */
    private int lostGames;
    
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

	/**
	 * @return the winGames
	 */
	public int getWonGames() {
		return wonGames;
	}

	/**
	 * @param winGames the winGames to set
	 */
	public void setWonGames(int wonGames) {
		this.wonGames = wonGames;
	}

	/**
	 * @return the playedGames
	 */
	public int getPlayedGames() {
		return playedGames;
	}

	/**
	 * @param playedGames the playedGames to set
	 */
	public void setPlayedGames(int playedGames) {
		this.playedGames = playedGames;
	}

	/**
	 * @return the lostGames
	 */
	public int getLostGames() {
		return lostGames;
	}

	/**
	 * @param lostGames the lostGames to set
	 */
	public void setLostGames(int lostGames) {
		this.lostGames = lostGames;
	}


}