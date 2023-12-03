/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.form;

import Util.Validate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import com.model.Bill;
import com.model.BillDetail;
import com.model.ReturnBill;
import com.model.ReturnBillDetail;
import com.repository.VoucherResponsitory;
import com.service.BillDetailService;
import com.service.BillService;
import com.service.ProductDetailService;
import com.service.ProductService;
import com.service.UserRoleService;
import com.service.UserService;
import com.service.imple.BillDetailImple;
import com.service.imple.BillImple;
import com.service.imple.ProductDetailImple;
import com.service.imple.ProductImple;
import com.service.imple.ReturnBillDetailImple;
import com.service.imple.ReturnBillImple;
import com.service.imple.UserImple;
import com.service.imple.UserRoleImple;

/**
 *
 * @author TgNam
 */
public class InvoiceManagementJPanel extends javax.swing.JPanel {
    
    private DefaultTableModel tableModel = new DefaultTableModel();
    private BillDetailService billDetailService = new BillDetailImple();
    private ProductService productService = new ProductImple();
    private ProductDetailService productDetailService = new ProductDetailImple();
    private BillService billService = new BillImple();
    private UserService userService = new UserImple();
    private UserRoleService userRoleService = new UserRoleImple();
    private VoucherResponsitory voucherResponsitory = new VoucherResponsitory();
    private Validate vl = new Validate();
    private String checkStatus = "1";
    private JFrame jFrame = new JFrame();
    private ReturnsForm returnsForm = new ReturnsForm(jFrame, true);
    private List<BillDetail> listProductReturn = null;
    //them cai nay 30/11
    private List<BillDetail> listProductExchang = null;
    private Exchang_Bill ex = new Exchang_Bill(jFrame, true);

    /**
     * Creates new form InvoiceManagementJPanel
     */
    public InvoiceManagementJPanel() {
        initComponents();
        columns_no_checkbox();
        datarowBill(String.valueOf("1"), String.valueOf("1"));
        btnDoiHang.setVisible(false);
        btnTraHang.setVisible(false);
        btnInPhieuGH.setVisible(true);
        bthXacNhan.setVisible(false);
        pannelLyDoHoanTra.setVisible(false);
    }
    
    public void columns_no_checkbox() {
        tableModel = new DefaultTableModel();
        String[] column = {"STT", "Tên Sản Phẩm", "Màu", "Size", "Số Lượng", "Đơn Giá"};
        tableModel.setColumnIdentifiers(column);
        TableColumnModel columnModel = tblBillDetails.getColumnModel();
        tblBillDetails.setModel(tableModel);
    }
    
