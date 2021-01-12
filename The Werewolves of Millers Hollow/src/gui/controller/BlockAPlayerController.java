/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported classes and libraries.
 */
import java.io.IOException;
/**
 * 
 */
import java.net.URL;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.facade.BlockAPlayerFacade;
import util.InfoBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

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
	 * Permit the admin to block a player
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void blockAPlayer(ActionEvent event) throws IOException{
		String username = usernameForBlock.getText();
		if(username.isBlank()) {
			InfoBox.infoBoxW("Please enter a username before block an account.","Missing username","Missing Information");
		} else {
			boolean confirmation = InfoBox.infoBoxC("Are you sure you want to block the player?", "Block confirmation");
			if(confirmation) {
				BlockAPlayerFacade blockaplayerFacade = new BlockAPlayerFacade();
				boolean exists = blockaplayerFacade.existsPlayer(username);
				if(exists) {
					boolean isDone = blockaplayerFacade.blockAPlayer(username);
					if(isDone) {
						TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/ReportManagementView.fxml"));
					}
					else {
						InfoBox.infoBoxE("We encounter a problem during the process. Try later.","Problem during block","Encountered problem");
					}
				}
				else {
					InfoBox.infoBoxE("This username not exist.","Incorrect username","Incorrect Information");
				}
			}
		}
	}
	
	/**
	 * Return to the administrator menu
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnAdministratorMenu(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdministratorMenuView.fxml"));	
	}
	
	//Added Methods

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
