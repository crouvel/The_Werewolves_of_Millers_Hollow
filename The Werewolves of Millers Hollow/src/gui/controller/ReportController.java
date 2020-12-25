/**
 * package gui.controller.
 */
package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import javafx.event.ActionEvent;
/**
 * Imported libraries and classes.
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class ReportController implements Initializable {
	
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
	
	//FXML Methods
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void deleteReport(ActionEvent event) throws IOException{
		
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void goBlockAPlayer(ActionEvent event) throws IOException{
		
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
