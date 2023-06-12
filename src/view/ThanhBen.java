/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author My PC
 */
public class ThanhBen {
    public JPanelGradient pane_gradient;
    public JButton btn_NhanVien;
    public JButton btn_HoaDon;
    public JButton btn_DatMon;
    public JButton btn_ThucDon;
    public JButton btn_Kho;
    public JButton btn_NCC;
    public JButton btn_ThongKe;
    public JButton btn_DangXuat;
    
    
    public JButton btn_Commit;

    public ThanhBen(){
        init();
    }
    
    public void set_QL(){
        btn_DatMon.setEnabled(true);
        btn_ThucDon.setEnabled(true);
        btn_Kho.setEnabled(true);
        btn_NCC.setEnabled(true);
        btn_NhanVien.setEnabled(true);
        btn_HoaDon.setEnabled(true);
        btn_ThongKe.setEnabled(true);
        btn_DangXuat.setEnabled(true);
    }
    
    public void set_KT(){
        btn_DatMon.setEnabled(false);
        btn_ThucDon.setEnabled(false);
        btn_Kho.setEnabled(false);
        btn_NCC.setEnabled(false);
        btn_NhanVien.setEnabled(false);
        
        btn_HoaDon.setEnabled(true);
        btn_ThongKe.setEnabled(true);
        btn_DangXuat.setEnabled(true);
    }
    
    public void set_Kho(){
        btn_DatMon.setEnabled(false);
        btn_ThucDon.setEnabled(false);
        btn_ThongKe.setEnabled(false);
        btn_NhanVien.setEnabled(false);
        btn_HoaDon.setEnabled(false);

        btn_NCC.setEnabled(true);
        btn_Kho.setEnabled(true);
        btn_DangXuat.setEnabled(true);
    }
    
    public void set_Bep(){
        btn_DatMon.setEnabled(true);
        btn_Kho.setEnabled(false);
        btn_NCC.setEnabled(false);
        btn_ThongKe.setEnabled(false);
        btn_NhanVien.setEnabled(false);
        
        btn_HoaDon.setEnabled(true);
        btn_ThucDon.setEnabled(true);
        btn_DangXuat.setEnabled(true);
    }
    
    public void init(){
        pane_gradient = new JPanelGradient(167,223,255, 255, 184, 183);
        pane_gradient.setPreferredSize(new Dimension(100, 600));  
        pane_gradient.setLayout(new java.awt.GridLayout(9, 1));
        btn_NhanVien();
        btn_HoaDon();
        btn_DatMon();
        btn_ThucDon();
        btn_NCC();
        btn_Kho();
        btn_ThongKe();
        btn_DangXuat();
        btn_Commit();
    }

    public void btn_Commit(){
        btn_Commit = new JButton ("COMMIT");
        btn_Commit.setOpaque(false);
        btn_Commit.setContentAreaFilled(false);
        btn_Commit.setFocusPainted(false);
        btn_Commit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Font newButtonFont=new Font(btn_Commit.getFont().getName(),Font.BOLD,btn_Commit.getFont().getSize());
        btn_Commit.setFont(newButtonFont);
        btn_Commit.setToolTipText("Commit dữ liệu");
        btn_Commit.setBorder(null);
        
        pane_gradient.add(btn_Commit);
        
        btn_Commit.setVisible(false);
    }
    
