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
import businesslogic.domain.User;
import businesslogic.facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import util.HashPassword;
import util.InfoBox;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class LoginController implements Initializable {
	
	//FXML Attributes
	
	/**
	 * 
	 */
	@FXML
	private TextField email;
	
	/**
	 * 
	 */
	@FXML
	private TextField password;
	
	//Attributes
	/**
	 * 
	 */
	private static User currentUser;
	
	//FXML Methods
	
	/**
	 * Allows the user to log in using their email and password.
	 * @param event
	 * @throws Exception 
	 */
	@FXML
	void login(ActionEvent event) throws Exception {
		String mail = email.getText();
		String pwd = password.getText();
		if(mail.isBlank() && pwd.isBlank()) {
			InfoBox.infoBoxW("Please enter an email address and a password.","Missing email address and password","Missing informations");
		}else {
			if(mail.isBlank()) {
				InfoBox.infoBoxW("Please enter an email address.","Missing email address","Missing information");
			}else {
				if(pwd.isBlank()) {
					InfoBox.infoBoxW("Please enter a password.","Missing password","Missing information");
				}else {
					UserFacade userFacade = new UserFacade();
					User user=userFacade.login(mail,HashPassword.hashPassword(pwd));
					if (user != null) {
						if(user.isAdmin()==1) {
							user.setPassword(pwd);
							TheWerewolvesOfMillersHollow.goToAdminMenu(user,getClass().getResource("../view/AdministratorMenuView.fxml"));
						}else {
							if(user.isLockedAccount()) {
								InfoBox.infoBoxI("Try to contact an administrator.. Good Luck !","Blocked account", "Locked Account");
							}else {
								user.setPassword(pwd);
								TheWerewolvesOfMillersHollow.goToPlayerMenu(user,getClass().getResource("../view/PlayerMenuView.fxml"));
							}
						}
					}else {
						InfoBox.infoBoxE("Please enter a correct email or password.","Incorrect email or password", "Incorrect information");
					}
				}
			}
		}		
	}

	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnMenu(ActionEvent event) throws IOException {
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/StartMenuView.fxml"));
	}
	
	//Methodes ajoutees
	
	/**
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

	/**
	 * @return the currentUser
	 */
	public static User getCurrentUser() throws IOException {
		return currentUser;
	}

	/**
	 * @param currentUser the currentUser to set
	 */
	public static void setCurrentUser(User currentUser) throws IOException {
		LoginController.currentUser = currentUser;
	}
	
}
