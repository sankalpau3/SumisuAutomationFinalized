/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appPackage;

import DAO.ProductDetailsDAO;
import DAO.StockDetailsDAO;
import data.ReportView;
import data.product;
import java.awt.Color;
import java.util.Vector;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author DELL
 */
public class stock extends javax.swing.JFrame {

    private Vector<Vector<String>> dataProduct; //Used for data from database
    private Vector<String> headerProduct; //Used to store data header
    private Vector<Vector<String>> dataStock; //Used for data from database
    private Vector<String> headerStock;
     private Vector<Vector<String>> dataStock2;
    StockDetailsDAO dba = new StockDetailsDAO();
    
    
    /**
     * Creates new form stock
     */
        public stock() {
        initComponents();
        headerProduct = new Vector<String>();
        headerProduct.add("itemId");
        headerProduct.add("proname");
        headerProduct.add("price");
        headerProduct.add("ingredient");
        headerProduct.add("qty");
        headerProduct.add("weight");
        
        headerStock = new Vector<String>();
        headerStock.add("Stock Id");
        headerStock.add("Manufacture_Date");
        headerStock.add("Expire_Date");
        headerStock.add("Qty");
        headerStock.add("Product_Id");
        
//        jPanel4.setBackground(new Color(0, 0, 0, 0));
   jTabbedPane1.setBackground(new Color(0, 0, 0, 0));
        
        lbl_rmQty.hide();
        lbl_rmProId.hide();
        
       
        
        
        loadTableProduct();
        loadTableStock();
        maxStockId();
        
        fillVehicle();
        
    
        
    
       
    }

    
     private void loadTableProduct() {

        ProductDetailsDAO dao = new ProductDetailsDAO();
        dataProduct = dao.getProductDetails();

       tblProduct.setModel(new javax.swing.table.DefaultTableModel(
                dataProduct, headerProduct));
        jScrollPane1.setViewportView(tblProduct);
    }
     
     
      private void loadTableStock() {

        StockDetailsDAO daos = new StockDetailsDAO();
        dataStock = daos.getStockDetails();

       tblStock.setModel(new javax.swing.table.DefaultTableModel(
                dataStock, headerStock));
        jScrollPane2.setViewportView(tblStock);
    }
      
      
      private void loadTableStock2() {

        StockDetailsDAO daos = new StockDetailsDAO();
        int productid;
        int row = tblProduct.getSelectedRow();
        if (tblProduct.getRowSelectionAllowed()) 
        {
             
            productid=  Integer.parseInt(tblProduct.getValueAt(row, 0).toString()) ;
            dataStock2 = daos.getStockDetails(productid);
        }
        

       tblStock.setModel(new javax.swing.table.DefaultTableModel(
                dataStock2, headerStock));
        jScrollPane2.setViewportView(tblStock);
    }
      
      
     
      
     
      private void maxStockId()
    {
       lbl_stockId.setText(Integer.toString(dba.getMaxStockId()));
    }
     
     
     private void getSelectedProId()
    {
        int row = tblProduct.getSelectedRow();

        
        if (tblProduct.getRowSelectionAllowed()) 
        {
            
            lbl_proId.setText(tblProduct.getValueAt(row, 0).toString());
            
        }
    }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     private void getSelectedStockDetails()
    {
        int row = tblStock.getSelectedRow();

        
        if (tblStock.getRowSelectionAllowed()) 
        {
            
            lbl_upStoId.setText(tblStock.getValueAt(row, 0).toString());
            lbl_upProId.setText(tblStock.getValueAt(row, 4).toString());
            txt_upQty.setText(tblStock.getValueAt(row, 3).toString());
            lbl_rmStockId.setText(tblStock.getValueAt(row, 0).toString());
            lbl_rmQty.setText(tblStock.getValueAt(row, 3).toString());
            lbl_rmProId.setText(tblStock.getValueAt(row, 4).toString());
            
                        
            lblsendstockId.setText(tblStock.getValueAt(row, 0).toString());
            lblAvailAmount.setText(tblStock.getValueAt(row, 3).toString());
            //lblSendProName.setText(tblProduct.getValueAt(row, 1).toString());
            //lblSendPrice.setText(tblProduct.getValueAt(row, 2).toString());
            //lblSendIngredient.setText(tblProduct.getValueAt(row, 3).toString());
            //lblSendWeight.setText(tblProduct.getValueAt(row, 5).toString());
            
            
            try{
                Date mdate = new SimpleDateFormat("yyyy-MM-dd").parse(tblStock.getValueAt(row, 1).toString());
                Date edate = new SimpleDateFormat("yyyy-MM-dd").parse(tblStock.getValueAt(row, 2).toString());
                
                jdc_upMan.setDate(mdate);
                jdc_upExp.setDate(edate);
            }
            catch(Exception e1)
            {
                
            }
            
        }
    }
     
