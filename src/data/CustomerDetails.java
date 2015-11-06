/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author JAYAMINI
 */
public class CustomerDetails {
     private String fname;
     private String lname;
     private String email;
     private String address;
     private String phone;
     private String startDate;
     private int cusId ;

    public CustomerDetails(String fname, String lname, String email, String address, String phone) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

   

    //default constructor
    public CustomerDetails() {
    }

  
    public CustomerDetails(String fname, String lname, String email, String address, String phone, String StartDate, int cusId) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.startDate = StartDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }
    
}
