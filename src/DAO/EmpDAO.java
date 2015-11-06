/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import data.Cal;
import data.DBConnManager;
import data.Emp;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Dell
 */
public class EmpDAO {

    private DBConnManager dbConnManager = null;
    
    Cal c = new Cal();
    
    public EmpDAO()
    {
        dbConnManager = new DBConnManager();
    }
    
    public Vector getEmpDetails() {

        Vector<Vector<String>> empDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT empId, fName, lName, address, phone, BOD, nic, basicSal "+
                    "FROM employee";

            ResultSet rs = stmt.executeQuery(query);
            empDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> empDetails = new Vector<String>();
                empDetails.add(rs.getString(1)); 
                empDetails.add(rs.getString(2)); 
                empDetails.add(rs.getString(3)); 
                empDetails.add(rs.getString(4)); 
                empDetails.add(rs.getString(5)); 
                empDetails.add(rs.getString(6));
                empDetails.add(rs.getString(7));
                empDetails.add(rs.getString(8));
                empDetailsVector.add(empDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return empDetailsVector;
    }
    
        public Vector getEmpDetails(String st) {

        Vector<Vector<String>> empDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT empId, fName, lName, address, phone, BOD, nic, basicSal "+
                    "FROM employee "+
                    "where fname like '"+st+"%' or lname like '"+st+"%' ";

            ResultSet rs = stmt.executeQuery(query);
            empDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> empDetails = new Vector<String>();
                empDetails.add(rs.getString(1)); 
                empDetails.add(rs.getString(2)); 
                empDetails.add(rs.getString(3)); 
                empDetails.add(rs.getString(4)); 
                empDetails.add(rs.getString(5)); 
                empDetails.add(rs.getString(6));
                empDetails.add(rs.getString(7));
                empDetails.add(rs.getString(8));
                empDetailsVector.add(empDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return empDetailsVector;
    }
    
    
        public Vector getAllEmpDetails(int i) {

        Vector<Vector<String>> allempDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * "+
                    " FROM employee"+
                    " where empid = "+i;

            ResultSet rs = stmt.executeQuery(query);
            allempDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> empDetails = new Vector<String>();
                empDetails.add(rs.getString(1)); 
                empDetails.add(rs.getString(2)); 
                empDetails.add(rs.getString(3)); 
                empDetails.add(rs.getString(4)); 
                empDetails.add(rs.getString(5)); 
                empDetails.add(rs.getString(6));
                empDetails.add(rs.getString(7));
                empDetails.add(rs.getString(8));
                empDetails.add(rs.getString(9)); 
                empDetails.add(rs.getString(10)); 
                empDetails.add(rs.getString(11)); 
                empDetails.add(rs.getString(12)); 
                empDetails.add(rs.getString(13)); 
                empDetails.add(rs.getString(14));
                empDetails.add(rs.getString(15));
                empDetails.add(rs.getString(16));
                empDetails.add(rs.getString(17));
                allempDetailsVector.add(empDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return allempDetailsVector;
    }
        public Vector getAllEmpDetails() {

        Vector<Vector<String>> allempDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * "+
                    " FROM employee";

            ResultSet rs = stmt.executeQuery(query);
            allempDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> empDetails = new Vector<String>();
                empDetails.add(rs.getString(1)); 
                empDetails.add(rs.getString(2)); 
                empDetails.add(rs.getString(3)); 
                empDetails.add(rs.getString(4)); 
                empDetails.add(rs.getString(5)); 
                empDetails.add(rs.getString(6));
                empDetails.add(rs.getString(7));
                empDetails.add(rs.getString(8));
                empDetails.add(rs.getString(9)); 
                empDetails.add(rs.getString(10)); 
                empDetails.add(rs.getString(11)); 
                empDetails.add(rs.getString(12)); 
                empDetails.add(rs.getString(13)); 
                empDetails.add(rs.getString(14));
                empDetails.add(rs.getString(15));
                empDetails.add(rs.getString(16));
                empDetails.add(rs.getString(17));
                allempDetailsVector.add(empDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return allempDetailsVector;
    }
    
//        public int getEmpId(String jobCatName){
//
//        int catId = 0;
//	Connection dbConn = null;
//
//        try {
//            dbConn = dbConnManager.connect();
//
//            Statement stmt = dbConn.createStatement();
//
//            String query = "SELECT jobCatId FROM JobCategory WHERE jobCatName = '"+jobCatName+"'";
//
//            System.out.println(query);
//            ResultSet rs = stmt.executeQuery(query);
//
//            if(rs.next()){
//                catId = Integer.parseInt(rs.getString(1));
//                System.out.println(catId);
//            }
//        } catch (SQLException sQLException) {
//            System.out.println(sQLException + "-----------Select query Failed for JobCatId");
//
//        }finally{
//            dbConnManager.con_close(dbConn);
//        }
//        return catId;
//    }
    
    
    public boolean addEmp(Emp d) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


            String query = "INSERT INTO employee(fname,lname,address,phone,bod,gender,nic,accno,maritalstatus,sdate,basicsal,allowances,othrs,bonus,mobile,email,category,section, username)  " +
                    "VALUES( '"+d.getfName()+"','"+ d.getlName() + "','" + d.getAddress() +"'," + d.getPhone() + ",'" + d.getBod() + "','" + d.getGender() + "','" + d.getNic() + "'," + d.getAccNo() + ",'" + d.isCivilStatus() + "','" + c.getDate() + "', "+d.getbSal()+" , 0 , 0 , 0,"+d.getMobile()+",'"+ d.getEmail()+"','"+d.getCatagory()+"','"+d.getSection()+"','"+d.getNic()+"')" ;
            
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

        public boolean updateEmp(Emp d, String id) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


            String query = "UPDATE `sumisu`.`employee` SET `fname`='"+ d.getfName()+"', `lname`='"+d.getlName()+"', `address`='"+d.getAddress()+"', `phone`='"+d.getPhone()+"', `BOD`='"+d.getBod()+"', `gender`='"+d.getGender()+"', `nic`='"+d.getNic()+"', `accNo`='"+d.getAccNo()+"', `basicSal`='"+d.getbSal()+"', `maritalStatus`='"+d.isCivilStatus()+"', `mobile`='"+d.getMobile()+"', `email`='"+d.getEmail()+"' WHERE `empId`='"+id+"'";

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
        
        
    public boolean deleteEmp(String id) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


            String query = "DELETE FROM `sumisu`.`employee` WHERE `empId`='"+id+"';";
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
    
    
    
            public Vector getEmpAllocateDetails(String st) {

        Vector<Vector<String>> empDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "select a.empid, e.fname, e.lname " +
                            "from employee e, attendence a " +
                            "where e.empid=a.empid and e.category = 'labour' and a.date = '"+c.getDate()+"' and a.section = '"+st+"'";

            ResultSet rs = stmt.executeQuery(query);
            empDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> empDetails = new Vector<String>();
                empDetails.add(rs.getString(1)); 
                empDetails.add(rs.getString(2)); 
                empDetails.add(rs.getString(3)); 
//                empDetails.add(rs.getString(4)); 
//                empDetails.add(rs.getString(5)); 
//                empDetails.add(rs.getString(6));
//                empDetails.add(rs.getString(7));
//                empDetails.add(rs.getString(8));
                empDetailsVector.add(empDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return empDetailsVector;
    }

            public boolean updateEmpSection(Emp d) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


            String query = "UPDATE `sumisu`.`attendence` SET `section`='"+d.getSection()+"' WHERE `EmpID`='"+d.getEmpId()+"' and`Date`='"+c.getDate()+"';";

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
            
        public String getEmpLevel(String User){

        String st="";
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "select category from employee where username = '"+User+"';";

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()){
                st = rs.getString(1);
                System.out.println(st);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query Failed for EmpLevel");

        }finally{
            dbConnManager.con_close(dbConn);
        }
        return st;
    }    
    
     
     public boolean updateUnPw(String id, String un , String pw)
     {
         boolean result;
         Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query;
            if(!pw.equals(""))
            {
                query = "UPDATE `sumisu`.`employee` SET `username`='"+un+"' , `password` = '"+pw+"' WHERE `empid`='"+id+"';";
                System.out.println(query);
            }
            else
            {
                query = "UPDATE `sumisu`.`employee` SET `username`='"+un+"'  WHERE `empid`='"+id+"';";
                System.out.println(query);
            }
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
        
        public ArrayList getEmpNames(){

        ArrayList nameList = null;
	Connection dbConn1 = null;
	Connection dbConn2 = null;
	Connection dbConn3 = null;

        try{
            //Connect to th DB
            dbConn1 = dbConnManager.connect();
            dbConn2 = dbConnManager.connect();
            dbConn3 = dbConnManager.connect();

            Statement stmt1 = dbConn1.createStatement();


            //Select the Names
            String query1 = "SELECT fname from employee";
            System.out.println(query1);
            ResultSet rs1 = stmt1.executeQuery(query1);
            
            
            Statement stmt2 = dbConn2.createStatement();
            String query2 = "SELECT lname from employee";
            System.out.println(query2);
            ResultSet rs2 = stmt2.executeQuery(query2);
            
            Statement stmt3 = dbConn3.createStatement();
            String query3 = "SELECT empid from employee";
            System.out.println(query3);
            ResultSet rs3 = stmt3.executeQuery(query3);

            nameList = new ArrayList();

            while (rs1.next() && rs2.next() && rs3.next()) {
                String Name1 = rs1.getString(1);
                String Name2 = rs2.getString(1);
                String Name3 = rs3.getString(1);
                String Name = Name1+" "+Name2+" "+Name3;
                System.out.println(Name);
                nameList.add(Name);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed at Names");
        }finally{
            //Close the db connection
            dbConnManager.con_close(dbConn1);
            dbConnManager.con_close(dbConn2);
            dbConnManager.con_close(dbConn3);
        }
        return nameList;
    }
        
        
        public boolean addComp(String Empid, String comp) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


            String query = "INSERT INTO `sumisu`.`empcomplains` (`empid`,`Details`,`date`,`time`) VALUES ("+Empid+",'"+comp+"','"+c.getDate()+"','"+c.getTime()+"');" ;
            
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
        
        public Vector getComplaints() {

        Vector<Vector<String>> allempDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * from empcomplains where isViewed = 0";

            ResultSet rs = stmt.executeQuery(query);
            allempDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> empDetails = new Vector<String>();
                empDetails.add(rs.getString(1)); 
                empDetails.add(rs.getString(2)); 
                empDetails.add(rs.getString(3)); 
                empDetails.add(rs.getString(4)); 
//                empDetails.add(rs.getString(5)); 
//                empDetails.add(rs.getString(6));
//                empDetails.add(rs.getString(7));
//                empDetails.add(rs.getString(8));
//                empDetails.add(rs.getString(9)); 
//                empDetails.add(rs.getString(10)); 
//                empDetails.add(rs.getString(11)); 
//                empDetails.add(rs.getString(12)); 
//                empDetails.add(rs.getString(13)); 
//                empDetails.add(rs.getString(14));
//                empDetails.add(rs.getString(15));
//                empDetails.add(rs.getString(16));
//                empDetails.add(rs.getString(17));
                allempDetailsVector.add(empDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return allempDetailsVector;
    }
     
        
        public boolean updateComp(String id) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


            String query = "UPDATE `sumisu`.`empcomplains` SET `isViewed`= 1 where compid = "+id+";" ;
            
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
        
}
