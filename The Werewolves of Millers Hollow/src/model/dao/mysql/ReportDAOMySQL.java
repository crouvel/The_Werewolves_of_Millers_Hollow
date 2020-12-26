/**
 * package model.dao.mysql
 */
package model.dao.mysql;

/**
 * Imported classes and libraries.
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import businesslogic.domain.Report;
import model.dao.factory.AbstractFactoryDAO;
import businesslogic.domain.PlayerReport;
import businesslogic.domain.PlayerReportType;
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
     * @throws SQLException 
     */
    public ArrayList<BugReport> getBugReports() throws SQLException{
    	String sqlRequest="SELECT * FROM Report";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	ResultSet resultSet = request.executeQuery();
    	ArrayList<BugReport> bugReports = new ArrayList<BugReport>();
        while (resultSet.next()) {
            if(resultSet.getInt("isBugReport")==1) {
            	bugReports.add(new BugReport(resultSet.getInt("reportId"),resultSet.getString("subject"),resultSet.getString("description"),resultSet.getString("attachementLink")));
            }
        }
        return bugReports;    
    }

    /**
     * @return
     * @throws SQLException
     */
    public ArrayList<PlayerReport> getPlayerReports() throws SQLException{
    	String sqlRequest="SELECT * FROM Report";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	ResultSet resultSet = request.executeQuery();
    	ArrayList<PlayerReport> playerReports = new ArrayList<PlayerReport>();
        while (resultSet.next()) {
            if(resultSet.getInt("isBugReport")==0) {
            	playerReports.add(new PlayerReport(resultSet.getInt("reportId"),resultSet.getString("description"),PlayerReportType.get(resultSet.getString("subject"))));
            }
        }
        return playerReports;
    }

    /**
     * @return
     * @throws SQLException 
     */
    public ArrayList<Report> getReports() throws SQLException{
    	String sqlRequest="SELECT * FROM Report";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	ResultSet resultSet = request.executeQuery();
    	ArrayList<Report> reports = new ArrayList<Report>();
        while (resultSet.next()) {
            reports.add(new Report(resultSet.getInt("reportId"),resultSet.getString("description")));
        }
        return reports;
    }
    
    
    /**
     * @param reportId 
     * @return
     */
    public BugReport getBugReportById(int reportId) {
    	return null;
    }

    /**
     * @param reportId 
     * @return
     */
    public PlayerReport getPlayerReportById(int reportId) {
    	return null;
    }

    /**
     * @param reportId 
     * @return
     */
    public Report getReportById(int reportId) {
    	return null;
    }

    /**
     * @param reportId 
     * @return
     * @throws SQLException
     */
    public boolean existsReport(int reportId) throws SQLException {
    	String sqlRequest = "SELECT * FROM Report WHERE reportId=?";
    	PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, reportId);
    	ResultSet resultSet = request.executeQuery();
    	return resultSet.first();
    }

    /**
     * @param reportId 
     * @return
     * @throws SQLException
     */
    public boolean deleteReport(int reportId) throws SQLException{
    	String sqlRequest="DELETE FROM Report WHERE reportId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
    	request.setInt(1, reportId);
        request.executeUpdate();
        return !existsReport(reportId);
    }
    /**
     * @param badPlayerUsername 
     * @param reason 
     * @param description 
     * @return
     * @throws SQLException
     */
    public boolean createPlayerReport(String badPlayerUsername, String reason, String description) throws SQLException {
    	return true;
    }

}