package chat.com.lloseng.ocsf.server;

/**
 * 
 */
public abstract class AbstractServer {

    /**
     * Default constructor
     */
    public AbstractServer() {
    }

    /**
     * 
     */
    private int port;

    /**
     * 
     */
    private int timeout = 500;

    /**
     * 
     */
    private int backlog = 10;

    /**
     * 
     */
    public boolean readyToStop = true;

    /**
     * 
     */
    public AbstractConnectionFactory connectionFactory = null;



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
    public final boolean isClosed() {
        // TODO implement here
        return false;
    }

    /**
     * @param port 
     * @return
     */
    public final void setPort(int port) {
    	this.port = port;
    }

    /**
     * @param timeout 
     * @return
     */
    public final void setTimeout(int timeout) {
    	this.timeout = timeout;
    }

    /**
     * @param backlog 
     * @return
     */
    public final void setBackLog(int backlog) {
        // TODO implement here
    }

    /**
     * @param factory 
     * @return
     */
    public final void setConnectionFactory(AbstractConnectionFactory factory) {
        // TODO implement here
    }

    /**
     * @return
     */
    public final void run() {
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
    protected void clientDisconnected() {
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
     * @param msg 
     * @param client ConnectionToClient 
     * @return
     */
    public final void receiveMessageFromClient(Object msg,ConnectionToGameClient client) {
        // TODO implement here
    }

    /**
     * @return
     */
    public final void close() {
        // TODO implement here
    }

    /**
     * @return
     */
    public final int getNumberOfClients() {
        return 0;
    }

    /**
     * @return
     */
    public final int getPort() {
        return this.port;
    }

    /**
     * @param exception 
     * @return
     */
    protected void listeningException(Throwable exception) {
        // TODO implement here
    }

    /**
     * @param msg 
     * @param client 
     * @return
     */
    protected abstract void handleMessageFromClient(Object msg, ConnectionToGameClient client);

}