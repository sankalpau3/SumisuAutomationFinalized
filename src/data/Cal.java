/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author Dell
 */
public class Cal {
    
    int year;
    int month;
    int day;
    String date;
    String monyear;
    private String time;

    Calendar c = new GregorianCalendar();
    
    public Cal() {
        this.year = c.get(Calendar.YEAR);
        this.month = c.get(Calendar.MONTH)+1;
        this.day = c.get(Calendar.DAY_OF_MONTH);
        this.time = c.getTime().toString().substring(11, 19);
        if(month<10)
        {
            this.date = year+"-0"+(month)+"-"+(day);
        }
        else if(day<10)
        {
            this.date = year+"-"+(month)+"-0"+(day);
        }
        else if(day<10 && month<10)
        {
            this.date = year+"-0"+(month)+"-0"+(day);
        }
        else
        {
        this.date = year+"-"+(month)+"-"+(day);
        }
    }

    public String getMonyear() {
        return monyear;
    }

    public void setMonyear(String monyear) {
        this.monyear = monyear;
    }   
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }
    
        public String formatedDate(String input) {
        String result = "";
        int month = 0, year, date;

        if (input.substring(4, 7).equals("Jan")) {
            month = 1;
        }
        if (input.substring(4, 7).equals("Feb")) {
            month = 2;
        }
        if (input.substring(4, 7).equals("Mar")) {
            month = 3;
        }
        if (input.substring(4, 7).equals("Apr")) {
            month = 4;
        }
        if (input.substring(4, 7).equals("May")) {
            month = 5;
        }
        if (input.substring(4, 7).equals("Jun")) {
            month = 6;
        }
        if (input.substring(4, 7).equals("Jul")) {
            month = 7;
        }
        if (input.substring(4, 7).equals("Aug")) {
            month = 8;
        }
        if (input.substring(4, 7).equals("Sep")) {
            month = 9;
        }
        if (input.substring(4, 7).equals("Oct")) {
            month = 10;
        }
        if (input.substring(4, 7).equals("Nov")) {
            month = 11;
        }
        if (input.substring(4, 7).equals("Dec")) {
            month = 12;
        }
        year = Integer.parseInt(input.substring(24, 28));
        day = Integer.parseInt(input.substring(8, 10));
        if (month < 10) {

            if (day < 10) {
                result = year + "-0" + month + "-0" + day;
                this.monyear = year + "-0" + month;
            } else {
                result = year + "-0" + month + "-" + day;
                this.monyear = year + "-0" + month;
            }
        } else {
            if (day < 10) {
                result = year + "-" + month + "-0" + day;
                this.monyear = year + "-0" + month;
            } else {
                result = year + "-" + month + "-" + day;
                System.out.println("aaaaaaa "+result);
                this.monyear = year + "-" + month;
            }
        }

        return result;
    }//End of FormatedDate

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    

    
    
    public void setDateTime(final JLabel dateLabel, final JLabel timeLabel){
        new Thread(new Runnable() {

                public void run() {
                    while (true) {
                        Date d = new Date();
                        
                        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
                        String date = sdf.format(d);
                        
                        //date = date + "   |";

                        Calendar c = Calendar.getInstance();
                        c.setTime(d);
                        int am=c.get(c.AM_PM);
                        String am_pm;
                        if(am==0){
                            am_pm="AM";
                        }else{
                            am_pm="PM";
                        }
                        
                        String hr = "" + c.get(c.HOUR);
                        if(c.get(c.HOUR)==0){
                            hr = "" + 12;
                        }
                        
                        String min = "" + c.get(c.MINUTE);
                        if(c.get(c.MINUTE)<10)
                            min = "0" + c.get(c.MINUTE);
                        else
                            min = "" + c.get(c.MINUTE);
                        
                        String sec = "" + c.get(c.SECOND);
                        if(c.get(c.SECOND)<10)
                            sec = "0" + c.get(c.SECOND);
                        else
                            sec = "" + c.get(c.SECOND);
                        
                        String time = "" + hr + ":" + min + ":" + sec + " " + am_pm;
                        timeLabel.setForeground(Color.white);
                        dateLabel.setForeground(Color.white);
                        timeLabel.setText(time);
                        dateLabel.setText(date);
                    }
                }
            }).start();
    }
    
    public boolean isValid(String vdate)
    {
        boolean b = false;
        System.out.println(date);
        int cday = Integer.parseInt(date.substring(8,10));
        int cmonth = Integer.parseInt(date.substring(5, 7));
        int cyear = Integer.parseInt(date.substring(0, 4));
        
        System.out.println(vdate);
        int vday = Integer.parseInt(vdate.substring(8,10));
        int vmonth = Integer.parseInt(vdate.substring(5, 7));
        int vyear = Integer.parseInt(vdate.substring(0, 4));
        System.out.println("val "+vday +" "+vmonth+" "+vyear);
        System.out.println("this "+day +" "+month+" "+year);
        if(cyear>vyear)
        {
            b = true;
            System.out.println("aaaaaaa");
        }
        else if(cyear==vyear && cmonth>vmonth)
        {
            b = true;
            System.out.println("bbbbbbbbb");
        }
        else if(cyear==vyear && cmonth==vmonth && cday >= vday)
        {
            b = true;
            System.out.println("ccccccc");
        }
        return b;
    }
    
    public boolean isValidRanage(String vdate, String v2date)
    {
        boolean b = false;
        System.out.println(date);
        System.out.println(vdate);
        int vday = Integer.parseInt(vdate.substring(8,10));
        int vmonth = Integer.parseInt(vdate.substring(5, 7));
        int vyear = Integer.parseInt(vdate.substring(0, 4));
        
         int v2day = Integer.parseInt(v2date.substring(8,10));
        int v2month = Integer.parseInt(v2date.substring(5, 7));
        int v2year = Integer.parseInt(v2date.substring(0, 4));
        
        if(v2day>vyear)
        {
            b = true;
           
        }
        else if(v2year==vyear && v2month>vmonth)
        {
            b = true;
           
        }
        else if(v2year==vyear && v2month==vmonth && v2day >= vday)
        {
            b = true;
           
        }
        return b;
    }
           
}
