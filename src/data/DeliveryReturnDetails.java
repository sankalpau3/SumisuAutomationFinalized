/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author Lalin_000
 */
public class DeliveryReturnDetails {
    
    private int Rid;
    private int Quantity;
    private String prouct_name;
    private String product_id;

    public DeliveryReturnDetails(int Rid, int Quantity, String prouct_name, String product_id) {
        this.Rid = Rid;
        this.Quantity = Quantity;
        this.prouct_name = prouct_name;
        this.product_id = product_id;
    }

    public DeliveryReturnDetails() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public int getRid() {
        return Rid;
    }

    public void setRid(int Rid) {
        this.Rid = Rid;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getProuct_name() {
        return prouct_name;
    }

    public void setProuct_name(String prouct_name) {
        this.prouct_name = prouct_name;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
    
    
}
