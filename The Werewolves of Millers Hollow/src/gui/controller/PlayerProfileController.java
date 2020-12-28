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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
	private DatePicker dateOfBirth;
	
	/**
	 * 
	 */
	@FXML
	private TextField gender;
	
	/**
	 * 
	 */
	@FXML
	private TextField country;
	
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
	 * Open an info box.
	 * @param message
	 * @param head
	 * @param title
	 */
	public static void infoBox(String message, String head, String title){
        //A CUSTOMISER
		Alert alert = new Alert(AlertType.CONFIRMATION);
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
		try {
			username.setText(PlayerMenuController.getCurrentPlayer().getUsername());
			playerEmail.setText(PlayerMenuController.getCurrentPlayer().getEmail());
			playerPassword.setText(PlayerMenuController.getCurrentPlayer().getPassword());
			//dateOfBirth
			gender.setText(PlayerMenuController.getCurrentPlayer().getGender().getName());
			country.setText(PlayerMenuController.getCurrentPlayer().getCountry());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
