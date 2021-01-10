/**
 * package model.dao.mysql
 */
package model.dao.mysql;

/**
 * Imported classes and libraries.
 */
import java.sql.SQLException;
import java.util.*;

import businesslogic.domain.Report;
import businesslogic.domain.PlayerReport;
import businesslogic.domain.BugReport;

/**
 * ReportDAO class.
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public abstract class ReportDAO {

    /**
     * Default constructor
     */
    public ReportDAO() {}
    
    /**
     * Create a player report with the information in parameters and return success or not.
     * @param badPlayerUsername 
     * @param reason 
     * @param description 
     * @return true if the player report was created, else false.
     * @throws SQLException 
     */
    public abstract boolean createPlayerReport(String badPlayerUsername, String reason, String description) throws SQLException;

    /**
     * Create a bug report with the information in parameters and return success or not.
     * @param subject 
     * @param description 
     * @param attachment 
     * @return true if the bug report was created, else false.
     * @throws SQLException 
     */
    public abstract boolean createBugReport(String subject, String description, String attachment) throws SQLException;

    /**
     * Search and return the bug reports in the database.
     * @return the list of bug reports.
     * @throws SQLException 
     */
    public abstract ArrayList<BugReport> getBugReports() throws SQLException;

    /**
     * Search and return the player reports in the database.
     * @return the list of player reports.
     * @throws SQLException 
     */
    public abstract ArrayList<PlayerReport> getPlayerReports() throws SQLException;

    /**
     * Search and return all the reports in the database.
     * @return the list of reports.
     * @throws SQLException 
     */
    public abstract ArrayList<Report> getReports() throws SQLException;

    /**
     * Search and return the bug report corresponding to the reportId in parameter.
     * @param reportId 
     * @return the bug report corresponding to the reportId parameter.
     * @throws SQLException 
     */
    public abstract BugReport getBugReportById(int reportId) throws SQLException;

    /**
     * Search and return the player report corresponding to the reportId in parameter.
     * @param reportId 
     * @return the player report corresponding to the reportId parameter.
     * @throws SQLException 
     */
    public abstract PlayerReport getPlayerReportById(int reportId) throws SQLException;

    /**
     * Search and return the report corresponding to the reportId in parameter.
     * @param reportId 
     * @return the report corresponding to the reportId parameter.
     * @throws SQLException 
     */
    public abstract Report getReportById(int reportId) throws SQLException;

    /**
     * Search the report corresponding to the reportId parameter in the database and it returns if exists or not.
     * @param reportId 
     * @return true if the report corresponding to the reportId in parameter exists, else false.
     * @throws SQLException 
     */
    public abstract boolean existsReport(int reportId) throws SQLException;

    /**
     * Delete the report corresponding to the reportId parameter in the database.
     * @param reportId 
     * @return true if the report was deleted or does not exist, else false.
     * @throws SQLException 
     */
    public abstract boolean deleteReport(int reportId) throws SQLException;
    
}