/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.imple;

import java.util.ArrayList;
import com.model.ExchangeBillDetail;
import com.repository.Exchange_DetailRepository;
import com.service.Exchange_detailServict;

/**
 *
 * @author thiet
 */
public class Exchage_DetailImple implements Exchange_detailServict{
    Exchange_DetailRepository edr = new Exchange_DetailRepository();
    @Override
    public ArrayList<ExchangeBillDetail> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(ExchangeBillDetail ex) {
        if(edr.insert(ex)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public ArrayList<ExchangeBillDetail> getExchangeBillDetail(String id) {
        return edr.getExBill(id);
    }
    
}
