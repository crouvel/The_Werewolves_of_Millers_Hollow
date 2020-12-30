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
import businesslogic.facade.ReportABugFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import util.InfoBox;
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
		String sub = subject.getText();
		String image = imageLink.getText();
		String desc = description.getText();

		if(sub.isBlank()) {
			InfoBox.infoBoxW("Please enter a subject","Missing Subject","Missing Information");
		}else {
			if(desc.isBlank()) {
				InfoBox.infoBoxW("Please enter a description","Missing Description","Missing Information");
			}else {
				if(!sub.matches("([a-z]|[A-Z]|[0-9])*")){
					InfoBox.infoBoxW("Please enter a valid subject","Invalid Subject","Invalid Syntax");
				}else {
					if(!image.isBlank()) {
						if(!image.matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")) {
							InfoBox.infoBoxW("Please enter a valid url","Invalid attachment link","Invalid URL");
						}else {
							if(image.contains(">") || image.contains("<")) {
								InfoBox.infoBoxW("Invalid character detected","Invalid character","Invalid URL");
							}else {
								ReportABugFacade rbf = new ReportABugFacade();
								boolean isDone = rbf.createBugReport(sub, desc, image);
								if(isDone) {
									InfoBox.infoBoxI("Bug report sent", "Report sent", "Report sent");
									TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
								}else {
									InfoBox.infoBoxW("Problem sending bug report","Connection problem.", "Connection problem");
									TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/ReportABugView.fxml"));
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * Allows the player to erase the field of the bug report's form.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void cancelAction(ActionEvent event) throws IOException {
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/ReportABugView.fxml"));
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
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
