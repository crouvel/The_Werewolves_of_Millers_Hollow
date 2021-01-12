/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported libraries and classes
 */
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.Player;
import businesslogic.facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class PlayerMenuController implements Initializable {
		
	/**
	 * 
	 */
	private static Player currentPlayer;	
	
	/**
	 * Allows the player to create a game
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void createAGame(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameManagementView.fxml"));		
	}
	
	/**
	 * Allows the player to go to the join a game view
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void joinAGame(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/SelectAndJoinGameView.fxml"));
	}
	
	/**
	 * Allows the player to go the search player stats view
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void searchPlayerStat(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/SearchPlayerStatsView.fxml"));	
	}
	
	/**
	 * Allows the player to go to the bug report view
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void reportABug(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/ReportABugView.fxml"));
	}
	
	/**
	 * Allows the player to view his profile
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void viewProfile(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerProfileView.fxml"));
	}
	
	/**
	 * Allows the player to view his friends list
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void viewFriendsList(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/FriendManagementView.fxml"));
	}
	
	/**
	 * Allows the player to sign out
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void signOut(ActionEvent event) throws IOException {
		LoginController.setCurrentUser(null);
		PlayerMenuController.setCurrentPlayer(null);		
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/StartMenuView.fxml"));
	}
	
	//Added Methods
	
	/**
	 * Getter of currentUser attribute.
	 * @return
	 */
	public static Player getCurrentPlayer() throws IOException{
		return PlayerMenuController.currentPlayer;
	}

	/**
	 * Setter of currentUser attribute.
	 * @param currentUser
	 */
	public static void setCurrentPlayer(Player currentPlayer) throws IOException{
		PlayerMenuController.currentPlayer = currentPlayer;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		UserFacade userFacade = new UserFacade();
		try {
			currentPlayer = userFacade.getPlayer(LoginController.getCurrentUser());
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
