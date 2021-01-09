package businesslogic.domain;


/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class PlayerReport extends Report {

    /**
     * 
     * @param reportId
     * @param description
     * @param reportType
     */
	public PlayerReport(int reportId,String description,PlayerReportType reportType) {
    	super(reportId,description);
    	this.reportType = reportType;
    }

    /**
     * Attributes that defines the bad player username.
     */
    private String usernameOfBadPlayer;

    /**
     * Attributes that defines the report type of the player report.
     */
    private PlayerReportType reportType;

    /**
     * @return the badPlayerUsername
     */
    public String getUsernameOfBadPlayer() {
        return this.usernameOfBadPlayer;
    }

	/**
	 * @param usernameOfBadPlayer the usernameOfBadPlayer to set.
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
	
	public String getReportTypeString() {
		return reportType.getName();
	}

	/**
	 * @param reportType the reportType to set
	 */
	public void setReportType(PlayerReportType reportType) {
		this.reportType = reportType;
	}
	
	/**
	 * @return all the report information
	 */
	public String toString() {
		return getReportId()+" : "+getReportType().getName();
	}

}