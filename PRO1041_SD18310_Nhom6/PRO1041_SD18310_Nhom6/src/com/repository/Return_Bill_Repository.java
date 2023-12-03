package com.repository;

import com.model.ReturnBill;
import java.sql.ResultSet;

/**
 *
 * @author thiet
 */
public class Return_Bill_Repository {

    public boolean Insert(ReturnBill rb) {
        try {
            String sql = """
                         INSERT INTO return_bill (created_at, total_cost, bill_id, reason_description)
                         VALUES 
                         ('2023-11-04 10:00:00', '320000', '1','Hàng lỗi');
                         """;
            JDBCHelped.excuteUpdate(sql, rb.getCreatedAt(), rb.getBillId().getId(), rb.getReasonDescription());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //start linh dz
    public boolean insert(ReturnBill returnBill) {
        String query = "INSERT INTO return_bill(total_cost, bill_id, created_at, reason_description) VALUES (?,?,NOW(),?) ";
        try {
            JDBCHelped.excuteUpdate(query, returnBill.getTotalCost(), returnBill.getBillId().getId(), returnBill.getReasonDescription());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ReturnBill getByIdBill(String idBill) {
        String query = "select * from return_bill WHERE bill_id = ?";
        ReturnBill returnBill = null;
        try {
            ResultSet rs = JDBCHelped.executeQuery(query, idBill);
            if (rs.next()) {
                returnBill = new ReturnBill(rs.getBigDecimal(1), new BillRepository().getById(rs.getLong(2)), rs.getDate(3), rs.getString(4), rs.getDate(5), rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return returnBill;
    }
    
    public ReturnBill getById(String id) {
        String query = "select * from return_bill WHERE id = ?";
        ReturnBill returnBill = null;
        try {
            ResultSet rs = JDBCHelped.executeQuery(query, id);
            if (rs.next()) {
                returnBill = new ReturnBill(rs.getBigDecimal(1), new BillRepository().getById(rs.getLong(2)), rs.getDate(3), rs.getString(4), rs.getDate(5), rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return returnBill;
    }
    // end linh dz
}
