package businesslogic.facade;

import java.util.*;
import businesslogic.domain.Game;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class SelectAndJoinAGameFacade {

    /**
     * Default constructor
     */
    public SelectAndJoinAGameFacade() {
    }


    /**
     * 
     */
    private ArrayList<Game> availableGames;


    /**
     * @param game_id 
     * @return
     */
    public boolean joinAGame(int game_id) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public ArrayList<Game> getGamesList() {
        return this.availableGames;
    }

}