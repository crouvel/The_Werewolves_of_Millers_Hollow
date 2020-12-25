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
    	this.gender = "MALE";
    	this.country = "";
    	this.playedGames = 0;
    	this.wonGames = 0;
    	this.lostGames = 0;
    	this.setFriendsList(new ArrayList<Player>());
    	this.setInvitedPlayer(new ArrayList<Player>());
    }
    
    /**
     * 
     * @param userId
     * @param email
     * @param password
     * @param isAdmin
     * @param username
     * @param dateOfBirth
     * @param gender
     * @param country
     */
    public Player(int userId,String email, String password,int isAdmin, String username, Date dateOfBirth, String gender, String country) {
    	super(userId,email,password,isAdmin);
    	this.username = username;
    	this.dateOfBirth = dateOfBirth;
    	this.gender = gender;
    	this.country = country;
    	this.playedGames = 0;
    	this.wonGames = 0;
    	this.lostGames = 0;
    	this.setFriendsList(new ArrayList<Player>());
    	this.setInvitedPlayer(new ArrayList<Player>());
    }
    
    /**
     * 
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
     */
    public Player(int userId,String email, String password,int isAdmin, String username, Date dateOfBirth, String gender, String country,int playedGames,int wonGames, int lostGames) {
    	this(userId,email,password,isAdmin,username,dateOfBirth,gender,country);
    	this.playedGames = playedGames;
    	this.wonGames = wonGames;
    	this.lostGames = lostGames;
    	this.setFriendsList(new ArrayList<Player>());
    	this.setInvitedPlayer(new ArrayList<Player>());
    }
    
    /**
     * 
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
     * @param friendList
     * @param invitedFriends
     */
    public Player(int userId,String email, String password,int isAdmin, String username, Date dateOfBirth, String gender, String country,int playedGames,int wonGames, int lostGames,ArrayList<Player> friendList,ArrayList<Player> invitedFriends) {
    	this(userId,email,password,isAdmin,username,dateOfBirth,gender,country,playedGames,wonGames,lostGames);
    	this.setFriendsList(friendList);
    	this.setInvitedPlayer(invitedFriends);
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
    private String gender;
    
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
     * Attribute corresponds to the friend list.
     */
    private ArrayList<Player> friendsList;

    /**
     * Attribute corresponds to the invited player list.
     */
    private ArrayList<Player> invitedPlayer;


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
    public String getGender() {
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
	 * @return the friendsList
	 */
	public ArrayList<Player> getFriendsList() {
		return friendsList;
	}

	/**
	 * @param friendsList the friendsList to set
	 */
	public void setFriendsList(ArrayList<Player> friendsList) {
		this.friendsList = friendsList;
	}

	/**
	 * @return the invitedPlayer
	 */
	public ArrayList<Player> getInvitedPlayer() {
		return invitedPlayer;
	}

	/**
	 * @param invitedPlayer the invitedPlayer to set
	 */
	public void setInvitedPlayer(ArrayList<Player> invitedPlayer) {
		this.invitedPlayer = invitedPlayer;
	}


}