/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appPackage;

import data.Cal;
import data.Emp;
import DAO.EmpDAO;
import data.ReportView;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Dell
 */
public class manageEmp extends javax.swing.JFrame {

    private Vector<Vector<String>> data; //Used for data from database
    private Vector<String> header; //Used to store data header
    Cal c = new Cal();
    boolean drag = false;
    String dragst ="";
    /**
     * Creates new form manageEmp
     */
    public manageEmp() {
        initComponents();
        header = new Vector<String>();
        header.add("Emp ID");
        header.add("First Name");
        header.add("Last Name");
        loadTable("", jScrollPane1, tblUpdateEmp);
        loadTable("", jScrollPane2, tblDelete);
       jTabbedPane1.setBackground(new Color(0, 0, 0, 0));
//       jPanel5.setBackground(new Color(0, 0, 0, 0));
//       jPanel2.setBackground(new Color(0, 0, 0, 0));
//       jPanel3.setBackground(new Color(0, 0, 0, 0));
       
       Cal c = new Cal();
            c.setDateTime(lbldate, lbltime);
       
    }
    
        private void loadTable() {

        EmpDAO dao = new EmpDAO();
        data = dao.getEmpDetails();

        tblUpdateEmp.setModel(new javax.swing.table.DefaultTableModel(
                data, header));
        jScrollPane1.setViewportView(tblUpdateEmp);
    }
        private void loadTable(String st) {

        EmpDAO dao = new EmpDAO();
        data = dao.getEmpDetails(st);

        tblUpdateEmp.setModel(new javax.swing.table.DefaultTableModel(
                data, header));
        jScrollPane1.setViewportView(tblUpdateEmp);
    }
        
        private void loadTable(String st, JScrollPane js, JTable jt) {

        EmpDAO dao = new EmpDAO();
        data = dao.getEmpDetails(st);

        jt.setModel(new javax.swing.table.DefaultTableModel(
                data, header));
        js.setViewportView(jt);
    }
        
        

        private boolean isNumber(String st)
        {
            boolean a = true;
            for (int r = 0; r < st.length(); r++) {
                {
                    if(!Character.isDigit(st.charAt(r)))
                    {
                        a = false;
                    }
                }
            }
            return a;
        }
            
        private boolean  isPhoneNo(String st)
        {
            boolean a = true;
            if(!isNumber(st))
            {
                a = false;
            }
            if(st.length()!=10)
            {
                a = false;
            }
            char ch = st.charAt(0);
            if(ch != '0')
            {
                a=false;
            }
            return a;
        }
        
        boolean isWord(String st)
        {
            boolean a = true;
            for (int r = 0; r < st.length(); r++) {
                {
                    if(!Character.isLetter(st.charAt(r)))
                    {
                        a = false;
                    }
                }
            }
            return a;
        }
        
        public boolean isValidEmailAddress(String email) {
    boolean stricterFilter = true; 
    String stricterFilterString = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
    String laxString = ".+@.+\\.[A-Za-z]{2}[A-Za-z]*";
    String emailRegex = stricterFilter ? stricterFilterString : laxString;
    java.util.regex.Pattern p = java.util.regex.Pattern.compile(emailRegex);
    java.util.regex.Matcher m = p.matcher(email);
    return m.matches();
}
        
        boolean isValidNIC(String st)
        {
            boolean b = true;
            System.out.println(b);
            if(st.length()!=10)
            {
                b = false;
                System.out.println("aaaaaaa");
            }
            
            else if(!isNumber(st.substring(0, 8)))
            {
                b = false;
                System.out.println("bbbbbbb");
            }
            else if(!(st.substring(9).equalsIgnoreCase("v") ||st.substring(9).equalsIgnoreCase("x")) )
            {
                System.out.println(st.substring(9));
                b = false;
                System.out.println("ccccccc");
            }
            System.out.println(b);
            return b;
        }
        
        void clearUpdate()
        {
            txtUAddress.setText("");
//            txtUDOB.setText("");
            txtUEmail.setText("");
            txtUFname.setText("");
            txtULname.setText("");
            txtUMobile.setText("");
            txtUNic.setText("");
            txtUTelephone.setText("");

            
        }
        void clearDelete()
        {
            lblDAddress.setText("");
            lblDCivilStatus.setText("");
            lblDDOB.setText("");
            lblDEmail.setText("");
            lblDGender.setText("");
            lblDLname.setText("");
            lblDMobile.setText("");
            lblDNIC.setText("");
            lblDTelephone.setText("");
            lblDfname.setText("");
        }
        void clearEUpdate()
        {
            lblEUAddress.setText("  ");
            lblEUEmail.setText("  ");
            lblEUFname.setText("  ");
            lblEULname.setText("  ");
            lblEUMobile.setText("  ");
            lblEUNic.setText("  ");
            lblEUTelephone.setText("  ");
            lblEUdob.setText("  ");
            
        }
        
