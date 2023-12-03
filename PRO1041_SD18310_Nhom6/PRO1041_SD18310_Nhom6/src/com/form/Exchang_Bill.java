/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.model.Bill;
import com.model.BillDetail;
import com.model.ReturnBill;
import com.model.ReturnBillDetail;
import com.service.BillDetailService;
import com.service.BillService;
import com.service.ExchangeService;
import com.service.Exchange_detailServict;
import com.service.imple.BillDetailImple;
import com.service.imple.BillImple;
import com.service.imple.Exchage_DetailImple;
import com.service.imple.ExchangeImple;
import com.service.imple.ReturnBillDetailImple;
import com.service.imple.ReturnBillImple;
import javax.swing.JFrame;

/**
 *
 * @author lenovo
 */
public class Exchang_Bill extends javax.swing.JDialog {

    private int stt = 0;
    private List<BillDetail> billDetails = new ArrayList<>();
    private Bill bill = null;
    private BillImple billImple = new BillImple();
    private BillDetailImple billDetailImple = new BillDetailImple();

    private Long idBill;

    //4/12
    private BillService bs = new BillImple();
    private BillDetailService bdts = new BillDetailImple();
    private ExchangeService exs = new ExchangeImple();
    private Exchange_detailServict exb = new Exchage_DetailImple();

    DefaultTableModel dtm;

    String id;
    double money_Sum;
    String idEx;
    private JFrame frame;

    public void setIdBill(Long idBill) {
        this.idBill = idBill;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }

    public Exchang_Bill(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        id = String.valueOf(idBill);
        System.out.println("id b:" + id);
        frame = (JFrame) parent;
        System.out.println(frame);
    }

    public void loadTableProductReturn() {
        dtm = (DefaultTableModel) tblBillCT.getModel();
        dtm.setRowCount(0);
        stt = 1;
        for (BillDetail bdt : billDetails) {
            Object[] ob = {
                stt++,
                bdt.getBillId().getId(),
                bdt.getProductDetailId().getProductId().getName_product(),
                bdt.getQuantityPurchased(),
                bdt.getProductDetailId().getColorId().getNameColor(),
                bdt.getProductDetailId().getSizeId().getNameSize(),
                bdt.getPriceNow()
            };
            dtm.addRow(ob);
        }
    }

    public void reset() {
        txtDaTT.setText("");
        txtHoanTra.setText("");
        txtLyDo.setText("");
        txtMaKH.setText("");
        txtTenKH.setText("");
    }

    public void loadForm() {
        bill = billImple.getById(idBill);
        txtMaKH.setText(bill.getId());
        txtTenKH.setText(bill.getUserId().getFullName());
        txtDaTT.setText(bill.getIntoMoney() + "");
    }

    // them vao 4/12
    public void minus_Quantity() {
        int row = tblBillCT.getSelectedRow();
        if (row < 0) {
            return;
        } else {
            int quantity_product = Integer.parseInt(tblBillCT.getValueAt(row, 3).toString());
            System.out.println(quantity_product);
            double monney_Product = Double.parseDouble(tblBillCT.getValueAt(row, 6).toString());
            int quantity = Integer.parseInt(JOptionPane.showInputDialog(this, "Moi ban nhap"));
            if (quantity > 0) {
                System.out.println(quantity);
                try {
                   int resultQuantity = quantity_product - quantity;
                    money_Sum += quantity * monney_Product;
                    dtm.setValueAt(resultQuantity, row, 3);
                    txtHoanTra.setText(String.valueOf(money_Sum));
                 System.out.println("tong tien la" + money_Sum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            } else {
                System.out.println("no");
                return;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTraHang = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBillCT = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDaTT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHoanTra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtLyDo = new javax.swing.JTextArea();
        btnHuy = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ĐỔI HÀNG");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelTraHang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblBillCT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblBillCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "Tên sản phẩm", "Số  lượng ", "Màu ", "Size", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBillCT.setRowHeight(25);
        tblBillCT.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tblBillCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBillCTMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblBillCT);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Danh sách sản phẩm muốn đổi");

        txtMaKH.setEditable(false);
        txtMaKH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Mã khách hàng:");

        txtTenKH.setEditable(false);
        txtTenKH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Tên khách hàng: ");

        txtDaTT.setEditable(false);
        txtDaTT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtDaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDaTTActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Đã thanh toán: ");
        jLabel5.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jLabel5AncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        txtHoanTra.setEditable(false);
        txtHoanTra.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Tổng số tiền đổi:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Lý do: ");

        txtLyDo.setColumns(20);
        txtLyDo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtLyDo.setRows(5);
        jScrollPane4.setViewportView(txtLyDo);

        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHuy.setText("HỦY");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXacNhan.setText("XÁC NHẬN ĐỔI HÀNG");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTraHangLayout = new javax.swing.GroupLayout(panelTraHang);
        panelTraHang.setLayout(panelTraHangLayout);
        panelTraHangLayout.setHorizontalGroup(
            panelTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTraHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelTraHangLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addGroup(panelTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTraHangLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(panelTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTraHangLayout.createSequentialGroup()
                                .addGroup(panelTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelTraHangLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(panelTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtHoanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)))
                                    .addGroup(panelTraHangLayout.createSequentialGroup()
                                        .addGroup(panelTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaKH, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDaTT))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                        .addGroup(panelTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(207, 207, 207)))))
                .addContainerGap())
            .addGroup(panelTraHangLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTraHangLayout.setVerticalGroup(
            panelTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTraHangLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTraHangLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(3, 3, 3)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTraHangLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(5, 5, 5)
                        .addComponent(txtHoanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelTraHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 732, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelTraHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblBillCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillCTMouseClicked
        this.minus_Quantity();

    }//GEN-LAST:event_tblBillCTMouseClicked

    private void jLabel5AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel5AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5AncestorMoved

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
        this.setVisible(false);

    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        ExchangeJDialog ex = new ExchangeJDialog(frame, true);
        int row = tblBillCT.getSelectedRow();
        id = String.valueOf(idBill);
        ex.setMoney(money_Sum);
        ex.setIDbill(id);
        ex.setVisible(true);
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadTableProductReturn();
        loadForm();
    }//GEN-LAST:event_formWindowOpened

    private void txtDaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDaTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDaTTActionPerformed

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
            java.util.logging.Logger.getLogger(Exchang_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exchang_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exchang_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exchang_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Exchang_Bill dialog = new Exchang_Bill(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel panelTraHang;
    private javax.swing.JTable tblBillCT;
    private javax.swing.JTextField txtDaTT;
    private javax.swing.JTextField txtHoanTra;
    private javax.swing.JTextArea txtLyDo;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
