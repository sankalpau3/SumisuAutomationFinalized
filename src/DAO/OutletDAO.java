/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

//import com.mysql.jdbc.Connection;
import data.Cal;
import data.DBConnManager;
import data.OutletCustomer;
import data.product;
//import java.sql.SQLException;
import java.sql.*;
import java.util.*;

/**
 *
 * @author nobilitynobility
 */
public class OutletDAO {
    
     private DBConnManager dbConnManager = null;
    
     public OutletDAO()
    {
        dbConnManager = new DBConnManager();
    }
     
     public Vector getoutletDetails(String no)
     {
         Vector<Vector<String>> outletDetailsVector = null;
	Connection dbConn = null;
        try{
        dbConn = (Connection) dbConnManager.connect();
        Statement stmt = dbConn.createStatement();
        String query = "SELECT * FROM sumisu.outletstock where proName like '"+no+"%';";
        ResultSet rs= stmt.executeQuery(query);
        outletDetailsVector = new Vector<Vector<String>>();
        while(rs.next())
        {
          Vector<String> outletDetails = new Vector<String>();
          outletDetails.add(rs.getString(1));
          outletDetails.add(rs.getString(2));
          outletDetails.add(rs.getString(3));
          outletDetails.add(rs.getString(6));
          outletDetails.add(rs.getString(5));
         
          
          outletDetailsVector.add(outletDetails);       
        }
        }
         catch(Exception ex)
        {
            System.out.println("-------- Select query fail. " + ex );
        }
        finally{
            dbConnManager.con_close(dbConn);
        }
       
         return outletDetailsVector;
     }
     
     public Vector getCartDetails()
     {
         Vector<Vector<String>> CartDetailsVector = null;
	Connection dbConn = null;
        try{
        dbConn = (Connection) dbConnManager.connect();
        Statement stmt = dbConn.createStatement();
        String query = "SELECT * FROM sumisu.cart;";
        ResultSet rs= stmt.executeQuery(query);
        CartDetailsVector = new Vector<Vector<String>>();
        /*"select c.itemId,  p.proName, c.qty,p.price\n" +
                       "from cart c,product p, outletcustomer oc\n" +
                       "where c.itemId=p.itemId and c.cusId=oc.cusId; "*/
        while(rs.next())
        {
          Vector<String> CartDetails = new Vector<String>();
          CartDetails.add(rs.getString(1));
          CartDetails.add(rs.getString(2));
          CartDetails.add(rs.getString(3));
          CartDetails.add(rs.getString(4));
          //CartDetails.add(rs.getString(5));
         
          
          CartDetailsVector.add(CartDetails);
          
        
        }
        }
         catch(Exception ex)
        {
            System.out.println("-------- Select query fail. " + ex );
        }
        finally{
            dbConnManager.con_close(dbConn);
        }
       
         return CartDetailsVector;
     }
     public boolean addOutletInvoice(float tot) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();
            Cal c= new Cal();


           //INSERT INTO `sumisu`.`outleinvoice` (`transactionType`, `description`, `transaction`) VALUES ('credit', 'sales', 'Outlet Sales');
            //INSERT INTO `sumisu`.`outleinvoice` (`transactionType`, `date`, `description`, `amount`, `transaction`) 
            //VALUES ('credit', '2014-9-29', 'sales', '1000', 'Outlet Sales');

            String query = "INSERT INTO `sumisu`.`outleinvoice` (`transactionType`, `date`, `description`, `amount`, `transaction`)  " +
                    "VALUES( 'Credit','" + c.getDate() + "','Sales','"+tot+"','Outlet Sales')";

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
     
         public boolean addOutletInvoiceProduct(int proId,String proName,int qty, String tid) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();
            


          //INSERT INTO `sumisu`.`outletinvoiceproduct` (`proId`, `proName`, `qty`, `transactionId1`) VALUES ('4', 'curry', '1', '2005');

            String query = "INSERT INTO `sumisu`.`outletinvoiceproduct` (`proId`, `proName`, `qty`, `transactionId1`) VALUES ('"+proId+"', '"+proName+"', '"+qty+"','"+tid+"');";

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
     
      public boolean deleteCart(String cartID) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = (Connection) dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


           
            //DELETE FROM `sumisu`.`cart` WHERE `cartId`='3' and`itemId`='3';cart where ID = "+id+" and Cust_ID = "+Cust_id;
            String query ="DELETE FROM `sumisu`.`cart` WHERE `cartId`='"+cartID+"'";

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
      
    public boolean updateCart(product p) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = (Connection) dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


           //sumisu.outletstock
            //update items set No_of_copies ="+(getNoofitems(id)+1)+" where ID = "+id;UPDATE `sumisu`.`product` SET `weight`='80g' WHERE `itemId`='1';;

            String query = "UPDATE `sumisu`.`outletstock` SET `qty`='"+(p.getQty()+1)+" WHERE `itemId`='"+p.getItemId()+"'";
                    

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
        //Update qty with last qty
       public boolean qtyInc(int qty,int id) { 

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = (Connection) dbConnManager.connect();
            
            
            Statement stmt = dbConn.createStatement();
            String query = "UPDATE `sumisu`.`outletstock` SET `qty`= `qty` + '"+qty+"' WHERE `itemId`='"+id+"';";
            
                    

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
       public boolean qtyDec(int qty,int id) {

        boolean result = false;
	Connection dbConn = null;
        qty = qty*(-1);//to -qty

        try {
            dbConn = (Connection) dbConnManager.connect();
            
            
            Statement stmt = dbConn.createStatement();
            String query = "UPDATE `sumisu`.`outletstock` SET `qty`= `qty` + '"+qty+"' WHERE `itemId`='"+id+"';";
            
                    

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
     
       
          public String getTransactionId(){

        String tId = "";
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "SELECT max(transactionId) from outleinvoice";

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()){
                tId = rs.getString(1);
                System.out.println(tId);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query Failed for JobCatId");

        }finally{
            dbConnManager.con_close(dbConn);
        }
        return tId;
    }
    
}