    public void btn_NhanVien(){    
        btn_NhanVien = new JButton ("NHÂN VIÊN");
        btn_NhanVien.setOpaque(false);
        btn_NhanVien.setContentAreaFilled(false);
        btn_NhanVien.setFocusPainted(false);
        btn_NhanVien.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Font newButtonFont=new Font(btn_NhanVien.getFont().getName(),Font.BOLD,btn_NhanVien.getFont().getSize());
        btn_NhanVien.setFont(newButtonFont);
        btn_NhanVien.setToolTipText("Hiển thị trang quản lý nhân viên");
        btn_NhanVien.setBorder(null);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/employee.png"));
        Image image = icon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_NhanVien.setIcon(newIcon);
        
        btn_NhanVien.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn_NhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
        
        btn_NhanVien.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                nhanVien_jButtonMouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                nhanVien_jButtonMouseExited(e);
            }
        });
        
        pane_gradient.add(btn_NhanVien);
    }

    public void btn_HoaDon(){
        btn_HoaDon = new JButton ("HÓA ĐƠN");
        btn_HoaDon.setOpaque(false);
        btn_HoaDon.setContentAreaFilled(false);
        btn_HoaDon.setFocusPainted(false);
        btn_HoaDon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Font newButtonFont=new Font(btn_HoaDon.getFont().getName(),Font.BOLD,btn_HoaDon.getFont().getSize());
        btn_HoaDon.setFont(newButtonFont);
        btn_HoaDon.setToolTipText("Hiển thị trang quản lý hóa đơn");
        btn_HoaDon.setBorder(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/image/bill.png"));
        Image image = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_HoaDon.setIcon(newIcon);
        
        btn_HoaDon.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn_HoaDon.setHorizontalTextPosition(SwingConstants.CENTER);
        
        btn_HoaDon.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                hoaDon_jButtonMouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                hoaDon_jButtonMouseExited(e);
            }
        });
        
        pane_gradient.add(btn_HoaDon);
    }
    
    public void btn_DatMon(){
        btn_DatMon = new JButton ("ĐẶT MÓN");
        btn_DatMon.setOpaque(false);
        btn_DatMon.setContentAreaFilled(false);
        btn_DatMon.setFocusPainted(false);
        btn_DatMon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Font newButtonFont=new Font(btn_DatMon.getFont().getName(),Font.BOLD,btn_DatMon.getFont().getSize());
        btn_DatMon.setFont(newButtonFont);
        btn_DatMon.setToolTipText("Hiển thị trang quản lý đặt món");
        btn_DatMon.setBorder(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/image/order-food.png"));
        Image image = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_DatMon.setIcon(newIcon);
        
        btn_DatMon.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn_DatMon.setHorizontalTextPosition(SwingConstants.CENTER);
        
        btn_DatMon.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                DatMon_jButtonMouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                DatMon_jButtonMouseExited(e);
            }
        });
        
        pane_gradient.add(btn_DatMon);
    }
    
    public void btn_ThucDon(){
        btn_ThucDon = new JButton ("THỰC ĐƠN");
        btn_ThucDon.setOpaque(false);
        btn_ThucDon.setContentAreaFilled(false);
        btn_ThucDon.setFocusPainted(false);
        btn_ThucDon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Font newButtonFont=new Font(btn_ThucDon.getFont().getName(),Font.BOLD,btn_ThucDon.getFont().getSize());
        btn_ThucDon.setFont(newButtonFont);
        btn_ThucDon.setToolTipText("Hiển thị trang quản lý thực đơn");
        btn_ThucDon.setBorder(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/image/menu.png"));
        Image image = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_ThucDon.setIcon(newIcon);
        
        btn_ThucDon.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn_ThucDon.setHorizontalTextPosition(SwingConstants.CENTER);
        
        btn_ThucDon.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                thucDon_jButtonMouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                thucDon_jButtonMouseExited(e);
            }
        });
        
        pane_gradient.add(btn_ThucDon);
    }
    
    public void btn_NCC(){
        btn_NCC = new JButton ("NHÀ CUNG CẤP");
        btn_NCC.setOpaque(false);
        btn_NCC.setContentAreaFilled(false);
        btn_NCC.setFocusPainted(false);
        btn_NCC.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Font newButtonFont=new Font(btn_NCC.getFont().getName(),Font.BOLD,btn_NCC.getFont().getSize());
        btn_NCC.setFont(newButtonFont);
        btn_NCC.setToolTipText("Hiển thị trang quản lý nhà cung cấp");
        btn_NCC.setBorder(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/image/wholesale.png"));
        Image image = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_NCC.setIcon(newIcon);
        
        btn_NCC.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn_NCC.setHorizontalTextPosition(SwingConstants.CENTER);
        
        btn_NCC.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                NCC_jButtonMouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                NCC_jButtonMouseExited(e);
            }
        });
        pane_gradient.add(btn_NCC);
    }

    public void btn_Kho(){
        btn_Kho = new JButton ("KHO");
        btn_Kho.setOpaque(false);
        btn_Kho.setContentAreaFilled(false);
        btn_Kho.setFocusPainted(false);
        btn_Kho.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Font newButtonFont=new Font(btn_Kho.getFont().getName(),Font.BOLD,btn_Kho.getFont().getSize());
        btn_Kho.setFont(newButtonFont);
        btn_Kho.setToolTipText("Hiển thị trang quản lý kho");
        btn_Kho.setBorder(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/image/cardboard.png"));
        Image image = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_Kho.setIcon(newIcon);
        
        btn_Kho.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn_Kho.setHorizontalTextPosition(SwingConstants.CENTER);
        
        btn_Kho.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                kho_jButtonMouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                kho_jButtonMouseExited(e);
            }
        });
        pane_gradient.add(btn_Kho);
    }
    
    public void btn_ThongKe(){
        btn_ThongKe = new JButton ("THỐNG KÊ");
        btn_ThongKe.setOpaque(false);
        btn_ThongKe.setContentAreaFilled(false);
        btn_ThongKe.setFocusPainted(false);
        btn_ThongKe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Font newButtonFont=new Font(btn_ThongKe.getFont().getName(),Font.BOLD,btn_ThongKe.getFont().getSize());
        btn_ThongKe.setFont(newButtonFont);
        btn_ThongKe.setToolTipText("Hiển thị trang báo cáo- thống kê");
        btn_ThongKe.setBorder(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/image/pngegg.png"));
        Image image = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_ThongKe.setIcon(newIcon);
        
        btn_ThongKe.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn_ThongKe.setHorizontalTextPosition(SwingConstants.CENTER);
        
        btn_ThongKe.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                thongke_jButtonMouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                thongke_jButtonMouseExited(e);
            }
        });
        pane_gradient.add(btn_ThongKe);
    }
        
    public void btn_DangXuat(){
        btn_DangXuat = new JButton();
        btn_DangXuat.setOpaque(false);
        btn_DangXuat.setContentAreaFilled(false);
        btn_DangXuat.setFocusPainted(false);
        btn_DangXuat.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Font newButtonFont=new Font(btn_DangXuat.getFont().getName(),Font.BOLD,btn_DangXuat.getFont().getSize());
        btn_DangXuat.setFont(newButtonFont);
        btn_DangXuat.setToolTipText("Quay trở lại giao diện đăng nhập");
        btn_DangXuat.setBorder(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/image/sign-out.png"));
        Image image = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_DangXuat.setIcon(newIcon);
        
        btn_DangXuat.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                dangxuat_jButtonMouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                dangxuat_jButtonMouseExited(e);
            }
        });
        pane_gradient.add(btn_DangXuat);
    }
    
    private void nhanVien_jButtonMouseEntered(java.awt.event.MouseEvent evt) {
        btn_NhanVien.setContentAreaFilled(true);
        btn_NhanVien.setBackground(Color.GRAY);
    }

    private void nhanVien_jButtonMouseExited(java.awt.event.MouseEvent evt) {
        btn_NhanVien.setContentAreaFilled(false);
    }

    private void hoaDon_jButtonMouseEntered(java.awt.event.MouseEvent evt) {
        btn_HoaDon.setContentAreaFilled(true);
        btn_HoaDon.setBackground(Color.GRAY);
    }

    private void hoaDon_jButtonMouseExited(java.awt.event.MouseEvent evt) {
        btn_HoaDon.setContentAreaFilled(false);
    }
        
    private void DatMon_jButtonMouseEntered(java.awt.event.MouseEvent evt) {
        btn_DatMon.setContentAreaFilled(true);
        btn_DatMon.setBackground(Color.GRAY);
    }

    private void DatMon_jButtonMouseExited(java.awt.event.MouseEvent evt) {
        btn_DatMon.setContentAreaFilled(false);
    }

    private void thucDon_jButtonMouseEntered(java.awt.event.MouseEvent evt) {
        btn_ThucDon.setContentAreaFilled(true);
        btn_ThucDon.setBackground(Color.GRAY);
    }

    private void thucDon_jButtonMouseExited(java.awt.event.MouseEvent evt) {
        btn_ThucDon.setContentAreaFilled(false);
    }

    private void kho_jButtonMouseEntered(java.awt.event.MouseEvent evt) {
        btn_Kho.setContentAreaFilled(true);
        btn_Kho.setBackground(Color.GRAY);
    }

    private void kho_jButtonMouseExited(java.awt.event.MouseEvent evt) {
        btn_Kho.setContentAreaFilled(false);
    }
    
    private void NCC_jButtonMouseEntered(java.awt.event.MouseEvent evt) {
        btn_NCC.setContentAreaFilled(true);
        btn_NCC.setBackground(Color.GRAY);
    }

    private void NCC_jButtonMouseExited(java.awt.event.MouseEvent evt) {
        btn_NCC.setContentAreaFilled(false);
    }
    
    private void thongke_jButtonMouseEntered(java.awt.event.MouseEvent evt) {
        btn_ThongKe.setContentAreaFilled(true);
        btn_ThongKe.setBackground(Color.GRAY);
    }

    private void thongke_jButtonMouseExited(java.awt.event.MouseEvent evt) {
        btn_ThongKe.setContentAreaFilled(false);
    }
        
    private void dangxuat_jButtonMouseEntered(java.awt.event.MouseEvent evt) {
        btn_DangXuat.setContentAreaFilled(true);
        btn_DangXuat.setBackground(Color.GRAY);
    }

    private void dangxuat_jButtonMouseExited(java.awt.event.MouseEvent evt) {
        btn_DangXuat.setContentAreaFilled(false);
    }
}
