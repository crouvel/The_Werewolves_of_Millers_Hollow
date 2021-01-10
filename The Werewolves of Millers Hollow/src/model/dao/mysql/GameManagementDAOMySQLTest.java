package model.dao.mysql;



import java.sql.SQLException;
import model.dao.factory.AbstractFactoryDAO;

/**
 * 
 * @author clare
 *
 */
class GameManagementDAOMySQLTest {

	
		
		public static void main(String[] args) {
	        AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
	       try {
	        GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();
	        System.out.println(gameManagementDAO.getGame(166));
	       }catch(SQLException e) {
	    	   e.printStackTrace();
	       }
	    }


}
