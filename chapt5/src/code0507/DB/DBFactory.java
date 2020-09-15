/**
 * 
 */
package code0507.DB;

/**
 * DBFactory.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
import java.sql.Connection;  
import java.sql.DriverManager;  
  
public class DBFactory {  
    public static Connection getDBConnection() {  
        Connection conn = null;  
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
            String url = "jdbc:mysql://localhost:3306/blogsystem";  
            String user = "root";  
            String password = "yourpass";  
            conn = DriverManager.getConnection(url, user, password);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return conn;  
    }  
}  