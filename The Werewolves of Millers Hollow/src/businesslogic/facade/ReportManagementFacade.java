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
     * @param reportId 
     * @return
     */
    public BugReport checkBugReport(int reportId) {
        return null;
    }

    /**
     * @param reportId 
     * @return
     */
    public PlayerReport checkPlayerReport(int reportId) {
        return null;
    }

    /**
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