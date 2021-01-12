/**
 * @package businesslogic.domain
 */
package businesslogic.domain;


/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class Administrator extends User {

    /**
     * Constructor of Administrator
     * @param userId
     * @param email
     * @param password
     * @param isAdmin
     */
    public Administrator(int userId,String email, String password,int isAdmin) {
    	super(userId,email,password,isAdmin);
    }

}