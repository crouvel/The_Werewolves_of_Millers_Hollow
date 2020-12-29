/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported libraries and classes.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.Game;
import businesslogic.facade.SelectAndJoinAGameFacade;
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
		String id = gameId.getText();
		if(id.isBlank()) {
			infoBoxW("Please enter a game id before try to join.","Missing game id.","Missing information");
		}else {
			int gId = 0;
			try {
				gId = Integer.parseInt(id);
			}catch (NumberFormatException e){
				infoBoxE("Please enter an integer for the number of played games.","Incorrect syntax for the number of played games","Incorrect syntax");
			}
			SelectAndJoinAGameFacade joinGameFacade = new SelectAndJoinAGameFacade();
			boolean isDone = joinGameFacade.joinAGame(gId);
			if(isDone) {
				
			}
			else {
				infoBoxE("Please try later.","Connection problem or inexistant game","Bad connection / inexistant game");
			}
		}
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
	 * Open an error info box.
	 * @param message
	 * @param head
	 * @param title
	 */
	public static void infoBoxE(String message, String head, String title){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(head);
        alert.showAndWait();
    }
	
	/**
	 * Open a warning info box.
	 * @param message
	 * @param head
	 * @param title
	 */
	public static void infoBoxW(String message, String head, String title){
        Alert alert = new Alert(AlertType.WARNING);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(head);
        alert.showAndWait();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SelectAndJoinAGameFacade joinGameFacade = new SelectAndJoinAGameFacade();
		ArrayList<Game> games;
		games = joinGameFacade.getGamesList();
		for(Game i : games) {
			availableGames.getItems().add(i);
		}
	}

}
