/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks.foodieesoft.frames;

import geeks.foodieesoft.beans.Customer;
import geeks.foodieesoft.beans.Discount;
import geeks.foodieesoft.beans.Order;
import geeks.foodieesoft.beans.Product;
import geeks.foodieesoft.beans.OrderDetail;
import geeks.foodieesoft.dao.DBManager;
import geeks.foodieesoft.dao.DBManagerInterface;
import geeks.foodieesoft.util.CurrentDate;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;

/**
 *
 * @author Vksoni
 */
public class SalePage extends javax.swing.JFrame {

    /**
     * Creates new form UserType
     */
    DBManagerInterface dbManager;
    DefaultTableModel tableModelProduct;
    DefaultTableModel tableModelProductBills;
    ArrayList<Product> product_list;
    ArrayList<Discount> discount_types_list;
    ArrayList<OrderDetail> order_detail_list;
    TableRowSorter<DefaultTableModel> rowSorter = null;
    DefaultComboBoxModel comboBoxModelDiscountType;
    public static int user_id = LoginPage.user_id;
    public static int user_cat_id = LoginPage.user_cat_id;
    public int total_calcu_bill = 0;
    public int grand_total = 0;
    Customer customer;
    public int custo_id;
    Random randomNumGenerator;

    public SalePage() {
        initComponents();
        dbManager = new DBManager();
        tableModelProduct = (DefaultTableModel) this.jTableProduct.getModel();
        tableModelProductBills = (DefaultTableModel) this.jTableProductBills.getModel();
        comboBoxModelDiscountType = (DefaultComboBoxModel) this.jComboBoxDiscountType.getModel();
        this.jComboBoxDiscountType.setVisible(true);
        discount_types_list = dbManager.getDiscountTypes();
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelProduct);
        this.jTableProduct.setRowSorter(rowSorter);

        order_detail_list = new ArrayList<OrderDetail>();
        // disable before select delivery or walkin
        this.jButtonAdd.setEnabled(false);
        this.jTableProduct.setEnabled(false);
        this.jTableProductBills.setEnabled(false);
        this.jTextFieldSerachProducts.setEnabled(false);
        this.jSpinnerQuantity.setEnabled(false);
        this.jComboBoxDiscountType.setEnabled(false);
        this.jTextFieldDiscount.setEnabled(false);
        this.jButtonGenerateBill.setEnabled(false);
        showInProductTable();
        showInDiscountComboBox();
        randomNumGenerator = new Random();

        JTableHeader headerProduct = this.jTableProduct.getTableHeader();
        headerProduct.setBackground(new Color(0, 0, 51));
        headerProduct.setForeground(new Color(0, 204, 0));
        headerProduct.setFont(new Font("SansSerif", Font.BOLD, 16));

