package businesslogic.facade;

import java.sql.SQLException;

import businesslogic.domain.Report;
import model.dao.factory.AbstractFactoryDAO;
import model.dao.mysql.ReportDAO;

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
    	AbstractFactoryDAO factoryTest = AbstractFactoryDAO.getInstance();
    	try {
    		ReportDAO reportDAO  = factoryTest.createReportDAO();
    		return reportDAO.createBugReport(subject,description,attachment);
    	}catch(SQLException e) {
    		return false;
    	}
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