        void clearAdd()
        {
            txtAccNo.setText("");
            txtAddress.setText("");
            txtBasicSalary.setText("");
//            txtDOB.setText("yyyy-mm-dd");
            txtEPFNo.setText("");
            txtEmail.setText("");
            txtFname.setText("");
            txtLname.setText("");
            txtMobile.setText("");
            txtNIC.setText("");
            txtTelephone.setText("");
            
        }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbldate = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        cmbCatagory = new javax.swing.JComboBox();
        cmbSection = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblFname = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        txtLname = new javax.swing.JTextField();
        lblDateOfBirth = new javax.swing.JLabel();
        lblCivilStatus = new javax.swing.JLabel();
        lblNic = new javax.swing.JLabel();
        txtNIC = new javax.swing.JTextField();
        lblEFname = new javax.swing.JLabel();
        lblEGender = new javax.swing.JLabel();
        lblELname = new javax.swing.JLabel();
        lblEDOB = new javax.swing.JLabel();
        lblECivilStatus = new javax.swing.JLabel();
        lblENic = new javax.swing.JLabel();
        lblAccNo = new javax.swing.JLabel();
        txtAccNo = new javax.swing.JTextField();
        lblEpf = new javax.swing.JLabel();
        txtEPFNo = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblTelephone = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JTextField();
        lblMobile = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        lblSection = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        lblEAddress = new javax.swing.JLabel();
        lblETelephone = new javax.swing.JLabel();
        lblEEmail = new javax.swing.JLabel();
        lblEMobile = new javax.swing.JLabel();
        lblECatagory = new javax.swing.JLabel();
        lblESection = new javax.swing.JLabel();
        cmbCivilStatus = new javax.swing.JComboBox();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        txtBasicSalary = new javax.swing.JTextField();
        lblEAccno = new javax.swing.JLabel();
        lblEEpfno = new javax.swing.JLabel();
        lblEBasicSal = new javax.swing.JLabel();
        txtDOB = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUpdateEmp = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtUFname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtULname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUNic = new javax.swing.JTextField();
        cmbUGender = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txtUTelephone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtUMobile = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtUEmail = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        cmbUCivilStatus = new javax.swing.JComboBox();
        lblEUFname = new javax.swing.JLabel();
        lblEULname = new javax.swing.JLabel();
        lblEUAddress = new javax.swing.JLabel();
        lblEUdob = new javax.swing.JLabel();
        lblEUNic = new javax.swing.JLabel();
        lblEUTelephone = new javax.swing.JLabel();
        lblEUMobile = new javax.swing.JLabel();
        lblEUEmail = new javax.swing.JLabel();
        txtUDOB = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDelete = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblDfname = new javax.swing.JLabel();
        lblDLname = new javax.swing.JLabel();
        lblDAddress = new javax.swing.JLabel();
        lblDGender = new javax.swing.JLabel();
        lblDDOB = new javax.swing.JLabel();
        lblDCivilStatus = new javax.swing.JLabel();
        lblDNIC = new javax.swing.JLabel();
        lblDTelephone = new javax.swing.JLabel();
        lblDMobile = new javax.swing.JLabel();
        lblDEmail = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        txtDSearch = new javax.swing.JTextField();
        lblmouse = new javax.swing.JLabel();
        lblframe = new javax.swing.JLabel();
        lblxy = new javax.swing.JLabel();
        lblDrag = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        pnlBtn = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbldate.setFont(new java.awt.Font("LcdD", 0, 24)); // NOI18N
        lbldate.setText("date");
        getContentPane().add(lbldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 600, 110, -1));

        lbltime.setFont(new java.awt.Font("LcdD", 0, 24)); // NOI18N
        lbltime.setText("time");
        getContentPane().add(lbltime, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 600, 160, -1));

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });
        jTabbedPane1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseMoved(evt);
            }
        });

        cmbCatagory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--", "Manager", "Cashier", "Store Keeper", "Sales Rep", "Clerk", "Labour" }));
        cmbCatagory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCatagoryItemStateChanged(evt);
            }
        });

        cmbSection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--", "Grinding", "Packing", "Delivery", "Loading" }));
        cmbSection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSectionItemStateChanged(evt);
            }
        });

        jLabel1.setText("Personal Details");

        lblFname.setText("First Name");

        txtFname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFnameMouseClicked(evt);
            }
        });

        lblGender.setText("Gender");

        lblLastName.setText("Last Name");

        txtLname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLnameMouseClicked(evt);
            }
        });

        lblDateOfBirth.setText("Date of Birth");

        lblCivilStatus.setText("Civil Status");

        lblNic.setText("N I C");

        txtNIC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNICMouseClicked(evt);
            }
        });

        lblEFname.setText(" ");

        lblEGender.setText(" ");

        lblELname.setText(" ");

        lblEDOB.setText(" ");

        lblECivilStatus.setText(" ");

        lblENic.setText(" ");

        lblAccNo.setText("Acc No");

        txtAccNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAccNoFocusGained(evt);
            }
        });

        lblEpf.setText("EPF No");

        txtEPFNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEPFNoFocusGained(evt);
            }
        });

        jLabel16.setText("Contact Information");

        lblAddress.setText("Address");

        txtAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAddressFocusGained(evt);
            }
        });

        lblEmail.setText("Email");

        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailMouseClicked(evt);
            }
        });

        lblTelephone.setText("Telephone");

        txtTelephone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelephoneMouseClicked(evt);
            }
        });

        lblMobile.setText("Mobile");

        txtMobile.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMobileFocusGained(evt);
            }
        });

        jLabel21.setText("Catagory");

        lblSection.setText("Section");

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--", "Male", "Female" }));
        cmbGender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbGenderMouseClicked(evt);
            }
        });
        cmbGender.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGenderItemStateChanged(evt);
            }
        });

        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblEAddress.setText(" ");

        lblETelephone.setText(" ");

        lblEEmail.setText(" ");

        lblEMobile.setText(" ");

        lblECatagory.setText(" ");

        lblESection.setText(" ");

        cmbCivilStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--", "Single", "Married" }));
        cmbCivilStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCivilStatusItemStateChanged(evt);
            }
        });

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel24.setText("Basic Salary");

        txtBasicSalary.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBasicSalaryFocusGained(evt);
            }
        });

        lblEAccno.setText(" ");

        lblEEpfno.setText(" ");

        lblEBasicSal.setText(" ");

        txtDOB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDOBFocusGained(evt);
            }
        });
        txtDOB.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtDOBPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFname)
                                    .addComponent(lblGender)
                                    .addComponent(lblCivilStatus))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblEFname, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEGender, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblECivilStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFname)
                                    .addComponent(cmbGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbCivilStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLastName)
                                    .addComponent(lblDateOfBirth)
                                    .addComponent(lblNic))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblENic, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(lblEDOB, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(lblELname, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(txtNIC)
                                    .addComponent(txtLname)
                                    .addComponent(txtDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAddress)
                                    .addComponent(lblEmail))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(lblEEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblEMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblEAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAddress)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(56, 56, 56)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTelephone)
                                            .addComponent(lblMobile))
                                        .addGap(56, 56, 56)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTelephone)
                                            .addComponent(txtMobile)
                                            .addComponent(lblETelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAccNo)
                                    .addComponent(lblEpf)
                                    .addComponent(jLabel24))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblEAccno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAccNo)
                                    .addComponent(txtEPFNo)
                                    .addComponent(txtBasicSalary, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(lblEEpfno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEBasicSal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(80, 80, 80))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(123, 123, 123))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cmbCatagory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)
                        .addComponent(lblSection))
                    .addComponent(lblECatagory, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblESection, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccNo)
                    .addComponent(txtAccNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEAccno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEpf)
                    .addComponent(txtEPFNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEEpfno)
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEBasicSal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(52, 52, 52))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCatagory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(lblSection))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblECatagory)
                    .addComponent(lblESection))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFname)
                            .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLastName)
                            .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEFname, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblELname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDateOfBirth)
                                .addComponent(lblGender))
                            .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblEGender, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCivilStatus)
                                        .addComponent(cmbCivilStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNic)
                                        .addComponent(txtNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lblEDOB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblENic)
                            .addComponent(lblECivilStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblAddress)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTelephone)))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEAddress)
                            .addComponent(lblETelephone))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMobile)
                            .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEMobile)
                            .addComponent(lblEEmail)))
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Add", jPanel1);

        tblUpdateEmp.setModel(new javax.swing.table.DefaultTableModel(
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
        tblUpdateEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUpdateEmpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUpdateEmp);

        txtSearch.setText("Search...");
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setText("First Name");

        txtUFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUFnameActionPerformed(evt);
            }
        });
        txtUFname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUFnameFocusGained(evt);
            }
        });

        jLabel3.setText("Last Name");

        txtULname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtULnameFocusGained(evt);
            }
        });

        jLabel4.setText("Address");

        txtUAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUAddressFocusGained(evt);
            }
        });

        jLabel5.setText("Gender");

        jLabel6.setText("Date of Birth");

        jLabel7.setText("Civil Status");

        jLabel8.setText("NIC");

        txtUNic.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUNicFocusGained(evt);
            }
        });

        cmbUGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        jLabel9.setText("Telephone");

        txtUTelephone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUTelephoneFocusGained(evt);
            }
        });

        jLabel10.setText("Mobile");

        txtUMobile.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUMobileFocusGained(evt);
            }
        });

        jLabel11.setText("Email");

        txtUEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUEmailFocusGained(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        cmbUCivilStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Married" }));

        lblEUFname.setText("jLabel26");

        lblEULname.setText("jLabel26");

        lblEUAddress.setText("jLabel27");

        lblEUdob.setText("jLabel29");

        lblEUNic.setText("jLabel31");

        lblEUTelephone.setText("jLabel32");

        lblEUMobile.setText("jLabel33");

        lblEUEmail.setText("jLabel34");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUFname, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtUAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtULname, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtUNic, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(cmbUGender, 0, 150, Short.MAX_VALUE)
                            .addComponent(txtUTelephone, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtUMobile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtUEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(cmbUCivilStatus, 0, 150, Short.MAX_VALUE)
                            .addComponent(txtUDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEUFname, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEULname, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEUAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEUdob, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEUNic, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEUTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEUMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEUEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(btnUpdate)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtUFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEUFname))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtULname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEULname))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtUAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEUAddress))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cmbUGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(lblEUdob))
                                    .addComponent(txtUDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(cmbUCivilStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUNic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(lblEUNic))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtUTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEUTelephone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtUMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEUMobile))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtUEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEUEmail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate))
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Update", jPanel2);

        jScrollPane2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseMoved(evt);
            }
        });

        tblDelete.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDeleteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDeleteMousePressed(evt);
            }
        });
        tblDelete.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tblDeleteMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tblDeleteMouseMoved(evt);
            }
        });
        jScrollPane2.setViewportView(tblDelete);

        jLabel12.setText("First Name");

        jLabel13.setText("Last Name");

        jLabel14.setText("Address");

        jLabel15.setText("Gender");

        jLabel17.setText("Date of Birth");

        jLabel18.setText("Civil Status");

        jLabel19.setText("NIC");

        jLabel20.setText("Telephone");

        jLabel22.setText("Mobile");

        jLabel23.setText("Email");

        lblDfname.setText("jLabel24");

        lblDLname.setText("jLabel25");

        lblDAddress.setText("jLabel26");

        lblDGender.setText("jLabel27");

        lblDDOB.setText("jLabel28");

        lblDCivilStatus.setText("jLabel29");

        lblDNIC.setText("jLabel30");

        lblDTelephone.setText("jLabel31");

        lblDMobile.setText("jLabel32");

        lblDEmail.setText("jLabel33");

        btnDelete.setText("Delete");
        btnDelete.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnDeleteMouseMoved(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtDSearch.setText("Search...");
        txtDSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDSearchMouseClicked(evt);
            }
        });
        txtDSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDSearchActionPerformed(evt);
            }
        });
        txtDSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDSearchKeyReleased(evt);
            }
        });

        lblDrag.setText("aaaa");

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblxy)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblDrag, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblmouse)
                                .addGap(67, 67, 67)
                                .addComponent(lblframe))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDLname, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDfname, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDCivilStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDGender, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnDelete)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDrag, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                    .addComponent(txtDSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblmouse)
                                    .addComponent(lblframe))
                                .addGap(29, 29, 29))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jSeparator6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblxy)
                            .addComponent(btnDelete)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(lblDfname))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblDLname))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(lblDAddress))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lblDGender))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(lblDDOB))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(lblDCivilStatus))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(lblDNIC))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(lblDTelephone))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(lblDMobile))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(lblDEmail))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Delete", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 950, 450));

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

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mainmenubackgroundWindows.jpg"))); // NOI18N
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCatagoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCatagoryItemStateChanged

        String st = cmbCatagory.getModel().getSelectedItem().toString();
        if(st.equalsIgnoreCase("labour"))
        {
            cmbSection.setVisible(true);
            lblSection.setVisible(true);
        }
        else
        {
            cmbSection.setVisible(false);
            lblSection.setVisible(false);
        }
        lblECatagory.setText(" ");
        lblESection.setText(" ");
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCatagoryItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
       
        lblSection.setVisible(false);
        cmbSection.setVisible(false);
        btnDelete.setEnabled(false);
        lblDrag.setVisible(false);
        clearEUpdate();
        // TODO add your handling code here:
        clearAdd();
        clearDelete();
    }//GEN-LAST:event_formWindowOpened

    private void txtUFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUFnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Cal c = new Cal();
        String st;
        boolean e=true;
        st = txtFname.getText();
        if(st.equals("")||st.equals("First Name..."))
        {
            e = false;
            lblEFname.setForeground(Color.red);
            lblEFname.setText("Enter First Name");
        }
        else if(!isWord(st))
        {
            e = false;
            lblEFname.setForeground(Color.red);
            lblEFname.setText("Enter a valid name");
        }
        
        st = txtLname.getText();
        if(st.equals("")||st.equals("Last Name..."))
        {
            e = false;
            lblELname.setForeground(Color.red);
            lblELname.setText("Enter Last Name");
        }
        
        else if(!isWord(st))
        {
            e = false;
            lblELname.setForeground(Color.red);
            lblELname.setText("Enter a valid name");
        }
        
        st = cmbCivilStatus.getSelectedItem().toString();
        if(st.equals("--Select--"))
        {
            e = false;
            lblECivilStatus.setForeground(Color.red);
            lblECivilStatus.setText("Select civil Status");
        }
        
        try {
            st = c.formatedDate(txtDOB.getDate().toString());
            System.out.println(txtDOB.getDate().toString());
            System.out.println(st);
            if(!c.isValid(st))
            {
                e = false;
                lblEDOB.setForeground(Color.red);
                lblEDOB.setText("Enter Date of Birth");
            }
        } catch (Exception ex) {
            e = false;
            lblEDOB.setForeground(Color.red);
            lblEDOB.setText("Enter Date of Birth");
        }
        
