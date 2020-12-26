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
import businesslogic.domain.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class SelectAndJoinGameController  implements Initializable {
	
	//FXML Attributes
	
	/**
	 * Attribute uses for choose the gameId.
	 */
	@FXML
	private TextField gameId;
	
	/**
	 * Attribute containing the list of available games.
	 */
	@FXML
	private ListView<Game> availableGames;
	
	//FXML Methods
	
	/**
	 * Allows the player to join a game selected in the list of available games.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void joinAGame(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * Allows the player to join a game by his gameId.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void selectAGame(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * Returns the player to the player menu.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnPlayerMenu(ActionEvent event) throws IOException{
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
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(head);
        alert.showAndWait();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
