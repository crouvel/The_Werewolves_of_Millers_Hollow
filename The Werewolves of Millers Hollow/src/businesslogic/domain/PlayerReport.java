package businesslogic.domain;


/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class PlayerReport extends Report {

    /**
     * Default constructor
     */
    public PlayerReport() {
    }

    /**
     * 
     */
    private String usernameOfBadPlayer;

    /**
     * 
     */
    private PlayerReportType reportType;

    /**
     * @return
     */
    public String getUsernameOfBadPlayer() {
        return this.usernameOfBadPlayer;
    }

	/**
	 * @param usernameOfBadPlayer the usernameOfBadPlayer to set
	 */
	public void setUsernameOfBadPlayer(String usernameOfBadPlayer) {
		this.usernameOfBadPlayer = usernameOfBadPlayer;
	}

	/**
	 * @return the reportType
	 */
	public PlayerReportType getReportType() {
		return reportType;
	}

	/**
	 * @param reportType the reportType to set
	 */
	public void setReportType(PlayerReportType reportType) {
		this.reportType = reportType;
	}

}