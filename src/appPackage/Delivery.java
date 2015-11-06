/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appPackage;

import DAO.DailyDeliveryDAO;
import data.Cal;
import DAO.DeliveryDAO;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import data.AutoCompletion;
import data.DeliveryDetails;
import data.DeliveryProductDetails;
import data.DeliveryReturnDetails;
import data.ReportView;
import data.Validation;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import oracle.jrockit.jfr.events.Bits;

/**
 *
 * @author Dell
 */
public class Delivery extends javax.swing.JFrame {

    /**
     * Creates new form Delivery
     */
    private Vector<Vector<String>> data; //Used for data from database
    private Vector<Vector<String>> data1; //Used for data from database

    private Vector<String> header; //Used to store data header
    private Vector<String> Mheader; //Used to store maintain data header
    private Vector<String> DDheader; //Used to store Daily Delivery data header
    private Vector<String> DPheader; //Used to store Daily Delivery products data header
    private Vector<String> RPheader; //Used to store Daily Delivery products data header
    private Vector<Vector<String>> Mdata; //Used for maintain data from database
    private Vector<Vector<String>> DDdata; //Used for Daily Delivery data from database
    private Vector<Vector<String>> DPdata; //Used for Delivery Products data from database
    private Vector<Vector<String>> RPdata; //Used for Delivery Products data from database

    public Delivery() {
        initComponents();
        header = new Vector<String>();
        header.add("V ID");
        header.add("V No");
        header.add("V type");
        header.add("Fuel Type");
        header.add("Mrent");
        header.add("LInsDate");
        header.add("InsExpDate");
        header.add("LicenDate");
        header.add("LicenExpDate");

        Mheader = new Vector<String>();
        Mheader.add("V ID");
        Mheader.add("V No");

        DDheader = new Vector<String>();
        DDheader.add("DDC ID");
        DDheader.add("Date");
        DDheader.add("V No");
        DDheader.add("Rep ID");
        DDheader.add("Route");
        DDheader.add("Status");

        DPheader = new Vector<String>();
        DPheader.add("ddc ID");
        DPheader.add("dd ID");
        DPheader.add("Product Name");
        DPheader.add("Product ID");
        DPheader.add("Qty");
        DPheader.add("StockID");

        RPheader = new Vector<String>();
        RPheader.add("Rep ID");
        RPheader.add("Product ID");
        RPheader.add("Product Name");

        loadTable(tblVehicle, jScrollPane1); //load table vehile
        loadTable(tblVehicle1, jScrollPane3); //
        loadTbMaintain("", tblmain, jScrollPane4);
        loadTbDailyDelivery(tblDDC, jScrollPane8);
        loadTbDailyDelivery(tblDDCRoute, jScrollPane11);
        loadTbExpRtProduct(tblExpnRetPrdt, jScrollPane10);

        jTabbedPane1.setBackground(new Color(0, 0, 0, 0));
        fillPronames("");
        fillRepnames("");
        AutoCompletion.enable(cmbPnames);
        AutoCompletion.enable(cmbRepName);
        lblDDid.hide();

    }

    public void loadTbMaintain(String no, JTable tb1, JScrollPane j1) {

        DeliveryDAO dao = new DeliveryDAO();
        Mdata = dao.getMaintainDeliveryDetails(no);
        tb1.setModel(new javax.swing.table.DefaultTableModel(
                Mdata, Mheader));

        j1.setViewportView(tb1);
    }

    public void loadTable(JTable tb1, JScrollPane j1) {

        String no = "";
        DeliveryDAO dao = new DeliveryDAO();
        data = dao.getDeliveryDetails(no);
        tb1.setModel(new javax.swing.table.DefaultTableModel(
                data, header));
//        tb1.setModel(new javax.swing.table.DefaultTableModel(
//                data, header));
        j1.setViewportView(tb1);
    }

    public void loadTable1(String no, JTable tb1, JScrollPane j1) {

        DeliveryDAO dao1 = new DeliveryDAO();
        data1 = dao1.getDeliveryDetails(no);
        tb1.setModel(new javax.swing.table.DefaultTableModel(
                data1, header));
        tb1.setModel(new javax.swing.table.DefaultTableModel(
                data1, header));
        j1.setViewportView(tb1);
    }

    public void loadTbDailyDelivery(JTable tb1, JScrollPane j1) {

        DailyDeliveryDAO dao = new DailyDeliveryDAO();
        DDdata = dao.getDailyDeliveryDetails();
        tb1.setModel(new javax.swing.table.DefaultTableModel(
                DDdata, DDheader));

        j1.setViewportView(tb1);
    }

    public void loadTbDeliveryProduct(JTable tb1, JScrollPane j1, String ddcid) {

        DailyDeliveryDAO dao = new DailyDeliveryDAO();
        DPdata = dao.getDeliveryProductDetails(ddcid);
        tb1.setModel(new javax.swing.table.DefaultTableModel(
                DPdata, DPheader));

        j1.setViewportView(tb1);
    }

    public void loadTbExpRtProduct(JTable tb1, JScrollPane j1) {

        DailyDeliveryDAO dao = new DailyDeliveryDAO();
        RPdata = dao.getDeliveryReturnDetails("");
        tb1.setModel(new javax.swing.table.DefaultTableModel(
                RPdata, RPheader));

        j1.setViewportView(tb1);
    }

    public void loadTableMainSearch(String no, JTable tb1, JScrollPane j1) {

        DeliveryDAO dao11 = new DeliveryDAO();
        Mdata = dao11.getMaintainDeliveryDetails(no);
        tb1.setModel(new javax.swing.table.DefaultTableModel(
                Mdata, Mheader));
        tb1.setModel(new javax.swing.table.DefaultTableModel(
                Mdata, Mheader));
        j1.setViewportView(tb1);
    }

    private void AddClear() {
        DchLastInsuranceDate.setDate(null);
        //lblInsExpDate.setText("");
        DchLastLicenceDate.setDate(null);
        //lblLExpDate.setText("");
        txtVehicleNo.setText("");
        txtMonthlyRental.setText("");
        lblEVehicleNo.setText("");
//        lblEType.setText("");
        //      lblEFuelType.setText("");
        lblEMonthlyRental.setText("");
        lblELastInsuranceDate.setText("");
        lblELastLicenceDate.setText("");

    }

    private void MaintainClear() {
        txtDescription.setText("");
        txtAmounta.setText("");
        txtMVehicleNo.setText("");
        lblEMAmount.setText("");
        lblEMVehicleNo.setText("");
        lblDescription.setText("");
        lblDateM.setText("");
        dchMaintain.setDate(null);
    }

    private void UpdateClear() {
        txtUpVehicleNo.setText("");
        txtUpMonthlyRental.setText("");
        DchLastInsuranceDate1.setDate(null);
//        DchlInsuranceExpirationDate1.setDate(null);
        DchLastLicenceDate1.setDate(null);
        //      DchLicenceExpiration1.setDate(null);
        lblUVehicleNo.setText("");
        txtSearch.setText("");
    }

    private void fillPronames(String n) {
        DailyDeliveryDAO dao = new DailyDeliveryDAO();
        ArrayList jobCatList = dao.getProNames(n);

        Iterator i = jobCatList.iterator();
        //cmbProductNames
        cmbPnames.removeAllItems();
        while (i.hasNext()) {
            cmbPnames.addItem(i.next());
        }
    }

