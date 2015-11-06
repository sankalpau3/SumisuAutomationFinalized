/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author ChanaPC
 */
public class PayrollDetails {
    
    private int empID;
    private String empName;
    private int basicSal;
    private int allowAmount;
    private String allowDes;
    private int deducAmount;
    private int Bonus;

    
    private String deducDes;
    private String adate;
    private String attendtime;
    private String leavetime;

    public PayrollDetails() {
    }
    

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getBasicSal() {
        return basicSal;
    }

    public void setBasicSal(int basicSal) {
        this.basicSal = basicSal;
    }

    public int getAllowAmount() {
        return allowAmount;
    }

    public void setAllowAmount(int allowAmount) {
        this.allowAmount = allowAmount;
    }

    public String getAllowDes() {
        return allowDes;
    }

    public void setAllowDes(String allowDes) {
        this.allowDes = allowDes;
    }

    public int getDeducAmount() {
        return deducAmount;
    }

    public void setDeducAmount(int deducAmount) {
        this.deducAmount = deducAmount;
    }

    public String getDeducDes() {
        return deducDes;
    }

    public void setDeducDes(String deducDes) {
        this.deducDes = deducDes;
    }

    public String getAttendtime() {
        return attendtime;
    }

    public void setAttendtime(String attendtime) {
        this.attendtime = attendtime;
    }

    public String getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(String leavetime) {
        this.leavetime = leavetime;
    }
    
    public int getBonus() {
        return Bonus;
    }

    public void setBonus(int Bonus) {
        this.Bonus = Bonus;
    }
    
    
    
}