    private void getSelectedProDetails()
    {
        int row = tblProduct.getSelectedRow();

        
        if (tblProduct.getRowSelectionAllowed()) 
        {
            
           
           // lblSendItem.setText(tblStock.getValueAt(row, 0).toString());
            //lblAvailAmount.setText(tblStock.getValueAt(row, 3).toString());
            lblSendProName.setText(tblProduct.getValueAt(row, 1).toString());
            lblSendPrice.setText(tblProduct.getValueAt(row, 2).toString());
            lblSendIngredient.setText(tblProduct.getValueAt(row, 3).toString());
            lblSendWeight.setText(tblProduct.getValueAt(row, 5).toString());
            
            lblSendProId.setText(tblProduct.getValueAt(row, 0).toString());
            lblSendProQty.setText(tblProduct.getValueAt(row, 4).toString());
            
            
           
            
        }
    } 
     
    
    
     
    
    
    
   
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        lblStockId = new javax.swing.JLabel();
        lblQty = new javax.swing.JLabel();
        txt_qty = new javax.swing.JTextField();
        btnAddStock = new javax.swing.JButton();
        lbl_stockId = new javax.swing.JLabel();
        lblManDate = new javax.swing.JLabel();
        lblExpDate = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        lbl_proId = new java.awt.Label();
        jdc_manDate = new com.toedter.calendar.JDateChooser();
        jdc_expDate = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        lblUpStockId = new javax.swing.JLabel();
        lblUpQty = new javax.swing.JLabel();
        txt_upQty = new javax.swing.JTextField();
        btnUpdateStock = new javax.swing.JButton();
        lblUpManDate = new javax.swing.JLabel();
        lblUpExpDate = new javax.swing.JLabel();
        lbl_upStoId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_upProId = new javax.swing.JLabel();
        jdc_upMan = new com.toedter.calendar.JDateChooser();
        jdc_upExp = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        lblRmStockId = new javax.swing.JLabel();
        btnRemoveStock = new javax.swing.JButton();
        lbl_rmStockId = new javax.swing.JLabel();
        lbl_rmQty = new javax.swing.JLabel();
        lbl_rmProId = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblSend = new javax.swing.JLabel();
        lblAvaiAm = new javax.swing.JLabel();
        lblQuantity1 = new javax.swing.JLabel();
        lblAvailAmount = new javax.swing.JLabel();
        btnSendToOutlet = new javax.swing.JButton();
        txtSendQuantity = new javax.swing.JTextField();
        btnSendToVehicle = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblSendProName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSendPrice = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblSendIngredient = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblSendWeight = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblSendProId = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblSendProQty = new javax.swing.JLabel();
        lblsendstockId = new javax.swing.JLabel();
        cmbVehicleDetails = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnStockIReport = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        pnlBtn = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStockId.setText("Stock ID");

        lblQty.setText("Qty");

