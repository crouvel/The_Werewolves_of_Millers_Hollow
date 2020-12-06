package gui.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class PlayerProfileController  implements Initializable{
	
	@FXML
	private TextField username;
	
	@FXML
	private TextField playerEmail;
	
	@FXML
	private TextField playerPassword;
	
	@FXML
	private TextField dateOfBirth;
	
	@FXML
	private TextField gender;
	
	@FXML
	private TextField country;
	
	@FXML
	void modifyUsername(ActionEvent event) {
		
	}
	
	@FXML
	void modifyPlayerEmail(ActionEvent event) {
		
	}
	
	@FXML
	void modifyPlayerPassword(ActionEvent event) {
		
	}
	
	@FXML
	void modifyCountry(ActionEvent event) {
		
	}
	
	@FXML
	void saveModifications(ActionEvent event) {
		
	}
	
	@FXML
	void deletePlayerAccount(ActionEvent event) {
		
	}
	
	@FXML
	void returnPlayerMenu(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
	}

	//METHOD AJOUTE
	
	public static void infoBox(String message, String head, String title){
        //A CUSTOMISER
		Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(head);
        alert.showAndWait();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
