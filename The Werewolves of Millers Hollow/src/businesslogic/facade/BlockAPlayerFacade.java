package businesslogic.facade;

import businesslogic.domain.Administrator;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class BlockAPlayerFacade {

    /**
     * Default constructor
     */
    public BlockAPlayerFacade() {
    }


    /**
     * 
     */
    private Administrator currentAdmin;




    /**
     * @param username 
     * @return
     */
    public boolean blockAPlayer(String username) {
        // TODO implement here
        return false;
    }




	/**
	 * @return the currentAdmin
	 */
	public Administrator getCurrentAdmin() {
		return currentAdmin;
	}




	/**
	 * @param currentAdmin the currentAdmin to set
	 */
	public void setCurrentAdmin(Administrator currentAdmin) {
		this.currentAdmin = currentAdmin;
	}

}