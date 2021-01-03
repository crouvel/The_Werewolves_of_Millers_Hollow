package chat.server;

import java.util.*;
import businesslogic.domain.User;
import chat.com.lloseng.ocsf.server.ConnectionToGameClient;

/**
 * 
 */
@SuppressWarnings("deprecation")
public class EchoServerGame implements Observer {

    /**
     * Default constructor
     */
    public EchoServerGame() {
    }

    /**
     * 
     */
    public User user_id;

    /**
     * @param id 
     * @param ConnectionToClient 
     * @return
     */
    public void clientLogin(int id, ConnectionToGameClient client) {
        // TODO implement here
    }

    /**
     * @param msg 
     * @param client 
     * @return
     */
    public void handleMessageFromClient(Object msg, ConnectionToGameClient client) {
        // TODO implement here
    }

    /**
     * @return
     */
    protected void serverStarted() {
        // TODO implement here
    }

    /**
     * @return
     */
    protected void serverStopped() {
        // TODO implement here
    }

    /**
     * @return
     */
    protected void clientConnected() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void update() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void listen() {
        // TODO implement here
    }

    /**
     * @return
     */
    protected void serverClosed() {
        // TODO implement here
    }

    /**
     * @return
     */
    protected void clientDisconnected() {
        // TODO implement here
    }

    /**
     * @param client 
     * @param exception 
     * @return
     */
    protected final void clientException(ConnectionToGameClient client, String exception) {
        // TODO implement here
    }

    /**
     * @param exception 
     * @return
     */
    protected void listeningException(String exception) {
        // TODO implement here
    }

	/**
	 * 
	 */
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}