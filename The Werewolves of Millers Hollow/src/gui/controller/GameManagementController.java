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
import java.util.Collections;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.Game;
import businesslogic.domain.PlayerInGame;
import businesslogic.domain.Role;
import businesslogic.facade.FriendManagementFacade;
import businesslogic.facade.GameManagementFacade;
import businesslogic.facade.SelectAndJoinAGameFacade;
import util.InfoBox;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.application.Platform;

/**
 * 
 * @author Tiffany Dumaire, Clarence Rouvel
 *
 */
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
	private TextField numberOfPlayers;

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
	private ListView<String> invitedFriends;

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

	/**
	 * 
	 */
	@FXML
	private Pane invitedFriendsPane;
	
	/**
	 * 
	 */
	@FXML
	private Pane friendsPane;
	
	/**
	 * 
	 */
	@FXML
	private Pane rolePane;
	
	/**
	 * 
	 */
	@FXML
	private Button startGameButton;
	
	/**
	 * 
	 */
	@FXML
	private Button kickPlayerOutOfGameButton;
	
	/**
	 * 
	 */
	@FXML
	private Button generateIdButton;
	
	/**
	 * 
	 */
	private ToggleGroup statusGroup;

	/**
	 * 
	 */
	private static Game currentGame;

	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void generateGameId(ActionEvent event) throws IOException{ 
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
		SelectAndJoinAGameFacade selectAGame = new SelectAndJoinAGameFacade();
		boolean status = true;
		if(statusGroup.getSelectedToggle()== privateGame) {
			status = false;
		}
		boolean exists = gameManagementFacade.existsGameByUsername(PlayerMenuController.getCurrentPlayer().getUsername());
		if(exists) {
			gameManagementFacade.deleteGame2(PlayerMenuController.getCurrentPlayer().getUsername());
		}
		int nbplayers = 0;
		try {		
			nbplayers = Integer.parseInt(numberOfPlayers.getText());
			if(nbplayers < 8 || nbplayers > 47 ) {
				InfoBox.infoBoxW("The number of players must be between 8 and 47.", "Incorrect information","Bad Typing");
			}else {
				boolean isDone = gameManagementFacade.createGame( nbplayers , status, PlayerMenuController.getCurrentPlayer().getUsername());
				if(isDone) {		
					Game game = gameManagementFacade.getGameByCreator(PlayerMenuController.getCurrentPlayer().getUsername());
					if(game == null) {
						InfoBox.infoBoxW("Please retry to create the game later","Incorrect information.", "Connection Problem");
					}else {
						boolean isDone2 = selectAGame.joinAGameCreator(game.getGame_id());
						if(isDone2) {
							PlayerInGame player = selectAGame.getPlayerInGame(game.getGame_id(),PlayerMenuController.getCurrentPlayer().getUsername());
							TheWerewolvesOfMillersHollow.generateGameIdInGameManagement(player, game, getClass().getResource("../view/GameManagementView.fxml"));
						}
					}
				}else {
					InfoBox.infoBoxW("Please retry to create the game later","Incorrect information.", "Connection Problem");
				}
			}
		}catch(NumberFormatException e) {
			InfoBox.infoBoxE("Please enter an integer for the number of players.", "Incorrect information","Bad Typing");
		}	
	}

	/**
	 * 
	 * @param event
	 * @throws IOException
	 * @throws SQLException 
	 */
	@FXML
	void startGame(ActionEvent event) throws IOException, SQLException{
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
		Game game = GameManagementController.getCurrentGame();
		if(game == null ) {
			InfoBox.infoBoxE("Please generate a game, then modify its roles, and then start it.","Missing game","Bad Manipulation");
		}else {
			ArrayList<String> players;
			int nbplayers = GameManagementController.getCurrentGame().getNumberOfPlayers();
			int nbw = (int)numberOfWerewolves.getValue();
			int nbh = (int)hasWitch.getValue();
			int ft = (int)hasFortuneTeller.getValue();
			int lg = (int)hasLittleGirl.getValue();
			int hc = (int)hasCupid.getValue();
			int hunter = (int)hasHunter.getValue();
			int special = nbh + ft + lg + hc + hunter;
			players = gameManagementFacade.getPlayerList(GameManagementController.getCurrentGame().getGame_id());
			if(players.size() < nbplayers || players == null) {
				InfoBox.infoBoxW("Cannot start the game. The number of players is not reached", "Not enough Players", "Bad Manipulation");
			}else  {
				if(nbplayers < 12) {
					if(nbw > 2 || special > 3) {
						InfoBox.infoBoxW("The amount of werewolves or/and special roles is too high", "Incorrect information", "Bad information");
					}else {
						ArrayList<String> roles = new ArrayList<String>();
						for(int i = 0; i < nbw; i++) {
							roles.add(Role.WEREWOLF.getName());
						}
						if(nbh == 1) {
							roles.add(Role.WITCH.getName());
						}
						if(ft == 1) {
							roles.add(Role.FORTUNE_TELLER.getName());
						}
						if(lg == 1) {
							roles.add(Role.LITTLE_GIRL.getName());
						}
						if(hc == 1) {
							roles.add(Role.CUPID.getName());
						}
						if(hunter == 1) {
							roles.add(Role.HUNTER.getName());
						}
						Collections.shuffle(players);
						for(int i = 0; i < roles.size(); i++) {
							boolean a = gameManagementFacade.modifyPlayerInGame(GameManagementController.getCurrentGame().getGame_id(), players.get(i), roles.get(i));
							if(!a) {
								InfoBox.infoBoxE("Problem... Retry please :(","Database connection problem", "Connection problem");
							}
						}
						for(int i = roles.size(); i < nbplayers; i++) {
							boolean a = gameManagementFacade.modifyPlayerInGame(GameManagementController.getCurrentGame().getGame_id(), players.get(i), Role.VILLAGER.getName());
							if(!a) {
								InfoBox.infoBoxE("Problem... Retry please :(","Database connection problem", "Connection problem");
							}
						}
						boolean isDone2 = gameManagementFacade.modifyRole(GameManagementController.getCurrentGame().getGame_id(),1,getBoolean(nbh),getBoolean(ft), getBoolean(lg),getBoolean(hc),getBoolean(hunter));
						if(isDone2) {		
							TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameView.fxml"));
						}else {
							InfoBox.infoBoxE("Please retry to start the game later.","Incorrect information.", "Connection problem");
						}
					}
				}else {
					if(nbw > nbplayers/6 || special > nbplayers/4) {
						InfoBox.infoBoxW("The amount of werewolves or/and special roles is too high", "Incorrect information", "Bad information");
					}else {
						ArrayList<String> roles = new ArrayList<String>();
						for(int i = 0; i < nbw; i++) {
							roles.add(Role.WEREWOLF.getName());
						}
						if(nbh == 1) {
							roles.add(Role.WITCH.getName());
						}
						if(ft == 1) {
							roles.add(Role.FORTUNE_TELLER.getName());
						}
						if(lg == 1) {
							roles.add(Role.LITTLE_GIRL.getName());
						}
						if(hc == 1) {
							roles.add(Role.CUPID.getName());
						}
						if(hunter == 1) {
							roles.add(Role.HUNTER.getName());
						}
						Collections.shuffle(players);
						for(int i = 0; i < roles.size(); i++) {
							boolean a = gameManagementFacade.modifyPlayerInGame(GameManagementController.getCurrentGame().getGame_id(), players.get(i), roles.get(i));
							if(!a) {
								InfoBox.infoBoxE("Problem... Retry please :(","Database connection problem", "Connection problem");
							}
						}
						for(int i = roles.size(); i < nbplayers; i++) {
							boolean a = gameManagementFacade.modifyPlayerInGame(GameManagementController.getCurrentGame().getGame_id(), players.get(i), Role.VILLAGER.getName());
							if(!a) {
								InfoBox.infoBoxE("Problem... Retry please :(","Database connection problem", "Connection problem");
							}
						}						
						boolean isDone = gameManagementFacade.modifyRole(GameManagementController.getCurrentGame().getGame_id(),(int)numberOfWerewolves.getValue(),getBoolean(nbh),getBoolean(ft), getBoolean(lg),getBoolean(hc),getBoolean(hunter));
						if(isDone) {		
							TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameView.fxml"));
						}else {
							InfoBox.infoBoxE("Please retry to start the game later.","Incorrect information.", "Connection problem");
						}
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
	void kickPlayerOutOfGame(ActionEvent event) throws IOException{
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
		Game game = gameManagementFacade.getGameByCreator(PlayerMenuController.getCurrentPlayer().getUsername());
		if(game == null ) {
			InfoBox.infoBoxW("Please generate a game in order to kick a player of the game.","Missing game","Bad Manipulation");
		}else {
			String username = listPlayers.getSelectionModel().getSelectedItem();
			if(username==null) {
				InfoBox.infoBoxW("Please select a player before try to delete.","Missing Player.","Missing informations");
			}else {
				GameManagementController.getCurrentGame();
				boolean isDone = gameManagementFacade.kickPlayerOfTheGame(GameManagementController.getCurrentGame().getGame_id(),username);
				if(isDone) {		
					TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameManagementView.fxml"));
				}else {
					InfoBox.infoBoxE("Please retry to kick the player later.","Incorrect information.", "Connection problem");
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
			InfoBox.infoBoxW("Please generate a game in order to send a game invitation.","Missing game","Bad Manipulation");
		}else {
			String invFriend = inviteFriends.getSelectionModel().getSelectedItem();
			if(invFriend == null) {
				InfoBox.infoBoxW("Please select a friend to invite.","Missing friend","Missing informations");
			}else {
				if(invitedFriends.getItems().contains(invFriend)) {
					InfoBox.infoBoxW("This player is already in the invited friends list.","Incorrect action", "Incorrect information");
				}else {
					boolean isDone=gameManagementFacade.inviteFriendToPlay(GameManagementController.getCurrentGame().getGame_id(),PlayerMenuController.getCurrentPlayer().getUsername(),invFriend);
					if (isDone) {
						TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameManagementView.fxml"));
					}else {
						InfoBox.infoBoxE("Please retry to invite your friend to play later.","Connection Problem", "Incorrect information");
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param event
	 * @throws IOException
	 * @throws SQLException 
	 */
	@FXML
	void cancelGameRequest(ActionEvent event) throws IOException, SQLException{
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
		Game game = GameManagementController.getCurrentGame();
		if(game == null ) {
			InfoBox.infoBoxW("Please generate a game in order to cancel a sent invitation.","Missing game","Bad Manipulation");
		}else {
			ArrayList<String> invited = gameManagementFacade.getInvitedFriendList(GameManagementController.getCurrentGame().getGame_id(),PlayerMenuController.getCurrentPlayer().getUsername());
			if(invited == null) {
				InfoBox.infoBoxW("Please invite a friend to play.","Empty list","Missing informations");
			} else {
				String invitedFriend = invitedFriends.getSelectionModel().getSelectedItem();
				if(invitedFriend==null) {
					InfoBox.infoBoxW("Please select a friend to cancel sent invitation.","Missing friend","Missing informations");
				} else {
					GameManagementController.getCurrentGame();
					boolean isDone=gameManagementFacade.cancelRequest(GameManagementController.getCurrentGame().getGame_id(),PlayerMenuController.getCurrentPlayer().getUsername(),invitedFriend);
					if (isDone) {
						TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameManagementView.fxml"));
					} else {
						InfoBox.infoBoxE("Please retry to cancel the invitation to play later.","Connection Problem", "Incorrect information");
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
			if(GameManagementController.getCurrentPlayerInGame().isCreator()) {
				boolean isDone = gameManagementFacade.deleteGame(GameManagementController.getCurrentGame().getGame_id());
				if(isDone) {		
					GameManagementController.setCurrentGame(null);
					GameManagementController.setCurrentPlayerInGame(null);
					TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
				} else {
					InfoBox.infoBoxE("Retry to cancel the game creation later.","Incorrect information.", "Connection problem");
				}	
			}else {
				boolean isDone = gameManagementFacade.kickPlayerOfTheGame(GameManagementController.getCurrentGame().getGame_id(),GameManagementController.getCurrentPlayerInGame().getUsername());
				if(isDone) {
					GameManagementController.setCurrentGame(null);
					GameManagementController.setCurrentPlayerInGame(null);
					TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
				}else {
					InfoBox.infoBoxE("Retry to cancel the game later.","Incorrect information.", "Connection problem");
				}
			} 
		}
		else {
			TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
		}
	}

	//Added Methods
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		statusGroup = new ToggleGroup();
		privateGame.setToggleGroup(statusGroup);
		publicGame.setToggleGroup(statusGroup);
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
		FriendManagementFacade friendManagementFacade = new FriendManagementFacade();
		try {
			if ((GameManagementController.getCurrentGame() !=  null) && (GameManagementController.getCurrentPlayerInGame() !=  null)) {
				if(GameManagementController.getCurrentPlayerInGame().isCreator()) {
					rolePane.setDisable(false);
					kickPlayerOutOfGameButton.setDisable(false);
				}
				numberOfPlayers.setText(GameManagementController.getCurrentGame().getNumberOfPlayers()+"");
				numberOfPlayers.setDisable(true);
				privateGame.setDisable(true);
				publicGame.setDisable(true);
				if(!GameManagementController.getCurrentGame().isStatus()) {
					statusGroup.selectToggle(privateGame);
				}
				invitedFriendsPane.setVisible(true);
				friendsPane.setVisible(true);
				generateIdButton.setDisable(true);
				gameId.setText(GameManagementController.getCurrentGame().getGame_id()+"");
				//refresh lists
				Task<ListView<String>> gameManagementTask = new Task<>() {
					@Override
					protected ListView<String> call() throws Exception {
						while(listPlayers.getItems().size() != GameManagementController.getCurrentGame().getNumberOfPlayers()){
							ArrayList<String> p = gameManagementFacade.getPlayerList(GameManagementController.getCurrentGame().getGame_id());
							ArrayList<String> invited = gameManagementFacade.getInvitedFriendList(GameManagementController.getCurrentGame().getGame_id(),PlayerMenuController.getCurrentPlayer().getUsername());
							ArrayList<String> invite = friendManagementFacade.getFriendList(PlayerMenuController.getCurrentPlayer().getUsername());
							Platform.runLater(() -> {	
								listPlayers.getItems().clear();
								for(String i : p) {
									listPlayers.getItems().add(i);
								}

								invitedFriends.getItems().clear();
								for(String i : invited) {
									if(!p.contains(i)) {
										invitedFriends.getItems().add(i);
									}
								}
								inviteFriends.getItems().clear();
								for(String i : invite) {
									if(!p.contains(i) && !invited.contains(i)) {
										inviteFriends.getItems().add(i);
									}
								}
							});	
							if(!GameManagementController.getCurrentPlayerInGame().isCreator()) {
								try {
									if(!p.contains(GameManagementController.getCurrentGame().getCreatorUsername())) {
										GameManagementController.setCurrentGame(null);
										GameManagementController.setCurrentPlayerInGame(null);
										TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							Thread.sleep(5000);
						}
						if(GameManagementController.getCurrentPlayerInGame().isCreator()) {
							startGameButton.setDisable(false);
						}else {
							while(!(GameManagementController.getCurrentGame().getCurrentPhase().getName().equals("NIGHT"))) {
								Game game = gameManagementFacade.getGame(GameManagementController.getCurrentGame().getGame_id());	
								GameManagementController.setCurrentGame(game);
								Thread.sleep(1000);
							}	
							Platform.runLater(() -> {	
								try {
									TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/GameView.fxml"));
								} catch (IOException e) {
									e.printStackTrace();
								}			
							});
						}
						
						return listPlayers;
					}
				};				
				Thread gameManagementThread = new Thread(gameManagementTask);
				gameManagementThread.setDaemon(true);
				gameManagementThread.start();					
			}
		}catch (NullPointerException | IOException e) {
			InfoBox.infoBoxE("Loading information problem. Quit and retry.", "Loading information problem", "Error");
		}
	}
	
	/**
	 * 
	 * @return the currentGame
	 * @throws IOException
	 */
	public static Game getCurrentGame() throws IOException {
		return GameManagementController.currentGame;
	}

	/**
	 * 
	 * @param currentGame the currentGame to set
	 * @throws IOException
	 */
	public static void setCurrentGame(Game currentGame) throws IOException {
		GameManagementController.currentGame = currentGame;
	}

	/**
	 * 
	 * @return the currentPlayerInGame
	 */
	public static PlayerInGame getCurrentPlayerInGame() {
		return currentPlayerInGame;
	}

	/**
	 * 
	 * @param currentPlayerInGame the currentPlayerInGame to set
	 */
	public static void setCurrentPlayerInGame(PlayerInGame currentPlayerInGame) {
		GameManagementController.currentPlayerInGame = currentPlayerInGame;
	}
	
	/**
	 * 
	 * @param nb
	 * @return
	 */
	public boolean getBoolean(int nb) {
		if(nb == 0) {
			return false;
		}else {
			return true;
		}
	}
	
}
