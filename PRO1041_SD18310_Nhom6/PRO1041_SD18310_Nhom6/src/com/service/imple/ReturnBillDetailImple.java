package com.service.imple;

import java.util.List;
import com.model.ReturnBillDetail;
import com.repository.ReturnBill_Detail_Repository;
import com.service.ReturnBillDetailService;

/**
 *
 * @author lenovo
 */
public class ReturnBillDetailImple implements ReturnBillDetailService {

    private ReturnBill_Detail_Repository returnBillDetailRepository = new ReturnBill_Detail_Repository();

    @Override
    public boolean insert(com.model.ReturnBillDetail returnBillDetail) {
        return returnBillDetailRepository.insert(returnBillDetail);
    }

    @Override
    public List<ReturnBillDetail> getAll() {
        return returnBillDetailRepository.getAll();
    }

    @Override
    public List<ReturnBillDetail> getByIdBill(String idBill) {
        return returnBillDetailRepository.getByIdBill(idBill);
    }

}
