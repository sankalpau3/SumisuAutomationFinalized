/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appPackage;

import DAO.OutletDAO;
import static appPackage.Outlet.tblCart;
import data.Cal;
import java.awt.Color;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nobilitynobility
 */
public class invoiceUI extends javax.swing.JFrame {

    /**
     * Creates new form invoiceUI
     */
    JTable tbl = new JTable();
    private int rowcount = -1;
    boolean firstselect = true;

    public invoiceUI() {
        initComponents();
        this.setBackground(new Color(255, 255, 255, 254));
    }

    public invoiceUI(JTable tbla) {
        initComponents();
        this.tbl = tbla;
        //this.out2 = outl;
        jScrollPane1abc.setViewportView(tbl);
        this.setBackground(new Color(255, 255, 255, 254));
        calTot();

    }

    public void calTot() {
        float sum = 0;
        this.rowcount = tbl.getRowCount();
        for (int i = 0; i < tbl.getRowCount(); i++) {
            sum += Float.parseFloat(tbl.getValueAt(i, 5).toString());

        }

        lblamount.setText("" + sum);

    }

    public void displayTot() {
        float cash = Float.parseFloat(txtCash.getText());
        System.out.println(lblBalance.getText());
        float tot = Float.parseFloat(lblamount.getText());
        float dis = (float) 0.0;
        float sum = cash - (tot-dis);
        

//        DefaultTableModel model = (DefaultTableModel) tblCart.getModel();
//        model.addRow(new Object[]{"=====", "=====", "=====", "=====", "=====",});
//        model.addRow(new Object[]{"SUB TOTAL", "", "", "", "", tot + ""});
//        model.addRow(new Object[]{"DISCOUNT", "", "", "", "", dis + ""});
//
//        model.addRow(new Object[]{"CASH", "", "", "", "", cash + ""});
//        model.addRow(new Object[]{"NET TOTAL", "", "", "", "", tot - dis + ""});
//        model.addRow(new Object[]{"BALANCE", "", "", "", "", cash - (tot - dis) + ""});
        lblBalance.setText(sum + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1abc = new javax.swing.JScrollPane();
        tblInvoice = new javax.swing.JTable();
        txtCash = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnPrintrecipt = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblamount = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        tblInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1abc.setViewportView(tblInvoice);

        txtCash.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCashCaretUpdate(evt);
            }
        });
        txtCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCashActionPerformed(evt);
            }
        });
        txtCash.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCashFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCashFocusLost(evt);
            }
        });

        jLabel1.setText("Cash:");

        btnPrintrecipt.setText("Print Recipt");
        btnPrintrecipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintreciptActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Total :");

        lblamount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblamount.setText("#####");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Balance:");

        lblBalance.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblBalance.setText("#####");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("-Invoice-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1abc))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPrintrecipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCash, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblamount, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 99, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1abc, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblamount, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrintrecipt, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(73, 73, 73)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        while (tblCart.getRowCount() > rowcount) {

            DefaultTableModel model = (DefaultTableModel) tblCart.getModel();
            model.removeRow(rowcount);

        }
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnPrintreciptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintreciptActionPerformed
       
        float cash = Float.parseFloat(txtCash.getText());
        float tot = Float.parseFloat(lblamount.getText());
        float dis = (float) 0.0;
        float sum = cash - tot;
        
         

        
        
        if (cash < tot) {

            JOptionPane.showMessageDialog(rootPane, "Cash amount is less than total");
        } else {
            Cal cl = new Cal();
            String date = cl.getDate();
            int a = JOptionPane.showConfirmDialog(rootPane, "The Balance is : " + sum + ".  Print Recipt?");
            if (a == JOptionPane.YES_OPTION) {
                
                printRecipt pr = new printRecipt();
                int c = tblCart.getRowCount();
                pr.lblPrintBalance.setText(lblBalance.getText());
                pr.lblPrintTot.setText(lblamount.getText());
                DefaultTableModel model1 = (DefaultTableModel) pr.jTable1.getModel();
                for (int r = 0; r < c; r++) {
                    model1.addRow(new Object[]{ tblCart.getValueAt(r, 1), tblCart.getValueAt(r, 2), tblCart.getValueAt(r, 3), tblCart.getValueAt(r, 4), tblCart.getValueAt(r, 5)});
                }
                 OutletDAO oud = new OutletDAO();
        oud.addOutletInvoice(tot);
        String tid = oud.getTransactionId();
        boolean b1;
                    System.out.println(tblCart.getRowCount());

        for(int i =0; i < tblCart.getRowCount();i++)
        {
            System.out.println(tblCart.getRowCount());
            // (`proId`, `proName`, `qty`, `transactionId1`)
            b1 = oud.addOutletInvoiceProduct(Integer.parseInt(tblCart.getValueAt(i, 0).toString()),tblCart.getValueAt(i, 1).toString(), Integer.parseInt(tblCart.getValueAt(i, 3).toString()), tid);
//            if(!b1)
//            {
//                JOptionPane.showMessageDialog(null, "Failed");
//                break;
//            }
        }
                    System.out.println(tblCart.getRowCount()+"   aaa");   
                pr.setVisible(true);
                
                
                while (tbl.getRowCount() > 0) {

                    DefaultTableModel model = (DefaultTableModel) tbl.getModel();
                    model.removeRow(0);

                }

                this.dispose();
            }

        }
    }//GEN-LAST:event_btnPrintreciptActionPerformed

    private void txtCashFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCashFocusLost
        if (firstselect) {
            displayTot();
            firstselect = false;
        }
    }//GEN-LAST:event_txtCashFocusLost

    private void txtCashCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCashCaretUpdate
 while (tblCart.getRowCount() > rowcount) {

            DefaultTableModel model = (DefaultTableModel) tblCart.getModel();
            model.removeRow(rowcount);

        }
        firstselect = true;
    }//GEN-LAST:event_txtCashCaretUpdate

    private void txtCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCashActionPerformed
        btnPrintreciptActionPerformed(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCashActionPerformed

    private void txtCashFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCashFocusGained
         
        
    }//GEN-LAST:event_txtCashFocusGained

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
            java.util.logging.Logger.getLogger(invoiceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(invoiceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(invoiceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(invoiceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new invoiceUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrintrecipt;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1abc;
    public static javax.swing.JLabel lblBalance;
    public static javax.swing.JLabel lblamount;
    private javax.swing.JTable tblInvoice;
    private javax.swing.JTextField txtCash;
    // End of variables declaration//GEN-END:variables
}