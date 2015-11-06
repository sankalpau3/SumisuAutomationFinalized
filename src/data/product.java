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
public class product 
{
    
    private int itemId;
    private String proName;
    private String price;
    private String ingredient;
    private int qty;
    private String weight;
public product() {
    }
    public int getItemId() {
        return itemId;
    }

    public String getProName() {
        return proName;
    }

    public String getPrice() {
        return price;
    }

    public String getIngredient() {
        return ingredient;
    }

    public int getQty() {
        return qty;
    }

    public String getWeight() {
        return weight;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    
    
    


  
 
 
 
  public product (int itemId, String proName, String price, String ingredient, int qty, String weight) 
  {
        this.itemId = itemId;
        this.proName= proName;
        this.price = price;
        this.ingredient = ingredient;
        this.qty = qty;
        this.weight = weight;
        
    }
}