/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported libraries and classes.
 */
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.Player;
import businesslogic.facade.UserFacade;
import util.InfoBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class SearchPlayerStatsController  implements Initializable{
	
	//FXML Attributes
	
	/**
	 * Attribute uses to choose if it's maximum Played Games or minimum Played Games.
	 */
	private ToggleGroup playedGroup;
	
	/**
	 * Attribute uses to choose if it's maximum Won Games or minimum Won Games.
	 */
	private ToggleGroup wonGroup;
	
	/**
	 * Attribute uses to choose if it's maximum Lost Games or minimum Lost Games.
	 */
	private ToggleGroup lostGroup;
	
	/**
	 * Attribute uses to display the playerList.
	 */
	@FXML
	private ListView<String> playersList;
	
	/**
	 * Attribute uses to choose the username searched or part of username searched.
	 */
	@FXML
	private TextField usernameSearch;
	
	/**
	 * Attribute uses to choose the number of Played Games.
	 */
	@FXML
	private TextField playedSearch;
	
	/**
	 * Attribute uses to choose the number of Win Games.
	 */
	@FXML
	private TextField winSearch;
	
	/**
	 * Attribute uses to choose the number of Lost Games.
	 */
	@FXML
	private TextField lostSearch;
	
	/**
	 * Attribute uses to choose to search by the minimum of Played Games.
	 */
	@FXML
	private RadioButton minPlayed;
	
	/**
	 * Attribute uses to choose to search by the maximum of Played Games.
	 */
	@FXML
	private RadioButton maxPlayed;
	
	/**
	 * Attribute uses to choose to search by the minimum of Won Games.
	 */
	@FXML
	private RadioButton minWin;
	
	/**
	 * Attribute uses to choose to search by the maximum of Won Games.
	 */
	@FXML
	private RadioButton maxWin;
	
	/**
	 * Attribute uses to choose to search by the minimum of Lost Games.
	 */
	@FXML
	private RadioButton minLost;
	
	/**
	 * Attribute uses to choose to search by the maximum of Lost Games.
	 */
	@FXML
	private RadioButton maxLost;
	
	//FXML Methods
	
	/**
	 * Allows the player to refine the research.
	 * @param event
	 * @throws IOException, NumberFormatException
	 */
	@FXML
	void startResearch(ActionEvent event) throws IOException,NumberFormatException {
		String theSearchUsername = usernameSearch.getText();
		String searchPlayed = playedSearch.getText();
		String searchWin = winSearch.getText();
		String searchLost = lostSearch.getText();
		if(!theSearchUsername.matches("([a-z]|[A-Z]|[0-9])*")) {
			InfoBox.infoBoxE("Please enter a correct username or a correct string.","Incorrect syntax for the username field","Incorrect syntax");
		}else {
			int play = 0;
			int win = 0;
			int lost = 0;
			try {
			   play = Integer.parseInt(searchPlayed);
			}catch (NumberFormatException e){
				InfoBox.infoBoxE("Please enter an integer for the number of played games.","Incorrect syntax for the number of played games","Incorrect syntax");
			}
			try {
				win = Integer.parseInt(searchWin);
			}catch (NumberFormatException e){
				InfoBox.infoBoxE("Please enter an integer for the number of won games.","Incorrect syntax for the number of won games","Incorrect syntax");
			}
			try {
				lost = Integer.parseInt(searchLost);
			}catch (NumberFormatException e){	
				InfoBox.infoBoxE("Please enter an integer for the number of lost games.","Incorrect syntax for the number of lost games","Incorrect syntax");
			}	
			boolean maxP = true;
			boolean maxW = true;
			boolean maxL = true;
			if(playedGroup.getSelectedToggle()==minPlayed) {
				maxP = false;
			}
			if(wonGroup.getSelectedToggle()==minWin) {
				maxW = false;
			}
			if(lostGroup.getSelectedToggle()==minLost) {
				maxL = false;
			}
			UserFacade userfacade = new UserFacade();
			ArrayList<String> searchList = new ArrayList<String>();
			try {
				searchList = userfacade.getCorrespondingPlayers(theSearchUsername, play, win, lost, maxP, maxW, maxL);
				if(searchList.isEmpty()) {
					InfoBox.infoBoxW("No result.. Another try ?","Empty list in result :","No result");
				}else {
					playersList.getItems().clear();
					for(String username : searchList) {
						playersList.getItems().add(username);
					}
				}
			}catch(SQLException e) {
				e.getStackTrace();
			}
		}
	}

	/**
	 * Returns the player to the selected player's statistics view .
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void viewPlayerStats(ActionEvent event) throws IOException {
		String username = playersList.getSelectionModel().getSelectedItem();
		if(username == null) {
			InfoBox.infoBoxW("Please select a player before try to show player profile.","Selected player missing","Missing Information");
		}else {
			UserFacade userfacade = new UserFacade();
			Player player = userfacade.searchPlayerStats(username);
			if(player != null) {
				TheWerewolvesOfMillersHollow.goToPlayerStats(player,getClass().getResource("../view/PlayerStatsView.fxml"));
			}else {
				InfoBox.infoBoxW("Please try later.","Bad connection / inexistant player","Connection problem or inexistant player");
			}
		}
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		UserFacade userfacade = new UserFacade();
		ArrayList<String> searchList;
		playedGroup = new ToggleGroup();
		minPlayed.setToggleGroup(playedGroup);
		maxPlayed.setToggleGroup(playedGroup);
		wonGroup = new ToggleGroup();
		minWin.setToggleGroup(wonGroup);
		maxWin.setToggleGroup(wonGroup);
		lostGroup = new ToggleGroup();
		minLost.setToggleGroup(lostGroup);
		maxLost.setToggleGroup(lostGroup);
		try {
			searchList = userfacade.getCorrespondingPlayers("", 0, 0, 0, false, false, false);
			for(String username : searchList) {
				playersList.getItems().add(username);
			}
		}catch(SQLException e) {
			e.getStackTrace();
		}	
	}

}