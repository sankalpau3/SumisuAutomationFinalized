/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author it13063856
 */
public class DBConnManager {

    String sourceURL;

    public DBConnManager()
    {
         try
         {
            // Load JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Connection URL.
            sourceURL = new String("jdbc:mysql://localhost:3306/sumisu");
         }
         catch (ClassNotFoundException classNotFoundException)
         {
             System.out.println(classNotFoundException + "-----------Unable to load database driver classes");
         }
    }

    public Connection connect()
    {
        Connection dbConn = null;
        try
        {
            dbConn = (Connection) DriverManager.getConnection(sourceURL, "root", "");
        }
        catch (SQLException sQLException)
        {
            System.out.println(sQLException + "-----------DB connection failure");
        }
        return dbConn;
    }

    public void con_close(Connection dbConn)
    {
        try
        {
             dbConn.close();
        }
        catch (SQLException sQLException)
        {
             System.out.println(sQLException + "-----------DB connection closing failure");
        }
    }
     public com.mysql.jdbc.Connection getConnection(){
        try {
            java.sql.Connection con = DriverManager.getConnection(sourceURL, "root", "");
            return (com.mysql.jdbc.Connection) con;
        } catch (SQLException sQLException) {
            return null;

        }
    }
}
