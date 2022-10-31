/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import context.DBContext;
import entity.Account;
import entity.Author;
import entity.BookDetail;
import entity.BorrowOrder_E;
import entity.Publisher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vo Viet Nhan
 */
public class ProjectDAO {

    Connection conn = null;  //kết nối với sql server
    PreparedStatement ps = null; // ném câu lệnh neatbean vào trong sql
    ResultSet rs = null; //nhận kết quả trả về

    public List<BookDetail> searchByName(String txtName) {
        List<BookDetail> list = new ArrayList<>();
        String query = "select b.ID_book, img, book_name, a.author_name, b.language, b.type, p.publisher_name, b.amount\n"
                + "from Book b\n"
                + "inner join author a\n"
                + "on b.ID_author=a.ID_author\n"
                + "inner join Publisher p\n"
                + "on p.ID_publisher = b.ID_publisher\n"
                + "where b.book_name like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtName + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new BookDetail(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)                      
                ));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return list;
    }

    public BookDetail getBookByID(String id_book) {
        String query = "  select b.ID_book, img, book_name, a.author_name, b.language, b.type, p.publisher_name,publishing_year, b.amount\n"
                + "                from Book b,Author a,Publisher p\n"
                + "                where b.ID_book = ? and a.ID_author = b.ID_author and p.ID_publisher = b.ID_publisher";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id_book);
            rs = ps.executeQuery();

            while (rs.next()) {
                BookDetail book = new BookDetail(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9), 1
                );
                return book;
            }

        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public List<BookDetail> getDetailBook() {
        List<BookDetail> list = new ArrayList<>();
        String query = "select b.ID_book,img,book_name,a.author_name,b.language,b.type,p.publisher_name,b.amount,b.publishing_year \n"
                + "from Book b\n"
                + "inner join author a \n"
                + "on b.ID_author=a.ID_author\n"
                + "inner join Publisher p \n"
                + "on p.ID_publisher = b.ID_publisher\n"
                + "where b.avaiable =1 ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new BookDetail(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9), 1
                ));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return list;
    }

    public List<Author> authorCheck() {
        List<Author> list = new ArrayList<>();
        String query = "select * from author ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Author(rs.getString(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return list;
    }

    public void insertAuthor(String author_name) {
        String query = "insert into author (author_name) values (?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, author_name);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.print(e);
        }

    }

    public List<Publisher> publisherCheck() {
        List<Publisher> list = new ArrayList<>();
        String query = "select * from publisher ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Publisher(rs.getString(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return list;
    }

    public void insertPublisher(String publisher_name) {
        String query = "insert into publisher (publisher_name) values (?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, publisher_name);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.print(e);
        }

    }

    public void insertBook(String Id_publisher, String Id_author, String img, String book_name, String language, String type, String publishing_year, String amount, Boolean avaiable) {
        String query = "insert into book(ID_publisher,ID_author,img,book_name,language,type,amount,publishing_year,avaiable) values (?,?,?,?,?,?,?,?,?)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Id_publisher);
            ps.setString(2, Id_author);
            ps.setString(3, img);
            ps.setString(4, book_name);
            ps.setString(5, language);
            ps.setString(6, type);
            ps.setString(7, publishing_year);
            ps.setString(8, amount);
            ps.setBoolean(9, avaiable);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);

        }
    }

    public void deleteBook(String id) {
        String query = "UPDATE Book SET avaiable = 0 WHERE ID_book = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    public void updateBook(String id, String Id_author, String Id_publisher, String image, String name, String language, String type, String year, String amount) {
        String query = "update [book] set ID_author=?,ID_publisher=?,img=?,book_name=?,[language]=?,[type]=?,publishing_year=?,amount=?\n"
                + "where ID_book=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Id_author);
            ps.setString(2, Id_publisher);
            ps.setString(3, image);
            ps.setString(4, name);
            ps.setString(5, language);
            ps.setString(6, type);
            ps.setString(7, year);
            ps.setString(8, amount);
            ps.setString(9, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public Account login(String username, String password) {
        String query = "select * from Accounts"
                + " where USERNAME = ?"
                + " and PASSWORD = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8), rs.getString(9));
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return null;
    }

    public Account loginCheckExits(String username) {
        String query = "select * from Accounts"
                + " where USERNAME = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return null;
    }

    public void singup(String username, String mail, String password) {

        try {
            String query = "insert into Accounts(USERNAME,[mail],[PASSWORD]) "
                    + "values (?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, mail);
            ps.setString(3, password);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    public BorrowOrder_E insertOrder(String idBook, String idAccount, String Date) {
        try {
            String query = "  insert into Orders (ID_book,ID_account,date_create)\n"
                    + "  values (?,?,?); ";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idBook);
            ps.setString(2, idAccount);
            ps.setString(3, Date);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public Account getAccountDetail(String id) {
        try {
            String query = "select account_ID,fullname,phone,citizen_identity_card,[address],mail,[USERNAME],[PASSWORD] from Accounts where account_ID = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateUser(String id, String user, String pass, String name, String phone, String CMND, String address, String mail) {
        String query = "update Accounts set USERNAME=?,PASSWORD=?,fullName=?,phone=?,citizen_identity_card=?,address=?,mail=? where account_ID =?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, name);
            ps.setString(4, phone);
            ps.setString(5, CMND);
            ps.setString(6, address);
            ps.setString(7, mail);
            ps.setString(8, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void updateAmountBook(String idbook, int quantity) {
        String query = "update Book set amount = ((select amount where id_book =? ) - ?) where id_book=?";
        try {

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idbook);
            ps.setInt(2, quantity);
            ps.setString(3, idbook);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ProjectDAO dao = new ProjectDAO();
        List<BookDetail> list = dao.searchByName("ship");
        System.out.println(list);
    }
}
