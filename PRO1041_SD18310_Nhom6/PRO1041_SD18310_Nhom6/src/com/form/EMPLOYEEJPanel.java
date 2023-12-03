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
import com.model.User;
import com.model.UserRole;
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
public class EMPLOYEEJPanel extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private Validate vl = new Validate();
    private Date nowDate = null;
    private UserRoleService urs = new UserRoleImple();
    private UserService us = new UserImple();
    private AddressService as = new AddressImple();
    private boolean search = true;
    private boolean search0 = true;

    /**
     * Creates new form EMPLOYEEJPanel
     */
    public EMPLOYEEJPanel() {
        initComponents();
        datarowEmployee();
        datarowEmployee_0();
        txtaccount.setEditable(false);
        txtnumblephone.setEditable(false);
    }

    //đổ đữ liệu cho bảng NhanVien
    public void datarowEmployee() {
        tableModel = (DefaultTableModel) tblEmploee.getModel();
        tableModel.setRowCount(0);
        
        for (UserRole userRole : urs.getAll_Employee(String.valueOf("1"))) {
            tableModel.addRow(new Object[]{
                userRole.getUserId().getFullName(),
                userRole.getUserId().getEmail(),
                userRole.getUserId().getNumberPhone(),
                userRole.getUserId().getDateOfBirth(),
                userRole.getUserId().getAccount(),
                userRole.getUserId().getPassword(),
                userRole.getUserId().getAddressId().getAddressDetail(),
                userRole.getRoleId().getRoleName(),
                userRole.getUserId().checkTrangThai()
            });
        }

    }

    //đổ đữ liệu cho bảng XoaNhanVien
    public void datarowEmployee_0() {
        tableModel = (DefaultTableModel) tblEmployee_0.getModel();
        tableModel.setRowCount(0);
        for (UserRole userRole : urs.getAll_Employee(String.valueOf("0"))) {
            tableModel.addRow(new Object[]{
                userRole.getUserId().getFullName(),
                userRole.getUserId().getEmail(),
                userRole.getUserId().getNumberPhone(),
                userRole.getUserId().getDateOfBirth(),
                userRole.getUserId().getAccount(),
                userRole.getUserId().getPassword(),
                userRole.getUserId().getAddressId().getAddressDetail(),
                userRole.getRoleId().getRoleName(),
                userRole.getUserId().checkTrangThai()
            });
        }

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
    
    public void fillTableEmployee(int index) {
        UserRole ur = urs.getAll_Employee(String.valueOf("1")).get(index);
        txtfullname.setText(ur.getUserId().getFullName());
        txtemail.setText(ur.getUserId().getEmail());
        txtnumblephone.setText(ur.getUserId().getNumberPhone());
        txtdateofbirth.setText(String.valueOf(ur.getUserId().getDateOfBirth()));
        txtaccount.setText(ur.getUserId().getAccount());
        txtpassword.setText(ur.getUserId().getPassword());
        txtaddress.setText(ur.getUserId().getAddressId().getAddressDetail());
        if (ur.getRoleId().getRoleName().equalsIgnoreCase("ADMIN")) {
            rdoadmin.setSelected(true);
        } else {
            rdoemployee.setSelected(true);
        }
    }

    public void fillTableEmployeeSearch(int index, String name) {
        UserRole ur = urs.getSearch_Employee(String.valueOf("1"), name).get(index);
        txtfullname.setText(ur.getUserId().getFullName());
        txtemail.setText(ur.getUserId().getEmail());
        txtnumblephone.setText(ur.getUserId().getNumberPhone());
        txtdateofbirth.setText(String.valueOf(ur.getUserId().getDateOfBirth()));
        txtaccount.setText(ur.getUserId().getAccount());
        txtpassword.setText(ur.getUserId().getPassword());
        txtaddress.setText(ur.getUserId().getAddressId().getAddressDetail());
        if (ur.getRoleId().getRoleName().equalsIgnoreCase("ADMIN")) {
            rdoadmin.setSelected(true);
        } else {
            rdoemployee.setSelected(true);
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

    public User checkupdate() {
        User user = null;
        Date dateofbirth = checkDateOfBirch();
        String fullname = txtfullname.getText();
        String email = txtemail.getText();
        String numblephone = txtnumblephone.getText();
        String account = txtaccount.getText();
        String password = txtpassword.getText();
        String address = txtaddress.getText();
        nowDate = getCurrentDateTime();
        try {
            if (fullname.trim().isEmpty() || email.trim().isEmpty() || account.trim().isEmpty() || password.trim().isEmpty() || address.trim().isEmpty() || numblephone.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng không được để trống các ô nhập!");
                return null;
            } else if (!vl.isCheckName(fullname) || !vl.isCheckName(email) || !vl.isCheckName(account) || !vl.isCheckName(password)) {
                JOptionPane.showMessageDialog(this, "Vui lòng kí tự không được vượt quá 40 kí tự!");
                return null;
            } else if (!vl.isCheckTXT(address)) {
                JOptionPane.showMessageDialog(this, "Vui lòng kí tự không được vượt quá 100 kí tự!");
                return null;
            } else if (dateofbirth == null || !vl.isCheckPhone(numblephone)) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng kí tự của ngày sinh và số điện thoại!");
                return null;
            } else {
                return new User(null, nowDate, dateofbirth, null, null, nowDate, account, email, fullname, numblephone, password, String.valueOf(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui Lòng nhập lại!");
            return null;
        }
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmploee = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSearch1 = new javax.swing.JTextField();
        bthsearch1 = new javax.swing.JButton();
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
        bthUpdateEmployee = new javax.swing.JButton();
        bthResetForm = new javax.swing.JButton();
        BthRemoveStatus = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmployee_0 = new javax.swing.JTable();
        txtSearch0 = new javax.swing.JTextField();
        bthsearch0 = new javax.swing.JButton();
        bthKhoiPhuc = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        bthResetTable = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblEmploee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Họ Và Tên", "Email", "Số điện thoại", "Ngày Sinh", "Tài Khoản", "Mật Khẩu", "Địa Chỉ", "Vai Trò", "Trạng thái"
            }
        ));
        tblEmploee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmploeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmploee);

        jLabel1.setText("Tìm Kiếm");

        bthsearch1.setBackground(new java.awt.Color(204, 255, 255));
        bthsearch1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bthsearch1.setText("Tìm Kiếm");
        bthsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthsearch1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bthsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(0, 151, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bthsearch1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(txtSearch1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

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

        bthUpdateEmployee.setBackground(new java.awt.Color(153, 204, 255));
        bthUpdateEmployee.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bthUpdateEmployee.setText("Update Thông Tin Nhân Viên");
        bthUpdateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthUpdateEmployeeActionPerformed(evt);
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

        BthRemoveStatus.setBackground(new java.awt.Color(153, 204, 255));
        BthRemoveStatus.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BthRemoveStatus.setText("Xóa  Nhân Viên");
        BthRemoveStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BthRemoveStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfullname, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtemail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtnumblephone, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtdateofbirth, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtaccount, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtpassword, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtaddress, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BthRemoveStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(rdoadmin)
                                        .addGap(52, 52, 52)
                                        .addComponent(rdoemployee)))
                                .addGap(0, 179, Short.MAX_VALUE))
                            .addComponent(bthUpdateEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                            .addComponent(bthResetForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfullname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnumblephone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdateofbirth, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoadmin)
                    .addComponent(rdoemployee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bthUpdateEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bthResetForm, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BthRemoveStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh Sách Nhân Viên Đang Làm Việc", jPanel1);

        tblEmployee_0.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Họ Và Tên", "Email", "Số điện thoại", "Ngày Sinh", "Tài Khoản", "Mật Khẩu", "Địa Chỉ", "Vai Trò", "Trạng thái"
            }
        ));
        jScrollPane2.setViewportView(tblEmployee_0);

        bthsearch0.setBackground(new java.awt.Color(204, 255, 255));
        bthsearch0.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bthsearch0.setText("Tìm Kiếm");
        bthsearch0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthsearch0ActionPerformed(evt);
            }
        });

        bthKhoiPhuc.setBackground(new java.awt.Color(153, 204, 255));
        bthKhoiPhuc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bthKhoiPhuc.setText("Khôi Phục Nhân Viên");
        bthKhoiPhuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthKhoiPhucActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setText("Nhân Viên Đã Nghỉ Việc");

        bthResetTable.setBackground(new java.awt.Color(153, 204, 255));
        bthResetTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bthResetTable.setText("Reset Table");
        bthResetTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthResetTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(txtSearch0, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bthsearch0, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(bthKhoiPhuc, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bthResetTable, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 657, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch0, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bthsearch0, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bthKhoiPhuc, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bthResetTable, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh Sách Nhân Viên Đã Nghỉ Việc", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblEmploeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmploeeMouseClicked
        int index = tblEmploee.getSelectedRow();
        if (search == true) {
            fillTableEmployee(index);
        }
        if (search == false) {
            fillTableEmployeeSearch(index, txtSearch1.getText());
        }
    }//GEN-LAST:event_tblEmploeeMouseClicked

    private void bthResetFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthResetFormActionPerformed
        reset();
        datarowEmployee();
        datarowEmployee_0();
        search = true;
    }//GEN-LAST:event_bthResetFormActionPerformed

    private void bthUpdateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthUpdateEmployeeActionPerformed
        int index = tblEmploee.getSelectedRow();
        if (index >= 0) {
            if (search == true) {
                UserRole ur = urs.getAll_Employee(String.valueOf("1")).get(index);
                if (ur != null) {
                    User user = checkupdate();
                    if (user != null) {
                        String iduser = ur.getUserId().getId();
                        String idaddress = ur.getUserId().getAddressId().getId();
                        String addressdetail = txtaddress.getText();
                        as.update_address(nowDate, addressdetail, idaddress);
                        boolean userS = us.Update_user_all(user, iduser);
                        if (userS) {
                            JOptionPane.showMessageDialog(this, "Update thành công !");
                            String idrole = rdoadmin.isSelected() == true ? "1" : "2";
                            urs.Update_user_role(ur.getUserId(), idrole);
                        } else {
                            JOptionPane.showMessageDialog(this, "Update thất bại !");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Lỗi ");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi");
                }
            }
            if (search == false) {
                String name = txtSearch1.getText();
                UserRole ur = urs.getSearch_Employee(String.valueOf("1"), name).get(index);
                if (ur != null) {
                    User user = checkupdate();
                    if (user != null) {
                        String iduser = ur.getUserId().getId();
                        String idaddress = ur.getUserId().getAddressId().getId();
                        String addressdetail = txtaddress.getText();
                        as.update_address(nowDate, addressdetail, idaddress);
                        boolean userS = us.Update_user_all(user, iduser);
                        if (userS) {
                            JOptionPane.showMessageDialog(this, "Update thành công !");
                            String idrole = rdoadmin.isSelected() == true ? "1" : "2";
                            urs.Update_user_role(ur.getUserId(), idrole);
                        } else {
                            JOptionPane.showMessageDialog(this, "Update thất bại !");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Lỗi ");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhân viên nào ");
        }
        reset();
        datarowEmployee();
        search = true;
    }//GEN-LAST:event_bthUpdateEmployeeActionPerformed

    private void BthRemoveStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BthRemoveStatusActionPerformed
        int index = tblEmploee.getSelectedRow();
        if (index >= 0) {
            if (search == true) {
                UserRole ur = urs.getAll_Employee(String.valueOf("1")).get(index);
                if (ur != null) {
                    boolean userS = us.Update_status_user(String.valueOf("0"), ur.getUserId());
                    if (userS) {
                        JOptionPane.showMessageDialog(this, "Xóa thành công !");
                    } else {
                        JOptionPane.showMessageDialog(this, "Xóa thất bại !");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi ");
                }
            }
            if (search == false) {
                String name = txtSearch1.getText();
                UserRole ur = urs.getSearch_Employee(String.valueOf("1"), name).get(index);
                if (ur != null) {
                    boolean userS = us.Update_status_user(String.valueOf("0"), ur.getUserId());
                    if (userS) {
                        JOptionPane.showMessageDialog(this, "Xóa thành công !");
                    } else {
                        JOptionPane.showMessageDialog(this, "Xóa thất bại !");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi ");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhân viên nào ");
        }
        reset();
        datarowEmployee();
        datarowEmployee_0();
        search = true;
    }//GEN-LAST:event_BthRemoveStatusActionPerformed

    private void bthKhoiPhucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthKhoiPhucActionPerformed
        int index = tblEmployee_0.getSelectedRow();
        if (index >= 0) {
            if (search0 == true) {
                UserRole ur = urs.getAll_Employee(String.valueOf("0")).get(index);
                if (ur != null) {
                    boolean userS = us.Update_status_user(String.valueOf("1"), ur.getUserId());
                    if (userS) {
                        JOptionPane.showMessageDialog(this, "Khôi phục thành công !");
                    } else {
                        JOptionPane.showMessageDialog(this, "Khôi phục thất bại !");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi ");
                }
            }
            if (search0 == false) {
                String name = txtSearch1.getText();
                UserRole ur = urs.getSearch_Employee(String.valueOf("0"), name).get(index);
                if (ur != null) {
                    boolean userS = us.Update_status_user(String.valueOf("1"), ur.getUserId());
                    if (userS) {
                        JOptionPane.showMessageDialog(this, "Khôi phục thành công !");
                    } else {
                        JOptionPane.showMessageDialog(this, "Khôi phục thất bại !");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi ");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhân viên nào ");
        }
        reset();
        datarowEmployee();
        datarowEmployee_0();
        search = true;
    }//GEN-LAST:event_bthKhoiPhucActionPerformed

    private void bthsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthsearch1ActionPerformed
        String status = String.valueOf("1");
        String nameSearch = txtSearch1.getText();
        tableModel = (DefaultTableModel) tblEmploee.getModel();
        tableModel.setRowCount(0);
        for (UserRole userRole : urs.getSearch_Employee(status, nameSearch)) {
            tableModel.addRow(new Object[]{
                userRole.getUserId().getFullName(),
                userRole.getUserId().getEmail(),
                userRole.getUserId().getNumberPhone(),
                userRole.getUserId().getDateOfBirth(),
                userRole.getUserId().getAccount(),
                userRole.getUserId().getPassword(),
                userRole.getUserId().getAddressId().getAddressDetail(),
                userRole.getRoleId().getRoleName(),
                userRole.getUserId().checkTrangThai()
            });
        }
        search = false;
    }//GEN-LAST:event_bthsearch1ActionPerformed

    private void bthsearch0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthsearch0ActionPerformed
        String status = String.valueOf("0");
        String nameSearch = txtSearch0.getText();
        tableModel = (DefaultTableModel) tblEmployee_0.getModel();
        tableModel.setRowCount(0);
        for (UserRole userRole : urs.getSearch_Employee(status, nameSearch)) {
            tableModel.addRow(new Object[]{
                userRole.getUserId().getFullName(),
                userRole.getUserId().getEmail(),
                userRole.getUserId().getNumberPhone(),
                userRole.getUserId().getDateOfBirth(),
                userRole.getUserId().getAccount(),
                userRole.getUserId().getPassword(),
                userRole.getUserId().getAddressId().getAddressDetail(),
                userRole.getRoleId().getRoleName(),
                userRole.getUserId().checkTrangThai()
            });
        }
        search0 = false;
    }//GEN-LAST:event_bthsearch0ActionPerformed

    private void bthResetTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthResetTableActionPerformed
        datarowEmployee();
        datarowEmployee_0();
        search = true;
    }//GEN-LAST:event_bthResetTableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BthRemoveStatus;
    private javax.swing.JButton bthKhoiPhuc;
    private javax.swing.JButton bthResetForm;
    private javax.swing.JButton bthResetTable;
    private javax.swing.JButton bthUpdateEmployee;
    private javax.swing.JButton bthsearch0;
    private javax.swing.JButton bthsearch1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoadmin;
    private javax.swing.JRadioButton rdoemployee;
    private javax.swing.JTable tblEmploee;
    private javax.swing.JTable tblEmployee_0;
    private javax.swing.JTextField txtSearch0;
    private javax.swing.JTextField txtSearch1;
    private javax.swing.JTextField txtaccount;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtdateofbirth;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JTextField txtnumblephone;
    private javax.swing.JTextField txtpassword;
    // End of variables declaration//GEN-END:variables
}
