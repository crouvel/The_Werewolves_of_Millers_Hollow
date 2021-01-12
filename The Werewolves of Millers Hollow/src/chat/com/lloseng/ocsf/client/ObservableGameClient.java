package chat.com.lloseng.ocsf.client;

import java.net.InetAddress;
import java.util.*;

/**
 * 
 */
@SuppressWarnings("deprecation")
public class ObservableGameClient extends Observable {

	public static final String CONNECTION_CLOSED = "#OC: Connection Closed";
	public static final String CONNECTION_ESTABLISHED = "#OC: Connection Established";
	
	private AdaptableClient service;
    /**
     * Default constructor
     */
    public ObservableGameClient(String host, int port) {
    	service = new AdaptableClient(host,port,this);
    }

    /**
     * 
     */
    public String CONNECTION_ESTABLISHED;


    /**
     * @return
     */
    public final void openConnection() throws IOException{
        service.openConnection();
    }
    
    /**
     * 
     * @throws IOException
     */
    final public void closeConnection() throws IOException {
		service.closeConnection();
	}

    /**
     * @param message 
     * @return
     */
    public final void sendToServer(Object message) throws IOException{
        service.sendToServer(message);
    }

    /**
     * @return
     */
    public final boolean isConnected() {
        return service.isConnected();
    }

    /**
     * @return
     */
    public final int getPort() {
        return service.getPort();
    }

    /**
     * @param port 
     * @return
     */
    public final void setPort(int port) {
       service.setPort(port);
    }

    /**
     * @return
     */
    public final String getHost() {
        return service.getHost();
    }

    /**
     * @param host 
     * @return
     */
    public final void setHost(String host) {
        service.setHost(host);
    }

    /**
     * @return
     */
    public final InetAddress getInetAddress() {
        return service.getInetAddress();
    }

    /**
     * @param message 
     * @return
     */
    protected void handleMessageFromServer(Object message) {
        setChanged();
        notifyObservers(message);
    }

    /**
     * @return
     */
    protected void connectionClosed(){
        setChanged();
        notifyObservers(CONNECTION_CLOSED);
    }

    /**
     * @return
     */
    protected void connectionEstablished() {
    	setChanged();
        notifyObservers(CONNECTION_ESTABLISHED);
    }

}