/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported libraries and classes.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class FriendManagementController implements Initializable {
	
	//FXML Attributes
	
	/**
	 * Attribute uses for add a friend.
	 */
	@FXML
	private TextField addFriendUsername;
	
	/**
	 * Attribute containing the player's friends list.
	 */
	@FXML
	private ListView<Player> friendsList;
	
	/**
	 * Attribute containing the player's sent friend requests.
	 */
	@FXML
	private ListView<Player> sent;
	
	/**
	 * Attribute containing the player's received friend requests.
	 */
	@FXML
	private ListView<Player> receive;
	
	//FXML Methods
	
	/**
	 * Allows the player to accept the selected friend request in the receive ListView.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void accept(ActionEvent event) throws IOException {

	}
	
	/**
	 * Allows the player to refuse the selected friend request in the receive ListView.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void refuse(ActionEvent event) throws IOException {

	}
	
	/**
	 * Allows the player to cancel the selected friend request in the sent ListView.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void cancel(ActionEvent event) throws IOException {

	}
	
	/**
	 * Allows the player to delete the selected friend in his friends list.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void deleteFriend(ActionEvent event) throws IOException {

	}
	
	/**
	 * Allows the player to send a request to a player.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void sendCurrentRequest(ActionEvent event) throws IOException {

	}
	
	/**
	 * Allows the player to cancel his choice and erase the addFriendUsername TextField.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void cancelCurrentRequest(ActionEvent event) throws IOException {

	}
	
	/**
	 * Returns the player to the player menu.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnPlayerMenu(ActionEvent event) throws IOException {
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
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
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			
	}

}
