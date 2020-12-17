package businesslogic.domain;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class PlayerInGame {

    /**
     * Default constructor
     */
    public PlayerInGame() {
    }

    /**
	 * @return the creator
	 */
	public boolean isCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(boolean creator) {
		this.creator = creator;
	}

	/**
	 * @return the proposeAsASheriff
	 */
	public boolean isProposeAsASheriff() {
		return proposeAsASheriff;
	}

	/**
	 * @param proposeAsASheriff the proposeAsASheriff to set
	 */
	public void setProposeAsASheriff(boolean proposeAsASheriff) {
		this.proposeAsASheriff = proposeAsASheriff;
	}

	/**
	 * @return the isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * @param isAlive the isAlive to set
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the isSheriff
	 */
	public boolean isSheriff() {
		return isSheriff;
	}

	/**
	 * @param isSheriff the isSheriff to set
	 */
	public void setSheriff(boolean isSheriff) {
		this.isSheriff = isSheriff;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 */
	private String username;
	
	/**
     * 
     */
    private boolean creator;

    /**
     * 
     */
    private boolean proposeAsASheriff;

    /**
     * 
     */
    private boolean isAlive;

    /**
     * 
     */
    private Role role;

    /**
     * 
     */
    private boolean isSheriff;



}