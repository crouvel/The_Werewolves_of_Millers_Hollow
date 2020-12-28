/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported libraries and classes.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class ReportABugController  implements Initializable{
	
	/**
	 * Attribute uses to define the bug report's subject.
	 */
	@FXML
	private TextField subject;
	
	/**
	 * Attribute uses to define a bug report's image url link.
	 */
	@FXML
	private TextField imageLink;
	
	/**
	 * Attribute uses to define the bug report's description.
	 */
	@FXML
	private TextArea description;
	
	/**
	 * Allows the player to send a bug report.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void sendBugReport(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * Allows the player to erase the field of the bug report's form.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void cancelAction(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * Returns the player to the player menu.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnPlayerMenu(ActionEvent event) throws IOException {
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
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
		// TODO Auto-generated method stub
		
	}

}
