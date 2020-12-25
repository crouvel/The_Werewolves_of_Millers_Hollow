package model.dao.mysql;

import java.util.*;
import businesslogic.domain.Report;
import businesslogic.domain.PlayerReport;
import businesslogic.domain.BugReport;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public abstract class ReportDAO {

    /**
     * Default constructor
     */
    public ReportDAO() {
    }






    /**
     * @param subject 
     * @param description 
     * @param attachment 
     * @return
     */
    public abstract boolean createBugReport(String subject, String description, String attachment);

    /**
     * @return
     */
    public abstract ArrayList<BugReport> getBugReports();

    /**
     * @return
     */
    public abstract ArrayList<PlayerReport> getPlayerReports();

    /**
     * @return
     */
    public abstract ArrayList<Report> getReports();

    /**
     * @param reportId 
     * @return
     */
    public abstract BugReport getBugReportById(int reportId);

    /**
     * @param reportId 
     * @return
     */
    public abstract PlayerReport getPlayerReportById(int reportId);

    /**
     * @param reportId 
     * @return
     */
    public abstract Report getReportById(int reportId);

    /**
     * @param reportId 
     * @return
     */
    public abstract boolean existsReport(int reportId);

    /**
     * @param reportId 
     * @return
     */
    public abstract boolean deleteReport(int reportId);

    /**
     * @param badPlayerUsername 
     * @param reason 
     * @param description 
     * @return
     */
    public abstract boolean createPlayerReport(String badPlayerUsername, String reason, String description);

}