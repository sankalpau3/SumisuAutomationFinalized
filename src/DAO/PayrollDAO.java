/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import data.Cal;
import data.DBConnManager;
import data.PayrollDetails;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author ChanaPC
 */
public class PayrollDAO {
     private DBConnManager dbConnManager = null;
     Cal c = new Cal();
    public PayrollDAO() {
     dbConnManager = new DBConnManager();
     
    }
    
    public Vector getPayroll(String no) {

         Vector<Vector<String>> jobDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT empId, fname, basicsal, allowances, bonus FROM sumisu.employee where fname like '"+no+"%';";

            ResultSet rs = stmt.executeQuery(query);
            jobDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> jobDetails = new Vector<String>();
                jobDetails.add(rs.getString(1)); 
                jobDetails.add(rs.getString(2));
                jobDetails.add(rs.getString(3));
                jobDetails.add(rs.getString(4));
                jobDetails.add(rs.getString(5));
                jobDetailsVector.add(jobDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return jobDetailsVector;
    }//end of getJobDetails

    
    public boolean addAttendance(PayrollDetails d)
    {
         boolean result = false;
         Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "INSERT INTO `sumisu`.`attendence` (`EmpID`, `Date`, `StartTime`, `section`) VALUES ('"+d.getEmpID()+"', '"+d.getAdate()+"', '"+d.getAttendtime()+"', 'N/A')";


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
        }finally{
            dbConnManager.con_close(dbConn);
        }
        return result;  
       
    
    } 
    
    public boolean addAttendanceOut(PayrollDetails d)
    {
         boolean result = false;
         Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "UPDATE `sumisu`.`attendence` SET `endtime`='"+d.getLeavetime()+"' WHERE `EmpID`='"+d.getEmpID()+"' and`Date`='"+d.getAdate()+"';";


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
        }finally{
            dbConnManager.con_close(dbConn);
        }
        return result;  
       
    } 
    
    
    
    
    public Vector getEmpDetails(String st) {

        Vector<Vector<String>> empDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT empId, fName, lname "+"FROM employee "+" where fname like '"+st+"%'";

            ResultSet rs = stmt.executeQuery(query);
            empDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> empDetails = new Vector<String>();
                empDetails.add(rs.getString(1)); 
                empDetails.add(rs.getString(2)); 
                empDetails.add(rs.getString(3)); 
//                empDetails.add(rs.getString(4)); 

                empDetailsVector.add(empDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return empDetailsVector;
    }
    
    public boolean updateEmployee(PayrollDetails d) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

           

            String query = "UPDATE `sumisu`.`employee` SET `basicSal`='"+d.getBasicSal()+"', `Allowances`='"+d.getAllowAmount()+"', `bonus`='"+d.getBonus()+"' WHERE `empId`='"+d.getEmpID()+"';";

            System.out.println(query);

            int val = stmt.executeUpdate(query);
            System.out.println(val+" /VaL");
            if (val == 1) {
                result = true;
            } else {
                result = false;
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Update query failed");

            result = false;
        }finally{
            dbConnManager.con_close(dbConn);
        }
        return result;
    }
//end of Update
    
    public Vector getAttendenceDetails(String no) {

        Vector<Vector<String>> profitVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM sumisu.attendence where date = '"+c.getDate()+"';";

            ResultSet rs = stmt.executeQuery(query);
            profitVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> profitDetails = new Vector<String>();
                profitDetails.add(rs.getString(1)); //transactionID
                profitDetails.add(rs.getString(2)); //transaction type
                profitDetails.add(rs.getString(3)); //date
                profitDetails.add(rs.getString(4)); //discription
               
                profitVector.add(profitDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return profitVector;
    }//end of getJobDetails
    
}


