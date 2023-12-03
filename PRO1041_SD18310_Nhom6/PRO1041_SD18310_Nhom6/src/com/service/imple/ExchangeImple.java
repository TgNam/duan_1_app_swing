/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.imple;

import java.util.ArrayList;
import com.model.ExchangeBill;
import com.repository.ExchangeRepository;
import com.service.ExchangeService;

/**
 *
 * @author thiet
 */
public class ExchangeImple implements ExchangeService{
    ExchangeRepository exr = new ExchangeRepository();
    @Override
    public ArrayList<ExchangeBill> getList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Insert(ExchangeBill ex) {
        if(exr.Insert(ex)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public ArrayList<ExchangeBill> getExchangeBills() {
        return exr.getExchangeBill();
    }
    
}
