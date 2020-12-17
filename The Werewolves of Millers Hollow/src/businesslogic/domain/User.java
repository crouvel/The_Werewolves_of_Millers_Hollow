package businesslogic.domain;


/**
 * @author Tiffany Dumaire
 */
public class User {

    /**
     * Default constructor
     */
    public User(int userId,String email, String password,int isAdmin) {
    	this.userId=userId;
    	this.email=email;
    	this.password=password;
    	this.isAdmin=isAdmin;
    	this.isLockedAccount = false;
    }

    /**
     * 
     */
    private int userId;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String password;
    
    /**
     * 
     */
    private int isAdmin;
    
    /**
     * 
     */
    public boolean isLockedAccount;

    /**
     * @return
     */
    public int getId() {
        return this.userId;
    }

    /**
     * @return
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
    	this.email=email;
    }

    /**
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
    	this.password=password;
    }

    /**
     * 
     * @return
     */
	public int isAdmin() {
		return isAdmin;
	}
	
	/**
	 * 
	 * @param isAdmin
	 */
	public void setAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
    /**
     * @return
     */
    public boolean isLockedAccount() {
        // TODO implement here
        return false;
    }

    /**
     * @param isLocked
     */
    public void setIsLockedAccount(boolean isLocked) {
        // TODO implement here
    }
    

}