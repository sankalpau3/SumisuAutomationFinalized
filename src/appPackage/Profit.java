/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appPackage;

import DAO.LoanDAO;
import DAO.ProfitDAO;
import DAO.TaxDAO;
import data.ReportView;
import data.*;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.HeadlessException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.lang.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 *
 * @author Sanke
 */
public class Profit extends javax.swing.JFrame {

    private Vector<Vector<String>> data; //Used for data from database
    private Vector<String> header; //Used to store data header
    private Vector<Vector<String>> dataLoan; //Used for data from database
    private Vector<String> headerLoan; //Used to store data header
    private Vector<Vector<String>> dataTax; //Used for data from database
    private Vector<String> headerTax; //Used to store data header
    private boolean chkUpRm = false, chkValidate = true, chkValidate1 = true;

    /**
     * Creates new form Profit
     */
    public Profit() {
        initComponents();
        //   txtTmode.setVisible(false);
        header = new Vector<String>();
        header.add("Transaction ID");
        header.add("Transaction Type");
        header.add("Date");
        header.add("Description");
        header.add("Amount");
        header.add("Transaction");

        General.setBackground(new Color(0, 0, 0, 0));

        //loan
        headerLoan = new Vector<String>();
        headerLoan.add("Loan ID");
        headerLoan.add("Amount");
        headerLoan.add("Date");
        headerLoan.add("Duration");
        headerLoan.add("Discription");
        headerLoan.add("Interest Rate");
        headerLoan.add("Acc NO");
        headerLoan.add("Finance Insitute");
        headerLoan.add("Branch");
        headerLoan.add("No of Installments Paid");
        headerLoan.add("Last Date Paid");
        headerLoan.add("No of Instlmnt");
        headerLoan.add("Min Amount Instlmnt");
        //loan end

        //tax
        headerTax = new Vector<String>();
        headerTax.add("Tax ID");
        headerTax.add("Invoice No");
        headerTax.add("Date");
        headerTax.add("Type");
        headerTax.add("Amount");
        headerTax.add("Quartile");
        headerTax.add("Discription");

        //tax End
        loadTable();
        loadTableLoan();
        loadTableTax();
        fillTransactionModes();
        fillTransactionModesAtType(cmbttype1.getSelectedItem().toString());
        AutoCompletion.enable(cmbtmode);

        //
        lbltmodeOther.setVisible(false);
        txtOtherTmode.setVisible(false);
        //
    }

