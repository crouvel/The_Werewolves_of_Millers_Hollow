package gui.controller;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.facade.UserFacade;
import businesslogic.systemelement.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField password;
	
	@FXML
	void login(ActionEvent event) throws SQLException, IOException {
		String mail = email.getText();
		String pwd = password.getText();
		UserFacade userFacade = new UserFacade();
		User user;
		try {
			user = userFacade.login(mail,pwd);
		}catch(SQLException e) {
			infoBox("Please enter a correct email or password.","Incorrect email or password", "Incorrect or missing information");
            return;
		}
		if(user.isAdmin()==1) {
			TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdministratorMenuView.fxml"));
		}else {
			TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
		}
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
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(head);
        alert.showAndWait();
    }
	
	public void goToAdministratorMenu(URL resources,User user) throws IOException {
		FXMLLoader loader = new FXMLLoader(resources);
        AdministratorMenuController administrator = loader.<AdministratorMenuController>getController();
        administrator.setCurrentUser(user);
        TheWerewolvesOfMillersHollow.setScene(resources);
	}
	
	public void goToPlayerMenu(URL resources,User user) throws IOException {
		FXMLLoader loader = new FXMLLoader(resources);
        PlayerMenuController player = loader.<PlayerMenuController>getController();
        player.setCurrentUser(user);
        TheWerewolvesOfMillersHollow.setScene(resources);
	}	
}
