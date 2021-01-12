/**
 * package businesslogic.facade
 */
package businesslogic.facade;

/**
 * Imported classes and libraries.
 */
import java.sql.SQLException;
import java.util.*;
import model.dao.factory.AbstractFactoryDAO;
import model.dao.mysql.ReportDAO;
import businesslogic.domain.BugReport;
import businesslogic.domain.PlayerReport;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class ReportManagementFacade {

    /**
     * Allows the admin to check a bug report
     * @param reportId 
     * @return
     */
    public BugReport checkBugReport(int reportId) {
        return null;
    }

    /**
     * Allows the admin to check a player report
     * @param reportId 
     * @return
     */
    public PlayerReport checkPlayerReport(int reportId) {
        return null;
    }

    /**
     * Return the list of bug reports in the database
     * @return
     */
    public ArrayList<BugReport> showBugReports() {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		ReportDAO reportDAO  = factory.createReportDAO();
    		return reportDAO.getBugReports();
    	}catch(SQLException e) {
    		return null;
    	}   
    }

    /**
     * Return the list of player reports in the database
     * @return
     */
    public ArrayList<PlayerReport> showPlayerReports() {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		ReportDAO reportDAO  = factory.createReportDAO();
    		return reportDAO.getPlayerReports();
    	}catch(SQLException e) {
    		return null;
    	}  
    }

    /**
     * Allows the admin to delete a report
     * @param reportId 
     * @return
     */
    public boolean deleteReport(int reportId) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		ReportDAO reportDAO  = factory.createReportDAO();
    		return reportDAO.deleteReport(reportId);
    	}catch(SQLException e) {
    		e.getStackTrace();
    		return false;
    	} 
    }
    
    /**
     * Return true if the report exists, else false
     * @param reportId 
     * @return
     */
    public boolean existsReport(int reportId) {
    	AbstractFactoryDAO factory = AbstractFactoryDAO.getInstance();
    	try {
    		ReportDAO reportDAO  = factory.createReportDAO();
    		return reportDAO.existsReport(reportId);
    	}catch(SQLException e) {
    		e.getStackTrace();
    		return false;
    	} 
    }

}