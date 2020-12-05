package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;

public class AdministratorRegistrationController  implements Initializable{
	
	@FXML
	private TextField emailAdmin;
	
	@FXML
	private PasswordField passwordAdmin;
	
	@FXML
	void createAdministratorAccount(ActionEvent event) {
		
	}
	
	@FXML
	void returnAdministratorMenu(ActionEvent event) {
		
	}
	
	public static void infoBox(String message, String head, String title){
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
