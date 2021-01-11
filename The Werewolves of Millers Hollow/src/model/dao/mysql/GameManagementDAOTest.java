package model.dao.mysql;


/**
 * Imported classes and libraries.
 */
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import businesslogic.domain.Game;
import model.dao.factory.AbstractFactoryDAO;

/**
 * GameManagementDAOTest class.
 * @author clare
 */
class GameManagementDAOTest {

	/**
	 * Checks if the game is retrieved from the database
	 * @return void.
	 */
	@Test
	void testGetGame() {
		AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
		try {
			GameManagementDAO gameManagementDAO  = factory.createGameManagementDAO();

			/**
			 * Game with id 166 exists in the database, supposed to return Success.
			 */
			Game game = gameManagementDAO.getGame(166);
			if (game != null) {
				System.out.println("getGame: Success");
			}
			else{
				System.out.println("getGame: Failed, function tells us something went wrong during the procedure");
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}

