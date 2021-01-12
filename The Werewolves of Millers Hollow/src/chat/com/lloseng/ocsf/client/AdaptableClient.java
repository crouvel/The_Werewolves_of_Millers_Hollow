package chat.com.lloseng.ocsf.client;


/**
 * 
 */
public class AdaptableClient extends AbstractClient {
	
	private ObservableGameClient client;

    /**
     * Default constructor
     */
	public AdaptableClient(String host, int port, ObservableGameClient client) {
		super(host, port);
		this.client = client;
	}



    /**
     * @return
     */
    protected final void connectionEstablished() {
    	client.connectionEstablished();
    }

    /**
     * @return
     */
    protected final void connectionClosed() {
    	client.connectionClosed();
    }

    /**
     * @param msg 
     * @return
     */
    protected final void handleMessageFromServer(Object msg) {
    	client.handleMessageFromServer(msg);
    }

}