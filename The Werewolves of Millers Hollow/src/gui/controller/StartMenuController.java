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
import javafx.scene.control.TextField;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class StartMenuController implements Initializable {
	
	//FXML Attributes
	
	/**
	 * 
	 */
	@FXML
	private TextField email;
	
	/**
	 * 
	 */
	@FXML
	private TextField password;

	//FXML Methods
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
    void handleLogin(ActionEvent event) throws IOException {
        TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/LoginView.fxml"));
    }
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
    void handleRegister(ActionEvent event) throws IOException {
        TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/RegistrationView.fxml"));
    }

	//Added Methods 
	
	/**
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
