/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author nobilitynobility
 */
public class OutletCustomer {
    private int cusId;
    private String fname;
    private String lname;
    private String address;
    private String email;
    private String phone;
    private String startDate;

  
    public OutletCustomer(String fname, String lname, String address, String email,String phone) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.email = email;
        this.phone = phone;
        Cal c = new Cal();
        this.startDate = c.getDate();
    }

    public OutletCustomer() {
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

   
    
    
}
