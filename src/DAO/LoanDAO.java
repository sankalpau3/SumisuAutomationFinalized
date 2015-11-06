/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import data.DBConnManager;
import data.LoanDetails;
import data.ProfitData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author sanke
 */
public class LoanDAO {

    private DBConnManager dbConnManager = null;

    public LoanDAO() {
        dbConnManager = new DBConnManager();
    }

    public boolean addTrans(LoanDetails d) {
        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "INSERT INTO `sumisu`.`loan` (`amount`, `date`, `duration`, `description`, `rate`, `acc_No`, `financeName`, `branch`, `no_of_installment`, `min_installment`) "
                    + "VALUES ('" + d.getAmount() + "', '" + d.getDate() + "', '" + d.getDuration() + "', "
                    + "'" + d.getDiscription() + "', '" + d.getRate() + "', '" + d.getAccNo() + "', '" + d.getFinaceName() + "', '" + d.getBranch() + "' , '" + d.getNO_of_ins() + "' , '" + d.getMin_ins() + "');";

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

    public Vector getLoan() {

        Vector<Vector<String>> profitVector = null;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM sumisu.loan;";

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
                profitDetails.add(rs.getString(7)); //transaction
                profitDetails.add(rs.getString(8)); //transaction
                profitDetails.add(rs.getString(9)); //transaction
                profitDetails.add(rs.getString(10)); //transaction
                profitDetails.add(rs.getString(11)); //transaction
                profitDetails.add(rs.getString(12));
                profitDetails.add(rs.getString(13));
                profitVector.add(profitDetails);

            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return profitVector;
    }//End of getProfit

    public Vector getLoanFromID(int ID) {

        Vector<Vector<String>> profitVector = null;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM sumisu.loan where loanID = " + ID + ";";

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
                profitDetails.add(rs.getString(7)); //transaction
                profitDetails.add(rs.getString(8)); //transaction
                profitDetails.add(rs.getString(9)); //transaction
                profitDetails.add(rs.getString(10)); //transaction
                profitDetails.add(rs.getString(11)); //transaction
                profitDetails.add(rs.getString(12)); //transaction
                profitDetails.add(rs.getString(13)); //transaction
                profitVector.add(profitDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return profitVector;
    }//End of getProfit     

    public boolean addInstallment(LoanDetails d) {
        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "UPDATE `sumisu`.`loan` SET `installmentpayed`='" + d.getNoinstallments() + "', `dateLastpaid`='" + d.getLastPayDate() + "' WHERE `loanID`='" + d.getID() + "';";

            System.out.println(query);

            int val = stmt.executeUpdate(query);
            query = "INSERT INTO `sumisu`.`loan_installments` (`Instalamtl`, `InstallMentDate`, `Loan_ID`) VALUES ('" + d.getAmount() + "', '" + d.getLastPayDate() + "', '" + d.getID() + "');";
            int val2 = stmt.executeUpdate(query);
            if (val == 1 && val2 == 1) {
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

    }//end of addInstallment

    public Vector getLoanHistory(int ID) {

        Vector<Vector<String>> profitVector = null;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM sumisu.loan_installments WHERE Loan_ID = " + ID + ";";

            ResultSet rs = stmt.executeQuery(query);
            profitVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> profitDetails = new Vector<String>();

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
    }//End of getLoan History

    public Vector getLoanFromIDLess() {

        Vector<Vector<String>> profitVector = null;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM sumisu.loan;";

            ResultSet rs = stmt.executeQuery(query);
            profitVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> profitDetails = new Vector<String>();
                profitDetails.add(rs.getString(1)); //transactionID
                profitDetails.add(rs.getString(2)); //transaction type
                profitDetails.add(rs.getString(7)); //transaction
                profitDetails.add(rs.getString(8)); //transaction
                profitDetails.add(rs.getString(9)); //transaction
                profitVector.add(profitDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return profitVector;
    }//End of getLoanFromIDLess     

    public boolean updateLoan(LoanDetails d) {
        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "UPDATE `sumisu`.`loan` SET `amount`='" + d.getAmount() + "', `date`='" + d.getDate() + "', `duration`='" + d.getDuration() + "',"
                    + " `description`='" + d.getDiscription() + "', `rate`='" + d.getRate() + "', `acc_No`='" + d.getAccNo() + "',"
                    + " `financeName`='" + d.getFinaceName() + "', `branch`='" + d.getBranch() + "', `installmentpayed`= `installmentpayed`,"
                    + " `dateLastpaid`= `dateLastpaid`, `no_of_installment`='" + d.getNO_of_ins() + "',"
                    + " `min_installment`='" + d.getMin_ins() + "' WHERE `loanID`='" + d.getID() + "';";
            System.out.println(d.getNO_of_ins());
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

    }//end of updateLoan

}
