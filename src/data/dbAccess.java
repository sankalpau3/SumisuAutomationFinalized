/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Janson with Happy Codings
 */
public class dbAccess {

    private String sourceURL = null;
    Connection dbConn = null;

    public dbAccess() {
        try {
//             Load JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Connection URL
            sourceURL = "jdbc:mysql://localhost:3306/moviehut";
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println(classNotFoundException + "--------Unable to load database driver class");
        }

    }

    // for connection open
    private void Connect() {
        try {

            dbConn = DriverManager.getConnection(sourceURL, "root", "");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "DB_CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    // for connection close
    public void Con_close() {
        try {
            dbConn.close();
        } catch (SQLException sQLException) {
            System.out.println(sQLException + "----------DB connection closing failure");
        }
    }

    // for execute UPDATE quaries4
    
    public boolean UPDATE(String sql) {

        Connect();

        try {



            Statement stmt = dbConn.createStatement();

            if (stmt.executeUpdate(sql) == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, sQLException, "DB_CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                dbConn.close();
            } catch (SQLException ex) {
                System.out.println(ex + "----------DB connection closing failure");
            }
        }


    }

    // for execute SELECT Quary
    public ResultSet SELECT(String sql) {

        Connect();


        try {
            dbConn = DriverManager.getConnection(sourceURL, "root", "");
            Statement stmt = dbConn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            return rs;

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, sQLException, "DB_CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }
}
