package businesslogic.domain;


/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class BugReport extends Report {

    /**
     * Default constructor
     */
    public BugReport() {
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
        // TODO implement here
        return this.subject;
    }

    /**
     * @return
     */
    public String getAttachment() {
        // TODO implement here
        return this.attachment;
    }

}