package businesslogic.facade;

import java.util.*;
import businesslogic.domain.Report;
import businesslogic.domain.BugReport;
import businesslogic.domain.PlayerReport;

/**
 * @author Tiffany Dumaire - Aaron Lazaroo - Clarence Rouvel
 */
public class ReportManagementFacade {

    /**
     * Default constructor
     */
    public ReportManagementFacade() {
    }

    /**
     * 
     */
    private ArrayList<Report> reportsList;


    /**
     * 
     */
    private Report currentReportInView;




    /**
     * @return
     */
    public ArrayList<Report> getReportsList() {
        return this.reportsList;
    }

    /**
     * @return
     */
    public Report getcurrentReportInView() {
        return this.currentReportInView;
    }

    /**
     * @param reportId 
     * @return
     */
    public BugReport checkBugReport(int reportId) {
        // TODO implement here
        return null;
    }

    /**
     * @param reportId 
     * @return
     */
    public PlayerReport checkPlayerReport(int reportId) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ArrayList<BugReport> showBugReports() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ArrayList<PlayerReport> showPlayerReports() {
        // TODO implement here
        return null;
    }

    /**
     * @param reportId 
     * @return
     */
    public boolean deleteReport(int reportId) {
        // TODO implement here
        return false;
    }

}