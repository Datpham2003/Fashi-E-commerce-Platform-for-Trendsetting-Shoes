///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Utils;
//
//import java.io.Serializable;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBUtils implements Serializable {
//
//    private static final String DB_NAME = "SWP_G4_Project";
//    private static final String DB_USER_NAME = "sa";
//    private static final String DB_PASSWORD = "sa";
//
//    public static Connection getConnection() throws ClassNotFoundException, SQLException {
//        Connection conn = null;
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + DB_NAME;
//        conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
//        return conn;
//    }
//}
