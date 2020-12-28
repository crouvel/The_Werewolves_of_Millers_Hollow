package gui.controller;

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
	
	/**
	 * 
	 */
	@FXML
	private BarChart<String,Number> comparaison;
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void searchAnotherPlayer(ActionEvent event) throws IOException {
		PlayerStatsController.setPlayer(null);
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/SearchPlayerStatsView.fxml"));
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnPlayerMenu(ActionEvent event) throws IOException {
		PlayerStatsController.setPlayer(null);
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		//Comparaison Stats Graph
		try {
			username.setText(PlayerStatsController.getPlayer().getUsername());
			played.setText(PlayerStatsController.getPlayer().getPlayedGames()+"");
			won.setText(PlayerStatsController.getPlayer().getWonGames()+"");
			lost.setText(PlayerStatsController.getPlayer().getLostGames()+"");
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
			//Axis initialization
			CategoryAxis xAxis = new CategoryAxis();
			NumberAxis yAxis = new NumberAxis();
			//creation of graph
			comparaison = new BarChart<String,Number>(xAxis,yAxis);
			XYChart.Series<String,Number> series = new XYChart.Series<String, Number>();
			series.setName(PlayerMenuController.getCurrentPlayer().getUsername());
			XYChart.Series<String,Number> series2 = new XYChart.Series<String, Number>();
			series2.setName(PlayerStatsController.getPlayer().getUsername());
			//series
			series.getData().addAll(
					new XYChart.Data<String,Number>("Played",PlayerMenuController.getCurrentPlayer().getPlayedGames()),
					new XYChart.Data<String,Number>("Won",PlayerMenuController.getCurrentPlayer().getWonGames()),
					new XYChart.Data<String,Number>("Lost",PlayerMenuController.getCurrentPlayer().getLostGames()));
			
			series2.getData().addAll(
					new XYChart.Data<String,Number>("Played",PlayerStatsController.getPlayer().getPlayedGames()),
					new XYChart.Data<String,Number>("Won",PlayerStatsController.getPlayer().getWonGames()),
					new XYChart.Data<String,Number>("Lost",PlayerStatsController.getPlayer().getLostGames()));
			comparaison.getData().addAll(series,series2);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
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
