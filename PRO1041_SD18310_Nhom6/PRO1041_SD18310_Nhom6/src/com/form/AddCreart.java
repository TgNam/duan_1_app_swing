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
import com.model.User;
import com.service.AddressService;
import com.service.UserRoleService;
import com.service.UserService;
import com.service.imple.AddressImple;
import com.service.imple.UserImple;
import com.service.imple.UserRoleImple;

/**
 *
 * @author TgNam
 */
public class AddCreart extends javax.swing.JPanel {

    private Validate vl = new Validate();
    private Date nowDate = null;
    private UserRoleService urs = new UserRoleImple();
    private UserService us = new UserImple();
    private AddressService as = new AddressImple();

    /**
     * Creates new form AddCreart
     */
    public AddCreart() {
        initComponents();
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

    public void reset() {
        txtfullname.setText("");
        txtemail.setText("");
        txtnumblephone.setText("");
        txtdateofbirth.setText("");
        txtaccount.setText("");
        txtpassword.setText("");
        txtaddress.setText("");
        rdoadmin.setSelected(true);
    }

    // check ngày sinh
    public Date checkDateOfBirch() {
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateofbirth = txtdateofbirth.getText();
            if (!vl.isCheckDate(dateofbirth)) {
                JOptionPane.showMessageDialog(this, "Định dạng ngày sinh không đúng!");
                return null;
            }
            date = sdf.parse(dateofbirth);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng ngày yyyy-MM-dd");
            return null;
        }
    }
    // check số điện thoại 

    public String checknumblephone() {
        String numblephone = txtnumblephone.getText();
        boolean checkName_phone = true;
        try {
            if (numblephone.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng không được để trống số điện thoại!");
            } else if (!vl.isCheckPhone(numblephone)) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số điện thoại!");
                return null;
            }
            if (checkName_phone) {
                for (User userl : us.getUser_name_phone()) {
                    if (userl.getNumberPhone().equals(numblephone)) {
                        checkName_phone = false;
                    }
                }
            }
            if (!checkName_phone) {
                JOptionPane.showMessageDialog(this, "Số điện thoại đã được sử dụng vui lòng sử dụng số diện thoại khác!");
                return null;
            } else {
                return numblephone;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi số điện thoại!");
            return null;
        }
    }

