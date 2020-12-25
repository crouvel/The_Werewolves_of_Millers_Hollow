package gui.controller;

import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AdministratorProfileController  implements Initializable{
	
	@FXML
	private TextField adminEmail;

	@FXML
	private TextField adminPassword;
	
	@FXML
	void returnAdministratorMenu(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdminMenuView.fxml"));	
	}
	
	@FXML
	void saveModifications(ActionEvent event) {
		
	}
	
	@FXML
	void deleteAdministratorAccount(ActionEvent event) {
		
	}
	
	@FXML
	void modifyAdministratorEmail(ActionEvent event) {
		
	}
	
	@FXML
	void modifyAdministratorPassword(ActionEvent event) {
		
	}
	
	//METHOD AJOUTEE
	
	public static void infoBox(String message, String head, String title){
        //A CUSTOMISER
        Alert alert = new Alert(AlertType.ERROR);
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
