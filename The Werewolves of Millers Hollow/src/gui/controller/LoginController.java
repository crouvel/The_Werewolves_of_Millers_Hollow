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
import businesslogic.facade.UserFacade;
import businesslogic.systemelement.User;

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
		UserFacade userFacade = new UserFacade();
		User user;
		try {
			user = userFacade.login(mail,pwd);
		}catch(SQLException e) {
			infoBox("Please enter a correct email or password.","Incorrect email or password", "Incorrect or missing information");
            return;
		}
		if(user.isAdmin()==1) {
			TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdministratorMenuView.fxml"));
		}else {
			TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
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
