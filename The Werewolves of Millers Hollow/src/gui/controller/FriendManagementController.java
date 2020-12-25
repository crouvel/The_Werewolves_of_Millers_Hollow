package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FriendManagementController  implements Initializable {
	
	
	
	
	
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
