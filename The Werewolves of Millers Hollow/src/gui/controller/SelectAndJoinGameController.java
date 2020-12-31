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
import businesslogic.domain.PlayerInGame;
import businesslogic.facade.SelectAndJoinAGameFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import util.InfoBox;

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
			InfoBox.infoBoxW("Please enter a game id before try to join.","Missing game id.","Missing information");
		}else {
			int gId = 0;
			try {
				gId = Integer.parseInt(id);
			}catch (NumberFormatException e){
				InfoBox.infoBoxE("Please enter an integer corresponding to a valid gameId.","Incorrect syntax of game id","Incorrect syntax");
			}
			SelectAndJoinAGameFacade joinGameFacade = new SelectAndJoinAGameFacade();
			boolean isDone = joinGameFacade.joinAGame(gId);
			if(isDone) {
				Game game = joinGameFacade.getGame(gId);
				if(game == null) {
					InfoBox.infoBoxI("Please select an other game.","Connection problem or inexistant game","Inexistant game");
				}else {
					PlayerInGame player = joinGameFacade.getPlayerInGame(gId, PlayerMenuController.getCurrentPlayer().getUsername());
					TheWerewolvesOfMillersHollow.goToGameManagement(player, game, getClass().getResource("../view/GameManagementView.fxml"));
				}
			}
			else {
				InfoBox.infoBoxE("Please try later.","Connection problem or inexistant game","Bad connection / inexistant game");
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
		Game game =  availableGames.getSelectionModel().getSelectedItem();
		if(game == null) {
			InfoBox.infoBoxW("Please select a game before try to join.","Missing selected game.","Missing information");
		}else {
			int gId = game.getGame_id();
			SelectAndJoinAGameFacade joinGameFacade = new SelectAndJoinAGameFacade();
			boolean isDone = joinGameFacade.joinAGame(gId);
			if(isDone) {
				Game joinedGame = joinGameFacade.getGame(gId);
				if(joinedGame == null) {
					InfoBox.infoBoxI("Please select an other game.","Connection problem or inexistant game","Inexistant game");
				}else {
					PlayerInGame player = joinGameFacade.getPlayerInGame(gId, PlayerMenuController.getCurrentPlayer().getUsername());
					TheWerewolvesOfMillersHollow.goToGameManagement(player, joinedGame, getClass().getResource("../view/GameManagementView.fxml"));
				}
			}
			else {
				InfoBox.infoBoxE("Please try later.","Connection problem or inexistant game","Bad connection / inexistant game");
			}
		}
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
