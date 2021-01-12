package chat.com.lloseng.ocsf.server;

/**
 * 
 */
public abstract class AbstractConnectionFactory {

    /**
     * Default constructor
     */
    public AbstractConnectionFactory() {
    }

    /**
     * 
     */
    public abstract ConnectionToGameClient createConnection(ThreadGroup group, Socket clientS, AbstractServer server) throws IOException;

}