package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBConnection {
    
    /*public static String ICSI518_DB_HOST = "localhost";
     public static String ICSI518_DB_PORT = "3306";
     public static String ICSI518_DB = "icsi518_hw2";
     public static String ICSI518_DB_USER = "icsi518";
     public static String ICSI518_DB_PASSWD = "secretICSI518";*/
    public static String ICSI518_DB_HOST = "localhost";
    public static String ICSI518_DB_PORT = "3306";
    public static String ICSI518_DB = "icsi518_hw4";
    public static String ICSI518_DB_USER = "icsi518";
    public static String ICSI518_DB_PASSWD = "secretICSI518";
    
    public static Connection createConnection()
    {
        Connection connection=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //connection = DriverManager.getConnection(db_url,userName, password);
            connection = DriverManager.getConnection("jdbc:mysql://" + ICSI518_DB_HOST + ":" + ICSI518_DB_PORT + "/" + ICSI518_DB,ICSI518_DB_USER, ICSI518_DB_PASSWD);
            System.out.println("Printing connection object "+connection);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return connection;
    }
    /*public static Connection connection;
     public static Connection createConnection()
     {
     try {
     MysqlDataSource db = new MysqlDataSource();
     db.setServerName(System.getenv("ICSI518_DB_HOST").toString());
     db.setPortNumber(Integer.parseInt(System.getenv("ICSI518_DB_PORT")));
     db.setDatabaseName(System.getenv("ICSI518_DB").toString());
     db.setUser(System.getenv("ICSI518_DB_USER").toString());
     db.setPassword(System.getenv("ICSI518_DB_PASSWD").toString());
     
     connection = db.getConnection();
     
     } catch (Exception e) {
     // TODO: handle exception
     e.printStackTrace();
     }
     
     return connection;
     }*/
    
}
