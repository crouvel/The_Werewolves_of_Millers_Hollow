package chat.com.lloseng.ocsf.client;
import java.net.InetAddress;
import java.util.*;

/**
 * 
 */
public abstract class AbstractClient {

    /**
     * Default constructor
     */
    public AbstractClient() {
    }

    /**
     * 
     */
    private String host;

    /**
     * 
     */
    private int port;


    /**
     * 
     */
    public final void run() {
        // TODO implement here
    }

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
    public void sendToServer(Object message) {
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
     * @param int port 
     * @return
     */
    public final void setPort(int port) {
        // TODO implement here
    }

    /**
     * @return
     */
    public final int getPort() {
        // TODO implement here
        return 0;
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
     * @return
     */
    protected void connnectionClosed() {
        // TODO implement here
    }

    /**
     * @param exception 
     * @return
     */
    protected void connectionException(Exception exception) {
        // TODO implement here
    }

    /**
     * @return
     */
    protected void connectionEstablished() {
        // TODO implement here
    }

    /**
     * @return
     */
    private final void closeAll() {
        // TODO implement here
    }

    /**
     * @param msg
     */
    protected abstract void handleMessageFromServer(Object msg);

}