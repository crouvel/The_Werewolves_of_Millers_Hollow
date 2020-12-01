package model.dao.mysql;

import java.util.*;

import businesslogic.systemelement.User;

/**
 * @author Tiffany Dumaire
 */
public abstract class UserDAO{

    /**
     * Default constructor
     */
    public UserDAO() {
    }



    /**
     * @param userId 
     * @return
     */
    public abstract User getUserById(int userId);

    /**
     * @param email 
     * @return
     */
    public abstract User getUserByEmail(String email);

}