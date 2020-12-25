package model.dao.mysql;

import java.util.*;
import businesslogic.domain.Report;
import businesslogic.domain.PlayerReport;
import businesslogic.domain.BugReport;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class ReportDAOMySQL extends ReportDAO {

    /**
     * Default constructor
     */
    public ReportDAOMySQL() {
    }

    /**
     * @param subject 
     * @param description 
     * @param attachment 
     * @return
     */
    public boolean createBugReport(String subject, String description, String attachment) {
    	return true;
    }

    /**
     * @return
     */
    public ArrayList<BugReport> getBugReports(){
    	return new ArrayList<BugReport>();
    }

    /**
     * @return
     */
    public ArrayList<PlayerReport> getPlayerReports(){
    	return new ArrayList<PlayerReport>();
    }

    /**
     * @return
     */
    public ArrayList<Report> getReports(){
    	return new ArrayList<Report>();
    }
    
    
    /**
     * @param reportId 
     * @return
     */
    public BugReport getBugReportById(int reportId) {
    	return new BugReport();
    }

    /**
     * @param reportId 
     * @return
     */
    public PlayerReport getPlayerReportById(int reportId) {
    	return new PlayerReport();
    }

    /**
     * @param reportId 
     * @return
     */
    public Report getReportById(int reportId) {
    	return new Report();
    }

    /**
     * @param reportId 
     * @return
     */
    public boolean existsReport(int reportId) {
    	return true;
    }

    /**
     * @param reportId 
     * @return
     */
    public boolean deleteReport(int reportId) {
    	return true;
    }

    /**
     * @param badPlayerUsername 
     * @param reason 
     * @param description 
     * @return
     */
    public boolean createPlayerReport(String badPlayerUsername, String reason, String description) {
    	return true;
    }

}