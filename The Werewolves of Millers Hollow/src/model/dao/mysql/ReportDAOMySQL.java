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
 * ReportDAOMySQL class.
 * @author Tiffany Dumaire, Aaron Lazaroo, Clarence Rouvel
 */
public class ReportDAOMySQL extends ReportDAO {

	/**
	 * Default constructor
	 */
	public ReportDAOMySQL() {}

	@Override
	public boolean createBugReport(String subject, String description, String attachment) throws SQLException {
		try {
			String sqlRequest = "INSERT INTO Report(subject,description,isBugReport,attachementLink) VALUES(?,?,?,?)";
			PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
			request.setString(1, subject);
			request.setString(2, description);
			request.setBoolean(3, true);
			request.setString(4, attachment);
			request.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}
	}

	@Override
	public boolean createPlayerReport(String badPlayerUsername, String reason, String description) throws SQLException {
		try {
			String sqlRequest = "INSERT INTO Report(subject,description,isBugReport,attachementLink) VALUES(?,?,?,?)";
			PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
			request.setString(1, reason);
			request.setString(2, "Reported Player: " + badPlayerUsername + "\n\n" + description);
			request.setBoolean(3, true);
			request.setString(4, "");
			request.executeUpdate();
			return true;
		}catch(SQLException e) {
			return false;
		}
	}


	@Override
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

	@Override
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

	@Override
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


	@Override
	public BugReport getBugReportById(int reportId) throws SQLException {
		return null;
	}

	@Override
	public PlayerReport getPlayerReportById(int reportId) throws SQLException {
		return null;
	}

	@Override
	public Report getReportById(int reportId) throws SQLException {
		return null;
	}

	@Override
	public boolean existsReport(int reportId) throws SQLException {
		String sqlRequest = "SELECT * FROM Report WHERE reportId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, reportId);
		ResultSet resultSet = request.executeQuery();
		return resultSet.first();
	}

	@Override
	public boolean deleteReport(int reportId) throws SQLException{
		String sqlRequest="DELETE FROM Report WHERE reportId=?";
		PreparedStatement request = AbstractFactoryDAO.getConnection().prepareStatement(sqlRequest);
		request.setInt(1, reportId);
		request.executeUpdate();
		return !existsReport(reportId);
	}

}