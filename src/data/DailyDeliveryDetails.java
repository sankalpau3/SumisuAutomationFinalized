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
public class DailyDeliveryDetails {

    private int ddcid;
    private String date;
    private String Vno;
    private int repid;
    private String route;
    private String status;

    public DailyDeliveryDetails(int ddcid, String date, String Vno, int repid, String route, String status) {
        this.ddcid = ddcid;
        this.date = date;
        this.Vno = Vno;
        this.repid = repid;
        this.route = route;
        this.status = status;
    }

    public int getDdcid() {
        return ddcid;
    }

    public void setDdcid(int ddcid) {
        this.ddcid = ddcid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVno() {
        return Vno;
    }

    public void setVno(String Vno) {
        this.Vno = Vno;
    }

    public int getRepid() {
        return repid;
    }

    public void setRepid(int repid) {
        this.repid = repid;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
