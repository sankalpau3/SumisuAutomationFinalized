/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import data.Cal;
import data.CustomerDetails;
import data.DBConnManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author JAYAMINI
 */
public class CustomerDAO 
{
     private DBConnManager dbConnManager = null;

    public CustomerDAO() {
        dbConnManager = new DBConnManager();
    }
    
     public boolean addCustomer(CustomerDetails d) {

        boolean result = false;
	Connection dbConn = null;
        
         Cal c = new Cal();

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "INSERT INTO `sumisu`.`deliverycustomer` (`fname`, `lname`, `email`, `address`, `phone`, `StartDate`, `deliveryVehicleId`) VALUES ('"+d.getFname()+"', '"+d.getLname()+"', '"+d.getEmail()+"', '"+d.getAddress()+"', '"+d.getPhone()+"', '"+c.getDate()+"', '1');";

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
     
      public boolean updateCustomer(CustomerDetails d) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "UPDATE `sumisu`.`deliverycustomer` SET `fname`='"+d.getFname()+"', `lname`='"+d.getLname()+"', `email`='"+d.getEmail()+"', `address`='"+d.getAddress()+"', `phone`='"+d.getPhone()+"', `StartDate`='2014-01-01', `deliveryVehicleId`='11' WHERE `cusId`='"+d.getCusId()+"';";

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
     
       public Vector getCustomerDetails(String no) {

        Vector<Vector<String>> customerDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM sumisu.deliverycustomer where fname like '"+no+"%';";

            ResultSet rs = stmt.executeQuery(query);
            customerDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> customerDetails = new Vector<String>();
                customerDetails.add(rs.getString(1)); //fname
                customerDetails.add(rs.getString(2)); //lname
                customerDetails.add(rs.getString(3)); //email
                customerDetails.add(rs.getString(4)); //address
                customerDetails.add(rs.getString(5)); //phone
                customerDetails.add(rs.getString(6)); //StartDate
                customerDetails.add(rs.getString(7)); //deliveryvehicleid
                
                customerDetailsVector.add(customerDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return customerDetailsVector;
    }
    public boolean deleteCustomer(String cusId) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "DELETE FROM `sumisu`.`deliverycustomer` WHERE `cusId`='"+cusId+"';";


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
    
    
    public Vector getDelCustDetails(String no) {

        Vector<Vector<String>> customerDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT `deliverycustomer`.`cusId`, `deliverycustomer`.`fname`, `deliverycustomer`.`lname` FROM `sumisu`.`deliverycustomer` where fname like '"+no+"%' or fname like '"+no+"%'";

            ResultSet rs = stmt.executeQuery(query);
            customerDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> customerDetails = new Vector<String>();
                customerDetails.add(rs.getString(1)); //fname
                customerDetails.add(rs.getString(2)); //lname
                customerDetails.add(rs.getString(3)); //email
//                customerDetails.add(rs.getString(4)); //address
//                customerDetails.add(rs.getString(5)); //phone
//                customerDetails.add(rs.getString(6)); //timeduration
//                customerDetails.add(rs.getString(7)); //deliveryvehicleid
                customerDetailsVector.add(customerDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return customerDetailsVector;
    }
    
    public Vector getProductDetails(String st) {

        Vector<Vector<String>> ProductDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            //String query = "SELECT itemId , proName , price , ingredient , qty , weight "+
                  //  "FROM product";
            String query = "SELECT `product`.`itemId`, `product`.`proName`, `product`.`price`, `product`.`weight` FROM `sumisu`.`product` where proName like '%"+st+"%';";

            ResultSet rs = stmt.executeQuery(query);
            ProductDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> ProductDetails = new Vector<String>();
                ProductDetails.add(rs.getString(1)); 
                ProductDetails.add(rs.getString(2)); 
                ProductDetails.add(rs.getString(3)); 
                ProductDetails.add(rs.getString(4)); 
//                ProductDetails.add(rs.getString(5)); 
//                ProductDetails.add(rs.getString(6));
                ProductDetailsVector.add(ProductDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return ProductDetailsVector;
    }
    
    public boolean updateOrder(String cid, String pid, String qty) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "INSERT INTO `sumisu`.`delorder` (`custid`,`proid`,`qty`) VALUES ("+cid+","+pid+","+qty+");";

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
    
    public Vector getOrderDetails(String st) {

        Vector<Vector<String>> ProductDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            //String query = "SELECT itemId , proName , price , ingredient , qty , weight "+
                  //  "FROM product";
            String query = "select d.proid, p.proName, d.qty from delorder d , product p where d.proid = p.itemId and d.custid = "+st+" ;";

            ResultSet rs = stmt.executeQuery(query);
            ProductDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> ProductDetails = new Vector<String>();
                ProductDetails.add(rs.getString(1)); 
                ProductDetails.add(rs.getString(2)); 
                ProductDetails.add(rs.getString(3)); 
//                ProductDetails.add(rs.getString(4)); 
//                ProductDetails.add(rs.getString(5)); 
//                ProductDetails.add(rs.getString(6));
                ProductDetailsVector.add(ProductDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return ProductDetailsVector;
    }
    
    
    public boolean deleteOrder(String cusId , String Pid) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "DELETE FROM `sumisu`.`delorder` WHERE custid = "+cusId+" and proid = "+Pid+" ;";


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
     

      

