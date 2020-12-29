/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported libraries and classes
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
public class AdministratorProfileController  implements Initializable{
	
	//FXML Attributes
	
	/**
	 * 
	 */
	@FXML
	private TextField adminEmail;
	
	/**
	 * 
	 */
	@FXML
	private TextField adminPassword;
	
	//FXML Methods
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnAdministratorMenu(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdministratorMenuView.fxml"));	
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
	void deleteAdministratorAccount(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void modifyAdministratorEmail(ActionEvent event) throws IOException{
		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void modifyAdministratorPassword(ActionEvent event) throws IOException {
		
	}
	
	//Added Methods
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		try {
			adminEmail.setText(AdministratorMenuController.getCurrentAdmin().getEmail());
			adminPassword.setText(AdministratorMenuController.getCurrentAdmin().getPassword());	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
