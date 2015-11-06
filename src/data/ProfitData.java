/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author sanke
 */
public class ProfitData {
    private double amount;
    private String systemDate;
    private String addedDate;
    private String discription;
    private String transType;
    private String transMode;
    private int transId;

    public ProfitData() {
    }
    

    public ProfitData(double amount, String systemDate, String addedDate, String discription, String transType, String transMode, int transId) {
        this.amount = amount;
        this.systemDate = systemDate;
        this.addedDate = addedDate;
        this.discription = discription;
        this.transType = transType;
        this.transMode = transMode;
        this.transId = transId;
    }

   
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
  
    public String getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(String systemDate) {
        this.systemDate = systemDate;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

 
    public String getDiscription() {
        return discription;
    }

    
    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getTransType() {
        return transType;
    }

   
    public void setTransType(String transType) {
        this.transType = transType;
    }

   
    public String getTransMode() {
        return transMode;
    }

    public void setTransMode(String transMode) {
        this.transMode = transMode;
    }
    public int gettransId() {
        return transId;
    }

    public void settransId(int transId) {
        this.transId = transId;
    }
    
    
    
}