    private void fillRepnames(String n) {
        DailyDeliveryDAO dao = new DailyDeliveryDAO();
        ArrayList jobCatList = dao.getRepNames();

        Iterator i = jobCatList.iterator();
        //cmbReturnProduct
        cmbRepName.removeAllItems();
        while (i.hasNext()) {
            cmbRepName.addItem(i.next());
        }
    }

    private String incYear(String date) {
        System.out.println(date.substring(0, 4));

        int upDate = Integer.parseInt(date.substring(0, 4));
        upDate = upDate + 1;
        return upDate + date.substring(4, 10);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        btnGrpStatus = new javax.swing.ButtonGroup();
        a = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVehicle1 = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        lblFuelType = new javax.swing.JLabel();
        lblELastLicenceDate = new javax.swing.JLabel();
        txtMonthlyRental = new javax.swing.JTextField();
        lblEMonthlyRental = new javax.swing.JLabel();
        lblELastInsuranceDate = new javax.swing.JLabel();
        cmbAddFtype = new javax.swing.JComboBox();
        lblLExpDate = new javax.swing.JLabel();
        lblMonthlyRental = new javax.swing.JLabel();
        cmbType1 = new javax.swing.JComboBox();
        lblLicenceExpiration = new javax.swing.JLabel();
        btnDAdd = new javax.swing.JButton();
        txtVehicleNo = new javax.swing.JTextField();
        DchLastLicenceDate = new com.toedter.calendar.JDateChooser();
        lblLastInsuranceDate = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        btnVClear = new javax.swing.JButton();
        lblLastLicenceDate = new javax.swing.JLabel();
        lblEVehicleNo = new javax.swing.JLabel();
        lblInsuranceExpirationDate = new javax.swing.JLabel();
        lblInsExpDate = new javax.swing.JLabel();
        DchLastInsuranceDate = new com.toedter.calendar.JDateChooser();
        lblVehicleNo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehicle = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        lblLicenceExpiration1 = new javax.swing.JLabel();
        txtUpMonthlyRental = new javax.swing.JTextField();
        DchLastInsuranceDate1 = new com.toedter.calendar.JDateChooser();
        DchLastLicenceDate1 = new com.toedter.calendar.JDateChooser();
        btnClear = new javax.swing.JButton();
        cmbFuelType = new javax.swing.JComboBox();
        txtUpVehicleNo = new javax.swing.JTextField();
        lblUpMonthlyRental = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        cmbType = new javax.swing.JComboBox();
        lblLastInsuranceDate1 = new javax.swing.JLabel();
        btnUpAdd = new javax.swing.JButton();
        lblLastLicenceDate1 = new javax.swing.JLabel();
        lblUpFuelType = new javax.swing.JLabel();
        lblUVehicleNo = new javax.swing.JLabel();
        lblUpVehicleNo = new javax.swing.JLabel();
        lblUpType = new javax.swing.JLabel();
        lblInsuranceExpirationDate1 = new javax.swing.JLabel();
        lblUPINSEXP = new javax.swing.JLabel();
        lblUPLINEXPD = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblmain = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblVnO = new javax.swing.JLabel();
        lblVID = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblDDCRoute = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cmbRepName = new javax.swing.JComboBox();
        txtRoute = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        dchMaintain = new com.toedter.calendar.JDateChooser();
        txtMVehicleNo = new javax.swing.JTextField();
        lblDateM = new javax.swing.JLabel();
        lblEMAmount = new javax.swing.JLabel();
        lblMdate = new javax.swing.JLabel();
        bttnClear1 = new javax.swing.JButton();
        lblM = new javax.swing.JLabel();
        btnMainAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblEMVehicleNo = new javax.swing.JLabel();
        txtAmounta = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMSearch = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblDP = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblExpnRetPrdt = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblDDC = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        lblDDid = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        lblpid = new javax.swing.JLabel();
        lblPName = new javax.swing.JLabel();
        lblDRPid = new javax.swing.JLabel();
        lblPDName = new javax.swing.JLabel();
        lblPNameErr = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtSoldAmount = new javax.swing.JTextField();
        lblSoldAmount = new javax.swing.JLabel();
        chkAllSold = new javax.swing.JCheckBox();
        btnUpdateSales = new javax.swing.JButton();
        lblSoldAmountError = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lblVNO = new javax.swing.JLabel();
        lblDRVno = new javax.swing.JLabel();
        lblroute = new javax.swing.JLabel();
        lblDRRoute = new javax.swing.JLabel();
        RbtnON = new javax.swing.JRadioButton();
        RbtnCame = new javax.swing.JRadioButton();
        jPanel14 = new javax.swing.JPanel();
        cmbPnames = new javax.swing.JComboBox();
        lblRepID = new javax.swing.JLabel();
        txtQTY = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblQty = new javax.swing.JLabel();
        lblREPID = new javax.swing.JLabel();
        lblQerr = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblRange = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dchFrom = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        dchTo = new com.toedter.calendar.JDateChooser();
        btnExpRtPd = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        btnRecord = new javax.swing.JButton();
        btnGenerateReport = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pnlBtn = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        jPanel6.setMaximumSize(new java.awt.Dimension(170, 170));
        jPanel6.setMinimumSize(new java.awt.Dimension(170, 170));
        jPanel6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel6FocusGained(evt);
            }
        });

        tblVehicle1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVehicle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVehicle1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblVehicle1);

        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFuelType.setText("Fuel Type");
        jPanel15.add(lblFuelType, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        lblELastLicenceDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblELastLicenceDate.setMaximumSize(new java.awt.Dimension(170, 170));
        lblELastLicenceDate.setMinimumSize(new java.awt.Dimension(170, 170));
        lblELastLicenceDate.setPreferredSize(new java.awt.Dimension(6, 20));
        jPanel15.add(lblELastLicenceDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 140, 20));

        txtMonthlyRental.setMaximumSize(new java.awt.Dimension(170, 170));
        txtMonthlyRental.setMinimumSize(new java.awt.Dimension(170, 170));
        txtMonthlyRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonthlyRentalActionPerformed(evt);
            }
        });
        txtMonthlyRental.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMonthlyRentalFocusGained(evt);
            }
        });
        jPanel15.add(txtMonthlyRental, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 140, -1));

        lblEMonthlyRental.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblEMonthlyRental.setForeground(new java.awt.Color(255, 0, 0));
        lblEMonthlyRental.setPreferredSize(new java.awt.Dimension(6, 20));
        jPanel15.add(lblEMonthlyRental, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 140, 10));

        lblELastInsuranceDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblELastInsuranceDate.setPreferredSize(new java.awt.Dimension(6, 20));
        jPanel15.add(lblELastInsuranceDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 140, 10));

        cmbAddFtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Diesel", "Petrol" }));
        jPanel15.add(cmbAddFtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 101, 140, -1));

        lblLExpDate.setText("YYYY-MM-DD");
        lblLExpDate.setMaximumSize(new java.awt.Dimension(170, 170));
        lblLExpDate.setMinimumSize(new java.awt.Dimension(170, 170));
        lblLExpDate.setPreferredSize(new java.awt.Dimension(6, 20));
        jPanel15.add(lblLExpDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 150, -1));

        lblMonthlyRental.setText("Monthly Rental");
        jPanel15.add(lblMonthlyRental, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        cmbType1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lorry", "Van", "Demo Batta" }));
        jPanel15.add(cmbType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 53, 140, -1));

        lblLicenceExpiration.setText("Licence exp Date");
        jPanel15.add(lblLicenceExpiration, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        btnDAdd.setText("Add");
        btnDAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDAddActionPerformed(evt);
            }
        });
        jPanel15.add(btnDAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));

        txtVehicleNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVehicleNoActionPerformed(evt);
            }
        });
        txtVehicleNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtVehicleNoFocusGained(evt);
            }
        });
        jPanel15.add(txtVehicleNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 11, 140, -1));

        DchLastLicenceDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DchLastLicenceDatePropertyChange(evt);
            }
        });
        jPanel15.add(DchLastLicenceDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 140, -1));

        lblLastInsuranceDate.setText("Last insurance date");
        jPanel15.add(lblLastInsuranceDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        lblType.setText("Type");
        jPanel15.add(lblType, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        btnVClear.setText("Clear");
        btnVClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVClearActionPerformed(evt);
            }
        });
        jPanel15.add(btnVClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, -1));

        lblLastLicenceDate.setText("Last licence date");
        jPanel15.add(lblLastLicenceDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        lblEVehicleNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblEVehicleNo.setMaximumSize(new java.awt.Dimension(77, 14));
        lblEVehicleNo.setMinimumSize(new java.awt.Dimension(77, 14));
        lblEVehicleNo.setPreferredSize(new java.awt.Dimension(6, 20));
        jPanel15.add(lblEVehicleNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 37, 140, 10));

        lblInsuranceExpirationDate.setText("Insurance exp date");
        jPanel15.add(lblInsuranceExpirationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 100, -1));

        lblInsExpDate.setText("YYYY-MM-DD");
        lblInsExpDate.setMaximumSize(new java.awt.Dimension(170, 170));
        lblInsExpDate.setMinimumSize(new java.awt.Dimension(170, 170));
        lblInsExpDate.setPreferredSize(new java.awt.Dimension(6, 20));
        jPanel15.add(lblInsExpDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 140, -1));

        DchLastInsuranceDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DchLastInsuranceDatePropertyChange(evt);
            }
        });
        jPanel15.add(DchLastInsuranceDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 140, -1));

        lblVehicleNo.setText("Vehicle No");
        jPanel15.add(lblVehicleNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add New Vehicle", jPanel6);

        jPanel3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel3FocusGained(evt);
            }
        });

        tblVehicle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVehicle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVehicleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVehicle);

        txtSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchCaretUpdate(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        jLabel4.setText("Search");

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblLicenceExpiration1.setText("Licence expiration Date");
        lblLicenceExpiration1.setPreferredSize(null);

        txtUpMonthlyRental.setText(" ");

        DchLastInsuranceDate1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DchLastInsuranceDate1PropertyChange(evt);
            }
        });

        DchLastLicenceDate1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DchLastLicenceDate1PropertyChange(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        cmbFuelType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Diesel", "Petrol", " " }));

        txtUpVehicleNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUpVehicleNoFocusGained(evt);
            }
        });

        lblUpMonthlyRental.setText("Monthly rental");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        cmbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lorry", "Van", "Demo Batta" }));
        cmbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTypeActionPerformed(evt);
            }
        });

        lblLastInsuranceDate1.setText("Last insurance date");
        lblLastInsuranceDate1.setPreferredSize(null);

        btnUpAdd.setText("Update");
        btnUpAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpAddActionPerformed(evt);
            }
        });

        lblLastLicenceDate1.setText("Last licence date");
        lblLastLicenceDate1.setPreferredSize(null);

        lblUpFuelType.setText("Fuel type");

        lblUVehicleNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUVehicleNo.setPreferredSize(new java.awt.Dimension(6, 20));

        lblUpVehicleNo.setText("Vehicle no");

        lblUpType.setText("Type");

        lblInsuranceExpirationDate1.setText("Insurance expiration date");
        lblInsuranceExpirationDate1.setPreferredSize(null);

        lblUPINSEXP.setText("YYYY-MM-DD");

        lblUPLINEXPD.setText("YYYY-MM-DD");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblLastInsuranceDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInsuranceExpirationDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLastLicenceDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLicenceExpiration1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUpMonthlyRental)
                            .addComponent(lblUpFuelType)
                            .addComponent(btnUpAdd))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbFuelType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblUPLINEXPD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblUPINSEXP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUpMonthlyRental, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(DchLastInsuranceDate1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(btnClear)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete))
                                .addComponent(DchLastLicenceDate1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUpType)
                            .addComponent(lblUpVehicleNo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUVehicleNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUpVehicleNo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DchLastInsuranceDate1, txtUpMonthlyRental});

        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUpVehicleNo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUpVehicleNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUVehicleNo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUpType)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUpFuelType)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(cmbFuelType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(lblUpMonthlyRental)
                        .addGap(23, 23, 23)
                        .addComponent(lblLastInsuranceDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(txtUpMonthlyRental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DchLastInsuranceDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInsuranceExpirationDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUPINSEXP, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DchLastLicenceDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLastLicenceDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLicenceExpiration1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUPLINEXPD))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpAdd)
                    .addComponent(btnClear)
                    .addComponent(btnDelete))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Update or Delete vehicle", jPanel3);

        tblmain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tblmain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmainMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblmain);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Vehicle No : ");

        lblVnO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lblVID.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel16.setText("Vehicle ID : ");

        tblDDCRoute.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDDCRoute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDDCRouteMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblDDCRoute);

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Daily Delivery  Routine");

        cmbRepName.setEditable(true);
        cmbRepName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbRepName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRepNameActionPerformed(evt);
            }
        });

        txtRoute.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel12.setText("Route :");

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblVnO, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cmbRepName, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtRoute))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVID, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblVID, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel8)
                    .addComponent(lblVnO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbRepName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRoute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        dchMaintain.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dchMaintainFocusGained(evt);
            }
        });
        dchMaintain.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dchMaintainPropertyChange(evt);
            }
        });

        txtMVehicleNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMVehicleNoActionPerformed(evt);
            }
        });
        txtMVehicleNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMVehicleNoFocusGained(evt);
            }
        });

        lblMdate.setText("Date");

        bttnClear1.setText("Clear");
        bttnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnClear1ActionPerformed(evt);
            }
        });

        lblM.setText("Amount");

        btnMainAdd.setText("Add");
        btnMainAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainAddActionPerformed(evt);
            }
        });

        jLabel3.setText("VehicleNo");

        txtAmounta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountaActionPerformed(evt);
            }
        });
        txtAmounta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAmountaFocusGained(evt);
            }
        });

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        txtDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescriptionFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescription);

        jLabel5.setText("Description ");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addGap(64, 64, 64)
                                    .addComponent(lblEMVehicleNo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMVehicleNo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                    .addComponent(lblM)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtAmounta, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(lblMdate)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblDateM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEMAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dchMaintain, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnMainAdd)
                        .addGap(54, 54, 54)
                        .addComponent(bttnClear1))
                    .addComponent(lblDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtMVehicleNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEMVehicleNo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAmounta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEMAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMdate)
                    .addComponent(dchMaintain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDateM, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMainAdd)
                    .addComponent(bttnClear1))
                .addContainerGap())
        );

        jLabel9.setText("Search Vehicle ");

        txtMSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMSearchCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane4)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(80, 80, 80))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(txtMSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Vehicle maintenance", jPanel2);

        tblDP.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDPMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblDP);

        tblExpnRetPrdt.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(tblExpnRetPrdt);

        jLabel13.setText("Daily Delivery Chart");

        jLabel14.setText("Delivery Products");

        tblDDC.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDDC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDDCMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblDDC);

        jLabel15.setText("Expired & Return Products");

        lblDDid.setText("jLabel8");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDDid))
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblDDid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblpid.setText("Product ID:");

        lblPName.setText("Product Name:");

        lblDRPid.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDRPid.setText("#####");

        lblPDName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPDName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPDNameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPNameErr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(lblpid)
                                .addGap(18, 18, 18)
                                .addComponent(lblDRPid, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(lblPName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPDName, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(96, 96, 96))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addComponent(lblPNameErr, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPName)
                    .addComponent(lblPDName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblpid)
                    .addComponent(lblDRPid))
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSoldAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel10.add(txtSoldAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 60, -1));

        lblSoldAmount.setText("Sold Amount");
        jPanel10.add(lblSoldAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        chkAllSold.setSelected(true);
        chkAllSold.setText("All Sold");
        chkAllSold.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkAllSoldMouseClicked(evt);
            }
        });
        jPanel10.add(chkAllSold, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnUpdateSales.setText("Update Sales");
        btnUpdateSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSalesActionPerformed(evt);
            }
        });
        jPanel10.add(btnUpdateSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 30));
        jPanel10.add(lblSoldAmountError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, 20));

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblVNO.setText("Vehicle No :");

        lblDRVno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDRVno.setText("######");

        lblroute.setText("Route :");

        lblDRRoute.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDRRoute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDRRouteMouseClicked(evt);
            }
        });

        btnGrpStatus.add(RbtnON);
        RbtnON.setText("On Route");
        RbtnON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RbtnONMouseClicked(evt);
            }
        });

        btnGrpStatus.add(RbtnCame);
        RbtnCame.setText("Came Back");
        RbtnCame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RbtnCameMouseClicked(evt);
            }
        });
        RbtnCame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtnCameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVNO)
                .addGap(15, 15, 15)
                .addComponent(lblDRVno, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblroute)
                .addGap(8, 8, 8)
                .addComponent(lblDRRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RbtnON)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RbtnCame)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDRRoute, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblVNO)
                        .addComponent(lblDRVno)
                        .addComponent(lblroute)
                        .addComponent(RbtnON)
                        .addComponent(RbtnCame)))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbPnames.setEditable(true);
        cmbPnames.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPnames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPnamesActionPerformed(evt);
            }
        });
        cmbPnames.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmbPnamesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmbPnamesKeyTyped(evt);
            }
        });
        jPanel14.add(cmbPnames, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 29, 155, -1));

        lblRepID.setText("Rep ID : ");
        jPanel14.add(lblRepID, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 32, -1, -1));

        txtQTY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQTYActionPerformed(evt);
            }
        });
        txtQTY.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQTYFocusLost(evt);
            }
        });
        jPanel14.add(txtQTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 29, 58, -1));

        jButton1.setText("Expired");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        lblQty.setText("Quantity");
        jPanel14.add(lblQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 32, -1, -1));

        lblREPID.setText("####");
        jPanel14.add(lblREPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 32, -1, -1));
        jPanel14.add(lblQerr, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 130, 17));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(829, 829, 829))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dalily Delivery Data", jPanel8);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblRange.setText("Range of Dates");

        jLabel1.setText("From");

        jLabel7.setText("To");

        btnExpRtPd.setText("EXP & Return Products");
        btnExpRtPd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpRtPdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblRange)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dchFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dchTo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(btnExpRtPd, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lblRange)
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dchTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(dchFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnExpRtPd))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnRecord.setText("Display Maintain Record");
        btnRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordActionPerformed(evt);
            }
        });

        btnGenerateReport.setText("Vehicle Details Report");
        btnGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnGenerateReport, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnGenerateReport)
                .addGap(59, 59, 59)
                .addComponent(btnRecord)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Delivery report", jPanel5);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 950, 460));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
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

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mainmenubackgroundWindows.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpAddActionPerformed

        Cal cl1 = new Cal();
        boolean chk1 = true;
        boolean b1 = false;
        String dateins;
        String dateInsExp;
        String dateLLicen;
        String dateLicenExp;

        if (txtUpVehicleNo.getText().equals("")) {
            lblUVehicleNo.setForeground(Color.red);
            lblUVehicleNo.setText("* Please Enter Vehicle No");
            chk1 = false;
        }
        if (chk1) {
            DeliveryDAO dao1 = new DeliveryDAO();//creating DAO object
            DeliveryDetails dData = new DeliveryDetails();//creating DeliveryDetails object
            int mrent1 = 0;
            if (!txtUpMonthlyRental.getText().equals("")) {
                mrent1 = Integer.parseInt(txtUpMonthlyRental.getText());
            }
            Cal c = new Cal();
            dateins = c.formatedDate(DchLastInsuranceDate1.getDate().toString());
            // dateInsExp = c.formatedDate(DchlInsuranceExpirationDate1.getDate().toString());
            dateLLicen = c.formatedDate(DchLastLicenceDate1.getDate().toString());
            // dateLicenExp = c.formatedDate(DchLicenceExpiration1.getDate().toString());

            dData.setvNo(txtUpVehicleNo.getText());
            dData.setvType(cmbType.getSelectedItem().toString());
            dData.setfType(cmbFuelType.getSelectedItem().toString());
            dData.setmRent(mrent1);
            dData.setlInDate(dateins);
            // dData.setInsExpDate(dateInsExp);
            dData.setLlicenDate(dateLLicen);
            // dData.setLicenExpDate(dateLicenExp);

            b1 = dao1.updateDeliveryVehical(dData);
        }
        if (b1) {
            JOptionPane.showMessageDialog(null, "Vehicle Successfully updated");
            UpdateClear();

        } else {
            JOptionPane.showMessageDialog(null, "Update Fail");
        }

        loadTable1(txtSearch.getText(), tblVehicle, jScrollPane1);


    }//GEN-LAST:event_btnUpAddActionPerformed

    private void btnMainAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainAddActionPerformed

        Cal cl2 = new Cal();
        boolean chk5 = true;
        boolean b1 = false;
        String datemaintain = "";

        if (txtMVehicleNo.getText().equals("")) {
            lblEMVehicleNo.setForeground(Color.red);
            lblEMVehicleNo.setText("Select Vehicle No");
            chk5 = false;
        }
        if (txtAmounta.getText().equals("")) {
            lblEMAmount.setForeground(Color.red);
            lblEMAmount.setText("Add Amount");
            chk5 = false;
        } else {
            Validation val1 = new Validation();
            boolean b23 = val1.isNumeric(txtAmounta.getText());
            if (!b23) {
                lblEMAmount.setForeground(Color.red);
                lblEMAmount.setText("Invalid Amount");
                chk5 = false;
            }
        }
        if (txtDescription.getText().equals("")) {
            lblDescription.setForeground(Color.red);
            lblDescription.setText("Enter description ");
            chk5 = false;
        }
        try {
            datemaintain = dchMaintain.getDate().toString();
            datemaintain = cl2.formatedDate(datemaintain);
        } catch (NullPointerException ex) {
            lblDateM.setForeground(Color.red);
            lblDateM.setText(" Please Enter Date ");
            chk5 = false;
        }

        if (chk5) {
            DeliveryDAO dao1 = new DeliveryDAO();//creating DAO object
            DeliveryDetails dData = new DeliveryDetails();//creating DeliveryDetails object

            dData.setvNo(txtMVehicleNo.getText());
            dData.setAmount(Float.parseFloat(txtAmounta.getText()));
            dData.setDescription(txtDescription.getText());
            dData.setMaintainDate(datemaintain);

            b1 = dao1.addMaintainVehical(dData);
        }
        if (b1) {
            JOptionPane.showMessageDialog(null, "Successfully added");
            MaintainClear();
            loadTbMaintain(txtMSearch.getText(), tblmain, jScrollPane4);

        } else {
            JOptionPane.showMessageDialog(null, "Fail!");
        }


    }//GEN-LAST:event_btnMainAddActionPerformed

    private void bttnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnClear1ActionPerformed
        MaintainClear();


    }//GEN-LAST:event_bttnClear1ActionPerformed

    private void txtVehicleNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVehicleNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVehicleNoActionPerformed

    private void txtMonthlyRentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonthlyRentalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMonthlyRentalActionPerformed

    private void btnDAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDAddActionPerformed

        Cal cl1 = new Cal();
        boolean chk = true;
        boolean b1 = false;
        String dateLins = "";
        String dateInsExp = "";
        String dateLLicen = "";
        String dateLicenExp = "";
        //validating
        String chek = txtMonthlyRental.getText();
        if (!chek.matches("-?\\d+(\\.\\d+)?")) {
            lblEMonthlyRental.setText("Invalid Monthly Rental");
            chk = false;
        }
        if (txtMonthlyRental.getText().equals("")) {
            txtMonthlyRental.setText("0");
        }
        if (txtVehicleNo.getText().equals("")) {
            lblEVehicleNo.setForeground(Color.red);
            lblEVehicleNo.setText("Enter Vehicle No");
            chk = false;
        }

        try {
            dateLins = DchLastInsuranceDate.getDate().toString();
            dateLins = cl1.formatedDate(dateLins);
        } catch (NullPointerException ex) {
            lblELastInsuranceDate.setForeground(Color.red);
            lblELastInsuranceDate.setText("Enter Last Insurance Date ");
            chk = false;
        }
        try {

            dateInsExp = lblInsExpDate.getText().toString();
            //dateInsExp = cl1.formatedDate(dateInsExp);

        } catch (NullPointerException ex) {
            //      lblEInsuranceExpirationDate.setForeground(Color.red);
            //     lblEInsuranceExpirationDate.setText("Please Enter Insurance Expiration Date");
            //   chk = false;
        }
        try {

            dateLLicen = DchLastLicenceDate.getDate().toString();
            dateLLicen = cl1.formatedDate(dateLLicen);
        } catch (NullPointerException ex) {
            lblELastLicenceDate.setForeground(Color.red);
            lblELastLicenceDate.setText("Enter Last Licence Date");
            chk = false;
        }
        try {

            dateLicenExp = lblLExpDate.getText().toString();
            //dateLicenExp = cl1.formatedDate(dateLicenExp);
        } catch (NullPointerException ex) {
//            lblELicenceExpiration.setForeground(Color.red);
            //          lblELicenceExpiration.setText("Please Enter LicenceExpiration");
            //        chk = false;
        }

        if (chk) {
            DeliveryDAO dao1 = new DeliveryDAO();//creating DAO object
            DeliveryDetails dData = new DeliveryDetails();//creating DeliveryDetails object

            dData.setvNo(txtVehicleNo.getText());
            dData.setvType(cmbType1.getSelectedItem().toString());
            dData.setfType(cmbAddFtype.getSelectedItem().toString());
            dData.setmRent(Float.parseFloat(txtMonthlyRental.getText()));
            dData.setlInDate(dateLins);
            dData.setInsExpDate(dateInsExp);
            dData.setLlicenDate(dateLLicen);
            dData.setLicenExpDate(dateLicenExp);

            b1 = dao1.addDeliveryVehical(dData);
            if (b1) {
                JOptionPane.showMessageDialog(null, "Vehicle Successfully added");
                AddClear();

            } else {
                JOptionPane.showMessageDialog(null, "Faild");
            }

            loadTable(tblVehicle1, jScrollPane3);
        }


    }//GEN-LAST:event_btnDAddActionPerformed

    private void txtVehicleNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVehicleNoFocusGained
        lblEVehicleNo.setText("");
    }//GEN-LAST:event_txtVehicleNoFocusGained

    private void txtMonthlyRentalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMonthlyRentalFocusGained
        lblEMonthlyRental.setText("");
    }//GEN-LAST:event_txtMonthlyRentalFocusGained

    private void DchLastInsuranceDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DchLastInsuranceDateFocusGained

    }//GEN-LAST:event_DchLastInsuranceDateFocusGained

    private void DchLastInsuranceDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DchLastInsuranceDatePropertyChange
        lblELastInsuranceDate.setText("");
        try {
            Cal c = new Cal();
            String insDate = c.formatedDate(DchLastInsuranceDate.getDate().toString());
            lblInsExpDate.setText(incYear(insDate));
        } catch (Exception e) {
            System.out.println(e);
        }

