/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author phamduc
 */
public class MainFrame extends javax.swing.JFrame {
    private javax.swing.JButton btnQuanLyMonAn;
    private javax.swing.JButton btnQuanLyLoaiMon;
    
    

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý Món Ăn và Loại Món Ăn");

        // Tạo nút để chuyển đến JFrame quản lý Món Ăn
        btnQuanLyMonAn = new JButton("Quản lý Món Ăn");
        btnQuanLyMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnQuanLyMonAnActionPerformed(evt);
                } catch (RemoteException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Tạo nút để chuyển đến JFrame quản lý Loại Món Ăn
        btnQuanLyLoaiMon = new JButton("Quản lý Loại Món Ăn");
        btnQuanLyLoaiMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnQuanLyLoaiMonActionPerformed(evt);
                } catch (RemoteException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Tạo JPanel để chứa các nút
        JPanel panel = new JPanel();
        panel.add(btnQuanLyMonAn);
        panel.add(btnQuanLyLoaiMon);

        // Thêm JPanel vào JFrame
        getContentPane().add(panel);
        

        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void btnQuanLyMonAnActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {
        // Mở JFrame quản lý Món Ăn
        MonAnJFrame monAnFrame = new MonAnJFrame();
        monAnFrame.setVisible(true);
    }

    private void btnQuanLyLoaiMonActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {
        // Mở JFrame quản lý Loại Món Ăn
        LoaiMonAnJFrame loaiMonFrame = new LoaiMonAnJFrame();
        loaiMonFrame.setVisible(true);
    }

    public static void main(String args[]) {
        // Chạy ứng dụng
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}