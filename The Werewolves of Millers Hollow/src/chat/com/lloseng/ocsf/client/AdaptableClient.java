package chat.com.lloseng.ocsf.client;

import java.io.*;
import java.net.*;
import java.util.*;



/**
 * 
 */
public class AdaptableClient extends AbstractClient {
	
	private ObservableClient client;

    /**
     * Default constructor
     */
	public AdaptableClient(String host, int port, ObservableClient client) {
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

    /**
     * @param exception 
     * @return
     */
    protected final void connectionException(Exception exception) {
    	client.connectionException(exception);
    }

}