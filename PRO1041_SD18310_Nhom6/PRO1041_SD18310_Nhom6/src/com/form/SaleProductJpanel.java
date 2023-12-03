/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.form;

import Util.Validate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.model.Product;
import com.model.SaleProduct;
import com.service.ProductService;
import com.service.SaleProductService;
import com.service.imple.ProductImple;
import com.service.imple.SaleProductImple;

/**
 *
 * @author TgNam
 */
public class SaleProductJpanel extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private ProductService Ps = new ProductImple();
    private SaleProductService Sps = new SaleProductImple();
    private Validate vl = new Validate();
    private Date nowDate = null;
    /**
     * Creates new form tesst
     */
    public SaleProductJpanel() {
        initComponents();
        datarowProcuct();
        datarowSaleProcuct();
    }

    //đổ đữ liệu cho bảng sản phẩm
    public void datarowProcuct() {
        tableModel = (DefaultTableModel) tblsanpham.getModel();
        tableModel.setRowCount(0);
        int index = 1;
        for (Product product : Ps.getList_sale()) {
            tableModel.addRow(new Object[]{index++, product.getId(), product.getName_product(), product.getProduct_price(),product.getSale_id().getId(), product.getSale_id().getSale() + " %"});
        }
    }

    //đổ đữ liệu cho bảng SaleProduct
    public void datarowSaleProcuct() {
        tableModel = (DefaultTableModel) tblkhuyenmai.getModel();
        tableModel.setRowCount(0);
        int index = 1;
        for (SaleProduct saleProduct : Sps.getList()) {
            tableModel.addRow(new Object[]{saleProduct.getId(), saleProduct.getStart_at(), saleProduct.getEnd_at(), saleProduct.getSale() + " %", saleProduct.checkTrangThai()});
        }
    }

    //đổ dữ liệu lên form 
    public void filltableKM(int index) {
        SaleProduct ps = Sps.getList().get(index);
        txtsale.setText(String.valueOf(ps.getSale()));
        txttgbd.setText(String.valueOf(ps.getStart_at()));
        txttgkt.setText(String.valueOf(ps.getEnd_at()));
    }

    //lấy thời gian hiện tại
    public static Date getCurrentDateTime() {
        try {
            // Lấy thời gian hiện tại
            Date currentDate = new Date();

            // Định dạng ngày tháng năm giờ phút giây
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // Chuyển đổi thành chuỗi theo định dạng
            String formattedDateTime = dateFormat.format(currentDate);

            // Chuyển lại thành đối tượng Date
            Date date = dateFormat.parse(formattedDateTime);

            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //check ngày kết thúc
    public Date checkDateEndAt() {
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String endAt = txttgkt.getText();
            if (!vl.isCheckDate(endAt)) {
                JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ hoặc năm sinh không hợp lệ của ô ngày kết thúc!");
                return null;
            }
            date = sdf.parse(endAt);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng ngày yyyy-MM-dd");
            return null;
        }
    }
    
    // check ngày bắt đầu
    public Date checkDateStartAt() {
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String startAt = txttgbd.getText();
            if (!vl.isCheckDate(startAt)) {
                JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ hoặc năm sinh không hợp lệ của ô ngày bắt đầu!");
                return null;
            }
            date = sdf.parse(startAt);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng ngày yyyy-MM-dd");
            return null;
        }
    }

    public SaleProduct check() {
        SaleProduct nv = null;
        String sale = txtsale.getText();
        Date StartAt = checkDateStartAt();
        Date EndAt = checkDateEndAt();
        String status = rdohd.isSelected() == true ? "1" : "0";
        nowDate = getCurrentDateTime();
        try {
            if (sale.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng không được để trống!");
                return null;
            } else if (Double.parseDouble(sale) > Double.parseDouble("100")) {
                JOptionPane.showMessageDialog(this, "Vui lòng % giảm giá <100!");
                return null;
            } else {
                return new SaleProduct(null, nowDate, nowDate, StartAt, EndAt, Double.parseDouble(sale), status);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui Lòng nhập lại!");
            return null;
        }
    }
    public void reset(){
        txtsale.setText("");
        txttgbd.setText("");
        txttgkt.setText("");
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsanpham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblkhuyenmai = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtsale = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txttgbd = new javax.swing.JTextField();
        txttgkt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rdohd = new javax.swing.JRadioButton();
        rdonhd = new javax.swing.JRadioButton();
        bthluu = new javax.swing.JButton();
        bthcapnhat = new javax.swing.JButton();
        bthxoa = new javax.swing.JButton();
        bthmoi = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "TênSP", "Giá", "Mã Sale", "MaKM", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblsanpham);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Danh sách sẩn phẩm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblkhuyenmai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Ngày bắt đầu", "Ngày kết thúc", "Giảm giá %", "Trạng thái"
            }
        ));
        tblkhuyenmai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkhuyenmaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblkhuyenmai);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Danh sách khuyến mại");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Khuyến mại");

        jLabel4.setText("Mức Giảm Giá:");

        jLabel5.setText("TG bắt đầu:");

        jLabel6.setText("TG kết thúc:");

        jLabel7.setText("Trạng Thái:");

        buttonGroup1.add(rdohd);
        rdohd.setSelected(true);
        rdohd.setText("Đang hoạt động");

        buttonGroup1.add(rdonhd);
        rdonhd.setText("Ngừng hoạt động");

        bthluu.setText("Lưu");
        bthluu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthluuActionPerformed(evt);
            }
        });

        bthcapnhat.setText("Cập nhật");
        bthcapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthcapnhatActionPerformed(evt);
            }
        });

        bthxoa.setText("Xóa");
        bthxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthxoaActionPerformed(evt);
            }
        });

        bthmoi.setText("Mới");
        bthmoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthmoiActionPerformed(evt);
            }
        });

        jButton1.setText("Thêm tất cả sản phẩm");
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txttgkt))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(rdohd)
                                .addGap(44, 44, 44)
                                .addComponent(rdonhd))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bthluu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(bthcapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(bthxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bthmoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsale, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(txttgbd))))
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtsale, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txttgbd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txttgkt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdohd)
                    .addComponent(rdonhd))
                .addGap(28, 28, 28)
                .addComponent(bthluu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bthxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bthcapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bthmoi, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblkhuyenmaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkhuyenmaiMouseClicked
        int index = tblkhuyenmai.getSelectedRow();
        filltableKM(index);
    }//GEN-LAST:event_tblkhuyenmaiMouseClicked

    private void bthluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthluuActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblsanpham.getModel();
        boolean checksp = false;
        //thêm saleProduct
        SaleProduct sp = check();
        Sps.add(sp);
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Boolean isChecked = (Boolean) model.getValueAt(i, 6); // 5 là chỉ số cột của checkbox trong table

            if (isChecked != null && isChecked) {
                // Đối tượng tại hàng i đã được chọn
                // Bạn có thể thực hiện các thao tác cần thiết với đối tượng này ở đây
                Product p = Ps.getList_sale().get(i);
                Ps.updateSale_ID_created_at(nowDate, p.getId());
                checksp=true;
            }
        }
        if (checksp==true && sp!=null) {
            JOptionPane.showMessageDialog(this, "Bạn đã thêm đợt giảm giá thành công");
        }else{
            Sps.delete_ID_created_at(nowDate);
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm "+"\n"+"Bạn đã thêm đợt giảm giá thất bại");
        }
        reset();
        datarowProcuct();
        datarowSaleProcuct();
    }//GEN-LAST:event_bthluuActionPerformed

    private void bthcapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthcapnhatActionPerformed
        int index = tblkhuyenmai.getSelectedRow();
        if (index >=0) {
            SaleProduct sp = Sps.getList().get(index);
            JOptionPane.showMessageDialog(this, Sps.update(check(),sp.getId())); 
        }else{
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn đợt khuyến mãi cần sửa"); 
        }     
        reset();
        datarowProcuct();
        datarowSaleProcuct();      
    }//GEN-LAST:event_bthcapnhatActionPerformed

    private void bthxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthxoaActionPerformed
        int index = tblkhuyenmai.getSelectedRow();
        if (!(index < 0)) {
            int hoi = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?");
            if (hoi != JOptionPane.YES_NO_OPTION) {
                JOptionPane.showMessageDialog(this, "Bạn đã không xóa khuyến mãi");
                return;
            }
            SaleProduct sp = Sps.getList().get(index);
            Ps.updateSale_ID(sp.getId());
            JOptionPane.showMessageDialog(this,  Sps.delete_ID(sp.getId()));
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn đợt khuyến mãi cần xóa");
        }  
        reset();
        datarowProcuct();
        datarowSaleProcuct();
    }//GEN-LAST:event_bthxoaActionPerformed

    private void bthmoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthmoiActionPerformed
        reset();     
    }//GEN-LAST:event_bthmoiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblsanpham.getModel();
        int rowCount = model.getRowCount();
        SaleProduct sp = check();
        if (sp != null) {
            JOptionPane.showMessageDialog(this, Sps.add(sp));
        for (int i = 0; i < rowCount; i++) {
                Product p = Ps.getList_sale().get(i);
                Ps.updateSale_ID_created_at(nowDate, p.getId());           
        }
        JOptionPane.showMessageDialog(this, "Thêm tất cả thành công");
        }else{
            JOptionPane.showMessageDialog(this, "Thêm tất cả thát bại");
        }
        reset();
        datarowProcuct();
        datarowSaleProcuct();      
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bthcapnhat;
    private javax.swing.JButton bthluu;
    private javax.swing.JButton bthmoi;
    private javax.swing.JButton bthxoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdohd;
    private javax.swing.JRadioButton rdonhd;
    private javax.swing.JTable tblkhuyenmai;
    private javax.swing.JTable tblsanpham;
    private javax.swing.JTextField txtsale;
    private javax.swing.JTextField txttgbd;
    private javax.swing.JTextField txttgkt;
    // End of variables declaration//GEN-END:variables
}
