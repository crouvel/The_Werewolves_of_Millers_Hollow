/**
 * @package gui.controller
 */
package gui.controller;

/**
 * Imported libraries and classes.
 */
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.TheWerewolvesOfMillersHollow;
import businesslogic.facade.FriendManagementFacade;
import util.InfoBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class FriendManagementController implements Initializable {
	
	//FXML Attributes
	
	/**
	 * Attribute uses for add a friend.
	 */
	@FXML
	private TextField addFriendUsername;
	
	/**
	 * Attribute containing the player's friends list.
	 */
	@FXML
	private ListView<String> friendsList;
	
	/**
	 * Attribute containing the player's sent friend requests.
	 */
	@FXML
	private ListView<String> sent;
	
	/**
	 * Attribute containing the player's received friend requests.
	 */
	@FXML
	private ListView<String> receive;
	
	//Other Attributes
	
	
	//FXML Methods
	
	/**
	 * Allows the player to accept the selected friend request in the receive ListView.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void accept(ActionEvent event) throws IOException {
		String username = receive.getSelectionModel().getSelectedItem();
		if(username==null) {
			InfoBox.infoBoxW("Please select a friend request before accept.","Missing friend.","Missing informations");
		}else {
			FriendManagementFacade friendManagementFacade = new FriendManagementFacade();
			boolean isDone = friendManagementFacade.acceptFriendRequest(PlayerMenuController.getCurrentPlayer().getUsername(),username);
			if(isDone) {		
				TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/FriendManagementView.fxml"));
			}else {
				InfoBox.infoBoxW("Retry to accept the friend request later.","Incorrect information.", "Connection problem");
			}
		}
	}
	
	/**
	 * Allows the player to refuse the selected friend request in the receive ListView.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void refuse(ActionEvent event) throws IOException{
		String username = receive.getSelectionModel().getSelectedItem();
		if(username==null) {
			InfoBox.infoBoxW("Please select a friend request before refuse.","Missing friend.","Missing informations");
		}else {
			FriendManagementFacade friendManagementFacade = new FriendManagementFacade();
			boolean isDone = friendManagementFacade.refuseFriendRequest(PlayerMenuController.getCurrentPlayer().getUsername(),username);
			if(isDone) {		
				TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/FriendManagementView.fxml"));
			}else {
				InfoBox.infoBoxW("Retry to refuse the friend request later.","Incorrect information.", "Connection problem");
			}
		}
	}
	
	/**
	 * Allows the player to cancel the selected friend request in the sent ListView.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void cancel(ActionEvent event) throws IOException {
		String username = sent.getSelectionModel().getSelectedItem();
		if(username==null) {
			InfoBox.infoBoxW("Please select a friend request before cancel.","Missing friend.","Missing informations");
		}else {
			FriendManagementFacade friendManagementFacade = new FriendManagementFacade();
			boolean isDone = friendManagementFacade.cancelFriendRequest(PlayerMenuController.getCurrentPlayer().getUsername(),username);
			if(isDone) {		
				TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/FriendManagementView.fxml"));
			}else {
				InfoBox.infoBoxW("Retry to cancel your friend request later.","Incorrect information.", "Connection problem");
			}
		}
	}
	
	/**
	 * Allows the player to delete the selected friend in his friends list.
	 * @param event
	 * @throws IOException
	 * @throws SQLException 
	 */
	@FXML
	void deleteFriend(ActionEvent event) throws IOException {
		String username = friendsList.getSelectionModel().getSelectedItem();
		if(username==null) {
			InfoBox.infoBoxW("Please select a friend before try to delete.","Missing friend.","Missing informations");
		}else {
			FriendManagementFacade friendManagementFacade = new FriendManagementFacade();
			boolean isDone = friendManagementFacade.deleteFriend(PlayerMenuController.getCurrentPlayer().getUsername(),username);
			if(isDone) {		
				TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/FriendManagementView.fxml"));
			}else {
				InfoBox.infoBoxW("Retry to delete your friend later.","Incorrect information.", "Connection problem");
			}
		}		
	}
	
	/**
	 * Allows the player to send a request to a player.
	 * @param event
	 * @throws IOException
	 * @throws SQLException 
	 */
	@FXML
	void sendCurrentRequest(ActionEvent event) throws IOException {
		String newFriend = addFriendUsername.getText();
		if(newFriend.isBlank()) {
			InfoBox.infoBoxW("Please write a username if you want to add a friend.","Missing username","Missing informations");
		}else {
			if(friendsList.getItems().contains(newFriend)) {
				InfoBox.infoBoxW("This player is already in your friend list.","Incorrect username", "Incorrect information");
			}else {
				FriendManagementFacade friendManagementFacade = new FriendManagementFacade();
				boolean isDone=friendManagementFacade.sendRequest(PlayerMenuController.getCurrentPlayer().getUsername(),newFriend);
				if (isDone) {
					TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/FriendManagementView.fxml"));
				}else {
					InfoBox.infoBoxW("Please write a correct username or retry later.","Incorrect username", "Incorrect information");
				}
			}
		}
	}
	
	/**
	 * Allows the player to cancel his choice and erase the addFriendUsername TextField.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void cancelCurrentRequest(ActionEvent event) throws IOException {
		addFriendUsername.setText("");
	}
	
	/**
	 * Returns the player to the player menu.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnPlayerMenu(ActionEvent event) throws IOException {
		TheWerewolvesOfMillersHollow.setScene(getClass().getResource("../view/PlayerMenuView.fxml"));
	}
	
	//Added Methods 

	/**
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		FriendManagementFacade friendManagementFacade = new FriendManagementFacade();
		ArrayList<String> sentRequests;
		ArrayList<String> receivedRequests;
		ArrayList<String> friendList;
		try {
			sentRequests = friendManagementFacade.getSentFriendRequests(PlayerMenuController.getCurrentPlayer().getUsername());
			for(String i : sentRequests) {
				sent.getItems().add(i);
			}
			receivedRequests = friendManagementFacade.getReceivedFriendRequests(PlayerMenuController.getCurrentPlayer().getUsername());
			for(String i : receivedRequests) {
				receive.getItems().add(i);
			}
			friendList = friendManagementFacade.getFriendList(PlayerMenuController.getCurrentPlayer().getUsername());
			for(String i : friendList) {
				friendsList.getItems().add(i);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
