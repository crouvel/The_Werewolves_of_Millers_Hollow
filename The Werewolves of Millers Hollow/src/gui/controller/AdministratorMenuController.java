package gui.controller;

import businesslogic.systemelement.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AdministratorMenuController {
	
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

}
