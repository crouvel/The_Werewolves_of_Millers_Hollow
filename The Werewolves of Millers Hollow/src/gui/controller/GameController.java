/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported Classes and Libraries.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.Game;
import businesslogic.domain.PlayerInGame;
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
import javafx.scene.layout.Pane;
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
	private ListView<String> chat;
	
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
	
	//Other functions
	
	/**
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		/*
		ProgressBar progress = new ProgressBar();
        progress.setMinWidth(200);
        progress.setMaxWidth(Double.MAX_VALUE);
        IntegerProperty seconds = new SimpleIntegerProperty();
        progress.progressProperty().bind(seconds.divide(60.0));
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(seconds, 0)),
            new KeyFrame(Duration.minutes(1), e-> {
                // do anything you need here on completion...
                System.out.println("Minute over");
            }, new KeyValue(seconds, 60))   
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
		*/
	}

	/**
	 * @return the currentPlayer
	 */
	public static PlayerInGame getCurrentPlayer() {
		return currentPlayer;
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
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public static void setGame(Game game) {
		GameController.game = game;
	}

}
