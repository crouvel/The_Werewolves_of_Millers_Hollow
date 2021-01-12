package chat.com.lloseng.ocsf.server;

import java.io.IOException;
import java.util.*;

/**
 * 
 */
@SuppressWarnings("deprecation")
public class ObservableGameServer extends Observable {

	public static final String CLIENT_CONNECTED= "#OS:Client has connected.";

	public static final String CLIENT_DISCONNECTED= "#OS:Client has disconnected.";

	public static final String CLIENT_EXCEPTION= "#OS:Client has an exception.";

	public static final String LISTENING_EXCEPTION= "#OS:Listening exception.";

	public static final String SERVER_CLOSED= "#OS:Server has closed.";

	public static final String SERVER_STARTED= "#OS:Server has started.";

	public static final String SERVER_STOPPED= "#OS:Server has stopped.";

	private AdaptableServer service;

	/**
	 * Default constructor
	 */
	public ObservableGameServer(int port) {
		service = new AdaptableServer(port, this);
	}


	/**
	 * @return
	 */
	public final void listen() throws IOException{
		service.listen();
	}

	/**
	 * @return
	 */
	public final void stopListening() {
		service.stopListening();
	}

	/**
	 * @return
	 * @throws IOException 
	 */
	public void close() throws IOException {
		service.close();
	}

	/**
	 * @param msg 
	 * @return
	 */
	public void sendToAllClients(Object msg) {
		service.sendToAllClients(msg);
	}

	/**
	 * @return
	 */
	public final boolean isListening() {
		return service.isListening();
	}

	final public Thread[] getClientConnections()
	{
		return service.getClientConnections();
	}

	/**
	 * @return
	 */
	public final int getNumberOfClients() {
		return service.getNumberOfClients();
	}

	/**
	 * @return
	 */
	public final int getPort() {
		return service.getPort();
	}

	/**
	 * @param int 
	 * @return
	 */
	public final void setPort(int port) {
		service.setPort(port);
	}

	/**
	 * @param timeout 
	 * @return
	 */
	public final void setTimeout(int timeout) {
		service.setTimeout(timeout);
	}

	/**
	 * @param backlog
	 */
	public final void setBackLog(int backlog) {
		service.setBackLog(backlog);
	}

	/**
	 * @param client 
	 * @return
	 */
	protected void clientConnected(ConnectionToGameClient client) {
		setChanged();
		notifyObservers(CLIENT_CONNECTED);
	}

	/**
	 * @param client 
	 * @return
	 */
	protected void clientDisconnected(ConnectionToGameClient client) {
		setChanged();
		notifyObservers(CLIENT_DISCONNECTED);
	}

	/**
	 * @param client 
	 * @param exception 
	 * @return
	 */
	protected void clientException(ConnectionToGameClient client, Throwable exception) {
		setChanged();
		notifyObservers(CLIENT_EXCEPTION);
		try
		{
			client.close();
		}
		catch (Exception e) {}
	}

	/**
	 * @param exception 
	 * @return
	 */
	protected void listeningException(Throwable exception) {
		setChanged();
		notifyObservers(LISTENING_EXCEPTION);
		stopListening();
	}

	/**
	 * @return
	 */
	protected void serverStarted() {
		setChanged();
		notifyObservers(SERVER_STOPPED);
	}

	/**
	 * @return
	 */
	protected void serverStopped() {
		setChanged();
		notifyObservers(SERVER_CLOSED);
	}

	/**
	 * @return
	 */
	protected void serverClosed() {
		setChanged();
		notifyObservers(SERVER_STARTED);
	}

	/**
	 * @param message 
	 * @param client 
	 * @return
	 */
	protected void handleMessageFromClient(Object message, ConnectionToGameClient client) {
		setChanged();
		notifyObservers(message);
	}

}