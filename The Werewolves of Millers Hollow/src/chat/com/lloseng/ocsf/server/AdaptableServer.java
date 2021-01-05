package chat.com.lloseng.ocsf.server;

/**
 * 
 */
public class AdaptableServer extends AbstractServer {
	
	ObservableGameServer server;

    /**
     * Default constructor
     */
    public AdaptableServer(int port, ObservableServer server) {
    	super(port);
    	this.server=server;
    }


    /**
     * @return
     */
    protected final void clientConnected(ConnectionToClient client) {
    	server.clientConnected(client);
    }

    /**
     * @return
     */
    protected final void clientDisconnected(ConnectionToClient client) {
    	server.clientDisconnected(client);
    }

    /**
     * @return
     */
    protected final void serverStarted() {
    	server.serverStarted();
    }

    /**
     * @return
     */
    protected final void serverStopped() {
    	server.serverStopped();
    }

    /**
     * @return
     */
    protected final void serverClosed() {
    	server.serverClosed();
    }

    /**
     * @param msg 
     * @param client
     */
    protected final void handleMessageFromClient(Object msg, ConnectionToGameClient client) {
    	server.handleMessageFromClient(msg, client);
    }

    /**
     * @param client 
     * @param exception 
     * @return
     */
    protected final void clientException(ConnectionToGameClient client, Throwable exception) {
    	server.clientException(client, exception);
    }

    /**
     * @param exception 
     * @return
     */
    protected final void listeningException(Throwable exception) {
    	server.listeningException(exception);
    }

}