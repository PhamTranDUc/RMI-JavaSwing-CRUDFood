/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.LoaiMon;
import Client.MonAnJFrame;
import Entity.MonAn;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author phamduc
 */
public class LoaiMonDao {
    public Connect connection;
    
    public LoaiMonDao(){
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // Thay đổi các giá trị sau đây tùy thuộc vào cấu hình của bạn
//            String jdbcUrl = "jdbc:mysql://localhost:3306/laptrinhmang";
//            String username = "root";
//            String password = "123456";
//
//            // Kết ncategory_itemối đến MySQL Database
//            connection = DriverManager.getConnection(jdbcUrl, username, password);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        this.connection= new Connect();
    }
    
    public boolean addMenuItem(LoaiMon loaiMon){
        String sql="INSERT INTO category_food(code,name,description)"+" VALUES(?,?,?)";
       try{
           PreparedStatement  ps=  connection.getConnection().prepareStatement(sql);
           ps.setString(1, loaiMon.getCode());
           ps.setString(2, loaiMon.getName());
          ps.setString(3,loaiMon.getDescription() );
           return ps.executeUpdate() >0;
       }catch(Exception e){
           e.printStackTrace();
    }
       return false;
}
    public ArrayList<LoaiMon> getAllLoaiMon(){
        ArrayList<LoaiMon> list= new ArrayList<>();
        String sql= "SELECT * FROM category_food";
        try{
            PreparedStatement ps= connection.getConnection().prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                 LoaiMon loaiMon= new LoaiMon();
                 loaiMon.setCode(rs.getString("code"));
                 loaiMon.setName(rs.getString("name"));
                 loaiMon.setDescription(rs.getString("description"));
                 list.add(loaiMon);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
        
    }
    
    
    public static void main(String[] args){
        new LoaiMonDao();
    }
    
    public void update(String code,String name,String description){
         Connect c= new Connect();
        String sql="UPDATE category_food SET name='"+name+"', description = '"+description+"' WHERE code = '"+code+"'";
        try{
            PreparedStatement ps= c.getConnection().prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    



    
}
