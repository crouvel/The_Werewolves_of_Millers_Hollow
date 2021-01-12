/**
 * package gui.controller
 */
package gui.controller;

/**
 * @author Aaron Lazaroo
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.TheWerewolvesOfMillersHollow;
import businesslogic.domain.Player;
import businesslogic.domain.User;
import businesslogic.facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import util.HashPassword;
import util.InfoBox;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class PlayerProfileController  implements Initializable{

	//FXML Attributes

	/**
	 * 
	 */
	@FXML
	private TextField username;

	/**
	 * 
	 */
	@FXML
	private TextField playerEmail;

	/**
	 * 
	 */
	@FXML
	private TextField playerPassword;

	/**
	 * 
	 */
	@FXML
	private Text dateOfBirth;

	/**
	 * 
	 */
	@FXML
	private Text gender;

	/**
	 * 
	 */
	@FXML
	private ComboBox<String> country;

	//FXML Methods

	/**
	 * Allows the player to modify his username
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void modifyUsername(ActionEvent event) throws IOException {
		String user = username.getText();
		if(user.isBlank()) {
			InfoBox.infoBoxW("A valid username must be provided","Missing username","Missing information");
		}else {
			if(!user.matches("([a-z]|[A-Z]|[0-9])*")){
				InfoBox.infoBoxW("A username with valid syntax expected","Username syntax invalid","Invalid syntax");
			}
			else {
				boolean confirmation = InfoBox.infoBoxC("Are you sure you want to save the modifications?", "Update confirmation");
				if(confirmation) {
					UserFacade uf = new UserFacade();
					Player cur = PlayerMenuController.getCurrentPlayer();
					if(cur==null) {
						InfoBox.infoBoxE("Connection failed","Connection failed","Connection Error");
					}else {
						boolean isDone = uf.modifyPlayerProfile(user,cur.getEmail(), cur.getPassword(),cur.getCountry());
						if(isDone) {
							Player newP =  uf.searchPlayerStats(user);
							PlayerMenuController.setCurrentPlayer(newP);
							TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerProfileView.fxml"));
						}else {
							InfoBox.infoBoxE("Connection failed, retry later","Connection failed","Connection Error");
						}
					}
				} else {
					TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerProfileView.fxml"));
				}
			}
		}
	}

	/**
	 * Allows the player to modify his email
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void modifyPlayerEmail(ActionEvent event) throws IOException {
		String email = playerEmail.getText();
		if(email.isBlank()) {
			InfoBox.infoBoxW("A valid email must be provided","Missing email","Missing information");
		}else {
			if(!email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")){
				InfoBox.infoBoxW("An email with valid syntax expected","Email syntax invalid","Invalid syntax");
			}
			else {
				boolean confirmation = InfoBox.infoBoxC("Are you sure you want to save the modifications?", "Update confirmation");
				if(confirmation) {
					UserFacade uf = new UserFacade();
					Player cur = PlayerMenuController.getCurrentPlayer();
					if(cur==null) {
						InfoBox.infoBoxE("Connection failed","Connection failed","Connection Error");
					}else {
						boolean isDone = uf.modifyPlayerProfile(cur.getUsername(),email, cur.getPassword(),cur.getCountry());
						if(isDone) {
							Player newP =  uf.searchPlayerStats(cur.getUsername());
							PlayerMenuController.setCurrentPlayer(newP);
							TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerProfileView.fxml"));
						}else {
							InfoBox.infoBoxE("Connection failed, retry later","Connection failed","Connection Error");
						}
					}
				} else {
					TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerProfileView.fxml"));
				}
			}
		}
	}

	/**
	 * Allows the player to modify his password
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void modifyPlayerPassword(ActionEvent event) throws IOException,Exception {
		String password = playerPassword.getText();
		if(password.isBlank()) {
			InfoBox.infoBoxW("A valid password must be provided","Missing password","Missing information");
		}else {
			if(!password.matches("([a-z]|[A-Z]|[0-9])*")){
				InfoBox.infoBoxW("A password with valid syntax expected","Password syntax invalid","Invalid syntax");
			}
			else {
				boolean confirmation = InfoBox.infoBoxC("Are you sure you want to save the modifications?", "Update confirmation");
				if(confirmation) {
					UserFacade uf = new UserFacade();
					Player cur = PlayerMenuController.getCurrentPlayer();
					if(cur==null) {
						InfoBox.infoBoxE("Connection failed","Connection failed","Connection Error");
					}else {
						boolean isDone = uf.modifyPlayerProfile(cur.getUsername(),cur.getEmail(), HashPassword.hashPassword(password),cur.getCountry());
						if(isDone) {
							Player newP =  uf.searchPlayerStats(cur.getUsername());
							newP.setPassword(password);
							PlayerMenuController.setCurrentPlayer(newP);
							TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerProfileView.fxml"));
						}else {
							InfoBox.infoBoxE("Connection failed, retry later","Connection failed","Connection Error");
						}
					}
				} else {
					TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerProfileView.fxml"));
				}
			}
		}
	}

	/**
	 * Allows the player to modify his country
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void modifyCountry(ActionEvent event) throws IOException,Exception {
		boolean confirmation = InfoBox.infoBoxC("Are you sure you want to save the modifications?", "Update confirmation");
		if(confirmation) {
			String count = (String) country.getValue();
			UserFacade uf = new UserFacade();
			Player cur = PlayerMenuController.getCurrentPlayer();
			if(cur==null) {
				InfoBox.infoBoxE("Connection failed","Connection failed","Connection Error");
			}else {
				boolean isDone = uf.modifyPlayerProfile(cur.getUsername(),cur.getEmail(), cur.getPassword(),count);
				if(isDone) {
					Player newP =  uf.searchPlayerStats(cur.getUsername());
					PlayerMenuController.setCurrentPlayer(newP);
					TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerProfileView.fxml"));
				}else {
					InfoBox.infoBoxE("Connection failed, retry later","Connection failed","Connection Error");
				}
			}
		} else {
			TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerProfileView.fxml"));
		}
	}

	/**
	 * Allows the player to save all modifications
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void saveModifications(ActionEvent event) throws IOException,Exception {
		String user = username.getText();
		String email = playerEmail.getText();
		String password = playerPassword.getText();
		String count = (String) country.getValue();
		//Username
		if(user.isBlank()) {
			InfoBox.infoBoxW("A valid username must be provided","Missing username","Missing information");
		}else {
			//Email
			if(email.isBlank()) {
				InfoBox.infoBoxW("A valid email must be provided","Missing email","Missing information");
			}else {
				//Password
				if(password.isBlank()) {
					InfoBox.infoBoxW("A valid password must be provided","Missing password","Missing information");
				}else {
					if(!user.matches("([a-z]|[A-Z]|[0-9])*")){
						InfoBox.infoBoxW("A username with valid syntax expected","Username syntax invalid","Invalid syntax");
					}
					else {
						if(!email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")){
							InfoBox.infoBoxW("An email with valid syntax expected","Email syntax invalid","Invalid syntax");
						}
						else {
							if(!password.matches("([a-z]|[A-Z]|[0-9])*")){
								InfoBox.infoBoxW("A password with valid syntax expected","Password syntax invalid","Invalid syntax");
							}
							else {
								boolean confirmation = InfoBox.infoBoxC("Are you sure you want to save the modifications?", "Update confirmation");
								if(confirmation) {
								UserFacade uf = new UserFacade();
									boolean isDone = uf.modifyPlayerProfile(user,email, HashPassword.hashPassword(password),count);
									if(isDone) {
										User cur =  uf.login(email, HashPassword.hashPassword(password));
										if(cur==null) {
											InfoBox.infoBoxE("Connection failed","Connection failed","Connection Error");
										}else {
											PlayerMenuController.setCurrentPlayer(uf.getPlayer(cur));
											PlayerMenuController.getCurrentPlayer().setPassword(password);
											TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerProfileView.fxml"));
										}
									}else {
										InfoBox.infoBoxE("Connection failed, retry later","Connection failed","Connection Error");
									}
								} else {
									TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerProfileView.fxml"));
								}
							}
						}
					}
				}
			}
		}

	}

	/**
	 * Allows the player to delete his account
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void deletePlayerAccount(ActionEvent event) throws IOException {
		boolean confirmation = InfoBox.infoBoxC("Are you sure you want to delete your account?", "Delete confirmation");
		if(confirmation) {
			UserFacade uf = new UserFacade();
			boolean isDone = uf.deleteUserByEmail(PlayerMenuController.getCurrentPlayer().getEmail());
			if(isDone) {
				LoginController.setCurrentUser(null);
				PlayerMenuController.setCurrentPlayer(null);
				TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/StartMenuView.fxml"));
			}else {
				InfoBox.infoBoxE("Delete failed, retry later","Deletion failed","Delete Error");
			}
		} else {
			TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerProfileView.fxml"));
		}
	}

	/**
	 * Returns to the player Menu
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnPlayerMenu(ActionEvent event) throws IOException{
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
	}

	//Added Methods

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			username.setText(PlayerMenuController.getCurrentPlayer().getUsername());
			playerEmail.setText(PlayerMenuController.getCurrentPlayer().getEmail());
			playerPassword.setText(PlayerMenuController.getCurrentPlayer().getPassword());
			dateOfBirth.setText(PlayerMenuController.getCurrentPlayer().getDateOfBirth().toString());
			gender.setText(PlayerMenuController.getCurrentPlayer().getGender().getName());
			country.setValue(PlayerMenuController.getCurrentPlayer().getCountry());
			country.getItems().add("France");
			country.getItems().add("USA");
			country.getItems().add("England");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
