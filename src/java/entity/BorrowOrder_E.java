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
public class BorrowOrder_E {
    private String IDO;
    private String idBook;
    private String idAccount;
    private String USN;
    private String img;
    private String Name;
    private String Date;

    public BorrowOrder_E(String IDO, String USN, String img, String Name, String Date) {
        this.IDO = IDO;
        this.USN = USN;
        this.img = img;
        this.Name = Name;
        this.Date = Date;
    }

  

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }
    
    
    public String getIDO() {
        return IDO;
    }

    public String getUSN() {
        return USN;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return Name;
    }

    public String getDate() {
        return Date;
    }

    @Override
    public String toString() {
        return "BorrowOrder_E{" + "IDO=" + IDO + ", USN=" + USN + ", img=" + img + ", Name=" + Name + ", Date=" + Date + '}';
    }
    
    
}
