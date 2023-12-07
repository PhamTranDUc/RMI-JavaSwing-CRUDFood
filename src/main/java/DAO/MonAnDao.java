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
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phamduc
 */
public class MonAnDao {
    private Connect connection;
    
    public MonAnDao(){
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // Thay đổi các giá trị sau đây tùy thuộc vào cấu hình của bạn
//            String jdbcUrl = "jdbc:mysql://localhost:3306/laptrinhmang";
//            String username = "root";
//            String password = "123456";
//
//            // Kết nối đến MySQL Database
//            connection = DriverManager.getConnection(jdbcUrl, username, password);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
       this.connection= new Connect();
    }
    
   public boolean addMenuItem(MonAn monAn){
    String sql = "INSERT INTO food(code, name, image, price, time, category) VALUES (?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement ps = connection.getConnection().prepareStatement(sql);
        LoaiMon category = monAn.getCategory();
        ps.setString(1, monAn.getCode());
        ps.setString(2, monAn.getName());

        if (MonAnJFrame.path2 != null && !MonAnJFrame.path2.isEmpty()) {
            InputStream is = new FileInputStream(new File(MonAnJFrame.path2));
            ps.setBlob(3, is);
        } else {
            ps.setBlob(3, (Blob) null);
        }

        ps.setDouble(4, monAn.getPrice());
        ps.setInt(5, monAn.getTime());
        ps.setString(6, category.getCode());
        System.out.println("Add new MonAn has code " + monAn.getCode());
        return ps.executeUpdate() > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

   public boolean updateMenuItem(MonAn monAn) {
    String sql;
    try {
        // Đường dẫn hình ảnh được truyền vào
        if (MonAnJFrame.path2 != null) {
            sql = "UPDATE food SET name=?, image=?, price=?, time=? ,category=? WHERE code=?";
            try (PreparedStatement ps = connection.getConnection().prepareStatement(sql)) {
                LoaiMon category = monAn.getCategory();
                ps.setString(1, monAn.getName());
                InputStream is = new FileInputStream(new File(MonAnJFrame.path2));
                ps.setBlob(2, is);
                ps.setDouble(3, monAn.getPrice());
                ps.setInt(4, monAn.getTime());
                ps.setString(5,category.getCode());
                ps.setString(6, monAn.getCode());
                System.out.println("Update MonAn has code " + monAn.getCode());
                return ps.executeUpdate() > 0;
            }
        } else {
            // Nếu không có đường dẫn hình ảnh, không thay đổi cột image trong câu SQL
            sql = "UPDATE food SET name=?, price=?, time=? ,category=? WHERE code=?";
            try (PreparedStatement ps = connection.getConnection().prepareStatement(sql)) {
                 LoaiMon category = monAn.getCategory();
                ps.setString(1, monAn.getName());
                ps.setDouble(2, monAn.getPrice());
                ps.setInt(3, monAn.getTime());
                ps.setString(4, category.getCode());
                ps.setString(5, monAn.getCode());
                System.out.println("Update MonAn has code " + monAn.getCode());
                return ps.executeUpdate() > 0;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

    
    public ArrayList<MonAn> getAllMonAn(){
        ArrayList<MonAn> list= new ArrayList<>();
        String sql= "SELECT * FROM food";
        try{
            PreparedStatement ps= connection.getConnection().prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                 MonAn mon= new MonAn();
                 mon.setCode(rs.getString("code"));
                 mon.setName(rs.getString("name"));
                 mon.setImage(rs.getBytes("image"));
                 mon.setPrice(rs.getDouble("price"));
                 mon.setTime(rs.getInt("time"));
                 String tmp=  rs.getString("category");
                 mon.setCategory(tmp);
                 list.add(mon);
            }
            System.out.println(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
        
    }
    
    public MonAn findByCode(String code){
        ArrayList<MonAn> list= new ArrayList<>();
        String sql= "SELECT * FROM food WHERE code='"+code+"'";
        try{
            PreparedStatement ps= connection.getConnection().prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                 MonAn mon= new MonAn();
                 mon.setCode(rs.getString("code"));
                 mon.setName(rs.getString("name"));
                 mon.setImage(rs.getBytes("image"));
                 mon.setPrice(rs.getDouble("price"));
                 mon.setTime(rs.getInt("time"));
                 mon.setCategory(rs.getString("category"));
                 list.add(mon);
            }
            System.out.println(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }
    public static void main(String[] args){
        new MonAnDao();
    }
    
    public ArrayList<MonAn> findByKeyWord(String keyWord){
        ArrayList<MonAn> listRs= new ArrayList<>();
          String sql = "SELECT * FROM food WHERE code LIKE ? OR name LIKE ?";
        try{
            PreparedStatement ps= connection.getConnection().prepareStatement(sql);
             ps.setString(1, "%" + keyWord + "%");
             ps.setString(2, "%" + keyWord + "%");
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                 MonAn mon= new MonAn();
                 mon.setCode(rs.getString("code"));
                 mon.setName(rs.getString("name"));
                 mon.setImage(rs.getBytes("image"));
                 mon.setPrice(rs.getDouble("price"));
                 mon.setTime(rs.getInt("time"));
                 var tmp= rs.getString("category");
                 mon.setCategory(tmp);
                 listRs.add(mon);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if(listRs.size()>0){
            return listRs;
        }
        listRs.clear();
        return listRs;
    }
    
     public ArrayList<MonAn> findByCategory(String keyWord){
        ArrayList<MonAn> listRs= new ArrayList<>();
          String sql = "SELECT * FROM food WHERE category = ?";
        try{
            PreparedStatement ps= connection.getConnection().prepareStatement(sql);
              ps.setString(1, keyWord);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                 MonAn mon= new MonAn();
                 mon.setCode(rs.getString("code"));
                 mon.setName(rs.getString("name"));
                 mon.setImage(rs.getBytes("image"));
                 mon.setPrice(rs.getDouble("price"));
                 mon.setTime(rs.getInt("time"));
                 var tmp= rs.getString("category");
                 mon.setCategory(tmp);
                 listRs.add(mon);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if(listRs.size()>0){
            return listRs;
        }
        listRs.clear();
         System.out.println(sql);
        return listRs;
    }
     
      public ArrayList<MonAn> findByTime(int index){
        ArrayList<MonAn> listRs= new ArrayList<>();
        String sql="";
        if(index==0){
            sql = "SELECT * FROM food";
        }
        if(index==1){
              sql = "SELECT * FROM food WHERE time = 1";
        }else if(index ==2){
             sql = "SELECT * FROM food WHERE time > 1 AND time < 15";
        }else if(index == 3){
             sql = "SELECT * FROM food WHERE time >= 15";
        }
        
          
        try{
            PreparedStatement ps= connection.getConnection().prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                 MonAn mon= new MonAn();
                 mon.setCode(rs.getString("code"));
                 mon.setName(rs.getString("name"));
                 mon.setImage(rs.getBytes("image"));
                 mon.setPrice(rs.getDouble("price"));
                 mon.setTime(rs.getInt("time"));
                 var tmp= rs.getString("category");
                 mon.setCategory(tmp);
                 listRs.add(mon);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if(listRs.size()>0){
            return listRs;
        }
        listRs.clear();
        return listRs;
    }
      
public void deleteMonAn(String code) {
    String sql = "DELETE FROM food WHERE code = ?";
    try {
        PreparedStatement ps = connection.getConnection().prepareStatement(sql);
        ps.setString(1, code);
        ps.executeUpdate();
        System.out.println("Deleted MonAn with code: " + code);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
