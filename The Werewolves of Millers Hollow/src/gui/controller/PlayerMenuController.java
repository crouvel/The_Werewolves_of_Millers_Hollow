package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import businesslogic.systemelement.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class PlayerMenuController implements Initializable {
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField password;
	
	private User currentUser;
	
	public PlayerMenuController() {
       
    }
	
	
	@FXML
	void createAGame(ActionEvent event) throws IOException{
		
	}
	
	@FXML
	void joinAGame(ActionEvent event) throws IOException{
		
	}
	
	@FXML
	void searchPlayerStat(ActionEvent event) throws IOException{
		
	}
	
	@FXML
	void reportABug(ActionEvent event) throws IOException{
		
	}
	
	@FXML
	void viewProfile(ActionEvent event) throws IOException{
		
	}
	
	@FXML
	void viewFriendsList(ActionEvent event) throws IOException{
		
	}
	
	@FXML
	void signOut(ActionEvent event) throws IOException {
		
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


	public User getCurrentUser() {
		return currentUser;
	}


	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