//        if(st.equals(""))
//        {
//            e = false;
//            lblEDOB.setForeground(Color.red);
//            lblEDOB.setText("Enter Date of Birth");
//        }
        
        st = txtAddress.getText();
        if(st.equals("")||st.equals("Address..."))
        {
            e = false;
            lblEAddress.setForeground(Color.red);
            lblEAddress.setText("Enter Address");
        }
        
        st = txtTelephone.getText();
        if(st.equals("")||st.equals("phone no..."))
        {
            e = false;
            lblETelephone.setForeground(Color.red);
            lblETelephone.setText("Enter Telephone");
        }
        else if(!isPhoneNo(st))
        {
            e = false;
            lblETelephone.setForeground(Color.red);
            lblETelephone.setText("Enter a valid phone no");
        }
        
        st = txtEmail.getText();
        if(st.equals("")||st.equals("ABC@gmail.com"))
        {
            e = false;
            lblEEmail.setForeground(Color.red);
            lblEEmail.setText("Enter email");
        }
        
        else if(!isValidEmailAddress(st))
        {
            e = false;
            lblEEmail.setForeground(Color.red);
            lblEEmail.setText("Enter a valid Email address");
        }
        
        st = txtMobile.getText();
        if(st.equals("")||st.equals("Mobile no..."))
        {
            e = false;
            lblEMobile.setForeground(Color.red);
            lblEMobile.setText("Enter Mobile");
        }
        else if(!isPhoneNo(st))
        {
            e = false;
            lblEMobile.setForeground(Color.red);
            lblEMobile.setText("Enter a valid mobile no");
        }
        
        st = txtNIC.getText();
        if(st.equals("")||st.equals("N I C"))
        {
            e = false;
            lblENic.setForeground(Color.red);
            lblENic.setText("Enter NIC no");
        }
        
        else if(!isValidNIC(st))
        {
            e = false;
            lblENic.setForeground(Color.red);
            lblENic.setText("Enter Valid NIC no");
        }
        
        st = cmbGender.getModel().getSelectedItem().toString();
        if(st.equals("--Select--"))
        {
            e = false;
            lblEGender.setForeground(Color.red);
            lblEGender.setText("Select gender");
        }
        
        st = cmbCatagory.getSelectedItem().toString();
        if(st.equals("--Select--"))
        {
            e = false;
            lblECatagory.setForeground(Color.red);
            lblECatagory.setText("Select a employee catagory");
        }
        if(st.equalsIgnoreCase("labour") && cmbSection.getSelectedItem().toString().equalsIgnoreCase("--Select--"))
        {
            e = false;
            lblESection.setForeground(Color.red);
            lblESection.setText("Select a default section to labour");
        }
        st = txtAccNo.getText();
        if(st.equals(""))
        {
            e = false;
            lblEAccno.setForeground(Color.red);
            lblEAccno.setText("Enter Acc No");
        }
        else if(!isNumber(st))
        {
            e = false;
            lblEAccno.setForeground(Color.red);
            lblEAccno.setText("Enter valid Acc No");
        }
        st = txtEPFNo.getText();
        if(st.equals(""))
        {
            e = false;
            lblEEpfno.setForeground(Color.red);
            lblEEpfno.setText("Enter EPF No");
        }
        else if(!isNumber(st))
        {
            e = false;
            lblEEpfno.setForeground(Color.red);
            lblEEpfno.setText("Enter valid EPF No");
        }
        st = txtBasicSalary.getText();
        if(st.equals(""))
        {
            e = false;
            lblEBasicSal.setForeground(Color.red);
            lblEBasicSal.setText("Enter Basic Salary");
        }
        else if(!isNumber(st))
        {
            e = false;
            lblEBasicSal.setForeground(Color.red);
            lblEBasicSal.setText("Enter a valid Amount");
        }
        
        
        if(e)
        {
        //Create a Emp Object
        Emp d = new Emp();

        d.setfName(txtFname.getText());
        d.setlName(txtLname.getText());
        d.setAddress(txtAddress.getText());
        d.setPhone(txtTelephone.getText());
        d.setBod(c.formatedDate(txtDOB.getDate().toString()));
        d.setGender(cmbGender.getSelectedItem().toString());
        d.setNic(txtNIC.getText());
        d.setAccNo(Integer.parseInt(txtAccNo.getText()));
        d.setsDate(c.getDate());
        d.setMobile(Integer.parseInt(txtMobile.getText()));
        d.setEmail(txtEmail.getText());
        d.setCatagory(cmbCatagory.getSelectedItem().toString());
        d.setSection(cmbSection.getSelectedItem().toString());
        d.setbSal(Integer.parseInt(txtBasicSalary.getText()));
        if(cmbCivilStatus.getSelectedItem().toString().equalsIgnoreCase("Married"))
        {
            d.setCivilStatus(true);
        }
        else if(cmbCivilStatus.getSelectedItem().toString().equalsIgnoreCase("Single"))
        {
            d.setCivilStatus(false);
        }
        //Save to the database
        EmpDAO dao = new EmpDAO();
        boolean a = dao.addEmp(d);

        if(!a)
        {
            JOptionPane.showMessageDialog(rootPane, "The Employee you are trying to add is already exits");
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Successfully added to the database");
            clearAdd();
        }
        loadTable("", jScrollPane1, tblUpdateEmp); 
        loadTable("", jScrollPane2, tblDelete);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtFnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFnameMouseClicked


        lblEFname.setText(" ");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFnameMouseClicked

    private void cmbGenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbGenderMouseClicked

//        lblEGender.setText("");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGenderMouseClicked

    private void cmbGenderItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGenderItemStateChanged

        if(cmbGender.getModel().getSelectedItem().toString().equals("--Select--"))
        {
            lblEGender.setForeground(Color.red);
            lblEGender.setText("Select gender");
        }
        else
        {
            lblEGender.setText(" ");
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGenderItemStateChanged

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        
        boolean e = true;
        String st="";
        
        st = txtUFname.getText();
        if(st.equals(""))
        {
            lblEUFname.setForeground(Color.red);
            lblEUFname.setText("Enter Fisrt Name");
            e = false;
        }
        else if(!isWord(st))
        {
            lblEUFname.setForeground(Color.red);
            lblEUFname.setText("Enter Valid Fisrt Name");
            e = false;
        }
        
        st = txtULname.getText();
        if(st.equals(""))
        {
            lblEULname.setForeground(Color.red);
            lblEULname.setText("Enter Last Name");
            e = false;
        }
        else if(!isWord(st))
        {
            lblEULname.setForeground(Color.red);
            lblEULname.setText("Enter Valid Last Name");
            e = false;
        }
        
        st = txtUAddress.getText();
        if(st.equals(""))
        {
            lblEUAddress.setForeground(Color.red);
            lblEUAddress.setText("Enter Address");
            e = false;
        }
        
        
        
        st = c.formatedDate(txtUDOB.getDate().toString());
        if(st.equals(""))
        {
            lblEUdob.setForeground(Color.red);
            lblEUdob.setText("Enter Birth Day");
            e = false;
        }
        else if(!c.isValid(st))
        {
            lblEUdob.setForeground(Color.red);
            lblEUdob.setText("Enter Valid Birth Day");
            e = false;
        }        
        
        st = txtUNic.getText();
        if(st.equals(""))
        {
            lblEUNic.setForeground(Color.red);
            lblEUNic.setText("Enter NIC");
            e = false;
        }
       
        else if(!isValidNIC(st))
        {
            lblEUNic.setForeground(Color.red);
            lblEUNic.setText("Enter Valid NIC");
            e = false;
        }
        
        st = txtUTelephone.getText();
        if(st.equals(""))
        {
            lblEUTelephone.setForeground(Color.red);
            lblEUTelephone.setText("Enter Telephone");
            e = false;
        }
        
        st = txtUMobile.getText();
        if(st.equals(""))
        {
            lblEUMobile.setForeground(Color.red);
            lblEUMobile.setText("Enter Mobile");
            e = false;
        }
        
        st = txtULname.getText();
        if(st.equals(""))
        {
            lblEULname.setForeground(Color.red);
            lblEULname.setText("Enter Last Name");
            e = false;
        }
        
        st = txtUEmail.getText();
        if(st.equals(""))
        {
            lblEUEmail.setForeground(Color.red);
            lblEUEmail.setText("Enter Last Name");
            e = false;
        }
    
        
        
        if(e)
        {
        //Create a Emp Object
        Emp d = new Emp();

        d.setfName(txtUFname.getText());
        d.setlName(txtULname.getText());
        d.setAddress(txtUAddress.getText());
        d.setPhone(txtUTelephone.getText());
        d.setBod(c.formatedDate(txtUDOB.getDate().toString()));
        d.setGender(cmbUGender.getSelectedItem().toString());
        d.setNic(txtUNic.getText());
//        d.setAccNo(Integer.parseInt(txtUAccNo.getText()));
//        d.setsDate(c.getDate());
        d.setMobile(Integer.parseInt(txtUMobile.getText()));
        d.setEmail(txtUEmail.getText());
//        d.setCatagory(cmbCatagory.getSelectedItem().toString());
//        d.setSection(cmbSection.getSelectedItem().toString());
        if(cmbUCivilStatus.getSelectedItem().toString().equalsIgnoreCase("Married"))
        {
            d.setCivilStatus(true);
        }
        else if(cmbUCivilStatus.getSelectedItem().toString().equalsIgnoreCase("Single"))
        {
            d.setCivilStatus(false);
        }
        //Save to the database
        int r = tblUpdateEmp.getSelectedRow();
        EmpDAO dao1 = new EmpDAO();
        data = dao1.getAllEmpDetails(Integer.parseInt(tblUpdateEmp.getValueAt(r, 0).toString()));
        String st1 = data.get(0).elementAt(0);
        EmpDAO dao = new EmpDAO();
        boolean a = dao.updateEmp(d,st1);

//        if(!a)
//        {
//            JOptionPane.showMessageDialog(rootPane, "The Employee you are trying to add is already exits");
//        }
//        else
//        {
//            JOptionPane.showMessageDialog(rootPane, "Successfully added to the database");
//        }
        loadTable("", jScrollPane1, tblUpdateEmp);        
        txtSearch.setText("Search...");
        clearUpdate();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblUpdateEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUpdateEmpMouseClicked

                int r = tblUpdateEmp.getSelectedRow();
        EmpDAO dao1 = new EmpDAO();
//        System.out.println("aaaaaaaa");
//        System.out.println(Integer.parseInt(tblUpdateEmp.getValueAt(r, 0).toString()));
        data = dao1.getAllEmpDetails(Integer.parseInt(tblUpdateEmp.getValueAt(r, 0).toString()));

        r=0;

//        System.out.println("bbbbbbbbb");
        String gender = data.get(r).elementAt(6);
        String civilStatus = data.get(r).elementAt(9);
//        System.out.println("ccccccc");
        txtUFname.setText(data.get(r).elementAt(1));
        txtULname.setText(data.get(r).elementAt(2));
        txtUAddress.setText(data.get(r).elementAt(3));
//        cmbUGender.setSelectedItem(data.get(r).elementAt(7));
//        txtUCivilStatus.setText(data.get(r).elementAt(9));
//        txtUDOB.setDate(data.get(r).elementAt(5));
        java.util.Date date;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(data.get(r).elementAt(5));
                txtUDOB.setDate(date);
            } catch (ParseException ex) {
                Logger.getLogger(Profit.class.getName()).log(Level.SEVERE, null, ex);
            }
        
//        (data.get(r).elementAt(5));
        txtUTelephone.setText(data.get(r).elementAt(4));
        txtUMobile.setText(data.get(r).elementAt(15));
        txtUEmail.setText(data.get(r).elementAt(16));
        txtUNic.setText(data.get(r).elementAt(7));
        
        if(gender.equalsIgnoreCase("male"))
        {
            cmbUGender.setSelectedIndex(0);
        }
        else
        {
            cmbUGender.setSelectedIndex(1);
        }
        if(civilStatus.equalsIgnoreCase("true"))
        {
            cmbUCivilStatus.setSelectedIndex(1);
        }
        else
        {
            cmbUCivilStatus.setSelectedIndex(0);
        }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_tblUpdateEmpMouseClicked

    private void txtTelephoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelephoneMouseClicked

        lblETelephone.setText(" ");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelephoneMouseClicked

    private void cmbSectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSectionItemStateChanged

        lblESection.setText(" ");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSectionItemStateChanged

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked

        if(txtSearch.getText().equalsIgnoreCase("Search..."))
        {
            txtSearch.setForeground(Color.black);
            txtSearch.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

        loadTable(txtSearch.getText());
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cmbCivilStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCivilStatusItemStateChanged

        if(cmbCivilStatus.getModel().getSelectedItem().toString().equals("--Select--"))
        {
            lblECivilStatus.setForeground(Color.red);
            lblECivilStatus.setText("Select Civil Status");
        }
        else
        {
            lblECivilStatus.setText(" ");
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCivilStatusItemStateChanged

    private void txtLnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLnameMouseClicked
 
        lblELname.setText(" ");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLnameMouseClicked

    private void txtNICMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNICMouseClicked

        lblENic.setText(" ");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNICMouseClicked

    private void txtDSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDSearchActionPerformed

    private void txtDSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDSearchKeyReleased

        loadTable(txtDSearch.getText(), jScrollPane2, tblDelete);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDSearchKeyReleased

    private void txtDSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDSearchMouseClicked

        if(txtDSearch.getText().equalsIgnoreCase("Search..."))
        {
            txtDSearch.setForeground(Color.black);
            txtDSearch.setText("");
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDSearchMouseClicked

    private void tblDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDeleteMouseClicked

        int r = tblDelete.getSelectedRow();
        if(r!=-1)
        {
            btnDelete.setEnabled(true);
        }
        EmpDAO dao1 = new EmpDAO();
//        System.out.println("aaaaaaaa");
//        System.out.println(Integer.parseInt(tblUpdateEmp.getValueAt(r, 0).toString()));
        data = dao1.getAllEmpDetails(Integer.parseInt(tblDelete.getValueAt(r, 0).toString()));

        r=0;

//        System.out.println("bbbbbbbbb");

//        System.out.println("ccccccc");
        lblDfname.setText(data.get(r).elementAt(1));
        lblDLname.setText(data.get(r).elementAt(2));
        lblDAddress.setText(data.get(r).elementAt(3));
        lblDGender.setText(data.get(r).elementAt(6));
//        txtUCivilStatus.setText(data.get(r).elementAt(9));
        lblDDOB.setText(data.get(r).elementAt(5));
        lblDTelephone.setText(data.get(r).elementAt(4));
        lblDMobile.setText(data.get(r).elementAt(15));
        lblDEmail.setText(data.get(r).elementAt(16));
        lblDNIC.setText(data.get(r).elementAt(7));
        String civilStatus = data.get(r).elementAt(9);
        if(civilStatus.equalsIgnoreCase("true"))
        {
            lblDCivilStatus.setText("Maried");
        }
        else
        {
            lblDCivilStatus.setText("Single");
        }
//                PointerInfo inf = MouseInfo.getPointerInfo();
//        Point ptm = inf.getLocation();
//        Point ptf = this.getLocation();
//
//        lblmouse.setText(ptm.toString());
//
//        int a,b,c,d;
//        a = tblDelete.getLocationOnScreen().x;
//        b = tblDelete.getLocationOnScreen().y;
//        c = tblDelete.getLocationOnScreen().x + tblDelete.getWidth();
//        d = tblDelete.getLocationOnScreen().y + tblDelete.getHeight();
//        lblxy.setText(a+" "+b+" "+c+" "+d);
//        
//        if(a<ptm.x && b<ptm.y && c>ptm.x && d>ptm.y)
//        {
//            drag = true;
//            int row = tblDelete.getSelectedRow();
//        System.out.println(row);
//        lblDrag.setText(tblDelete.getValueAt(row, 1).toString()+" "+tblDelete.getValueAt(row, 2).toString());
//        dragst = lblDrag.getText();
//        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDeleteMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        String id = tblDelete.getValueAt(tblDelete.getSelectedRow(), 0).toString();
        EmpDAO dao = new EmpDAO();
        dao.deleteEmp(id);
        drag = false;
                loadTable("", jScrollPane2, tblDelete);

        lblDrag.setText("  ");
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblDeleteMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDeleteMouseDragged


        
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDeleteMouseDragged

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

        PointerInfo inf = MouseInfo.getPointerInfo();
        Point ptm = inf.getLocation();
        if(drag)
        {
            int r = tblDelete.getSelectedRow();
            lblDrag.setText(dragst);
            lblDrag.setVisible(true);
            lblDrag.setLocation(ptm.x-240,ptm.y-216);
//            lblDrag.setText(tblDelete.getValueAt(r, 1).toString()+" "+tblDelete.getValueAt(r, 2).toString());
            
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseMoved

    private void tblDeleteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDeleteMouseMoved

//        PointerInfo inf = MouseInfo.getPointerInfo();
//        Point ptm = inf.getLocation();
//        if(drag)
//        {
//            int r = tblDelete.getSelectedRow();
//            lblDrag.setText(dragst);
//            lblDrag.setVisible(true);
//            lblDrag.setLocation(ptm.x-240,ptm.y-216);
//            
//            
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDeleteMouseMoved

    private void tblDeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDeleteMousePressed

        
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDeleteMousePressed

    private void txtAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusGained

        lblEAddress.setText(" ");
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressFocusGained

    private void txtEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseClicked

        lblEEmail.setText(" ");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailMouseClicked

    private void txtAccNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAccNoFocusGained

        lblEAccno.setText(" ");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAccNoFocusGained

    private void txtEPFNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEPFNoFocusGained

        lblEEpfno.setText(" ");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEPFNoFocusGained

    private void txtBasicSalaryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBasicSalaryFocusGained

        lblEBasicSal.setText(" ");
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBasicSalaryFocusGained

    private void jTabbedPane1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseMoved

        PointerInfo inf = MouseInfo.getPointerInfo();
        Point ptm = inf.getLocation();
        if(drag)
        {
            int r = tblDelete.getSelectedRow();
            lblDrag.setText(dragst);
            lblDrag.setVisible(true);
            lblDrag.setLocation(ptm.x-240,ptm.y-216);
//            lblDrag.setText(tblDelete.getValueAt(r, 1).toString()+" "+tblDelete.getValueAt(r, 2).toString());
            
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseMoved

    private void jScrollPane2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseMoved

        PointerInfo inf = MouseInfo.getPointerInfo();
        Point ptm = inf.getLocation();
        if(drag)
        {
            int r = tblDelete.getSelectedRow();
            lblDrag.setText(dragst);
            lblDrag.setVisible(true);
            lblDrag.setLocation(ptm.x-240,ptm.y-216);
//            lblDrag.setText(tblDelete.getValueAt(r, 1).toString()+" "+tblDelete.getValueAt(r, 2).toString());
            
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseMoved

    private void btnDeleteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseMoved

        PointerInfo inf = MouseInfo.getPointerInfo();
        Point ptm = inf.getLocation();
        if(drag)
        {
            int r = tblDelete.getSelectedRow();
            lblDrag.setText(dragst);
            lblDrag.setVisible(true);
            lblDrag.setLocation(ptm.x-240,ptm.y-216);
//            lblDrag.setText(tblDelete.getValueAt(r, 1).toString()+" "+tblDelete.getValueAt(r, 2).toString());
            
        }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteMouseMoved

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

        
        drag = false;
        lblDrag.setText("  ");
//        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

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

    private void txtUFnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUFnameFocusGained

        lblEUFname.setText(" ");
    // TODO add your handling code here:
    }//GEN-LAST:event_txtUFnameFocusGained

    private void txtULnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtULnameFocusGained
       
        lblEULname.setText(" ");
        // TODO add your handling code here:
    }//GEN-LAST:event_txtULnameFocusGained

    private void txtUAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUAddressFocusGained
 
        lblEUAddress.setText(" ");
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUAddressFocusGained

    private void txtUNicFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUNicFocusGained

        lblEUNic.setText(" ");
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUNicFocusGained

    private void txtUTelephoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUTelephoneFocusGained
  
        lblEUTelephone.setText(" ");
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUTelephoneFocusGained

    private void txtUMobileFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUMobileFocusGained
 
        lblEUMobile.setText(" ");
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUMobileFocusGained

    private void txtUEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUEmailFocusGained
 
        lblEUEmail.setText(" ");
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUEmailFocusGained

    private void txtDOBFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDOBFocusGained

        lblEDOB.setText(" ");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDOBFocusGained

    private void txtMobileFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMobileFocusGained

        lblEMobile.setText(" ");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMobileFocusGained

    private void txtDOBPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtDOBPropertyChange

        lblEDOB.setText(" ");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDOBPropertyChange

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
            java.util.logging.Logger.getLogger(manageEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageEmp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbCatagory;
    private javax.swing.JComboBox cmbCivilStatus;
    private javax.swing.JComboBox cmbGender;
    private javax.swing.JComboBox cmbSection;
    private javax.swing.JComboBox cmbUCivilStatus;
    private javax.swing.JComboBox cmbUGender;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAccNo;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCivilStatus;
    private javax.swing.JLabel lblDAddress;
    private javax.swing.JLabel lblDCivilStatus;
    private javax.swing.JLabel lblDDOB;
    private javax.swing.JLabel lblDEmail;
    private javax.swing.JLabel lblDGender;
    private javax.swing.JLabel lblDLname;
    private javax.swing.JLabel lblDMobile;
    private javax.swing.JLabel lblDNIC;
    private javax.swing.JLabel lblDTelephone;
    private javax.swing.JLabel lblDateOfBirth;
    private javax.swing.JLabel lblDfname;
    private javax.swing.JLabel lblDrag;
    private javax.swing.JLabel lblEAccno;
    private javax.swing.JLabel lblEAddress;
    private javax.swing.JLabel lblEBasicSal;
    private javax.swing.JLabel lblECatagory;
    private javax.swing.JLabel lblECivilStatus;
    private javax.swing.JLabel lblEDOB;
    private javax.swing.JLabel lblEEmail;
    private javax.swing.JLabel lblEEpfno;
    private javax.swing.JLabel lblEFname;
    private javax.swing.JLabel lblEGender;
    private javax.swing.JLabel lblELname;
    private javax.swing.JLabel lblEMobile;
    private javax.swing.JLabel lblENic;
    private javax.swing.JLabel lblESection;
    private javax.swing.JLabel lblETelephone;
    private javax.swing.JLabel lblEUAddress;
    private javax.swing.JLabel lblEUEmail;
    private javax.swing.JLabel lblEUFname;
    private javax.swing.JLabel lblEULname;
    private javax.swing.JLabel lblEUMobile;
    private javax.swing.JLabel lblEUNic;
    private javax.swing.JLabel lblEUTelephone;
    private javax.swing.JLabel lblEUdob;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEpf;
    private javax.swing.JLabel lblFname;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMobile;
    private javax.swing.JLabel lblNic;
    private javax.swing.JLabel lblSection;
    private javax.swing.JLabel lblTelephone;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lblframe;
    private javax.swing.JLabel lblmouse;
    private javax.swing.JLabel lbltime;
    private javax.swing.JLabel lblxy;
    private javax.swing.JButton logout;
    private javax.swing.JPanel pnlBtn;
    private javax.swing.JTable tblDelete;
    private javax.swing.JTable tblUpdateEmp;
    private javax.swing.JTextField txtAccNo;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBasicSalary;
    private com.toedter.calendar.JDateChooser txtDOB;
    private javax.swing.JTextField txtDSearch;
    private javax.swing.JTextField txtEPFNo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtNIC;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTelephone;
    private javax.swing.JTextField txtUAddress;
    private com.toedter.calendar.JDateChooser txtUDOB;
    private javax.swing.JTextField txtUEmail;
    private javax.swing.JTextField txtUFname;
    private javax.swing.JTextField txtULname;
    private javax.swing.JTextField txtUMobile;
    private javax.swing.JTextField txtUNic;
    private javax.swing.JTextField txtUTelephone;
    // End of variables declaration//GEN-END:variables
}
