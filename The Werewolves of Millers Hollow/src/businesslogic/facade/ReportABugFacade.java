package businesslogic.facade;

import businesslogic.domain.Report;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class ReportABugFacade {

    /**
     * Default constructor
     */
    public ReportABugFacade() {
    }


    /**
     * 
     */
    private Report report;



    /**
     * @param subject 
     * @param description 
     * @param attachment 
     * @return
     */
    public boolean createBugReport(String subject, String description, String attachment) {
        // TODO implement here
        return false;
    }



	/**
	 * @return the report
	 */
	public Report getReport() {
		return report;
	}



	/**
	 * @param report the report to set
	 */
	public void setReport(Report report) {
		this.report = report;
	}

}