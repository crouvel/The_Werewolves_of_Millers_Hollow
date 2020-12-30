/**
 * package gui.controller
 */
package gui.controller;

/**
 * 
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class PlayerProfileController  implements Initializable{
	
	//FXML Attributes
	
	/**
	 * 
	 */
	@FXML
	private TextField username;
	
	/**
	 * 
	 */
	@FXML
	private TextField playerEmail;
	
	/**
	 * 
	 */
	@FXML
	private TextField playerPassword;
	
	/**
	 * 
	 */
	@FXML
	private Text dateOfBirth;
	
	/**
	 * 
	 */
	@FXML
	private Text gender;
	
	/**
	 * 
	 */
	@FXML
	private ComboBox<String> country;
	
	//FXML Methods
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void modifyUsername(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void modifyPlayerEmail(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void modifyPlayerPassword(ActionEvent event) throws IOException {

	}

	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void modifyCountry(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void saveModifications(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void deletePlayerAccount(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnPlayerMenu(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
	}

	//Added Methods

	/**
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			username.setText(PlayerMenuController.getCurrentPlayer().getUsername());
			playerEmail.setText(PlayerMenuController.getCurrentPlayer().getEmail());
			playerPassword.setText(PlayerMenuController.getCurrentPlayer().getPassword());
			dateOfBirth.setText(PlayerMenuController.getCurrentPlayer().getDateOfBirth().toString());
			gender.setText(PlayerMenuController.getCurrentPlayer().getGender().getName());
			country.setValue(PlayerMenuController.getCurrentPlayer().getCountry());
			country.getItems().add("France");
			country.getItems().add("USA");
			country.getItems().add("England");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
