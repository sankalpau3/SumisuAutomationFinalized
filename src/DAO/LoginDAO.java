/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import data.Cal;
import data.DBConnManager;
import java.sql.*;

/**
 *
 * @author Dell
 */
public class LoginDAO {
    
    private DBConnManager dbConnManager = null;
    
    Cal c = new Cal();
    
    public LoginDAO()
    {
        dbConnManager = new DBConnManager();
    }
            public boolean isFirstlogin(String username){

        boolean isFirst;
        int i = 0;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "SELECT isFirstLogin FROM employee WHERE username = '"+username+"'";

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()){
                i = Integer.parseInt(rs.getString(1));
                System.out.println(i);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query Failed for isFirstLogin");

        }finally{
            dbConnManager.con_close(dbConn);
        }
        if(i==1)
        {
            isFirst = true;
        }
        else
        {
            isFirst = false;
        }
        return isFirst;
    }
            
            
            public boolean updateuser(String id, String un , String pw) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


            String query = "UPDATE `sumisu`.`employee` SET `username`='"+un+"', `password`='"+pw+"' WHERE `empId`='"+id+"';";

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
            
            public boolean updateflogin(String id) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


            String query = "UPDATE `sumisu`.`employee` SET `isFirstLogin`='0' WHERE `empId`='"+id+"';";

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
            
            
            
          public int getEmpId(String un){

        int empId = 0;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "SELECT empId FROM employee WHERE username = '"+un+"'";

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()){
                empId = Integer.parseInt(rs.getString(1));
                System.out.println(empId);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query Failed for EmpId");

        }finally{
            dbConnManager.con_close(dbConn);
        }
        return empId;
    }          
           
          public boolean validateUser(String un, String pw){

        int count = 0;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "select count(empid)" +
                            " from employee" +
                            " where username = '"+un+"' and password = '"+pw+"'";

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()){
                count = Integer.parseInt(rs.getString(1));
                System.out.println(count);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query Failed for EmpId");

        }finally{
            dbConnManager.con_close(dbConn);
        }
        if(count==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
          
          
          public boolean isAvailable(String un){

        int count = 0;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "select count(empid)" +
                            " from employee" +
                            " where username = '"+un+"'";

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()){
                count = Integer.parseInt(rs.getString(1));
                System.out.println(count);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query Failed for EmpId");

        }finally{
            dbConnManager.con_close(dbConn);
        }
        if(count==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
          
          public boolean setUn(String un) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


            String query = "UPDATE `sumisu`.`loginun`  SET `username` = '"+un+"' WHERE `id` = 1;";

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
          
          public String getun(){

        String un = "";
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "SELECT username FROM sumisu.loginun where id = 1;";

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()){
                un = rs.getString(1);
                System.out.println(un);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query Failed for EmpId");

        }finally{
            dbConnManager.con_close(dbConn);
        }
        return un;
    }     
          
          
}
