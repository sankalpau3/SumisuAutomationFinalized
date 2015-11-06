/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import data.Cal;
import data.DBConnManager;
import data.Stock;
import java.sql.*;
import java.util.*;


public class StockDetailsDAO
{
    

private DBConnManager dbConnManager = null;
    
    public StockDetailsDAO()
    {
        dbConnManager = new DBConnManager();
    }


 public Vector getStockDetails() {

        Vector<Vector<String>> StockDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM sumisu.stock";

            ResultSet rs = stmt.executeQuery(query);
            StockDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String>  StockDetails = new Vector<String>();
                StockDetails.add(rs.getString(1)); 
                StockDetails.add(rs.getString(2)); 
                StockDetails.add(rs.getString(3)); 
                StockDetails.add(rs.getString(4)); 
                StockDetails.add(rs.getString(5)); 
                StockDetailsVector.add(StockDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return StockDetailsVector;
    }
 
 public Vector getStockDetails(int productid) {

        Vector<Vector<String>> StockDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM sumisu.stock where proId = "+productid+"";

            ResultSet rs = stmt.executeQuery(query);
            StockDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String>  StockDetails = new Vector<String>();
                StockDetails.add(rs.getString(1)); 
                StockDetails.add(rs.getString(2)); 
                StockDetails.add(rs.getString(3)); 
                StockDetails.add(rs.getString(4)); 
                StockDetails.add(rs.getString(5)); 
                StockDetailsVector.add(StockDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return StockDetailsVector;
    }
 
 public String getUpdateDetails(int stockId)
 {
     String data="";
     Connection dbConn = null;
     
     try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT StockId , ManDate , Expdate ,Qty "+
                    "FROM stock where StockId ="+stockId+" ";

            ResultSet rs = stmt.executeQuery(query);
          

            while (rs.next()) {
                
                for(int i=1;i<7;i++)
                {
                    data = data+rs.getString(i)+",";
                }
               
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
     
     
     
     return data;
 }
 
 public int getMaxStockId()
    {
        int id=0    ;
        Connection dbConn = null;
     
     try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "select max(stockId)+1 stockId from sumisu.stock" ;

            ResultSet rs = stmt.executeQuery(query);
           
          while (rs.next()) 
        {
            id = rs.getInt(1);
        }
          

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        
     return id;
        
    }
 

 public boolean addStock(int stockId, String manDate, String expDate, int qty,int proId) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


            String query = "INSERT INTO `sumisu`.`stock` (`stockId`, `manDate`, `expDate`, `qty`, `proId`) VALUES ("+stockId+", '"+manDate+"', '"+expDate+"',"+qty+", "+proId+")";
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } 
                else 
                {
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
 
 public boolean updateStock(int stockId,String manDate,String expDate,int uqty)
 {
     boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

           //update querry
            String query = "UPDATE sumisu.stock set manDate ='"+manDate+"', expDate='"+expDate+"', qty=qty-"+uqty+" where stockId="+stockId+"" ;
             
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } 
                else 
                {
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
 
 public boolean removeStock(int stockId)
 {
     boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

           //update querry
            String query = "DELETE FROM `sumisu`.`stock` WHERE stockId = "+stockId+"" ;
            
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } 
                else 
                {
                result = false;
                }           

        } catch (SQLException sQLException) {
            System.out.println(sQLException );

            result = false;
        }finally{
            dbConnManager.con_close(dbConn);
        }        
        return result;
     
 }
 public boolean updateProduct_incQty(int proId,int qty)
 {
     boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

           //update querry
            String query = "UPDATE sumisu.product set qty= qty + "+qty+" where itemId="+proId+"" ;
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } 
                else 
                {
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
 public boolean updateProduct_decQty(int proId,int qty)
 {
     boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

           //update querry
            String query = "UPDATE sumisu.product set qty= qty -"+qty+" where itemId="+proId+"" ;
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } 
                else 
                {
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
 
 public Vector getDailyDeliveryDetails() {

        Vector<Vector<String>> dailyDelDetailsVector = null;
        Connection dbConn = null;
        Cal cl = new Cal();

        try {
            
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            System.out.println(cl.getDate());
            
            
            String query = "SELECT * FROM sumisu.daily_delivery_chart WHERE date LIKE '" + cl.getDate() + "';";

            ResultSet rs = stmt.executeQuery(query);
            dailyDelDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> dailyDelDetails = new Vector<String>();
                dailyDelDetails.add(rs.getString(1));
                dailyDelDetails.add(rs.getString(2));
                dailyDelDetails.add(rs.getString(3));
                dailyDelDetails.add(rs.getString(4));
                dailyDelDetails.add(rs.getString(5));
                dailyDelDetails.add(rs.getString(6));
                dailyDelDetailsVector.add(dailyDelDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return dailyDelDetailsVector;
    }

    public boolean addToOutlet(int ItemId, String ProName, double price, String ingredient, String qty, double weight) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


            String query = "INSERT INTO `sumisu`.`outletstock` (itemId , proName , price , ingredient , qty , weight)"
                    + " VALUES ("+ItemId+",'"+ProName + "'," +price +",'" +ingredient + "'," +qty+ "," + weight+ ")";
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } 
                else 
                {
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
    
    
    
    public boolean updateSendproQty(int proId,int qty)
 {
     boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

           //update querry
            String query = "UPDATE sumisu.product set qty= qty -"+qty+" where itemId="+proId+"" ;
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } 
                else 
                {
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
    
    public boolean updateSendStockQty(int stockId,int uqty)
 {
     boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

           //update querry
            String query = "UPDATE sumisu.stock set qty=qty-"+uqty+" where stockId="+stockId+"" ;
             
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } 
                else 
                {
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
    
public boolean checkoutlet(int itemid)
    {
        boolean outletcheck = false;
        Connection dbConn = null;
     
     try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "select * from sumisu.outletstock where itemId = "+itemid+"" ;

            ResultSet rs = stmt.executeQuery(query);
           
          while (rs.next()) 
        {
            outletcheck = true;
        }
          

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        
     return outletcheck;
        
    } 
public boolean updateOutletStock(int itemid,int outQty)
 {
     boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

           //update querry
            String query = "UPDATE sumisu.outletstock set qty =qty+"+outQty+" where itemID="+itemid+"" ;
       

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } 
                else 
                {
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

public ArrayList getdeliveryDetails(){

        ArrayList deliveryDetails = null;
	Connection dbConn = null;
        
        try{
            //Connect to th DB
            dbConn = dbConnManager.connect();
            
            Statement stmt = dbConn.createStatement();

            
            String query = "SELECT ddcid,Vno FROM sumisu.daily_delivery_chart where date = curdate() ";

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            deliveryDetails = new ArrayList();

            while (rs.next()) {
                String delDetails = rs.getString(2)+" "+ rs.getInt(1);
                System.out.println(delDetails);
                deliveryDetails.add(delDetails);
            }

        } catch (SQLException sQLException) {
            
        }finally{
            //Close the db connection
            dbConnManager.con_close(dbConn);
        }
        return deliveryDetails;
    }


public boolean addVehicleDeli(int ddcid, String product_name, String product_id, int number_of_products, int stockId) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();


String query = "INSERT INTO `sumisu`.`delivery_products`(`ddcid`,`prouct_name`,`product_id`,`number_of_products`,`stockId`)"
                    + " VALUES ("+ddcid+",'"+product_name + "','" +product_id+"'," +number_of_products + "," +stockId+")";
            
            System.out.println(query);

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } 
                else 
                {
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
    


    
    
    
    
    
}