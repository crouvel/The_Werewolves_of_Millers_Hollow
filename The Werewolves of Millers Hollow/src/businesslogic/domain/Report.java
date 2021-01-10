package businesslogic.domain;

/**
 * Report enumeration.
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class Report {

    /**
     * Constructor
     * @param reportId
     * @param description
     */
	public Report(int reportId,String description) {
    	this.reportId=reportId;
    	this.description=description;
    }

    /**
     * Attribute that defines the id of the report.
     */
    private int reportId;

    /**
     * Attribute that defines the report description.
     */
    private String description;



    /**
     * @return the reportId
     */
    public int getReportId() {
        return this.reportId;
    }

    /**
     * @return the description od the report
     */
    public String getDescription() {
        return this.description;
    }

}