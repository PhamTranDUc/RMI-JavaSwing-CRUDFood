/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import DTO.LoaiMonDto;
import DAO.Connect;
import DAO.LoaiMonDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author phamduc
 */
public class LoaiMon extends UnicastRemoteObject implements LoaiMonInf{
    private String code;
    private String name;
    private String description;

    public LoaiMon() throws RemoteException{
    }

    public LoaiMon(String code, String name, String description) throws RemoteException{
        this.code = code;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LoaiMon(String code) throws RemoteException{
        this.code = code;
    }

    @Override
    public ArrayList<LoaiMonDto> getAll() {
      
        LoaiMonDao dao= new LoaiMonDao();
         ArrayList<LoaiMonDto> list= new ArrayList<>();
        for(LoaiMon a: dao.getAllLoaiMon()){
            list.add(new LoaiMonDto(a.getCode(),a.getName(),a.getDescription()));
        }
      
         System.out.println("Selected all category_food");
        return list;
    }

    @Override
    public void save(LoaiMon loaiMonAn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(String code, String name, String description) throws RemoteException {
       LoaiMonDao dao= new LoaiMonDao();
       dao.update(code, name, description);
        System.out.println("Update LoaiMonAn has code "+code);
    }

    @Override
    public LoaiMonDto findByCode(String tmp) throws RemoteException {
        Connect c= new Connect();
        LoaiMonDto lm= new LoaiMonDto();
        String sql= "SELECT * FROM category_food WHERE code='"+ tmp+"'";
       try{
        PreparedStatement ps=  c.getConnection().prepareStatement(sql);
        ResultSet rs= ps.executeQuery(sql);
        if(rs.next()){
            String code= rs.getString("code");
            String name= rs.getString("name");
            String description= rs.getString("description");
          
            lm.setName(name);
            lm.setDescription(description);
            lm.setCode(code);
            
            System.out.println("SQL Query: " + sql);
        }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
        return  lm;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoaiMon other = (LoaiMon) obj;
        return Objects.equals(this.code, other.code);
    }
    
    
    
}
