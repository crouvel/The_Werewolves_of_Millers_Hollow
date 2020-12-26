package chat.com.lloseng.ocsf.server;

/**
 * 
 */
public class AdaptableServer extends AbstractServer {

    /**
     * Default constructor
     */
    public AdaptableServer() {
    }


    /**
     * @return
     */
    protected final void clientConnected() {
        // TODO implement here
    }

    /**
     * @return
     */
    protected final void clientDisconnected() {
        // TODO implement here
    }

    /**
     * @return
     */
    protected final void serverStarted() {
        // TODO implement here
    }

    /**
     * @return
     */
    protected final void serverStopped() {
        // TODO implement here
    }

    /**
     * @return
     */
    protected final void serverClosed() {
        // TODO implement here
    }

    /**
     * @param msg 
     * @param client
     */
    protected final void handleMessageFromClient(Object msg, ConnectionToGameClient client) {
        // TODO implement here
    }

    /**
     * @param client 
     * @param exception 
     * @return
     */
    protected final void clientException(ConnectionToGameClient client, Throwable exception) {
        // TODO implement here
    }

    /**
     * @param exception 
     * @return
     */
    protected final void listeningException(Throwable exception) {
        // TODO implement here
    }

}