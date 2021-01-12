/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported libraries and classes.
 */
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import util.HashPassword;
import util.InfoBox;

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
	
	@FXML
	private ChoiceBox<String> countryChoice;
	
	private ToggleGroup gender;
	
	@FXML
	private RadioButton choiceMale;
	
	@FXML
	private RadioButton choiceFemale;
  
	/**
	 * Allows the user to register an player account
	 * @param event
	 * @throws Exception 
	 */
	@FXML
	void register(ActionEvent event) throws IOException,Exception {
		String user = usernameField.getText();
		String email = emailAddressField.getText();
		String password = passwordField.getText();
		Date date = Date.valueOf(dateOfBirthField.getValue());
		String genderC = "Male";
		String count = (String) countryChoice.getValue();
		if(gender.getSelectedToggle()==choiceFemale) {
			genderC="Female";
		}
		//Username
		if(user.isBlank()) {
			InfoBox.infoBoxW("A valid username must be provided","Missing username","Missing information");
		}else {
			//Email
			if(email.isBlank()) {
				InfoBox.infoBoxW("A valid email must be provided","Missing email","Missing information");
			}else {
				//Password
				if(password.isBlank()) {
					InfoBox.infoBoxW("A valid password must be provided","Missing password","Missing information");
				}else {
					if(!user.matches("([a-z]|[A-Z]|[0-9])*")){
						InfoBox.infoBoxW("A username with valid syntax expected","Username syntax invalid","Invalid syntax");
					}
					else {
						if(!email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")){
							InfoBox.infoBoxW("An email with valid syntax expected","Email syntax invalid","Invalid syntax");
						}
						else {
							if(!password.matches("([a-z]|[A-Z]|[0-9])*")){
								InfoBox.infoBoxW("A password with valid syntax expected","Password syntax invalid","Invalid syntax");
							}
							else {
								UserFacade uf = new UserFacade();
								boolean isDone = uf.registerPlayer(user,email,HashPassword.hashPassword(password),date,genderC,count);
								if(isDone) {
									InfoBox.infoBoxI("Player created", "Player created", "Player Created");
									TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/StartMenuView.fxml"));
								}else {
									InfoBox.infoBoxE("Creation failed, retry later","Creation failed","Creation Error");
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Returns to the start menu of the application
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnStartMenu(ActionEvent event) throws IOException {
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/StartMenuView.fxml"));
	}

	//Added methods

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		countryChoice.getItems().add("France");
		countryChoice.getItems().add("USA");
		countryChoice.getItems().add("England");
		gender = new ToggleGroup();
		choiceMale.setToggleGroup(gender);
		choiceFemale.setToggleGroup(gender);
	}
}
