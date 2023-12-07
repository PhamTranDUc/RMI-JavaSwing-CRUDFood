/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Entity.LoaiMon;
import DTO.MonAnDto;
import DAO.Connect;
import DAO.MonAnDao;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author phamduc
 */
public class MonAn extends UnicastRemoteObject implements MonAnInf{
    
    private String code;
    
    private String name;
    
    private  byte[] image;
    
    private Double price;
    
    private int time;
    
    private LoaiMon category;

    public MonAn() throws RemoteException{
    }

    public MonAn(String code, String name, Double price, int time,LoaiMon loaiMon) throws RemoteException{
        this.code = code;
        this.name = name;
       
        this.price = price;
        this.time = time;
        this.category= loaiMon;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return  this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public LoaiMon getCategory() {
        return this.category;
    }

    public void setCategory(LoaiMon category) {
        this.category = category;
    }
    
    public void setCategory(String category) throws RemoteException{
        this.category = new LoaiMon(category);
    }

    public MonAn(String code, String name, Double price, int time,String category) throws RemoteException{
        this.code = code;
        this.name = name;
        this.image = image;
        this.price = price;
        this.time = time;
        this.category=new LoaiMon(category);
    }

    @Override
    public ArrayList<MonAnDto> getAll() throws RemoteException {
        MonAnDao dao= new MonAnDao();
        ArrayList<MonAn> tmp= dao.getAllMonAn();
        ArrayList<MonAnDto> list= new ArrayList<>();
        for(MonAn a: tmp){
//            list.add(new MonAnDto(a.getCode(), a.getName(), a.getImage(), a.getPrice(), a.getTime(), a.getCategory()));
  list.add(new MonAnDto(a.getCode(), a.getName(), a.getImage(), a.getPrice(), a.getTime(),a.getCategory().getCode()));
                        

        }
         System.out.println("Selected all food");
        return list;
    }

    @Override
    public void save(String code,String name,Double price,int time,String nameCate) throws RemoteException {
        MonAnDao dao = new MonAnDao();
        
        MonAn mA= new MonAn(code,name,price,time,nameCate);
        dao.addMenuItem(mA);
        
    }

    @Override
    public void delete(String code) throws RemoteException {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          MonAnDao dao = new MonAnDao();
          dao.deleteMonAn(code);
          System.out.println("Delete MonAn has code "+code);
    }

    @Override
    public ArrayList<MonAnDto> getAllByCategory(String category) throws RemoteException {
        MonAnDao dao= new MonAnDao();
       ArrayList<MonAnDto> tmp1= new ArrayList<>();
       ArrayList<MonAn> list= dao.findByCategory(category);
       for(MonAn a: list){
           tmp1.add(new MonAnDto(a.getCode(), a.getName(), a.getImage(), a.getPrice(), a.getTime(),a.getCategory().getCode()));
       }
       System.out.println("Selected all food by category_food "+category);
       return tmp1;
        
    }

    @Override
    public ArrayList<MonAnDto> getAllByTime(int time) throws RemoteException {
       MonAnDao dao= new MonAnDao();
       ArrayList<MonAnDto> tmp1= new ArrayList<>();
       ArrayList<MonAn> list= dao.findByTime(time);
       for(MonAn a: list){
           tmp1.add(new MonAnDto(a.getCode(), a.getName(), a.getImage(), a.getPrice(), a.getTime(),a.getCategory().getCode()));
       }
       System.out.println("Selected all food by time "+ time);
       return tmp1;
    }

    @Override
    public MonAnDto findByCode(String tmp) throws RemoteException {
      MonAnDao dao = new MonAnDao();
      MonAn a= dao.findByCode(tmp);
      MonAnDto dto= new MonAnDto(a.getCode(), a.getName(), a.getImage(), a.getPrice(), a.getTime(),a.getCategory().getCode());
      return dto; 
    }

    @Override
    public void update(String code, String name, Double price, int time, String nameCate) throws RemoteException {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    MonAnDao dao = new MonAnDao();
        
        MonAn mA= new MonAn(code,name,price,time,nameCate);
        
        dao.updateMenuItem(mA);
        System.out.println("Update MonAn has code "+code);
    }

    @Override
    public ArrayList<MonAnDto> findByKeyWord(String key) throws RemoteException {
   //     throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          MonAnDao dao= new MonAnDao();
           ArrayList<MonAnDto> tmp1= new ArrayList<>();
       ArrayList<MonAn> list= dao.findByKeyWord(key);
       for(MonAn a: list){
           tmp1.add(new MonAnDto(a.getCode(), a.getName(), a.getImage(), a.getPrice(), a.getTime(),a.getCategory().getCode()));
       }
//       System.out.println("Selected all food by time "+ time);
       return tmp1;
    }
    
    
    
}
