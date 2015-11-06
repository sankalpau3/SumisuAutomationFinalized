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
public class TaxData {
    
    private int invoiceNO;
    private String date;
    private String type;
    private float amount;
    private String quartile;
    private String discript;
    private int taxId;

    public TaxData() {
    }

    public TaxData(int invoiceNO, String date, String type, float amount, String quartile, String discript) {
        this.invoiceNO = invoiceNO;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.quartile = quartile;
        this.discript = discript;
    }

    public int getTaxId() {
        return taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }
    

    public int getInvoiceNO() {
        return invoiceNO;
    }

    public void setInvoiceNO(int invoiceNO) {
        this.invoiceNO = invoiceNO;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getQuartile() {
        return quartile;
    }

    public void setQuartile(String quartile) {
        this.quartile = quartile;
    }

    public String getDiscript() {
        return discript;
    }

    public void setDiscript(String discript) {
        this.discript = discript;
    }
    
    
    
    
}
