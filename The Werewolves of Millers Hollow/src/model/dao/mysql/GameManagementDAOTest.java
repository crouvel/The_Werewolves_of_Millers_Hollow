package model.dao.mysql;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import businesslogic.domain.Game;
import model.dao.factory.AbstractFactoryDAO;

class GameManagementDAOTest {

	/*
	 * Checks if the game is retrieved from the database
	 */
	@Test
	void testGetGame() {
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
	       try {
	        GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();
	        
	        /**
	         * Game with id 166 exists in the database, supposed to return Succes.
	         */
	        Game game = gameManagementDAO.getGame(166);
	        if (game != null) {
                System.out.println("createSprintBacklog: Success");
            }
            else{
                System.out.println("createSprintBacklog: Failed, function tells us something went wrong during the procedure");
            }
	       
	       }catch(SQLException e) {
	    	   e.printStackTrace();
	       }
	    }
	}

