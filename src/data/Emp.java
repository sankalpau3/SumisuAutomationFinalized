/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author Dell
 */
public class Emp {
    
    private int empId;
    private String fName;
    private String lName;
    private String address;
    private String phone;
    private String bod;
    private String gender;
    private String nic;
    private int accNo;
    private boolean civilStatus;
    private String sDate;
    private int bSal;
    private int allowances;
    private int otHrs;
    private int bonus;
    private int mobile;
    private String email;
    private String catagory;
    private String section;
    Cal c = new Cal();

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBod() {
        return bod;
    }

    public void setBod(String bod) {
        this.bod = bod;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public boolean isCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(boolean civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public int getbSal() {
        return bSal;
    }

    public void setbSal(int bSal) {
        this.bSal = bSal;
    }

    public int getAllowances() {
        return allowances;
    }

    public void setAllowances(int allowances) {
        this.allowances = allowances;
    }

    public int getOtHrs() {
        return otHrs;
    }

    public void setOtHrs(int otHrs) {
        this.otHrs = otHrs;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
    
    
    
    
    public Emp(String fName, String lName, String address, String phone, String bod, String gender, String nic, int accNo, boolean civilStatus, String sDate, int bSal, int allowances, int otHrs, int bonus) {
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.phone = phone;
        this.bod = bod;
        this.gender = gender;
        this.nic = nic;
        this.accNo = accNo;
        this.civilStatus = civilStatus;
        this.sDate = sDate;
        this.bSal = bSal;
        this.allowances = allowances;
        this.otHrs = otHrs;
        this.bonus = bonus;
    }

    public Emp() 
    {
        this.sDate = c.getDate();
        this.bod = c.getDate();
    }


    
    
    
}
