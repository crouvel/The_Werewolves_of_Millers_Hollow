/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported Classes and Libraries.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.Game;
import businesslogic.domain.PlayerInGame;
import businesslogic.domain.Role;
import businesslogic.facade.GameFacade;
import businesslogic.facade.GameManagementFacade;
import javafx.application.Platform;
import javafx.concurrent.Task;
/*
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;*/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
//import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
//import javafx.util.Duration;
import util.InfoBox;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class GameController implements Initializable{
	
	//Attributes
	
	/**
	 * 
	 */
	private static PlayerInGame currentPlayer;
	
	/**
	 * 
	 */
	private ArrayList<String> roleList;
	
	/**
	 * 
	 */
	private static Game game;
	
	//Report Part
	
	/**
	 * 
	 */
	@FXML
	private Pane reportPlayerPane;
	
	/**
	 * 
	 */
	@FXML
	private ComboBox<String> badPlayerUsername;
	
	/**
	 * 
	 */
	@FXML
	private ComboBox<String> reason;
	
	/**
	 * 
	 */
	@FXML
	private TextArea description;
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void cancelReport(ActionEvent event)  throws IOException {
		badPlayerUsername.getItems().get(0);
		reason.getItems().get(0);
		description.setText("");
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void sendReport(ActionEvent event)  throws IOException {
		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void reportAPlayer(ActionEvent event) throws IOException {
		if(reportPlayerPane.isVisible()) {
			reportPlayerPane.setVisible(false);
		}else {
			reportPlayerPane.setVisible(true);
		}
	}
	
	//Chat Part
	
	/**
	 * 
	 */
	@FXML
	private Pane chatPane;
	
	/**
	 * 
	 */
	@FXML
	private TextFlow chat;
	
	/**
	 * 
	 */
	@FXML
	private TextField message;
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void sendMessage(ActionEvent event)  throws IOException {
		
	}
	
	/**
	 * 
	 */
	public void displayMessage() {
		
	}
	
	//Vote Part
	
	/**
	 * 
	 */
	@FXML
	private Pane votePane;
	
	/**
	 * 
	 */
	@FXML
	private ListView<String> playerVoteList;
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void sendVote(ActionEvent event)  throws IOException {
		
	}
	
	//Propose As A Sheriff Part
	
	/**
	 * 
	 */
	@FXML
	private Pane speechPane;
	
	/**
	 * 
	 */
	@FXML
	private TextField speech;
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void no(ActionEvent event) throws IOException {
		speechPane.setVisible(false);
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void sendCandidacy(ActionEvent event) throws IOException {
		String mySpeech = speech.getText();
		if(mySpeech.isBlank()) {
			InfoBox.infoBoxW("Please fill in the speech field before sending your candidacy.","The speech is missing.","Missing information");
		}else {
			//A FINIR
			System.out.println(mySpeech);
		}
	}
	
	//Quit Part
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnPlayerMenu(ActionEvent event) throws IOException {
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
	}
	
	//Initialization
	
	/**
	 * 
	 */
	@FXML
	private Pane roleAttribution;
	
	/**
	 * 
	 */
	@FXML
	private Text roleName;
	
	/**
	 * 
	 */
	@FXML
	private ImageView roleImage;
	
	//Cupid
	/**
	 * 
	 */
	@FXML
	private Pane inLovePane;
	
	/**
	 * 
	 */
	@FXML
	private ComboBox<String> firstPlayerInLove;
	
	/**
	 * 
	 */
	@FXML
	private ComboBox<String> secondPlayerInLove;
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void becomeLovers(ActionEvent event) throws IOException {
		String playerOne = firstPlayerInLove.getValue();
		String playerTwo = secondPlayerInLove.getValue();
		if(playerOne.equals(playerTwo)) {
			InfoBox.infoBoxI("Please choose two different players.", "The two players are the same.", "Identical players");
		}else {
			GameFacade gameFacade = new GameFacade();
			boolean player1 = gameFacade.becomeLover(GameController.getGame().getGame_id(), playerOne);
			if(!player1) {
				InfoBox.infoBoxW("Retry to send your love potion","Love potion corrupted","Corrupt Love Potion");
			}else {
				boolean player2 = gameFacade.becomeLover(GameController.getGame().getGame_id(), playerTwo);
				if(!player2) {
					InfoBox.infoBoxE("(Joke) The game will self-destruct. Thank your connection.","The game was corrupted","Corrupt game");
				}else {
					//Affichage dans le chat
					System.out.println("In Love : " + playerOne + " x " + playerTwo );
				}
			}
		}
		
	}
	
	//Other functions
	
	/**
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		GameFacade gameFacade = new GameFacade();
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
		try {
			ArrayList<String> role = gameFacade.getRoleList(GameController.getGame().getGame_id());
			this.setRoleList(role);
			PlayerInGame player = gameFacade.getPlayerInGame(GameManagementController.getCurrentGame().getGame_id(), GameManagementController.getCurrentPlayerInGame().getUsername());
			GameController.setCurrentPlayer(player);
			roleName.setText(player.getRole().getName());
			if(player.getRole().equals(Role.CUPID)) {
				roleImage.setImage(new Image("@../../image/role/cupid.png"));
			}
			if(player.getRole().equals(Role.FORTUNE_TELLER)) {
				roleImage.setImage(new Image("@../../image/role/fortuneTeller.png"));
			}
			if(player.getRole().equals(Role.HUNTER)) {
				roleImage.setImage(new Image("@../../image/role/hunter.png"));
			}
			if(player.getRole().equals(Role.LITTLE_GIRL)) {
				roleImage.setImage(new Image("@../../image/role/littleGirl.png"));
			}
			if(player.getRole().equals(Role.WEREWOLF)) {
				roleImage.setImage(new Image("@../../image/role/wolf.png"));
			}
			if(player.getRole().equals(Role.WITCH)) {
				roleImage.setImage(new Image("@../../image/role/witch.png"));
			}
			if(player.getRole().equals(Role.VILLAGER)) {
				roleImage.setImage(new Image("@../../image/role/villager.png"));
			}
			Task<Boolean> gameTask = new Task<>() {
				@Override
				protected Boolean call() throws Exception {
					Thread.sleep(10000);
					Platform.runLater(() -> {	
						roleAttribution.setVisible(false);							
					});
					//Game Start
					Text start = new Text();
					start.setText("Game Message - The game start ! \n \nGame Message - Night falls on the city...\n \n");
					start.setFont(new Font("Arial", 15));
					chat.getChildren().add(start);
					Thread.sleep(1000);
					
					if(roleList.contains(Role.CUPID.getName())) {
						//Unique action of cupid
						Text cupid = new Text();
						cupid.setText("Game Message - It is cupid's turn to perform his special action ! \n \n ");
						cupid.setFont(new Font("Arial", 15));
						chat.getChildren().add(cupid);
						if(GameController.getCurrentPlayer().getRole().equals(Role.CUPID)) {
							Platform.runLater(() -> {	
								inLovePane.setVisible(true);	
								Text cupid2 = new Text();
								cupid2.setText("Game Message - Choose the lovers ! \n \n ");
								cupid2.setFont(new Font("Arial", 15));
								chat.getChildren().add(cupid2);
							});
						}
						Thread.sleep(60000);
						if(GameController.getCurrentPlayer().getRole().equals(Role.CUPID)) {
							Platform.runLater(() -> {	
								inLovePane.setVisible(false);							
							});
						}
						Text cupid3 = new Text();
						cupid3.setText("Game Message - Cupid has chosen the lovers ! \n \n ");
						cupid3.setFont(new Font("Arial", 15));
						chat.getChildren().add(cupid3);
					}
					
					
					do {
						PlayerInGame player2 = gameFacade.getPlayerInGame(GameManagementController.getCurrentGame().getGame_id(), GameManagementController.getCurrentPlayerInGame().getUsername());
						GameController.setCurrentPlayer(player2);
						Game game = gameManagementFacade.getGame(GameManagementController.getCurrentGame().getGame_id());
						GameController.setGame(game);
						
						
						
						
						
						
						
						
					}while(!GameController.getGame().isFinish());
					return true;
				}
			};
			Thread gameThread = new Thread(gameTask);
			gameThread.setDaemon(true);
			gameThread.start();
		} catch (IOException e) {
			InfoBox.infoBoxE("Verify your connection.", "Bad connection", "Connection Problem");
		}
	}

	/**
	 * @return the currentPlayer
	 */
	public static PlayerInGame getCurrentPlayer() {
		return GameController.currentPlayer;
	}

	/**
	 * @param currentPlayer the currentPlayer to set
	 */
	public static void setCurrentPlayer(PlayerInGame currentPlayer) {
		GameController.currentPlayer = currentPlayer;
	}

	/**
	 * @return the game
	 */
	public static Game getGame() {
		return GameController.game;
	}

	/**
	 * @param game the game to set
	 */
	public static void setGame(Game game) {
		GameController.game = game;
	}

	/**
	 * @return the roleList
	 */
	public ArrayList<String> getRoleList() {
		return roleList;
	}

	/**
	 * @param roleList the roleList to set
	 */
	public void setRoleList(ArrayList<String> roleList) {
		this.roleList = roleList;
	}

}