        btnAddStock.setText("Add Stock");
        btnAddStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStockActionPerformed(evt);
            }
        });

        lbl_stockId.setText("[StockId]");

        lblManDate.setText("ManDate");

        lblExpDate.setText("Expdate");

        label1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        label1.setText("Product Id");

        lbl_proId.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lbl_proId.setText("[Select Product ]");

        jdc_manDate.setDateFormatString("yyyy-MM-dd");

        jdc_expDate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblStockId)
                                .addGap(101, 101, 101)
                                .addComponent(lbl_stockId))
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnAddStock)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblExpDate)
                                        .addComponent(lblQty))
                                    .addGap(98, 98, 98)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jdc_expDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_proId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblManDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdc_manDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStockId)
                    .addComponent(lbl_stockId))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_proId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblManDate)
                    .addComponent(jdc_manDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblExpDate))
                    .addComponent(jdc_expDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblQty))
                    .addComponent(txt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnAddStock))
        );

        jTabbedPane1.addTab("add", jPanel3);

        lblUpStockId.setText("Stock Id");

        lblUpQty.setText("Qty");

        btnUpdateStock.setText("Update Stock");
        btnUpdateStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStockActionPerformed(evt);
            }
        });

        lblUpManDate.setText("ManDate");

        lblUpExpDate.setText("ExpDate");

        lbl_upStoId.setText("         ");

        jLabel2.setText("Product Id");

        lbl_upProId.setText("           ");

        jdc_upMan.setDateFormatString("yyyy-MM-dd");

        jdc_upExp.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUpManDate)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUpExpDate)
                            .addComponent(lblUpQty))
                        .addGap(96, 96, 96)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_upQty, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdc_upExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdc_upMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUpStockId)
                            .addComponent(jLabel2))
                        .addGap(98, 98, 98)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_upProId)
                            .addComponent(lbl_upStoId)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnUpdateStock)))
                .addGap(20, 31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUpStockId)
                    .addComponent(lbl_upStoId))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_upProId))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUpManDate)
                    .addComponent(jdc_upMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblUpExpDate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jdc_upExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblUpQty))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(txt_upQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addComponent(btnUpdateStock)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("update", jPanel1);

        lblRmStockId.setText("Stock Id/Name");

        btnRemoveStock.setText("Remove Stock");
        btnRemoveStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveStockActionPerformed(evt);
            }
        });

        lbl_rmStockId.setText("           ");

        lbl_rmQty.setText("            ");

        lbl_rmProId.setText("            ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 69, Short.MAX_VALUE)
                        .addComponent(btnRemoveStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_rmProId)
                            .addComponent(lbl_rmQty))
                        .addGap(45, 45, 45))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblRmStockId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_rmStockId)
                        .addGap(58, 58, 58))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRmStockId)
                    .addComponent(lbl_rmStockId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_rmQty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_rmProId)
                    .addComponent(btnRemoveStock))
                .addContainerGap(267, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("remove", jPanel2);

        lblSend.setText("Stock ID");

        lblAvaiAm.setText("Available Stock Quantity");

        lblQuantity1.setText("Quantity");

        lblAvailAmount.setText("jLabel9");

        btnSendToOutlet.setText("Send to Outlet");
        btnSendToOutlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendToOutletActionPerformed(evt);
            }
        });

        txtSendQuantity.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtSendQuantityInputMethodTextChanged(evt);
            }
        });

        btnSendToVehicle.setText("Send to Vehicle");
        btnSendToVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendToVehicleActionPerformed(evt);
            }
        });

        jLabel5.setText("Product Name");

        lblSendProName.setText("jLabel6");

        jLabel7.setText("Price");

        lblSendPrice.setText("jLabel8");

        jLabel9.setText("Ingredient");

        lblSendIngredient.setText("jLabel10");

        jLabel11.setText("Weight");

        lblSendWeight.setText("jLabel12");

        jLabel6.setText("Pro Id");

        lblSendProId.setText("jLabel8");

        jLabel8.setText("Product Qty");

        lblSendProQty.setText("jLabel10");

        lblsendstockId.setText("jLabel10");

        cmbVehicleDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVehicleDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSend)
                                    .addComponent(lblAvaiAm)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAvailAmount)
                                    .addComponent(lblsendstockId)
                                    .addComponent(lblSendProId)
                                    .addComponent(lblSendProName)
                                    .addComponent(lblSendPrice)
                                    .addComponent(lblSendIngredient)
                                    .addComponent(lblSendProQty)
                                    .addComponent(lblSendWeight)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblQuantity1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSendQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(cmbVehicleDetails, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSendToOutlet)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(btnSendToVehicle)
                        .addGap(19, 19, 19))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSend)
                    .addComponent(lblsendstockId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAvailAmount)
                    .addComponent(lblAvaiAm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblSendProId))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblSendProName))
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSendPrice)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblSendIngredient))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblSendProQty))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblSendWeight))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSendQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cmbVehicleDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSendToOutlet)
                    .addComponent(btnSendToVehicle))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Send", jPanel5);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 270, 440));

        jPanel4.setOpaque(false);

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tblStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStockMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblStock);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Product Details");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Stock Details");

        btnStockIReport.setText("Stock iReport");
        btnStockIReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockIReportActionPerformed(evt);
            }
        });

        jButton1.setText("Stock Details Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStockIReport, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStockIReport, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 460, 430));

        pnlBtn.setOpaque(false);

        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.png"))); // NOI18N
        home.setOpaque(false);
        home.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Focus_home.png"))); // NOI18N
        home.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Focus_home.png"))); // NOI18N
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        logout.setOpaque(false);
        logout.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fourcus_Logout.png"))); // NOI18N
        logout.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fourcus_Logout.png"))); // NOI18N
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        btnExit.setOpaque(false);
        btnExit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Focus_delete.png"))); // NOI18N
        btnExit.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Focus_delete.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnLayout = new javax.swing.GroupLayout(pnlBtn);
        pnlBtn.setLayout(pnlBtnLayout);
        pnlBtnLayout.setHorizontalGroup(
            pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlBtnLayout.setVerticalGroup(
            pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnLayout.createSequentialGroup()
                .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(home)
                    .addComponent(logout)
                    .addComponent(btnExit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 590, 180, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mainmenubackgroundWindows.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStockActionPerformed

        jScrollPane1.setVisible(true);
        tblProduct.setVisible(true);
        tblStock.setVisible(true);
        try{
        Date mandate = jdc_manDate.getDate();
        Date expdate = jdc_expDate.getDate();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String mDate = dateFormat.format(mandate);
        String eDate = dateFormat.format(expdate);
                

//String startDateString = dateFormat.format(projectStartDateJDateChooser.getDate())
        
        boolean v1 = dba.addStock(Integer.parseInt(lbl_stockId.getText()), mDate, eDate, Integer.parseInt(txt_qty.getText()), Integer.parseInt(lbl_proId.getText()));
        boolean v2 = dba.updateProduct_incQty(Integer.parseInt(lbl_proId.getText()), Integer.parseInt(txt_qty.getText()));
        
        if(v1 && v2)
        {
            JOptionPane.showMessageDialog(null, "Stock successfully added");
            loadTableStock();
            loadTableProduct();
            maxStockId();
        }
        else
            JOptionPane.showMessageDialog(null, "Error");
        loadTableProduct();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Invalid Inputs");
        }
        
           
        
        
        

    }//GEN-LAST:event_btnAddStockActionPerformed

    private void btnUpdateStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStockActionPerformed
        // TODO add your handling code here:
        
        try{
        Date mandate = jdc_upMan.getDate();
        Date expdate = jdc_upExp.getDate();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String mDate = dateFormat.format(mandate);
        String eDate = dateFormat.format(expdate);
        boolean v1 =dba.updateStock(Integer.parseInt(lbl_upStoId.getText()), mDate, eDate, Integer.parseInt(txt_upQty.getText()));
        boolean v2 =dba.updateProduct_decQty(Integer.parseInt(lbl_upProId.getText()),Integer.parseInt(txt_upQty.getText()) );
        if(v1&&v2)
        {
            JOptionPane.showMessageDialog(null, "Stock Updated successfully ");
            loadTableProduct();
            loadTableStock(); 
        }
       } 
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "Invalid Inputs");
        
        }
        
        
        
    }//GEN-LAST:event_btnUpdateStockActionPerformed

    
    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        getSelectedProId();
        loadTableStock2();
        getSelectedProDetails();
    }//GEN-LAST:event_tblProductMouseClicked

    private void tblStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStockMouseClicked
        // TODO add your handling code here:
        
        getSelectedStockDetails();
    }//GEN-LAST:event_tblStockMouseClicked

    private void btnRemoveStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveStockActionPerformed
        // TODO add your handling code here:
        try {
            boolean v1 = dba.removeStock(Integer.parseInt(lbl_rmStockId.getText()));
            boolean v2 = dba.updateProduct_decQty(Integer.parseInt(lbl_rmProId.getText()), Integer.parseInt(lbl_rmQty.getText()));
        
            if(v1&&v2)
            {
                JOptionPane.showMessageDialog(null, "Stock Removed successfully ");
                loadTableProduct();
                loadTableStock();
            }
            else
                JOptionPane.showMessageDialog(null, "Remove stock Fail ");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Please select Stock Id");
        }
        
            
        
            
    }//GEN-LAST:event_btnRemoveStockActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        lblStockId.setVisible(false);
        lbl_stockId.setVisible(false);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed

        MainMenu m = new MainMenu();
        m.b = true;
        m.setVisible(true);
        this.dispose();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_homeActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed

        MainMenu m = new MainMenu();
        m.b = false;
        m.setVisible(true);
        this.dispose();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed

        int a =JOptionPane.showConfirmDialog(rootPane, "Do you want to exit");
        if(a == JOptionPane.YES_OPTION)
        {
            this.dispose();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSendToOutletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendToOutletActionPerformed
        // TODO add your handling code here:
      
        if( Integer.parseInt( txtSendQuantity.getText()) >   Integer.parseInt( lblAvailAmount.getText()))
        {
                JOptionPane.showMessageDialog(null, "Amount should be less than Available amount!");
        }
        else
        {
        
        
             try{
                
                    
            if(dba.checkoutlet(Integer.parseInt(lblSendProId.getText())))
            {
              dba.updateOutletStock(Integer.parseInt(lblSendProId.getText()),Integer.parseInt(txtSendQuantity.getText()));
              dba.updateSendproQty(Integer.parseInt(lblSendProId.getText()),Integer.parseInt(txtSendQuantity.getText()));
              dba.updateSendStockQty(Integer.parseInt(lblsendstockId.getText()),Integer.parseInt(txtSendQuantity.getText()));
              loadTableProduct();
              loadTableStock();
              JOptionPane.showMessageDialog(null, "Qty added to outlet ");
              
              
            }
            else
            {
                 boolean addout =dba.addToOutlet(Integer.parseInt(lblSendProId.getText()),lblSendProName.getText(),Double.parseDouble(lblSendPrice.getText()), lblSendIngredient.getText(), txtSendQuantity.getText(),Double.parseDouble(lblSendWeight.getText()));
                 boolean updpro = dba.updateSendproQty(Integer.parseInt(lblSendProId.getText()),Integer.parseInt(txtSendQuantity.getText()));
                 boolean updsto = dba.updateSendStockQty(Integer.parseInt(lblsendstockId.getText()),Integer.parseInt(txtSendQuantity.getText()));
                if(addout && updpro && updsto)
                {
                    JOptionPane.showMessageDialog(null, "Qty added to outlet ");
                    loadTableProduct();
                    loadTableStock();
                } 
                else
                  JOptionPane.showMessageDialog(null, "Error");
            }
         
            
             
             
    }
    catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Enter Quantity");
        }
        }     
            
    }//GEN-LAST:event_btnSendToOutletActionPerformed

    
  
    
    
    
    
    
    
    
    
    
    private void btnStockIReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockIReportActionPerformed
        // TODO add your handling code here:
        try{
        HashMap hm = new HashMap();
        //lblSendProName.setText(tblProduct.getValueAt(row, 1).toString());
       // hm.put("PARA_SHOW_PRODUCT", Integer.parseInt(txtIre.getText()));
        
        hm.put("PARA_SHOW_PRODUCT",tblProduct.getValueAt(tblProduct.getSelectedRow(), 0).toString());
        
        hm.put("PARA_NAME",tblProduct.getValueAt(tblProduct.getSelectedRow(), 1).toString());
        
         //hm.put("PARA_NAME", Integer.parseInt(txtIre.getText()));
        
        
        ReportView r = new ReportView("C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaApplication9\\src\\iReport2\\new4.jasper",hm);
        r.setVisible(true);
        }
          catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Select a Product");
        }
        
    }//GEN-LAST:event_btnStockIReportActionPerformed

    private void btnSendToVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendToVehicleActionPerformed

        try{
        String s1 =  cmbVehicleDetails.getSelectedItem().toString();
       
        int vehicle = Integer.parseInt(s1.toString().split(" ")[1]);
        
        boolean adddel = dba.addVehicleDeli(vehicle,lblSendProName.getText(), lblSendProId.getText(),Integer.parseInt(txtSendQuantity.getText()) ,Integer.parseInt(lblsendstockId.getText()));
        boolean updpro = dba.updateSendproQty(Integer.parseInt(lblSendProId.getText()),Integer.parseInt(txtSendQuantity.getText()));
        boolean updsto = dba.updateSendStockQty(Integer.parseInt(lblsendstockId.getText()),Integer.parseInt(txtSendQuantity.getText()));
        if(adddel && updpro && updsto)
               {
                  JOptionPane.showMessageDialog(null, "Products Send to vehicle");
                  loadTableProduct();
                  loadTableStock();
                }
            
            }
        
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Enter Quantity");
        }


        
    }//GEN-LAST:event_btnSendToVehicleActionPerformed

  
    private void fillVehicle()
    {
        StockDetailsDAO dao = new StockDetailsDAO();
        ArrayList VehicleList=dao.getdeliveryDetails();
    
        Iterator i = VehicleList.iterator();
    
        while (i.hasNext())
        {
            cmbVehicleDetails.addItem(i.next());
        }
    
    
    }
      
    
    
    
    
    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        HashMap hm = new HashMap();
        ReportView r = new ReportView("C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaApplication9\\src\\iReport2\\new5.jasper",hm);
        r.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbVehicleDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVehicleDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVehicleDetailsActionPerformed

    private void txtSendQuantityInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSendQuantityInputMethodTextChanged
        
        if( Integer.parseInt( txtSendQuantity.getText()) >   Integer.parseInt( lblAvailAmount.getText()))
        {
            
        }
        
        
        
        
    }//GEN-LAST:event_txtSendQuantityInputMethodTextChanged

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
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStock;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRemoveStock;
    private javax.swing.JButton btnSendToOutlet;
    private javax.swing.JButton btnSendToVehicle;
    private javax.swing.JButton btnStockIReport;
    private javax.swing.JButton btnUpdateStock;
    private javax.swing.JComboBox cmbVehicleDetails;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdc_expDate;
    private com.toedter.calendar.JDateChooser jdc_manDate;
    private com.toedter.calendar.JDateChooser jdc_upExp;
    private com.toedter.calendar.JDateChooser jdc_upMan;
    private java.awt.Label label1;
    private javax.swing.JLabel lblAvaiAm;
    private javax.swing.JLabel lblAvailAmount;
    private javax.swing.JLabel lblExpDate;
    private javax.swing.JLabel lblManDate;
    private javax.swing.JLabel lblQty;
    private javax.swing.JLabel lblQuantity1;
    private javax.swing.JLabel lblRmStockId;
    private javax.swing.JLabel lblSend;
    private javax.swing.JLabel lblSendIngredient;
    private javax.swing.JLabel lblSendPrice;
    private javax.swing.JLabel lblSendProId;
    private javax.swing.JLabel lblSendProName;
    private javax.swing.JLabel lblSendProQty;
    private javax.swing.JLabel lblSendWeight;
    private javax.swing.JLabel lblStockId;
    private javax.swing.JLabel lblUpExpDate;
    private javax.swing.JLabel lblUpManDate;
    private javax.swing.JLabel lblUpQty;
    private javax.swing.JLabel lblUpStockId;
    private java.awt.Label lbl_proId;
    private javax.swing.JLabel lbl_rmProId;
    private javax.swing.JLabel lbl_rmQty;
    private javax.swing.JLabel lbl_rmStockId;
    private javax.swing.JLabel lbl_stockId;
    private javax.swing.JLabel lbl_upProId;
    private javax.swing.JLabel lbl_upStoId;
    private javax.swing.JLabel lblsendstockId;
    private javax.swing.JButton logout;
    private javax.swing.JPanel pnlBtn;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txtSendQuantity;
    private javax.swing.JTextField txt_qty;
    private javax.swing.JTextField txt_upQty;
    // End of variables declaration//GEN-END:variables
}
