/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Entity;

import Entity.LoaiMon;
import DTO.LoaiMonDto;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author phamduc
 */
public interface LoaiMonInf extends Remote{
     public ArrayList<LoaiMonDto> getAll() throws RemoteException;
    public void save(LoaiMon loaiMonAn) throws RemoteException;    
    public void delete(String code) throws RemoteException;
     public void update(String code,String name,String description) throws RemoteException;
     public LoaiMonDto findByCode(String code) throws RemoteException;
}
