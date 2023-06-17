/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import style.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author My PC
 */
public class DangNhap{
    public JLayeredPane pane_layer;
    private JPanel pane_gradient;
    private JLabel label_image;
    
    public JPanel pane_login;
    private JPanel pane_DangNhap;
    private JPanel pane_account;
    private GridBagConstraints gbc;
    
    public JPasswordField MatKhau_Text;
    public JTextField TenTK_Text;
    public ButtonGradient btn_DangNhap;
    
    public JOptionPane SaiTK_jOptionPane = new JOptionPane();
    public JOptionPane ThieuThongTin_jOptionPane = new JOptionPane();
    
    public DangNhap() throws IOException{
        init();
    }
    
    public void init() throws IOException{ 
        pane_gradient();
        label_img();       

    }
    
    public void pane_gradient(){
        pane_gradient = new JPanelGradient(167,223,255, 255, 184, 183);
        pane_gradient.setPreferredSize(new Dimension(350, 600));
    }
    
    public void label_img() throws IOException{ 
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/—Pngtree—japan fuji mountain landscape illustration_4622958 - Cut.png"));
        Image image = icon.getImage().getScaledInstance(357, 534, java.awt.Image.SCALE_DEFAULT);
        ImageIcon newIcon = new ImageIcon(image); 
        
        label_image = new JLabel();
        label_image.setIcon(newIcon);
    }
    
    public JLayeredPane pane_background(){
        pane_layer = new JLayeredPane();
        label_image.setBounds(0, 0, 350, 600);
        pane_gradient.setBounds(0, 0, 350, 600);
        pane_layer.add(pane_gradient, new Integer(1));
        pane_layer.add(label_image, new Integer(2));
        return pane_layer;
    }
    
    public JPanel pane_login() throws IOException{
        pane_login = new JPanel();
        pane_login.setPreferredSize( new Dimension( 550, 600 ) );
        pane_login.setBackground(Color.white);
        pane_login.setLayout(new FlowLayout());
        account();
        return pane_login;
    }
    
    public void pane_DangNhap(){
        pane_DangNhap = new JPanel();
        pane_DangNhap.setBackground(Color.white);
        pane_DangNhap.setBorder(new EmptyBorder(60, 0, 00, 0));
        Font font = new Font("SansSerif", Font.BOLD, 28);
        TextGradient DangNhap = new TextGradient("ĐĂNG NHẬP", font, new Color(70,190,255), new Color( 255, 130, 130), -1);
        DangNhap.setBackground(Color.white);
        DangNhap.setPreferredSize(new Dimension(200, 50));
        pane_DangNhap.add(DangNhap);
        pane_login.add(pane_DangNhap);
    }
    
    public void init_pane_account(){
        pane_account = new JPanel();
        pane_account.setPreferredSize( new Dimension( 550, 600/2 ) );
        pane_account.setBackground(Color.white);        
        pane_account.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();  
    }
    
    public void account() throws IOException{
        pane_DangNhap();
        init_pane_account();
        
        //Create new Border for Text field
        Border newBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0; 
        gbc.insets = new Insets(0, 0, 5, 0);
        JLabel TenTK =new JLabel("Tên tài khoản:");
        TenTK.setFont(new Font("SansSerif", Font.PLAIN, 16));
        TenTK.setForeground(Color.black);
        pane_account.add(TenTK, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;        
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 10, 0);
        TenTK_Text = new JTextField(30);
        TenTK_Text.setSize(50,20);
        TenTK_Text.setFont(new Font("SansSerif", Font.PLAIN, 16));
        TenTK_Text.setBorder(newBorder);
        pane_account.add(TenTK_Text, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 0, 5, 0);
        JLabel MatKhau =new JLabel("Mật khẩu:");
        MatKhau.setFont(new Font("SansSerif", Font.PLAIN, 16));
        MatKhau.setForeground(Color.black);
        pane_account.add(MatKhau, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;        
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 10, 0);
        MatKhau_Text = new JPasswordField(30);
        MatKhau_Text.setEchoChar('*');
        MatKhau_Text.setFont(new Font("SansSerif", Font.PLAIN, 16));
        MatKhau_Text.setSize(50, 20);
        MatKhau_Text.setBorder(newBorder);
        pane_account.add(MatKhau_Text, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 0, 0);
        JLabel forget = new JLabel("Quên mật khẩu?");
        forget.setBorder(new EmptyBorder(10, 0, 0,0));
        forget.setFont(new Font("SansSerif", Font.PLAIN, 16));
        forget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JPanel pane_forget = new JPanel();
        pane_forget.setLayout( new FlowLayout(FlowLayout.RIGHT) );
        pane_forget.setBackground(Color.white);
        
        pane_account.add(pane_forget, gbc);
        
        pane_login.add(pane_account);
        btn_DangNhap();
        Slogan();
    }
    
