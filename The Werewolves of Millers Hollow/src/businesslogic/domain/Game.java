package businesslogic.domain;

/**
 * @author Tiffany Dumaire, Aaron Lazaroo, Clarence Rouvel
 */


public class Game {
    
    /**
     * Constructor of Game
     * @param numberOfPlayers
     * @param status
     * @param numberOfWerewolves
     * @param hasWitch
     * @param hasLittleGirl
     * @param hasCupid
     * @param hasHunter
     * @param hasFortuneTeller
     * @param finish
     * @param currentPhase
     * @param availableGame
     * @param creator
     */
    public Game(int numberOfPlayers, boolean status, int numberOfWerewolves, boolean hasWitch,
    		boolean hasLittleGirl, boolean hasCupid, boolean hasHunter, boolean hasFortuneTeller, boolean finish,
			Phase currentPhase, boolean availableGame, String creator) {
		super();
		this.numberOfPlayers = numberOfPlayers;
		this.status = status;
		this.numberOfWerewolves = numberOfWerewolves;
		this.hasWitch = hasWitch;
		this.hasLittleGirl = hasLittleGirl;
		this.hasCupid = hasCupid;
		this.hasHunter = hasHunter;
		this.hasFortuneTeller = hasFortuneTeller;
		this.finish = finish;
		this.currentPhase = currentPhase;
		this.availableGame = availableGame;
		this.setCreatorUsername(creatorUsername);
	
	}
    
    /**
     * Constructor of Game
     * @param game_id
     * @param numberOfPlayers
     * @param status
     * @param numberOfWerewolves
     * @param hasWitch
     * @param hasLittleGirl
     * @param hasCupid
     * @param hasHunter
     * @param hasFortuneTeller
     * @param finish
     * @param currentPhase
     * @param availableGame
     */
    public Game(int game_id, int numberOfPlayers, boolean status, int numberOfWerewolves, boolean hasWitch, boolean hasLittleGirl, boolean hasCupid,
			boolean hasHunter, boolean hasFortuneTeller, boolean finish, Phase currentPhase, boolean availableGame) {
		super();
		this.game_id = game_id;
		this.numberOfPlayers = numberOfPlayers;
		this.status = status;
		this.numberOfWerewolves = numberOfWerewolves;
		this.hasWitch = hasWitch;
		this.hasLittleGirl = hasLittleGirl;
		this.hasCupid = hasCupid;
		this.hasHunter = hasHunter;
		this.hasFortuneTeller = hasFortuneTeller;
		this.finish = finish;
		this.currentPhase = currentPhase;
		this.availableGame = availableGame;
		
	}
    
    /**
     * Constructor of Game
     * @param game_id
     * @param numberOfPlayers
     * @param status
     * @param numberOfWerewolves
     * @param hasWitch
     * @param hasLittleGirl
     * @param hasCupid
     * @param hasHunter
     * @param hasFortuneTeller
     * @param finish
     * @param currentPhase
     * @param availableGame
     * @param creatorUsername
     */
	public Game(int game_id, int numberOfPlayers, boolean status, int numberOfWerewolves, boolean hasWitch, boolean hasLittleGirl, boolean hasCupid,
			boolean hasHunter, boolean hasFortuneTeller, boolean finish, Phase currentPhase, boolean availableGame,
			String creatorUsername) {
		super();
		this.game_id = game_id;
		this.numberOfPlayers = numberOfPlayers;
		this.status = status;
		this.numberOfWerewolves = numberOfWerewolves;
		this.hasWitch = hasWitch;
		this.hasLittleGirl = hasLittleGirl;
		this.hasCupid = hasCupid;
		this.hasHunter = hasHunter;
		this.hasFortuneTeller = hasFortuneTeller;
		this.finish = finish;
		this.currentPhase = currentPhase;
		this.availableGame = availableGame;
		this.setCreatorUsername(creatorUsername);
	}
	/**
     * 
     * @param hasHunter
     */
	public void setHasHunter(boolean hasHunter) {
		this.hasHunter = hasHunter;
	}