        JTableHeader header = this.jTableProductBills.getTableHeader();
        header.setBackground(new Color(0, 0, 51));
        header.setForeground(new Color(0, 204, 0));
        header.setFont(new Font("SansSerif", Font.BOLD, 16));
        custo_id = 1;

    }

    public SalePage(int customer_id) {
        initComponents();
        dbManager = new DBManager();
        customer = dbManager.getCustomerDetail(customer_id);
        tableModelProduct = (DefaultTableModel) this.jTableProduct.getModel();
        tableModelProductBills = (DefaultTableModel) this.jTableProductBills.getModel();
        comboBoxModelDiscountType = (DefaultComboBoxModel) this.jComboBoxDiscountType.getModel();
        this.jComboBoxDiscountType.setVisible(true);
        discount_types_list = dbManager.getDiscountTypes();
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelProduct);
        this.jTableProduct.setRowSorter(rowSorter);
        this.jLabelName.setText(customer.getCustomer_name());
        this.jLabelContact.setText(customer.getContact());
        this.jLabelAddress.setText(customer.getAddress());
        order_detail_list = new ArrayList<OrderDetail>();

        showInProductTable();
        this.jButtonAdd.setEnabled(true);
        custo_id = customer_id;
        showInDiscountComboBox();
        randomNumGenerator = new Random();

        JTableHeader headerProduct = this.jTableProduct.getTableHeader();
        headerProduct.setBackground(new Color(0, 0, 51));
        headerProduct.setForeground(new Color(0, 204, 0));
        headerProduct.setFont(new Font("SansSerif", Font.BOLD, 16));

        JTableHeader header = this.jTableProductBills.getTableHeader();
        header.setBackground(new Color(0, 0, 51));
        header.setForeground(new Color(0, 204, 0));
        header.setFont(new Font("SansSerif", Font.BOLD, 16));

        // disable before select delivery or walkin
        this.jButtonAdd.setEnabled(true);
        this.jTableProduct.setEnabled(true);
        this.jTableProductBills.setEnabled(true);
        this.jTextFieldSerachProducts.setEnabled(true);
        this.jSpinnerQuantity.setEnabled(true);
        this.jComboBoxDiscountType.setEnabled(true);
        this.jTextFieldDiscount.setEnabled(true);
        this.jButtonGenerateBill.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabelName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabelContact = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabelAddress = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jButtonGenerateBill = new javax.swing.JButton();
        jTextFieldDiscount = new javax.swing.JTextField();
        jSpinnerQuantity = new javax.swing.JSpinner();
        jSeparator11 = new javax.swing.JSeparator();
        jLabelShowlBill = new javax.swing.JLabel();
        jComboBoxDiscountType = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldSerachProducts = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabelTotalBill = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jRadioButtonDelivery = new javax.swing.JRadioButton();
        jRadioButtonWalkin = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableProductBills = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jLabelExit = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/Untitled-1.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 230, 170));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("CUSTOMER");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 204, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 51));
        jButton2.setText("Back");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 20));

        jTableProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTableProduct.setForeground(new java.awt.Color(0, 0, 51));
        jTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Id", "Food Name", "Price (Rs)", "Quantity", "Food Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProduct.setColumnSelectionAllowed(true);
        jTableProduct.setGridColor(new java.awt.Color(0, 0, 51));
        jTableProduct.setSelectionBackground(new java.awt.Color(0, 0, 51));
        jTableProduct.setSelectionForeground(new java.awt.Color(0, 204, 0));
        jTableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProduct);
        jTableProduct.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableProduct.getColumnModel().getColumnCount() > 0) {
            jTableProduct.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTableProduct.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTableProduct.getColumnModel().getColumn(3).setPreferredWidth(2);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 610, 200));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 51));
        jLabel9.setText("NAME:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 132, 260, -1));

        jLabelName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 140, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 51));
        jLabel10.setText("CONTACT#:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 260, -1));

        jLabelContact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jLabelContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 140, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 51));
        jLabel11.setText("ADDRESS:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 260, -1));

        jLabelAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jLabelAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 160, -1));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 132, 260, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 51));
        jLabel13.setText("SEARCH:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 260, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 51));
        jLabel14.setText("QUANTITY");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(637, 220, 190, -1));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 360, -1));

        jButtonGenerateBill.setBackground(new java.awt.Color(0, 204, 0));
        jButtonGenerateBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonGenerateBill.setForeground(new java.awt.Color(0, 0, 51));
        jButtonGenerateBill.setText("Generate");
        jButtonGenerateBill.setBorder(null);
        jButtonGenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateBillActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonGenerateBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 590, 260, 30));

        jTextFieldDiscount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldDiscount.setText("0");
        jTextFieldDiscount.setBorder(null);
        jTextFieldDiscount.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldDiscountMouseClicked(evt);
            }
        });
        jTextFieldDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDiscountActionPerformed(evt);
            }
        });
        jTextFieldDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDiscountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDiscountKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 520, 200, 20));
        jPanel1.add(jSpinnerQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 260, -1));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 510, 380, -1));

        jLabelShowlBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelShowlBill.setForeground(new java.awt.Color(0, 204, 0));
        jLabelShowlBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelShowlBill.setText("0");
        jPanel1.add(jLabelShowlBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 480, 330, -1));

        jComboBoxDiscountType.setBackground(new java.awt.Color(0, 0, 51));
        jComboBoxDiscountType.setForeground(new java.awt.Color(0, 204, 0));
        jComboBoxDiscountType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDiscountTypeItemStateChanged(evt);
            }
        });
        jComboBoxDiscountType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDiscountTypeActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxDiscountType, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 520, 150, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setText("Total Bill");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 550, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 550, 380, -1));

        jTextFieldSerachProducts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldSerachProducts.setText("search products ....");
        jTextFieldSerachProducts.setBorder(null);
        jTextFieldSerachProducts.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldSerachProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldSerachProductsMouseClicked(evt);
            }
        });
        jTextFieldSerachProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSerachProductsActionPerformed(evt);
            }
        });
        jTextFieldSerachProducts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSerachProductsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSerachProductsKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldSerachProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 200, 20));
        jPanel1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 580, 380, -1));

        jLabelTotalBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTotalBill.setForeground(new java.awt.Color(0, 204, 0));
        jLabelTotalBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalBill.setText("0");
        jPanel1.add(jLabelTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 560, 330, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 51));
        jLabel16.setText("Bill");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 480, 30, -1));

        jRadioButtonDelivery.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButtonDelivery);
        jRadioButtonDelivery.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonDelivery.setForeground(new java.awt.Color(0, 204, 0));
        jRadioButtonDelivery.setText("Delivery");
        jRadioButtonDelivery.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonDeliveryItemStateChanged(evt);
            }
        });
        jRadioButtonDelivery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonDeliveryMouseClicked(evt);
            }
        });
        jRadioButtonDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDeliveryActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButtonDelivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        jRadioButtonWalkin.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButtonWalkin);
        jRadioButtonWalkin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonWalkin.setForeground(new java.awt.Color(0, 204, 0));
        jRadioButtonWalkin.setText("Walking");
        jRadioButtonWalkin.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonWalkinItemStateChanged(evt);
            }
        });
        jRadioButtonWalkin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonWalkinMouseClicked(evt);
            }
        });
        jRadioButtonWalkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonWalkinActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButtonWalkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        jTableProductBills.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTableProductBills.setForeground(new java.awt.Color(0, 0, 51));
        jTableProductBills.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Name", "Price (Rs)", "Quantity", "Total Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProductBills.setColumnSelectionAllowed(true);
        jTableProductBills.setGridColor(new java.awt.Color(0, 0, 51));
        jTableProductBills.setSelectionBackground(new java.awt.Color(0, 0, 51));
        jTableProductBills.setSelectionForeground(new java.awt.Color(0, 204, 0));
        jTableProductBills.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductBillsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableProductBills);
        jTableProductBills.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableProductBills.getColumnModel().getColumnCount() > 0) {
            jTableProductBills.getColumnModel().getColumn(1).setPreferredWidth(5);
            jTableProductBills.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTableProductBills.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 520, 200));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 51));
        jLabel17.setText("DISCOUNT TYPE");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 520, 140, -1));

        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/geeks/foodieesoft/images/plus-icon-0.png"))); // NOI18N
        jButtonAdd.setBorder(null);
        jButtonAdd.setBorderPainted(false);
        jButtonAdd.setContentAreaFilled(false);
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 200, 60, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1180, 640));

        jLabelExit.setBackground(new java.awt.Color(0, 0, 51));
        jLabelExit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelExit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelExit.setText("X");
        jLabelExit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabelExit.setOpaque(true);
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelExitMouseExited(evt);
            }
        });
        getContentPane().add(jLabelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 40, 40));

        jLabelMin.setBackground(new java.awt.Color(255, 0, 0));
        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMin.setText("-");
        jLabelMin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 40, 40));

        jLabel6.setBackground(new java.awt.Color(0, 0, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sale ");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new HomePage(user_id, user_cat_id).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductMouseClicked
        // TODO add your handling code here:
//        this.jButtonUpdate.setVisible(true);
//        this.jButtonDelete.setVisible(true);
//        this.jButtonSave.setVisible(false);
//
//        this.jTextFieldQuestion.setText(questions_list.get(this.jTableQuestions.getSelectedRow()).getQuestions());

    }//GEN-LAST:event_jTableProductMouseClicked

    private void jButtonGenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateBillActionPerformed
        int discount_id = discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_id();
        int billNum = randomNumGenerator.nextInt(10000);

        if (this.jRadioButtonWalkin.isSelected()) {
            custo_id = 1;
        }
        try {
            int discount = 0;
            if (!(this.jTextFieldDiscount.getText().equalsIgnoreCase("Enter Discount.."))) {
                discount = Integer.parseInt(this.jTextFieldDiscount.getText());
            }
            if (containsLetter(this.jTextFieldDiscount.getText())) {
                if (discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_type().equalsIgnoreCase("Amount")) {
                    grand_total = total_calcu_bill - discount;
                    this.jLabelTotalBill.setText("Rs:" + grand_total);
                    dbManager.saveOrder(new Order(0, custo_id, billNum, 1, user_id, CurrentDate.getCurrentDate(), 0, "", discount_id, discount, grand_total));
                    for (OrderDetail detail : order_detail_list) {
                        dbManager.saveOrderDetail(new OrderDetail(0, dbManager.getLastOrderId(), detail.getProduct_id(), detail.getQantity(), 1, user_id, CurrentDate.getCurrentDate(), 0, detail.getTotal_price(), ""));
                    }
                    JOptionPane.showMessageDialog(this, "Your total bill is Rs: " + grand_total);
                    new SalePage().setVisible(true);
                    this.dispose();

                    genReport();

                } else if (discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_type().equalsIgnoreCase("Percentage")) {
                    int percent_money = (discount * total_calcu_bill) / 100;
                    grand_total = total_calcu_bill - percent_money;
                    this.jLabelTotalBill.setText("Rs: " + grand_total);
                    dbManager.saveOrder(new Order(0, custo_id, billNum, 1, user_id, CurrentDate.getCurrentDate(), 0, "", discount_id, discount, grand_total));
                    for (OrderDetail detail : order_detail_list) {
                        dbManager.saveOrderDetail(new OrderDetail(0, dbManager.getLastOrderId(), detail.getProduct_id(), detail.getQantity(), 1, user_id, CurrentDate.getCurrentDate(), 0, detail.getTotal_price(), ""));
                    }
                    JOptionPane.showMessageDialog(this, "Your total bill is Rs: " + grand_total);

                    new SalePage().setVisible(true);
                    this.dispose();

                    genReport();

                }

            } else {
                JOptionPane.showMessageDialog(this, "Discount should in number");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Discount should in number");
        }


    }//GEN-LAST:event_jButtonGenerateBillActionPerformed

    private void jTextFieldDiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldDiscountMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldDiscountMouseClicked

    private void jTextFieldDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDiscountActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldDiscountActionPerformed

    private void jTextFieldDiscountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiscountKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_jTextFieldDiscountKeyPressed

    private void jComboBoxDiscountTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDiscountTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDiscountTypeActionPerformed

    private void jTextFieldSerachProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSerachProductsMouseClicked
        if (this.jTextFieldSerachProducts.getText().equalsIgnoreCase("search products ....")) {
            this.jTextFieldSerachProducts.setText("");
        }    }//GEN-LAST:event_jTextFieldSerachProductsMouseClicked

    private void jTextFieldSerachProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSerachProductsActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldSerachProductsActionPerformed

    private void jTextFieldSerachProductsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSerachProductsKeyPressed
        if (this.jTextFieldSerachProducts.getText().equalsIgnoreCase("search products ....")) {
            this.jTextFieldSerachProducts.setText("");
        }
    }//GEN-LAST:event_jTextFieldSerachProductsKeyPressed

    private void jRadioButtonDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDeliveryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonDeliveryActionPerformed

    private void jRadioButtonWalkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonWalkinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonWalkinActionPerformed

    private void jRadioButtonDeliveryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonDeliveryMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jRadioButtonDeliveryMouseClicked

    private void jTextFieldSerachProductsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSerachProductsKeyReleased
        // TODO add your handling code here:

        String searchData = this.jTextFieldSerachProducts.getText();
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchData));

    }//GEN-LAST:event_jTextFieldSerachProductsKeyReleased

    private void jTableProductBillsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductBillsMouseClicked
        // TODO add your handling code here:

        JPanel panel = new JPanel();
        panel.add(new JLabel("Quantity"));

        JTextField textField = new JTextField(10);
        panel.add(textField);
        JButton btnUpdate = new JButton("Update");
        panel.add(btnUpdate);

        int result = JOptionPane.showOptionDialog(null, panel, "Update quantity",
                0, 0,
                null, null, null);


    }//GEN-LAST:event_jTableProductBillsMouseClicked

    private void jRadioButtonWalkinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonWalkinMouseClicked
        // TODO add your handling code here:
        if (this.jRadioButtonWalkin.isSelected()) {
            this.jButtonAdd.setEnabled(true);
            this.jTableProduct.setEnabled(true);
            this.jTableProductBills.setEnabled(true);
            this.jTextFieldSerachProducts.setEnabled(true);
            this.jSpinnerQuantity.setEnabled(true);
            this.jComboBoxDiscountType.setEnabled(true);
            this.jTextFieldDiscount.setEnabled(true);
            this.jButtonGenerateBill.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButtonWalkinMouseClicked

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jLabelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseEntered
        // TODO add your handling code here:

        this.jLabelExit.setBackground(Color.red);
    }//GEN-LAST:event_jLabelExitMouseEntered

    private void jLabelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseExited
        // TODO add your handling code here:
        this.jLabelExit.setBackground(new Color(0, 0, 51));
    }//GEN-LAST:event_jLabelExitMouseExited

    private void jTextFieldDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiscountKeyReleased
        try {
            int discount = 0;
            if (!(this.jTextFieldDiscount.getText().equalsIgnoreCase("Enter Discount.."))) {
                discount = Integer.parseInt(this.jTextFieldDiscount.getText());
            }
            if (containsLetter(this.jTextFieldDiscount.getText())) {
                if (discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_type().equalsIgnoreCase("Amount")) {
                    grand_total = total_calcu_bill - discount;
                    this.jLabelTotalBill.setText("Rs:" + grand_total);

                } else if (discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_type().equalsIgnoreCase("Percentage")) {
                    int percent_money = (discount * total_calcu_bill) / 100;
                    grand_total = total_calcu_bill - percent_money;
                    this.jLabelTotalBill.setText("Rs: " + grand_total);

                }

            } else {
                JOptionPane.showMessageDialog(this, "Discount should in number");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Discount should in number");
        }

    }//GEN-LAST:event_jTextFieldDiscountKeyReleased

    private void jComboBoxDiscountTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDiscountTypeItemStateChanged
        // TODO add your handling code here:
        int discount_id = discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_id();
        try {
            int discount = 0;
            if (!(this.jTextFieldDiscount.getText().equalsIgnoreCase("Enter Discount.."))) {
                discount = Integer.parseInt(this.jTextFieldDiscount.getText());
            }
            if (containsLetter(this.jTextFieldDiscount.getText())) {
                if (discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_type().equalsIgnoreCase("Amount")) {
                    grand_total = total_calcu_bill - discount;
                    this.jLabelTotalBill.setText("Rs:" + grand_total);
                } else if (discount_types_list.get(this.jComboBoxDiscountType.getSelectedIndex()).getDiscount_type().equalsIgnoreCase("Percentage")) {
                    int percent_money = (discount * total_calcu_bill) / 100;
                    grand_total = total_calcu_bill - percent_money;
                    this.jLabelTotalBill.setText("Rs: " + grand_total);

                }

            } else {

            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jComboBoxDiscountTypeItemStateChanged

    private void jRadioButtonWalkinItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonWalkinItemStateChanged
        // TODO add your handling code here:
        if (this.jRadioButtonWalkin.isSelected()) {
            this.jLabelName.setText("Mr Walking");
            this.jLabelAddress.setText("NULL");
            this.jLabelAddress.setText("NULL");
            custo_id = 1;

        }
    }//GEN-LAST:event_jRadioButtonWalkinItemStateChanged

    private void jRadioButtonDeliveryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonDeliveryItemStateChanged
        // TODO add your handling code here:
        if (this.jRadioButtonDelivery.isSelected()) {
            new DeliveryInfoPage().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jRadioButtonDeliveryItemStateChanged

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        if (this.jTableProduct.getSelectedRow() != -1 && Integer.parseInt("" + this.jSpinnerQuantity.getValue()) > 0) {
            int old_quantitiy = Integer.parseInt("" + this.jTableProduct.getValueAt(this.jTableProduct.getSelectedRow(), 3));
            int selling_quantity = Integer.parseInt(this.jSpinnerQuantity.getValue() + "");
            int new_quantity = old_quantitiy - selling_quantity;
            String product_name = "" + this.jTableProduct.getValueAt(this.jTableProduct.getSelectedRow(), 1);

            if (old_quantitiy > 0 && selling_quantity <= old_quantitiy) {
                int product_id = Integer.parseInt("" + this.jTableProduct.getValueAt(this.jTableProduct.getSelectedRow(), 0));
                int price = Integer.parseInt("" + this.jTableProduct.getValueAt(this.jTableProduct.getSelectedRow(), 2));
                int i = dbManager.mofidyProductsQuantity(new Product(product_id, 0, 0, 0, new_quantity, 0, 0, "", "", ""));
                double total_price = price * selling_quantity;
                total_calcu_bill += total_price;
                this.jLabelTotalBill.setText("Rs:" + total_calcu_bill);
                this.jLabelShowlBill.setText("Rs:" + total_calcu_bill);

                Object row[] = {product_name, price, selling_quantity, total_price};

                showInBillTable(row);
                showInProductTable();
                try {
                    order_detail_list.add(new OrderDetail(0, 0, product_id, selling_quantity, 1, user_id, "", 0, total_price, ""));
                } catch (Exception e) {
                }
                this.jSpinnerQuantity.setValue(0);

            } else {
                JOptionPane.showMessageDialog(this, "Can't sell " + selling_quantity + " " + product_name + " because  avalible quantity is " + old_quantitiy);

            }

        } else if (this.jTableProduct.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select the product");
        } else if (Integer.parseInt("" + this.jSpinnerQuantity.getValue()) == 0) {
            JOptionPane.showMessageDialog(this, "Quantity can't be zero ");
        } else if (Integer.parseInt("" + this.jSpinnerQuantity.getValue()) <= 0) {
            JOptionPane.showMessageDialog(this, "Quantity can't be negative");
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

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
            java.util.logging.Logger.getLogger(SalePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalePage().setVisible(true);
            }
        });
    }

    public void showInProductTable() {
        tableModelProduct.setRowCount(0);

        product_list = dbManager.getAllProducts();
        for (Product product : product_list) {
            Vector V = new Vector();
            V.add(product.getProduct_id());
            V.add(product.getFood_name());
            V.add(product.getPrice());
            V.add(product.getQuantity());
            V.add(dbManager.getFoodType(product.getFood_cat_id()));
            V.add(product.getFood_cat_id());
            tableModelProduct.addRow(V);
        }
    }

    public void showInBillTable(Object row[]) {
        tableModelProductBills.addRow(row);

    }

    public void showInDiscountComboBox() {
        for (Discount discount : discount_types_list) {

            this.jComboBoxDiscountType.addItem("" + discount.getDiscount_type());

        }
    }

    public final boolean containsLetter(String s) {
        boolean containsLetter = true;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c)) {
                    containsLetter = false;
                    break;
                }
            }
        }

        return containsLetter;
    }

    public void genReport() {

        IReportEngine engine = null;
        EngineConfig config = null;

        try {

            config = new EngineConfig();
            //config.setLogConfig("c:/temp/test", Level.FINEST);
            Platform.startup(config);
            IReportEngineFactory factory = (IReportEngineFactory) Platform
                    .createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
            engine = factory.createReportEngine(config);

            IReportRunnable design = null;
            //Open the report design
            String rpath = "new_report.rptdesign";

            design = engine.openReportDesign(rpath);

            IRunAndRenderTask task = engine.createRunAndRenderTask(design);
            //task.setParameterValue("Top Count", (new Integer(5)));
            //task.validateParameters();
            // int order=DbManager.getMaxOrder();
            HTMLRenderOption options = new HTMLRenderOption();
            int order_no = order_detail_list.size();
            options.setOutputFileName("C:\\Users\\ALI SHAIKH PC\\Desktop\\Recipts/ReciptNo" + order_no + ".pdf");
            options.setOutputFormat("pdf");
            //options.setHtmlRtLFlag(false);
            //options.setEmbeddable(false);
            //options.setImageDirectory("C:\\test\\images");

            //PDFRenderOption options = new PDFRenderOption();
            //options.setOutputFileName("c:/temp/test.pdf");
            //options.setOutputFormat("pdf");
            task.setRenderOption(options);
            task.run();
            task.close();
            engine.destroy();
        } catch (Exception ex) {
            System.out.println("hello");
            System.out.println(ex.getMessage());
           ex.printStackTrace();
        } finally {
            Platform.shutdown();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonGenerateBill;
    private javax.swing.JComboBox<String> jComboBoxDiscountType;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelContact;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelShowlBill;
    private javax.swing.JLabel jLabelTotalBill;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonDelivery;
    private javax.swing.JRadioButton jRadioButtonWalkin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSpinner jSpinnerQuantity;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JTable jTableProductBills;
    private javax.swing.JTextField jTextFieldDiscount;
    private javax.swing.JTextField jTextFieldSerachProducts;
    // End of variables declaration//GEN-END:variables
}
