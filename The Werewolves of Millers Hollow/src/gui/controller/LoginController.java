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

public class LoginController implements Initializable {
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField password;
	
	public LoginController() {
       
    }
	
	@FXML
	void login(ActionEvent event) {
		
	}
	
	@FXML
	void returnMenu(ActionEvent event) throws IOException {
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/StartMenuView.fxml"));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	//Methodes ajoutees
	
	
	public static void infoBox(String message, String head, String title){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(head);
        alert.showAndWait();
    }
}
