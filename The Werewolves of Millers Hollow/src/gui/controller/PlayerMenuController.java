/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported libraries/classes
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.systemelement.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class PlayerMenuController implements Initializable {
	
	/**
	 * 
	 */
	@FXML
	private TextField email;
	
	/**
	 * 
	 */
	@FXML
	private TextField password;
	
	/**
	 * 
	 */
	private User currentUser;	
	
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
	
	/**
	 * @param arg0
	 * @param arg1
	 */
	public void initialize(URL arg0, ResourceBundle arg1) {
		
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
	public User getCurrentUser() {
		return currentUser;
	}

	/**
	 * Setter of currentUser attribute.
	 * @param currentUser
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
