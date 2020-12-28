/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported classes and libraries.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.Game;
import businesslogic.domain.Player;
import businesslogic.domain.PlayerInGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;

public class GameManagementController implements Initializable {
	
	//Attributes
	private static Game currentGame;
	
	private static PlayerInGame currentPlayerInGame;
	
	//FXML Attributes
	
	/**
	 * Attribute uses to define the number of players of the game.
	 */
	@FXML
	private Slider numberOfPlayers;
	
	/**
	 * Attribute uses to store the generate game id.
	 */
	@FXML
	private Text gameId;
	
	/**
	 * Attribute allows to define the game status to public.
	 */
	@FXML
	private RadioButton publicGame;
	
	/**
	 * Attribute allows to define the game status to private.
	 */
	@FXML
	private RadioButton privateGame;
	
	/**
	 * Attribute uses to store the invited friends list of the player.
	 */
	@FXML
	private ListView<Player> invitedFriends;
	
	/**
	 * Attribute uses to store (the friends list - the invited friends list) of the player.
	 */
	@FXML
	private ListView<Player> inviteFriends;
	
	/**
	 * Attribute uses to store the list of players which are in the game.
	 */
	@FXML
	private ListView<Player> listPlayers;
	
	/**
	 * Attribute uses to define the number of Werewolves.
	 */
	@FXML
	private Slider numberOfWerewolves;
	
	/**
	 * Attribute uses to define if the special role Witch will be use.
	 */
	@FXML
	private Slider hasWitch;
	
	/**
	 * Attribute uses to define if the special role Fortune Teller will be use.
	 */
	@FXML
	private Slider hasFortuneTeller;
	
	/**
	 * Attribute uses to define if the special role Little Girl will be use.
	 */
	@FXML
	private Slider hasLittleGirl;
	
	/**
	 * Attribute uses to define if the special role Cupif will be use.
	 */
	@FXML
	private Slider hasCupid;
	
	/**
	 * Attribute uses to define if the special role Hunter will be use.
	 */
	@FXML
	private Slider hasHunter;
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void generateGameId(ActionEvent event) throws IOException{
		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void startGame(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameView.fxml"));	
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void kickPlayerOutOfGame(ActionEvent event) throws IOException{
		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void sendGameRequest(ActionEvent event) throws IOException{
		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void cancelGameRequest(ActionEvent event) throws IOException{
		
	}
	
	/**
	 * 
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

	/**
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the currentPlayerInGame
	 */
	public static PlayerInGame getCurrentPlayerInGame() {
		return currentPlayerInGame;
	}

	/**
	 * @param currentPlayerInGame the currentPlayerInGame to set
	 */
	public static void setCurrentPlayerInGame(PlayerInGame currentPlayerInGame) {
		GameManagementController.currentPlayerInGame = currentPlayerInGame;
	}

	/**
	 * @return the currentGame
	 */
	public static Game getCurrentGame() {
		return currentGame;
	}

	/**
	 * @param currentGame the currentGame to set
	 */
	public static void setCurrentGame(Game currentGame) {
		GameManagementController.currentGame = currentGame;
	}
		

}
