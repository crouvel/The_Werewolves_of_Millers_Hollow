package chat.com.lloseng.ocsf.server;

import java.util.*;

/**
 * 
 */
public class ObservableGameServer extends Observable {

    /**
     * Default constructor
     */
    public ObservableGameServer() {
    }


    /**
     * @return
     */
    public final void listen() {
        // TODO implement here
    }

    /**
     * @return
     */
    public final void stopListening() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void close() {
        // TODO implement here
    }

    /**
     * @param msg 
     * @return
     */
    public void sendToAllClients(Object msg) {
        // TODO implement here
    }

    /**
     * @return
     */
    public final boolean isListening() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public final int getNumberOfClients() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public final int getPort() {
        // TODO implement here
        return 0;
    }

    /**
     * @param int 
     * @return
     */
    public final void setPort(int port) {
        // TODO implement here
    }

    /**
     * @param timeout 
     * @return
     */
    public final void setTimeout(int timeout) {
        // TODO implement here
    }

    /**
     * @param backlog
     */
    public final void setBackLog(int backlog) {
        // TODO implement here
    }

    /**
     * @param client 
     * @return
     */
    protected void clientConnected(ConnectionToGameClient client) {
        // TODO implement here
    }

    /**
     * @param client 
     * @return
     */
    protected void clientDisconnected(ConnectionToGameClient client) {
        // TODO implement here
    }

    /**
     * @param client 
     * @param exception 
     * @return
     */
    protected void clientException(ConnectionToGameClient client, Throwable exception) {
        // TODO implement here
    }

    /**
     * @param exception 
     * @return
     */
    protected void listeningException(Throwable exception) {
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
    protected void serverClosed() {
        // TODO implement here
    }

    /**
     * @param message 
     * @param client 
     * @return
     */
    protected void handleMessageFromClient(Object message, ConnectionToGameClient client) {
        // TODO implement here
    }

}