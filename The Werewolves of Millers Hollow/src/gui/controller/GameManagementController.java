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
import businesslogic.facade.GameManagementFacade;
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
	 * Attribute uses to define if the special role Cupid will be use.
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
	
	private static Game currentGame;
	@FXML
	void generateGameId(ActionEvent event) throws IOException{ //marche
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
		int status;
		if (publicGame.isSelected()) {
			status = 1;
		}if(privateGame.isSelected()) {
			status = 0;
		}else {
			status = 0;
		}
		boolean isDone = gameManagementFacade.createGame((int)numberOfPlayers.getValue(), status);
		if(isDone) {		
			TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameManagementView.fxml"));
		}else {
			infoBox("Please retry to create a game later.","Incorrect information.", "Connection problem");
		}
		
		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void startGame(ActionEvent event) throws IOException{
		
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
		boolean isDone = gameManagementFacade.modifyRole(Game.getGame_id(),(int)numberOfWerewolves.getValue(),(int)hasWitch.getValue(),(int)hasFortuneTeller.getValue(),(int)hasLittleGirl.getValue(),(int)hasCupid.getValue(),(int)hasHunter.getValue());
		if(isDone) {		
			TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameView.fxml"));
		}else {
			infoBox("Please retry to start the game later.","Incorrect information.", "Connection problem");
		}
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void kickPlayerOutOfGame(ActionEvent event) throws IOException{
		String username = listPlayers.getSelectionModel().getSelectedItem().getUsername();
		if(username==null) {
			infoBox("Please select a player before try to delete.","Missing Player.","Missing informations");
		}else {
			GameManagementFacade gameManagementFacade = new GameManagementFacade();
			GameManagementController.getCurrentGame();
			boolean isDone = gameManagementFacade.kickPlayerOfTheGame(Game.getGame_id(),username);
			if(isDone) {		
				TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameManagementView.fxml"));
			}else {
				infoBox("Please retry to kick the player later.","Incorrect information.", "Connection problem");
			}
		}		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void sendGameRequest(ActionEvent event) throws IOException{
		Player invFriend = inviteFriends.getSelectionModel().getSelectedItem();
		if(invFriend.getUsername().isBlank()) {
			infoBox("Please select a friend to invite.","Missing friend","Missing informations");
		}else {
			if(invitedFriends.getItems().contains(invFriend)) {
				infoBox("This player is already in the invited friends list.","Incorrect action", "Incorrect information");
			}else {
				GameManagementFacade gameManagementFacade = new GameManagementFacade();
				GameManagementController.getCurrentGame();
				boolean isDone=gameManagementFacade.inviteFriendToPlay(Game.getGame_id(),PlayerMenuController.getCurrentPlayer().getUsername(),invFriend.getUsername());
				if (isDone) {
					TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameManagementView.fxml"));
				}else {
					infoBox("Please retry to invite your friend to play later.","Connection Problem", "Incorrect information");
				}
			}
		}
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void cancelGameRequest(ActionEvent event) throws IOException{
		Player invitedFriend = invitedFriends.getSelectionModel().getSelectedItem();
		if(invitedFriend.getUsername().isBlank()) {
			infoBox("Please select a friend to cancel sent invitation.","Missing friend","Missing informations");
		}else {
			if(inviteFriends.getItems().contains(invitedFriend)) {
				infoBox("This player is already in the invite friends list.","Incorrect action", "Incorrect information");
			}else {
				GameManagementFacade gameManagementFacade = new GameManagementFacade();
				GameManagementController.getCurrentGame();
				boolean isDone=gameManagementFacade.cancelRequest(Game.getGame_id(),PlayerMenuController.getCurrentPlayer().getUsername(),invitedFriend.getUsername());
				if (isDone) {
					TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameManagementView.fxml"));
				}else {
					infoBox("Please retry to cancel the invitation to play later.","Connection Problem", "Incorrect information");
				}
			}
		}
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnPlayerMenu(ActionEvent event) throws IOException{
		
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
			GameManagementController.getCurrentGame();
			boolean isDone = gameManagementFacade.deleteGame(Game.getGame_id());
			if(isDone) {		
				TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
			}else {
				infoBox("Retry to cancel the game creation later.","Incorrect information.", "Connection problem");
			}		
			
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
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
		
		
	}

	public static Game getCurrentGame() {
		return currentGame;
	}

	public static void setCurrentGame(Game currentGame) {
		GameManagementController.currentGame = currentGame;
	}

	
		

}
