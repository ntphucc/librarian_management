/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Thanh Phuc
 */
public class DBContext {
    //      public String getImagePath() throws Exception{
    //          return "image/";
    //      }
    private final String serverName = "localhost";
    private final String dbName = "SWP391";
    private final String portNumber = "1433";
    private final String instance = "";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
    private final String userID = "sa";
    private final String password = "123456";

    public Connection getConnection() throws Exception{
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName;
        if(instance==null||instance.trim().isEmpty())
            url="jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url,userID,password);
        
    }
    public static void main(String[] args) {
         try {
            System.out.println(new DBContext().getConnection());
        } catch (Exception e) {
             System.err.println(e);
        }
    }

}