//         loadTable(tblVehicle1, jScrollPane3);
    }//GEN-LAST:event_DchLastInsuranceDatePropertyChange

    private void DchlInsuranceExpirationDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DchlInsuranceExpirationDatePropertyChange
//        lblEInsuranceExpirationDate.setText("");
    }//GEN-LAST:event_DchlInsuranceExpirationDatePropertyChange

    private void DchLastLicenceDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DchLastLicenceDatePropertyChange
        lblELastLicenceDate.setText("");
        try {
            Cal c = new Cal();
            String insDate = c.formatedDate(DchLastLicenceDate.getDate().toString());
            lblLExpDate.setText(incYear(insDate));
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_DchLastLicenceDatePropertyChange

    private void DchLicenceExpirationPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DchLicenceExpirationPropertyChange
        //      lblELicenceExpiration.setText("");
    }//GEN-LAST:event_DchLicenceExpirationPropertyChange

    private void DchLastInsuranceDate1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DchLastInsuranceDate1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_DchLastInsuranceDate1FocusGained

    private void DchLastInsuranceDate1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DchLastInsuranceDate1PropertyChange

        try {
            Cal c = new Cal();
            String insDate = c.formatedDate(DchLastInsuranceDate1.getDate().toString());
            lblUPINSEXP.setText(incYear(insDate));
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_DchLastInsuranceDate1PropertyChange

    private void DchlInsuranceExpirationDate1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DchlInsuranceExpirationDate1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_DchlInsuranceExpirationDate1PropertyChange

    private void DchLastLicenceDate1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DchLastLicenceDate1PropertyChange
        try {
            Cal c = new Cal();
            String insDate = c.formatedDate(DchLastLicenceDate1.getDate().toString());
            lblUPLINEXPD.setText(incYear(insDate));
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_DchLastLicenceDate1PropertyChange

    private void DchLicenceExpiration1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DchLicenceExpiration1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_DchLicenceExpiration1PropertyChange

    private void btnVClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVClearActionPerformed

        AddClear();

    }//GEN-LAST:event_btnVClearActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        UpdateClear();

    }//GEN-LAST:event_btnClearActionPerformed

    private void txtUpVehicleNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUpVehicleNoFocusGained
        lblUVehicleNo.setText("");
    }//GEN-LAST:event_txtUpVehicleNoFocusGained

    private void tblVehicleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVehicleMouseClicked

        int row = tblVehicle.getSelectedRow();
        txtUpVehicleNo.setText(tblVehicle.getValueAt(row, 1).toString());
        cmbType.setSelectedItem(tblVehicle.getValueAt(row, 2).toString());
        cmbFuelType.setSelectedItem(tblVehicle.getValueAt(row, 3).toString());
        txtUpMonthlyRental.setText(tblVehicle.getValueAt(row, 4).toString());
        txtMVehicleNo.setText(tblVehicle.getValueAt(row, 1).toString());
        try {

            java.util.Date date;
            date = new SimpleDateFormat("yyyy-MM-dd").parse(tblVehicle.getValueAt(row, 5).toString());
            DchLastInsuranceDate1.setDate(date);
            //  date = new SimpleDateFormat("yyyy-MM-dd").parse(tblVehicle.getValueAt(row, 6).toString());
            //  DchlInsuranceExpirationDate1.setDate(date);
            date = new SimpleDateFormat("yyyy-MM-dd").parse(tblVehicle.getValueAt(row, 7).toString());
            DchLastLicenceDate1.setDate(date);
//            date = new SimpleDateFormat("yyyy-MM-dd").parse(tblVehicle.getValueAt(row, 8).toString());
//            DchLicenceExpiration1.setDate(date);

        } catch (ParseException ex) {
            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
            // JOptionPane.showMessageDialog(txtAmount, "aaaaaaaaaaaa");
        }

