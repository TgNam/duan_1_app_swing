/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repository;

import com.model.Address;
import com.model.Bill;
import com.model.User;
import com.model.Voucher;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class StatisticsRepository {

    public ArrayList<Bill> getBil_All() {
        ArrayList<Bill> list = new ArrayList<>();
        try {
            String sql = """
                         select db_levents.bill.id, 
                                             db_levents.user.full_name,
                                             db_levents.user.number_phone ,
                                             db_levents.bill.into_money,
                                             db_levents.bill.total_cost,
                                             db_levents.address.address_detail,
                                             db_levents.bill.created_at,
                                             db_levents.bill.delivery_date,
                                             db_levents.bill.updated_at,
                                             db_levents.bill.voucher_id,
                                             db_levents.bill.status
                                             from db_levents.bill
                                             left  join db_levents.user on db_levents.bill.user_id = db_levents.user.id
                                             left join db_levents.address on db_levents.bill.address_id = db_levents.address.id
                                             left join db_levents.user_role on db_levents.user.id = db_levents.user_role.user_id
                                             inner join db_levents.role on db_levents.user_role.role_id = db_levents.role.id
                                             where db_levents.bill.status = '3'
                         """;
            ResultSet rs = JDBCHelped.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String number_Phone = rs.getString(3);
                BigDecimal into_money = rs.getBigDecimal(4);
                BigDecimal total_cost = rs.getBigDecimal(5);
                String address_detail = rs.getString(6);
                Date created_at = rs.getDate(7);
                Date delivery_date = rs.getDate(8);
                Date updated_at = rs.getDate(9);
                String voucher = rs.getString(10);
                String status = rs.getString(11);
                Bill b;
                b = new Bill(into_money, total_cost, new Address(address_detail), created_at, delivery_date, id, updated_at, new User(name, number_Phone), new Voucher(voucher), status);
                list.add(b);
                ;
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Bill> getBil_Year() {
        ArrayList<Bill> list = new ArrayList<>();
        try {
            String sql = """
                     select db_levents.bill.id, 
                                         db_levents.user.full_name,
                                         db_levents.user.number_phone ,
                                         db_levents.bill.into_money,
                                         db_levents.bill.total_cost,
                                         db_levents.address.address_detail,
                                         db_levents.bill.created_at,
                                         db_levents.bill.delivery_date,
                                         db_levents.bill.updated_at,
                                         db_levents.bill.voucher_id,
                                         db_levents.bill.status
                                         from db_levents.bill
                                         left  join db_levents.user on db_levents.bill.user_id = db_levents.user.id
                                         left join db_levents.address on db_levents.bill.address_id = db_levents.address.id
                                         left join db_levents.user_role on db_levents.user.id = db_levents.user_role.user_id
                                         inner join db_levents.role on db_levents.user_role.role_id = db_levents.role.id
                                         where db_levents.bill.status = '3'
                                         AND YEAR(db_levents.bill.created_at) = YEAR(CURRENT_DATE());
                     """;

            ResultSet rs = JDBCHelped.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String number_Phone = rs.getString(3);
                BigDecimal into_money = rs.getBigDecimal(4);
                BigDecimal total_cost = rs.getBigDecimal(5);
                String address_detail = rs.getString(6);
                Date created_at = rs.getDate(7);
                Date delivery_date = rs.getDate(8);
                Date updated_at = rs.getDate(9);
                String voucher = rs.getString(10);
                String status = rs.getString(11);
                Bill b;
                b = new Bill(into_money, total_cost, new Address(address_detail), created_at, delivery_date, id, updated_at, new User(name, number_Phone), new Voucher(voucher), status);
                list.add(b);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Bill> getBil_Month(int month) {
        ArrayList<Bill> list = new ArrayList<>();
        try {
            String sql = """
                     select db_levents.bill.id, 
                                         db_levents.user.full_name,
                                         db_levents.user.number_phone ,
                                         db_levents.bill.into_money,
                                         db_levents.bill.total_cost,
                                         db_levents.address.address_detail,
                                         db_levents.bill.created_at,
                                         db_levents.bill.delivery_date,
                                         db_levents.bill.updated_at,
                                         db_levents.bill.voucher_id,
                                         db_levents.bill.status
                                         from db_levents.bill
                                         left  join db_levents.user on db_levents.bill.user_id = db_levents.user.id
                                         left join db_levents.address on db_levents.bill.address_id = db_levents.address.id
                                         left join db_levents.user_role on db_levents.user.id = db_levents.user_role.user_id
                                         inner join db_levents.role on db_levents.user_role.role_id = db_levents.role.id
                                         where db_levents.bill.status = '3'
                                         AND MONTH(db_levents.bill.created_at) = ? 
                                         AND YEAR(db_levents.bill.created_at) = YEAR(CURRENT_DATE());
                     """;

            // Sử dụng PreparedStatement để tránh tình trạng SQL injection
            try (PreparedStatement pstmt = JDBCHelped.getConnection().prepareStatement(sql)) {
                pstmt.setInt(1, month);

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String id = rs.getString(1);
                    String name = rs.getString(2);
                    String number_Phone = rs.getString(3);
                    BigDecimal into_money = rs.getBigDecimal(4);
                    BigDecimal total_cost = rs.getBigDecimal(5);
                    String address_detail = rs.getString(6);
                    Date created_at = rs.getDate(7);
                    Date delivery_date = rs.getDate(8);
                    Date updated_at = rs.getDate(9);
                    String voucher = rs.getString(10);
                    String status = rs.getString(11);
                    Bill b = new Bill(into_money, total_cost, new Address(address_detail), created_at, delivery_date, id, updated_at, new User(name, number_Phone), new Voucher(voucher), status);
                    list.add(b);
                }
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // BingChiLing is here
    // dùng cho lấy tất cả doanh thu
    public BigDecimal getSumIntoMoneyByStatus(int status1, int status2, int status3) {
        String query = "SELECT SUM(into_money)  FROM db_levents.bill where status in (?,?,?);";
        try {
            ResultSet rs = JDBCHelped.executeQuery(query, status1, status2, status3);
            if (rs != null && rs.next()) {
                return rs.getBigDecimal(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal getSumIntoMoneyByStatus(int status1, int status2, int status3, int year) {
        String query = "SELECT SUM(into_money)  FROM db_levents.bill where status in (?,?,?) and YEAR(created_at) = ?;";
        try {
            ResultSet rs = JDBCHelped.executeQuery(query, status1, status2, status3, year);
            if (rs != null && rs.next()) {
                return rs.getBigDecimal(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }

    // dùng cho lọc doanh thu
    public BigDecimal getSumIntoMoneyByStatus(int status1, int status2, int status3, int year, int month) {
        String query = "SELECT SUM(into_money)  FROM db_levents.bill where status in (?,?,?) and YEAR(created_at) = ? and MONTH(created_at) = ?;";
        try {
            ResultSet rs = JDBCHelped.executeQuery(query, status1, status2, status3, year, month);
            if (rs != null && rs.next()) {
                return rs.getBigDecimal(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }

    // dùng cho lọc bill trả hàng
    public BigDecimal getSumIntoMoneyByStatusAndUpdated(int status, int year, int month) {
        String query = "SELECT SUM(into_money) FROM db_levents.bill where status in (?,?,?) and YEAR(updated_at) = ? and MONTH(updated_at) = ?;";
        try {
            ResultSet rs = JDBCHelped.executeQuery(query, status, year, month);
            if (rs != null && rs.next()) {
                return rs.getBigDecimal(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal getSumIntoMoneyByStatusAndUpdated(int status, int year) {
        String query = "SELECT SUM(into_money) FROM db_levents.bill where status in (?) and YEAR(updated_at) = ?";
        try {
            ResultSet rs = JDBCHelped.executeQuery(query, status, year);
            if (rs != null && rs.next()) {
                return rs.getBigDecimal(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal getSumIntoMoneyByStatusAndYear(int status1, int status2, int status3, int year) {
        String query = "SELECT SUM(into_money)  FROM db_levents.bill where status in (?,?,?) and YEAR(created_at) = ? ;";
        try {
            ResultSet rs = JDBCHelped.executeQuery(query, status1, status2, status3, year);
            if (rs != null && rs.next()) {
                return rs.getBigDecimal(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }

    public String getQuantityBillByStatus(int status) {
        String query = "select COUNT(*) from db_levents.bill WHERE status = ?";
        try {
            ResultSet rs = JDBCHelped.executeQuery(query, status);
            if (rs != null && rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }

    public String getQuantityBillByStatus(int status, int year) {
        String query = "select COUNT(*) from db_levents.bill WHERE status = ? and YEAR(created_at) = ? ";
        try {
            ResultSet rs = JDBCHelped.executeQuery(query, status,year);
            if (rs != null && rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }

    public String getQuantityBillByStatus(int status, int year, int month) {
        String query = "select COUNT(*) from db_levents.bill WHERE status = ? and YEAR(created_at) = ? and MONTH(created_at) = ?";
        try {
            ResultSet rs = JDBCHelped.executeQuery(query, status,year, month);
            if (rs != null && rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }
    
    // end
}
