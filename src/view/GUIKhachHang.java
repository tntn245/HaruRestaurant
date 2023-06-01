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
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author My PC
 */
public class GUIKhachHang {
    public JPanel pane_bg;
    private JPanelGradient pane_gradient;
    private JButton btn_ThucDon;
    private ArrayList<JButton> btn_LoaiMon;
    private JPanel pane_list_ThucDon;

    private JButton btn_GioHang;
    private JTable table_GioHang;
    private JScrollPane Scrollpane_GioHang;
    private JPanel pane_TongTien_GioHang;
    private JLabel label_TongTien_GioHang;
    private JLabel label_SetTongTien_GioHang;
    
    private int Tien =0;
    private int old_SL = 0;
    private int new_Sl = 0;

    private JTable table_DaDat;
    private JScrollPane Scrollpane_DaDat;
    private JPanel pane_TongTien_DaDat;
    private JLabel label_TongTien_DaDat;
    private JLabel label_SetTongTien_DaDat;

    private ArrayList<JLabel> label_LoaiMon_list = new ArrayList<JLabel>();
    private ArrayList<ArrayList<JButton>> btn_MonAn_list = new ArrayList<ArrayList<JButton>>();  
    
    private JPanel pane_Search;
    private JButton btn_Search;
    private JComboBox boxSearch;
    private JTextField txtSearch;
    private JPanel pane_Search_txt_combobox = new JPanel();

    public JLabel label_SetSoHD;
    public JLabel label_SetSoBan;
    private JPanel pane_SoHD_SoBan;

    private JPanel pane_bg_ThucDon;
    private JScrollPane Scrollpane_ThucDon;
    private JPanel pane_ThucDon;

    private JPanel pane_bg_GioHang;
    private JTabbedPane tabbedPane;
    private JPanel pane_DaDat;
    private JPanel pane_GioHang;
    public ButtonGradient btn_DatMon;
    
    public JButton btn_DangXuat;

    private Connection connection;

    public GUIKhachHang(Connection connection) {
        this.connection = connection;
        init();
    }

    public void setSOHD(String SOBAN) {
        String MABAN = "BAN" + SOBAN;
        try {
            String sql_SOHD = "SELECT SOHD FROM HOADON WHERE MABAN = '" + MABAN + "' AND TINHTRANGTHANHTOAN = 0";
            Statement statement_SOHD = connection.createStatement();
            ResultSet res_SOHD = statement_SOHD.executeQuery(sql_SOHD);

            while (res_SOHD.next()) {
                String SOHD = res_SOHD.getString("SOHD");
                label_SetSoHD.setText(SOHD);
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println("the error is" + ex);
        }
    }

    public void setSOHD_login(String TENTK){
        String MABAN;
        try{
            String sql_MABAN = "SELECT MABAN FROM VITRI WHERE TENTK = '"+TENTK+"'";
            Statement statement_MABAN = connection.createStatement();
            ResultSet res_MABAN = statement_MABAN.executeQuery(sql_MABAN);
            
            while(res_MABAN.next()){
                MABAN = res_MABAN.getString("MABAN");  
                
                String sql_SOHD = "SELECT SOHD FROM HOADON WHERE MABAN = '" + MABAN + "' AND TINHTRANGTHANHTOAN = 0";
                Statement statement_SOHD = connection.createStatement();
                ResultSet res_SOHD = statement_SOHD.executeQuery(sql_SOHD);

                while (res_SOHD.next()) {
                    String SOHD = res_SOHD.getString("SOHD");
                    label_SetSoHD.setText(SOHD);
                }
            }
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is"+ex);
        }
    }
    
    public void setSOBAN(String MABAN){
        String SOBAN = MABAN.substring(3);
        label_SetSoBan.setText("Bàn " + SOBAN);        
    }
        
    public void init(){
        pane_bg = new JPanel();
        pane_bg.setPreferredSize(new Dimension(900, 600));  
        pane_bg.setLayout(new java.awt.BorderLayout());
        
        pane_list_ThucDon = new JPanel();
        pane_list_ThucDon.setOpaque(false);
        pane_list_ThucDon.setPreferredSize(new Dimension(200, 430));  
        
        pane_gradient = new JPanelGradient(167,223,255, 255, 184, 183);
        pane_gradient.setPreferredSize(new Dimension(200, 600));
        pane_gradient.add(pane_list_ThucDon);
        pane_gradient.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pane_bg.add(pane_gradient, BorderLayout.WEST);
                
        
        pane_bg_ThucDon = new JPanel();
        pane_bg_ThucDon.setLayout(new FlowLayout());
        pane_bg_ThucDon.setSize(new Dimension(700, 1));
        pane_bg_ThucDon.setBackground(Color.white);
        
        init_pane_ThucDon();
        search_bar();
        add_ThucDon();
        pane_bg.add(pane_bg_ThucDon, BorderLayout.CENTER);
        
        btn_ThucDon();
        list_btn_LMA();
        btn_GioHang();
        set_pane_GioHang();
        
        btn_DangXuat();
    }
    
    public void init_pane_ThucDon(){
        pane_ThucDon = new JPanel();
        pane_ThucDon.setLayout(new WrapLayout(FlowLayout.LEFT));
        pane_ThucDon.setSize(new Dimension(630, 1));
        pane_ThucDon.setBackground(Color.white);
        
        Scrollpane_ThucDon= new JScrollPane();
        Scrollpane_ThucDon.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scrollpane_ThucDon.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Scrollpane_ThucDon.setBorder(null); 
        //new LineBorder(Color.LIGHT_GRAY, 1, true)
        Scrollpane_ThucDon.setPreferredSize(new Dimension(630, 450));
    }
    
    public void btn_ThucDon(){
        btn_ThucDon = new JButton ("THỰC ĐƠN");
        btn_ThucDon.setOpaque(false);
        btn_ThucDon.setContentAreaFilled(false);
        btn_ThucDon.setFocusPainted(false);
        btn_ThucDon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Font newButtonFont=new Font(btn_ThucDon.getFont().getName(),Font.BOLD,16);
        btn_ThucDon.setFont(newButtonFont);
        btn_ThucDon.setToolTipText("Hiển thị toàn bộ thực đơn");
        btn_ThucDon.setBorder(null);
        btn_ThucDon.setPreferredSize(new Dimension(200, 60));

        ImageIcon icon = new ImageIcon(getClass().getResource("/image/menu.png"));
        Image image = icon.getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_ThucDon.setIcon(newIcon);
        
        btn_ThucDon.setVerticalTextPosition(SwingConstants.CENTER);
        btn_ThucDon.setHorizontalTextPosition(SwingConstants.RIGHT);
        
        btn_ThucDon.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                btn_ThucDon.setContentAreaFilled(true);
                btn_ThucDon.setBackground(Color.GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btn_ThucDon.setContentAreaFilled(false);
            }
        });
        
