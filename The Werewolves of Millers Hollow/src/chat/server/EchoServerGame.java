package chat.server;

import java.util.*;

import chat.com.lloseng.ocsf.server.ObserverOriginatorServer;

import businesslogic.domain.User;
import chat.com.lloseng.ocsf.server.ConnectionToGameClient;
import gui.controller.GameController;

/**
 * 
 */
@SuppressWarnings("deprecation")
public class EchoServerGame implements Observer {

	final public static int DEFAULT_PORT = 5555;

	GameController serverUI;

	ObserverOriginatorServer originServer;

	/**
	 * Default constructor
	 */
	public EchoServerGame(int port, GameController serverUI) {
		this.originServer = new ObserverOriginatorServer(port);
		this.originServer.addObserver(this);
		this.serverUI = serverUI;
	}

	/**
	 * 
	 */
	public User user_id;


	/**
	 * @param msg 
	 * @param client 
	 * @return
	 */
	public void handleMessageFromClient(Object msg, ConnectionToGameClient client) {
		String message = msg.toString();
		serverUI.display("Message received: " + msg + " from " + client);

		this.originServer.sendToAllClients("> " + client.getInfo("id").toString() + " :" + msg);
	}

	/**
	 * @return
	 */
	protected void serverStarted() {
		serverUI.display("Server listening for connections on port " + this.originServer.getPort());
	}

	/**
	 * @return
	 */
	protected void serverStopped() {
		serverUI.display("Server has stopped listening for connections.");
	}

	/**
	 * @return
	 */
	protected void clientConnected(ConnectionToClient client) {
		serverUI.display("A client connected : " + client.toString());
	}

	/**
	 * @return
	 */
	public void update(Observable o, Object arg) {

		OriginatorMessage m=(OriginatorMessage) arg1;

		String msg = (String) m.getMessage();
		ConnectionToClient client = m.getOriginator();

		if (msg.startsWith(ObservableServer.CLIENT_CONNECTED)) {
			this.clientConnected(client);
		} else if (msg.startsWith(ObservableServer.CLIENT_DISCONNECTED)) {
			this.clientDisconnected(client);
		} else if (msg.startsWith(ObservableServer.CLIENT_EXCEPTION)) {
			this.clientException(client, msg);
		} else if (msg.startsWith(ObservableServer.LISTENING_EXCEPTION)) {
			this.listeningException(msg);
		} else if (msg.startsWith(ObservableServer.SERVER_CLOSED)) {
			this.serverClosed();
		} else if (msg.startsWith(ObservableServer.SERVER_STARTED)) {
			this.serverStarted();
		} else  if (msg.startsWith(ObservableServer.SERVER_STOPPED)) {
			this.serverStopped();
		} else {
			this.handleMessageFromClient(msg, client);
		}
	}

	/**
	 * @return
	 */
	public void listen() throws IOException {
		this.originServer.listen();
	}

	/**
	 * @return
	 */
	protected void serverClosed() {
		serverUI.display("Server has closed.");
	}

	/**
	 * @return
	 */
	protected void clientDisconnected(ConnectionToClient client) {
		serverUI.display("A client disconnected : " + client.toString());

		this.originServer.sendToAllClients("Server MSG> " + client.getInfo("id").toString() + " left");
	}

	/**
	 * @param client 
	 * @param exception 
	 * @return
	 */
	protected final void clientException(ConnectionToGameClient client, String exception) {
		serverUI.display("A client : " + client.toString() + " has encountered an exception : " + exception);
	}

	/**
	 * @param exception 
	 * @return
	 */
	protected void listeningException(String exception) {}


}