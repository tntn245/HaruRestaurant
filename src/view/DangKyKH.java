/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author My PC
 */
public class DangKyKH {
    public JLayeredPane pane_layer = new JLayeredPane();;
    private JPanel content_pane = new JPanel();
    private JLabel label_background = new JLabel();
    private JPanel pane_inf = new JPanel();
    private GridBagConstraints gbc = new GridBagConstraints();
    private Border newBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black);
    
    public JTextField HoTen_Text;
    public JTextField SDT_Text;
    public JTextField DiaChi_Text;
    public JTextField NgSinh_Text;
    // gioi tinh
    public JRadioButton Nam;
    public JRadioButton Nu;
    public ButtonGroup gender_group =new ButtonGroup(); 
    
    public JTextField TaiKhoan_Text;
    public JPasswordField MatKhau_Text;
    public JPasswordField Nhap_Lai_MatKhau_Text;
    
    public ButtonGradient btn_DangKy;
    public ButtonGradient btn_TroVe;
    
    private JOptionPane TenTK_jOptionPane = new JOptionPane();
    private JOptionPane ThongtinDK_jOptionPane = new JOptionPane();
    private JOptionPane SaiMK_jOptionPane = new JOptionPane();
    private JOptionPane DKthanhcong_jOptionPane = new JOptionPane();

    public DangKyKH(Connection connection) throws IOException{
        init();
        init_content_pane();
        pane_background();
        ActionDangKy(connection);
    }
    
    public void init(){
        pane_layer.setPreferredSize(new Dimension(900, 600));
        pane_layer.setVisible(true);
    }
    
    public void init_content_pane(){
        content_pane.setPreferredSize(new Dimension(900, 600));
        content_pane.setBackground( Color.white);
//        content_pane.setLayout(new GridBagLayout());
        content_pane.add(pane_inf());
//        content_pane.add(content_account());
    }
    
    public JPanel pane_inf(){
        pane_inf.setPreferredSize(new Dimension(800, 600));
        pane_inf.setBackground(Color.white);
        pane_inf.setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel HoTen =new JLabel("Họ và tên:");
        gbc.insets = new Insets(0, 0, 0, 0);
        HoTen.setFont(new Font("SansSerif", Font.PLAIN, 16));
        HoTen.setForeground(Color.black);
        pane_inf.add(HoTen, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;        
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 10, 0);
        HoTen_Text = new JTextField(25);
        HoTen_Text.setFont(new Font("SansSerif", Font.PLAIN, 16));
        HoTen_Text.setBorder(newBorder);
        pane_inf.add(HoTen_Text, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        JLabel SDT =new JLabel("Số điện thoại:");
        SDT.setBorder(new EmptyBorder(30, 0, 0,0));
        SDT.setFont(new Font("SansSerif", Font.PLAIN, 16));
        SDT.setForeground(Color.black);
        pane_inf.add(SDT, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;    
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 10, 0);
        SDT_Text = new JTextField(10);
        SDT_Text.setFont(new Font("SansSerif", Font.PLAIN, 16));
        SDT_Text.setBorder(newBorder);
        pane_inf.add(SDT_Text, gbc);       
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 0, 0);
        JLabel DiaChi =new JLabel("Địa chỉ:");
        DiaChi.setBorder(new EmptyBorder(30, 0, 0,0));
        DiaChi.setFont(new Font("SansSerif", Font.PLAIN, 16));
        DiaChi.setForeground(Color.black);
        pane_inf.add(DiaChi, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;        
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 10, 0);
        DiaChi_Text = new JTextField(25);
        DiaChi_Text.setFont(new Font("SansSerif", Font.PLAIN, 16));
        DiaChi_Text.setBorder(newBorder);
        pane_inf.add(DiaChi_Text, gbc);      

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(0, 0, 0, 0);
        JLabel NgSinh =new JLabel("Ngày sinh:");
        NgSinh.setBorder(new EmptyBorder(30, 0, 0,0));
        NgSinh.setFont(new Font("SansSerif", Font.PLAIN, 16));
        NgSinh.setForeground(Color.black);
        pane_inf.add(NgSinh, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 7;        
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 10, 0);
        NgSinh_Text = new JTextField(25);
        NgSinh_Text.setFont(new Font("SansSerif", Font.PLAIN, 16));
        NgSinh_Text.setBorder(newBorder);
        pane_inf.add(NgSinh_Text, gbc);     
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.insets = new Insets(0, 0, 0, 0);
        JLabel GioiTinh =new JLabel("Giới tính:");
        GioiTinh.setBorder(new EmptyBorder(30, 0, 0,0));
        GioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 16));
        GioiTinh.setForeground(Color.black);
        pane_inf.add(GioiTinh, gbc);       
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;        
        gbc.insets = new Insets(5, 0, 10, 0);
        Nam =new JRadioButton("Nam");
        Nam.setBounds(75,50,100,30);    
        Nam.setFont(new Font("SansSerif", Font.PLAIN, 16));
        Nam.setBackground(Color.white);
        gender_group.add(Nam);      
        pane_inf.add(Nam, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 9;     
        Nu =new JRadioButton("Nữ");
        Nu.setBounds(75,50,100,30);
        Nu.setFont(new Font("SansSerif", Font.PLAIN, 16));
        Nu.setBackground(Color.white);
        gender_group.add(Nu);      
        pane_inf.add(Nu, gbc); 

        setGap();
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/Picture10.png"));
        Image image = icon.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image);   
        JLabel img_avatar = new JLabel();
        img_avatar.setIcon(newIcon);
        img_avatar.setBounds(620, 50, 100, 100);
        pane_layer.add(img_avatar, new Integer(3));
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridheight = 1;        
        gbc.insets = new Insets(0, 0, 0, 0);
        JLabel TaiKhoan =new JLabel("Tên tài khoản:");
        TaiKhoan.setBorder(new EmptyBorder(30, 0, 0,0));
        TaiKhoan.setFont(new Font("SansSerif", Font.PLAIN, 16));
        TaiKhoan.setForeground(Color.black);
        pane_inf.add(TaiKhoan, gbc);
        
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 4;
        gbc.gridy = 3;        
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 10, 0);
        TaiKhoan_Text = new JTextField(25);
        TaiKhoan_Text.setFont(new Font("SansSerif", Font.PLAIN, 16));
        TaiKhoan_Text.setBorder(newBorder);
        pane_inf.add(TaiKhoan_Text, gbc); 
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 0, 0);
        JLabel MatKhau =new JLabel("Mật khẩu:");
        MatKhau.setBorder(new EmptyBorder(30, 0, 0,0));
        MatKhau.setFont(new Font("SansSerif", Font.PLAIN, 16));
        MatKhau.setForeground(Color.black);
        pane_inf.add(MatKhau, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 4;
        gbc.gridy = 5;      
        gbc.insets = new Insets(5, 0, 10, 0);
        MatKhau_Text = new JPasswordField(25);
        MatKhau_Text.setEchoChar('*');
        MatKhau_Text.setFont(new Font("SansSerif", Font.PLAIN, 16));
        MatKhau_Text.setBorder(newBorder);
        pane_inf.add(MatKhau_Text, gbc);          

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 4;
        gbc.gridy = 6;
        gbc.insets = new Insets(0, 0, 0, 0);
        TextGradient Nhap_Lai_MatKhau = new TextGradient("Nhập lại mật khẩu:", new Font("SansSerif", Font.BOLD, 18), new Color(40,173,253), new Color( 250, 87, 87), 0);
        Nhap_Lai_MatKhau.setPreferredSize(new Dimension(100, 30));
        Nhap_Lai_MatKhau.setBackground(Color.white);
//        JLabel Nhap_Lai_MatKhau =new JLabel("Nhập lại mật khẩu:");
//        Nhap_Lai_MatKhau.setBorder(new EmptyBorder(30, 0, 0,0));
//        Nhap_Lai_MatKhau.setFont(new Font("SansSerif", Font.PLAIN, 16));
//        Nhap_Lai_MatKhau.setForeground(Color.black);
        pane_inf.add(Nhap_Lai_MatKhau, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 4;
        gbc.gridy = 7;       
        gbc.insets = new Insets(5, 0, 10, 0);
        Nhap_Lai_MatKhau_Text = new JPasswordField(25);
        Nhap_Lai_MatKhau_Text.setEchoChar('*');
        Nhap_Lai_MatKhau_Text.setFont(new Font("SansSerif", Font.PLAIN, 16));
        Nhap_Lai_MatKhau_Text.setBorder(newBorder);
        pane_inf.add(Nhap_Lai_MatKhau_Text, gbc); 
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 4;
        gbc.gridy = 8;   
        gbc.gridheight = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        pane_inf.add(group_btn(), gbc);         
        
        return pane_inf;
    }

    public void Check_MK(){
        if(Nhap_Lai_MatKhau_Text.getPassword() == MatKhau_Text.getPassword()){
            System.out.println("dung pass");
        }
    }
    
    public void setGap(){
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 2;
        gbc.gridy = 0; 
        gbc.gridheight=10;
        gbc.gridwidth = 2;
        JPanel emp_pane = new JPanel();
        emp_pane.setBackground(Color.white);
        emp_pane.setPreferredSize(new Dimension(100, 20));
        pane_inf.add(emp_pane, gbc);
    }
  
    public JPanel group_btn(){
        JPanel pane_btn_DangKy = new JPanel();
        pane_btn_DangKy.setBackground(Color.white);
        pane_btn_DangKy.setBorder(new EmptyBorder(30, 0, 0,0));
        GridLayout layout = new GridLayout(1,2);
        layout.setHgap(30);
        pane_btn_DangKy.setLayout(layout);

        btn_DangKy = new ButtonGradient();
        btn_DangKy.setText("ĐĂNG KÝ");
        btn_DangKy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_DangKy.setFont(new Font("SansSerif", Font.PLAIN, 20));
       
        btn_TroVe = new ButtonGradient();
        btn_TroVe.setText("TRỞ VỀ");
        btn_TroVe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_TroVe.setFont(new Font("SansSerif", Font.PLAIN, 20));
                
        pane_btn_DangKy.add(btn_TroVe);
        pane_btn_DangKy.add(btn_DangKy);
        return pane_btn_DangKy;
    }
    
    public void pane_background(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/Picture8.png"));
        Image image = icon.getImage().getScaledInstance(924, 562, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image);   
        label_background = new JLabel();
        label_background.setIcon(newIcon);
    }
    
    public JLayeredPane set_pane(){
        content_pane.setBounds(0, 0, 900, 600);
        label_background.setBounds(0, 0, 900, 600);
        pane_layer.add(content_pane, new Integer(1));
        pane_layer.add(label_background, new Integer(2));
        return pane_layer;
    }

    private String GioiTinh_DangKy;
    public void ActionDangKy(Connection connection){
        Nam.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (Nam.isSelected()) {
                    GioiTinh_DangKy="Nam";
                }
            }
        });
        
        Nu.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (Nu.isSelected()) {
                    GioiTinh_DangKy="Nữ";
                }
            }
        });
        
        btn_DangKy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String HoTen = HoTen_Text.getText();
                String SDT = SDT_Text.getText();
                String DiaChi = DiaChi_Text.getText();
                String NgSinh = NgSinh_Text.getText();
                String TenTK = TaiKhoan_Text.getText();
                String MatKhau = MatKhau_Text.getText();
                String NhapLaiMK = Nhap_Lai_MatKhau_Text.getText();
                String LoaiTK = "Khách hàng";

                try {
                    Statement statement = connection.createStatement();
                    
                    if (HoTen.equals("") || SDT.equals("") || DiaChi.equals("") || NgSinh.equals("") || TenTK.equals("") || MatKhau.equals("") || NhapLaiMK.equals("")) {
                        ThongtinDK_jOptionPane.setVisible(true);
                        ThongtinDK_jOptionPane.showMessageDialog(pane_layer, "Vui lòng nhập đầy đủ thông tin!");
                        ThongtinDK_jOptionPane.setMessageType(JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        boolean flag_TK = false;
                        boolean flag_insertKH = false;
                        String sql= "SELECT * FROM TAIKHOAN WHERE TENTK = '" +TenTK+"'";
                        ResultSet res_select = statement.executeQuery(sql);
                        while(res_select.next())
                            flag_TK = true;
                        if(flag_TK){
                            TenTK_jOptionPane.setVisible(true);
                            TenTK_jOptionPane.showMessageDialog(pane_layer, "Tên tài khoản đã tồn tại. Mời bạn nhập tên tài khoản khác!");
                            TenTK_jOptionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
                        }
                        else if(!MatKhau.equals(NhapLaiMK)){
                            SaiMK_jOptionPane.setVisible(true);
                            SaiMK_jOptionPane.showMessageDialog(pane_layer, "Mật khẩu không đúng!");
                            SaiMK_jOptionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            sql = "INSERT INTO TAIKHOAN VALUES ( '" + TenTK + "', '" + MatKhau + "' , '" + LoaiTK + "' )";
                            int res = statement.executeUpdate(sql);
                            System.out.println("Insert thanh cong");
                            
                            sql = "INSERT INTO KHACHHANG VALUES (  '' , '" + HoTen + "', '" +GioiTinh_DangKy+ "' , '" + DiaChi + "' , TO_DATE('"+NgSinh+"', 'DD-MM-YYYY'), '" + SDT + "', '"+ TenTK + "' , 0 )";
                            res = statement.executeUpdate(sql);
                            System.out.println("Insert thanh cong");
                            DKthanhcong_jOptionPane.setVisible(true);
                            DKthanhcong_jOptionPane.showMessageDialog(pane_layer, "Đăng ký tài khoản thành công!");
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
