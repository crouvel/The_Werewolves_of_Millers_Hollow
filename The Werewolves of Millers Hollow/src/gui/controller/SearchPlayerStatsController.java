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
import businesslogic.domain.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class SearchPlayerStatsController  implements Initializable{
	
	//FXML Attributes
	
	/**
	 * 
	 */
	@FXML
	private ListView<Player> playersList;
	
	/**
	 * 
	 */
	@FXML
	private TextField usernameSearch;
	
	/**
	 * 
	 */
	@FXML
	private TextField playedSearch;
	
	/**
	 * 
	 */
	@FXML
	private TextField winSearch;
	
	/**
	 * 
	 */
	@FXML
	private TextField lostSearch;
	
	/**
	 * 
	 */
	@FXML
	private RadioButton minPlayed;
	
	/**
	 * 
	 */
	@FXML
	private RadioButton maxPlayed;
	
	/**
	 * 
	 */
	@FXML
	private RadioButton minWin;
	
	/**
	 * 
	 */
	@FXML
	private RadioButton maxWin;
	
	/**
	 * 
	 */
	@FXML
	private RadioButton minLost;
	
	/**
	 * 
	 */
	@FXML
	private RadioButton maxLost;
	
	//FXML Methods
	
	/**
	 * Allows the player to refine the research.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void startResearch(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * Returns the player to the selected player's statistics view .
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void viewPlayerStats(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * Returns the player to the player menu.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnPlayerMenu(ActionEvent event) throws IOException {
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

}