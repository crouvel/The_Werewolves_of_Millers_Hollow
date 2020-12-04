package util;

import java.sql.*;
import javax.swing.*;


public class ConnectionUtil {
    Connection connection = null;
    public static Connection connectionDatabase()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://mysql-projetsep.alwaysdata.net/projetsep_werewolves?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            String user = "projetsep";
            String pwd = "ProjetSEP-2020";
            Connection connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connection status"+pwd);
            return connection;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}