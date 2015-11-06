/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appPackage;

import data.Cal;
import data.Printer;
import java.awt.Color;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nobilitynobility
 */
public class printRecipt extends javax.swing.JFrame {

    /**
     * Creates new form printRecipt
     */
    public printRecipt() {
        initComponents();
        Cal cl = new Cal();
        lblDate.setText(cl.getDate());
        lblTime.setText(cl.getTime());
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lblDate1 = new javax.swing.JLabel();
        lblTime1 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblprintTot = new javax.swing.JLabel();
        lblPrintBalance = new javax.swing.JLabel();
        Balance = new javax.swing.JLabel();
        lblPrintTot = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDate1.setText("Date:");
        getContentPane().add(lblDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        lblTime1.setText("Time:");
        getContentPane().add(lblTime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 140, 20));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("============================================================");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 20));

        jScrollPane1.setOpaque(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProName                             ", "weight(g)", "Qty", "UnitPrice", "Tot"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 420, 240));

        jLabel8.setText("============================================================");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 420, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 420, 310));
        getContentPane().add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 90, 20));

        lblprintTot.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblprintTot.setText("Total :");
        getContentPane().add(lblprintTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 90, 30));

        lblPrintBalance.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblPrintBalance.setText("####");
        lblPrintBalance.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblPrintBalanceFocusGained(evt);
            }
        });
        getContentPane().add(lblPrintBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, 80, 30));

        Balance.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Balance.setText("Balance :");
        getContentPane().add(Balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, -1, 30));

        lblPrintTot.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblPrintTot.setText("####");
        getContentPane().add(lblPrintTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 80, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/recipt.jpg"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
//        this.print();
       // this.dispose();
    }//GEN-LAST:event_formMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat preformat = pjob.defaultPage();
        preformat.setOrientation(PageFormat.PORTRAIT);
        PageFormat postformat = pjob.pageDialog(preformat);
        
        
//If user does not hit cancel then print.
        if (preformat != postformat) {
    //Set print component
        pjob.setPrintable(new Printer(this), postformat);
            if (pjob.printDialog()) {
        try {
            pjob.print();
        } catch (PrinterException ex) {
           //Logger.getLogger(NewReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }
    }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void lblPrintBalanceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblPrintBalanceFocusGained
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_lblPrintBalanceFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(printRecipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(printRecipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(printRecipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(printRecipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new printRecipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Balance;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDate1;
    public static javax.swing.JLabel lblPrintBalance;
    public static javax.swing.JLabel lblPrintTot;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTime1;
    private javax.swing.JLabel lblprintTot;
    // End of variables declaration//GEN-END:variables
}
