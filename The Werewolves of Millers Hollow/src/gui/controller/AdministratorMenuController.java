package gui.controller;

import businesslogic.systemelement.User;
import javafx.fxml.FXML;

public class AdministratorMenuController {
	
	private User currentUser;

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User user) {
		this.currentUser = user;
	}

}
