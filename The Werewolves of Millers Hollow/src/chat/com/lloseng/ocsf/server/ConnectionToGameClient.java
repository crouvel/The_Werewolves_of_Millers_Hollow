package chat.com.lloseng.ocsf.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;

/**
 * 
 */
public class ConnectionToGameClient extends Thread{
	
	private AbstractServer server;
	private Socket clientS;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	private boolean stop;
	private HashMap info = new HashMap(10);

    /**
     * Default constructor
     */
    public ConnectionToGameClient(ThreadGroup group, Socket clientS,AbstractServer server) throws IOException {
    	super(group,(Runnable)null);
        this.clientS = clientS;
        this.server = server;

        clientS.setSoTimeout(0); 

        //Initialize the objects streams
        try
        {
          in = new ObjectInputStream(clientS.getInputStream());
          out = new ObjectOutputStream(clientS.getOutputStream());
        }
        catch (IOException ex)
        {
          try
          {
            closeAll();
          }
          catch (Exception exc) { }

          throw ex;  // Rethrow the exception.
        }

        stop = false;
        start();
    }


    /**
     * @param message 
     * @return
     * @throws IOException 
     */
    public void sendToClient(Object message) throws IOException {
    	if (clientS == null || out == null)
    	      throw new SocketException("socket does not exist");
    	    out.writeObject(message);
    }

    /**
     * @return
     */
    public final void close() throws IOException{
    	stop = true;
        closeAll();
    }

    /**
     * @return
     */
    public final void run() {
        // TODO implement here
    }

    /**
     * @param message 
     * @return
     */
    protected boolean handleMessageFromClient(Object message) {
    	return true;
    }

    /**
     * @return
     * @throws IOException 
     */
    private final void closeAll() throws IOException {
    	try{
          if (clientS!= null) {
        	  clientS.close();
          }

          // Close the output stream
          if (out != null) {
        	  out.close();
          }

          // Close the input stream
          if (in != null) {
        	  in.close();
          }
        }
        finally
        {
          // Set the streams and the sockets to NULL no matter what
          // Doing so allows, but does not require, any finalizers
          // of these objects to reclaim system resources if and
          // when they are garbage collected.
          out = null;
          in = null;
          clientS = null;
        }
    }

    /**
     * @return
     */
    protected void finalize() {
    	try{
          closeAll();
        }
        catch(IOException e) {}
    }

    /**
     * @return
     */
    public final InetAddress getInetAddress() {
    	return clientS == null ? null : clientS.getInetAddress();
    }

    /**
     * @return
     */
    public String toString() {
    	return clientS == null ? null : clientS.getInetAddress().getHostName() +" (" + clientS.getInetAddress().getHostAddress() + ")";
    }

    /**
     * @param infotype 
     * @param info 
     * @return
     */
    public void setInfo(String infotype, Object info) {
    	info.put(infotype, info);
    }

    /**
     * @param infoType 
     * @return
     */
    public Object getInfo(String infoType) {
    	return info.get(infoType);
    }

}