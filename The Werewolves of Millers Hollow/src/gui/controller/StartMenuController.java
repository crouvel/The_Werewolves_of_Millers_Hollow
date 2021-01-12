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

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class StartMenuController implements Initializable {

	//FXML Methods
	
	/**
	 * Go to the login view
	 * @param event
	 * @throws IOException
	 */
	@FXML
    void handleLogin(ActionEvent event) throws IOException {
        TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/LoginView.fxml"));
    }
	
	/**
	 * Go to the player register view
	 * @param event
	 * @throws IOException
	 */
	@FXML
    void handleRegister(ActionEvent event) throws IOException {
        TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/RegistrationView.fxml"));
    }

	//Added Methods 

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
