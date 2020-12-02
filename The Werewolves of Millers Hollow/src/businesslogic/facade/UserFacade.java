package businesslogic.facade;

import businesslogic.systemelement.User;
import model.dao.factory.AbstractFactoryDAO;
import model.dao.mysql.UserDAO;

/**
 * @author Tiffany Dumaire
 */
public class UserFacade {

    /**
     * Default constructor
     */
    public UserFacade() {
    }

    /**
     * 
     */
    private User currentUser;


    /**
     * @param email 
     * @param password 
     * @return
     */
    public User login(String email, String password) {
        // TODO implement here
        return null;
    }

    /**
     * @param email 
     * @param password 
     * @return
     */
    public User register(String email, String password) {
        return login(email, password);
    }

    /**
     * @return
     */
    public User getCurrentUser() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int getCurrentUserId() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public String getCurrentUserEmail() {
        // TODO implement here
        return "";
    }

}