/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import data.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author sanke
 */
public class ProfitDAO {

    private DBConnManager dbConnManager = null;

    public ProfitDAO() {
        dbConnManager = new DBConnManager();
    }

    public Vector getProfit() {

        Vector<Vector<String>> profitVector = null;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * from profit";

            ResultSet rs = stmt.executeQuery(query);
            profitVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> profitDetails = new Vector<String>();
                profitDetails.add(rs.getString(1)); //transactionID
                profitDetails.add(rs.getString(2)); //transaction type
                profitDetails.add(rs.getString(3)); //date
                profitDetails.add(rs.getString(4)); //discription
                profitDetails.add(rs.getString(5)); //amount
                profitDetails.add(rs.getString(6)); //transaction
                profitVector.add(profitDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return profitVector;
    }//End of getProfit

    public Vector getProfitFiltered(String date, String transactionType, String transaction) {

        Vector<Vector<String>> profitVector = null;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * from profit" +
                    " where date like '" + date + "%' and transactionType like '"+transactionType+"%' and transaction like '%"+transaction+"%'";

            ResultSet rs = stmt.executeQuery(query);
            profitVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> profitDetails = new Vector<String>();
                profitDetails.add(rs.getString(1)); //transactionID
                profitDetails.add(rs.getString(2)); //transaction type
                profitDetails.add(rs.getString(3)); //date
                profitDetails.add(rs.getString(4)); //discription
                profitDetails.add(rs.getString(5)); //amount
                profitDetails.add(rs.getString(6)); //transaction
                profitVector.add(profitDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return profitVector;
    }//End of getProfit
    
    


    public boolean addTrans(ProfitData d) {
        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "INSERT INTO profit(transactionType,date,description,amount,transaction)  "
                    + "VALUES( '" + d.getTransType() + "','" + d.getSystemDate() + "','" + d.getDiscription() + "'," + d.getAmount() + ",'" + d.getTransMode() + "')";

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

    public boolean updateTrans(ProfitData d) {
        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "UPDATE `sumisu`.`profit` SET `transactionType`='" + d.getTransType() + "', `description`='" + d.getDiscription() + "', `amount`='" + d.getAmount() + "', `transaction`='" + d.getTransMode() + "' WHERE `transactionId`='" + d.gettransId() + "'";

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
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return result;

    }//end of updateTransaction

    public boolean removeTransactio(ProfitData d) {
        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "DELETE FROM `sumisu`.`profit` WHERE `transactionId`='" + d.gettransId() + "';";

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
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return result;

    }
    
    public ArrayList getTansactionModes(){

        ArrayList MyArr = null;
	Connection dbConn = null;

        try{
            //Connect to th DB
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            //Select the JobCatNames
            String query = "SELECT DISTINCT `transaction` FROM `sumisu`.`profit`";

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            MyArr = new ArrayList();

            while (rs.next()) {
                String catName = rs.getString(1);
                System.out.println(catName);
                MyArr.add(catName);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed at JobCatNames");
        }finally{
            //Close the db connection
            dbConnManager.con_close(dbConn);
        }
        return MyArr;
    } //end of getJobCategories
    
     public ArrayList getTansactionType(String mode){

        ArrayList MyArr = null;
	Connection dbConn = null;

        try{
            //Connect to th DB
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            //Select the JobCatNames
            String query = "SELECT DISTINCT `transaction` FROM `sumisu`.`profit` where transactionType = '"+mode+"'";

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            MyArr = new ArrayList();

            while (rs.next()) {
                String catName = rs.getString(1);
                System.out.println(catName);
                MyArr.add(catName);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed at JobCatNames");
        }finally{
            //Close the db connection
            dbConnManager.con_close(dbConn);
        }
        return MyArr;
    } //end of getJobCategories

}
