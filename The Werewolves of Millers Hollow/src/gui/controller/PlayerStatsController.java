package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class PlayerStatsController implements Initializable {

	//Attributes
	
	/**
	 * 
	 */
	private static Player player;
	
	//FXML Attributes
	
	/**
	 * 
	 */
	@FXML
	private Text played;
	
	/**
	 * 
	 */
	@FXML
	private Text won;
	
	/**
	 * 
	 */
	@FXML
	private Text lost;
	
	/**
	 * 
	 */
	@FXML
	private Text username;
	
	/**
	 * 
	 */
	@FXML
	private ImageView photo;
	
	/**
	 * 
	 */
	@FXML
	private Text countryName;
	
	/**
	 * 
	 */
	@FXML
	private Text month;
	
	/**
	 * 
	 */
	@FXML
	private Text day;
	
	/**
	 * 
	 */
	@FXML
	private Text year;
	
	/**
	 * 
	 */
	@FXML
	private ImageView countryImage;
	
	@FXML
	private BarChart<CategoryAxis,NumberAxis> comparaison;
	
	@FXML
	void searchAnotherPlayer(ActionEvent event) throws IOException {
		PlayerStatsController.setPlayer(null);
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/SearchPlayerStatsView.fxml"));
	}
	
	@FXML
	void returnPlayerMenu(ActionEvent event) throws IOException {
		PlayerStatsController.setPlayer(null);
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

	/**
	 * @return the player
	 */
	public static Player getPlayer() throws IOException {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public static void setPlayer(Player player) throws IOException {
		PlayerStatsController.player = player;
	}

}
