/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
import appPackage.MainMenu;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author sanke
 */
public class Animation {

    public Animation() {
    }
   
    
    public void showbtn(final JButton b1, final JButton b2, final JButton b3, final JButton b4)
    {
         new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    b1.setVisible(true);
                    Thread.sleep(100);
                    b2.setVisible(true);
                    Thread.sleep(100);
                    b3.setVisible(true);
                    Thread.sleep(100);
                    b4.setVisible(true);
                    System.gc();
                } catch (InterruptedException ex) {
                }
            }
        }).start();
    }
     public void hidebtn(JButton b1, JButton b2, JButton b3, JButton b4)
    {
        try{
            b1.setVisible(false);
            
            b2.setVisible(false);
          
            b3.setVisible(false);
          
            b4.setVisible(false);
            
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
     
}
