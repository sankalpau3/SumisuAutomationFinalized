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
public class DeliveryDetails {
    private int vId;
    private String vNo;
    private float mRent = 0;
    private String vType;
    private String fType;
    private String lInDate;
    private String InsExpDate;
    private String LlicenDate;
    private String licenExpDate;
    private String MaintainDate;
    private float amount;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    private String description;

    public DeliveryDetails(int vId, String vNo, String vType, String fType, String lInDate, String InsExpDate, String LlicenDate, String licenExpDate, String MaintainDate, String amount, String description) {
        this.vId = vId;
        this.vNo = vNo;
        this.vType = vType;
        this.fType = fType;
        this.lInDate = lInDate;
        this.InsExpDate = InsExpDate;
        this.LlicenDate = LlicenDate;
        this.licenExpDate = licenExpDate;
        this.MaintainDate = MaintainDate;
       // this.amount = amount;
        this.description = description;
    } 
    
    public DeliveryDetails() {
    }

    public int getvId() {
        return vId;
    }

    public void setvId(int vId) {
        this.vId = vId;
    }

    public String getvNo() {
        return vNo;
    }

    public void setvNo(String vNo) {
        this.vNo = vNo;
    }

    public float getmRent() {
        return mRent;
    }

    public void setmRent(float mRent) {
        this.mRent = mRent;
    }

    public String getvType() {
        return vType;
    }

    public void setvType(String vType) {
        this.vType = vType;
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType;
    }

    public String getlInDate() {
        return lInDate;
    }

    public void setlInDate(String lInDate) {
        this.lInDate = lInDate;
    }

    public String getInsExpDate() {
        return InsExpDate;
    }

    public void setInsExpDate(String InsExpDate) {
        this.InsExpDate = InsExpDate;
    }

    public String getLlicenDate() {
        return LlicenDate;
    }

    public void setLlicenDate(String LlicenDate) {
        this.LlicenDate = LlicenDate;
    }

    public String getLicenExpDate() {
        return licenExpDate;
    }

    public void setLicenExpDate(String licenExpDate) {
        this.licenExpDate = licenExpDate;
    }

     public String getMaintainDate() {
        return MaintainDate;
    }

    public void setMaintainDate(String MaintainDate) {
        this.MaintainDate = MaintainDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
    
    
    
}
