/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author PC
 */
public class CompletedOrder_E extends ConfirmedOrder_E {
    private String date_return;
    private String LIB_Get;

    public CompletedOrder_E(String IDO, String USN, String img, String Name, String Date, String LIB_C, String date_return, String LIB_Get) {
        super(IDO, USN, img, Name, Date, LIB_C);
        this.date_return = date_return;
        this.LIB_Get = LIB_Get;
    }

    public String getLIB_Get() {
        return LIB_Get;
    }

    public String getDate_return() {
        return date_return;
    }

    @Override
    public String toString() {
        return "CompletedOrder_E{" + super.toString() + "date_return=" + date_return + '}';
    }
    
    
}
