package chat.com.lloseng.ocsf.server;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 */
public abstract class AbstractServer implements Runnable{

	/**
	 * Default constructor
	 */
	public AbstractServer(int port) {
		this.port = port;
		this.ClientTG = new ThreadGroup("Client threads") {
			public void uncaughtException(Thread thread, Throwable exception) {
				clientException((ConnectionToGameClient) thread,exception);
			}
		}
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


	private ServerSocket serverS = null;
	private Thread connectionListener = null;
	private ThreadGroup ClientTG;

	/**
	 * 
	 */
	public AbstractConnectionFactory connectionFactory = null;



	/**
	 * @return
	 */
	public final void listen() throws IOException{
		if(!isListening()) {
			if(serverS == null) {
				serverS = new ServerSocket(getPort(),backlog);
			}
			serverS.setSoTimeout(timeout);

			connectionListener = new Thread(this);
			connectionListener.start();
		}
	}

	/**
	 * @return
	 */
	public final void stopListening() {
		readyToStop = true;
	}

	/**
	 * @param msg 
	 * @return
	 */
	public void sendToAllClients(Object msg) {
		Thread[] clientThreads = getClientConnections();

		for(int i = 0; i<clientThreads.length;i++) {
			try
			{
				((ConnectionToGameClient)clientThreads[i]).sendToClient(msg);
			}
			catch (Exception ex) {}
		}
	}


	synchronized final public Thread[] getClientConnections() {
		Thread[] clientThreads = new Thread[ClientTG.activeCount()];
		ClientTG.enumerate(clientThreads);

		return clientThreads;
	}

	/**
	 * @return
	 */
	public final boolean isListening() {
		return connectionListener!=null && connectionListener.isAlive();
	}

	/**
	 * @return
	 */
	public final boolean isClosed() {
		return (serverS==null);
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
		this.backlog=backlog;
	}

	/**
	 * @param factory 
	 * @return
	 */
	public final void setConnectionFactory(AbstractConnectionFactory factory) {
		this.connectionFactory=factory;
	}

	/**
	 * @return
	 */
	public final void run() {
		readyToStop = false;
		serverStarted();

		try {
			while(!readyToStop) {
				try {
					Socket clientS = serverS.accept();

					synchronized(this) {
						if(!readyToStop) {
							if(connectionFactory==null) {
								new ConnectionToGameClient(this.ClientTG,clientS,this);
							}else {
								connectionFactory.createConnection(this.ClientTG,clientS,this);
							}
						}
					}
				}catch(InterruptedIOException exception) {}
			}
		}catch(IOException exception) {
			if(!readyToStop) {
				listeningException(exception);
			}
		}
		finally {
			readyToStop = true;
			connectionListener = null;
			
			serverStopped();
		}

	}

	/**
	 * @return
	 */
	protected void clientConnected(ConnectionToGameClient client) {}

	/**
	 * @return
	 */
	protected void clientDisconnected(ConnectionToGameClient client) {}

	/**
	 * @return
	 */
	protected void serverStarted() {}

	/**
	 * @return
	 */
	protected void serverStopped() {}

	/**
	 * @return
	 */
	protected void serverClosed() {}

	/**
	 * @param msg 
	 * @param client ConnectionToClient 
	 * @return
	 */
	public final void receiveMessageFromClient(Object msg,ConnectionToGameClient client) {
		this.handleMessageFromClient(msg, client);
	}

	/**
	 * @return
	 */
	public final void close() throws IOException{
		if(serverS == null) {
			return;
		}
		stopListening();
		
		try {
			serverS.close();
		}finally {
			synchronized(this) {
				Thread[] clientThreads = getClientConnections();
				for(int i=0;i<clientThreads.length;i++) {
					try {
						((ConnectionToGameClient) clientThreads[i]).close();
					}catch(Exception e) {}
				}
				serverS = null;
			}
			try {
				connectionListener.join();
			}catch(InterruptedException e) {}
			catch(NullPointerException e) {}
			
			serverClosed();
		}
	}

	/**
	 * @return
	 */
	public final int getNumberOfClients() {
		return ClientTG.activeCount();
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
	protected void listeningException(Throwable exception) {}

	/**
	 * @param msg 
	 * @param client 
	 * @return
	 */
	protected abstract void handleMessageFromClient(Object msg, ConnectionToGameClient client);

}