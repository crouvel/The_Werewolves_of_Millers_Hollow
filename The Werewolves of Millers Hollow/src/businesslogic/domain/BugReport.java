package businesslogic.domain;


/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class BugReport extends Report {

	/**
	 * 
	 * @param reportId
	 * @param subject
	 * @param description
	 * @param attachment
	 */
    public BugReport(int reportId, String subject, String description, String attachment) {
    	super(reportId,description);
    	this.subject=subject;
    	this.attachment=attachment;
    }

    /**
     * 
     */
    private String subject;

    /**
     * 
     */
    private String attachment;

    /**
     * @return
     */
    public String getSubject() {
        return this.subject;
    }

    /**
     * @return
     */
    public String getAttachment() {
        return this.attachment;
    }
    
    public String toString() {
    	if(attachment != null) {
    		return getReportId() + " : " + getSubject() + " (with attached file)";
    	}
		return getReportId() + " : " + getSubject() + " (without attached file)";
	}

}