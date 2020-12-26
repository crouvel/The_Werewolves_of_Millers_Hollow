package chat.client;

import java.util.*;
import businesslogic.domain.PlayerInGame;

/**
 * 
 */
public class ChatGameClient implements Observer {

    /**
     * Default constructor
     */
    public ChatGameClient() {
    }


    /**
     * 
     */
    private PlayerInGame currentPlayerInGame;


    /**
     * @param a0 
     * @param a1
     */
    public void update(Observable a0, Object a1) {
        // TODO implement here
    }

    /**
     * @param msg 
     * @return
     */
    public void handleMessageFromServer(Object msg) {
        // TODO implement here
    }

    /**
     * @param msg 
     * @return
     */
    public void handleMessageFromClienUI(String msg) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void quit() {
        // TODO implement here
    }

    /**
     * @return
     */
    protected void connectionClosed() {
        // TODO implement here
    }

    /**
     * @return
     */
    protected void connectionEstablished() {
        // TODO implement here
    }

    /**
     * @param exception 
     * @return
     */
    public void connectionException(Exception exception) {
        // TODO implement here
    }

	/**
	 * @return the currentPlayerInGame
	 */
	public PlayerInGame getCurrentPlayerInGame() {
		return currentPlayerInGame;
	}

	/**
	 * @param currentPlayerInGame the currentPlayerInGame to set
	 */
	public void setCurrentPlayerInGame(PlayerInGame currentPlayerInGame) {
		this.currentPlayerInGame = currentPlayerInGame;
	}

}