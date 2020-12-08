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
import businesslogic.systemelement.User;
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
	private User currentUser;

	//FXML Methods
	
	/**
	 * Logged out the administratorReturns the administrator and go to the start menu of the application.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void signOut(ActionEvent event) throws IOException {
		//A Compléter
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
	 * Getter of currentUser.
	 * @return the current user 
	 */
	public User getCurrentUser() {
		return currentUser;
	}

	/**
	 * Setter of currentUser.
	 * @param user : new value of currentUser.
	 */
	public void setCurrentUser(User user) {
		this.currentUser = user;
	}

	/**
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
