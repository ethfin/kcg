/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author TOPHY
 */
public class Panel extends javax.swing.JFrame {

    Database r = new Database();
    
    Connection con = null;
    PreparedStatement qry = null;
    ResultSet rs = null;
    
    
    public Panel() {
        try {
            initComponents();
            showDate();
            showTime();
            LoadData();
            LoadData1();
            sales();
            accounts();
        } catch (SQLException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private void LoadData() throws SQLException {
        DefaultTableModel dtm = (DefaultTableModel)table2.getModel();
        dtm.setRowCount(0);
        r.Connect();
        r.qry=(PreparedStatement)r.con.prepareStatement("SELECT * FROM stocks_table");
        r.rs=r.qry.executeQuery();
        
        while (r.rs.next()) {
            dtm.addRow(new Object[] {
                r.rs.getInt("receive_no"),
                r.rs.getDate("receive_date"),
                r.rs.getInt("item_no"),
                r.rs.getString("name"),
                r.rs.getInt("quantity"),
                r.rs.getDouble("capital_prc"),
                r.rs.getDouble("sell_prc")
            });
        }
        r.Disconnect();
        table3.setModel(dtm);
        table2.setModel(dtm);
        table5.setModel(dtm);
        table3.updateUI();
        table5.updateUI();
        table2.updateUI();
    }
    
    private void LoadData1() throws SQLException {
        DefaultTableModel dtm = (DefaultTableModel)table4.getModel();
        dtm.setRowCount(0);
        r.Connect();
        r.qry=(PreparedStatement)r.con.prepareStatement("SELECT * FROM history");
        r.rs=r.qry.executeQuery();
        
        while (r.rs.next()) {
            dtm.addRow(new Object[] {
                r.rs.getInt("ID"),
                r.rs.getString("Name"),
                r.rs.getDate("Date"),
                r.rs.getDouble("Price"),
                r.rs.getInt("Total_quantity"),
                r.rs.getInt("Remain_quantity"),
                r.rs.getDouble("capital_prc"),
                r.rs.getDouble("profit"),
                r.rs.getDouble("Amount"),
                r.rs.getDouble("Payment"),
                r.rs.getDouble("Changes")
            });
        }
        r.Disconnect();
        table4.setModel(dtm);
        table4.updateUI();
    }
    
    private void sales() throws SQLException {
        DefaultTableModel dtm = (DefaultTableModel)sales_table.getModel();
        dtm.setRowCount(0);
        r.Connect();
        r.qry=(PreparedStatement)r.con.prepareStatement("SELECT * FROM daily");
        r.rs=r.qry.executeQuery();
        
        while (r.rs.next()) {
            dtm.addRow(new Object[] {
                r.rs.getInt("ID"),
                r.rs.getString("Name"),
                r.rs.getDate("Date"),
                r.rs.getDouble("Price"),
                r.rs.getInt("Total_quantity"),
                r.rs.getInt("Remain_quantity"),
                r.rs.getDouble("capital_prc"),
                r.rs.getDouble("profit"),
                r.rs.getDouble("Amount"),
                r.rs.getDouble("Payment"),
                r.rs.getDouble("Changes")
            });
        }
        r.Disconnect();
        sales_table.setModel(dtm);
        sales_table.updateUI();
    }
    
    private void accounts() throws SQLException {
        DefaultTableModel dtm = (DefaultTableModel)users.getModel();
        dtm.setRowCount(0);
        r.Connect();
        r.qry=(PreparedStatement)r.con.prepareStatement("SELECT * FROM login");
        r.rs=r.qry.executeQuery();
        
        while (r.rs.next()) {
            dtm.addRow(new Object[] {
                r.rs.getInt("ID"),
                r.rs.getString("name"),
                r.rs.getString("pass")
            });
        }
        r.Disconnect();
        users.setModel(dtm);
        users.updateUI();
    }
    
    void showDate() {
        Date D = new Date();
        SimpleDateFormat Frm = new SimpleDateFormat("yyyy-MM-dd");
        dateLab.setText(Frm.format(D));
        txt2.setText(Frm.format(D));
        
    }
    void showTime() {
        new Timer(0, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Date D = new Date();
                SimpleDateFormat Frm = new SimpleDateFormat("hh:mm:ss a");
                timeLab.setText(Frm.format(D));
            }
        }).start();
    }
    
    //SEARCH CODE FOR TABLE
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        Header = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Layers = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table4 = new javax.swing.JTable();
        addproduct = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt6 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt8 = new javax.swing.JTextField();
        add_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txt9 = new javax.swing.JTextField();
        stocks = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        sell = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        rec_no = new javax.swing.JTextField();
        sell_prc = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        desc = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        item_no = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        datein_btn = new javax.swing.JButton();
        date1 = new javax.swing.JTextField();
        capital_prc = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        qty1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        changes = new javax.swing.JTextField();
        pay_ct = new javax.swing.JTextField();
        process_btn = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        table5 = new javax.swing.JTable();
        add_btn2 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        qty2 = new javax.swing.JTextField();
        clear_txt = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        profit = new javax.swing.JTextField();
        search_bar1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        settings = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        users = new javax.swing.JTable();
        add_btn1 = new javax.swing.JButton();
        update_btn1 = new javax.swing.JButton();
        delete_btn1 = new javax.swing.JButton();
        password3 = new javax.swing.JPasswordField();
        user = new javax.swing.JTextField();
        daily = new javax.swing.JPanel();
        sums1 = new javax.swing.JTextField();
        sales1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        search_bar = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        sales_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        delete_btn2 = new javax.swing.JButton();
        password = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        timeLab = new javax.swing.JLabel();
        dateLab = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Header.setBackground(new java.awt.Color(0, 102, 204));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("KCG Office and School Supplies");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        jButton5.setText("Add New Product");
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        jButton7.setText("HOME");
        jButton7.setBorderPainted(false);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sell.png"))); // NOI18N
        jButton8.setText("SELL");
        jButton8.setBorderPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/stock.png"))); // NOI18N
        jButton9.setText("STOCKS");
        jButton9.setBorderPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/settings.png"))); // NOI18N
        jButton3.setText("SETTINGS");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Layers.setBackground(new java.awt.Color(153, 153, 153));
        Layers.setLayout(new java.awt.CardLayout());

