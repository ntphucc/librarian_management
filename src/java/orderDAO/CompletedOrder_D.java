/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderDAO;

import entity.CompletedOrder_E;
import entity.ConfirmedOrder_E;
import context.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thanh Phuc
 */
public class CompletedOrder_D {

    Connection conn = null;  //kết nối với sql server
    PreparedStatement ps = null; // ném câu lệnh neatbean vào trong sql
    ResultSet rs = null; //nhận kết quả trả về

    public List<CompletedOrder_E> getCompletedOrder() {
        String query = "select O.ID_order, AC.USERNAME, B.img, B.book_name, O.date_create, O.lib_confirm, O.date_return, O.lib_return\n"
                + "                from Orders O, Accounts AC, Book B\n"
                + "                where O.status = 'done' and AC.account_ID = O.ID_account and O.ID_book = B.ID_book";
        List<CompletedOrder_E> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CompletedOrder_E(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
//       DateTime date = new DateTime(to)
//        System.out.println(java.time.LocalDate.now());
        CompletedOrder_D d = new CompletedOrder_D();
        List<CompletedOrder_E> list = d.getCompletedOrder();
        for (CompletedOrder_E borrowOrder_E : list) {
            System.out.println(borrowOrder_E.toString());
        }

    }

}
