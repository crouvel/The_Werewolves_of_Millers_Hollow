package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

public class SelectAndJoinGameController  implements Initializable {
	
	private Label label;

	//TableView comment l'utiliser???
	
	@FXML
	void goToJoinAGame(ActionEvent event) {
		
	}
	
	@SuppressWarnings("unused")
	private void showJoinAGameWindow() throws IOException{
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("o7planning");
		dialog.setHeaderText("Enter your name:");
		dialog.setContentText("Name:"); 
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(name -> {
			this.label.setText(name);
		});
	}
	
	@FXML
	void returnPlayerMenu(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
