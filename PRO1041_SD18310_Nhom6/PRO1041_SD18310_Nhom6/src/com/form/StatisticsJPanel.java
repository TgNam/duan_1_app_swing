/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.form;

import com.model.Bill;
import com.repository.StatisticsRepository;
import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class StatisticsJPanel extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
     private StatisticsRepository statisticsRepository;

    
    public StatisticsJPanel() {
        initComponents();
        initComboBox();
        statisticsRepository = new StatisticsRepository();
        for (int i = 1; i <= 12; i++) {
    cbbThang.addItem(String.valueOf(i));
}
        
        datarowStatisticsAll();
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

//        rdoThang.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                rdoThangActionPerformed(evt);
//            }
//        });

        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });
    }
    private void initComboBox() {
    // Gán ItemListener cho JComboBox cbbThang
    cbbThang.addItemListener(this::cbbThangItemStateChanged);
}
//    public void datarowStatisticsAll() {
//    tableModel = (DefaultTableModel) tblThongKe.getModel();
//    tableModel.setRowCount(0); // Xóa tất cả các dòng hiện có trong bảng
//
//    // Gọi phương thức getBil_All() từ StatisticsRepository để lấy danh sách hóa đơn
//    StatisticsRepository statisticsRepository = new StatisticsRepository();
//    ArrayList<Bill> billList = statisticsRepository.getBil_All();
//
//    // Kiểm tra xem danh sách có dữ liệu hay không
//    if (billList != null) {
//        // Duyệt qua danh sách hóa đơn và thêm dữ liệu vào bảng
//        for (Bill bill : billList) {
//            // Đối với mỗi hóa đơn, bạn có thể sử dụng các phương thức như
//            // bill.getId(), bill.getCreatedAt(), bill.getTotalCost(),...
//            // để lấy thông tin cần thiết và thêm vào bảng
//            tableModel.addRow(new Object[]{
//                bill.getId(),
//                bill.getCreatedAt(),
//                bill.getTotalCost()
//            });
//        }
//    }
//}
    
    public void datarowStatisticsAll() {
    tableModel = (DefaultTableModel) tblThongKe.getModel();
    tableModel.setRowCount(0);

    StatisticsRepository statisticsRepository = new StatisticsRepository();
    ArrayList<Bill> billList = statisticsRepository.getBil_All();

    BigDecimal tongTien = BigDecimal.ZERO; // Tổng tiền ban đầu là 0
    BigDecimal doanhThu = BigDecimal.ZERO;
    int soHoaDon = 0;
    if (billList != null) {
        for (Bill bill : billList) {
            tableModel.addRow(new Object[]{
                bill.getId(),
                bill.getCreatedAt(),
                bill.getTotalCost(),
                ++soHoaDon
            });

            // Tính tổng tiền bằng cách thêm giá trị của mỗi hóa đơn vào tổng
            tongTien = tongTien.add(bill.getTotalCost());
            doanhThu = doanhThu.add(bill.getTotalCost());
        }
    }

    // Hiển thị tổng tiền trong JLabel jlbTongTien
    jlbTongTien.setText(tongTien.toString());
    jlbSoHoaDon.setText(String.valueOf(soHoaDon));
    jlbDoanhThu.setText(doanhThu.toString());
    tblThongKe.repaint();
}
    
     private void datarowStatisticsByYear() {
    tableModel = (DefaultTableModel) tblThongKe.getModel();
    tableModel.setRowCount(0);

    StatisticsRepository statisticsRepository = new StatisticsRepository();
    ArrayList<Bill> billList = statisticsRepository.getBil_Year();

    BigDecimal tongTien = BigDecimal.ZERO; // Tổng tiền ban đầu là 0
    BigDecimal doanhThu = BigDecimal.ZERO;
    if (billList != null) {
        for (Bill bill : billList) {
            tableModel.addRow(new Object[]{
                bill.getId(),
                bill.getCreatedAt(),
                bill.getTotalCost()
            });

            // Tính tổng tiền bằng cách thêm giá trị của mỗi hóa đơn vào tổng
            tongTien = tongTien.add(bill.getTotalCost());
            doanhThu = doanhThu.add(bill.getTotalCost());
        }
    }

    // Hiển thị tổng tiền trong JLabel jlbTongTien
    jlbTongTien.setText(tongTien.toString());
    jlbDoanhThu.setText(doanhThu.toString());
    tblThongKe.repaint();
    }
     
    private void datarowStatisticsByMonth(int selectedMonth) {
    tableModel = (DefaultTableModel) tblThongKe.getModel();
    tableModel.setRowCount(0);

    StatisticsRepository statisticsRepository = new StatisticsRepository();
    ArrayList<Bill> billList = statisticsRepository.getBil_Month(selectedMonth);

    BigDecimal tongTien = BigDecimal.ZERO; // Tổng tiền ban đầu là 0

    if (billList != null) {
        for (Bill bill : billList) {
            tableModel.addRow(new Object[]{
                bill.getId(),
                bill.getCreatedAt(),
                bill.getTotalCost()
            });

            // Tính tổng tiền bằng cách thêm giá trị của mỗi hóa đơn vào tổng
            tongTien = tongTien.add(bill.getTotalCost());
        }
    }

    // Hiển thị tổng tiền trong JLabel jlbTongTien
    jlbTongTien.setText(tongTien.toString());
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlbDoanhThu = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlbSoHoaDon = new javax.swing.JLabel();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoNam = new javax.swing.JRadioButton();
        rdoThang = new javax.swing.JRadioButton();
        cbbThang = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jlbTongTien = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày", "Tiền"
            }
        ));
        jScrollPane2.setViewportView(tblThongKe);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Doanh Thu");

        jlbDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        jlbDoanhThu.setText("000000");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("VNĐ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbDoanhThu)
                    .addComponent(jLabel9))
                .addGap(36, 36, 36))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Số Hóa Đơn");

        jlbSoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbSoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        jlbSoHoaDon.setText("0000000");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbSoHoaDon)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbSoHoaDon)
                .addGap(36, 36, 36))
        );

        buttonGroup1.add(rdoTatCa);
        rdoTatCa.setSelected(true);
        rdoTatCa.setText("Tất cả");
        rdoTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoTatCaMouseClicked(evt);
            }
        });
        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Theo năm");
        rdoNam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoNamMouseClicked(evt);
            }
        });
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoThang);
        rdoThang.setText("Theo tháng");
        rdoThang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoThangMouseClicked(evt);
            }
        });
        rdoThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoThangActionPerformed(evt);
            }
        });

        cbbThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbThangItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Tổng tiền:");

        jlbTongTien.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbTongTien.setForeground(new java.awt.Color(255, 0, 0));
        jlbTongTien.setText("jLabel11");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("VNĐ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(335, 335, 335)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoThang)
                                .addGap(18, 18, 18)
                                .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rdoTatCa)
                            .addComponent(rdoNam))
                        .addGap(245, 245, 245)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoTatCa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoNam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoThang)
                    .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jlbTongTien)
                    .addComponent(jLabel11))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void rdoTatCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoTatCaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoTatCaMouseClicked

    private void rdoNamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoNamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNamMouseClicked

    private void rdoThangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoThangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoThangMouseClicked

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed
         datarowStatisticsAll();
    }//GEN-LAST:event_rdoTatCaActionPerformed

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        datarowStatisticsByYear();
    }//GEN-LAST:event_rdoNamActionPerformed

    private void rdoThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoThangActionPerformed
//         datarowStatisticsByMonth();
    }//GEN-LAST:event_rdoThangActionPerformed

    private void cbbThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbThangItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
        // Lấy giá trị được chọn từ JComboBox
        String selectedMonthStr = (String) cbbThang.getSelectedItem();
        // Chuyển đổi giá trị thành số nguyên
        int selectedMonth = Integer.parseInt(selectedMonthStr);

        // Nếu chọn "Tất cả", hiển thị dữ liệu của tất cả các hóa đơn
        if (selectedMonth == 0) {
            datarowStatisticsAll();
        } else {
            // Ngược lại, hiển thị dữ liệu của hóa đơn trong tháng được chọn
            datarowStatisticsByMonth(selectedMonth);
        }
    }
    }//GEN-LAST:event_cbbThangItemStateChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlbDoanhThu;
    private javax.swing.JLabel jlbSoHoaDon;
    private javax.swing.JLabel jlbTongTien;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JRadioButton rdoThang;
    private javax.swing.JTable tblThongKe;
    // End of variables declaration//GEN-END:variables
}