    public void columns_yes_checkbox() {
        tblBillDetails.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblBillDetails.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT", "Tên sản phẩm", "Màu", "Size", "Số lượng", "Đơn giá", ""
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, true
            };
            
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblBillDetails.setRowHeight(25);
    }
    
    public void datarowBill(String status1, String status2) {
        tableModel = (DefaultTableModel) tblBill.getModel();
        tableModel.setRowCount(0);
        int index = 1;
        for (Bill bill : billService.getBill_status(status1, status2)) {
            tableModel.addRow(new Object[]{
                index++,
                bill.getId(),
                bill.getUserId().getFullName(),
                bill.getUserId().getNumberPhone(),
                bill.checkTrangThai(),
                bill.getCreatedAt()
            });
        }
    }
    
    public void loadBillDetail(String id) {
        tableModel = (DefaultTableModel) this.tblBillDetails.getModel();
        tableModel.setRowCount(0);
        int index = 1;
        for (BillDetail bdt : this.billDetailService.getbill_all(id)) {
            Object[] ob = {
                index++,
                bdt.getProductDetailId().getProductId().getName_product(),
                bdt.getProductDetailId().getColorId().getNameColor(),
                bdt.getProductDetailId().getSizeId().getNameSize(),
                bdt.getQuantityPurchased(),
                bdt.getPriceNow()
            };
            tableModel.addRow(ob);
        }
    }
    
    public void loadBillReturn(List<ReturnBillDetail> list) {
        tableModel = (DefaultTableModel) this.tblBillDetails.getModel();
        tableModel.setRowCount(0);
        int index = 1;
        for (ReturnBillDetail rbd : list) {
            Object[] ob = {
                index++,
                rbd.getProductDetailId().getProductId().getName_product(),
                rbd.getProductDetailId().getColorId().getNameColor(),
                rbd.getProductDetailId().getSizeId().getNameSize(),
                rbd.getQuantityOfProductsReturned(),
                rbd.getPriceAtTheTimeOfPurchase()
            };
            tableModel.addRow(ob);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFormTraHang = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        bthBill3 = new javax.swing.JButton();
        bthBill2 = new javax.swing.JButton();
        bthBill46 = new javax.swing.JButton();
        bthBill57 = new javax.swing.JButton();
        bthBill1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBillDetails = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnDoiHang = new javax.swing.JButton();
        btnTraHang = new javax.swing.JButton();
        btnInPhieuGH = new javax.swing.JButton();
        bthXacNhan = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        pannelLyDoHoanTra = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtLyDo = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LỊCH SỬ HÓA ĐƠN");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Hóa đơn");

        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "Tên khách hàng", "Số điện thoại", "Trạng thái", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBill.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tblBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBillMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBill);
        if (tblBill.getColumnModel().getColumnCount() > 0) {
            tblBill.getColumnModel().getColumn(0).setMinWidth(50);
            tblBill.getColumnModel().getColumn(0).setMaxWidth(50);
            tblBill.getColumnModel().getColumn(1).setMinWidth(70);
            tblBill.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        bthBill3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bthBill3.setText("Hóa đơn hoàn thành");
        bthBill3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthBill3ActionPerformed(evt);
            }
        });

        bthBill2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bthBill2.setText("Hóa đơn đang giao");
        bthBill2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthBill2ActionPerformed(evt);
            }
        });

        bthBill46.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bthBill46.setText("Hóa đơn chờ trả hàng/đổi hàng");
        bthBill46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthBill46ActionPerformed(evt);
            }
        });

        bthBill57.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bthBill57.setText("Hóa đơn trả hàng/đổi hàng");
        bthBill57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthBill57ActionPerformed(evt);
            }
        });

        bthBill1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bthBill1.setText("Hóa đơn đã thanh toán");
        bthBill1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthBill1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bthBill1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bthBill2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bthBill3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bthBill46, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bthBill57, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bthBill57, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bthBill1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bthBill2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bthBill3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bthBill46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelFormTraHangLayout = new javax.swing.GroupLayout(panelFormTraHang);
        panelFormTraHang.setLayout(panelFormTraHangLayout);
        panelFormTraHangLayout.setHorizontalGroup(
            panelFormTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormTraHangLayout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelFormTraHangLayout.setVerticalGroup(
            panelFormTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormTraHangLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblBillDetails.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblBillDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sản phẩm", "Màu", "Size", "Số lượng", "Đơn giá", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBillDetails.setRowHeight(25);
        tblBillDetails.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tblBillDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBillDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBillDetails);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Chi tiết hóa đơn");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnDoiHang.setText("ĐỔI HÀNG");
        btnDoiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiHangActionPerformed(evt);
            }
        });

        btnTraHang.setText("TRẢ HÀNG");
        btnTraHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraHangActionPerformed(evt);
            }
        });

        btnInPhieuGH.setText("IN PHIẾU GIAO HÀNG");
        btnInPhieuGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInPhieuGHActionPerformed(evt);
            }
        });

        bthXacNhan.setText("XÁC NHẬN");
        bthXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthXacNhanActionPerformed(evt);
            }
        });

        jButton1.setText("HUỶ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bthXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInPhieuGH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                    .addComponent(btnTraHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDoiHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDoiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInPhieuGH, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bthXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pannelLyDoHoanTra.setPreferredSize(new java.awt.Dimension(383, 267));

        txtLyDo.setColumns(20);
        txtLyDo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtLyDo.setRows(5);
        jScrollPane3.setViewportView(txtLyDo);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Lý do:");

        javax.swing.GroupLayout pannelLyDoHoanTraLayout = new javax.swing.GroupLayout(pannelLyDoHoanTra);
        pannelLyDoHoanTra.setLayout(pannelLyDoHoanTraLayout);
        pannelLyDoHoanTraLayout.setHorizontalGroup(
            pannelLyDoHoanTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
            .addGroup(pannelLyDoHoanTraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pannelLyDoHoanTraLayout.setVerticalGroup(
            pannelLyDoHoanTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelLyDoHoanTraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelFormTraHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(593, Short.MAX_VALUE)
                    .addComponent(pannelLyDoHoanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(427, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelFormTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(283, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(427, Short.MAX_VALUE)
                    .addComponent(pannelLyDoHoanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bthBill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthBill1ActionPerformed
        columns_no_checkbox();
        datarowBill(String.valueOf("1"), String.valueOf("1"));
        checkStatus = "1";
        btnDoiHang.setVisible(false);
        btnTraHang.setVisible(false);
        btnInPhieuGH.setVisible(true);
        bthXacNhan.setVisible(false);
        pannelLyDoHoanTra.setVisible(false);
        txtLyDo.setText("");
    }//GEN-LAST:event_bthBill1ActionPerformed

    private void bthBill2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthBill2ActionPerformed
        columns_no_checkbox();
        datarowBill(String.valueOf("2"), String.valueOf("2"));
        checkStatus = "2";
        btnDoiHang.setVisible(false);
        btnTraHang.setVisible(false);
        btnInPhieuGH.setVisible(false);
        bthXacNhan.setVisible(true);
        pannelLyDoHoanTra.setVisible(false);
        txtLyDo.setText("");
    }//GEN-LAST:event_bthBill2ActionPerformed

    private void bthBill3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthBill3ActionPerformed
        columns_yes_checkbox();
        datarowBill(String.valueOf("3"), String.valueOf("3"));
        checkStatus = "3";
        btnDoiHang.setVisible(true);
        btnTraHang.setVisible(true);
        btnInPhieuGH.setVisible(false);
        bthXacNhan.setVisible(false);
        pannelLyDoHoanTra.setVisible(false);
        txtLyDo.setText("");
    }//GEN-LAST:event_bthBill3ActionPerformed

    private void bthBill46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthBill46ActionPerformed
        columns_no_checkbox();
        datarowBill(String.valueOf("4"), String.valueOf("6"));
        checkStatus = "46";
        btnDoiHang.setVisible(false);
        btnTraHang.setVisible(false);
        btnInPhieuGH.setVisible(false);
        bthXacNhan.setVisible(true);
        pannelLyDoHoanTra.setVisible(true);
        txtLyDo.setText("");
    }//GEN-LAST:event_bthBill46ActionPerformed

    private void bthBill57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthBill57ActionPerformed
        columns_no_checkbox();
        datarowBill(String.valueOf("5"), String.valueOf("7"));
        checkStatus = "57";
        btnDoiHang.setVisible(false);
        btnTraHang.setVisible(false);
        btnInPhieuGH.setVisible(false);
        bthXacNhan.setVisible(false);
        pannelLyDoHoanTra.setVisible(false);
        txtLyDo.setText("");
    }//GEN-LAST:event_bthBill57ActionPerformed

    private void tblBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillMouseClicked
        try {
            int row = tblBill.getSelectedRow();
            if (row >= 0) {
                if (checkStatus.equals("1")) {
                    Bill bill = billService.getBill_status("1", "1").get(row);
                    String id = bill.getId();
                    loadBillDetail(id);
                } else if (checkStatus.equals("2")) {
                    Bill bill = billService.getBill_status("2", "2").get(row);
                    String id = bill.getId();
                    loadBillDetail(id);
                } else if (checkStatus.equals("3")) {
                    Bill bill = billService.getBill_status("3", "3").get(row);
                    String id = bill.getId();
                    loadBillDetail(id);
                } else if (checkStatus.equals("46")) {
                    Bill bill = billService.getBill_status("4", "6").get(row);
                    String id = bill.getId();
                    List<ReturnBillDetail> listRbd = new ReturnBillDetailImple().getByIdBill(id);
                    loadBillReturn(listRbd);
                    ReturnBill returnBill = new ReturnBillImple().getById(listRbd.get(0).getReturnBillId().getId());
                    txtLyDo.setText(returnBill.getReasonDescription());
                } else if (checkStatus.equals("57")) {
                    Bill bill = billService.getBill_status("5", "7").get(row);
                    String id = bill.getId();
                    loadBillDetail(id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi dữ liệu");
        }
    }//GEN-LAST:event_tblBillMouseClicked

    private void btnTraHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraHangActionPerformed
        
        int rowCount = tblBillDetails.getRowCount();
        int indexBill = tblBill.getSelectedRow();
        if (indexBill != -1) {
            Bill bill = billService.getBill_status(checkStatus, checkStatus).get(indexBill);
            // Lấy ra các sản phẩm có trong bill này
            List<BillDetail> billDetails = billDetailService.getbill_all(bill.getId());
            Boolean isChecked = null;
            listProductReturn = new ArrayList<>();
            returnsForm = new ReturnsForm(jFrame, true);
            // duyệt qua từng dòng với i là đại diện cho index của các dòng
            for (int i = 0; i < rowCount; i++) {
                isChecked = (Boolean) tblBillDetails.getValueAt(i, tblBillDetails.getColumnCount() - 1);
                if (isChecked != null && isChecked) {
                    // nếu dòng này đang được tích thì lấy ra BillDetail tại dòng đó
                    billDetails.get(i).setBillId(bill);
                    listProductReturn.add(billDetails.get(i));
                }
            }
            if (listProductReturn.size() == 0) {
                JOptionPane.showMessageDialog(this, "Chọn sản phẩm muốn trả", "Trả hàng", JOptionPane.ERROR_MESSAGE);
                return;
            }
            returnsForm.setBillDetails(listProductReturn);
            returnsForm.setIdBill(Long.valueOf(bill.getId()));
            returnsForm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn hóa đơn", "Lỗi", 0);
            return;
        }
    }//GEN-LAST:event_btnTraHangActionPerformed

    private void tblBillDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillDetailsMouseClicked
        int rowCount = tblBillDetails.getRowCount();
        int indexBill = tblBill.getSelectedRow();
        if (indexBill != -1) {
            Bill bill = billService.getBill_status(checkStatus, checkStatus).get(indexBill);
            
        }
    }//GEN-LAST:event_tblBillDetailsMouseClicked

    private void btnDoiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiHangActionPerformed
        int rowCount = tblBillDetails.getRowCount();
        int indexBill = tblBill.getSelectedRow();
        if (indexBill != -1) {
            Bill bill = billService.getBill_status(checkStatus, checkStatus).get(indexBill);
            // Lấy ra các sản phẩm có trong bill này
            List<BillDetail> billDetails = billDetailService.getbill_all(bill.getId());
            Boolean isChecked = null;
            listProductExchang = new ArrayList<>();
            ex = new Exchang_Bill(jFrame, true);
            // duyệt qua từng dòng với i là đại diện cho index của các dòng
            for (int i = 0; i < rowCount; i++) {
                isChecked = (Boolean) tblBillDetails.getValueAt(i, tblBillDetails.getColumnCount() - 1);
                if (isChecked != null && isChecked) {
                    // nếu dòng này đang được tích thì lấy ra BillDetail tại dòng đó
                    billDetails.get(i).setBillId(bill);
                    listProductExchang.add(billDetails.get(i));
                }
            }
            if (listProductExchang.size() == 0) {
                JOptionPane.showMessageDialog(this, "Chọn sản phẩm muốn trả", "Trả hàng", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ex.setBillDetails(listProductExchang);
            ex.setIdBill(Long.valueOf(bill.getId()));
            ex.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn hóa đơn", "Lỗi", 0);
            return;
        }
    }//GEN-LAST:event_btnDoiHangActionPerformed

    private void btnInPhieuGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInPhieuGHActionPerformed
        int row = tblBill.getSelectedRow();
        if (row != -1) {
            Bill bill = billService.getBill_status("1", "1").get(row);
            String id = bill.getId();
            billService.printerBill(Long.valueOf(id));
            JOptionPane.showMessageDialog(this, "Hóa đơn đã được lưu vào thư mục HoaDon trong ổ C", "Xuất hóa đơn", 1);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn xuất", "Xuất hóa đơn", 0);
        }
    }//GEN-LAST:event_btnInPhieuGHActionPerformed

    private void bthXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthXacNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bthXacNhanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bthBill1;
    private javax.swing.JButton bthBill2;
    private javax.swing.JButton bthBill3;
    private javax.swing.JButton bthBill46;
    private javax.swing.JButton bthBill57;
    private javax.swing.JButton bthXacNhan;
    private javax.swing.JButton btnDoiHang;
    private javax.swing.JButton btnInPhieuGH;
    private javax.swing.JButton btnTraHang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelFormTraHang;
    private javax.swing.JPanel pannelLyDoHoanTra;
    private javax.swing.JTable tblBill;
    private javax.swing.JTable tblBillDetails;
    private javax.swing.JTextArea txtLyDo;
    // End of variables declaration//GEN-END:variables
}
