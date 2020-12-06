package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import businesslogic.systemelement.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class AdministratorMenuController  implements Initializable{
	
	private User currentUser;

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User user) {
		this.currentUser = user;
	}
	
	@FXML
	void signOut(ActionEvent event) {
		
	}
	
	@FXML
	void viewProfile(ActionEvent event) {
		
	}
	
	@FXML
	void manageReports(ActionEvent event) {
		
	}
	
	@FXML
	void createAnAdministratorAccount(ActionEvent event) {
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
