/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author phamduc
 */
public class Connect {
    private Connection connection;
    
    public Connect(){
          try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Thay đổi các giá trị sau đây tùy thuộc vào cấu hình của bạn
            String jdbcUrl = "jdbc:mysql://localhost:3306/laptrinhmang2";
            String username = "root";
            String password = "123456";

            // Kết nối đến MySQL Database
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public  Connection getConnection(){
        return this.connection;
    }
    
}
