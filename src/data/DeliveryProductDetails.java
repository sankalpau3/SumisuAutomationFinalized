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
public class DeliveryProductDetails {
    
    private int ddcid;
    private int ddid;
    private String prouct_name;
    private String product_id;
    private int No_of_products;

    public DeliveryProductDetails(int ddcid, int ddid, String prouct_name, String product_id, int NoOfProducts) {
        this.ddcid = ddcid;
        this.ddid = ddid;
        this.prouct_name = prouct_name;
        this.product_id = product_id;
        this.No_of_products = NoOfProducts;
    }

    public int getDdcid() {
        return ddcid;
    }

    public void setDdcid(int ddcid) {
        this.ddcid = ddcid;
    }

    public int getDdid() {
        return ddid;
    }

    public void setDdid(int ddid) {
        this.ddid = ddid;
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

    public int getNoOfProducts() {
        return No_of_products;
    }

    public void setNoOfProducts(int NoOfProducts) {
        this.No_of_products = NoOfProducts;
    }
    
    
}
