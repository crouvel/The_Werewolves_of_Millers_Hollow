package businesslogic.domain;

import java.util.*;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class Player extends User {

    /**
     * Basic constructor.
     * @param userId
     * @param email
     * @param password
     * @param isAdmin
     */
    public Player(int userId,String email, String password,int isAdmin) {
    	super(userId,email,password,isAdmin);
    	this.username = "";
    	this.dateOfBirth = null;
    	this.gender = Gender.MALE;
    	this.country = "";
    	this.playedGames = 0;
    	this.wonGames = 0;
    	this.lostGames = 0;
    	this.status = 1;
    }
    
   /**
    * Constructor of player
    * @param userId
    * @param email
    * @param password
    * @param isAdmin
    * @param username
    * @param dateOfBirth
    * @param gender
    * @param country
    * @param status
    */
    public Player(int userId,String email, String password,int isAdmin, String username, Date dateOfBirth, Gender gender, String country,int status) {
    	super(userId,email,password,isAdmin);
    	this.username = username;
    	this.dateOfBirth = dateOfBirth;
    	this.gender = gender;
    	this.country = country;
    	this.playedGames = 0;
    	this.wonGames = 0;
    	this.lostGames = 0;
    	this.status = status;
    }
    
    /**
     * Constructor of player
     * @param userId
     * @param email
     * @param password
     * @param isAdmin
     * @param username
     * @param dateOfBirth
     * @param gender
     * @param country
     * @param playedGames
     * @param wonGames
     * @param lostGames
     * @param status
     */
    public Player(int userId,String email, String password,int isAdmin, String username, Date dateOfBirth, Gender gender, String country,int playedGames,int wonGames, int lostGames,int status) {
    	this(userId,email,password,isAdmin,username,dateOfBirth,gender,country,status);
    	this.playedGames = playedGames;
    	this.wonGames = wonGames;
    	this.lostGames = lostGames;
    }

    /**
     * Attribute corresponds to the username.
     */
    private String username;

    /**
     * Attribute corresponds to the date of birth.
     */
    private Date dateOfBirth;

    /**
     * Attribute corresponds to the country.
     */
    private String country;

    /**
     * Attribute corresponds to the gender.
     */
    private Gender gender;
    
    /**
     * Attribute corresponds to the number of played games.
     */
    private int playedGames;
    
    /**
     * Attribute corresponds to the number of won games.
     */
    private int wonGames;
    
    /**
     * Attribute corresponds to the number of lost games.
     */
    private int lostGames;
    
    /**
     * 1 if public, 0 if private
     */
    private int status;
    
    /**
     * @return the username of the player
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @param username : the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the data of birth of the player 
     */
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * @return the gender of the player
     */
    public Gender getGender() {
        return this.gender;
    }

    /**
     * @return the country of the player
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * @param country : the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

	/**
	 * @return the number of win Games of the player
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
	 * @return the number of played Games of the player
	 */
	public int getPlayedGames() {
		return playedGames;
	}

	/**
	 * @param playedGames : the playedGames to set
	 */
	public void setPlayedGames(int playedGames) {
		this.playedGames = playedGames;
	}

	/**
	 * @return the number of lost Games of the player
	 */
	public int getLostGames() {
		return lostGames;
	}

	/**
	 * @param lostGames : the lostGames to set
	 */
	public void setLostGames(int lostGames) {
		this.lostGames = lostGames;
	}

	/**
	 * @return the status
	 */
	public int isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

}