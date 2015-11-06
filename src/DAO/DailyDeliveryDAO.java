/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import data.Cal;
import data.DBConnManager;
import data.DeliveryDetails;
import data.DeliveryReturnDetails;
import data.ProfitData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Lalin_000
 */
public class DailyDeliveryDAO {

    private DBConnManager dbConnManager = null;
    Cal cl = new Cal();

    public DailyDeliveryDAO() {

        dbConnManager = new DBConnManager();
    }

    public Vector getDailyDeliveryDetails() {

        Vector<Vector<String>> dailyDelDetailsVector = null;
        Connection dbConn = null;

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

    public Vector getDeliveryProductDetails(String no) {

        Vector<Vector<String>> DelProductDetailsVector = null;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM sumisu.delivery_products WHERE ddcid = " + no + " ;";

            ResultSet rs = stmt.executeQuery(query);
            DelProductDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> DelProductDetails = new Vector<String>();
                DelProductDetails.add(rs.getString(1));
                DelProductDetails.add(rs.getString(2));
                DelProductDetails.add(rs.getString(3));
                DelProductDetails.add(rs.getString(4));
                DelProductDetails.add(rs.getString(5));
                DelProductDetails.add(rs.getString(6));
                DelProductDetailsVector.add(DelProductDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return DelProductDetailsVector;
    }

    public Vector getDeliveryReturnDetails(String no) {

        Vector<Vector<String>> DelReturnDetailsVector = null;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM sumisu.delivery_products;";

            ResultSet rs = stmt.executeQuery(query);
            DelReturnDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> DelReturnDetails = new Vector<String>();
                DelReturnDetails.add(rs.getString(1));
                DelReturnDetails.add(rs.getString(2));
                DelReturnDetails.add(rs.getString(3));
                DelReturnDetailsVector.add(DelReturnDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return DelReturnDetailsVector;
    }//end of getDeliveryReturnDetails

    public ArrayList getProNames(String m) {

        ArrayList jobCatList = null;
        Connection dbConn = null;

        try {
            //Connect to th DB
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            //Select the JobCatNames
            String query = "SELECT DISTINCT proName FROM sumisu.product WHERE proName LIKE '" + m + "%';";

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            jobCatList = new ArrayList();

            while (rs.next()) {
                String catName = rs.getString(1);
                System.out.println(catName);
                jobCatList.add(catName);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed at JobCatNames");
        } finally {
            //Close the db connection
            dbConnManager.con_close(dbConn);
        }
        return jobCatList;
    } //end of getJobCategories

    public double getprice(int m) {

        Connection dbConn = null;
        double res = 0;

        try {
            //Connect to th DB
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            //Select the JobCatNames
            String query = "SELECT price FROM sumisu.product where itemId="+m+";";

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()){
                res = Double.parseDouble(rs.getString(1));
                System.out.println(res);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "  -----------Select query failed at get price ");
        } finally {
            //Close the db connection
            dbConnManager.con_close(dbConn);
        }
        return res;
    } //end of getJobCategories

    public boolean addSales(int qty, String vNo, int m) {
        boolean result = false;
        Connection dbConn = null;
        Cal cl = new Cal();
        double tot = getprice(m) * (double) qty;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "INSERT INTO profit(transactionType,date,description,amount,transaction)  "
                    + "VALUES( 'Debit','" + cl.getDate() + "','" + vNo + "'," + tot + ",'Deliver Sales');";

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

    public boolean updatetoStock(int stockId, int uqty) {
        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            //update querry
            String query = "UPDATE `sumisu`.`stock` SET `qty`= `qty` + '"+uqty+"' WHERE `stockId`='"+stockId+"';";

            System.out.println(query);

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } else {
                result = false;
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------update query failed");

            result = false;
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return result;
    }
    
    public boolean updatestatus(String status, int id) {
        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            //update querry
            String query = "UPDATE `sumisu`.`daily_delivery_chart` SET `status`='"+status+"' WHERE `ddcid`='"+id+"';";

            System.out.println(query);

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } else {
                result = false;
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------update query failed");

            result = false;
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return result;
    }
    
    public boolean addExpired(DeliveryReturnDetails r) {

        boolean result = false;
	Connection dbConn = null;
        Cal cl = new Cal();

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

           

            String query = "INSERT INTO `sumisu`.`expire_and_return_products` (`Rid`, `product_name`, `product_id`, `quantity`, `date`) VALUES ('"+r.getRid()+"', '"+r.getProuct_name()+"', '"+getPidByPname(r.getProuct_name())+"', '"+r.getQuantity()+"', '"+cl.getDate()+"');";

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
    
    public int getPidByPname(String id) {

       Connection dbConn = null;
        int res = 0;

        try {
            //Connect to th DB
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            //Select the JobCatNames
            String query = "SELECT itemId FROM sumisu.product where proName ='"+id+"';";

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()){
                res = Integer.parseInt(rs.getString(1));
                System.out.println(res);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "  -----------Select query failed at get price ");
        } finally {
            //Close the db connection
            dbConnManager.con_close(dbConn);
        }
        return res;
    }//end of getDeliveryReturnDetails
    
     public boolean updateQuantity(int qty, int ddid) {
        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            //update querry
            String query = "UPDATE `sumisu`.`delivery_products` SET `number_of_products`='"+qty+"' WHERE `ddid`='"+ddid+"';";

            System.out.println(query);

            int val = stmt.executeUpdate(query);

            if (val == 1) {
                result = true;
            } else {
                result = false;
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------update query failed");

            result = false;
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return result;
    }
     
     public boolean addVehiclesToDailyRoutine(String Vno,String route,String repId) {

        boolean result = false;
	Connection dbConn = null;
        Cal cl = new Cal();

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();
            Cal cl1 =new Cal();
           

            String query = "INSERT INTO `sumisu`.`daily_delivery_chart` (`date`, `Vno`, `repid`, `route`, `status`) VALUES ('"+cl1.getDate()+"', '"+Vno+"', '"+repId+"', '"+route+"', 'On Route');";

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
     
     public ArrayList getRepNames(){

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
            String query1 = "SELECT fname from employee where category = 'Sales Rep'";
            System.out.println(query1);
            ResultSet rs1 = stmt1.executeQuery(query1);
            
           Statement stmt2 = dbConn2.createStatement();
            String query2 = "SELECT lname from employee where category = 'Sales Rep'";
            System.out.println(query2);
            ResultSet rs2 = stmt2.executeQuery(query2);
            
            
            
            Statement stmt3 = dbConn3.createStatement();
            String query3 = "SELECT empid from employee where category = 'Sales Rep'";
            System.out.println(query3);
            ResultSet rs3 = stmt3.executeQuery(query3);

            nameList = new ArrayList();

            while (rs1.next()&& rs3.next()&& rs2.next()) {
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
     
     public boolean validateEntry(String rp, String vno){
        Cal cl = new Cal();
        int count = 1;
	Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "select count(ddcid)" +
                            " from sumisu.daily_delivery_chart" +
                            " where date = '"+cl.getDate()+"' AND (repid = '"+rp+"' or Vno = '"+vno+"')";

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
}