//         String st = tblVehicle.getValueAt(row, 5).toString();
//         java.util.Date dt = null;
//        try {
//            dt = new SimpleDateFormat("dd-mm-yyyy").parse(st);
//        } catch (ParseException ex) {
//            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(txtAmount, st);
//        }
//         
        // DchLastInsuranceDate1.setDate(null);

    }//GEN-LAST:event_tblVehicleMouseClicked

    private void txtDescriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescriptionFocusGained
        lblDescription.setText("");
    }//GEN-LAST:event_txtDescriptionFocusGained

    private void dchMaintainFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dchMaintainFocusGained
        lblDateM.setText("");
    }//GEN-LAST:event_dchMaintainFocusGained

    private void dchMaintainPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dchMaintainPropertyChange
        lblDateM.setText("");
    }//GEN-LAST:event_dchMaintainPropertyChange

    private void tblVehicle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVehicle1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblVehicle1MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//            loadTbMaintain();
        txtMVehicleNo.setEditable(false);
        loadTable1(txtSearch.getText(), tblVehicle, jScrollPane1);
        loadTable(tblVehicle1, jScrollPane3);
        loadTbMaintain(txtMSearch.getText(), tblmain, jScrollPane4);
        lblSoldAmount.setVisible(!chkAllSold.isSelected());
        txtSoldAmount.setVisible(!chkAllSold.isSelected());
    }//GEN-LAST:event_formWindowOpened

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

// TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void jPanel6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel6FocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel6FocusGained

    private void jPanel3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel3FocusGained


    }//GEN-LAST:event_jPanel3FocusGained

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

// TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

        loadTable1(txtSearch.getText(), tblVehicle1, jScrollPane3);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    private void tblmainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmainMouseClicked
        int row = tblmain.getSelectedRow();
        txtMVehicleNo.setText(tblmain.getValueAt(row, 1).toString());
        lblVnO.setText(tblmain.getValueAt(row, 1).toString());
        lblVID.setText(tblmain.getValueAt(row, 0).toString());

    }//GEN-LAST:event_tblmainMouseClicked

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
    }//GEN-LAST:event_txtSearchKeyTyped

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        loadTable1(txtSearch.getText(), tblVehicle, jScrollPane1);
    }//GEN-LAST:event_txtSearchCaretUpdate

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        boolean del = false;

        DeliveryDAO d = new DeliveryDAO();
        int row = tblVehicle.getSelectedRow();
        if (row >= 0) {
            int a = JOptionPane.showConfirmDialog(null, "do you want to delete!");
            if (a == JOptionPane.YES_OPTION) {
                String vno = tblVehicle.getValueAt(row, 1).toString();
                String vId = tblVehicle.getValueAt(row, 0).toString();
                del = d.DeleteDeliveryVehical(vId, vno);
                if (del) {
                    txtSearch.setText("");
                    loadTable1(txtSearch.getText(), tblVehicle, jScrollPane1);
                    UpdateClear();
                    JOptionPane.showMessageDialog(null, "Successfully Deleted");
                }

            }
            if (a == JOptionPane.NO_OPTION) {
                UpdateClear();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please Select a vehicle");
        }
        // del = d.DeleteDeliveryVehical("","");

//         if(del)
//         {
//           JOptionPane.showMessageDialog(null, "Successfully Deleted");
//            UpdateClear();
//             loadTable1( , null, null);
//        }
//        else
//            JOptionPane.showMessageDialog(null, "Fail");
//         }
//         

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

//        loadTable1(txtSearch.getText(),tblVehicle,jScrollPane1);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtMVehicleNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMVehicleNoFocusGained
        lblEMVehicleNo.setText("");

    }//GEN-LAST:event_txtMVehicleNoFocusGained

    private void txtMVehicleNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMVehicleNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMVehicleNoActionPerformed

    private void txtAmountaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmountaFocusGained
        lblEMAmount.setText("");
    }//GEN-LAST:event_txtAmountaFocusGained

    private void txtAmountaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountaActionPerformed

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

        int a = JOptionPane.showConfirmDialog(rootPane, "Do you want to exit");
        if (a == JOptionPane.YES_OPTION) {
            this.dispose();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReportActionPerformed
        HashMap hm = new HashMap();
        Cal cl = new Cal();

        ReportView r = new ReportView("C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaApplication9\\src\\iReport\\VehicleDetailsreport.jasper", hm);
        r.setVisible(true);
    }//GEN-LAST:event_btnGenerateReportActionPerformed

    private void btnRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordActionPerformed

        HashMap hm = new HashMap();
        Cal cl = new Cal();

        ReportView r = new ReportView("C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaApplication9\\src\\iReport\\MaintaunDetails.jasper", hm);
        r.setVisible(true);
    }//GEN-LAST:event_btnRecordActionPerformed

    private void tblDDCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDDCMouseClicked
        int row = tblDDC.getSelectedRow();
        loadTbDeliveryProduct(tblDP, jScrollPane9, tblDDC.getValueAt(row, 0).toString());
        lblDRVno.setText(tblDDC.getValueAt(row, 2).toString());
        lblDRRoute.setText(tblDDC.getValueAt(row, 4).toString());
        lblDDid.setText(tblDDC.getValueAt(row, 0).toString());
        if (tblDDC.getValueAt(row, 5).toString().equalsIgnoreCase("On Route")) {
            RbtnON.setSelected(true);
        }
        if (tblDDC.getValueAt(row, 5).toString().equalsIgnoreCase("Came Back")) {
            RbtnCame.setSelected(true);
        }

        lblREPID.setText(tblDDC.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tblDDCMouseClicked

    private void tblDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDPMouseClicked
        int row = tblDP.getSelectedRow();
        lblDRPid.setText(tblDP.getValueAt(row, 3).toString());

        lblPDName.setText(tblDP.getValueAt(row, 2).toString());
        lblPNameErr.setText("");
    }//GEN-LAST:event_tblDPMouseClicked

    private void chkAllSoldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkAllSoldMouseClicked

        lblSoldAmount.setVisible(!chkAllSold.isSelected());
        txtSoldAmount.setVisible(!chkAllSold.isSelected());

    }//GEN-LAST:event_chkAllSoldMouseClicked

    private void RbtnCameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtnCameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbtnCameActionPerformed

    private void lblDRRouteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDRRouteMouseClicked

    }//GEN-LAST:event_lblDRRouteMouseClicked

    private void cmbPnamesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbPnamesKeyReleased
        fillPronames(cmbPnames.getSelectedItem().toString());
        cmbPnames.showPopup();

    }//GEN-LAST:event_cmbPnamesKeyReleased

    private void btnUpdateSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSalesActionPerformed
        // addSales(int qty, String vNo,int m)
        DailyDeliveryDAO dao1 = new DailyDeliveryDAO();

        int row = tblDP.getSelectedRow();
        int row2 = tblDDC.getSelectedRow();
        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = true;
        boolean b4 = true;

        if (tblDP.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a row from Delivery Products");
            b3 = false;
        }
        if (tblDP.getValueAt(row, 4).toString().equals("0")) {
            JOptionPane.showMessageDialog(rootPane, "No products in the vehicle ");
            b4 = false;
        }

        if (b3 && b4) {
            if (chkAllSold.isSelected()) {
                b1 = dao1.addSales(Integer.parseInt(tblDP.getValueAt(row, 4).toString()),
                        tblDDC.getValueAt(row2, 2).toString(),
                        Integer.parseInt(tblDP.getValueAt(row, 3).toString()));
                dao1.updateQuantity(0, Integer.parseInt(tblDP.getValueAt(row, 1).toString()));
                System.out.println("b1 " + b1);
                if (b1) {
                    loadTbDeliveryProduct(tblDP, jScrollPane9, lblDDid.getText());
                    JOptionPane.showMessageDialog(null, "Succesfully added to profit");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed  to add to profit");
                }

            } else {
                if (txtSoldAmount.getText().equals("")) {
                    lblSoldAmountError.setForeground(Color.red);
                    lblSoldAmountError.setText("Enter Sold Amount!");

                }
                b1 = dao1.addSales(Integer.parseInt(txtSoldAmount.getText()),
                        tblDDC.getValueAt(row2, 2).toString(),
                        Integer.parseInt(tblDP.getValueAt(row, 3).toString()));
                loadTbDeliveryProduct(tblDP, jScrollPane9, lblDDid.getText());

                int itmamt = (Integer.parseInt(tblDP.getValueAt(row, 4).toString()) - Integer.parseInt(txtSoldAmount.getText()));
                System.out.println("amt " + itmamt);
                b2 = dao1.updatetoStock(Integer.parseInt(tblDP.getValueAt(row, 5).toString()), itmamt);
                dao1.updateQuantity(0, Integer.parseInt(tblDP.getValueAt(row, 1).toString()));
                System.out.println("b1 " + b1 + "b2  " + b2);
                if (b1 && b2) {
                    JOptionPane.showMessageDialog(null, "Succesfully added to profit and updated stock");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed  to add to profit");
                }

            }

        }
    }//GEN-LAST:event_btnUpdateSalesActionPerformed

    private void cmbPnamesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbPnamesKeyTyped


    }//GEN-LAST:event_cmbPnamesKeyTyped

    private void lblPDNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPDNameMouseClicked

    }//GEN-LAST:event_lblPDNameMouseClicked

    private void cmbPnamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPnamesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPnamesActionPerformed

    private void RbtnONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RbtnONMouseClicked
        int row = tblDDC.getSelectedRow();

        DailyDeliveryDAO dao12 = new DailyDeliveryDAO();
        if (RbtnON.isSelected()) {
            if (tblDDC.getSelectedRowCount() == 1) {
                dao12.updatestatus("On Route", Integer.parseInt(tblDDC.getValueAt(row, 0).toString()));
                loadTbDailyDelivery(tblDDC, jScrollPane8);
            } else {
                JOptionPane.showMessageDialog(null, "please select a row from the DDC table");
            }
        }


    }//GEN-LAST:event_RbtnONMouseClicked

    private void RbtnCameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RbtnCameMouseClicked
        int row = tblDDC.getSelectedRow();

        DailyDeliveryDAO dao12 = new DailyDeliveryDAO();
        if (RbtnCame.isSelected()) {
            if (tblDDC.getSelectedRowCount() == 1) {
                dao12.updatestatus("Came Back", Integer.parseInt(tblDDC.getValueAt(row, 0).toString()));
                loadTbDailyDelivery(tblDDC, jScrollPane8);
            } else {
                JOptionPane.showMessageDialog(null, "please select a row from the DDC table");
            }
        }
    }//GEN-LAST:event_RbtnCameMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtQTY.getText().equals("")) {
            lblQerr.setForeground(Color.red);
            lblQerr.setText("* Please Enter Rejected Quantity!");
        }

        DeliveryReturnDetails d = new DeliveryReturnDetails();
        d.setProuct_name(cmbPnames.getSelectedItem().toString());
        d.setQuantity(Integer.parseInt(txtQTY.getText()));

        DailyDeliveryDAO doq13 = new DailyDeliveryDAO();
        boolean b121 = doq13.addExpired(d);
        if (txtQTY.getText().equals("")) {
            lblQerr.setForeground(Color.red);
            lblQerr.setText("* Please Enter Rejected Quantity!");
        }
        if (b121) {
            JOptionPane.showMessageDialog(null, " Successfully Added");
        } else {

            JOptionPane.showMessageDialog(null, "Fail");
        }
        loadTbExpRtProduct(tblExpnRetPrdt, jScrollPane10);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtQTYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQTYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQTYActionPerformed

    private void txtQTYFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQTYFocusLost
        lblQerr.setText("");
    }//GEN-LAST:event_txtQTYFocusLost

    private void tblDDCRouteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDDCRouteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDDCRouteMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String Vno = lblVnO.getText();
        String route = txtRoute.getText();

        String repId = cmbRepName.getSelectedItem().toString().split(" ")[2];
        boolean chk = true;
        if (route.equals("")) {
            chk = false;
            JOptionPane.showMessageDialog(rootPane, Vno + " Please Enter a route");
        }
        DailyDeliveryDAO dao1 = new DailyDeliveryDAO();
        boolean b1 = false;
        boolean b2 = false;
        if (chk) {
            b2 = dao1.validateEntry(repId, Vno);

            if (b2) {
                if (tblmain.getSelectedRowCount() == 1) {
                    b1 = dao1.addVehiclesToDailyRoutine(Vno, route, repId);
                    if (b1) {
                        JOptionPane.showMessageDialog(rootPane, Vno + " Successfully added to the route");
                        loadTbDailyDelivery(tblDDCRoute, jScrollPane11);

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Failed to add to route");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Please Select a vehicle from the Table");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "You can not add this combination. Please Select a different !");
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        lblVnO.setText("");
        lblVID.setText("");
        txtRoute.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtMSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMSearchCaretUpdate
        loadTbMaintain(txtMSearch.getText(), tblmain, jScrollPane4);

    }//GEN-LAST:event_txtMSearchCaretUpdate

    private void btnExpRtPdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpRtPdActionPerformed

        Cal cl = new Cal();
        String d1 = cl.formatedDate(dchFrom.getDate().toString());
        String d2 = cl.formatedDate(dchTo.getDate().toString());
        
        boolean d = cl.isValidRanage(d1, d2);
        if(d)
        {
        
        HashMap hm = new HashMap();
      
        boolean b1 = true;
        try {
            hm.put("PARA_DATE_FROM", cl.formatedDate(dchFrom.getDate().toString()));
            hm.put("PARA_DATE_TO", cl.formatedDate(dchTo.getDate().toString()));
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Please Select Range of dates");
            b1 = false;
        }
        if (b1) {
            ReportView r = new ReportView("C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaApplication9\\src\\iReport\\ReturnProductDetails.jasper", hm);
            r.setVisible(true);
        }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Enter Valid Date Range !");
        }

    }//GEN-LAST:event_btnExpRtPdActionPerformed

    private void cmbRepNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRepNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRepNameActionPerformed

    private void cmbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTypeActionPerformed

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
            java.util.logging.Logger.getLogger(Delivery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Delivery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Delivery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Delivery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Delivery().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DchLastInsuranceDate;
    private com.toedter.calendar.JDateChooser DchLastInsuranceDate1;
    private com.toedter.calendar.JDateChooser DchLastLicenceDate;
    private com.toedter.calendar.JDateChooser DchLastLicenceDate1;
    private javax.swing.JRadioButton RbtnCame;
    private javax.swing.JRadioButton RbtnON;
    private javax.swing.ButtonGroup a;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnExpRtPd;
    private javax.swing.JButton btnGenerateReport;
    private javax.swing.ButtonGroup btnGrpStatus;
    private javax.swing.JButton btnMainAdd;
    private javax.swing.JButton btnRecord;
    private javax.swing.JButton btnUpAdd;
    private javax.swing.JButton btnUpdateSales;
    private javax.swing.JButton btnVClear;
    private javax.swing.JButton bttnClear1;
    private javax.swing.JCheckBox chkAllSold;
    private javax.swing.JComboBox cmbAddFtype;
    private javax.swing.JComboBox cmbFuelType;
    private javax.swing.JComboBox cmbPnames;
    private javax.swing.JComboBox cmbRepName;
    private javax.swing.JComboBox cmbType;
    private javax.swing.JComboBox cmbType1;
    private com.toedter.calendar.JDateChooser dchFrom;
    private com.toedter.calendar.JDateChooser dchMaintain;
    private com.toedter.calendar.JDateChooser dchTo;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDDid;
    private javax.swing.JLabel lblDRPid;
    private javax.swing.JLabel lblDRRoute;
    private javax.swing.JLabel lblDRVno;
    private javax.swing.JLabel lblDateM;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblELastInsuranceDate;
    private javax.swing.JLabel lblELastLicenceDate;
    private javax.swing.JLabel lblEMAmount;
    private javax.swing.JLabel lblEMVehicleNo;
    private javax.swing.JLabel lblEMonthlyRental;
    private javax.swing.JLabel lblEVehicleNo;
    private javax.swing.JLabel lblFuelType;
    private javax.swing.JLabel lblInsExpDate;
    private javax.swing.JLabel lblInsuranceExpirationDate;
    private javax.swing.JLabel lblInsuranceExpirationDate1;
    private javax.swing.JLabel lblLExpDate;
    private javax.swing.JLabel lblLastInsuranceDate;
    private javax.swing.JLabel lblLastInsuranceDate1;
    private javax.swing.JLabel lblLastLicenceDate;
    private javax.swing.JLabel lblLastLicenceDate1;
    private javax.swing.JLabel lblLicenceExpiration;
    private javax.swing.JLabel lblLicenceExpiration1;
    private javax.swing.JLabel lblM;
    private javax.swing.JLabel lblMdate;
    private javax.swing.JLabel lblMonthlyRental;
    private javax.swing.JLabel lblPDName;
    private javax.swing.JLabel lblPName;
    private javax.swing.JLabel lblPNameErr;
    private javax.swing.JLabel lblQerr;
    private javax.swing.JLabel lblQty;
    private javax.swing.JLabel lblREPID;
    private javax.swing.JLabel lblRange;
    private javax.swing.JLabel lblRepID;
    private javax.swing.JLabel lblSoldAmount;
    private javax.swing.JLabel lblSoldAmountError;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblUPINSEXP;
    private javax.swing.JLabel lblUPLINEXPD;
    private javax.swing.JLabel lblUVehicleNo;
    private javax.swing.JLabel lblUpFuelType;
    private javax.swing.JLabel lblUpMonthlyRental;
    private javax.swing.JLabel lblUpType;
    private javax.swing.JLabel lblUpVehicleNo;
    private javax.swing.JLabel lblVID;
    private javax.swing.JLabel lblVNO;
    private javax.swing.JLabel lblVehicleNo;
    private javax.swing.JLabel lblVnO;
    private javax.swing.JLabel lblpid;
    private javax.swing.JLabel lblroute;
    private javax.swing.JButton logout;
    private javax.swing.JPanel pnlBtn;
    private javax.swing.JTable tblDDC;
    private javax.swing.JTable tblDDCRoute;
    private javax.swing.JTable tblDP;
    private javax.swing.JTable tblExpnRetPrdt;
    private javax.swing.JTable tblVehicle;
    private javax.swing.JTable tblVehicle1;
    private javax.swing.JTable tblmain;
    private javax.swing.JTextField txtAmounta;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtMSearch;
    private javax.swing.JTextField txtMVehicleNo;
    private javax.swing.JTextField txtMonthlyRental;
    private javax.swing.JTextField txtQTY;
    private javax.swing.JTextField txtRoute;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoldAmount;
    private javax.swing.JTextField txtUpMonthlyRental;
    private javax.swing.JTextField txtUpVehicleNo;
    private javax.swing.JTextField txtVehicleNo;
    // End of variables declaration//GEN-END:variables
}