    private void loadTable() {

        ProfitDAO dao = new ProfitDAO();
        data = dao.getProfit();

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
                data, header));
        jScrollPane2.setViewportView(tbl1);

        try {
            Cal newc1 = new Cal();
            String datenew = newc1.formatedDate(dchSearchd.getDate().toString());
            String tType = cmbttype1.getSelectedItem().toString();
            System.out.println(datenew);
            loadTableFiltered("", "", "");
        } catch (Exception ex) {
        }
    }//end of loadTable

    private void loadTableTax() {

        TaxDAO dao = new TaxDAO();
        dataTax = dao.getTaxInfo();

        tblTax.setModel(new javax.swing.table.DefaultTableModel(dataTax, headerTax));
        jScrollPane3.setViewportView(tblTax);
    }//end of loadTableTax

    private void loadTableLoan() {

        LoanDAO dao = new LoanDAO();
        dataLoan = dao.getLoan();

        tblLoan.setModel(new javax.swing.table.DefaultTableModel(
                dataLoan, headerLoan));
        jscpLoan.setViewportView(tblLoan);

    }//end of loadTableLoan

    private void loadTableFiltered(String date, String Ttype, String TransAct) {

        ProfitDAO dao = new ProfitDAO();
        if (Ttype.equalsIgnoreCase(" ")) {

            if (TransAct.equalsIgnoreCase(" ")) {
                data = dao.getProfitFiltered(date, "", "");
            } else {
                data = dao.getProfitFiltered(date, "", TransAct);
            }

        } else {
            if (TransAct.equalsIgnoreCase(" ")) {
                data = dao.getProfitFiltered(date, Ttype, "");
            } else {
                data = dao.getProfitFiltered(date, Ttype, TransAct);
            }
        }

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
                data, header));
        jScrollPane2.setViewportView(tbl1);
    }//end of load tableFiltered

    Validation val1 = new Validation();

    private void clearAll() {
        txtamt.setText("");
        txtarea.setText("");
        dchsdate.setDate(null);
        lblstfid.setText("");
        txtOtherTmode.setText("");
        cmbtmode.setSelectedIndex(0);
    }

    private void fillTransactionModes() {
        cmbtmode.removeAllItems();
        cmbtmode1.removeAllItems();
        try {
            ProfitDAO dao11 = new ProfitDAO();
            ProfitDAO dao111 = new ProfitDAO();
            ArrayList jobCatList = dao11.getTansactionModes();
            ArrayList jobCatList1 = dao111.getTansactionModes();

            cmbtmode1.addItem("");
            Iterator i = jobCatList.iterator();
            Iterator ii = jobCatList1.iterator();

            while (i.hasNext() && ii.hasNext()) {
                cmbtmode.addItem(i.next());
                cmbtmode1.addItem(ii.next());

            }

            //cmbtmode.addItem("Other");
        } catch (Exception e) {
        }

    }

    private void fillTransactionModesAtType(String mode) {

        cmbtmode1.removeAllItems();
        try {
            ProfitDAO dao11 = new ProfitDAO();

            ArrayList jobCatList = dao11.getTansactionType(mode);

            cmbtmode1.addItem("");
            Iterator i = jobCatList.iterator();

            while (i.hasNext()) {

                cmbtmode1.addItem(i.next());

            }

            //cmbtmode.addItem("Other");
        } catch (Exception e) {
        }

    }

    private void selectRow() {

        //retrieving the selected row index
        int row = tbl1.getSelectedRow();

        //if a single row is selected from the table, take each cell values into the controls
        if (tbl1.getRowSelectionAllowed()) {

            lblstfid.setText(tbl1.getValueAt(row, 0).toString());
            txtamt.setText(tbl1.getValueAt(row, 4).toString());
            txtarea.setText(tbl1.getValueAt(row, 3).toString());
            cmbtmode.setSelectedItem(tbl1.getValueAt(row, 5).toString());
            cmbttype.setSelectedItem(tbl1.getValueAt(row, 1).toString());

            java.util.Date date;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(tbl1.getValueAt(row, 2).toString());
                dchsdate.setDate(date);
            } catch (ParseException ex) {
                Logger.getLogger(Profit.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void clearTax() {
        txtInvoNoTax.setText("");
        lblErrInvoNo.setText("");
        dchTax.setDate(null);
        lblerrdate.setText("");
        TxtAmtTax.setText("");
        lblErrAmt.setText("");
        txtAOtherTax.setText("");
    }

    private boolean taxValidation() {
        Validation val = new Validation();
        boolean chkval = true;
        if (txtInvoNoTax.getText().equals("")) {
            chkval = false;
            lblErrInvoNo.setText("Can not be empty");
        }

        try {

            dchTax.getDate().toString();

        } catch (NullPointerException e) {
            chkval = false;
            lblerrdate.setText("Please Select");
        }
        if (TxtAmtTax.getText().equals("")) {
            chkval = false;
            lblErrAmt.setText("Can not be empty");
        } else {
            if (!val.isNumeric(TxtAmtTax.getText())) {
                chkval = false;
                lblErrAmt.setText("Invalid");
            }
        }
        return chkval;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        General = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblTitle2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel12 = new javax.swing.JPanel();
        btnslctrm = new javax.swing.JButton();
        lblsystmdate = new javax.swing.JLabel();
        btnslctupd = new javax.swing.JButton();
        txtamt = new javax.swing.JTextField();
        txta1 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        dchSearchd = new com.toedter.calendar.JDateChooser();
        cmbtmode1 = new javax.swing.JComboBox();
        cmbttype1 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lblerroramt = new javax.swing.JLabel();
        dchsdate = new com.toedter.calendar.JDateChooser();
        lblerrdate = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnslctadd = new javax.swing.JButton();
        lblstfid = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        btnupd = new javax.swing.JButton();
        btnclr = new javax.swing.JButton();
        btnrm = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cmbttype = new javax.swing.JComboBox();
        cmbtmode = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        txtOtherTmode = new javax.swing.JTextField();
        lbltmodeOther = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnAddIns = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblLoanId = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtamtLoan = new javax.swing.JFormattedTextField();
        dchLoan = new com.toedter.calendar.JDateChooser();
        lblEamountLoan = new javax.swing.JLabel();
        lblEdateLoan = new javax.swing.JLabel();
        lblELid = new javax.swing.JLabel();
        btnCompleteLoan = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnAddLoan = new javax.swing.JButton();
        btnUpdateLoan = new javax.swing.JButton();
        jscpLoan = new javax.swing.JScrollPane();
        tblLoan = new javax.swing.JTable();
        lblTitle1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTax = new javax.swing.JTable();
        lblErrDpaid = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        lblTaxType = new javax.swing.JLabel();
        lblDatepaid = new javax.swing.JLabel();
        lblErrAmt = new javax.swing.JLabel();
        dchTax = new com.toedter.calendar.JDateChooser();
        lblErrQuat = new javax.swing.JLabel();
        lblOther = new javax.swing.JLabel();
        lblInvoiceNo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAOtherTax = new javax.swing.JTextArea();
        lblErrTaxType = new javax.swing.JLabel();
        lblQuartile = new javax.swing.JLabel();
        TxtAmtTax = new javax.swing.JTextField();
        lblErrInvoNo = new javax.swing.JLabel();
        txtInvoNoTax = new javax.swing.JTextField();
        cmbQuatTax = new javax.swing.JComboBox();
        cmbTypeTax = new javax.swing.JComboBox();
        lblErrDatePaid = new javax.swing.JLabel();
        btnAdd1 = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        dchRptFdate = new com.toedter.calendar.JDateChooser();
        dchRptLdate = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        cmbQuatTax1 = new javax.swing.JComboBox();
        pnlBtn = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        General.setMinimumSize(new java.awt.Dimension(1366, 768));
        General.setPreferredSize(new java.awt.Dimension(1000, 768));
        General.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                GeneralFocusGained(evt);
            }
        });

        jPanel2.setPreferredSize(new java.awt.Dimension(700, 740));

        lblTitle2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitle2.setText("Genarl");

        btnslctrm.setText("Remove");
        btnslctrm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnslctrmActionPerformed(evt);
            }
        });

        lblsystmdate.setText("#######");

        btnslctupd.setText("Update");
        btnslctupd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnslctupdActionPerformed(evt);
            }
        });

        txtamt.setEnabled(false);
        txtamt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtamtCaretUpdate(evt);
            }
        });
        txtamt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamtActionPerformed(evt);
            }
        });
        txtamt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtamtFocusGained(evt);
            }
        });

        txtarea.setColumns(3);
        txtarea.setRows(2);
        txtarea.setEnabled(false);
        txtarea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtareaFocusGained(evt);
            }
        });
        txta1.setViewportView(txtarea);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setFocusable(false);
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dchSearchd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dchSearchdFocusLost(evt);
            }
        });
        dchSearchd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dchSearchdPropertyChange(evt);
            }
        });
        dchSearchd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dchSearchdKeyReleased(evt);
            }
        });
        jPanel8.add(dchSearchd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 15, 136, -1));

        cmbtmode1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Salary pay" }));
        cmbtmode1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbtmode1ItemStateChanged(evt);
            }
        });
        cmbtmode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtmode1ActionPerformed(evt);
            }
        });
        jPanel8.add(cmbtmode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 13, 129, -1));

        cmbttype1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Debit", "Credit" }));
        cmbttype1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbttype1MouseClicked(evt);
            }
        });
        cmbttype1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbttype1ItemStateChanged(evt);
            }
        });
        jPanel8.add(cmbttype1, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 13, 78, -1));

        jScrollPane2.setEnabled(false);
        jScrollPane2.setMaximumSize(new java.awt.Dimension(547, 100));

        tbl1.setAutoCreateRowSorter(true);
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbl1.setAutoscrolls(false);
        tbl1.setFillsViewportHeight(true);
        tbl1.setFocusCycleRoot(true);
        tbl1.setOpaque(false);
        tbl1.setRowHeight(17);
        tbl1.setRowMargin(0);
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl1);

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 43, 537, 146));

        jLabel8.setText("Transaction ID");

        lblerroramt.setForeground(new java.awt.Color(204, 0, 0));

        dchsdate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dchsdatePropertyChange(evt);
            }
        });

        lblerrdate.setForeground(new java.awt.Color(204, 0, 0));
        lblerrdate.setText(" ");

        jLabel6.setText("Amount");

        jLabel2.setText("System Date");

        btnslctadd.setText("Add New");
        btnslctadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnslctaddActionPerformed(evt);
            }
        });

        lblstfid.setText("#######");

        jLabel3.setText("Date");

        jLabel4.setText("Description");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(lblerroramt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txta1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtamt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(280, 280, 280)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dchsdate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblerrdate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnslctadd)
                        .addGap(73, 73, 73)
                        .addComponent(btnslctupd, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(btnslctrm, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(lblstfid, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lblsystmdate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnslctadd)
                    .addComponent(btnslctupd)
                    .addComponent(btnslctrm))
                .addGap(8, 8, 8)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(lblstfid)
                    .addComponent(jLabel2)
                    .addComponent(lblsystmdate))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtamt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblerroramt, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dchsdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lblerrdate)))
                .addGap(6, 6, 6)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txta1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txtamt.getAccessibleContext().setAccessibleName("");
        txtamt.getAccessibleContext().setAccessibleDescription("");

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnupd.setText("Update");
        btnupd.setEnabled(false);
        btnupd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdActionPerformed(evt);
            }
        });

        btnclr.setText("Clear");
        btnclr.setEnabled(false);
        btnclr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclrActionPerformed(evt);
            }
        });

        btnrm.setText("Remove");
        btnrm.setEnabled(false);
        btnrm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrmActionPerformed(evt);
            }
        });

        btnadd.setText("Add");
        btnadd.setEnabled(false);
        btnadd.setMaximumSize(new java.awt.Dimension(71, 23));
        btnadd.setMinimumSize(new java.awt.Dimension(71, 23));
        btnadd.setPreferredSize(new java.awt.Dimension(71, 23));
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnrm, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnupd, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclr, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnrm, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnupd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnclr, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnadd, btnclr, btnrm, btnupd});

        jPanel14.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 190));

        jLabel7.setText("Transaction Mode");

        cmbttype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Debit", "Credit" }));
        cmbttype.setEnabled(false);

        cmbtmode.setEditable(true);
        cmbtmode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Salary pay", "Supplier Pay", "Maintainence Cost", "Pety cash", "Bank Fee", " " }));
        cmbtmode.setEnabled(false);
        cmbtmode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbtmodeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbtmodeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmbtmodeMouseReleased(evt);
            }
        });
        cmbtmode.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbtmodePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbtmode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbtmodeItemStateChanged(evt);
            }
        });
        cmbtmode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtmodeActionPerformed(evt);
            }
        });
        cmbtmode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbtmodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbtmodeFocusLost(evt);
            }
        });
        cmbtmode.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                cmbtmodeCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cmbtmodeInputMethodTextChanged(evt);
            }
        });
        cmbtmode.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbtmodePropertyChange(evt);
            }
        });
        cmbtmode.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                cmbtmodeVetoableChange(evt);
            }
        });

        jLabel5.setText("Transaction Type");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbttype, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbtmode, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addComponent(cmbtmode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel14.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 168, -1));

        lbltmodeOther.setText("Transaction Mode");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOtherTmode, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltmodeOther))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltmodeOther)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOtherTmode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 131, -1, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(540, 540, 540))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lblTitle2)
                .addGap(0, 0, 0)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addGap(224, 224, 224))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        General.addTab(" Genaral", jPanel2);

        jPanel6.setToolTipText("");

        btnAddIns.setText("Add Installment");
        btnAddIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddInsActionPerformed(evt);
            }
        });

        jLabel9.setText("Loan ID:");

        lblLoanId.setText(" ");

        jLabel13.setText("Date Payed :");

        jLabel14.setText("Amount Payed :");

        txtamtLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamtLoanActionPerformed(evt);
            }
        });
        txtamtLoan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtamtLoanFocusLost(evt);
            }
        });
        txtamtLoan.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtamtLoanCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        dchLoan.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dchLoanPropertyChange(evt);
            }
        });

        lblEamountLoan.setForeground(new java.awt.Color(255, 0, 0));
        lblEamountLoan.setText(" ");

        lblEdateLoan.setForeground(new java.awt.Color(255, 0, 0));
        lblEdateLoan.setText(" ");

        lblELid.setForeground(new java.awt.Color(255, 0, 0));
        lblELid.setText(" ");

        btnCompleteLoan.setText("View Pay History");
        btnCompleteLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteLoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblLoanId, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtamtLoan, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(lblEamountLoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lblELid, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblEdateLoan, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addContainerGap())
                            .addComponent(dchLoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnAddIns, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnCompleteLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dchLoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddIns, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCompleteLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblLoanId))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(txtamtLoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEamountLoan)
                    .addComponent(lblEdateLoan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblELid)
                .addContainerGap())
        );

        btnAddLoan.setText("Add Loan");
        btnAddLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLoanActionPerformed(evt);
            }
        });

        btnUpdateLoan.setText("Update Loan ");
        btnUpdateLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateLoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnAddLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdateLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        tblLoan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblLoanMouseEntered(evt);
            }
        });
        jscpLoan.setViewportView(tblLoan);

        lblTitle1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitle1.setText("Loan Information");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jscpLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jscpLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        General.addTab("  Loan ", jPanel5);

        tblTax.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaxMouseClicked(evt);
            }
        });
        tblTax.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tblTaxMouseMoved(evt);
            }
        });
        tblTax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblTaxFocusLost(evt);
            }
        });
        jScrollPane3.setViewportView(tblTax);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel9.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 339, 61, -1));

        lblTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitle.setText("Tax Information");
        jPanel9.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2, 118, -1));

        lblAmount.setText("Amount :");
        jPanel9.add(lblAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 168, -1, -1));

        lblTaxType.setText("Tax Type :");
        jPanel9.add(lblTaxType, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 124, -1, -1));

        lblDatepaid.setText("Date Paid :");
        jPanel9.add(lblDatepaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 73, -1, -1));

        lblErrAmt.setForeground(new java.awt.Color(255, 0, 0));
        jPanel9.add(lblErrAmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 189, 152, 15));
        jPanel9.add(dchTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 73, 153, -1));

        lblErrQuat.setForeground(new java.awt.Color(255, 0, 0));
        jPanel9.add(lblErrQuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 230, 152, 15));

        lblOther.setText("Other :");
        jPanel9.add(lblOther, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 251, -1, -1));

        lblInvoiceNo.setText("Invoice No :");
        jPanel9.add(lblInvoiceNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, -1, -1));

        txtAOtherTax.setColumns(20);
        txtAOtherTax.setRows(3);
        jScrollPane1.setViewportView(txtAOtherTax);

        jPanel9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 251, 294, 70));

        lblErrTaxType.setForeground(new java.awt.Color(255, 0, 0));
        jPanel9.add(lblErrTaxType, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 143, 152, 15));

        lblQuartile.setText("Quartile :");
        jPanel9.add(lblQuartile, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 211, -1, -1));

        TxtAmtTax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtAmtTaxFocusGained(evt);
            }
        });
        jPanel9.add(TxtAmtTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 165, 153, -1));

        lblErrInvoNo.setForeground(new java.awt.Color(255, 0, 0));
        jPanel9.add(lblErrInvoNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 52, 153, 15));

        txtInvoNoTax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInvoNoTaxActionPerformed(evt);
            }
        });
        txtInvoNoTax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtInvoNoTaxFocusGained(evt);
            }
        });
        txtInvoNoTax.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtInvoNoTaxAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel9.add(txtInvoNoTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 29, 153, -1));

        cmbQuatTax.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Quartile One", "Quartile Two", "Quartile Three", "Quartile Four" }));
        jPanel9.add(cmbQuatTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 208, 152, -1));

        cmbTypeTax.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Income Tax", "Garbage Tax", "Environment Tax", "Other" }));
        jPanel9.add(cmbTypeTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 121, 152, -1));

        lblErrDatePaid.setForeground(new java.awt.Color(255, 0, 0));
        jPanel9.add(lblErrDatePaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 99, 152, 15));

        btnAdd1.setText("Clear");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        jPanel9.add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 339, -1, -1));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblErrDpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove)))
                .addGap(425, 425, 425))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(lblErrDpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnUpdate)
                                    .addComponent(btnRemove))))
                        .addGap(0, 151, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        General.addTab("Tax", jPanel1);

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel16.add(dchRptFdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 221, 168, -1));
        jPanel16.add(dchRptLdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 259, 166, -1));

        jLabel10.setText("From :");
        jPanel16.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 221, -1, -1));

        jLabel11.setText("To :");
        jPanel16.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 259, -1, -1));

        jButton4.setText("Genarate Report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 130, 30));

        jLabel12.setText("All transaction Repot");
        jPanel16.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 189, -1, -1));

        jButton1.setText("Today Transactios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 37, 130, 30));

        jButton5.setText("Debit Report");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 136, 130, 30));

        jButton6.setText("Credit Report");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 95, 130, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Genaral Transaction Summary");
        jPanel16.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Loan ID :");
        jPanel15.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 36, 54, -1));

        jButton3.setText("Get Loan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 32, -1, -1));

        jButton2.setText("Genarate Installment Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 32, 180, 30));

        lblLID.setText("######");
        jPanel15.add(lblLID, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 36, -1, -1));

        jButton7.setText("Genarate Loan Info Report");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 84, 180, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Loan Summary");
        jPanel15.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Summary");

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton9.setText("Genarate Specific Report");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 180, 30));

        jButton10.setText("Genarate Tax Info Report");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 180, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Tax Summany");
        jPanel17.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        cmbQuatTax1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Quartile One", "Quartile Two", "Quartile Three", "Quartile Four" }));
        jPanel17.add(cmbQuatTax1, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 30, 149, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel18)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        General.addTab("Summary", jPanel3);

        getContentPane().add(General, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 950, 450));

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

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mainmenubackgroundWindows.jpg"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btnrmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrmActionPerformed
        if (lblstfid.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Plese select a record to delete");
        } else {

            int row1 = tbl1.getSelectedRow();
            ProfitData data2 = new ProfitData();
            data2.settransId(Integer.parseInt(tbl1.getValueAt(row1, 0).toString()));
            ProfitDAO dao1 = new ProfitDAO();
            dao1.removeTransactio(data2);
            loadTable();
            clearAll();
            JOptionPane.showMessageDialog(null, "Transaction Record Removed Successfully");

        }
    }//GEN-LAST:event_btnrmActionPerformed

    private void txtamtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtamtActionPerformed

    private void btnslctaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnslctaddActionPerformed

        chkUpRm = false;
        clearAll();
        btnslctadd.setEnabled(false);
        btnadd.setEnabled(true);
        btnclr.setEnabled(true);
        txtamt.setEnabled(true);
        txtarea.setEnabled(true);
        dchsdate.setEnabled(true);
        cmbtmode.setEnabled(true);
        cmbttype.setEnabled(true);
        btnslctrm.setEnabled(true);
        btnslctupd.setEnabled(true);
        btnupd.setEnabled(false);
        btnrm.setEnabled(false);


    }//GEN-LAST:event_btnslctaddActionPerformed

    private void btnslctupdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnslctupdActionPerformed
        chkUpRm = true;

        btnslctupd.setEnabled(false);
        btnadd.setEnabled(false);
        btnclr.setEnabled(false);
        btnupd.setEnabled(true);
        btnslctadd.setEnabled(true);
        btnslctrm.setEnabled(true);
        btnrm.setEnabled(false);
        txtarea.setEnabled(true);
        txtamt.setEnabled(true);
        dchsdate.setEnabled(true);
        jScrollPane2.setEnabled(true);
        tbl1.setEnabled(true);
        cmbtmode.setEnabled(true);
        cmbttype.setEnabled(true);


    }//GEN-LAST:event_btnslctupdActionPerformed

    private void btnslctrmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnslctrmActionPerformed
        chkUpRm = true;

        btnslctupd.setEnabled(true);
        btnslctadd.setEnabled(true);
        btnadd.setEnabled(false);
        btnclr.setEnabled(false);
        txtamt.setEnabled(false);
        txtarea.setEnabled(false);
        btnslctrm.setEnabled(false);
        btnrm.setEnabled(true);
        btnupd.setEnabled(false);
        cmbtmode.setEnabled(false);
        cmbttype.setEnabled(false);
        dchsdate.setEnabled(false);
        clearAll();

    }//GEN-LAST:event_btnslctrmActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        try {

            if (txtamt.getText().isEmpty()) {
                lblerroramt.setText("*Amount can not be null");
                chkValidate = false;
            }

            if (!val1.isNumeric(txtamt.getText())) {
                lblerroramt.setText("*Invalid Amount");
                chkValidate = false;
            }
            String s1 = dchsdate.getDate().toString();

        } catch (NullPointerException ex) {
            lblerrdate.setText("* Please select");
            chkValidate = false;
        }
        if (cmbtmode.getSelectedItem().toString().equals("Other") && txtOtherTmode.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter a transaction mode !");
            chkValidate = false;
        }

        if (chkValidate) {

            ProfitData dataD1 = new ProfitData();
            ProfitDAO dao1 = new ProfitDAO();

            dataD1.setAmount(Double.parseDouble(txtamt.getText()));
            String s12 = newc.formatedDate(dchsdate.getDate().toString());
            dataD1.setSystemDate(s12);

            dataD1.setDiscription(txtarea.getText());
            dataD1.setTransType(cmbttype.getSelectedItem().toString());
            if (cmbtmode.getSelectedItem().toString().equals("Other")) {
                dataD1.setTransMode(txtOtherTmode.getText());

            } else {
                dataD1.setTransMode(cmbtmode.getSelectedItem().toString());
            }

            boolean b1 = dao1.addTrans(dataD1);
            if (b1) {
                loadTable();
                clearAll();
                JOptionPane.showMessageDialog(null, "Added Successfully");

            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        }


    }//GEN-LAST:event_btnaddActionPerformed
    Cal newc = new Cal();
    private void GeneralFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GeneralFocusGained

        lblsystmdate.setText(newc.getDate());
    }//GEN-LAST:event_GeneralFocusGained

    private void txtamtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtamtFocusGained
        lblerroramt.setText("");
    }//GEN-LAST:event_txtamtFocusGained

    private void dchsdateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dchsdateFocusGained

    }//GEN-LAST:event_dchsdateFocusGained

    private void dchsdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dchsdateKeyPressed

    }//GEN-LAST:event_dchsdateKeyPressed

    private void dchsdatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dchsdatePropertyChange
        lblerrdate.setText("");
        chkValidate1 = true;
        chkValidate = true;
    }//GEN-LAST:event_dchsdatePropertyChange

    private void btnclrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclrActionPerformed

        clearAll();
    }//GEN-LAST:event_btnclrActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        loadTable();
        // txtTmode.setForeground(Color.GRAY);
        cmbtmode.addItem("Other");
    }//GEN-LAST:event_formWindowOpened

    private void txtareaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtareaFocusGained

    }//GEN-LAST:event_txtareaFocusGained

    private void cmbtmodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtmodeActionPerformed
        lblerrdate.setText("");
        chkValidate1 = true;
        chkValidate = true;
    }//GEN-LAST:event_cmbtmodeActionPerformed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        // tbl1.getSelectedRow()
        if (chkUpRm) {
            selectRow();
        }
    }//GEN-LAST:event_tbl1MouseClicked

    private void btnAddLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLoanActionPerformed

        AddLoan Adl = new AddLoan(-1);
        Adl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddLoanActionPerformed

    private void btnAddInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInsActionPerformed
        if (tblLoan.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Please Select A Row !");
        } else {
            Validation val1 = new Validation();
            String date1 = "";
            boolean b1 = true;
            Cal cl = new Cal();
            if (!(val1.isNumeric(txtamtLoan.getText()) || txtamtLoan.getText().equals(""))) {
                lblEamountLoan.setText("* Invalid");
                b1 = false;
            }
            if (lblLoanId.getText().equals("")) {
                lblELid.setText("Please Select A Loan");
                b1 = false;
            }
            try {
                date1 = cl.formatedDate(dchLoan.getDate().toString());
            } catch (NullPointerException ex) {
                b1 = false;
                lblEdateLoan.setText("* Invalid");
            }
            if (b1) {

                int row = tblLoan.getSelectedRow();
                String inst = "";

                inst = tblLoan.getValueAt(row, 9).toString();
                int installments = Integer.parseInt(inst);
                installments = 1 + installments;

                LoanDetails ldata = new LoanDetails();
                ldata.setID(Integer.parseInt(lblLoanId.getText()));
                ldata.setLastPayDate(date1);
                ldata.setAmount(Double.parseDouble(txtamtLoan.getText()));
                ldata.setNoinstallments(installments);

                LoanDAO dao2 = new LoanDAO();
                boolean b11 = false;
                b11 = dao2.addInstallment(ldata);

                if (b11) {
                    txtamtLoan.setText("");
                    dchLoan.setDate(null);
                    lblLoanId.setText("");
                    lblELid.setText("");
                    lblEamountLoan.setText("");
                    lblerrdate.setText("");
                    loadTableLoan();
                    JOptionPane.showMessageDialog(rootPane, "Succesfully added an Installement");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Faild");
                }
            }
        }

    }//GEN-LAST:event_btnAddInsActionPerformed


    private void btnUpdateLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateLoanActionPerformed
        if (tblLoan.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Please Select a row !");
        } else {
            int lID = Integer.parseInt(lblLoanId.getText().toString());
            AddLoan ad = new AddLoan(lID);
            ad.loanIDToUpdate = lID;
            ad.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnUpdateLoanActionPerformed

    private void btnCompleteLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteLoanActionPerformed
        Loan_history hts = new Loan_history();
        hts.loadTable(Integer.parseInt(lblLoanId.getText()));
        hts.setVisible(true);
    }//GEN-LAST:event_btnCompleteLoanActionPerformed

    private void btnupdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdActionPerformed
        Cal cl = new Cal();
        if (txtamt.getText().isEmpty()) {
            lblerroramt.setText("*Amount can not be null");
            chkValidate1 = false;
        }

        if (!val1.isNumeric(txtamt.getText())) {
            lblerroramt.setText("*Invalid Amount");
            chkValidate1 = false;
        }
        String s1 = "";
        try {

            s1 = dchsdate.getDate().toString();
//        if(!val1.dateVal(s1))
//           lblerrdate.setText("*Invalid Date");
        } catch (NullPointerException ex) {
            lblerrdate.setText("* Please select");
            chkValidate1 = false;
        }

        if (chkValidate1) {
            ProfitData dataD1 = new ProfitData();
            dataD1.setAmount(Double.parseDouble(txtamt.getText()));
            dataD1.setSystemDate(s1);
            dataD1.setDiscription(txtarea.getText());
            dataD1.setTransType(cmbttype.getSelectedItem().toString());
            dataD1.setTransMode(cmbtmode.getSelectedItem().toString());
            dataD1.settransId(Integer.parseInt(lblstfid.getText()));
            dataD1.setAddedDate(cl.formatedDate(dchsdate.getDate().toString()));
            ProfitDAO dao1 = new ProfitDAO();
            boolean b1 = dao1.updateTrans(dataD1);
            if (b1) {
                loadTable();
                clearAll();
                JOptionPane.showMessageDialog(null, "Update Successfull");

            } else {
                JOptionPane.showMessageDialog(null, "Update Failed");
            }

        }
    }//GEN-LAST:event_btnupdActionPerformed

    private void dchSearchdPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dchSearchdPropertyChange
        String tType = cmbttype1.getSelectedItem().toString();
        String t = cmbtmode1.getSelectedItem().toString();
        try {
            Cal newc1 = new Cal();
            String datenew = newc1.formatedDate(dchSearchd.getDate().toString());

            loadTableFiltered(datenew, tType, t);
        } catch (Exception ex) {
            loadTableFiltered("", tType, t);
        }
    }//GEN-LAST:event_dchSearchdPropertyChange

    private void cmbtmode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtmode1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtmode1ActionPerformed

    private void txtamtLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamtLoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtamtLoanActionPerformed

    private void txtamtLoanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtamtLoanFocusLost

    }//GEN-LAST:event_txtamtLoanFocusLost

    private void txtamtLoanCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtamtLoanCaretPositionChanged
        JOptionPane.showMessageDialog(null, "Lost Focus");
    }//GEN-LAST:event_txtamtLoanCaretPositionChanged

    private void cmbtmodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbtmodeMouseClicked

    }//GEN-LAST:event_cmbtmodeMouseClicked

    private void cmbtmodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbtmodeItemStateChanged
        try {
            if (cmbtmode.getSelectedItem().toString().equals("Other")) {
                txtOtherTmode.setVisible(true);
                lbltmodeOther.setVisible(true);
            } else {
                txtOtherTmode.setVisible(false);
                lbltmodeOther.setVisible(false);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbtmodeItemStateChanged

    private void cmbtmodePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbtmodePropertyChange

    }//GEN-LAST:event_cmbtmodePropertyChange

    private void cmbtmodeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbtmodeMousePressed

    }//GEN-LAST:event_cmbtmodeMousePressed

    private void cmbtmodeCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cmbtmodeCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtmodeCaretPositionChanged

    private void cmbtmodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbtmodeFocusGained

    }//GEN-LAST:event_cmbtmodeFocusGained

    private void cmbtmodeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cmbtmodeInputMethodTextChanged

    }//GEN-LAST:event_cmbtmodeInputMethodTextChanged

    private void cmbtmodeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbtmodeMouseReleased

    }//GEN-LAST:event_cmbtmodeMouseReleased

    private void cmbtmodeVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_cmbtmodeVetoableChange

    }//GEN-LAST:event_cmbtmodeVetoableChange

    private void cmbtmodePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbtmodePopupMenuWillBecomeInvisible


    }//GEN-LAST:event_cmbtmodePopupMenuWillBecomeInvisible

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

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

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        loadTableLoan();
    }//GEN-LAST:event_formFocusGained
    public int rowno = -1;
    private void tblLoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoanMouseClicked
        int row = tblLoan.getSelectedRow();
        rowno = row;
        lblLoanId.setText(tblLoan.getValueAt(row, 0).toString());

    }//GEN-LAST:event_tblLoanMouseClicked

    private void txtamtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtamtCaretUpdate
        lblerroramt.setText("");
    }//GEN-LAST:event_txtamtCaretUpdate

    private void tblLoanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoanMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblLoanMouseEntered

    private void dchLoanPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dchLoanPropertyChange
        lblEdateLoan.setText(" ");
    }//GEN-LAST:event_dchLoanPropertyChange

    private void txtInvoNoTaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInvoNoTaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInvoNoTaxActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        TaxDAO dao1 = new TaxDAO();
        Cal cl = new Cal();

        if (taxValidation()) {
            TaxData data1 = new TaxData(Integer.parseInt(txtInvoNoTax.getText()),
                    cl.formatedDate(dchTax.getDate().toString()), cmbTypeTax.getSelectedItem().toString(),
                    Float.parseFloat(TxtAmtTax.getText()), cmbQuatTax.getSelectedItem().toString(), txtAOtherTax.getText());
            if (dao1.addTax(data1)) {
                loadTableTax();
                JOptionPane.showMessageDialog(null, "Succesfully added");
                clearTax();
            } else {
                JOptionPane.showMessageDialog(null, "Failed tp add");
            }

        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblTaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaxMouseClicked
        int row = tblTax.getSelectedRow();
        txtInvoNoTax.setText(tblTax.getValueAt(row, 1).toString());
        java.util.Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(tblTax.getValueAt(row, 2).toString());
            dchTax.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(Profit.class.getName()).log(Level.SEVERE, null, ex);
        }

        cmbTypeTax.setSelectedItem(tblTax.getValueAt(row, 3).toString());
        TxtAmtTax.setText(tblTax.getValueAt(row, 4).toString());
        cmbQuatTax.setSelectedItem(tblTax.getValueAt(row, 5).toString());
        txtAOtherTax.setText(tblTax.getValueAt(row, 6).toString());

    }//GEN-LAST:event_tblTaxMouseClicked

    private void tblTaxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblTaxFocusLost

    }//GEN-LAST:event_tblTaxFocusLost

    private void tblTaxMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaxMouseMoved

    }//GEN-LAST:event_tblTaxMouseMoved

    private void txtInvoNoTaxAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtInvoNoTaxAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInvoNoTaxAncestorAdded

    private void txtInvoNoTaxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtInvoNoTaxFocusGained
        lblErrInvoNo.setText("");
    }//GEN-LAST:event_txtInvoNoTaxFocusGained

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        boolean val = true;
        TaxDAO dao1 = new TaxDAO();
        Cal cl = new Cal();
        //validation checks

        //end of validation checks
        if (tblTax.getSelectedRowCount() == 1) {
            if (taxValidation()) {
                TaxData data3 = new TaxData(Integer.parseInt(txtInvoNoTax.getText()),
                        cl.formatedDate(dchTax.getDate().toString()), cmbTypeTax.getSelectedItem().toString(),
                        Float.parseFloat(TxtAmtTax.getText()), cmbQuatTax.getSelectedItem().toString(), txtAOtherTax.getText());
                data3.setTaxId(Integer.parseInt(tblTax.getValueAt(tblTax.getSelectedRow(), 0).toString()));

                if (dao1.updateTax(data3)) {
                    loadTableTax();
                    JOptionPane.showMessageDialog(null, "Succesfully updated");
                    clearTax();
                } else {
                    JOptionPane.showMessageDialog(null, "Update Faild");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Select a row from the table !");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        TaxDAO dao1 = new TaxDAO();
        TaxData data4 = new TaxData();

        int row = tblTax.getSelectedRow();
        if (tblTax.getSelectedRowCount() == 1) {
            data4.setTaxId(Integer.parseInt(tblTax.getValueAt(row, 0).toString()));

            if (dao1.removeTax(data4)) {
                loadTableTax();
                JOptionPane.showMessageDialog(null, "Successfully removed");
                clearTax();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to remove");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from the table to delete !");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        HashMap hm = new HashMap();
        Cal cl = new Cal();

        try {
            String date1 = cl.formatedDate(dchRptFdate.getDate().toString());
            String date2 = cl.formatedDate(dchRptLdate.getDate().toString());
            if (cl.isValidRanage(date1, date2)) {
                hm.put("PARA_F_DATE", date1);
                hm.put("PARA_L_DATE", date2);
                ReportView r = new ReportView("C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaApplication9\\src\\iReport\\tReporDrangeAll.jasper", hm);
                r.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Please Select a valid Range");
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Please Select date range");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cmbtmodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbtmodeFocusLost
        fillTransactionModes();
    }//GEN-LAST:event_cmbtmodeFocusLost

    private void cmbttype1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbttype1MouseClicked
        try {
            Cal newc1 = new Cal();
            String datenew = newc1.formatedDate(dchSearchd.getDate().toString());
            String tType = cmbttype1.getSelectedItem().toString();
            String t = cmbtmode1.getSelectedItem().toString();
            loadTableFiltered(datenew, tType, t);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_cmbttype1MouseClicked

    private void cmbttype1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbttype1ItemStateChanged
        String tType = cmbttype1.getSelectedItem().toString();
        String t = cmbtmode1.getSelectedItem().toString();
        try {
            Cal newc1 = new Cal();
            String datenew = newc1.formatedDate(dchSearchd.getDate().toString());

            loadTableFiltered(datenew, tType, t);
        } catch (Exception ex) {
            loadTableFiltered("", tType, t);
        }
        fillTransactionModesAtType(cmbttype1.getSelectedItem().toString());
    }//GEN-LAST:event_cmbttype1ItemStateChanged

    private void cmbtmode1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbtmode1ItemStateChanged
        String tType = cmbttype1.getSelectedItem().toString();
        String t = "";
        try {
            t = cmbtmode1.getSelectedItem().toString();
            Cal newc1 = new Cal();
            String datenew = newc1.formatedDate(dchSearchd.getDate().toString());

            loadTableFiltered(datenew, tType, t);
        } catch (Exception ex) {
            loadTableFiltered("", tType, t);
        }
    }//GEN-LAST:event_cmbtmode1ItemStateChanged

    private void dchSearchdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dchSearchdKeyReleased
        String tType = cmbttype1.getSelectedItem().toString();
        String t = cmbtmode1.getSelectedItem().toString();
        try {
            Cal newc1 = new Cal();
            String datenew = newc1.formatedDate(dchSearchd.getDate().toString());

            loadTableFiltered(datenew, tType, t);
        } catch (Exception ex) {
            loadTableFiltered("", tType, t);
        }
    }//GEN-LAST:event_dchSearchdKeyReleased

    private void dchSearchdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dchSearchdFocusLost
        String tType = cmbttype1.getSelectedItem().toString();
        String t = cmbtmode1.getSelectedItem().toString();
        try {
            Cal newc1 = new Cal();
            String datenew = newc1.formatedDate(dchSearchd.getDate().toString());

            loadTableFiltered(datenew, tType, t);
        } catch (Exception ex) {
            loadTableFiltered("", tType, t);
        }
    }//GEN-LAST:event_dchSearchdFocusLost
    public static String loanIID;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Loan_history hts = new Loan_history(this);
        hts.loadTableForSelectLoan();
        hts.setVisible(true);
        lblLID.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        HashMap hm = new HashMap();
        Cal cl = new Cal();
        try {
            hm.put("PARA_DATE", cl.getDate());

            ReportView r = new ReportView("C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaApplication9\\src\\iReport\\tReporDrange.jasper", hm);
            r.setVisible(true);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Please Select date range!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HashMap hm1 = new HashMap();

        if (!lblLID.getText().equals("######")) {

            hm1.put("PARA_LOANID", lblLID.getText());

            ReportView r = new ReportView("C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaApplication9\\src\\iReport\\LoanIntallments.jasper", hm1);
            r.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please Select a loan");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Cal cl = new Cal();
        HashMap hm = new HashMap();
        String dateM;
        if (cl.getMonth() < 10) {
            dateM = cl.getYear() + "-0" + cl.getMonth() + "%";
        } else {
            dateM = cl.getYear() + "-" + cl.getMonth() + "%";
        }
        System.out.println(dateM);
        hm.put("PARA_MONDATE", dateM);

        ReportView r = new ReportView("C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaApplication9\\src\\iReport\\debitReport.jasper", hm);
        r.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Cal cl = new Cal();
        HashMap hm = new HashMap();
        String dateM;
        if (cl.getMonth() < 10) {
            dateM = cl.getYear() + "-0" + cl.getMonth() + "%";
        } else {
            dateM = cl.getYear() + "-" + cl.getMonth() + "%";
        }
        System.out.println(dateM);
        hm.put("PARA_MONDATE", dateM);
        ReportView r = new ReportView("C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaApplication9\\src\\iReport\\creditReport.jasper", hm);
        r.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ReportView r = new ReportView("C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaApplication9\\src\\iReport\\loandata.jasper");
        r.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        HashMap hm = new HashMap();

        hm.put("PARA_QUATILE", cmbQuatTax1.getSelectedItem().toString());
        ReportView r = new ReportView("C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaApplication9\\src\\iReport\\taxReportSpecific.jasper", hm);
        r.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        ReportView r = new ReportView("C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaApplication9\\src\\iReport\\taxReport.jasper");
        r.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void TxtAmtTaxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtAmtTaxFocusGained
        lblErrAmt.setText("");
    }//GEN-LAST:event_TxtAmtTaxFocusGained

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        clearTax();
    }//GEN-LAST:event_btnAdd1ActionPerformed

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
            java.util.logging.Logger.getLogger(Profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profit().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTabbedPane General;
    private javax.swing.JTextField TxtAmtTax;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnAddIns;
    private javax.swing.JButton btnAddLoan;
    private javax.swing.JButton btnCompleteLoan;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateLoan;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnclr;
    private javax.swing.JButton btnrm;
    private javax.swing.JButton btnslctadd;
    private javax.swing.JButton btnslctrm;
    private javax.swing.JButton btnslctupd;
    private javax.swing.JButton btnupd;
    private javax.swing.JComboBox cmbQuatTax;
    private javax.swing.JComboBox cmbQuatTax1;
    private javax.swing.JComboBox cmbTypeTax;
    private javax.swing.JComboBox cmbtmode;
    private javax.swing.JComboBox cmbtmode1;
    private javax.swing.JComboBox cmbttype;
    private javax.swing.JComboBox cmbttype1;
    private com.toedter.calendar.JDateChooser dchLoan;
    private com.toedter.calendar.JDateChooser dchRptFdate;
    private com.toedter.calendar.JDateChooser dchRptLdate;
    private com.toedter.calendar.JDateChooser dchSearchd;
    private com.toedter.calendar.JDateChooser dchTax;
    private com.toedter.calendar.JDateChooser dchsdate;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JScrollPane jscpLoan;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblDatepaid;
    private javax.swing.JLabel lblELid;
    private javax.swing.JLabel lblEamountLoan;
    private javax.swing.JLabel lblEdateLoan;
    private javax.swing.JLabel lblErrAmt;
    private javax.swing.JLabel lblErrDatePaid;
    private javax.swing.JLabel lblErrDpaid;
    private javax.swing.JLabel lblErrInvoNo;
    private javax.swing.JLabel lblErrQuat;
    private javax.swing.JLabel lblErrTaxType;
    private javax.swing.JLabel lblInvoiceNo;
    public final javax.swing.JLabel lblLID = new javax.swing.JLabel();
    private javax.swing.JLabel lblLoanId;
    private javax.swing.JLabel lblOther;
    private javax.swing.JLabel lblQuartile;
    private javax.swing.JLabel lblTaxType;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblerrdate;
    private javax.swing.JLabel lblerroramt;
    private javax.swing.JLabel lblstfid;
    private javax.swing.JLabel lblsystmdate;
    private javax.swing.JLabel lbltmodeOther;
    private javax.swing.JButton logout;
    private javax.swing.JPanel pnlBtn;
    private javax.swing.JTable tbl1;
    private javax.swing.JTable tblLoan;
    private javax.swing.JTable tblTax;
    private javax.swing.JTextArea txtAOtherTax;
    private javax.swing.JTextField txtInvoNoTax;
    private javax.swing.JTextField txtOtherTmode;
    private javax.swing.JScrollPane txta1;
    private javax.swing.JTextField txtamt;
    private javax.swing.JFormattedTextField txtamtLoan;
    private javax.swing.JTextArea txtarea;
    // End of variables declaration//GEN-END:variables

}
