package businesslogic.domain;


/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class BugReport extends Report {

	/**
	 * Constructor of BugReport
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
     * Attribute which contains the subject
     */
    private String subject;

    /**
     * Attribute which contains the attachment link
     */
    private String attachment;

    /**
     * getter of the subject
     * @return the subject
     */
    public String getSubject() {
        return this.subject;
    }

    /**
     * Getter of attachment link
     * @return the attachment 
     */
    public String getAttachment() {
        return this.attachment;
    }
    
    /**
     * @return a string which contains the bugReport informations
     */
    public String toString() {
    	if(attachment != null) {
    		return getReportId() + " : " + getSubject() + " (with attached file)";
    	}
		return getReportId() + " : " + getSubject() + " (without attached file)";
	}

}