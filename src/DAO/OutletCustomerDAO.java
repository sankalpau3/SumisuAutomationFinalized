/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import data.DBConnManager;
import data.OutletCustomer;
import java.sql.Connection;
import java.sql.*;
import java.util.*;

/**
 *
 * @author nobilitynobility
 */
public class OutletCustomerDAO {
    private DBConnManager dbConnManager = null;
    
     public OutletCustomerDAO()
    {
        dbConnManager = new DBConnManager();
    }
    
     public Vector getoutletCustomerDetails(String no) {

        Vector<Vector<String>> outletCustomerDetailsVector = null;
	Connection dbConn = null;
        
        try{
        dbConn = dbConnManager.connect();
        Statement stmt = dbConn.createStatement();

        String query = "SELECT * FROM sumisu.outletcustomer where fname like '"+no+"%';";
        
        ResultSet rs= stmt.executeQuery(query);
        outletCustomerDetailsVector = new Vector<Vector<String>>();
        
        while(rs.next())
        {
          Vector<String> outletCustomerDetails = new Vector<String>();
          outletCustomerDetails.add(rs.getString(1));
          outletCustomerDetails.add(rs.getString(2));
          outletCustomerDetails.add(rs.getString(3));
          outletCustomerDetails.add(rs.getString(4));
          outletCustomerDetails.add(rs.getString(5));
          outletCustomerDetails.add(rs.getString(6));
          outletCustomerDetails.add(rs.getString(7));
          
          outletCustomerDetailsVector.add(outletCustomerDetails);
          
        }
        }
        catch(Exception ex)
        {
            System.out.println("-------- Select query fail. " + ex );
        }
        finally{
            dbConnManager.con_close(dbConn);
        }
        return outletCustomerDetailsVector;
        
     }
     public boolean addOutletCustomer(OutletCustomer d) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


           

            String query = "INSERT INTO outletcustomer(fname,lname,address,phone,email,startDate)  " +
                    "VALUES( '" + d.getFname() + "','" + d.getLname() + "','" + d.getAddress() + "','"+d.getPhone()+"','"+d.getEmail()+"','"+d.getStartDate()+"')";

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
      public boolean updateOutletCustomer(OutletCustomer d) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


           
            //UPDATE `sumisu`.`outletcustomer` SET `fname`='asd', `lname`='asd', `address`='asd', `phone`='997654328', `email`='ghjjk' WHERE `cusId`='11';

            String query = "UPDATE `sumisu`.`outletcustomer` SET `fname`='"+d.getFname()+"', `lname`='"+d.getLname()+"', `address`='"+d.getAddress()+"', `phone`='"+d.getPhone()+"', `email`='"+d.getEmail()+"' WHERE `cusId`='"+d.getCusId()+"'";
                    

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
        }finally{
            dbConnManager.con_close(dbConn);
        }
        return result;
    }
      
        public boolean deleteOutletCustomer(String cID) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


           
            //DELETE FROM `sumisu`.`outletcustomer` WHERE `cusId`='3';
            String query ="DELETE FROM outletcustomer  WHERE `cusId`='"+cID+"'";

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
        }finally{
            dbConnManager.con_close(dbConn);
        }
        return result;
    }
   
     
   
    }

     


