/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderDAO;

import entity.BorrowOrder_E;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class BorrowOrder_D {

    Connection conn = null;  //kết nối với sql server
    PreparedStatement ps = null; // ném câu lệnh neatbean vào trong sql
    ResultSet rs = null; //nhận kết quả trả về

    public List<BorrowOrder_E> getBorrowOrder() {
        String query = "select O.ID_order, AC.USERNAME, B.img, B.book_name, O.date_create\n"
                + "from Orders O, Accounts AC, Book B\n"
                + "where O.status is null and AC.account_ID = O.ID_account and O.ID_book = B.ID_book";
        List<BorrowOrder_E> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new BorrowOrder_E(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void rejectOrder(String id,String name) {
        String query = "update [Orders] set status = N'reject', lib_confirm = ? where ID_order=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(2, id);
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
       
    }
    public void acceptOrder(String id,String name){
    String query = "update [Orders] set status = N'accept', lib_confirm = ? where ID_order=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(2, id);
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static void main(String[] args) {
//       DateTime date = new DateTime(to)

        BorrowOrder_D d = new BorrowOrder_D();
        d.acceptOrder("2009","Trần Văn Tới");

    }
}
