/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import data.Cal;
import data.DBConnManager;
import data.DeliveryDetails;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Lalin_000
 */
public class DeliveryDAO {

    private DBConnManager dbConnManager = null;

    public DeliveryDAO() {

        dbConnManager = new DBConnManager();
    }

    //Start of getDeliveryDetails 
    public Vector getDeliveryDetails(String no) {

        Vector<Vector<String>> delDetailsVector = null;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM sumisu.deliveryvehicle where vno like '" + no + "%';";

            ResultSet rs = stmt.executeQuery(query);
            delDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> delDetails = new Vector<String>();
                delDetails.add(rs.getString(1));
                delDetails.add(rs.getString(2));
                delDetails.add(rs.getString(3));
                delDetails.add(rs.getString(4));
                delDetails.add(rs.getString(5));
                delDetails.add(rs.getString(6));
                delDetails.add(rs.getString(7));
                delDetails.add(rs.getString(8));
                delDetails.add(rs.getString(9));
                delDetailsVector.add(delDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return delDetailsVector;
    }//end of getDeliveryDetails 

    // Start of getMaintainDeliveryDetails
    public Vector getMaintainDeliveryDetails(String no) {

        Vector<Vector<String>> delDetailsVector = null;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT vId , vno FROM sumisu.deliveryvehicle where vno like '" + no + "%';";

            ResultSet rs = stmt.executeQuery(query);
            delDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> delDetails = new Vector<String>();
                delDetails.add(rs.getString(1));
                delDetails.add(rs.getString(2));
//              delDetails.add(rs.getString(3)); 
//              delDetails.add(rs.getString(4)); 
                delDetailsVector.add(delDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return delDetailsVector;
    }//end of getMaintainDeliveryDetails 
    
    //Start of add new Vehical
    public boolean addDeliveryVehical(DeliveryDetails d) {

        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "INSERT INTO `sumisu`.`deliveryvehicle` (`vNo`, `vType`, `fuelType`, `Mrent`, `LInsureDate`, `InsExpDate`, `LicenDate`, `LicenExpDate`) VALUES ('" + d.getvNo() + "', '" + d.getvType() + "', '" + d.getfType() + "', '" + d.getmRent() + "', '" + d.getlInDate() + "', '" + d.getInsExpDate() + "', '" + d.getLlicenDate() + "', '" + d.getLicenExpDate() + "');";

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
    }//end of addNewVehicle

    //Start of update Vehical
    public boolean updateDeliveryVehical(DeliveryDetails d) {

        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "UPDATE `sumisu`.`deliveryvehicle` SET `vType`='" + d.getvType() + "', `fuelType`='" + d.getfType() + "', `Mrent`='" + d.getmRent() + "', `LInsureDate`='" + d.getLlicenDate() + "', `InsExpDate`='" + d.getInsExpDate() + "', `LicenDate`='" + d.getLlicenDate() + "', `LicenExpDate`='" + d.getLicenExpDate() + "' WHERE `vNo`='" + d.getvNo() + "';";

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
    }//end of Update

    
    public boolean addMaintainVehical(DeliveryDetails d) {

        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "INSERT INTO `sumisu`.`deliverymaintain` (`vNo`, `amount`, `MaintainDate`, `description`) VALUES ('" + d.getvNo() + "', '" + d.getAmount() + "', '" + d.getMaintainDate() + "', '" + d.getDescription() + "');";

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
    }//end of add maintain

    public boolean DeleteDeliveryVehical(String vId, String vno) {

        boolean result = false;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            String query = "DELETE FROM `sumisu`.`deliveryvehicle` WHERE `vId`='" + vId + "' and`vNo`='" + vno + "';";

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
    }//end of delete vehicle

}
