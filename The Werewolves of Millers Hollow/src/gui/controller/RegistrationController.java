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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RegistrationController implements Initializable {
	
	//FXML Attributes
	
	/**
	 * 
	 */
	@FXML
	private TextField usernameField;
	
	/**
	 * 
	 */
	@FXML
	private TextField emailAddressField;
	
	/**
	 * 
	 */
	@FXML
	private TextField passwordField;
	
	/**
	 * 
	 */
	@FXML
	private DatePicker dateOfBirthField;
		
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void register(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnStartMenu(ActionEvent event) throws IOException {
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/StartMenuView.fxml"));
	}
	
	//Methodes ajoutees
	
	/**
	 * Open an info box.
	 * @param message
	 * @param head
	 * @param title
	 */
	public static void infoBox(String message, String head, String title){
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
		
	}
	
}