    //Chen icon
    public JLayeredPane pane_TenTK_Text() throws IOException{
        JLayeredPane layer = new JLayeredPane();
        layer.setPreferredSize(new Dimension(100, 50));

        TenTK_Text = new JTextField(30);
        TenTK_Text.setSize(50,20);
        TenTK_Text.setFont(new Font("SansSerif", Font.PLAIN, 16));
        Border newBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black);
        TenTK_Text.setBorder(newBorder);
        
        JLabel label_icon = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/Github-Octicons-Person-16.512.png"));
        Image image = icon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_DEFAULT);
        ImageIcon newIcon = new ImageIcon(image);   
        label_icon = new JLabel();
        label_icon.setIcon(newIcon);    
        
        TenTK_Text.setBounds(0, 0, 1000, 20);
        label_icon.setBounds(360, -17, 50, 50);
        layer.add(TenTK_Text, new Integer(1));
        layer.add(label_icon, new Integer(2));
        return layer;
    }    

    public JLayeredPane pane_MatKhau_Text() throws IOException{
        JLayeredPane layer = new JLayeredPane();
        layer.setPreferredSize(new Dimension(100, 20));

        JTextField MatKhau_Text = new JTextField(30);
        MatKhau_Text.setFont(new Font("SansSerif", Font.PLAIN, 16));
        MatKhau_Text.setSize(50, 20);
        Border newBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black);
        MatKhau_Text.setBorder(newBorder);
        
        JLabel label_icon = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/Github-Octicons-Key-16.512.png"));
        Image img = icon.getImage();
        Image image = img.getScaledInstance(117/3, 103/3,  java.awt.Image.SCALE_DEFAULT);
        ImageIcon newIcon = new ImageIcon(image);   
        label_icon = new JLabel();
        label_icon.setIcon(newIcon);       
        
        MatKhau_Text.setBounds(0, 0, 1000, 20);
        label_icon.setBounds(360, -17, 50, 20);
        layer.add(MatKhau_Text, new Integer(1));
        layer.add(label_icon, new Integer(2));
        return layer;
    }            

    public void btn_DangNhap(){
        JPanel pane_btn_DangNhap = new JPanel();
        pane_btn_DangNhap.setPreferredSize( new Dimension( 550, 50 ) );
        pane_btn_DangNhap.setBackground(Color.white);

        btn_DangNhap = new ButtonGradient();
        btn_DangNhap.setText("ĐĂNG NHẬP");
        btn_DangNhap.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_DangNhap.setFont(new Font("SansSerif", Font.PLAIN, 20));
        pane_btn_DangNhap.add(btn_DangNhap);
        pane_login.add(pane_btn_DangNhap);
    }
    
    public void Slogan(){
        JLabel Text =new JLabel("There is no sincerer love than the love of food...");
        Text.setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        JPanel pane_Slogan = new JPanel();
        pane_Slogan.setBackground(Color.white);
        pane_Slogan.setBorder(new EmptyBorder(20, 0, 0,0));
        pane_Slogan.add(Text);
        
        pane_login.add(pane_Slogan);
    }
}
