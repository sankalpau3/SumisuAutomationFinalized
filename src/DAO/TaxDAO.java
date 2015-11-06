/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import data.DBConnManager;
import data.TaxData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author sanke
 */
public class TaxDAO {

    private DBConnManager dbConnManager = null;

    public TaxDAO() {
        dbConnManager = new DBConnManager();
    }

    public Vector getTaxInfo() {

        Vector<Vector<String>> TaxVector = null;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM sumisu.tax;";

            ResultSet rs = stmt.executeQuery(query);
            TaxVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> taxDetails = new Vector<String>();
                taxDetails.add(rs.getString(1)); //TaxID
                taxDetails.add(rs.getString(2)); //InvoiceNo
                taxDetails.add(rs.getString(3)); //date
                taxDetails.add(rs.getString(4)); //type
                taxDetails.add(rs.getString(5)); //amount
                taxDetails.add(rs.getString(6)); //quartile
                taxDetails.add(rs.getString(7)); //discription
                TaxVector.add(taxDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return TaxVector;
    }//End of getProfit

    public boolean addTax(TaxData d) {
        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "INSERT INTO `sumisu`.`tax` (`invoiceno`, `date`, `type`, `amount`, `quartile`, `description`) VALUES ('" + d.getInvoiceNO() + "', '" + d.getDate() + "', '" + d.getType() + "',"
                    + " '" + d.getAmount() + "', '" + d.getQuartile() + "', '" + d.getDiscript() + "');";
            System.out.println(query);

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } else {
                result = false;
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Insert query failed");

            result = false;
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return result;

    }//end of addTax

    public boolean updateTax(TaxData d) {
        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "UPDATE `sumisu`.`tax` SET `invoiceno`='" + d.getInvoiceNO() + "', `date`='" + d.getDate() + "',"
                    + " `type`='" + d.getType() + "', `quartile`='" + d.getQuartile() + "',"
                    + " `description`='" + d.getDiscript() + "' WHERE `taxId`='" + d.getTaxId() + "';";
            System.out.println(query);

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } else {
                result = false;
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Update query failed");

            result = false;
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return result;

    }//end of updateTax
    
     public boolean removeTax(TaxData d) {
        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "DELETE FROM `sumisu`.`tax` WHERE `taxID`='" +d.getTaxId()+ "';";

            System.out.println(query);

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } else {
                result = false;
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Delete query failed");

            result = false;
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return result;

    }

}

