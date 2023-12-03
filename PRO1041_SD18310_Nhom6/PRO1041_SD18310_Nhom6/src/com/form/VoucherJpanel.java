/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.form;

import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.model.Voucher;
import com.repository.UserVoucherResponsitory;
import com.service.imple.UserImple;
import com.service.imple.VoucherImple;

/**
 *
 * @author lenovo
 */
public class VoucherJpanel extends javax.swing.JPanel {

    private VoucherImple voucherImple = new VoucherImple();
    private int index = -1;
    private UserVoucherResponsitory userVoucherResponsitory = new UserVoucherResponsitory();
    private UserImple userImple = new UserImple();

    public VoucherJpanel() {
        initComponents();
        FormVoucherPanel.setVisible(false);
        FormVoucherUpdate.setVisible(false);
        fillTableVoucher();
        fillTableKhachHang();
    }

    public void fillTableVoucher() {
        DefaultTableModel tableModel = (DefaultTableModel) tblVoucher.getModel();
        tableModel.setRowCount(0);
        voucherImple.resetStatus();
        // vòng lặp viết nhanh
        voucherImple.getAll().forEach(i -> tableModel.addRow(new Object[]{
            i.getId(), i.getSaleOf(), i.getStartAt(), i.getEndAt(), i.getCreatedAt(), i.getUpdatedAt(), i.getStatus()
        }));
    }

    public void fillTableKhachHang() {
        DefaultTableModel tableModel = (DefaultTableModel) tblKhachHang.getModel();
        tableModel.setRowCount(0);
        // vòng lặp viết nhanh
        userImple.getCustomer().forEach(i -> tableModel.addRow(new Object[]{
            i.getId(), i.getFullName(), i.getNumberPhone(), i.getEmail()
        }));
    }

    public void fillTableKhachHang1() {
        DefaultTableModel tableModel = (DefaultTableModel) tblKhachHang1.getModel();
        tableModel.setRowCount(0);
        // vòng lặp viết nhanh
        userImple.getCustomer().forEach(i -> tableModel.addRow(new Object[]{
            i.getId(), i.getFullName(), i.getNumberPhone(), i.getEmail()
        }));
    }

    public void resetForm() {
        txtSaleOf.setText("");
        jXStartAt.setDate(null);
        jXEndAt.setDate(null);

        for (int i = 0; i < tblKhachHang.getRowCount(); i++) {
            tblKhachHang.setValueAt(false, i, tblKhachHang.getColumnCount() - 1);
        }

        tblVoucher.clearSelection();
        index = -1;
    }

