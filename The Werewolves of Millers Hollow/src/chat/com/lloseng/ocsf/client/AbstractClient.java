package chat.com.lloseng.ocsf.client;

import java.net.InetAddress;

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
    	this.port = port;
    }

    /**
     * @return
     */
    public final int getPort() {
        return this.port;
    }

    /**
     * @return
     */
    public final String getHost() {
        return this.host;
    }

    /**
     * @param host 
     * @return
     */
    public final void setHost(String host) {
        this.host = host;
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