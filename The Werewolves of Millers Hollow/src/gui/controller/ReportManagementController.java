/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported libraries/classes
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.BugReport;
import businesslogic.domain.PlayerReport;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class ReportManagementController implements Initializable {
	/**
	 * Attribute containing a list of player reports.
	 */
	@FXML
	private ListView<PlayerReport> playerReports;
	
	/**
	 * Attribute containing a list of bug reports. 
	 */
	@FXML
	private ListView<BugReport> bugReports;
	
	/**
	 * Returns the administrator to the view where he can see the preview of the bug report selected in the list bugReports.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void checkBugReport(ActionEvent event) throws IOException{
		
	}
	
	/**
	 * Returns the administrator to the view where he can see the preview of the bug report selected in the list bugReports.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void checkPlayerReport(ActionEvent event) throws IOException{
		
	}
	
	/**
	 * Returns the administrator to the administrator menu.
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
