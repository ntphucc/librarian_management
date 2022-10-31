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
public class AccountUser_E {
    private String IDA;
    private String USN;
    private String USP;
    private String USM;

    public AccountUser_E(String IDA, String USN, String USP, String USM) {
        this.IDA = IDA;
        this.USN = USN;
        this.USP = USP;
        this.USM = USM;
    }

    public String getIDA() {
        return IDA;
    }

    public String getUSN() {
        return USN;
    }

    public String getUSP() {
        return USP;
    }

    public String getUSM() {
        return USM;
    }

    @Override
    public String toString() {
        return "AccountUser_E{" + "IDA=" + IDA + ", USN=" + USN + ", USP=" + USP + ", USM=" + USM + '}';
    }
    
    
    
    
}
