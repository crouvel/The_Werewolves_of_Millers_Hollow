/**
 * package gui.controller
 */
package gui.controller;

/**
 * 
 */
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.User;
import businesslogic.facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

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
	
	//FXML Methods
	
	/**
	 * 
	 * @param event
	 * @throws SQLException
	 * @throws IOException
	 */
	@FXML
	void login(ActionEvent event) throws SQLException, IOException {
		String mail = email.getText();
		String pwd = password.getText();
		if(mail.isBlank() && pwd.isBlank()) {
			infoBox("Please enter an email address and a password.","Missing email address and password","Missing informations");
		}else {
			if(mail.isBlank()) {
				infoBox("Please enter an email address.","Missing email address","Missing information");
			}else {
				if(pwd.isBlank()) {
					infoBox("Please enter a password.","Missing password","Missing information");
				}else {
					UserFacade userFacade = new UserFacade();
					User user=userFacade.login(mail,pwd);
					if (user != null) {
						if(user.isAdmin()==1) {
							TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdministratorMenuView.fxml"));
						}else {
							TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
						}
					}else {
						infoBox("Please enter a correct email or password.","Incorrect email or password", "Incorrect information");
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
	
	//Methode ajoute
	
	/**
	 * Open an info box.
	 * @param message
	 * @param head
	 * @param title
	 */
	public static void infoBox(String message, String head, String title){
        //A CUSTOMISER
		Alert alert = new Alert(AlertType.INFORMATION);
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