        home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        table4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        table4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product", "Date", "Selling Price", "Total Stocks", "Remaining Stocks", "Capital Price", "Profit", "Sale Amount", "Payment", "Change"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table4.setGridColor(new java.awt.Color(255, 255, 255));
        table4.setRowHeight(25);
        table4.setSelectionBackground(new java.awt.Color(234, 74, 200));
        table4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table4.getTableHeader().setResizingAllowed(false);
        table4.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(table4);

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1438, Short.MAX_VALUE)
                .addContainerGap())
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                .addContainerGap())
        );

        Layers.add(home, "card2");

        addproduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setBackground(new java.awt.Color(51, 102, 255));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setText("Receving Date");

        txt2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt2ActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(51, 102, 255));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setText("Item No.");

        txt3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt3ActionPerformed(evt);
            }
        });
        txt3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt3KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3KeyTyped(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(51, 102, 255));
        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel9.setText("Product");

        txt4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt4ActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(51, 102, 255));
        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel11.setText("Quantity");

        txt6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt6ActionPerformed(evt);
            }
        });
        txt6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt6KeyTyped(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(51, 102, 255));
        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel13.setText("Selling Price");

        txt8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt8ActionPerformed(evt);
            }
        });
        txt8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt8KeyTyped(evt);
            }
        });

        add_btn.setBackground(new java.awt.Color(255, 255, 255));
        add_btn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        add_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        add_btn.setText("ADD");
        add_btn.setBorderPainted(false);
        add_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        delete_btn.setBackground(new java.awt.Color(255, 0, 0));
        delete_btn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        delete_btn.setForeground(new java.awt.Color(255, 255, 255));
        delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cross.png"))); // NOI18N
        delete_btn.setText("DELETE");
        delete_btn.setBorderPainted(false);
        delete_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        update_btn.setBackground(new java.awt.Color(255, 153, 0));
        update_btn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        update_btn.setForeground(new java.awt.Color(255, 255, 255));
        update_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        update_btn.setText("UPDATE");
        update_btn.setBorderPainted(false);
        update_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        table2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Receve No", "Receive Date", "Item No", "Product", "Quantity", "Capital Price", "Sell Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table2.setRowHeight(25);
        table2.getTableHeader().setResizingAllowed(false);
        table2.getTableHeader().setReorderingAllowed(false);
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(0).setResizable(false);
            table2.getColumnModel().getColumn(1).setResizable(false);
            table2.getColumnModel().getColumn(2).setResizable(false);
            table2.getColumnModel().getColumn(3).setResizable(false);
            table2.getColumnModel().getColumn(4).setResizable(false);
            table2.getColumnModel().getColumn(5).setResizable(false);
            table2.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel14.setBackground(new java.awt.Color(51, 102, 255));
        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel14.setText("Capital Price");

        txt9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txt9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt9ActionPerformed(evt);
            }
        });
        txt9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt9KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout addproductLayout = new javax.swing.GroupLayout(addproduct);
        addproduct.setLayout(addproductLayout);
        addproductLayout.setHorizontalGroup(
            addproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addproductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addproductLayout.createSequentialGroup()
                        .addGroup(addproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(addproductLayout.createSequentialGroup()
                                .addGroup(addproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addComponent(update_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delete_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(addproductLayout.createSequentialGroup()
                                .addGroup(addproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(4, 4, 4)
                                .addGroup(addproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(1092, Short.MAX_VALUE))
                    .addGroup(addproductLayout.createSequentialGroup()
                        .addGroup(addproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(addproductLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt9, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addproductLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(66, 66, 66)
                                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1087, Short.MAX_VALUE))))
        );
        addproductLayout.setVerticalGroup(
            addproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addproductLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(addproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(addproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(add_btn)
                .addGap(18, 18, 18)
                .addComponent(update_btn)
                .addGap(18, 18, 18)
                .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        Layers.add(addproduct, "card3");

        stocks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel18.setText("STOCKS");

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel19.setText("SEARCH");

        jTextField12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(255, 0, 0));
        jButton15.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cross.png"))); // NOI18N
        jButton15.setText("Delete Product");
        jButton15.setBorderPainted(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        table3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Receve No", "Receive Date", "Item No", "Description", "Quantity", "Capital Price", "Sell Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table3.setRowHeight(25);
        table3.getTableHeader().setResizingAllowed(false);
        table3.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table3);
        if (table3.getColumnModel().getColumnCount() > 0) {
            table3.getColumnModel().getColumn(0).setResizable(false);
            table3.getColumnModel().getColumn(1).setResizable(false);
            table3.getColumnModel().getColumn(2).setResizable(false);
            table3.getColumnModel().getColumn(3).setResizable(false);
            table3.getColumnModel().getColumn(4).setResizable(false);
            table3.getColumnModel().getColumn(5).setResizable(false);
            table3.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout stocksLayout = new javax.swing.GroupLayout(stocks);
        stocks.setLayout(stocksLayout);
        stocksLayout.setHorizontalGroup(
            stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1458, Short.MAX_VALUE)
            .addGroup(stocksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stocksLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1068, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stocksLayout.createSequentialGroup()
                        .addComponent(jButton15)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        stocksLayout.setVerticalGroup(
            stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stocksLayout.createSequentialGroup()
                .addGroup(stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stocksLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)))
                    .addGroup(stocksLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton15)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        Layers.add(stocks, "card4");

        sell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel20.setText("Item Order Menu");

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel21.setText("Item Details");

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel22.setText("Receive Number");

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel23.setText("SELL PRICE");

        rec_no.setEditable(false);
        rec_no.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rec_no.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rec_no.setText("0");

        sell_prc.setEditable(false);
        sell_prc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sell_prc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sell_prc.setText("0.00");

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel25.setText("PRODUCT");

        desc.setEditable(false);
        desc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        desc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel28.setText("QUANTITY");

        qty.setEditable(false);
        qty.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        qty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qty.setText("0");

        item_no.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        item_no.setText("NO.");

        date.setBackground(new java.awt.Color(51, 255, 102));
        date.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dateKeyTyped(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel31.setText("Receive Date");

        datein_btn.setText("DATE IN");
        datein_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datein_btnActionPerformed(evt);
            }
        });

        date1.setEditable(false);
        date1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        date1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        date1.setText("0000-00-00");

        capital_prc.setEditable(false);
        capital_prc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        capital_prc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        capital_prc.setText("0.00");

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel24.setText("Capital Price");

        qty1.setBackground(new java.awt.Color(51, 255, 102));
        qty1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        qty1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qty1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qty1KeyTyped(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel29.setText("ITEMS");

        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel27.setText("ITEM NO.");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rec_no, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28)
                                .addComponent(sell_prc, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(desc))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29))
                    .addComponent(qty1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(item_no)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel27)
                        .addGap(30, 30, 30)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(capital_prc, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(datein_btn)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel31)
                    .addContainerGap(260, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rec_no, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell_prc, javax.swing.GroupLayout.Alignment.LEADING))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(datein_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(18, 18, 18)
                                .addComponent(qty1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(capital_prc)
                                .addContainerGap())
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(item_no)
                                .addGap(28, 28, 28))))))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(jLabel31)
                    .addContainerGap(155, Short.MAX_VALUE)))
        );

        jLabel32.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel32.setText("AMOUNT OF CHANGE");

        changes.setEditable(false);
        changes.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        changes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        changes.setText("0.00");
        changes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        changes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changesActionPerformed(evt);
            }
        });

        pay_ct.setBackground(new java.awt.Color(51, 255, 102));
        pay_ct.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        pay_ct.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pay_ct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pay_ct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_ctActionPerformed(evt);
            }
        });
        pay_ct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pay_ctKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pay_ctKeyTyped(evt);
            }
        });

        process_btn.setBackground(new java.awt.Color(255, 255, 255));
        process_btn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        process_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        process_btn.setText("PROCESS");
        process_btn.setBorderPainted(false);
        process_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                process_btnActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel35.setText("CUSTOMER'S MONEY");

        table5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Receve No", "Receive Date", "Item No", "Product", "Quantity", "Capital Price", "Sell Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table5.setRowHeight(25);
        table5.setRowMargin(5);
        table5.getTableHeader().setResizingAllowed(false);
        table5.getTableHeader().setReorderingAllowed(false);
        table5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table5MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(table5);
        if (table5.getColumnModel().getColumnCount() > 0) {
            table5.getColumnModel().getColumn(0).setResizable(false);
            table5.getColumnModel().getColumn(1).setResizable(false);
            table5.getColumnModel().getColumn(2).setResizable(false);
            table5.getColumnModel().getColumn(3).setResizable(false);
            table5.getColumnModel().getColumn(4).setResizable(false);
            table5.getColumnModel().getColumn(5).setResizable(false);
            table5.getColumnModel().getColumn(6).setResizable(false);
        }

        add_btn2.setBackground(new java.awt.Color(255, 255, 255));
        add_btn2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        add_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        add_btn2.setText("ADD");
        add_btn2.setBorderPainted(false);
        add_btn2.setEnabled(false);
        add_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btn2ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel36.setText("TOTAL PRICE");

        amount.setEditable(false);
        amount.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amount.setText("0.00");

        jLabel30.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel30.setText("QUANTITY BALANCE");

        qty2.setEditable(false);
        qty2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        qty2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qty2.setText("0");

        clear_txt.setBackground(new java.awt.Color(255, 0, 0));
        clear_txt.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        clear_txt.setForeground(new java.awt.Color(255, 255, 255));
        clear_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cross.png"))); // NOI18N
        clear_txt.setText("CLEAR");
        clear_txt.setBorderPainted(false);
        clear_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_txtActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel37.setText("PROFIT");

        profit.setEditable(false);
        profit.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        profit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        profit.setText("0.00");

        search_bar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        search_bar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_bar1ActionPerformed(evt);
            }
        });
        search_bar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_bar1KeyReleased(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N

        javax.swing.GroupLayout sellLayout = new javax.swing.GroupLayout(sell);
        sell.setLayout(sellLayout);
        sellLayout.setHorizontalGroup(
            sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sellLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sellLayout.createSequentialGroup()
                        .addGroup(sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(process_btn)
                            .addComponent(pay_ct, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(sellLayout.createSequentialGroup()
                                .addComponent(add_btn2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clear_txt))
                            .addGroup(sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(changes, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(18, 18, 18)
                        .addGroup(sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sellLayout.createSequentialGroup()
                                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(sellLayout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(profit, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sellLayout.createSequentialGroup()
                                                .addComponent(jLabel37)
                                                .addGap(37, 37, 37)))
                                        .addComponent(qty2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(16, 16, 16)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sellLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(33, 33, 33))))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(sellLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(906, 906, 906)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_bar1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );
        sellLayout.setVerticalGroup(
            sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sellLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(search_bar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sellLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sellLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sellLayout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pay_ct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(process_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(add_btn2)
                                    .addComponent(clear_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changes)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(sellLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qty2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel37)
                        .addGap(18, 18, 18)
                        .addComponent(profit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        Layers.add(sell, "card5");

        settings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        users.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        users.setSurrendersFocusOnKeystroke(true);
        users.getTableHeader().setResizingAllowed(false);
        users.getTableHeader().setReorderingAllowed(false);
        users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(users);
        if (users.getColumnModel().getColumnCount() > 0) {
            users.getColumnModel().getColumn(0).setResizable(false);
            users.getColumnModel().getColumn(1).setResizable(false);
            users.getColumnModel().getColumn(2).setResizable(false);
        }

        add_btn1.setBackground(new java.awt.Color(255, 255, 255));
        add_btn1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        add_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        add_btn1.setText("ADD");
        add_btn1.setBorderPainted(false);
        add_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btn1ActionPerformed(evt);
            }
        });

        update_btn1.setBackground(new java.awt.Color(255, 153, 0));
        update_btn1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        update_btn1.setForeground(new java.awt.Color(255, 255, 255));
        update_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        update_btn1.setText("UPDATE");
        update_btn1.setBorderPainted(false);
        update_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btn1ActionPerformed(evt);
            }
        });

        delete_btn1.setBackground(new java.awt.Color(255, 0, 0));
        delete_btn1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        delete_btn1.setForeground(new java.awt.Color(255, 255, 255));
        delete_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cross.png"))); // NOI18N
        delete_btn1.setText("DELETE");
        delete_btn1.setBorderPainted(false);
        delete_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btn1ActionPerformed(evt);
            }
        });

        password3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        password3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 10), new java.awt.Color(102, 102, 102))); // NOI18N
        password3.setSelectionColor(new java.awt.Color(224, 54, 255));
        password3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                password3KeyPressed(evt);
            }
        });

        user.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        user.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 10), new java.awt.Color(104, 104, 104))); // NOI18N
        user.setSelectionColor(new java.awt.Color(224, 54, 255));
        user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout settingsLayout = new javax.swing.GroupLayout(settings);
        settings.setLayout(settingsLayout);
        settingsLayout.setHorizontalGroup(
            settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(password3, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(user)
                    .addGroup(settingsLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(update_btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add_btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delete_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(950, Short.MAX_VALUE))
        );
        settingsLayout.setVerticalGroup(
            settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(settingsLayout.createSequentialGroup()
                        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(password3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(add_btn1)
                        .addGap(18, 18, 18)
                        .addComponent(update_btn1)
                        .addGap(18, 18, 18)
                        .addComponent(delete_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(359, Short.MAX_VALUE))
        );

        Layers.add(settings, "card7");

        daily.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sums1.setEditable(false);
        sums1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sums1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        sales1.setEditable(false);
        sales1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sales1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel26.setText("SALES AND PROFIT");

        search_bar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        search_bar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_barActionPerformed(evt);
            }
        });
        search_bar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_barKeyReleased(evt);
            }
        });

        jScrollPane10.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane10.setColumnHeaderView(null);

        sales_table.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        sales_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Date", "Price", "Total Quantity", "Remaining quantity", "Capital Price", "Profit", "Amount", "Payment", "Changes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sales_table.setGridColor(new java.awt.Color(255, 255, 255));
        sales_table.setRowHeight(25);
        sales_table.setSelectionBackground(new java.awt.Color(234, 74, 200));
        sales_table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        sales_table.getTableHeader().setResizingAllowed(false);
        sales_table.getTableHeader().setReorderingAllowed(false);
        sales_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sales_tableMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(sales_table);

        jLabel1.setText("SEARCH");

        jLabel3.setText("TOTAL PROFIT");

        jLabel4.setText("TOTAL SALES");

        delete_btn2.setBackground(new java.awt.Color(255, 0, 0));
        delete_btn2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        delete_btn2.setForeground(new java.awt.Color(255, 255, 255));
        delete_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cross.png"))); // NOI18N
        delete_btn2.setText("DELETE");
        delete_btn2.setBorderPainted(false);
        delete_btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btn2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("INSERT YOUR PASSWORD TO CONFIRM.");

        javax.swing.GroupLayout dailyLayout = new javax.swing.GroupLayout(daily);
        daily.setLayout(dailyLayout);
        dailyLayout.setHorizontalGroup(
            dailyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dailyLayout.createSequentialGroup()
                .addGroup(dailyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dailyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 1438, Short.MAX_VALUE))
                    .addGroup(dailyLayout.createSequentialGroup()
                        .addGroup(dailyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dailyLayout.createSequentialGroup()
                                .addGap(626, 626, 626)
                                .addComponent(jLabel26))
                            .addGroup(dailyLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(dailyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(dailyLayout.createSequentialGroup()
                                        .addGroup(dailyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1))
                                        .addGap(56, 56, 56)
                                        .addGroup(dailyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(sales1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                            .addComponent(sums1)
                                            .addComponent(search_bar)))
                                    .addComponent(jLabel4))
                                .addGap(56, 56, 56)
                                .addGroup(dailyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(dailyLayout.createSequentialGroup()
                                        .addComponent(delete_btn2)
                                        .addGap(18, 18, 18)
                                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dailyLayout.setVerticalGroup(
            dailyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dailyLayout.createSequentialGroup()
                .addGroup(dailyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dailyLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(dailyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sums1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dailyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sales1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dailyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dailyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)))
                .addGroup(dailyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 59, Short.MAX_VALUE))
        );

        Layers.add(daily, "card8");

        Logout.setBackground(new java.awt.Color(255, 0, 0));
        Logout.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cross.png"))); // NOI18N
        Logout.setText("LOGOUT");
        Logout.setBorderPainted(false);
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        timeLab.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        timeLab.setText("TIME");

        dateLab.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        dateLab.setText("DATE");

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report.png"))); // NOI18N
        jButton12.setText("SALES/PROFIT");
        jButton12.setBorderPainted(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeLab, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateLab, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Layers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Layers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)
                        .addGap(55, 55, 55)
                        .addComponent(jButton3)
                        .addGap(40, 40, 40)
                        .addComponent(dateLab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeLab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Logout)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Layers.removeAll();
       Layers.repaint();
       Layers.revalidate();
       Layers.add(addproduct);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Layers.removeAll();
       Layers.repaint();
       Layers.revalidate();
       Layers.add(sell);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Layers.removeAll();
       Layers.repaint();
       Layers.revalidate();
       Layers.add(stocks);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Layers.removeAll();
       Layers.repaint();
       Layers.revalidate();
       Layers.add(home);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void mouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseclicked
       
    }//GEN-LAST:event_mouseclicked

    private void txt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt2ActionPerformed

    private void txt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt3ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt3ActionPerformed

    private void txt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt4ActionPerformed

    private void txt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt6ActionPerformed

    private void txt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt8ActionPerformed

    private void changesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changesActionPerformed

    private void pay_ctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_ctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pay_ctActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        // TODO add your handling code here:
        double change1 = Double.parseDouble(txt9.getText());
        double change2 = Double.parseDouble(txt8.getText());
        if (change2 < change1) {
            JOptionPane.showMessageDialog(rootPane, "SELLING PRICE should be higher than the CAPTIAL PRICE", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
        try {
            r.Connect();
            r.qry = (PreparedStatement) r.con.prepareStatement("insert into stocks_table (receive_date,item_no,name,quantity,capital_prc,sell_prc) values (?, ?, ?, ?, ?, ?)");
            r.qry.setString(1, txt2.getText());
            r.qry.setString(2, txt3.getText());
            r.qry.setString(3, txt4.getText());
            r.qry.setString(4, txt6.getText());
            r.qry.setString(5, txt9.getText());
            r.qry.setString(6, txt8.getText());
            r.qry.execute();
            r.Disconnect();
            LoadData();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
        }
    }//GEN-LAST:event_add_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        // TODO add your handling code here:
        if (table2.getSelectedRowCount() > 0) {
            try {
                r.Connect();
                r.qry = (PreparedStatement) r.con.prepareStatement("DELETE FROM stocks_table WHERE receive_no=" + table2.getValueAt(table2.getSelectedRow(), 0));
                r.qry.execute();
                r.Disconnect();
                LoadData();
                JOptionPane.showMessageDialog(rootPane, "Deleted!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }  else {
                    JOptionPane.showMessageDialog(rootPane, "No Item Selected!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        // TODO add your handling code here:
        double change1 = Double.parseDouble(txt9.getText());
        double change2 = Double.parseDouble(txt8.getText());
        if (change2 < change1) {
            JOptionPane.showMessageDialog(rootPane, "SELLING PRICE should be higher than the CAPTIAL PRICE", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
        if (table2.getSelectedRowCount() > 0) {
            try {
                r.Connect();
                r.qry = (PreparedStatement) r.con.prepareStatement("UPDATE stocks_table SET receive_date=?,item_no=?,name=?,quantity=?,capital_prc=?,sell_prc=? WHERE receive_no=" + table2.getValueAt(table2.getSelectedRow(), 0));
                r.qry.setString(1, txt2.getText());
                r.qry.setString(2, txt3.getText());
                r.qry.setString(3, txt4.getText());
                r.qry.setString(4, txt6.getText());
                r.qry.setString(5, txt9.getText());
                r.qry.setString(6, txt8.getText());
                r.qry.execute();
                r.Disconnect();
                LoadData();
                JOptionPane.showMessageDialog(rootPane, "Update Succes!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }  else {
                    JOptionPane.showMessageDialog(rootPane, "No Item Selected!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
        }
    }//GEN-LAST:event_update_btnActionPerformed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            if (table2.getSelectedRow() >= 0) {
                txt2.setText(String.valueOf(table2.getValueAt(table2.getSelectedRow(), 1)));
                txt3.setText(String.valueOf(table2.getValueAt(table2.getSelectedRow(), 2)));
                txt4.setText(String.valueOf(table2.getValueAt(table2.getSelectedRow(), 3)));
                txt6.setText(String.valueOf(table2.getValueAt(table2.getSelectedRow(), 4)));
                txt9.setText(String.valueOf(table2.getValueAt(table2.getSelectedRow(), 5)));
                txt8.setText(String.valueOf(table2.getValueAt(table2.getSelectedRow(), 6)));
            }
        }
    }//GEN-LAST:event_table2MouseClicked

    private void txt3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt3KeyPressed

    private void txt3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLetter(c)&&!evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_txt3KeyTyped

    private void txt6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt6KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLetter(c)&&!evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_txt6KeyTyped

    private void txt8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt8KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLetter(c)&&!evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_txt8KeyTyped

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to DELETE this item?", "Delete",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
        if (table3.getSelectedRowCount() > 0) {
            try {
                r.Connect();
                r.qry = (PreparedStatement) r.con.prepareStatement("DELETE FROM stocks_table WHERE receive_no=" + table3.getValueAt(table3.getSelectedRow(), 0));
                r.qry.execute();
                r.Disconnect();
                LoadData();
                JOptionPane.showMessageDialog(rootPane, "Deleted!!", "Success!"+ "", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }  else {
                    JOptionPane.showMessageDialog(rootPane, "No Item Selected!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Layers.removeAll();
       Layers.repaint();
       Layers.revalidate();
       Layers.add(settings);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to logout?", "Exit",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            new login1().show();
            this.hide();
        }
    }//GEN-LAST:event_LogoutActionPerformed

    private void table5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table5MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            if (table5.getSelectedRow() >= 0) {
                rec_no.setText(String.valueOf(table5.getValueAt(table5.getSelectedRow(), 0)));
                date1.setText(String.valueOf(table5.getValueAt(table5.getSelectedRow(), 1)));
                item_no.setText(String.valueOf(table5.getValueAt(table5.getSelectedRow(), 2)));
                desc.setText(String.valueOf(table5.getValueAt(table5.getSelectedRow(), 3)));
                qty.setText(String.valueOf(table5.getValueAt(table5.getSelectedRow(), 4)));
                capital_prc.setText(String.valueOf(table5.getValueAt(table5.getSelectedRow(), 5)));
                sell_prc.setText(String.valueOf(table5.getValueAt(table5.getSelectedRow(), 6)));
            }
        }
    }//GEN-LAST:event_table5MouseClicked

    private void process_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_process_btnActionPerformed
        // TODO add your handling code here:
        
        
        int first = Integer.parseInt(qty.getText());
        int first1 = Integer.parseInt(qty1.getText());
        int minus1 = first - first1;
        
            double second = Double.parseDouble(sell_prc.getText());
            double third = Double.parseDouble(pay_ct.getText());
            double semi = first1 * second;
            double Final = third - semi;
            
            DecimalFormat dc = new DecimalFormat("0.00");
            String _Frl = dc.format(semi);
            String _Final = dc.format(Final);
            
            
            qty2.setText(String.valueOf(minus1));
            amount.setText(_Frl);
            changes.setText(_Final);
            
            double profit3 = Double.parseDouble(amount.getText());
            double profit4 = Double.parseDouble(capital_prc.getText());
            
            double profit1 = first1 * profit4;
            
            double profit2 = profit3 - profit1;
            String profitFinal = dc.format(profit2);
            
            profit.setText(profitFinal);
            
            int quantity = Integer.parseInt(qty2.getText());
        double change1 = Double.parseDouble(changes.getText());
        add_btn2.setEnabled(true);
        
        if (quantity <0 || change1 < 0 || table5.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(rootPane, "PAYMENT might be low or the available STOCKS might be LOW.", "Error!", JOptionPane.ERROR_MESSAGE);
            add_btn2.setEnabled(false);
        }
        
    }//GEN-LAST:event_process_btnActionPerformed

    private void add_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btn2ActionPerformed
        // TODO add your handling code here:
        int quantity = Integer.parseInt(qty2.getText());
        double change1 = Double.parseDouble(changes.getText());
        double ct_money = Double.parseDouble(pay_ct.getText());
        
        if (quantity <0 || change1 < 0 || ct_money < 0) {
            JOptionPane.showMessageDialog(rootPane, "The Payment might be low or the available stocks are low.", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
        
        int a = Integer.parseInt(qty2.getText());
        if (a == 0) {
            if (table5.getSelectedRowCount() > 0) {
                try {
                    r.Connect();
                    r.qry = (PreparedStatement) r.con.prepareStatement("DELETE FROM stocks_table WHERE receive_no=" + table5.getValueAt(table5.getSelectedRow(), 0));
                    r.qry.execute();
                    r.Disconnect();
                    LoadData();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "REASON:" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
                } 
            }
        }
        //HISTORY
        try {
            
            JOptionPane.showMessageDialog(rootPane, "Item Processed","ADDED", JOptionPane.INFORMATION_MESSAGE);
            add_btn2.setEnabled(false);
            
            r.Connect();
            r.qry = (PreparedStatement) r.con.prepareStatement("insert into history (Name,Date,Price,Total_quantity,Remain_quantity,capital_prc,profit,Amount,Payment,Changes) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            r.qry.setString(1, desc.getText());
            r.qry.setString(2, date.getText());
            r.qry.setString(3, sell_prc.getText());
            r.qry.setString(4, qty1.getText());
            r.qry.setString(5, qty2.getText());
            r.qry.setString(6, capital_prc.getText());
            r.qry.setString(7, profit.getText());
            r.qry.setString(8, amount.getText());
            r.qry.setString(9, pay_ct.getText());
            r.qry.setString(10, changes.getText());
            r.qry.execute();
            r.Disconnect();
            LoadData1();
        } catch (SQLException t) {
            JOptionPane.showMessageDialog(rootPane, "REASON:" + t, "ERROR", JOptionPane.ERROR_MESSAGE);
            
        }
        
        try {
            
            
            r.Connect();
            r.qry = (PreparedStatement) r.con.prepareStatement("insert into daily (Name,Date,Price,Total_quantity,Remain_quantity,capital_prc,profit,Amount,Payment,Changes) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            r.qry.setString(1, desc.getText());
            r.qry.setString(2, date.getText());
            r.qry.setString(3, sell_prc.getText());
            r.qry.setString(4, qty1.getText());
            r.qry.setString(5, qty2.getText());
            r.qry.setString(6, capital_prc.getText());
            r.qry.setString(7, profit.getText());
            r.qry.setString(8, amount.getText());
            r.qry.setString(9, pay_ct.getText());
            r.qry.setString(10, changes.getText());
            r.qry.execute();
            r.Disconnect();
            sales();
        } catch (SQLException t) {
            JOptionPane.showMessageDialog(rootPane, "REASON:" + t, "ERROR", JOptionPane.ERROR_MESSAGE);
            
        }
        
        
        if (table5.getSelectedRowCount() > 0) {
            try {
                r.Connect();
                r.qry = (PreparedStatement) r.con.prepareStatement("UPDATE stocks_table SET receive_date=?,item_no=?,name=?,quantity=?,capital_prc=?,sell_prc=? WHERE receive_no=" + table5.getValueAt(table5.getSelectedRow(), 0));
                r.qry.setString(1, date1.getText());
                r.qry.setString(2, item_no.getText());
                r.qry.setString(3, desc.getText());
                r.qry.setString(4, qty2.getText());
                r.qry.setString(5, capital_prc.getText());
                r.qry.setString(6, sell_prc.getText());
                r.qry.execute();
                r.Disconnect();
                LoadData();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "REASON:" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }    
        }
    }//GEN-LAST:event_add_btn2ActionPerformed

    private void datein_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datein_btnActionPerformed
        // TODO add your handling code here:
        date.setText(dateLab.getText());
    }//GEN-LAST:event_datein_btnActionPerformed

    private void clear_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_txtActionPerformed
        // TODO add your handling code here:
        rec_no.setText("0");
        date1.setText("0000-00-00");
        item_no.setText("NO.");
        desc.setText("");
        qty.setText("0");
        sell_prc.setText("0.00");
        date.setText("");
        qty1.setText("");
        pay_ct.setText("");
        changes.setText("0.00");
        amount.setText("0.00");
        qty2.setText("0");
        profit.setText("0.00");
    }//GEN-LAST:event_clear_txtActionPerformed

    private void txt9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt9ActionPerformed

    private void txt9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt9KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt9KeyTyped

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        Layers.removeAll();
        Layers.repaint();
        Layers.revalidate();
        Layers.add(daily);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void search_barKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_barKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)sales_table.getModel();
        String search = search_bar.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        sales_table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
        
        //PROFIT SUM
        double sum = 0;
        for(int i = 0; i < sales_table.getRowCount(); i++)
        {
            
            sum = sum + Double.parseDouble(sales_table.getValueAt(i, 7).toString());
            
        }
        DecimalFormat dc = new DecimalFormat("0.00");
            String deci = dc.format(sum);
        sums1.setText(deci);
        
        //TOTAL SALES
        double sum1 = 0;
        for(int i = 0; i < sales_table.getRowCount(); i++)
        {
            sum1 = sum1 + Double.parseDouble(sales_table.getValueAt(i, 8).toString());
        }
        DecimalFormat cd = new DecimalFormat("0.00");
            String decim = cd.format(sum1);
        sales1.setText(decim);
    }//GEN-LAST:event_search_barKeyReleased

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void sales_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sales_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sales_tableMouseClicked

    private void search_barActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_barActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_barActionPerformed

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        // TODO add your handling code here:DefaultTableModel table = (DefaultTableModel)sales_table.getModel();
        DefaultTableModel table = (DefaultTableModel)table3.getModel();
        String search = jTextField12.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        table3.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextField12KeyReleased

    private void search_bar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_bar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_bar1ActionPerformed

    private void search_bar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_bar1KeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)table5.getModel();
        String search = search_bar1.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        table5.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_search_bar1KeyReleased

    private void delete_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btn2ActionPerformed
        // TODO add your handling code here:
        
        
        try {
            r.Connect();
            r.qry= (PreparedStatement) r.con.prepareStatement("SELECT * FROM login WHERE pass=?");
            r.qry.setString(1, password.getText());
            r.rs=r.qry.executeQuery();
            if (r.rs.next()) {
               
                if (sales_table.getSelectedRowCount() > 0) {
            try {
                r.Connect();
                r.qry = (PreparedStatement) r.con.prepareStatement("DELETE FROM daily WHERE ID=" + sales_table.getValueAt(sales_table.getSelectedRow(), 0));
                r.qry.execute();
                r.Disconnect();
                sales();
                JOptionPane.showMessageDialog(rootPane, "Deleted!", "Information", JOptionPane.INFORMATION_MESSAGE);
                password.setText("");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }  else {
                    JOptionPane.showMessageDialog(rootPane, "No Item Selected!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Your Password was incorrect or invalid.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            r.Disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_delete_btn2ActionPerformed

    private void pay_ctKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pay_ctKeyReleased
        // TODO add your handling code here:
        add_btn2.setEnabled(false);
    }//GEN-LAST:event_pay_ctKeyReleased

    private void qty1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty1KeyReleased
        // TODO add your handling code here:
        add_btn2.setEnabled(false);
    }//GEN-LAST:event_qty1KeyReleased

    private void dateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateKeyReleased
        // TODO add your handling code here:
        add_btn2.setEnabled(false);
    }//GEN-LAST:event_dateKeyReleased

    private void dateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLetter(c)&&!evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_dateKeyTyped

    private void qty1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty1KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLetter(c)&&!evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_qty1KeyTyped

    private void pay_ctKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pay_ctKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLetter(c)&&!evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_pay_ctKeyTyped

    private void add_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btn1ActionPerformed
        // TODO add your handling code here:
        try {
            r.Connect();
            r.qry = (PreparedStatement) r.con.prepareStatement("insert into login (name, pass) values (?, ?)");
            r.qry.setString(1, user.getText());
            r.qry.setString(2, password3.getText());
            r.qry.execute();
            r.Disconnect();
            accounts();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_add_btn1ActionPerformed

    private void update_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btn1ActionPerformed
        // TODO add your handling code here:
        if (users.getSelectedRowCount() > 0) {
            try {
                r.Connect();
                r.qry = (PreparedStatement) r.con.prepareStatement("UPDATE login SET name=?,pass=? WHERE ID=" + users.getValueAt(users.getSelectedRow(), 0));
                r.qry.setString(1, user.getText());
                r.qry.setString(2, password3.getText());
                r.qry.execute();
                r.Disconnect();
                accounts();
                JOptionPane.showMessageDialog(rootPane, "Update Succes!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }  else {
                    JOptionPane.showMessageDialog(rootPane, "No Item Selected!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
    }//GEN-LAST:event_update_btn1ActionPerformed

    private void delete_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btn1ActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to DELETE this item?", "Delete",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            if (users.getSelectedRowCount() > 0) {
            try {
                r.Connect();
                r.qry = (PreparedStatement) r.con.prepareStatement("DELETE FROM login WHERE ID=" + users.getValueAt(users.getSelectedRow(), 0));
                r.qry.execute();
                r.Disconnect();
                accounts();
                JOptionPane.showMessageDialog(rootPane, "Deleted!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }  else {
                    JOptionPane.showMessageDialog(rootPane, "No Item Selected!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
        }
    }//GEN-LAST:event_delete_btn1ActionPerformed

    private void password3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_password3KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                r.Connect();
                r.qry= (PreparedStatement) r.con.prepareStatement("SELECT * FROM login WHERE name=? and pass=?");
                r.qry.setString(1, user.getText());
                r.qry.setString(2, password.getText());
                r.rs=r.qry.executeQuery();
                if (r.rs.next()) {
                    JOptionPane.showMessageDialog(rootPane, "WELCOME!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                    new Panel().show();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "The username/password was incorrect or invalid.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                r.Disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_password3KeyPressed

    private void userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                r.Connect();
                r.qry= (PreparedStatement) r.con.prepareStatement("SELECT * FROM login WHERE name=? and pass=?");
                r.qry.setString(1, user.getText());
                r.qry.setString(2, password.getText());
                r.rs=r.qry.executeQuery();
                if (r.rs.next()) {
                    JOptionPane.showMessageDialog(rootPane, "WELCOME!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                    new Panel().show();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "The username/password was incorrect or invalid.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                r.Disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_userKeyPressed

    private void usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            if (users.getSelectedRow() >= 0) {
                user.setText(String.valueOf(users.getValueAt(users.getSelectedRow(), 1)));
                password3.setText(String.valueOf(users.getValueAt(users.getSelectedRow(), 2)));
            }
        }
    }//GEN-LAST:event_usersMouseClicked

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
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Layers;
    private javax.swing.JButton Logout;
    private javax.swing.JButton add_btn;
    private javax.swing.JButton add_btn1;
    private javax.swing.JButton add_btn2;
    private javax.swing.JPanel addproduct;
    private javax.swing.JTextField amount;
    private javax.swing.JTextField capital_prc;
    private javax.swing.JTextField changes;
    private javax.swing.JButton clear_txt;
    private javax.swing.JPanel daily;
    private javax.swing.JTextField date;
    private javax.swing.JTextField date1;
    private javax.swing.JLabel dateLab;
    private javax.swing.JButton datein_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton delete_btn1;
    private javax.swing.JButton delete_btn2;
    private javax.swing.JTextField desc;
    private javax.swing.JPanel home;
    private javax.swing.JLabel item_no;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField password;
    private javax.swing.JPasswordField password1;
    private javax.swing.JPasswordField password2;
    private javax.swing.JPasswordField password3;
    private javax.swing.JTextField pay_ct;
    private javax.swing.JButton process_btn;
    private javax.swing.JTextField profit;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField qty1;
    private javax.swing.JTextField qty2;
    private javax.swing.JTextField rec_no;
    private javax.swing.JTextField sales1;
    private javax.swing.JTable sales_table;
    private javax.swing.JTextField search_bar;
    private javax.swing.JTextField search_bar1;
    private javax.swing.JPanel sell;
    private javax.swing.JTextField sell_prc;
    private javax.swing.JPanel settings;
    private javax.swing.JPanel stocks;
    private javax.swing.JTextField sums1;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    private javax.swing.JTable table4;
    private javax.swing.JTable table5;
    private javax.swing.JLabel timeLab;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextField txt8;
    private javax.swing.JTextField txt9;
    private javax.swing.JButton update_btn;
    private javax.swing.JButton update_btn1;
    private javax.swing.JTextField user;
    private javax.swing.JTable users;
    // End of variables declaration//GEN-END:variables
}
