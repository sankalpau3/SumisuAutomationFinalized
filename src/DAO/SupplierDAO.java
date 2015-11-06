/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import data.Cal;
import data.DBConnManager;
import data.SupplierDetails;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Dell
 */
public class SupplierDAO {

    private DBConnManager dbConnManager = null;

    Cal c = new Cal();

    public SupplierDAO() {
        dbConnManager = new DBConnManager();
    }

    public Vector getSuppliertFiltered(String no) {

        Vector<Vector<String>> profitVector = null;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM sumisu.suppllier" + " where fname like '" + no + "%'";

            ResultSet rs = stmt.executeQuery(query);
            profitVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> profitDetails = new Vector<String>();
                profitDetails.add(rs.getString(1)); //suplier ID
                profitDetails.add(rs.getString(2)); //fname
                profitDetails.add(rs.getString(3)); //lname 
                profitDetails.add(rs.getString(4)); //address
                profitDetails.add(rs.getString(5)); //phone
                profitDetails.add(rs.getString(6)); //accno
                profitDetails.add(rs.getString(7)); //email
                profitVector.add(profitDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return profitVector;
    }//End of getSupplier Filterd

    public boolean addSupplier(SupplierDetails d) {
        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "INSERT INTO `sumisu`.`suppllier` (`fname`, `lname`, `address`, `email`, `phone`, `accNo`) VALUES ('" + d.getFname() + "', '" + d.getLname() + "', '" + d.getAddr() + "', '" + d.getEmail() + "', '" + d.getPhone() + "', '" + d.getAccNo() + "')";

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

    }// end of addsupplier

    public boolean updateSupplier(SupplierDetails d) {
        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "UPDATE `sumisu`.`suppllier` SET `fname`='" + d.getFname() + "', `lname`='" + d.getLname() + "', `address`='" + d.getAddr() + "', `email`='" + d.getEmail() + "', `phone`='" + d.getPhone() + "' WHERE `supId`='" + d.getSupId() + "';";

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

    }
    
    public boolean removeSupplier(String supId) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "DELETE FROM `sumisu`.`suppllier` WHERE `supId`='"+supId+"';";


            System.out.println(query);

            int val = stmt.executeUpdate(query);
            System.out.println(val);
            if (val == 1) {
                result = true;
            } else {
                result = false;
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Remove query failed");

            result = false;
        }finally{
            dbConnManager.con_close(dbConn);
        }
        return result;   
    }
}
