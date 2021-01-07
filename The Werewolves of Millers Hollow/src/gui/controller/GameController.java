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
import javafx.scene.paint.Color;
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
	
	/**
	 * 
	 */
	@FXML
	private ImageView background;
	
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
	private ListView<Text> playerVoteList;
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void sendVote(ActionEvent event)  throws IOException {
		//Label vote = playerVoteList.getValue();
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
			GameFacade gameFacade = new GameFacade();
			boolean isDone = gameFacade.proposeAsASheriff(GameController.getGame().getGame_id(),GameController.getCurrentPlayer().getUsername());
			if(isDone) {
				//modifié avec envoie par chat !
				Text message = new Text();
				message.setText(" Game Message - "+ GameController.getCurrentPlayer().getUsername() +" would like to be Sheriff.\n\n");
				message.setFont(new Font("Arial", 15));
				message.setFill(Color.WHITE);
				chat.getChildren().add(message);
				ImageView image = new ImageView(new Image("@../../image/candidat.png"));
				image.setFitWidth(40);
				image.setFitHeight(80);
				chat.getChildren().add(image);
				Text speechCandidat = new Text();
				speechCandidat.setText(GameController.getCurrentPlayer().getUsername() +" : "+ mySpeech + "\n\n");
				speechCandidat.setFont(new Font("Arial", 15));
				speechCandidat.setFill(Color.WHITE);
				chat.getChildren().add(speechCandidat);
				speechPane.setVisible(false);
			}else {
				InfoBox.infoBoxW("Please retry...", "Connection problem", "Connection Problem");
			}
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
	
	//Cupid Part
	
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
					inLovePane.setVisible(false);
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
		try {
			TheWerewolvesOfMillersHollow.getStage().setOnCloseRequest(evt -> {
				GameFacade gameFacade = new GameFacade();
				boolean a = gameFacade.removePlayerInGame(GameController.getGame().getGame_id(), GameController.getCurrentPlayer().getUsername());
				if(a) {
					Text quit = new Text();
					quit.setText(" Game Message - The player "+ GameController.getCurrentPlayer().getUsername()+" leave the game! \n \n --> His role was "+ GameController.getCurrentPlayer().getRole().getName()+" \n\n");
					quit.setFont(new Font("Arial", 15));
					quit.setFill(Color.WHITE);
					chat.getChildren().add(quit);
					Platform.exit();
				}else {
					InfoBox.infoBoxE("You can't leave the game now :)", "Retry Later", "Connection Problem");
				}
			});
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		GameFacade gameFacade = new GameFacade();
		GameManagementFacade gameManagementFacade = new GameManagementFacade();
		try {
			Game game = gameManagementFacade.getGame(GameManagementController.getCurrentGame().getGame_id());
			GameController.setGame(game);
			ArrayList<String> role = gameFacade.getRoleList(GameController.getGame().getGame_id());
			this.setRoleList(role);
			PlayerInGame player = gameFacade.getPlayerInGame(GameController.getGame().getGame_id(), GameManagementController.getCurrentPlayerInGame().getUsername());
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
						//Game Start
						Text start = new Text();
						start.setText("\n Game Message - The game start ! \n \nGame Message - Night falls on the city..\n \n");
						start.setFont(new Font("Arial", 15));
						start.setFill(Color.WHITE);
						chat.getChildren().add(start);						
					});
					Thread.sleep(1000);
					
					if(roleList.contains(Role.CUPID.getName())) {
						//Unique action of CUPID
						Platform.runLater(() -> {		
							Text cupid = new Text();
							cupid.setText(" Game Message - It is cupid's turn to perform his special action! \n \n");
							cupid.setFont(new Font("Arial", 15));
							cupid.setFill(Color.WHITE);
							chat.getChildren().add(cupid);
						});
					
						if(GameController.getCurrentPlayer().getRole().equals(Role.CUPID)) {
							GameFacade gameFacade = new GameFacade();
							ArrayList<String> playerList = gameFacade.getPlayerList(GameController.getGame().getGame_id());
							for(String i : playerList) {
								Platform.runLater(() -> {
									firstPlayerInLove.getItems().add(i);
									secondPlayerInLove.getItems().add(i);
								});
							}
							Platform.runLater(() -> {	
								inLovePane.setVisible(true);
								Text cupid2 = new Text();
								cupid2.setText(" Game Message - Choose the lovers! \n \n");
								cupid2.setFont(new Font("Arial", 15));
								cupid2.setFill(Color.WHITE);
								chat.getChildren().add(cupid2);
							});
							
						}
						Thread.sleep(30000);
						if(GameController.getCurrentPlayer().getRole().equals(Role.CUPID)) {
							Platform.runLater(() -> {	
								inLovePane.setVisible(false);							
							});
						}
												
						//Display in Love with
						ArrayList<String> inLovePlayers = gameFacade.getPlayerInLove(GameController.getGame().getGame_id());
						if(inLovePlayers.isEmpty()) {
							Platform.runLater(() -> {	
								Text cupid3 = new Text();
								cupid3.setText(" Game Message - Cupid has not chosen lovers! \n \n");
								cupid3.setFont(new Font("Arial", 15));
								cupid3.setFill(Color.WHITE);
								chat.getChildren().add(cupid3);
							});
						}else {
							Platform.runLater(() -> {	
								Text cupid3 = new Text();
								cupid3.setText(" Game Message - Cupid has chosen the lovers! \n \n");
								cupid3.setFont(new Font("Arial", 15));
								cupid3.setFill(Color.WHITE);
								chat.getChildren().add(cupid3);
							});
							if(inLovePlayers.get(0).equals(GameController.getCurrentPlayer().getUsername())) {
								Platform.runLater(() -> {
									Text cupid4 = new Text();
									cupid4.setText(" Game Message - You are in love with "+ inLovePlayers.get(1)+ "! \n \n");
									cupid4.setFont(new Font("Arial", 15));
									cupid4.setFill(Color.WHITE);
									chat.getChildren().add(cupid4);
								});
							}
							if(inLovePlayers.get(1).equals(GameController.getCurrentPlayer().getUsername())) {
								Platform.runLater(() -> {
									Text cupid4 = new Text();
									cupid4.setText(" Game Message - You are in love with "+ inLovePlayers.get(0)+ "! \n \n");
									cupid4.setFont(new Font("Arial", 15));
									cupid4.setFill(Color.WHITE);
									chat.getChildren().add(cupid4);
								});
							}
						}
						Thread.sleep(2000);
					}
					
					//1st day with candidate and vote for Sheriff
					Platform.runLater(() -> {
						background.setImage(new Image("@../../image/dayBackground.png"));
						Text sheriffDay = new Text();
						sheriffDay.setText(" Game Message - The sun rises over the city.. \n \nThis morning, we can see werewolf scratches on the doors ...\n\nYou can now apply for the post of Sheriff!\n\n");
						sheriffDay.setFont(new Font("Arial", 15));
						sheriffDay.setFill(Color.WHITE);
						chat.getChildren().add(sheriffDay);
						speechPane.setVisible(true);
					});
					Thread.sleep(20000);
					Platform.runLater(() -> {
						speechPane.setVisible(false);
						Text sheriffDay2 = new Text();
						sheriffDay2.setText(" Game Message - Voting will start in a minute..\n\n");
						sheriffDay2.setFont(new Font("Arial", 15));
						sheriffDay2.setFill(Color.WHITE);
						chat.getChildren().add(sheriffDay2);
					});
					Thread.sleep(10000);
					GameFacade gameFacade = new GameFacade();
					ArrayList<PlayerInGame> playerList = gameFacade.getPlayerInGameList(GameController.getGame().getGame_id());
					for(PlayerInGame i : playerList) {
						if(i.isProposeAsASheriff()) {
							Platform.runLater(() -> {
								ImageView candidate = new ImageView(new Image("@../../image/candidat.png"));
								candidate.setFitHeight(20);
								candidate.setFitWidth(10);
								Text nextSheriff = new Text();
								nextSheriff.setText(i.getUsername());
								nextSheriff.setFont(new Font("Verdana", 15));
								playerVoteList.getItems().add(nextSheriff);
							});
						}else {
							Platform.runLater(() -> {
								Text nextSheriff = new Text();
								nextSheriff.setText(i.getUsername());
								nextSheriff.setFont(new Font("Verdana", 15));
								playerVoteList.getItems().add(nextSheriff);
							});
						}
					}
					Platform.runLater(() -> {
						votePane.setVisible(true);
						Text sheriffVote = new Text();
						sheriffVote.setText(" Game Message - Now you can vote for Sheriff!\n\n");
						sheriffVote.setFont(new Font("Arial", 15));
						sheriffVote.setFill(Color.WHITE);
						chat.getChildren().add(sheriffVote);
					});
					Thread.sleep(60000);
					
					Platform.runLater(() -> {
						votePane.setVisible(false);
					});
							
					Platform.runLater(() -> {
						Text sheriffVote = new Text();
						sheriffVote.setText(" Game Message - !\n\n");
						sheriffVote.setFont(new Font("Arial", 15));
						sheriffVote.setFill(Color.WHITE);
						chat.getChildren().add(sheriffVote);
					});
					
					do {
						PlayerInGame player = gameFacade.getPlayerInGame(GameController.getGame().getGame_id(), GameManagementController.getCurrentPlayerInGame().getUsername());
						player = gameFacade.getPlayerInGame(GameManagementController.getCurrentGame().getGame_id(), GameManagementController.getCurrentPlayerInGame().getUsername());
						GameController.setCurrentPlayer(player);
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
	
	/**
	 * 
	 * @return
	 */
	public String finalVote() {
		GameFacade gameFacade = new GameFacade();
		ArrayList<String> votes = gameFacade.getAllVotes(GameController.getGame().getGame_id());
		String result = votes.get(0);
		int a = 0;
		while(!votes.isEmpty()) {
			String e = votes.get(0);
			int o = 0;
			while(votes.contains(e)) {
				votes.remove(e);
				o++;
			}
			if(a < o) {
				a = o;
				result = e;
			}
		}
		return result; 
	}

}
