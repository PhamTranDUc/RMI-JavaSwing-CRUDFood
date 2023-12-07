/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Entity;

import DTO.MonAnDto;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author phamduc
 */
public interface MonAnInf extends Remote{
    public ArrayList<MonAnDto> getAll() throws RemoteException;
    public void save(String code,String name,Double price,int time,String nameCate) throws RemoteException;
    public void update(String code,String name,Double price,int time,String nameCate) throws RemoteException;        
    public void delete(String code) throws RemoteException;
    
    public ArrayList<MonAnDto> getAllByCategory(String category) throws RemoteException;
     public ArrayList<MonAnDto> getAllByTime(int time) throws RemoteException;
      public ArrayList<MonAnDto> findByKeyWord(String key) throws RemoteException;
     public MonAnDto findByCode(String code) throws RemoteException;
}