    public boolean validateForm() {
        if (txtSaleOf.getText().trim().isEmpty() || jXStartAt.getDate() == null || jXEndAt.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Lỗi dữ liệu trống", "Lỗi", 2);
            return false;
        }
        Double saleOf = Double.valueOf(txtSaleOf.getText().trim());
        if (saleOf < 0) {
            JOptionPane.showMessageDialog(this, "Giảm giá không được âm", "Lỗi", 2);
            return false;
        }
        if (saleOf > 100) {
            JOptionPane.showMessageDialog(this, "Giảm giá chỉ nằm trong khoảng từ 0 - 100", "Lỗi", 2);
            return false;
        }
        Date startDate = jXStartAt.getDate();
        Date endDate = jXEndAt.getDate();

        if (startDate != null && endDate != null && startDate.compareTo(endDate) >= 0) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải nhỏ hơn ngày kết thúc!", "Lỗi ngày", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Double.valueOf(txtSaleOf.getText().trim());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Giảm giá phải là số", "Lỗi", 2);
            return false;
        }
        return true;
    }

    public boolean validateForm1() {
        if (txtSaleOf1.getText().trim().isEmpty() || jXStartAt1.getDate() == null || jXEndAt1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Lỗi dữ liệu sai", "Lỗi", 2);
            return false;
        }
        Double saleOf = Double.valueOf(txtSaleOf1.getText().trim());
        if (saleOf < 0) {
            JOptionPane.showMessageDialog(this, "Giảm giá không được âm", "Lỗi", 2);
            return false;
        }
        if (saleOf > 100) {
            JOptionPane.showMessageDialog(this, "Giảm giá chỉ nằm trong khoảng từ 0 - 100", "Lỗi", 2);
            return false;
        }
        Date startDate = jXStartAt1.getDate();
        Date endDate = jXEndAt1.getDate();

        if (startDate != null && endDate != null && startDate.compareTo(endDate) >= 0) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải nhỏ hơn ngày kết thúc!", "Lỗi ngày", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Double.valueOf(txtSaleOf1.getText().trim());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Giảm giá phải là số", "Lỗi", 2);
            return false;
        }
        return true;
    }

    private String generateRandomId() {
        // Số chữ số trong ID
        int numberOfDigits = 10;

        // Tạo một đối tượng Random
        Random random = new Random();

        // StringBuilder để xây dựng ID
        StringBuilder idBuilder = new StringBuilder();

        // Sinh ngẫu nhiên từ 0 đến 9 và thêm vào StringBuilder
        for (int i = 0; i < numberOfDigits; i++) {
            int digit = random.nextInt(10);
            idBuilder.append(digit);
        }

        // Chuyển StringBuilder thành chuỗi và trả về
        return idBuilder.toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TableVoucherPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVoucher = new javax.swing.JTable();
        btnCreateVoucher = new javax.swing.JButton();
        FormVoucherPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtSaleOf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jXStartAt = new org.jdesktop.swingx.JXDatePicker();
        jXEndAt = new org.jdesktop.swingx.JXDatePicker();
        btnCreate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        FormVoucherUpdate = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSaleOf1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jXStartAt1 = new org.jdesktop.swingx.JXDatePicker();
        jXEndAt1 = new org.jdesktop.swingx.JXDatePicker();
        btnUUpdate1 = new javax.swing.JButton();
        btnRemove1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKhachHang1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh sách voucher");
        jLabel1.setToolTipText("");
        jLabel1.setOpaque(true);

        tblVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Giảm giá", "Ngày bắt đầu", "Ngày kết thúc", "Ngày tạo", "Ngày cập nhật", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVoucher.setFocusTraversalPolicyProvider(true);
        tblVoucher.setInheritsPopupMenu(true);
        tblVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVoucherMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblVoucherMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblVoucher);

        btnCreateVoucher.setBackground(new java.awt.Color(51, 51, 51));
        btnCreateVoucher.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnCreateVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateVoucher.setText("Tạo voucher");
        btnCreateVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateVoucherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TableVoucherPanelLayout = new javax.swing.GroupLayout(TableVoucherPanel);
        TableVoucherPanel.setLayout(TableVoucherPanelLayout);
        TableVoucherPanelLayout.setHorizontalGroup(
            TableVoucherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TableVoucherPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCreateVoucher))
        );
        TableVoucherPanelLayout.setVerticalGroup(
            TableVoucherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TableVoucherPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnCreateVoucher)
                .addContainerGap())
        );

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Giảm giá: ");

        txtSaleOf.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtSaleOf.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("Thời gian bắt đầu: ");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setText("Thời gian kết thúc: ");

        btnCreate.setBackground(new java.awt.Color(51, 51, 51));
        btnCreate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("CREATE");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSaleOf)
                            .addComponent(jXStartAt, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jXEndAt, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaleOf, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jXStartAt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jXEndAt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TẠO VOUCHER");
        jLabel2.setToolTipText("");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jLabel2.setOpaque(true);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblKhachHang.setAutoCreateRowSorter(true);
        tblKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên khách hàng", "Số điện thoại", "Email", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblKhachHang);
        if (tblKhachHang.getColumnModel().getColumnCount() > 0) {
            tblKhachHang.getColumnModel().getColumn(0).setMinWidth(100);
            tblKhachHang.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblKhachHang.getColumnModel().getColumn(0).setMaxWidth(100);
            tblKhachHang.getColumnModel().getColumn(2).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(3).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(4).setMinWidth(70);
            tblKhachHang.getColumnModel().getColumn(4).setPreferredWidth(5);
            tblKhachHang.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Chọn khách hàng:");

        btnBack.setBackground(new java.awt.Color(51, 51, 51));
        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FormVoucherPanelLayout = new javax.swing.GroupLayout(FormVoucherPanel);
        FormVoucherPanel.setLayout(FormVoucherPanelLayout);
        FormVoucherPanelLayout.setHorizontalGroup(
            FormVoucherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FormVoucherPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FormVoucherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormVoucherPanelLayout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(296, 296, 296))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FormVoucherPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(FormVoucherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormVoucherPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 350, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)))
        );
        FormVoucherPanelLayout.setVerticalGroup(
            FormVoucherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FormVoucherPanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormVoucherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FormVoucherPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBack)))
                .addContainerGap(318, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel8.setText("Giảm giá: ");

        txtSaleOf1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtSaleOf1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setText("Thời gian bắt đầu: ");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel11.setText("Thời gian kết thúc: ");

        btnUUpdate1.setBackground(new java.awt.Color(51, 51, 51));
        btnUUpdate1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnUUpdate1.setForeground(new java.awt.Color(255, 255, 255));
        btnUUpdate1.setText("UPDATE");
        btnUUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUUpdate1ActionPerformed(evt);
            }
        });

        btnRemove1.setBackground(new java.awt.Color(51, 51, 51));
        btnRemove1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnRemove1.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove1.setText("REMOVE");
        btnRemove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnUUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemove1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSaleOf1)
                                    .addComponent(jXStartAt1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jXEndAt1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaleOf1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jXStartAt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jXEndAt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("CHỈNH SỬA VOUCHER");
        jLabel12.setToolTipText("");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jLabel12.setOpaque(true);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblKhachHang1.setAutoCreateRowSorter(true);
        tblKhachHang1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblKhachHang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên khách hàng", "Số điện thoại", "Email", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblKhachHang1);
        if (tblKhachHang1.getColumnModel().getColumnCount() > 0) {
            tblKhachHang1.getColumnModel().getColumn(0).setMinWidth(100);
            tblKhachHang1.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblKhachHang1.getColumnModel().getColumn(0).setMaxWidth(100);
            tblKhachHang1.getColumnModel().getColumn(2).setResizable(false);
            tblKhachHang1.getColumnModel().getColumn(3).setResizable(false);
            tblKhachHang1.getColumnModel().getColumn(4).setMinWidth(70);
            tblKhachHang1.getColumnModel().getColumn(4).setPreferredWidth(5);
            tblKhachHang1.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Chọn khách hàng");

        btnBack1.setBackground(new java.awt.Color(51, 51, 51));
        btnBack1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnBack1.setForeground(new java.awt.Color(255, 255, 255));
        btnBack1.setText("Back");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FormVoucherUpdateLayout = new javax.swing.GroupLayout(FormVoucherUpdate);
        FormVoucherUpdate.setLayout(FormVoucherUpdateLayout);
        FormVoucherUpdateLayout.setHorizontalGroup(
            FormVoucherUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FormVoucherUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FormVoucherUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormVoucherUpdateLayout.createSequentialGroup()
                        .addComponent(btnBack1)
                        .addGap(0, 822, Short.MAX_VALUE))
                    .addGroup(FormVoucherUpdateLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FormVoucherUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3)))))
        );
        FormVoucherUpdateLayout.setVerticalGroup(
            FormVoucherUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FormVoucherUpdateLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormVoucherUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(btnBack1)
                .addContainerGap(524, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TableVoucherPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(FormVoucherPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(FormVoucherUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TableVoucherPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(356, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(FormVoucherPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 191, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(FormVoucherUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoucherMouseClicked

    }//GEN-LAST:event_tblVoucherMouseClicked

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // tạo voucher
        if (validateForm()) {
            Voucher voucher = new Voucher(Double.valueOf(txtSaleOf.getText().trim()),
                    jXEndAt.getDate(), generateRandomId(), jXStartAt.getDate());

            if (voucherImple.insert(voucher)) {
                JOptionPane.showMessageDialog(this, "Tạo Voucher thành công");

                int rowCount = tblKhachHang.getRowCount();
                // lấy giá trị của dòng đang được tích
                int rowSelected = -1;

                for (int i = 0; i < rowCount; i++) {
                    Boolean isChecked = (Boolean) tblKhachHang.getValueAt(i, tblKhachHang.getColumnCount() - 1); // tblKhachHang.getColumnCount() -1 là chỉ số cột của checkbox trong table

                    if (isChecked != null && isChecked) {
                        // Đối tượng tại hàng i đã được chọn
                        // Bạn có thể thực hiện các thao tác cần thiết với đối tượng này ở đây
                        rowSelected = i;

                        // tạo ra voucher với những khách hàng nào được sử dụng voucher này
                        String userId = userImple.getCustomer().get(rowSelected).getId();
                        userVoucherResponsitory.createAll(voucher.getId(), userId);
                    }
                }
                resetForm();
                fillTableVoucher();
                TableVoucherPanel.setVisible(true);
                FormVoucherPanel.setVisible(false);
                FormVoucherUpdate.setVisible(false);
                //--------------------------------------
            } else {
                JOptionPane.showMessageDialog(this, "Tạo Voucher thất bại", "Quản lý user", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        resetForm();
        TableVoucherPanel.setVisible(true);
        FormVoucherPanel.setVisible(false);
        FormVoucherUpdate.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCreateVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateVoucherActionPerformed
        // nút chuyển trang tạo voucher
        resetForm();
        TableVoucherPanel.setVisible(false);
        FormVoucherPanel.setVisible(true);
        FormVoucherUpdate.setVisible(false);
    }//GEN-LAST:event_btnCreateVoucherActionPerformed

    private void tblVoucherMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoucherMousePressed
        index = tblVoucher.getSelectedRow();
        if (index != -1 && evt.getClickCount() == 2) {
            index = tblVoucher.getSelectedRow();
            System.out.println(index);
            Voucher voucher = voucherImple.getAll().get(index);
            txtSaleOf1.setText(voucher.getSaleOf() + "");
            jXStartAt1.setDate(voucher.getStartAt());
            jXEndAt1.setDate(voucher.getEndAt());

            // khi click vào dòng này sẽ chuyển qua form chỉnh sửa của voucher
            fillTableKhachHang1();
            TableVoucherPanel.setVisible(false);
            FormVoucherPanel.setVisible(false);
            FormVoucherUpdate.setVisible(true);
        }

        for (int i = 0; i < tblKhachHang1.getRowCount(); i++) {
            int check = userVoucherResponsitory.getCountVoucherUser(voucherImple.getAll().get(index).getId(), userImple.getCustomer().get(i).getId());
            if (check > 0) {
                tblKhachHang1.setValueAt(true, i, tblKhachHang.getColumnCount() - 1);
            }
        }
    }//GEN-LAST:event_tblVoucherMousePressed

    private void btnUUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUUpdate1ActionPerformed
        // update voucher
        if (index != -1) {
            if (validateForm1()) {
                Voucher voucher = voucherImple.getAll().get(index);

                voucher.setSaleOf(Double.valueOf(txtSaleOf1.getText().trim()));
                voucher.setStartAt(jXStartAt1.getDate());
                voucher.setEndAt(jXEndAt1.getDate());

                if (voucherImple.update(voucher)) {

                    int rowCount = tblKhachHang1.getRowCount();
                    // lấy giá trị của dòng đang được tích
                    int rowSelected = -1;
                    userVoucherResponsitory.removeAllByVoucherId(Long.valueOf(voucher.getId()));
                    Boolean isChecked = null;
                    for (int i = 0; i < rowCount; i++) {
                        isChecked = (Boolean) tblKhachHang1.getValueAt(i, tblKhachHang1.getColumnCount() - 1); // tblKhachHang.getColumnCount() -1 là chỉ số cột của checkbox trong table
                        if (isChecked != null && isChecked) {
                            // Đối tượng tại hàng i đã được chọn
                            // Bạn có thể thực hiện các thao tác cần thiết với đối tượng này ở đây
                            rowSelected = i;

                            // tạo ra voucher với những khách hàng nào được sử dụng voucher này
                            String userId = userImple.getCustomer().get(rowSelected).getId();

                            userVoucherResponsitory.createAll(voucher.getId(), userId);
                        }
                    }
                    //--------------------------------------
                    JOptionPane.showMessageDialog(this, "Update Voucher thành công");
                    resetForm();
                    fillTableVoucher();
                    TableVoucherPanel.setVisible(true);
                    FormVoucherPanel.setVisible(false);
                    FormVoucherUpdate.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Update Voucher thất bại", "Quản lý user", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }//GEN-LAST:event_btnUUpdate1ActionPerformed

    private void btnRemove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove1ActionPerformed
        if (index != -1) {
            Voucher voucher = voucherImple.getAll().get(index);

            if (voucherImple.delete(voucher.getId())) {
                JOptionPane.showMessageDialog(this, "Xóa Voucher thành công");
                userVoucherResponsitory.removeAllByVoucherId(Long.valueOf(voucher.getId()));
                resetForm();
                fillTableVoucher();
                TableVoucherPanel.setVisible(true);
                FormVoucherPanel.setVisible(false);
                FormVoucherUpdate.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Không thể xóa voucher này!!!", "Quản lý user", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Voucher muốn xóa!", "Quản lý voucher", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemove1ActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        resetForm();
        fillTableVoucher();
        TableVoucherPanel.setVisible(true);
        FormVoucherPanel.setVisible(false);
        FormVoucherUpdate.setVisible(false);
    }//GEN-LAST:event_btnBack1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FormVoucherPanel;
    private javax.swing.JPanel FormVoucherUpdate;
    private javax.swing.JPanel TableVoucherPanel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnCreateVoucher;
    private javax.swing.JButton btnRemove1;
    private javax.swing.JButton btnUUpdate1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXDatePicker jXEndAt;
    private org.jdesktop.swingx.JXDatePicker jXEndAt1;
    private org.jdesktop.swingx.JXDatePicker jXStartAt;
    private org.jdesktop.swingx.JXDatePicker jXStartAt1;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblKhachHang1;
    private javax.swing.JTable tblVoucher;
    private javax.swing.JTextField txtSaleOf;
    private javax.swing.JTextField txtSaleOf1;
    // End of variables declaration//GEN-END:variables
}
