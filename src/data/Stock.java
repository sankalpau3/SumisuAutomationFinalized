/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author DELL
 */
public class Stock {
    
    private int stockId;
    private String manDate;
    private String expDate;
    private int qty;

    public int getStockId() {
        return stockId;
    }

    public String getManDate() {
        return manDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public int getQty() {
        return qty;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public void setManDate(String manDate) {
        this.manDate = manDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    
    public Stock (int stockId, String manDate, String expDate, int qty) 
  {
        this.stockId = stockId;
        this.manDate= manDate;
        this.expDate = expDate;
        this.qty = qty;
       
        
    }
    
    
    
    
    
    
}
