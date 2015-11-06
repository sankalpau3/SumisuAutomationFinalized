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
public class LoanDetails {
    private int ID;
    private double amount;
    private String date;
    private String duration;
    private String discription;
    private String finaceName;
    private String branch;
    private String LastPayDate;
    private double rate;
    private int accNo;
    private int Noinstallments;
    private int NO_of_ins;
    private float Min_ins;

    
    

   

        public LoanDetails( double amount, String date, String duration, String discription, double rate, int accNo, String finaceName, String branch) {
        
        this.amount = amount;
        this.date = date;
        this.duration = duration;
        this.discription = discription;
        this.rate = rate;
        this.accNo = accNo;
        this.finaceName =  finaceName;
        this.branch =  branch;
    }

    public LoanDetails(int ID, double amount, String date, String duration, String discription, String finaceName, String branch, String LastPayDate, double rate, int accNo, int Noinstallments, int NO_of_ins, float Min_ins) {
        this.ID = ID;
        this.amount = amount;
        this.date = date;
        this.duration = duration;
        this.discription = discription;
        this.finaceName = finaceName;
        this.branch = branch;
        this.LastPayDate = LastPayDate;
        this.rate = rate;
        this.accNo = accNo;
        this.Noinstallments = Noinstallments;
        this.NO_of_ins = NO_of_ins;
        this.Min_ins = Min_ins;
    }
        
        
        public int getNO_of_ins() {
        return NO_of_ins;
    }

    public void setNO_of_ins(int NO_of_ins) {
        this.NO_of_ins = NO_of_ins;
    }

    public float getMin_ins() {
        return Min_ins;
    }

    public void setMin_ins(float Min_ins) {
        this.Min_ins = Min_ins;
    }

    public String getLastPayDate() {
        return LastPayDate;
    }

    public void setLastPayDate(String LastPayDate) {
        this.LastPayDate = LastPayDate;
    }

    public int getNoinstallments() {
        return Noinstallments;
    }

    public void setNoinstallments(int Noinstallments) {
        this.Noinstallments = Noinstallments;
    }
        
    
     public String getFinaceName() {
        return finaceName;
    }

    public void setFinaceName(String finaceName) {
        this.finaceName = finaceName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public LoanDetails() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }
    
    
    
}
