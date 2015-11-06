/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author sanke
 */
public class Validation {

    public Validation() {
    }
   
   public boolean isNotNull(String value)
   {
       return value.equalsIgnoreCase("");
   }
   //this will return true if the input floating value is negative
   public boolean isNegative(float value)
   {
       return value < 0;
   }
   
   public boolean isNumeric(String value){  
       
        return value.matches("-?\\d+(\\.\\d+)?");
    }
    
       
   
//  public boolean dateVal(String value)
//  {
//      Cal cla = new Cal();
//      String date = cla.formatedDate(value);
//      String[] r = new String[6];
//      String delim = ".";
//      StringTokenizer tok = new StringTokenizer(date, delim, true);
//      int i = 0;
//      while (tok.hasMoreTokens()) {
//           r[i] = tok.nextToken();
//           i++;
//      }
//
//    System.out.println(Integer.parseInt(r[0])+"||"+Integer.parseInt(r[2])+"||"+Integer.parseInt(r[4]));
//
//      if(Integer.parseInt(r[0]) > cla.getYear())
//          return false;
//     if(Integer.parseInt(r[2]) > cla.getMonth())
//          return false;
//     return Integer.parseInt(r[4]) <= cla.getDay();
//  }
    
    
    
}