        btn_ThucDon.addActionListener(new ActionListener() {     
            @Override
            public void actionPerformed(ActionEvent e) {
                pane_Search_txt_combobox.setVisible(true);
                Scrollpane_ThucDon.setViewportView(pane_ThucDon);
                if (pane_bg_GioHang.isDisplayable()) {
                    pane_bg_GioHang.setVisible(false);
                    pane_bg_ThucDon.setVisible(true);
                }        
                pane_bg.add(pane_bg_ThucDon, BorderLayout.CENTER);
            }
        });
        
        pane_list_ThucDon.add(btn_ThucDon);
    }
        
    public void search_bar(){
        pane_Search = new JPanel();
        pane_Search.setBackground(Color.white);
        pane_Search.setPreferredSize(new Dimension(680, 70)); 
        pane_Search.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
        pane_search();
        label_SOHD_MABAN();
        pane_bg_ThucDon.add(pane_Search);
    }
    
    public void label_SOHD_MABAN(){
        pane_SoHD_SoBan = new JPanel();
        pane_SoHD_SoBan.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
//        pane_SoHD_SoBan.setPreferredSize(new java.awt.Dimension(125, 30));
        pane_SoHD_SoBan.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        
        label_SetSoHD = new JLabel();
        label_SetSoHD.setBackground(new java.awt.Color(130, 210, 255));
        label_SetSoHD.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        label_SetSoHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_SetSoHD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_SetSoHD.setText("HD");
        label_SetSoHD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_SetSoHD.setIconTextGap(0);
        label_SetSoHD.setOpaque(true);
        label_SetSoHD.setPreferredSize(new java.awt.Dimension(80, 30));
        label_SetSoHD.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pane_SoHD_SoBan.add(label_SetSoHD);

        label_SetSoBan = new JLabel();
        label_SetSoBan.setBackground(new java.awt.Color(225, 244, 255));
        label_SetSoBan.setForeground(new java.awt.Color(0, 102, 255));
        label_SetSoBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_SetSoBan.setText("Bàn");
        label_SetSoBan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_SetSoBan.setIconTextGap(0);
        label_SetSoBan.setOpaque(true);
        label_SetSoBan.setPreferredSize(new java.awt.Dimension(55, 30));
        pane_SoHD_SoBan.add(label_SetSoBan);
        
        pane_Search.add(pane_SoHD_SoBan);
    }
    
    public void pane_search(){
        pane_Search_txt_combobox = new JPanel();
        pane_Search_txt_combobox.setBackground(Color.white);
//        pane_Search_txt_combobox.setPreferredSize(new Dimension(400, 70)); 
        
        JPanel pane_search_bar = new JPanel();
        pane_search_bar.setBackground(Color.white );
        pane_search_bar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        txtSearch = new JTextField(" Search");
        txtSearch.setPreferredSize(new Dimension(30, 31)); 
        txtSearch.setColumns(24);     
        txtSearch.setForeground(Color.GRAY);
        txtSearch.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtSearch.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                txtSearch.setText("");
                txtSearch.setFont(new Font("SansSerif", Font.PLAIN, 14));
                txtSearch.setForeground(Color.BLACK);
            }
            public void focusLost(FocusEvent e) {
            }
        });
        
        btn_Search = new JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/search1.png"));
        Image image = icon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_Search.setIcon(newIcon);
        btn_Search.setBackground(Color.white);
        btn_Search.setPreferredSize(new Dimension(40, 31)); 
        btn_Search.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        pane_search_bar.add(txtSearch);
        pane_search_bar.add(btn_Search);
        
        String colname_NV[] = {"MAMON", "TENMON", "MALMA", "DONGIA"};
        boxSearch = new JComboBox(colname_NV);
        boxSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boxSearch.setSelectedItem("TENMON");
        boxSearch.setFont(new Font("SansSerif", Font.BOLD, 14));
        boxSearch.setBackground(Color.white);
        boxSearch.setPreferredSize(new Dimension(120, 35)); 

        Search();
        
        pane_search_bar.setBorder(txtSearch.getBorder());
        txtSearch.setBorder(null);
        btn_Search.setBorder(null);
        
        pane_Search_txt_combobox.add(pane_search_bar);
        pane_Search_txt_combobox.add(boxSearch);
        pane_Search.add(pane_Search_txt_combobox);
    }
    
    public void Search(){
        btn_Search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean flag = false;
                try{
                    String sql = "SELECT * FROM MONAN WHERE "
                    + boxSearch.getSelectedItem().toString() + " LIKE '%" + txtSearch.getText() + "%'";
                    Statement statement = connection.createStatement();
                    ResultSet res = statement.executeQuery(sql);
                    
                    //REMOVE ALL VÀ ADD MÓN VÀO
                    String text = txtSearch.getText();
                    if((!(text.equals(" Search"))) || (!(text.equals("")))){
                        for(int i=0;i<label_LoaiMon_list.size();i++){ 
                            label_LoaiMon_list.get(i).setVisible(false);
                            for(int j=0;j<btn_MonAn_list.get(i).size();j++){
                                btn_MonAn_list.get(i).get(j).setVisible(false);
                            }
                        }
                        while (res.next()) {
                            flag = true;
                            String TENMON = res.getString("TENMON");
                            search_ThucDon(TENMON);
                        }
                    }

                }
                catch(SQLException | HeadlessException ex){
                    System.out.println("the error is"+ex);
                }
                                
                if (!flag) {
                    JOptionPane search_jOptionPane = new JOptionPane();
                    search_jOptionPane.setVisible(true);
                    search_jOptionPane.showMessageDialog(pane_bg_ThucDon, "Không tìm thấy món ăn!");
                }
            }
        });
    }
    
    private void search_ThucDon(String TENMON){
        for(int i=0;i<label_LoaiMon_list.size();i++){ 
            label_LoaiMon_list.get(i).setVisible(true);
            for(int j=0;j<btn_MonAn_list.get(i).size();j++){
                String tenmon = btn_MonAn_list.get(i).get(j).getText();
                if(TENMON.equals(tenmon)){
                    btn_MonAn_list.get(i).get(j).setVisible(true);
                }  
            }
        }
    }
      
    private void add_ThucDon(){
        try {
            Statement statement = connection.createStatement();
            String sql_LOAIMONAN = "SELECT * FROM LOAIMONAN";
            ResultSet res_LOAIMONAN = statement.executeQuery(sql_LOAIMONAN);
            while (res_LOAIMONAN.next()) {
                String MALMA = res_LOAIMONAN.getString("MALMA");
                String TENLMA = res_LOAIMONAN.getString("TENLMA");
                
                JLabel label_temp = new JLabel(TENLMA);
                label_LoaiMon_list.add(label_temp);
                
                ArrayList<JButton> temp_btn_list = new ArrayList<JButton>();
                try {
                    Statement statement_MONAN = connection.createStatement();
                    String sql_MONAN = "SELECT * FROM MONAN WHERE MALMA = '" +MALMA+"'";
                    ResultSet res_MONAN = statement_MONAN.executeQuery(sql_MONAN);
                    while (res_MONAN.next()) {
                        String MAMON = res_MONAN.getString("MAMON");
                        String TENMON = res_MONAN.getString("TENMON");
                        String DONGIA = res_MONAN.getString("DONGIA");
                        String IMAGE = res_MONAN.getString("LINK_IMAGE");
                        int TINHTRANGMON = res_MONAN.getInt("TINHTRANG");
                        
                        JButton btn_temp = new JButton(TENMON);
                        if (TINHTRANGMON == 1) {
                            btn_temp.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            btn_temp.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e){
                                    ChonMonAn(MAMON, TENMON, DONGIA);
                                }
                            });
                        }
                        ImageIcon dishIcon = new ImageIcon(IMAGE);
                        Image dishImage = dishIcon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
                        ImageIcon scaledDishIcon = new ImageIcon(dishImage);
                        btn_temp.setIcon(scaledDishIcon);
                        btn_temp.setHorizontalTextPosition(CENTER);
                        btn_temp.setVerticalTextPosition(BOTTOM);
                        temp_btn_list.add(btn_temp);   
                    }
                    btn_MonAn_list.add(temp_btn_list);
                } catch (SQLException | HeadlessException ex) {
                    System.out.println("the error is" + ex);
                }
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println("the error is" + ex);
        }

        for(int i=0;i<label_LoaiMon_list.size();i++){
            label_LoaiMon_list.get(i).setPreferredSize(new Dimension(650, 50));
            label_LoaiMon_list.get(i).setFont(new java.awt.Font(label_LoaiMon_list.get(i).getFont().getName(), Font.BOLD, 14));
            label_LoaiMon_list.get(i).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            label_LoaiMon_list.get(i).setOpaque(true);
            if(i%2 ==0 )
                label_LoaiMon_list.get(i).setBackground(new Color(234,247,255));
            else
                label_LoaiMon_list.get(i).setBackground(new Color(255, 237, 243));
            pane_ThucDon.add(label_LoaiMon_list.get(i));
            System.out.println(label_LoaiMon_list.get(i).getText());    
            
            for(int j=0;j<btn_MonAn_list.get(i).size();j++){
                btn_MonAn_list.get(i).get(j).setPreferredSize(new Dimension(150, 150));
                pane_ThucDon.add(btn_MonAn_list.get(i).get(j));
                System.out.println(btn_MonAn_list.get(i).get(j).getText());    
            }
            System.out.println("-----------------------------------------");    
        }
        
        Scrollpane_ThucDon.setViewportView(pane_ThucDon);
        pane_bg_ThucDon.add(Scrollpane_ThucDon);
    }
    
    public void list_btn_LMA(){
        JScrollPane Scrollpane_LMA = new JScrollPane();
        JPanel pane_LMA = new JPanel();
        pane_LMA.setLayout(new WrapLayout(FlowLayout.RIGHT));
        pane_LMA.setOpaque(false);
        pane_LMA.setSize(new Dimension(150, 1));

        btn_LoaiMon = new ArrayList<JButton>();
        try {
            Statement statement = connection.createStatement();
            String sql_LOAIMONAN = "SELECT * FROM LOAIMONAN";
            ResultSet res_LOAIMONAN = statement.executeQuery(sql_LOAIMONAN);
            while (res_LOAIMONAN.next()) {
                String MALMA = res_LOAIMONAN.getString("MALMA");
                String TENLMA = res_LOAIMONAN.getString("TENLMA");
                
                JButton btn_temp = new JButton(TENLMA);
                btn_temp.setOpaque(false);
                btn_temp.setContentAreaFilled(false);
                btn_temp.setFocusPainted(false);
                btn_temp.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn_temp.setBorder(null);
                btn_temp.setPreferredSize(new Dimension(200, 50));

                btn_temp.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btn_temp.setContentAreaFilled(true);
                        btn_temp.setBackground(Color.GRAY);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        btn_temp.setContentAreaFilled(false);
                    }
                });

                btn_temp.addActionListener(new ActionListener() {     
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        pane_Search_txt_combobox.setVisible(false);
                        add_MonAn(MALMA);
                        if (pane_bg_GioHang.isDisplayable()) {
                            pane_bg_GioHang.setVisible(false);
                            pane_bg_ThucDon.setVisible(true);
                        }
                        pane_bg.add(pane_bg_ThucDon, BorderLayout.CENTER);
                    }
                });
                        
                btn_LoaiMon.add(btn_temp);
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println("the error is" + ex);
        }

        for(int i=0;i<btn_LoaiMon.size();i++){
            btn_LoaiMon.get(i).setFont(new java.awt.Font(btn_LoaiMon.get(i).getFont().getName(), Font.PLAIN, 14));
            btn_LoaiMon.get(i).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            pane_LMA.add(btn_LoaiMon.get(i));
        }
        
        Scrollpane_LMA.setViewportView(pane_LMA);
        Scrollpane_LMA.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scrollpane_LMA.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        Scrollpane_LMA.setBorder(null); 
        Scrollpane_LMA.setOpaque(false);
        Scrollpane_LMA.getViewport().setOpaque(false);
        Scrollpane_LMA.setPreferredSize(new Dimension(200, 380));  
        
        pane_list_ThucDon.add(Scrollpane_LMA);
    }
    
    private void add_MonAn(String MALMA){
        ArrayList<JButton> btn_MonAn_list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM MONAN WHERE MALMA = '"+MALMA+"'";
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                String MAMON = res.getString("MAMON");
                String TENMON = res.getString("TENMON");
                String DONGIA = res.getString("DONGIA");
                
                JButton btn_temp = new JButton(TENMON);
                btn_temp.setPreferredSize(new Dimension(150, 150));
                btn_temp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ChonMonAn(MAMON, TENMON, DONGIA);
                    }
                });
                btn_MonAn_list.add(btn_temp); 
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println("the error is" + ex);
        }
        
        JPanel pane_temp = new JPanel();
        pane_temp.setLayout(new WrapLayout(FlowLayout.LEFT));
        pane_temp.setSize(new Dimension(630, 1));
        pane_temp.setBackground(Color.white);

        for (int i = 0; i < btn_MonAn_list.size(); i++) {
            pane_temp.add(btn_MonAn_list.get(i));
            System.out.println(btn_MonAn_list.get(i).getText());
        }
        Scrollpane_ThucDon.setViewportView(pane_temp);
    }
    
    private void ChonMonAn(String MAMON, String TENMON, String DONGIA){
        DefaultTableModel tbmodel = (DefaultTableModel) table_GioHang.getModel();
        boolean flagTonTai = false;
        JOptionPane ChonMon_joption= new JOptionPane();
        
        for(int row=0; row<table_GioHang.getRowCount(); row++){
            Object mamon = table_GioHang.getValueAt(row, 0);
            String Strsl = table_GioHang.getValueAt(row, 3).toString();
            int sl = Integer.parseInt(Strsl);
            String StrMaMon = mamon.toString();
            if(StrMaMon.equals(MAMON)){
                flagTonTai = true;
                sl = sl+1;
                tbmodel.setValueAt(sl, row, 3);
                break;
            }
        }
        if(!flagTonTai){        
            Object new_tbdata[] = {MAMON, TENMON, DONGIA, 1};
            tbmodel.addRow(new_tbdata);
        }
        ChonMon_joption.setVisible(true);
        ChonMon_joption.showMessageDialog(pane_bg_ThucDon, "Thêm món ăn thành công.");
    }

    private void btn_GioHang(){
        btn_GioHang = new JButton("GIỎ HÀNG");
        btn_GioHang.setOpaque(false);
        btn_GioHang.setContentAreaFilled(false);
        btn_GioHang.setFocusPainted(false);
        btn_GioHang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Font newButtonFont=new Font(btn_GioHang.getFont().getName(),Font.BOLD,16);
        btn_GioHang.setFont(newButtonFont);
        btn_GioHang.setToolTipText("Hiển thị giỏ hàng");
        btn_GioHang.setBorder(null);
        btn_GioHang.setPreferredSize(new Dimension(200, 60));

        ImageIcon icon = new ImageIcon(getClass().getResource("/image/shopping-cart.png"));
        Image image = icon.getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_GioHang.setIcon(newIcon);
        
        btn_GioHang.setVerticalTextPosition(SwingConstants.CENTER);
        btn_GioHang.setHorizontalTextPosition(SwingConstants.RIGHT);
        
        btn_GioHang.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                btn_GioHang.setContentAreaFilled(true);
                btn_GioHang.setBackground(Color.GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btn_GioHang.setContentAreaFilled(false);
            }
        });
        
        btn_GioHang.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setTongTien_GioHang();
                if (pane_bg_ThucDon.isDisplayable()) {
                    pane_bg_ThucDon.setVisible(false);
                    pane_bg_GioHang.setVisible(true);
                }        
                pane_bg.add(pane_bg_GioHang, BorderLayout.CENTER);
            }
        });
        
        pane_gradient.add(btn_GioHang);
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
        btn_DangXuat.setPreferredSize(new Dimension(200, 60));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/sign-out.png"));
        Image image = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_DangXuat.setIcon(newIcon);
        
        btn_DangXuat.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                btn_DangXuat.setContentAreaFilled(true);
                btn_DangXuat.setBackground(Color.GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btn_DangXuat.setContentAreaFilled(false);
            }
        });
        pane_gradient.add(btn_DangXuat);
    }

    private void init_GioHang(){
        pane_bg_GioHang = new JPanel();
        pane_bg_GioHang.setLayout(new FlowLayout());
        pane_bg_GioHang.setSize(new Dimension(650, 1));
        pane_bg_GioHang.setBackground(Color.white);
        
        pane_GioHang = new JPanel();
        pane_GioHang.setSize(new Dimension(650, 550));
        pane_GioHang.setBackground(Color.white);
        
        pane_DaDat = new JPanel();
        pane_DaDat.setSize(new Dimension(650, 550));
        pane_DaDat.setBackground(Color.white);
        
        btn_DatMon = new ButtonGradient();
        btn_DatMon.setText("ĐẶT MÓN");
        btn_DatMon.setPreferredSize(new Dimension(650, 50));
        btn_DatMon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_DatMon.setFont(new Font(btn_DatMon.getFont().getName(),Font.BOLD,18));
        
        btn_DatMon.setVerticalTextPosition(SwingConstants.CENTER);
        btn_DatMon.setHorizontalTextPosition(SwingConstants.RIGHT);
        btn_DatMon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DatMon(label_SetSoHD.getText());
            }
        });
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(650, 550));
        tabbedPane.add("Giỏ hàng hiện tại", pane_GioHang);
        tabbedPane.add("Đơn hàng đã đặt", pane_DaDat);
        tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                System.out.println("Tab: " + tabbedPane.getSelectedIndex());
                if(tabbedPane.getSelectedIndex() == 1){
                    add_data_DonDat(label_SetSoHD.getText());
                    setTongTien_DonDat(label_SetSoHD.getText());
                }
            }
        });
        
        pane_bg_GioHang.add(tabbedPane);
    }
    
    private int row;
    private void pane_GioHang(){
        pane_TongTien_GioHang = new JPanel();
        pane_TongTien_GioHang.setBackground(Color.white);
        pane_TongTien_GioHang.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 5));
        pane_TongTien_GioHang.setPreferredSize(new Dimension(650, 25));
        label_TongTien_GioHang= new JLabel("TỔNG TIỀN: ");
        label_TongTien_GioHang.setFont(new Font(label_TongTien_GioHang.getFont().getName(),Font.BOLD,14));
        label_SetTongTien_GioHang= new JLabel("");
        label_SetTongTien_GioHang.setFont(new Font(label_TongTien_GioHang.getFont().getName(),Font.BOLD,14));
        pane_TongTien_GioHang.add(label_TongTien_GioHang);
        pane_TongTien_GioHang.add(label_SetTongTien_GioHang);
        
        String[] columnNames = {"Mã món", "Tên món", "Đơn giá", "Số lượng", ""};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };
            
            @Override
            public boolean isCellEditable(int row, int column) {
               return canEdit [column];
            }
        };
        table_GioHang = new JTable(model);
        table_GioHang.setRowHeight(40);
        table_GioHang.setFont(new Font(table_GioHang.getFont().getName(), Font.PLAIN, 14));
        table_GioHang.setShowGrid(false);
        table_GioHang.setShowHorizontalLines(true);
        table_GioHang.setSelectionBackground(new Color(167,223,255));//, 255, 184, 183

        TableColumnModel tcm = table_GioHang.getColumnModel();
        TableColumn tc = tcm.getColumn(3);
        tc.setCellEditor(new SpinnerEditor(1));
        
        table_GioHang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                old_SL = Integer.parseInt(table_GioHang.getValueAt(table_GioHang.getSelectedRow(), 3).toString());
            }
        });
        tc.getCellEditor().addCellEditorListener(
                new CellEditorListener() {
            public void editingCanceled(ChangeEvent e) {
            }

            public void editingStopped(ChangeEvent e) {
                System.out.println("editingStopped: apply additional action " + table_GioHang.getSelectedRow());

                String StrDG = table_GioHang.getValueAt(table_GioHang.getSelectedRow(), 2).toString();
                int DG = Integer.parseInt(StrDG);
                String Strsl = table_GioHang.getValueAt(table_GioHang.getSelectedRow(), 3).toString();
                new_Sl = Integer.parseInt(Strsl);
                Tien = Tien + (new_Sl - old_SL) * DG;

                System.out.println(Tien);
                label_SetTongTien_GioHang.setText("" + Tien);
            }
        });
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
            }

            @Override
            public void onDelete(int row) {
                if(table_GioHang.isEditing()) {
                    table_GioHang.getCellEditor().stopCellEditing();
                }
                DefaultTableModel tbmodel = (DefaultTableModel) table_GioHang.getModel();
                tbmodel.removeRow(row);
            }
        };
        table_GioHang.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender( new Color(255,255,255, 0), new Color(255, 255, 255, 0),false, true));
        table_GioHang.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event, new Color(255,255,255, 0), new Color(255, 255, 255, 0),false, true));
        
        Scrollpane_GioHang = new JScrollPane(); 
        Scrollpane_GioHang.setViewportView(table_GioHang);
        Scrollpane_GioHang.setBorder(null);
        Scrollpane_GioHang.setPreferredSize(new Dimension(650,420)); //450
        Scrollpane_GioHang.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scrollpane_GioHang.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        table_GioHang.setPreferredScrollableViewportSize(table_GioHang.getPreferredSize());
        table_GioHang.setTableHeader(null);
        
        pane_GioHang.add(Scrollpane_GioHang);
        pane_GioHang.add(pane_TongTien_GioHang);
        pane_GioHang.add(btn_DatMon);
    }
    
    private void pane_DonDat(){
        String[] columnNames = {"Mã món", "Tên món", "Đơn giá", "Số lượng"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };
            
            @Override
            public boolean isCellEditable(int row, int column) {
               return canEdit [column];
            }
        };
        table_DaDat = new JTable(model);
        table_DaDat.setRowHeight(40);
        table_DaDat.setFont(new Font(table_DaDat.getFont().getName(), Font.PLAIN, 14));
        table_DaDat.setShowGrid(false);
        table_DaDat.setShowHorizontalLines(true);
        table_DaDat.setSelectionBackground(new Color(167,223,255));
        
        Scrollpane_DaDat = new JScrollPane();        
        Scrollpane_DaDat.setViewportView(table_DaDat);
        Scrollpane_DaDat.setBorder(null);
        Scrollpane_DaDat.setPreferredSize(new Dimension(650,470)); 
        Scrollpane_DaDat.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scrollpane_DaDat.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        table_DaDat.setPreferredScrollableViewportSize(table_DaDat.getPreferredSize());
        table_DaDat.setTableHeader(null);    
        
        pane_TongTien_DaDat = new JPanel();
        pane_TongTien_DaDat.setBackground(Color.white);
        pane_TongTien_DaDat.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 0));
        pane_TongTien_DaDat.setPreferredSize(new Dimension(650, 25));
        label_TongTien_DaDat= new JLabel("TỔNG TIỀN: ");
        label_TongTien_DaDat.setFont(new Font(label_TongTien_DaDat.getFont().getName(),Font.BOLD,14));
        label_SetTongTien_DaDat= new JLabel();
        label_SetTongTien_DaDat.setFont(new Font(label_SetTongTien_DaDat.getFont().getName(),Font.BOLD,14));
        pane_TongTien_DaDat.add(label_TongTien_DaDat);
        pane_TongTien_DaDat.add(label_SetTongTien_DaDat);
        
        pane_DaDat.add(Scrollpane_DaDat);
        pane_DaDat.add(pane_TongTien_DaDat);
    }

    private void setTongTien_GioHang(){
        Tien = 0;
        for(int row=0; row<table_GioHang.getRowCount(); row++){
            Object dongia = table_GioHang.getValueAt(row, 2);
            int DG = Integer.parseInt(dongia.toString());
            Object sl = table_GioHang.getValueAt(row, 3);
            int SL = Integer.parseInt(sl.toString());

            Tien = Tien + SL * DG;

            System.out.println(Tien);
            label_SetTongTien_GioHang.setText("" + Tien);
        }
    }    
    private void setTongTien_DonDat(String SOHD){
        try {
            String sql_CTHD = "SELECT TRIGIA FROM HOADON WHERE SOHD = '" + SOHD + "'";
            Statement statement_CTHD = connection.createStatement();
            ResultSet res_CTHD = statement_CTHD.executeQuery(sql_CTHD);
            while (res_CTHD.next()) {
                String TRIGIA = res_CTHD.getString("TRIGIA");
                label_SetTongTien_DaDat.setText(TRIGIA);
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println("the error is" + ex);
        }
    }
    
    private void add_data_DonDat(String SOHD){
        DefaultTableModel tbmodel = (DefaultTableModel) table_DaDat.getModel();
        tbmodel.setRowCount(0);
        try {
            String sql_CTHD = "SELECT * FROM CTHD WHERE SOHD = '" + SOHD + "'";
            Statement statement_CTHD = connection.createStatement();
            ResultSet res_CTHD = statement_CTHD.executeQuery(sql_CTHD);
            while (res_CTHD.next()) {
                String MAMON = res_CTHD.getString("MAMON");
                int SL = res_CTHD.getInt("SL");
                String DONGIA = res_CTHD.getString("DONGIA");

                String sql_TENMON = "SELECT TENMON FROM MONAN WHERE MAMON = '" + MAMON + "'";
                Statement statement_TENMON = connection.createStatement();
                ResultSet res_TENMON = statement_TENMON.executeQuery(sql_TENMON);
                while (res_TENMON.next()) {
                    String TENMON = res_TENMON.getString("TENMON");

                    Object tbdata[] = {MAMON, TENMON, DONGIA, SL};
                    tbmodel.addRow(tbdata);
                }
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println("the error is" + ex);
        }
    }
    
    private void DatMon(String SOHD){
        DefaultTableModel tbmodel_GioHang = (DefaultTableModel) table_GioHang.getModel();
        JOptionPane DatMon_joption = new JOptionPane();
        if (table_GioHang.getRowCount() == 0) {
            DatMon_joption.setVisible(true);
            DatMon_joption.showMessageDialog(pane_bg_ThucDon, "Bạn chưa chọn món ăn nào!");
        }
        else
            for (int row = 0; row < table_GioHang.getRowCount(); row++) {
                Object mamon = table_GioHang.getValueAt(row, 0);
                Object tenmon = table_GioHang.getValueAt(row, 1);
                Object dongia = table_GioHang.getValueAt(row, 2);
                Object sl = table_GioHang.getValueAt(row, 3);
                try {
                    Statement statement_SELECT = connection.createStatement();
                    String sql_SELECT = "SELECT MAMON FROM CTHD WHERE SOHD = '" + SOHD + "' AND MAMON = '" + mamon + "'";
                    ResultSet res_SELECT = statement_SELECT.executeQuery(sql_SELECT);

                    boolean flag_TonTai = false;
                    while (res_SELECT.next()) {
                        flag_TonTai = true;
                        break;
                    }

                    if (flag_TonTai) {
                        Statement statement_UPDATE = connection.createStatement();
                        String sql_UPDATE = "UPDATE CTHD SET SL = SL + " + sl + " WHERE SOHD = '" + SOHD + "' AND MAMON = '" + mamon + "'";
                        int res_UPDATE = statement_UPDATE.executeUpdate(sql_UPDATE);
                        System.out.println("UPDATE thanh cong " + SOHD);
                    } else {
                        Statement statement_INSERT = connection.createStatement();
                        String sql_INSERT = "INSERT INTO CTHD VALUES (  '" + SOHD + "' , '" + mamon + "', " + sl + ", " + dongia + ", 0 )";
                        int res_INSERT = statement_INSERT.executeUpdate(sql_INSERT);
                        System.out.println("Insert thanh cong " + SOHD);
                    }
                } catch (SQLException ex) {
                    DatMon_joption.setVisible(true);
                    DatMon_joption.showMessageDialog(pane_bg_ThucDon, "Có lỗi xảy ra! Không thể đặt món");
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        tbmodel_GioHang.setRowCount(0);
    }
    
    private void set_pane_GioHang(){
        init_GioHang();
        pane_GioHang();
        pane_DonDat();
    }
}