	/**
	 * @return the hasFortuneTeller
	 */
	public boolean isHasFortuneTeller() {
		return hasFortuneTeller;
	}

	/**
	 * @param hasFortuneTeller the hasFortuneTeller to set
	 */
	public void setHasFortuneTeller(boolean hasFortuneTeller) {
		this.hasFortuneTeller = hasFortuneTeller;
	}

	/**
	 * @return the finish
	 */
	public boolean isFinish() {
		return finish;
	}

	/**
	 * @param finish the finish to set
	 */
	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	/**
	 * @return the currentPhase
	 */
	public Phase getCurrentPhase() {
		return currentPhase;
	}

	/**
	 * @param currentPhase the currentPhase to set
	 */
	public void setCurrentPhase(Phase currentPhase) {
		this.currentPhase = currentPhase;
	}

	/**
	 * @return the game_id
	 */
	public  int getGame_id() {
		return this.game_id;
	}

	/**
	 * @param game_id the game_id to set
	 */
	public  void setGame_id(int game_id) {
		this.game_id = game_id;
	}

	/**
	 * @return the numberOfPlayers
	 */
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	/**
	 * @param numberOfPlayers the numberOfPlayers to set
	 */
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the numberOfWerewolves
	 */
	public int getNumberOfWerewolves() {
		return numberOfWerewolves;
	}

	/**
	 * @param numberOfWerewolves the numberOfWerewolves to set
	 */
	public void setNumberOfWerewolves(int numberOfWerewolves) {
		this.numberOfWerewolves = numberOfWerewolves;
	}

	/**
	 * @return the hasWitch
	 */
	public boolean isHasWitch() {
		return hasWitch;
	}

	/**
	 * @param hasWitch the hasWitch to set
	 */
	public void setHasWitch(boolean hasWitch) {
		this.hasWitch = hasWitch;
	}

	/**
	 * @return the hasLittleGirl
	 */
	public boolean isHasLittleGirl() {
		return hasLittleGirl;
	}

	/**
	 * @param hasLittleGirl the hasLittleGirl to set
	 */
	public void setHasLittleGirl(boolean hasLittleGirl) {
		this.hasLittleGirl = hasLittleGirl;
	}

	/**
	 * @return the hasCupid
	 */
	public boolean isHasCupid() {
		return hasCupid;
	}

	/**
	 * @param hasCupid the hasCupid to set
	 */
	public void setHasCupid(boolean hasCupid) {
		this.hasCupid = hasCupid;
	}

	/**
	 * @return the availableGame
	 */
	public boolean isAvailableGame() {
		return availableGame;
	}

	/**
	 * @param availableGame the availableGame to set
	 */
	public void setAvailableGame(boolean availableGame) {
		this.availableGame = availableGame;
	}
	
	/**
	 * @return the creatorUsername
	 */
	public String getCreatorUsername() {
		return creatorUsername;
	}
	/**
	 * @param creatorUsername the creatorUsername to set
	 */
	public void setCreatorUsername(String creatorUsername) {
		this.creatorUsername = creatorUsername;
	}
	
	/**
	 * @return the information of the game
	 */
	public String toString() {
		return creatorUsername;
	}

	/**
	 * Attribute which contains if it's an available game or not
	 */
	private boolean availableGame;

	
    /**
     * @return the hasHunter attribute
     */
    public boolean isHasHunter() {
		return hasHunter;
	}

	/**
     * 
     */
    private int game_id;

    /**
     * 
     */
    private int numberOfPlayers;

    /**
     * 
     */
    private boolean status;

    /**
     * 
     */
    private int numberOfWerewolves;

    /**
     * 
     */
    private boolean hasWitch;

    /**
     * 
     */
    private boolean hasLittleGirl;

    /**
     * 
     */
    private boolean hasCupid;

    /**
     * 
     */
    private boolean hasHunter;

    /**
     * 
     */
    private boolean hasFortuneTeller;

    /**
     * 
     */
    private boolean finish;


    /**
     * 
     */
    private Phase currentPhase;
    
    /**
     * 
     */
   
    private String creatorUsername;
}