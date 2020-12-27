/**
 * package gui.controller.
 */
package gui.controller;

/**
 * Imported libraries and classes.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.BugReport;
import businesslogic.domain.PlayerReport;
import businesslogic.domain.Report;
import businesslogic.facade.ReportManagementFacade;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class ReportController implements Initializable {
	
	//Attributes
	
	/**
	 * 
	 */
	private static Report currentReport;
	
	//FXML Attributes
	
	/**
	 * 
	 */
	@FXML
	private Text titleIdTypeReport;
	
	/**
	 * 
	 */
	@FXML
	private TextFlow reportSpecifications;
	
	/**
	 * 
	 */
	@FXML
	private Button blockButton;
	
	//FXML Methods
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void deleteReport(ActionEvent event) throws IOException{
		Report report = ReportController.currentReport;
		if(report == null) {
			infoBoxE("Reload your application before retry to delete this report, we encounter a problem.","Problem with the current report :","Error");
		}else {
			ReportManagementFacade reportManagementFacade = new ReportManagementFacade();
			boolean isDone = reportManagementFacade.deleteReport(ReportController.getCurrentReport().getReportId());
			if(isDone) {		
				TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdministratorMenuView.fxml"));
			}else {
				infoBoxW("Retry to delete this report later.","Connection problem.", "Connection problem");
				TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/ReportManagementView.fxml"));
			}
		}		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void goBlockAPlayer(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/BlockAPlayerView.fxml"));
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnReportManagement(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/ReportManagementView.fxml"));
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
	public static void infoBoxC(String message, String head, String title){
        Alert alert = new Alert(AlertType.CONFIRMATION);
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
	public static void infoBoxE(String message, String head, String title){
        Alert alert = new Alert(AlertType.ERROR);
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
	public static void infoBoxW(String message, String head, String title){
        Alert alert = new Alert(AlertType.WARNING);
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
		if(currentReport instanceof BugReport) {
			titleIdTypeReport.setText(((BugReport) currentReport).getSubject() +"\n Bug Report");
			Text description = new Text();
			description.setText(currentReport.getDescription());
			description.setFont(new Font("Arial", 20));
			String url = ((BugReport) currentReport).getAttachment();
			ImageView img = new ImageView(url);	
			reportSpecifications.getChildren().add(description);
			reportSpecifications.getChildren().add(img);
			blockButton.setDisable(true);
		}else {
			if(currentReport instanceof PlayerReport) {
				titleIdTypeReport.setText((((PlayerReport) currentReport).getReportTypeString()) +"\n Player Report");
				Text description = new Text();
				description.setText(currentReport.getDescription());
				description.setFont(new Font("Arial", 20));
				reportSpecifications.getChildren().add(description);
			}
		}			
	}

	/**
	 * @return the currentReport
	 */
	public static Report getCurrentReport() {
		return ReportController.currentReport;
	}

	/**
	 * @param currentReport the currentReport to set
	 */
	public static void setCurrentReport(Report currentReport) {
		ReportController.currentReport = currentReport;
	}
	

}
