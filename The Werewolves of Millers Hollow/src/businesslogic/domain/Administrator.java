package businesslogic.domain;


/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class Administrator extends User {

    /**
     * Default constructor
     */
    public Administrator(int userId,String email, String password,int isAdmin) {
    	super(userId,email,password,isAdmin);
    }

}