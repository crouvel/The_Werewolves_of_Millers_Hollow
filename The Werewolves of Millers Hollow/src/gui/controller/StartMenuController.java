package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StartMenuController implements Initializable {
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField password;
	
	Stage stage = new Stage();
	
	public StartMenuController() {
       
    }
	
	@FXML
    void handleLogin(ActionEvent event) throws IOException {
        TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/LoginView.fxml"));
    }

	@FXML
    void handleRegister(ActionEvent event) throws IOException {
        TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/RegistrationView.fxml"));
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
