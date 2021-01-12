/**
 * package gui.controller
 */
package gui.controller;

/**
 * Imported libraries and classes
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
import javafx.scene.control.TextField;
import util.HashPassword;
import util.InfoBox;

/**
 * 
 * @author Aaron Lazaroo
 *
 */
public class AdministratorProfileController  implements Initializable{
	
	//FXML Attributes
	
	/**
	 * 
	 */
	@FXML
	private TextField adminEmail;
	
	/**
	 * 
	 */
	@FXML
	private TextField adminPassword;
	
	//FXML Methods
	
	/**
	 * return to the administrator menu
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnAdministratorMenu(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdministratorMenuView.fxml"));	
	}
	
	/**
	 * Save the modifications effected
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void saveModifications(ActionEvent event) throws IOException,Exception {
		String adEmail = adminEmail.getText();
		String adPassword = adminPassword.getText(); 		
		if(adEmail.isBlank()) {
			InfoBox.infoBoxW("A valid email must be provided","Missing email","Missing information");
		}else {
			if(adPassword.isBlank()) {
				InfoBox.infoBoxW("A valid password must be provided","Missing password","Missing information");
			}else {
				if(!adEmail.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
					InfoBox.infoBoxW("An email with valid syntax expected","Email syntax invalid","Invalid syntax");
				}else {
					if(!adPassword.matches("([a-z]|[A-Z]|[0-9])*")){
						InfoBox.infoBoxW("A password with valid syntax expected","Password syntax invalid","Invalid syntax");
					}
					else {
						boolean confirmation = InfoBox.infoBoxC("Are you sure you want to save the modifications?", "Update confirmation");
						if(confirmation) {
							UserFacade uf = new UserFacade();
							boolean isDone = uf.modifyAdministratorProfile(adEmail, HashPassword.hashPassword(adPassword));
							if(isDone) {
								Administrator admin =  uf.getAdminByLogin(adEmail, HashPassword.hashPassword(adPassword));
								if(admin==null) {
									InfoBox.infoBoxE("Connection failed","Connection failed","Connection Error");
								}else {
									admin.setPassword(adPassword);
									AdministratorMenuController.setCurrentAdmin(admin);
									TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdminProfileView.fxml"));
								}
							}else {
								InfoBox.infoBoxE("Connection failed, retry later","Connection failed","Connection Error");
							}
						}else {
							TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdminProfileView.fxml"));
						}
					}
				}
			}
		}
		
	}
	
	/**
	 * Delete the administrator account
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void deleteAdministratorAccount(ActionEvent event) throws IOException {
		boolean confirmation = InfoBox.infoBoxC("Are you sure you want to delete your account?", "Delete confirmation");
		if(confirmation) {
			UserFacade uf = new UserFacade();
			boolean isDone = uf.deleteAdministratorByEmail(AdministratorMenuController.getCurrentAdmin().getEmail());
			if(isDone) {
				AdministratorMenuController.setCurrentAdmin(null);
				LoginController.setCurrentUser(null);
				TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/StartMenuView.fxml"));
			}else {
				InfoBox.infoBoxE("Delete failed, retry later","Deletion failed","Delete Error");
			}
		}
	}
	
	/**
	 * Modify the email
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void modifyAdministratorEmail(ActionEvent event) throws SQLException,IOException{
		String adEmail = adminEmail.getText();
		if(adEmail.isBlank()) {
			InfoBox.infoBoxW("A valid email must be provided","Missing email","Missing information");
		}else {
			if(!adEmail.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
				InfoBox.infoBoxW("An email with valid syntax expected","Email syntax invalid","Invalid syntax");
			}else {
				boolean confirmation = InfoBox.infoBoxC("Are you sure you want to save the modifications?", "Update confirmation");
				if(confirmation) {
					UserFacade uf = new UserFacade();
					boolean isDone = uf.modifyAdministratorProfile(adEmail,AdministratorMenuController.getCurrentAdmin().getPassword());
					if(isDone) {
						Administrator admin =  uf.getAdminByLogin(adEmail, AdministratorMenuController.getCurrentAdmin().getPassword());
						if(admin==null) {
							InfoBox.infoBoxE("Connection failed","Connection failed","Connection Error");
						}else {
							AdministratorMenuController.setCurrentAdmin(admin);
							TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdminProfileView.fxml"));
						}
					}else {
						InfoBox.infoBoxE("Connection failed, retry later","Connection failed","Connection Error");
					}
				} else {
					TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdminProfileView.fxml"));
				}
			}
		}
	}
	
	/**
	 * Modify the password
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void modifyAdministratorPassword(ActionEvent event) throws IOException,Exception {
		String adPassword = adminPassword.getText();
		if(adPassword.isBlank()) {
			InfoBox.infoBoxW("A valid password must be provided","Missing password","Missing information");
		}else {
			if(!adPassword.matches("([a-z]|[A-Z]|[0-9])*")) {
				InfoBox.infoBoxW("A password with valid syntax expected","Password syntax invalid","Invalid syntax");
			}else {
				boolean confirmation = InfoBox.infoBoxC("Are you sure you want to save the modifications?", "Update confirmation");
				if(confirmation) {
					UserFacade uf = new UserFacade();
					boolean isDone = uf.modifyAdministratorProfile(AdministratorMenuController.getCurrentAdmin().getEmail(),HashPassword.hashPassword(adPassword));
					if(isDone) {
						Administrator admin =  uf.getAdminByLogin(AdministratorMenuController.getCurrentAdmin().getEmail(),HashPassword.hashPassword(adPassword));
						if(admin==null) {
							InfoBox.infoBoxE("Connection failed","Connection failed","Connection Error");
						}else {
							admin.setPassword(adPassword);
							AdministratorMenuController.setCurrentAdmin(admin);
							TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdminProfileView.fxml"));
						}
					}else {
						InfoBox.infoBoxE("Connection failed, retry later","Connection failed","Connection Error");
					}
				} else {
					TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/AdminProfileView.fxml"));
				}
			}
		}
	}
	
	//Added Methods
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		try {
			adminEmail.setText(AdministratorMenuController.getCurrentAdmin().getEmail());
			adminPassword.setText(AdministratorMenuController.getCurrentAdmin().getPassword());	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
