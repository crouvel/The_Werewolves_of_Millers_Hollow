/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported libraries and classes.
 */
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.Administrator;
import businesslogic.facade.UserFacade;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class AdministratorMenuController  implements Initializable{
	
	//Added Attribute
	
	/**
	 * Attribute containing the current user (Administrator connected)
	 */
	private static Administrator currentAdmin;

	//FXML Methods
	
	/**
	 * Logged out the administratorReturns the administrator and go to the start menu of the application.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void signOut(ActionEvent event) throws IOException {
		LoginController.setCurrentUser(null);
		AdministratorMenuController.setCurrentAdmin(null);
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/StartMenuView.fxml"));
	}
	
	/**
	 * Returns the administrator to his profile view.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void viewProfile(ActionEvent event) throws IOException {
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdminProfileView.fxml"));
	}
	
	/**
	 * Returns the administrator to the report management view.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void manageReports(ActionEvent event) throws IOException {
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/ReportManagementView.fxml"));	
	}
	
	/**
	 * Returns the administrator to the view who allows them to register a new administrator.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void createAnAdministratorAccount(ActionEvent event) throws IOException {
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdministratorRegistrationView.fxml"));
	}
	
	//Added Methods
	
	/**
	 * @return the currentAdmin
	 */
	public static Administrator getCurrentAdmin() throws IOException {
		return currentAdmin;
	}

	/**
	 * @param currentAdmin the currentAdmin to set
	 */
	public static void setCurrentAdmin(Administrator currentAdmin) throws IOException {
		AdministratorMenuController.currentAdmin = currentAdmin;
	}

	/**
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		UserFacade userFacade = new UserFacade();
		try {
			currentAdmin = userFacade.getAdmin(LoginController.getCurrentUser());
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}	
	}

}
