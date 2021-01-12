package chat.client;

import java.io.IOException;
import businesslogic.domain.PlayerInGame;
import java.util.Observable;
import java.util.Observer;
import gui.controller.GameController;

import chat.com.lloseng.ocsf.client.ObservableSWRClient;

/**
 * 
 */
@SuppressWarnings("deprecation")
public class ChatGameClient implements Observer {
	
	String idC;
	ObservableSWRClient swrC;
	GameController clientUI;

    /**
     * Default constructor
     */
    public ChatGameClient(String host, int port, String id) throws IOException{
    	this.swrC = new ObservableSWRClient(host,port);
    	this.swrC.addObserver(this);
    	this.clientUI = new GameController();
    	
    	
    	this.idC = id;
    	

    	this.swrC.openConnection();
		
    }


    /**
     * 
     */
    private PlayerInGame currentPlayerInGame;


    /**
     * @param a0 
     * @param a1
     */
    public void update(Observable a0, Object a1) {
    	String msg = (String) a1;

		if (msg.startsWith(ObservableSWRClient.WAITING_FOR_REPLY)) {

		} else if (msg.startsWith(ObservableSWRClient.CONNECTION_CLOSED)) {
			this.connectionClosed();
		} else if (msg.startsWith(ObservableSWRClient.CONNECTION_ESTABLISHED)) {
			this.connectionEstablished();
		} else {
			this.handleMessageFromServer(a1);
		}
    }

    /**
     * @param msg 
     * @return
     */
    public void handleMessageFromServer(Object msg) {
    	clientUI.display(msg.toString());
    }

    /**
     * @param msg 
     * @return
     */
    public void handleMessageFromClientUI(String msg) {
    	try {
			this.swrC.sendToServer(msg);
		} catch (IOException e) {
			clientUI.display("Could not send message to server.  Terminating client.");
			quit();
		}
    }

    /**
     * @return
     */
    public void quit() {
    	try {
			this.swrC.closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
    }

    /**
     * @return
     */
    protected void connectionClosed() {
    	this.clientUI.display("This connection is closed");
    }

    /**
     * @return
     */
    protected void connectionEstablished() {
    	this.clientUI.display("The connection has been established");
    }

    /**
     * @param exception 
     * @return
     */
    public void connectionException(Exception exception) {
    	this.clientUI.display("An exception has occured during connection: " + exception.getMessage());
    }

	/**
	 * @return the currentPlayerInGame
	 */
	public PlayerInGame getCurrentPlayerInGame() {
		return currentPlayerInGame;
	}

	/**
	 * @param currentPlayerInGame the currentPlayerInGame to set
	 */
	public void setCurrentPlayerInGame(PlayerInGame currentPlayerInGame) {
		this.currentPlayerInGame = currentPlayerInGame;
	}

}