    public String checkaccount() {
        String account = txtaccount.getText();
        boolean checkName_account = true;
        try {
            if (account.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng không được để trống tài khoản!");
            }
            if (!vl.isCheckTXT(account)) {
                JOptionPane.showMessageDialog(this, "Vui lòng kí tự không được vượt quá 100 kí tự!");
                return null;
            }
            if (checkName_account) {
                for (User userl : us.getUser_name_phone()) {
                    if (userl.getAccount() != null && !userl.getAccount().isEmpty()) {
                        // Tiếp tục xử lý khi giá trị không null và rỗng
                        if (userl.getAccount().equals(account)) {
                            checkName_account = false;
                        }
                    }

                }
            }
            if (!checkName_account) {
                JOptionPane.showMessageDialog(this, "Tài khoản này đã được sử dụng vui lòng sử dụng tài khoản khác!");
                return null;
            } else {
                return account;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi tài khoản!");
            return null;
        }
    }

    public User checkadd() {
        User user = null;
        Date dateofbirth = checkDateOfBirch();
        // Lấy giá trị từ trường nhập liệu tên đầy đủ
        String fullname = txtfullname.getText();
        // Lấy giá trị từ trường nhập liệu email
        String email = txtemail.getText();
        // Gọi phương thức checknumblephone() để kiểm tra và lấy giá trị số điện thoại
        String numblephone = checknumblephone();
        // Lấy giá trị từ trường nhập liệu tài khoản
        String account = checkaccount();
        // Lấy giá trị từ trường nhập liệu mật khẩu
        String password = txtpassword.getText();
        // Lấy giá trị từ trường nhập liệu địa chỉ
        String address = txtaddress.getText();
        // Lấy thời điểm hiện tại và lưu vào biến nowDate
        nowDate = getCurrentDateTime();
        try {
            if (fullname.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty() || address.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng không được để trống các ô nhập!");
                return null;
            } else if (!vl.isCheckName(fullname) || !vl.isCheckName(password)) {
                JOptionPane.showMessageDialog(this, "Vui lòng kí tự của tên và mật khẩu không được vượt quá 40 kí tự!");
                return null;
            } else if (!vl.isCheckTXT(address) || !vl.isCheckTXT(email)) {
                JOptionPane.showMessageDialog(this, "Vui lòng kí tự của địa chỉ và email không được vượt quá 100 kí tự!");
                return null;
            } else if (dateofbirth == null || numblephone == null || account == null) {
                return null;
            } else {
                return new User(null, nowDate, dateofbirth, null, null, nowDate, account, email, fullname, numblephone, password, String.valueOf(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Vui Lòng nhập lại!");
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        txtfullname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtnumblephone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtdateofbirth = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtaccount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rdoadmin = new javax.swing.JRadioButton();
        rdoemployee = new javax.swing.JRadioButton();
        bthadd = new javax.swing.JButton();
        bthResetForm = new javax.swing.JButton();
        rdocustomer = new javax.swing.JRadioButton();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Họ và tên:");

        jLabel3.setText("Email:");

        jLabel4.setText("Số điện thoại:");

        jLabel5.setText("Ngày Sinh:");

        jLabel6.setText("Tài Khoản:");

        jLabel7.setText("Mật Khẩu:");

        jLabel8.setText("Địa Chỉ:");

        jLabel9.setText("Vai Trò:");

        buttonGroup1.add(rdoadmin);
        rdoadmin.setSelected(true);
        rdoadmin.setText("ADMIN");

        buttonGroup1.add(rdoemployee);
        rdoemployee.setText("EMPLOYEE");

        bthadd.setBackground(new java.awt.Color(153, 204, 255));
        bthadd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bthadd.setText("Thêm Nhân Viên");
        bthadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthaddActionPerformed(evt);
            }
        });

        bthResetForm.setBackground(new java.awt.Color(153, 204, 255));
        bthResetForm.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bthResetForm.setText("Xóa From Thông Tin");
        bthResetForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthResetFormActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdocustomer);
        rdocustomer.setText("Customer ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(327, 327, 327)
                                .addComponent(jLabel5))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(309, 309, 309)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(txtdateofbirth, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(rdoadmin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdoemployee)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdocustomer))))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtemail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                                .addComponent(txtfullname, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(txtnumblephone, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bthadd, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bthResetForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfullname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdateofbirth, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnumblephone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoadmin)
                    .addComponent(rdoemployee)
                    .addComponent(rdocustomer))
                .addGap(45, 45, 45)
                .addComponent(bthadd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bthResetForm, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1007, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bthaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthaddActionPerformed
        User user = checkadd();
        if (user != null) {
            String address = txtaddress.getText();
            String numblephone = txtnumblephone.getText();
            nowDate = getCurrentDateTime();
            as.add_address(nowDate, address);
            boolean userS = us.add_user_all(user, nowDate, address);
            if (userS) {
                JOptionPane.showMessageDialog(this, "Thêm thành công !");
                String namerole = null;
                if (rdoadmin.isSelected()) {
                    namerole = "1";
                } else if (rdoemployee.isSelected()) {
                    namerole = "2";
                } else if (rdocustomer.isSelected()) {
                    namerole = "3";
                }
                urs.add_user_role(user, namerole);
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại !");
                as.delete_address(nowDate, address);
            }
        }
        reset();
    }//GEN-LAST:event_bthaddActionPerformed

    private void bthResetFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthResetFormActionPerformed
        reset();

    }//GEN-LAST:event_bthResetFormActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bthResetForm;
    private javax.swing.JButton bthadd;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton rdoadmin;
    private javax.swing.JRadioButton rdocustomer;
    private javax.swing.JRadioButton rdoemployee;
    private javax.swing.JTextField txtaccount;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtdateofbirth;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JTextField txtnumblephone;
    private javax.swing.JTextField txtpassword;
    // End of variables declaration//GEN-END:variables
}
