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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void createAGame(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameManagementView.fxml"));	
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void joinAGame(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/SelectAndJoinGameView.fxml"));
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void searchPlayerStat(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/SearchPlayerStatsView.fxml"));	
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void reportABug(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/ReportABugView.fxml"));
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void viewProfile(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerProfileView.fxml"));
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void viewFriendsList(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/FriendManagementView.fxml"));
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void signOut(ActionEvent event) throws IOException {
		//à terminer
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/StartMenuView.fxml"));
	}
	
	//Added Methods
	
	/**
	 * Open an info box.
	 * @param message
	 * @param head
	 * @param title
	 */
	public static void infoBox(String message, String head, String title){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(head);
        alert.showAndWait();
    }

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
