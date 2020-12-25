/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported libraries/classes
 */
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.BugReport;
import businesslogic.domain.PlayerReport;
import businesslogic.facade.ReportManagementFacade;
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
		BugReport report = bugReports.getSelectionModel().getSelectedItem();
		if(report==null) {
			infoBoxWarning("Please select a bug report before check.","Missing report.","Missing informations");
		}else {
			ReportManagementFacade reportManagementFacade = new ReportManagementFacade();
			boolean exists = reportManagementFacade.existsReport(report.getReportId());
			if(exists) {		
				ReportController.setCurrentReport(report);
				TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/ReportView.fxml"));
			}else {
				infoBoxError("Retry to check the bug report later.","Incorrect information.", "Connection problem");
			}
		}
	}
	
	/**
	 * Returns the administrator to the view where he can see the preview of the bug report selected in the list bugReports.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void checkPlayerReport(ActionEvent event) throws IOException{
		PlayerReport report = playerReports.getSelectionModel().getSelectedItem();
		if(report==null) {
			infoBoxWarning("Please select a player report before check.","Missing report.","Missing informations");
		}else {
			ReportManagementFacade reportManagementFacade = new ReportManagementFacade();
			boolean exists = reportManagementFacade.existsReport(report.getReportId());
			if(exists) {		
				ReportController.setCurrentReport(report);
				TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/ReportView.fxml"));
			}else {
				infoBoxError("Retry to check the player report later.","Incorrect information.", "Connection problem");
			}
		}
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
	public static void infoBoxWarning(String message, String head, String title){
        Alert alert = new Alert(AlertType.WARNING);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(head);
        alert.showAndWait();
    }
	
	/**
	 * Open an info box.
	 * @param message
	 * @param head
	 * @param title
	 */
	public static void infoBoxError(String message, String head, String title){
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
		ReportManagementFacade reportManagementFacade = new ReportManagementFacade();
		ArrayList<PlayerReport> playersReports;
		ArrayList<BugReport> bugsReports;
		playersReports = reportManagementFacade.showPlayerReports();
		for(PlayerReport player : playersReports) {
			playerReports.getItems().add(player);
		}
		bugsReports = reportManagementFacade.showBugReports();
		for(BugReport bug : bugsReports) {
			bugReports.getItems().add(bug);
		}
	}
}
