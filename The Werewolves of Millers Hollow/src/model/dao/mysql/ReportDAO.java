package model.dao.mysql;

import java.sql.SQLException;
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
     * @throws SQLException 
     */
    public abstract boolean createBugReport(String subject, String description, String attachment) throws SQLException;

    /**
     * @return
     * @throws SQLException 
     */
    public abstract ArrayList<BugReport> getBugReports() throws SQLException;

    /**
     * @return
     * @throws SQLException 
     */
    public abstract ArrayList<PlayerReport> getPlayerReports() throws SQLException;

    /**
     * @return
     * @throws SQLException 
     */
    public abstract ArrayList<Report> getReports() throws SQLException;

    /**
     * @param reportId 
     * @return
     * @throws SQLException 
     */
    public abstract BugReport getBugReportById(int reportId) throws SQLException;

    /**
     * @param reportId 
     * @return
     * @throws SQLException 
     */
    public abstract PlayerReport getPlayerReportById(int reportId) throws SQLException;

    /**
     * @param reportId 
     * @return
     * @throws SQLException 
     */
    public abstract Report getReportById(int reportId) throws SQLException;

    /**
     * @param reportId 
     * @return
     * @throws SQLException 
     */
    public abstract boolean existsReport(int reportId) throws SQLException;

    /**
     * @param reportId 
     * @return
     * @throws SQLException 
     */
    public abstract boolean deleteReport(int reportId) throws SQLException;

    /**
     * @param badPlayerUsername 
     * @param reason 
     * @param description 
     * @return
     * @throws SQLException 
     */
    public abstract boolean createPlayerReport(String badPlayerUsername, String reason, String description) throws SQLException;

}