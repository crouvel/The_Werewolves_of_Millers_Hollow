package businesslogic.domain;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class Report {

    /**
     * 
     * @param reportId
     * @param description
     */
    public Report(int reportId,String description) {
    	this.reportId=reportId;
    	this.description=description;
    }

    /**
     * 
     */
    private int reportId;

    /**
     * 
     */
    private String description;



    /**
     * @return
     */
    public int getReportId() {
        return this.reportId;
    }

    /**
     * @return
     */
    public String getDescription() {
        return this.description;
    }

}