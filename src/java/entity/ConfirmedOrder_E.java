/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.BorrowOrder_E;

/**
 *
 * @author PC
 */
public class ConfirmedOrder_E extends BorrowOrder_E {
    
    private String LIB_C;

    public ConfirmedOrder_E(String IDO, String USN, String img, String Name, String Date, String LIB_C) {
        super(IDO, USN, img, Name, Date);
       
        this.LIB_C = LIB_C;
    }


    public String getLIB_C() {
        return LIB_C;
    }

    @Override
    public String toString() {
        return "ConfirmedOrder_E{" + super.toString() + ", LIB_C=" + LIB_C + '}';
    }
    
}
