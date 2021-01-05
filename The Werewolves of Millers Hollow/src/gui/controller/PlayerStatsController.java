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
import businesslogic.domain.Gender;
import businesslogic.domain.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class PlayerStatsController implements Initializable {

	//Attributes
	
	/**
	 * Attribute corresponding to the observed player statistics.
	 */
	private static Player player;
	
	//FXML Attributes
	
	/**
	 * Attribute corresponding to the number of played games of player.
	 */
	@FXML
	private Text played;
	
	/**
	 * Attribute corresponding to the number of won games of player.
	 */
	@FXML
	private Text won;
	
	/**
	 * Attribute corresponding to the number of lost games of player.
	 */
	@FXML
	private Text lost;
	
	/**
	 * Attribute corresponding to the player username.
	 */
	@FXML
	private Text username;
	
	/**
	 * Attribute corresponding to the gender of player.
	 */
	@FXML
	private ImageView photo;
	
	/**
	 * Attribute corresponding to the country of player.
	 */
	@FXML
	private Text countryName;
	
	/**
	 * Attribute corresponding to the date of birth month of player.
	 */
	@FXML
	private Text month;
	
	/**
	 * Attribute corresponding to the date of birth day of player.
	 */
	@FXML
	private Text day;
	
	/**
	 * Attribute corresponding to the date of birth year of player.
	 */
	@FXML
	private Text year;
	
	/**
	 * Attribute corresponding to the country flag of player.
	 */
	@FXML
	private ImageView countryImage;
	
	/**
	 * Attribute corresponding to the comparison between player statistics and logged in player statistics.
	 */
	@FXML
	private BarChart<String,Number> comparaison;
	
	/**
	 * Attribute corresponding to the xAxis of the comparison BarChart.
	 */
	@FXML
	private CategoryAxis xAxis;
	/**
	 * Attribute corresponding to the yAxis of the comparison BarChart.
	 */
	@FXML
	private NumberAxis yAxis;
	
	/**
	 * Allows the player to return on the research window to search another player statistics.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void searchAnotherPlayer(ActionEvent event) throws IOException {
		PlayerStatsController.setPlayer(null);
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/SearchPlayerStatsView.fxml"));
	}
	
	/**
	 * Allows the player to return to the menu.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnPlayerMenu(ActionEvent event) throws IOException {
		PlayerStatsController.setPlayer(null);
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
	}
	
	@SuppressWarnings({"unchecked","deprecation"})
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			//profile information
			username.setText(PlayerStatsController.getPlayer().getUsername());
			played.setText(PlayerStatsController.getPlayer().getPlayedGames()+"");
			won.setText(PlayerStatsController.getPlayer().getWonGames()+"");
			lost.setText(PlayerStatsController.getPlayer().getLostGames()+"");
			System.out.println(PlayerStatsController.getPlayer().isStatus());
			if(PlayerStatsController.getPlayer().isStatus()==1) {
				month.setText((PlayerStatsController.getPlayer().getDateOfBirth().getMonth()+1)+"");
				day.setText(PlayerStatsController.getPlayer().getDateOfBirth().getDate()+"");
				year.setText(PlayerStatsController.getPlayer().getDateOfBirth().getYear()+"");
				if(PlayerStatsController.getPlayer().getGender()==Gender.MALE) {
					photo.setImage(new Image("@../../image/boy.png"));
				}else {
					photo.setImage(new Image("@../../image/girl.png"));
				}
				countryName.setText(PlayerStatsController.getPlayer().getCountry());
				countryImage.setImage(new Image("@../../image/country/"+PlayerStatsController.getPlayer().getCountry()+".png"));
			}else {
				month.setText("??");
				day.setText("??");
				year.setText("??");
				photo.setImage(new Image("@../../image/inconnu.png"));
				countryName.setText("Home");
				countryImage.setImage(new Image("@../../image/country/Home.png"));
			}
			//Comparison Statistics Graph
			//series creation
			XYChart.Series<String,Number> series = new XYChart.Series<String, Number>();
			series.setName(PlayerMenuController.getCurrentPlayer().getUsername());
			XYChart.Series<String,Number> series2 = new XYChart.Series<String, Number>();
			series2.setName(PlayerStatsController.getPlayer().getUsername());
			//series : current player statistics.
			series.getData().addAll(
					new XYChart.Data<String,Number>("Played",PlayerMenuController.getCurrentPlayer().getPlayedGames()),
					new XYChart.Data<String,Number>("Won",PlayerMenuController.getCurrentPlayer().getWonGames()),
					new XYChart.Data<String,Number>("Lost",PlayerMenuController.getCurrentPlayer().getLostGames()));
			//series2 : observed player statistics.
			series2.getData().addAll(
					new XYChart.Data<String,Number>("Played",PlayerStatsController.getPlayer().getPlayedGames()),
					new XYChart.Data<String,Number>("Won",PlayerStatsController.getPlayer().getWonGames()),
					new XYChart.Data<String,Number>("Lost",PlayerStatsController.getPlayer().getLostGames()));
			//initialization of BarChart
			comparaison.getData().addAll(series,series2);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
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
