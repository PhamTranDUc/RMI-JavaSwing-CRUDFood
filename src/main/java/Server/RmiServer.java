/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;


import Entity.MonAn;
import Entity.LoaiMon;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author phamduc
 */
public class RmiServer {
      public static void main(String[] args) throws RemoteException, MalformedURLException, MalformedURLException {
        LocateRegistry.createRegistry(1616);
        LocateRegistry.createRegistry(1617);
        //đăng ký đối tượng loaiMon
          LoaiMon loaiMon= new LoaiMon();
        Naming.rebind("rmi://localhost:1616/loaiMon", loaiMon);
        
         //đăng ký đối tượng monAn
         MonAn monAn= new MonAn();
         Naming.rebind("rmi://localhost:1617/monAn", monAn);
        System.out.println("Success");
    }
}
