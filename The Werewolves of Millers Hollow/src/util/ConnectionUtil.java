/**
 * package util.
 */
package util;

/**
 * Imported libraries and classes.
 */
import java.sql.*;
import javax.swing.*;

/**
 * 
 * @author Tiffany Dumaire
 *
 */
public class ConnectionUtil {
	
	/**
	 * Connection attribute initialized to "null".
	 */
    Connection connection = null;
    
    /**
     * Allows the application to connect to the database.     
     * @return the connection to the database.
     */
    public static Connection connectionDatabase()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://mysql-projetsep.alwaysdata.net/projetsep_werewolves?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            String user = "projetsep";
            String pwd = "ProjetSEP-2020";
            Connection connection = DriverManager.getConnection(url, user, pwd);
            return connection;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}