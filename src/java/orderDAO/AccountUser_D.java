/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderDAO;

import entity.AccountUser_E;
import entity.CompletedOrder_E;
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
public class AccountUser_D {

    Connection conn = null;  //kết nối với sql server
    PreparedStatement ps = null; // ném câu lệnh neatbean vào trong sql
    ResultSet rs = null; //nhận kết quả trả về

    public List<AccountUser_E> getAccountUser() {
        String query = "Select account_ID, USERNAME, PASSWORD, mail from Accounts where role_ID = 0";
        List<AccountUser_E> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AccountUser_E(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
}
