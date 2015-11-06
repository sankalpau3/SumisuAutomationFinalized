/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import data.DBConnManager;
import data.product;
import java.sql.*;
import java.util.*;


public class ProductDetailsDAO 
{
    

private DBConnManager dbConnManager = null;
    
    public ProductDetailsDAO()
    {
        dbConnManager = new DBConnManager();
    }


 public Vector getProductDetails() {

        Vector<Vector<String>> ProductDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            
            String query = "SELECT * FROM sumisu.product";

            ResultSet rs = stmt.executeQuery(query);
            ProductDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> ProductDetails = new Vector<String>();//initialize vector
                ProductDetails.add(rs.getString(1)); 
                ProductDetails.add(rs.getString(2)); 
                ProductDetails.add(rs.getString(3)); 
                ProductDetails.add(rs.getString(4)); 
                ProductDetails.add(rs.getString(5)); 
                ProductDetails.add(rs.getString(6));
                ProductDetailsVector.add(ProductDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return ProductDetailsVector;
    }
 
 public String getUpdateDetails(int proId)
 {
     String data="";
     Connection dbConn = null;
     
     try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT proName , price , ingredient , qty , weight "+
                    "FROM product where ItemId ="+proId+" ";

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
 
 
 
 
 
 
 
 

    public boolean getProductDetails(String Query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    



 public boolean addProduct(int ItemId, String ProName, double price, String ingredient, String qty, double weight ) {

        boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();//create connection

            Statement stmt = dbConn.createStatement();


            String query = "INSERT INTO product(itemId , proName , price , ingredient , qty , weight)  " +
                    "VALUES( "+ItemId+",'"+ProName + "'," +price +",'" +ingredient + "'," +qty+ "," + weight+ ")" ;
            
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
        }
        finally{ 
            dbConnManager.con_close(dbConn); //to close the db connection
        }        
        return result;
    }
 
 public boolean updateProduct(int proId,String proName,double pri,String ingred,String qty,double wei)
 {
     boolean result = false;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

           //update querry
            String query = "UPDATE sumisu.product set proName ='"+proName+"', price="+pri+", ingredient='"+ingred+"', qty='"+qty+"', weight="+wei+" where itemId="+proId+"" ;
            
            
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
 
 public boolean removeProduct(int proId)
 {
     boolean result = false;// bool variable is created and decalard as false
     Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();//create connction

            Statement stmt = dbConn.createStatement();//query execute karanne meken

           //update querry
            String query = "DELETE FROM `sumisu`.`product` WHERE itemId = "+proId+"" ;
            
            
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
 
 public int getMaxProId()
    {
        int id=0    ;
        Connection dbConn = null;
     
     try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "select max(itemid)+1 itemid from sumisu.product" ;

            ResultSet rs = stmt.executeQuery(query); //to store db values(db query's values)
           
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
 
 public Vector searchProductDetails(String proN) {

        Vector<Vector<String>> ProductDetailsVector = null;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            //String query = "SELECT itemId , proName , price , ingredient , qty , weight "+
                  //  "FROM product";
            String query = "select * from sumisu.product where proName like '"+proN+"%'";

            ResultSet rs = stmt.executeQuery(query);
            ProductDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> ProductDetails = new Vector<String>();
                ProductDetails.add(rs.getString(1)); 
                ProductDetails.add(rs.getString(2)); 
                ProductDetails.add(rs.getString(3)); 
                ProductDetails.add(rs.getString(4)); 
                ProductDetails.add(rs.getString(5)); 
                ProductDetails.add(rs.getString(6));
                ProductDetailsVector.add(ProductDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return ProductDetailsVector;
    }
    
    
}