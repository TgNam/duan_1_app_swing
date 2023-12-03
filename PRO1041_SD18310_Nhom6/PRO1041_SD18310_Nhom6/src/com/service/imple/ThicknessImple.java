/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.imple;

import java.util.ArrayList;
import com.model.Thickness;
import com.repository.ThicknessRepository;
import com.service.ThicknessService;

/**
 *
 * @author thiet
 */
public class ThicknessImple implements ThicknessService{
    ThicknessRepository t = new ThicknessRepository();
    @Override
    public ArrayList<Thickness> getAll() {
        return t.getListThikness();
    }

    @Override
    public boolean them(Thickness tk) {
        if(t.Insert(tk)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean sua(String id, Thickness tk) {
        if(t.Update(id, tk)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean xoa(String id) {
        if(t.Delete(id)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public ArrayList<Thickness> getThickness_sell(int min, int max) {
        return t.getThickness_sell(min, max);
    }
    
}
