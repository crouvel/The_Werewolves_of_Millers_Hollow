package test;


/**
 * Imported classes and libraries.
 */
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import businesslogic.domain.Game;
import model.dao.factory.AbstractFactoryDAO;
import model.dao.mysql.GameManagementDAO;

/**
 * GameManagementDAOTest class.
 * @author Clarence Rouvel.
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
			 * Game with game id 166 exists in the database, supposed to return Success.
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

