/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported classes and libraries.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.facade.BlockAPlayerFacade;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class BlockAPlayerController implements Initializable {
	
	//FXML Attributes
	
	/**
	 * 
	 */
	@FXML
	private TextField usernameForBlock;

	//FXML Methods
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void blockAPlayer(ActionEvent event) throws IOException{
		String username = usernameForBlock.getText();
		if(username.isBlank()) {
			infoBox("Please enter a username before block an account.","Missing username","Missing Information");
		}
		BlockAPlayerFacade blockaplayerFacade = new BlockAPlayerFacade();
		boolean exists = blockaplayerFacade.existsPlayer(username);
		if(exists) {
			boolean isDone = blockaplayerFacade.blockAPlayer(username);
			if(isDone) {
				TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdministratorMenuView.fxml"));
			}
			else {
				infoBox("We encounter a problem during the process. Try later.","Problem during block","Encountered problem");
			}
		}
		else {
			infoBox("This username not exist.","Incorrect username","Incorrect Information");
		}
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnAdministratorMenu(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdministratorMenuView.fxml"));	
	}
	
	//Added Methods
	
	/**
	 * Open an info box.
	 * @param message
	 * @param head
	 * @param title
	 */
	public static void infoBox(String message, String head, String title){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(head);
        alert.showAndWait();
	}
	
	/**
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
