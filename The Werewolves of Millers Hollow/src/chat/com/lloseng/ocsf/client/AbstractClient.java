package chat.com.lloseng.ocsf.client;

import java.io.*;
import java.net.*;

/**
 * 
 */
public abstract class AbstractClient {

	private Socket clientS;

	private ObjectOutputStream out;

	private ObjectInputStream in;

	private Thread clientT;

	private boolean stop= false;

	/**
	 * Default constructor
	 */
	public AbstractClient(String host, int port)
	{
		this.host = host;
		this.port = port;
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
		connectionEstablished();

	    // message from  server
	    Object msg;


	    try
	    {
	      while(!stop)
	      {
	   
	        try { 
	        
	          msg = in.readObject();

	          if (!stop) {  // Added in version 2.2
	            handleMessageFromServer(msg);
	          }
	          
	        } catch(ClassNotFoundException e) { 
	        
	          connectionException(e);
	          
	        } catch (RuntimeException e) { 
	        
	          connectionException(e);
	        }
	      } 
	    }
	    catch (Exception exception)
	    {
	      if(!stop)
	      {
	        try
	        {
	          closeAll();
	        }
	        catch (Exception e) { }

	        clientT= null; 
	        connectionException(exception);      
	      }
	    } finally {
	    
	        clientT = null; 
	        connnectionClosed();   
	    }
	}

	/**
	 * @return
	 * @throws IOException 
	 */
	public final void openConnection() throws IOException {
		// Do not do anything if the connection is already open
		if(isConnected())
			return;

		//Create the sockets and the data streams
		try
		{
			clientS= new Socket(host, port);
			out = new ObjectOutputStream(clientS.getOutputStream());
			in = new ObjectInputStream(clientS.getInputStream());
		}
		catch (IOException e)
		{
			try
			{
				closeAll();
			}
			catch (Exception exc) { }

			throw e; 
		}

		clientT = new Thread(clientT);  
		stop = false;
		clientT.start(); 
	}

	/**
	 * @param message 
	 * @return
	 * @throws IOException 
	 */
	public void sendToServer(Object message) throws IOException {
		if (clientS == null || out == null) {
			throw new SocketException("this socket does not exist");
		}
		out.writeObject(message);
	}

	/**
	 * @return
	 */
	public final boolean isConnected() {
		return clientT!=null && clientT.isAlive();
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
		return clientS.getInetAddress();
	}

	/**
	 * @return
	 */
	protected void connnectionClosed() {}

	/**
	 * @param exception 
	 * @return
	 */
	protected void connectionException(Exception exception) {}

	/**
	 * @return
	 */
	protected void connectionEstablished() {}

	/**
	 * @return
	 * @throws IOException 
	 */
	private final void closeAll() throws IOException {

		try
		{
			if (clientS != null)
				clientS.close();

			if (out != null)
				out.close();

			if (in != null)
				in.close();
		}
		finally
		{
			out = null;
			in = null;
			clientS = null;
		}
	}

	/**
	 * @param msg
	 */
	protected abstract void handleMessageFromServer(Object msg);

}