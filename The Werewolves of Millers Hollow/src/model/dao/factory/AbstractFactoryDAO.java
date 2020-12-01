package model.dao.factory;

import java.util.*;
import model.dao.mysql.UserDAO;

/**
 * @author Tiffany Dumaire
 */
public abstract class AbstractFactoryDAO {

    /**
     * Default constructor
     */
    public AbstractFactoryDAO() {
    }

    /**
     * 
     */
    public static AbstractFactoryDAO instance = null;


    /**
     * @return
     */
    public static AbstractFactoryDAO getInstance() {
        // TODO implement here
        return null;
    }

    /**
     * @param factory
     */
    public void setInstance(AbstractFactoryDAO factory) {
        // TODO implement here
    }

    /**
     * @return
     */
    public abstract UserDAO createUserDAO();

}