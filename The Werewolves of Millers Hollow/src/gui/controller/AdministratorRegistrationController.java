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
import businesslogic.facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import util.HashPassword;
import util.InfoBox;
import javafx.scene.control.PasswordField;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class AdministratorRegistrationController  implements Initializable{
	
	//FXML Attributes
	
	/**
	 * 
	 */
	@FXML
	private TextField emailAdmin;
	
	/**
	 * 
	 */
	@FXML
	private PasswordField passwordAdmin;
	
	//FXML Methods
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void createAdministratorAccount(ActionEvent event) throws IOException,Exception {
		String adEmail = emailAdmin.getText();
		String adPassword = passwordAdmin.getText(); 
		
		if(adEmail.isBlank()) {
			InfoBox.infoBoxW("A valid email must be provided","Missing email","Missing information");
		}else {
			if(adPassword.isBlank()) {
				InfoBox.infoBoxW("A valid password must be provided","Missing password","Missing information");
			}else {
				if(!adEmail.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
					InfoBox.infoBoxW("An email with valid syntax expected","Email syntax invalid","Invalid syntax");
				}else {
					if(!adPassword.matches("([a-z]|[A-Z]|[0-9])*")){
						InfoBox.infoBoxW("A password with valid syntax expected","Password syntax invalid","Invalid syntax");
					}
					else {
						UserFacade uf = new UserFacade();
						boolean isDone = uf.registerAdministrator(adEmail, HashPassword.hashPassword(adPassword));
						if(isDone) {
							InfoBox.infoBoxI("Admin created", "Admin created", "Admin Created");
							TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdministratorMenuView.fxml"));
						}else {
							InfoBox.infoBoxE("Creation failed, retry later","Creation failed","Creation Error");
						}
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnAdministratorMenu(ActionEvent event) throws IOException {
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdministratorMenuView.fxml"));	
	}
	
	//Added Methods

	/**
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
