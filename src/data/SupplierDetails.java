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
public class SupplierDetails {
    private int supId;
    private int accNo;
    private String fname;
    private String lname;
    private String addr;
    String email;
    int phone; 

    public SupplierDetails(int accNo, String fname, String lname, String addr, String email, int phone) {
        
        this.accNo = accNo;
        this.fname = fname;
        this.lname = lname;
        this.addr = addr;
        this.email = email;
        this.phone = phone;
    }

    public SupplierDetails() {
    }

    public int getSupId() {
        return supId;
    }

    public void setSupId(int supId) {
        this.supId = supId;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

}
