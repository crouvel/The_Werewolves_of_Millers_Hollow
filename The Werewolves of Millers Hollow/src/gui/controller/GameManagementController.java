/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported classes and libraries.
 */
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.Game;
import businesslogic.domain.Player;
import businesslogic.domain.PlayerInGame;
import businesslogic.facade.FriendManagementFacade;
import businesslogic.facade.GameManagementFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import model.dao.mysql.GameManagementDAOMySQL;

public class GameManagementController implements Initializable {
	
	
	/**
	 * 
	 */
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
	private static ListView<String> invitedFriends;

	/**
	 * Attribute uses to store (the friends list - the invited friends list) of the player.
	 */
	@FXML
	private ListView<String> inviteFriends;

	/**
	 * Attribute uses to store the list of players which are in the game.
	 */
	@FXML
	private ListView<String> listPlayers;

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



	private ToggleGroup statusGroup;
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */

	private static Game currentGame;

	@FXML
	void generateGameId(ActionEvent event) throws IOException{ 
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
		boolean status = true;

		if(statusGroup.getSelectedToggle()== privateGame) {
			status = false;
		}
		boolean isDone = gameManagementFacade.createGame((int)numberOfPlayers.getValue(), status, PlayerMenuController.getCurrentPlayer().getUsername());
		if(isDone) {		
			Game game = gameManagementFacade.getGameByCreator(PlayerMenuController.getCurrentPlayer().getUsername());
			if(game == null) {
				infoBox("Please retry to create the game later","Incorrect information.", "Connection Problem");
			}else {TheWerewolvesOfMillersHollow.generateGameIdInGameManagement(game, getClass().getResource("../view/GameManagementView.fxml"));
			}
		}else {
			infoBox("Please retry to create the game later","Incorrect information.", "Connection Problem");
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
		Game game = GameManagementController.getCurrentGame();
		if(game == null ) {
			infoBox("Please generate a game, then modify its roles, and then start it.","Missing game","Bad Manipulation");
		}else {
			
			
			
			int nbh = (int)hasWitch.getValue();
			int ft = (int)hasFortuneTeller.getValue();
			int lg = (int)hasLittleGirl.getValue();
			int hc = (int)hasCupid.getValue();
			int hunter = (int)hasHunter.getValue();
			
			boolean isDone = gameManagementFacade.modifyRole(GameManagementController.getCurrentGame().getGame_id(),
					(int)numberOfWerewolves.getValue(),getBoolean(nbh),getBoolean(ft), getBoolean(lg),getBoolean(hc),getBoolean(hunter));
			if(isDone) {		
				TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameView.fxml"));
			}else {
				infoBox("Please retry to start the game later.","Incorrect information.", "Connection problem");
			}
		}
	}
	
	boolean getBoolean(int nb) {
		if(nb == 0) {
			return false;
		}if (nb == 1 ) {
			return true;
		} return true;
	}

	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void kickPlayerOutOfGame(ActionEvent event) throws IOException{
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
		Game game = gameManagementFacade.getGameByCreator(PlayerMenuController.getCurrentPlayer().getUsername());
		if(game == null ) {
			infoBox("Please generate a game in order to kick a player of the game.","Missing game","Bad Manipulation");
			
		
		}else {

			String username = listPlayers.getSelectionModel().getSelectedItem();
			if(username==null) {
				infoBox("Please select a player before try to delete.","Missing Player.","Missing informations");
			}else {
				GameManagementController.getCurrentGame();
				boolean isDone = gameManagementFacade.kickPlayerOfTheGame(GameManagementController.getCurrentGame().getGame_id(),username);
				if(isDone) {		
					TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameManagementView.fxml"));
				}else {
					infoBox("Please retry to kick the player later.","Incorrect information.", "Connection problem");
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
	void sendGameRequest(ActionEvent event) throws IOException{
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
		Game game = gameManagementFacade.getGameByCreator(PlayerMenuController.getCurrentPlayer().getUsername());
		if(game == null) {
			infoBox("Please generate a game in order to send a game invitation.","Missing game","Bad Manipulation");
			
		
		}else {
			String invFriend = inviteFriends.getSelectionModel().getSelectedItem();
			if(invFriend == null) {
				infoBox("Please select a friend to invite.","Missing friend","Missing informations");
			}else {
				
				if(invitedFriends.getItems().contains(invFriend)) {
					infoBox("This player is already in the invited friends list.","Incorrect action", "Incorrect information");
				}else {
					
					
					boolean isDone=gameManagementFacade.inviteFriendToPlay(GameManagementController.getCurrentGame().getGame_id(),PlayerMenuController.getCurrentPlayer().getUsername(),invFriend);
					if (isDone) {
						TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameManagementView.fxml"));
					}else {
						infoBox("Please retry to invite your friend to play later.","Connection Problem", "Incorrect information");
					}
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
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
		Game game = GameManagementController.getCurrentGame();
		if(game == null ) {
			infoBox("Please generate a game in order to cancel a sent invitation.","Missing game","Bad Manipulation");
		}else {
			String invitedFriend = invitedFriends.getSelectionModel().getSelectedItem();
			if(invitedFriend==null) {
				infoBox("Please select a friend to cancel sent invitation.","Missing friend","Missing informations");
			}else {
				if(inviteFriends.getItems().contains(invitedFriend)) {
					infoBox("This player is already in the invite friends list.","Incorrect action", "Incorrect information");
				}else {

					GameManagementController.getCurrentGame();
					boolean isDone=gameManagementFacade.cancelRequest(GameManagementController.getCurrentGame().getGame_id(),PlayerMenuController.getCurrentPlayer().getUsername(),invitedFriend);
					if (isDone) {
						TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameManagementView.fxml"));
					}else {
						infoBox("Please retry to cancel the invitation to play later.","Connection Problem", "Incorrect information");
					}
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

		if(GameManagementController.getCurrentGame() != null) {

			GameManagementFacade gameManagementFacade = new GameManagementFacade();
			boolean isDone = gameManagementFacade.deleteGame(GameManagementController.getCurrentGame().getGame_id());
			if(isDone) {		
				GameManagementController.setInvitedFriends(null);
				GameManagementController.setCurrentGame(null);
				TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
			}else {
				infoBox("Retry to cancel the game creation later.","Incorrect information.", "Connection problem");
			}		

		}else {
			TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
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

	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<String> invited;
		ArrayList<String> invite;
		ArrayList<String> players;
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
		FriendManagementFacade friendManagementFacade = new FriendManagementFacade();



		try {
			if (GameManagementController.getCurrentGame() !=  null) {
			
			players = gameManagementFacade.getPlayerList(GameManagementController.getCurrentGame().getGame_id());
			for(String i : players) {
				listPlayers.getItems().add(i);
			}
			}



		} catch (NullPointerException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		statusGroup = new ToggleGroup();
		privateGame.setToggleGroup(statusGroup);
		publicGame.setToggleGroup(statusGroup);


		try {
			if (GameManagementController.getCurrentGame() !=  null) {
				gameId.setText(GameManagementController.getCurrentGame().getGame_id()+"");
			}
		}catch (NullPointerException | IOException e) {
			e.printStackTrace();}
		
			try {
				if (GameManagementController.getCurrentGame() !=  null) {
				invited = gameManagementFacade.getInvitedFriendList(GameManagementController.getCurrentGame().getGame_id(),PlayerMenuController.getCurrentPlayer().getUsername());
			for(String i : invited) {
				invitedFriends.getItems().add(i);
			}
				}
			}catch (NullPointerException | IOException e1) {
				e1.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try{
				invite = friendManagementFacade.getFriendList(PlayerMenuController.getCurrentPlayer().getUsername());
				
			for(String i : invite) {
				inviteFriends.getItems().add(i);
			}
		} catch (NullPointerException | IOException e2) {
			e2.printStackTrace();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}

	

	
		



	public static Game getCurrentGame() throws IOException {
		return GameManagementController.currentGame;
	}

	public static void setCurrentGame(Game currentGame) throws IOException {
		GameManagementController.currentGame = currentGame;
	}

	public static void setInvitedFriends(ListView<String> invited){
		GameManagementController.invitedFriends = invited;
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


}
