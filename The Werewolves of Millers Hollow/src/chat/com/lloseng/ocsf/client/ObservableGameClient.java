package chat.com.lloseng.ocsf.client;

import java.net.InetAddress;
import java.util.*;

/**
 * 
 */
@SuppressWarnings("deprecation")
public class ObservableGameClient extends Observable {

    /**
     * Default constructor
     */
    public ObservableGameClient() {
    }

    /**
     * 
     */
    public String CONNECTION_ESTABLISHED;


    /**
     * @return
     */
    public final void openConnection() {
        // TODO implement here
    }

    /**
     * @param message 
     * @return
     */
    public final void sendToServer(Object message) {
        // TODO implement here
    }

    /**
     * @return
     */
    public final boolean isConnected() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public final int getPort() {
        // TODO implement here
        return 0;
    }

    /**
     * @param port 
     * @return
     */
    public final void setPort(int port) {
        // TODO implement here
    }

    /**
     * @return
     */
    public final String getHost() {
        // TODO implement here
        return "";
    }

    /**
     * @param host 
     * @return
     */
    public final void setHost(String host) {
        // TODO implement here
    }

    /**
     * @return
     */
    public final InetAddress getInetAddress() {
        // TODO implement here
        return null;
    }

    /**
     * @param message 
     * @return
     */
    protected void handleMessageFromServer(Object message) {
        // TODO implement here
    }

    /**
     * @return
     */
    protected void connectionClosed() {
        // TODO implement here
    }

    /**
     * @return
     */
    protected void connectionEstablished() {
        // TODO implement here
    }

}