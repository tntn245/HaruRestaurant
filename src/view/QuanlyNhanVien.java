/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.raven.datechooser.*;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.io.*;
import javax.swing.KeyStroke;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

public class QuanlyNhanVien {
    private JPanel pane_bg;
    
    private JPanel pane_QLNV;
    private DropShadowPane pane_shadow;
    private JTable table_NV;
    private JScrollPane Scrollpane_TableNV;
    public ButtonGradient btn_ThemNV;
    public JPanel pane_Search;
    public JButton btn_Search;
    public JComboBox boxSearch;
    public JTextField txtSearch;
    
    public JDialog formNV_jDialog;
    public JOptionPane themNV_jOptionPane = new JOptionPane();
    public JOptionPane suaNV_jOptionPane = new JOptionPane();
    public JOptionPane search_jOptionPane = new JOptionPane();
    
    private JTextField txt_IDNhanVien;
    private JTextField txt_HoTen;
    private JTextField txt_CCCD;
    private PrefixTextField txt_SDT;
    private JComboBox txt_GioiTinh;
    private JTextField txt_Email;
    private JTextField suffix;
    private JTextField txt_NgaySinh;
    private JComboBox txt_BoPhan;
    private JTextField txt_NgayVaoLam;
    private JFormattedTextField txt_Luong;
    private JComboBox txt_TinhTrang;
    private JTextField txt_DiaChi;

    private JOptionPane Delete_Confirm_jOptionPane = new JOptionPane();
    
    public ButtonGradient btn_InFileExcel;
    
    private Connection connection;
    
    public QuanlyNhanVien(Connection connection){
        this.connection = connection;
        init_pane();
    }
    
    public void init_pane(){
        pane_bg = new JPanel();
        pane_bg.setOpaque(true);
        pane_bg.setBackground(new Color(230, 235, 240));
//        pane_bg.setBackground(new Color(215, 220, 230));

        pane_bg.setPreferredSize(new Dimension(800, 600)); 
        
        pane_shadow = new DropShadowPane(4, 0, 0, 0, Color.white, 50);
        pane_shadow.setPreferredSize(new Dimension(770, 550)); 
        
        pane_QLNV = new JPanel();
        pane_QLNV.setBackground(Color.white);
        pane_QLNV.setPreferredSize(new Dimension(760, 540)); 
    }    
    public JPanel pane_QLNV(){
        search_bar();
        table_NV();
        btn_InFileExcel();
        pane_shadow.add(pane_QLNV);
        pane_bg.add(pane_shadow);
//        pane_bg.add(pane_QLNV);
        return pane_bg;
    }
    
    public void search_bar(){
        pane_Search = new JPanel();
        pane_Search.setBackground(Color.white);
        pane_Search.setPreferredSize(new Dimension(800, 70)); 
        pane_search();
        btn_ThemNV();
        pane_QLNV.add(pane_Search);
    }
    
    public void pane_search(){
        JPanel pane_search_bar = new JPanel();
        pane_search_bar.setBackground(Color.white );
        pane_search_bar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        txtSearch = new JTextField(" Search");
        txtSearch.setPreferredSize(new Dimension(50, 31)); 
        txtSearch.setColumns(35);     
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
        
        String colname_NV[] = { "MANV", "HOTEN", "CCCD", "DIACHI", "SDT", "EMAIL", "GIOITINH", "NGSINH", "NGVL", "BOPHAN", "LUONG", "TENTK" };
        boxSearch = new JComboBox(colname_NV);
        boxSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boxSearch.setSelectedItem("HOTEN");
        boxSearch.setFont(new Font("SansSerif", Font.BOLD, 14));
        boxSearch.setBackground(Color.white);
        boxSearch.setPreferredSize(new Dimension(135, 35)); 

        Search();
        
        pane_search_bar.setBorder(txtSearch.getBorder());
        txtSearch.setBorder(null);
        btn_Search.setBorder(null);
        
        pane_Search.add(pane_search_bar);
        pane_Search.add(boxSearch);
        pane_Search.setBorder(new EmptyBorder(10, 0, 0, 0));
    }
    
    public void Search(){
        btn_Search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(txtSearch.getText().equals("") || txtSearch.getText().equals(" Search"))
                    add_data_table();
                else {
                    boolean flag = false;
                    try {
                        String sql = "SELECT MANV, HOTEN, CCCD, DIACHI, SDT, EMAIL, GIOITINH, "
                                + "TO_CHAR(NGSINH, 'DD-MM-YYYY') as NGSINH, "
                                + "TO_CHAR(NGVL, 'DD-MM-YYYY') as NGVL, "
                                + "BOPHAN, LUONG, TENTK "
                                + "FROM NHANVIEN WHERE "
                                + boxSearch.getSelectedItem().toString() + " LIKE '%" + txtSearch.getText() + "%'";
                        Statement statement = connection.createStatement();
                        ResultSet res = statement.executeQuery(sql);

                        DefaultTableModel tbmodel = (DefaultTableModel) table_NV.getModel();
                        tbmodel.setRowCount(0);

                        while (res.next()) {
                            flag = true;
                            String MANV = res.getString("MANV");
                            String HOTEN = res.getString("HOTEN");
                            String GIOITINH = res.getString("GIOITINH");
                            String NGVL = res.getString("NGVL");
                            String BOPHAN = res.getString("BOPHAN");
                            Object LUONG = res.getObject("LUONG");
                            String TENTK = res.getString("TENTK");

                            Object tbdata[] = {MANV, HOTEN, GIOITINH, NGVL, BOPHAN, LUONG, TENTK, null};
                            tbmodel.addRow(tbdata);
                        }
                    } catch (SQLException | HeadlessException ex) {
                        System.out.println("the error is" + ex);
                    }
                    if (!flag) {
                        search_jOptionPane.setVisible(true);
                        search_jOptionPane.showMessageDialog(pane_QLNV, "Không tìm thấy nhân viên!");
                    }
                }
            }
        });
    }

    public void init_Dialog(){
        formNV_jDialog = new JDialog();
        formNV_jDialog.getContentPane().setBackground(new Color(255, 255, 255));
        formNV_jDialog.setMinimumSize(new Dimension(800, 500));
        formNV_jDialog.setModal(true);
        formNV_jDialog.setResizable(false);
        GridBagLayout jDialogLayout = new GridBagLayout();
        jDialogLayout.columnWidths = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
        jDialogLayout.rowHeights = new int[] {0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0};
        formNV_jDialog.getContentPane().setLayout(jDialogLayout);
    }
    
    public void Dialog_form( boolean loaiDialog, int row){
        boolean loai = loaiDialog;
        init_Dialog();
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel IDNhanVien = new JLabel("ID Nhân viên:");
        JLabel HoTen = new JLabel("Họ tên:");
        JLabel CCCD = new JLabel("CMND/CCCD:");
        JLabel SDT = new JLabel("Số điện thoại:");
        JLabel GioiTinh = new JLabel("Giới tính");
        JLabel Email = new JLabel("E-mail:");
        JLabel NgaySinh = new JLabel("Ngày sinh:");
        JLabel BoPhan = new JLabel("Bộ phận:");
        JLabel NgayVaoLam = new JLabel("Ngày vào làm:");
        JLabel Luong = new JLabel("Lương:");
        JLabel DiaChi = new JLabel("Địa chỉ:");
        JLabel TinhTrang = new JLabel("Tình trạng làm việc:");
        
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        
        txt_IDNhanVien = new JTextField();
        txt_HoTen = new JTextField();
        
        txt_CCCD = new JTextField();
        txt_CCCD.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Number_keyPressed(e, txt_CCCD, 12);
            };
        });
        
        txt_SDT = new PrefixTextField("0");
        txt_SDT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Number_keyPressed(e, txt_SDT, 10);
            };
        });

        String StrGioiTinh[] = {"Nam", "Nữ"};
        txt_GioiTinh = new JComboBox(StrGioiTinh);
        
        JPanel pane_email = new JPanel();
        pane_email.setBackground(Color.white); 
        pane_email.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        txt_Email = new JTextField();
        txt_Email.setColumns(17);  
        txt_Email.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                email_keyPressed(e, txt_Email);
            };
        });
        suffix = new JTextField("@gmail.com");
        suffix.setColumns(7);  
        suffix.setForeground(new Color(134, 134, 134));
        suffix.setEditable(false);
        
        pane_email.add(txt_Email);
        pane_email.add(suffix);
        
        
        txt_NgaySinh = new JTextField();
        DateChooser ngaySinh_dateChooser = new DateChooser();
        ngaySinh_dateChooser.setForeground(new java.awt.Color(167, 223, 255));
        ngaySinh_dateChooser.setTextRefernce(txt_NgaySinh);
        String StrBoPhan[] = {"Quản lý", "Thu ngân", "Nhân viên kho", "Nhân viên bếp"};
        txt_BoPhan = new JComboBox(StrBoPhan);
        txt_NgayVaoLam = new JTextField();
        DateChooser ngayVaoLam_dateChooser = new DateChooser();
        ngayVaoLam_dateChooser.setForeground(new java.awt.Color(255, 184, 183));
        ngayVaoLam_dateChooser.setTextRefernce(txt_NgayVaoLam);
        txt_Luong = new JFormattedTextField(formatter);
        txt_DiaChi = new JTextField();
        String StrTinhTrang[] = {"Đã nghỉ việc", "Đang làm việc"};
        txt_TinhTrang = new JComboBox(StrTinhTrang);
        txt_TinhTrang.setSelectedIndex(1);
        
        ButtonGradient btn_cancel_themNV = new ButtonGradient();
        btn_cancel_themNV.setText("HỦY");
        btn_cancel_themNV.setColor1(new Color(255,231,231));
        btn_cancel_themNV.setColor2(new Color(255,130,145));
        btn_cancel_themNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_Dialog_jButtonActionPerformed(evt);
            }
        });

        gbc = new GridBagConstraints();
        gbc.gridx = 62;
        gbc.gridy = 18;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formNV_jDialog.getContentPane().add(btn_cancel_themNV, gbc);
        
        ButtonGradient btn_XacNhan = new ButtonGradient();
        btn_XacNhan.setText("XÁC NHẬN");
        btn_XacNhan.setColor1(new Color(225,244,255));
        btn_XacNhan.setColor2(new Color(133,210,255));
        btn_XacNhan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(loai)
                    themNV_jButtonActionPerformed(evt);
                else 
                    suaNV_jButtonActionPerformed(evt, row);
            }
        });
        gbc = new GridBagConstraints();
        gbc.gridx = 68;
        gbc.gridy = 18;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formNV_jDialog.getContentPane().add(btn_XacNhan, gbc);
        
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formNV_jDialog.getContentPane().add(IDNhanVien, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 56;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formNV_jDialog.getContentPane().add(HoTen, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 26;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formNV_jDialog.getContentPane().add(CCCD, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formNV_jDialog.getContentPane().add(SDT, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 26;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formNV_jDialog.getContentPane().add(GioiTinh, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 56;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formNV_jDialog.getContentPane().add(Email, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formNV_jDialog.getContentPane().add(NgaySinh, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 56;
        gbc.gridy = 8;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formNV_jDialog.getContentPane().add(BoPhan, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 26;
        gbc.gridy = 8;
        gbc.gridwidth = 5;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        formNV_jDialog.getContentPane().add(NgayVaoLam, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 5;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        formNV_jDialog.getContentPane().add(Luong, gbc);

        gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 26;
        gbc.gridy = 12;
        gbc.gridwidth = 5;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        formNV_jDialog.getContentPane().add(TinhTrang, gbc);
        
        gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 56;
        gbc.gridy = 12;
        gbc.gridwidth = 5;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        formNV_jDialog.getContentPane().add(DiaChi, gbc);
        
        if(loai)
            setText_nextMANV();
        else
            setText_currMANV(row);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 23;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 30, 0);
        formNV_jDialog.getContentPane().add(txt_IDNhanVien, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 56;
        gbc.gridy = 2;
        gbc.gridwidth = 19;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 30, 0);
        formNV_jDialog.getContentPane().add(txt_HoTen, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 26;
        gbc.gridy = 2;
        gbc.gridwidth = 25;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 30, 0);
        formNV_jDialog.getContentPane().add(txt_CCCD, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 23;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 30, 0);
        formNV_jDialog.getContentPane().add(txt_SDT, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 26;
        gbc.gridy = 6;
        gbc.gridwidth = 25;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 30, 0);
        formNV_jDialog.getContentPane().add(txt_GioiTinh, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 56;
        gbc.gridy = 6;
        gbc.gridwidth = 19;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 30, 0);
        formNV_jDialog.getContentPane().add(pane_email, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 23;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 30, 0);
        formNV_jDialog.getContentPane().add(txt_NgaySinh, gbc);

        txt_BoPhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        
        gbc = new GridBagConstraints();
        gbc.gridx = 56;
        gbc.gridy = 10;
        gbc.gridwidth = 19;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 30, 0);
        formNV_jDialog.getContentPane().add(txt_BoPhan, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 26;
        gbc.gridy = 10;
        gbc.gridwidth = 25;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 30, 0);
        formNV_jDialog.getContentPane().add(txt_NgayVaoLam, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 23;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 30, 0);
        formNV_jDialog.getContentPane().add(txt_Luong, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 26;
        gbc.gridy = 14;
        gbc.gridwidth = 25;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 30, 0);
        formNV_jDialog.getContentPane().add(txt_TinhTrang, gbc);    
        
        gbc = new GridBagConstraints();
        gbc.gridx = 56;
        gbc.gridy = 14;
        gbc.gridwidth = 19;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 0, 30, 0);
        formNV_jDialog.getContentPane().add(txt_DiaChi, gbc);   
    }

    public void btn_ThemNV(){
        btn_ThemNV = new ButtonGradient();
        btn_ThemNV.setText("THÊM MỚI");
        btn_ThemNV.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_ThemNV.setFont(new Font(btn_ThemNV.getFont().getName(),Font.BOLD,btn_ThemNV.getFont().getSize()));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/add-employee-icon.png"));
        Image image = icon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_ThemNV.setIcon(newIcon);
        
        btn_ThemNV.setVerticalTextPosition(SwingConstants.CENTER);
        btn_ThemNV.setHorizontalTextPosition(SwingConstants.RIGHT);
        btn_ThemNV.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Da bam them NV");
                ThemNhanVien_Dialog(e);
            }
        });
        
        pane_Search.add(btn_ThemNV);
    }  
    
    public void table_NV(){
        Scrollpane_TableNV= new JScrollPane();

        String[] columnNames = {"Mã NV", "Họ tên", "Giới tính", "Ngày vào làm", "Chức vụ", "Lương", "Tên TK", ""};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };
            
            @Override
            public boolean isCellEditable(int row, int column) {
               return canEdit [column];
            }
        };
        table_NV = new JTable(model);
        table_NV.setRowHeight(40);
        table_NV.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ? new Color(234,247,255) : new Color(255, 237, 243));
                c.setForeground(Color.black);
                return c;
            }
        });        
        
        table_NV.getTableHeader().setOpaque(false);
        table_NV.getTableHeader().setBackground(new Color(167,222,254));
        table_NV.getTableHeader().setForeground(Color.black);
        table_NV.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
//        table_NV.getTableHeader().setFont(new Font(table_NV.getFont().getName(),Font.BOLD,14));
        table_NV.getTableHeader().setPreferredSize(new Dimension(table_NV.getWidth(),40));
        table_NV.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
                
        table_NV.setShowHorizontalLines(false);
        table_NV.setGridColor(Color.white);
        table_NV.setBackground(Color.white);
        table_NV.setBorder(new EmptyBorder(5, 5, 5,5));
        table_NV.setFont(new Font("SansSerif", Font.PLAIN, 14));
//        table_NV.setFont(new Font(table_NV.getFont().getName(),Font.PLAIN,14));
        
        TableColumnModel columnModel = table_NV.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
//        columnModel.getColumn(7).setPreferredWidth(100);
        
        add_data_table();

        table_NV.setPreferredScrollableViewportSize(table_NV.getPreferredSize());
        table_NV.setFillsViewportHeight(true);
//        table_NV.setSelectionBackground(new Color(0, 0, 0, 0));
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                SuaNhanVien_Dialog(row);
            }

            @Override
            public void onDelete(int row) {
                if(table_NV.isEditing()) {
                    table_NV.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) table_NV.getModel();
                Object value_MANV = model.getValueAt(row, 0);
                System.out.println(value_MANV);
                Object value_TENTK = model.getValueAt(row, 0);
                System.out.println(value_TENTK);
                try {
                    Statement statement = connection.createStatement();
                    Delete_Confirm_jOptionPane.setVisible(true);
                    int flag_OK = Delete_Confirm_jOptionPane.showConfirmDialog(formNV_jDialog, "Bạn chắc chắn muốn xóa nhân viên?",null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(flag_OK == JOptionPane.OK_OPTION){
                        String sql = "DELETE FROM NHANVIEN WHERE MANV = '" + value_MANV + "'";
                        int res = statement.executeUpdate(sql);
                        System.out.println("Delete NV thanh cong");
                        sql = "DELETE FROM TAIKHOAN WHERE TENTK = '" + value_TENTK + "'";
                        res = statement.executeUpdate(sql);
                        System.out.println("Delete TK thanh cong");
                        model.removeRow(row);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//            @Override
//            public void onCreateAccount(int row) {}
        };
        table_NV.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender(new Color(234,247,255), new Color(255, 237, 243),true, false));
        table_NV.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event, new Color(234,247,255), new Color(255, 237, 243),true,false));
        
        
        Scrollpane_TableNV.setViewportView(table_NV);
        Scrollpane_TableNV.setBorder(new LineBorder( Color.LIGHT_GRAY, 1, true));
        Scrollpane_TableNV.setPreferredSize(new Dimension(700, 400));
        pane_QLNV.add(Scrollpane_TableNV);
    }
        
    public void btn_InFileExcel(){
        JPanel pane_InFileExcel = new JPanel();
        pane_InFileExcel.setPreferredSize(new Dimension(700,50));
        pane_InFileExcel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        pane_InFileExcel.setBackground(Color.white);

        btn_InFileExcel = new ButtonGradient();
        btn_InFileExcel.setText("IN FILE EXCEL");
        btn_InFileExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_InFileExcel.setFont(new Font(btn_InFileExcel.getFont().getName(),Font.BOLD,btn_InFileExcel.getFont().getSize()));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/printing.png"));
        Image image = icon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_InFileExcel.setIcon(newIcon);
        
        btn_InFileExcel.setVerticalTextPosition(SwingConstants.CENTER);
        btn_InFileExcel.setHorizontalTextPosition(SwingConstants.RIGHT);
        btn_InFileExcel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Dialog_InfileExcel();
            }
        });
        
        pane_InFileExcel.add(btn_InFileExcel);
        pane_QLNV.add(pane_InFileExcel);
    }  

    private void Dialog_InfileExcel(){
        JDialog InHD_jDialog = new JDialog();
        InHD_jDialog.getContentPane().setBackground(new Color(255, 255, 255));
        InHD_jDialog.setPreferredSize(new Dimension(400, 250));
        InHD_jDialog.setResizable(false);
        InHD_jDialog.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5,5));
        
        JPanel pane_path = new JPanel();
        pane_path.setPreferredSize(new Dimension(350,60));
        pane_path.setBackground(Color.white);
        JLabel label_path = new JLabel("Đường dẫn:");
        label_path.setPreferredSize(new Dimension(340, 20));
        pane_path.add(label_path);
        JTextField file_path = new JTextField("D:\\\\");
        file_path.setForeground(new Color(134, 134, 134));
        file_path.setEditable(false);
        file_path.setColumns(30);  
        pane_path.add(file_path);
        JButton choosefile = new JButton("...");
        pane_path.add(choosefile);
        
        JPanel pane_name = new JPanel();
        pane_name.setPreferredSize(new Dimension(350,60));
        pane_name.setBackground(Color.white);
        JLabel label_name = new JLabel("Tên file:");
        label_name.setPreferredSize(new Dimension(340, 20));
        pane_name.add(label_name);
        JTextField name = new JTextField("danhsachNV");
        name.setColumns(26);  
        JTextField suffix = new JTextField(".xlsx");
        suffix.setColumns(5);  
        suffix.setForeground(new Color(134, 134, 134));
        suffix.setEditable(false);
        
        JPanel pane_txt_name = new JPanel();
        JTextField temp = new JTextField();
        pane_txt_name.setBackground(Color.white);
        pane_txt_name.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
        pane_txt_name.add(name);
        pane_txt_name.add(suffix);
        pane_name.add(pane_txt_name);
        
        JPanel pane_btn = new JPanel();
        pane_btn.setBackground(Color.white);
        pane_btn.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pane_btn.setPreferredSize(new Dimension(350, 50));
        
        JButton ok = new JButton("IN");
        JButton cancel = new JButton("HỦY");
        pane_btn.add(ok);
        pane_btn.add(cancel);
        
        InHD_jDialog.add(pane_path);
        InHD_jDialog.add(pane_name);
        InHD_jDialog.add(pane_btn);
        
        InHD_jDialog.pack();
        InHD_jDialog.setLocationRelativeTo(null);
        InHD_jDialog.setVisible(true);
        
        choosefile.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Da bam chọn đường dẫn");
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
                                
                if (chooser.showOpenDialog(InHD_jDialog) == JFileChooser.APPROVE_OPTION) {
                    String filepath = chooser.getSelectedFile().toString();
                    file_path.setText(filepath+"\\");
                } else {
                    file_path.setText("D:\\");
                }
            }
        });
        
        ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String file_name = name.getText()+".xlsx";
                InFileExcel(file_path.getText(),file_name);
                InHD_jDialog.setVisible(false);
            }
        });
                
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Da bam cancel");
                InHD_jDialog.setVisible(false);
            }
        });
    }
    
    private void InFileExcel(String file_path, String file_name) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("DanhSachNhanVien");
        XSSFRow row = null;
        Cell cell = null;
        row = sheet.createRow(3);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("MÃ NHÂN VIÊN");

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("HỌ TÊN");

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("GIỚI TÍNH");

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("CMND/CCCD");

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("SDT");

        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("EMAIL");

        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("NGÀY SINH");

        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("NGÀY VÀO LÀM");

        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("ĐỊA CHỈ");

        cell = row.createCell(9, CellType.STRING);
        cell.setCellValue("CHỨC VỤ");

        cell = row.createCell(10, CellType.STRING);
        cell.setCellValue("LƯƠNG");

        cell = row.createCell(11, CellType.STRING);
        cell.setCellValue("TÌNH TRẠNG LÀM VIỆC");

        cell = row.createCell(12, CellType.STRING);
        cell.setCellValue("TÊN TÀI KHOẢN");

        try {
            String sql = "SELECT MANV, HOTEN, CCCD, DIACHI, SDT, EMAIL, GIOITINH, "
                    + "TO_CHAR(NGSINH, 'DD-MM-YYYY') as NGSINH, "
                    + "TO_CHAR(NGVL, 'DD-MM-YYYY') as NGVL, "
                    + "BOPHAN, LUONG, TINHTRANGLAMVIEC, TENTK "
                    + "FROM NHANVIEN ORDER BY TO_NUMBER(SUBSTR( MANV, 3 ))";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);
            int index = 4;
            while (res.next()) {
                String MANV = res.getString("MANV");
                String HOTEN = res.getString("HOTEN");
                String GIOITINH = res.getString("GIOITINH");
                String CCCD = res.getString("CCCD");
                String SDT = res.getString("SDT");
                String EMAIL = res.getString("EMAIL");
                String NGSINH = res.getString("NGSINH");
                String NGVL = res.getString("NGVL");
                String DIACHI = res.getString("DIACHI");
                String BOPHAN = res.getString("BOPHAN");
                Object LUONG = res.getObject("LUONG");
                int intLuong = Integer.parseInt(LUONG.toString());
                Object TINHTRANGLAMVIEC = res.getObject("TINHTRANGLAMVIEC");
                String StrTinhTrang;
                String TENTK = res.getString("TENTK");

                row = sheet.createRow(index);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(MANV);
                
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(HOTEN);
                
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(GIOITINH);
                
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(CCCD);
                
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(SDT);
                
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(EMAIL);
                
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(NGSINH);
                
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(NGVL);
                
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(DIACHI);
                
                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(BOPHAN);
                
                cell = row.createCell(10, CellType.NUMERIC);
                cell.setCellValue(intLuong);
                
                if(TINHTRANGLAMVIEC.equals("0"))
                    StrTinhTrang = "Đã nghỉ việc";
                else
                    StrTinhTrang = "Đang làm việc";
                cell = row.createCell(11, CellType.STRING);
                cell.setCellValue(StrTinhTrang);
                
                cell = row.createCell(12, CellType.STRING);
                cell.setCellValue(TENTK);
                
                index++;
            }
                
            CallableStatement cs = connection.prepareCall("{CALL TINH_TONG_LUONG_NV(?)}");
            cs.registerOutParameter(1, java.sql.Types.INTEGER);
            cs.executeUpdate();
            int tong_luong_NV = cs.getInt(1);
            System.out.println("Tong: " + tong_luong_NV);
            
            row = sheet.createRow(index + 1);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("TỔNG LƯƠNG:");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(tong_luong_NV);
            
        } catch (SQLException | HeadlessException ex) {
            System.out.println("the error is" + ex);
        }
                
        File f = new File(file_path+file_name);
        try {
            FileOutputStream fis = new FileOutputStream(f);
            try {
                workbook.write(fis);
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(QuanlyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane option_InNV = new JOptionPane();
            option_InNV.setVisible(true);
            option_InNV.showMessageDialog(pane_QLNV, "In thành công!");
        } catch (FileNotFoundException ex) {
            JOptionPane option_InNV = new JOptionPane();
            option_InNV.setVisible(true);
            option_InNV.showMessageDialog(pane_QLNV, "Tên file/ đường dẫn không hợp lệ!");
            ex.printStackTrace();
        }
        
    }

    private void Number_keyPressed(KeyEvent e, JTextField txt, int len) {
        String PhoneNumber = txt.getText();
        int length = PhoneNumber.length();
        if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
            if (length < len) {
                txt.setEditable(true);
            } else {
                txt.setEditable(false);
            }
        } else {
            if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                txt.setEditable(true);
            } else {
                txt.setEditable(false);
            }
        }
    }
    
    private void email_keyPressed(KeyEvent e, JTextField txt) {
        if (e.getKeyChar() != '@') {     
            if(e.getExtendedKeyCode() == KeyEvent.VK_SPACE )
                txt.setEditable(false);
            else
                txt.setEditable(true);   
        } 
        else {
            if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                txt.setEditable(true);
            } else {
                txt.setEditable(false);
            }
        }
        

    }
    
    public void add_data_table(){
        try{
            DefaultTableModel tbmodel = (DefaultTableModel)table_NV.getModel();
            String sql = "SELECT MANV, HOTEN, CCCD, DIACHI, SDT, EMAIL, GIOITINH, "
                    + "TO_CHAR(NGSINH, 'DD-MM-YYYY') as NGSINH, "
                    + "TO_CHAR(NGVL, 'DD-MM-YYYY') as NGVL, "
                    + "BOPHAN, LUONG, TINHTRANGLAMVIEC, TENTK "
                    + "FROM NHANVIEN ORDER BY TO_NUMBER(SUBSTR( MANV, 3 ))";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);

            tbmodel.setRowCount(0);
            while(res.next()){
                String MANV = res.getString("MANV");
                String HOTEN = res.getString("HOTEN");
                String GIOITINH = res.getString("GIOITINH");
                String NGVL = res.getString("NGVL");
                String BOPHAN = res.getString("BOPHAN");
                Object LUONG = res.getObject("LUONG");
                String TENTK = res.getString("TENTK");

                Object tbdata[] = {MANV, HOTEN, GIOITINH, NGVL, BOPHAN, LUONG, TENTK, null};
                tbmodel.addRow(tbdata);
            }
        }
        catch(SQLException | HeadlessException ex){
                    System.out.println("the error is"+ex);
        }
    }
    
    private void Exit_Dialog_jButtonActionPerformed(ActionEvent evt) {
        formNV_jDialog.setVisible(false);
    }

    private void ThemNhanVien_Dialog(ActionEvent evt) {
        Dialog_form(true, -1);
        formNV_jDialog.pack();
        formNV_jDialog.setLocationRelativeTo(null);
        formNV_jDialog.setVisible(true);
    }
    private void setText_nextMANV(){
        String MANV;
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT TO_NUMBER(SUBSTR(MANV, 3))+1 NUM_NV FROM NHANVIEN ORDER BY TO_NUMBER(SUBSTR( MANV, 3 )) DESC";
            ResultSet res = statement.executeQuery(sql);
            boolean flag = false;
            while(res.next()){
                flag = true;
                MANV = "NV" + res.getInt("NUM_NV");
                txt_IDNhanVien.setText(MANV);
                txt_IDNhanVien.setForeground(new Color (134, 134, 134));
                txt_IDNhanVien.setEditable(false);
                System.out.println("set " + MANV + " thanh cong" );
                break;
            }
            if(!flag)
                MANV = "NV1";
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is "+ex);
        }
    }
    
    private boolean kiemtrarangbuocNV_HD(String MANV, String StrNGVL){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT TO_CHAR(NGHD, 'DD-MM-YYYY') as NGHD FROM HOADON WHERE MANV = '" + MANV + "'";
            ResultSet res = statement.executeQuery(sql);
                while (res.next()) {
                    String StrNGHD = res.getString("NGHD");
                    java.util.Date NGVL=new SimpleDateFormat("dd-MM-yyyy").parse(StrNGVL);
                    java.util.Date NGHD=new SimpleDateFormat("dd-MM-yyyy").parse(StrNGHD);
                    if(NGVL.compareTo(NGHD) > 0){
                        JOptionPane date_option = new JOptionPane();
                        date_option.setVisible(true);
                        date_option.showMessageDialog(formNV_jDialog, "Ngày vào làm không được xảy ra sau ngày lập hóa đơn!");
                        return false;
                    }
                }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    private boolean kiemtrarangbuocNV(String MaNV, String HoTen, String CCCD, String DiaChi, String SDT, String Email, Object Luong, int NamSinh, int NamVL){
        try {
            Statement statement = connection.createStatement();
            if (HoTen.equals("") || CCCD.equals("") || DiaChi.equals("") || SDT.equals("") || Email.equals("") || Luong.equals("")) {
                themNV_jOptionPane.setVisible(true);
                themNV_jOptionPane.showMessageDialog(formNV_jDialog, "Vui lòng nhập đầy đủ thông tin!");
                themNV_jOptionPane.setMessageType(JOptionPane.WARNING_MESSAGE);
                return false;
            } else {
                boolean flag_CCCDtontai = false;
                String sql = "SELECT * FROM NHANVIEN WHERE CCCD = '" + CCCD + "'";
                ResultSet res_select = statement.executeQuery(sql);
                while (res_select.next()) {
                    String MANV = res_select.getString("MANV");
                    System.out.println(MANV);
                    if(!MANV.equals(MaNV))
                        flag_CCCDtontai = true;
                }
                if (flag_CCCDtontai) {
                    themNV_jOptionPane.setVisible(true);
                    themNV_jOptionPane.showMessageDialog(formNV_jDialog, "CMND/CCCD đã tồn tại!");
                    themNV_jOptionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
                    return false;
                } 
                else if((NamVL - NamSinh) < 18){
                    System.out.println(NamVL+" - "+NamSinh);
                    themNV_jOptionPane.setVisible(true);
                    themNV_jOptionPane.showMessageDialog(formNV_jDialog, "Nhân viên phải từ 18 tuổi!");
                    themNV_jOptionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    private void themNV_jButtonActionPerformed(ActionEvent evt){
        String MaNV = txt_IDNhanVien.getText();            
        String HoTen = txt_HoTen.getText();
        String CCCD = txt_CCCD.getText();
        String DiaChi = txt_DiaChi.getText();
        String SDT = txt_SDT.getText();
        Object GioiTinh = txt_GioiTinh.getItemAt(txt_GioiTinh.getSelectedIndex());
        String Email = txt_Email.getText() + "@gmail.com";
        String NgSinh = txt_NgaySinh.getText();
        int NamSinh = Integer.parseInt(NgSinh.substring(6));
        Object BoPhan = txt_BoPhan.getItemAt(txt_BoPhan.getSelectedIndex());
        String NVL = txt_NgayVaoLam.getText();
        int NamVL = Integer.parseInt(NVL.substring(6));
        Object Luong = txt_Luong.getValue();
        int TinhTrang = txt_TinhTrang.getSelectedIndex();
        
        try {
            Statement statement = connection.createStatement();
            if (kiemtrarangbuocNV(MaNV, HoTen, CCCD, DiaChi, SDT, Email, Luong, NamSinh, NamVL)) {
                String sql = "INSERT INTO NHANVIEN VALUES (  '" + MaNV + "' , '" + HoTen + "', '" + CCCD + "', '" + DiaChi + "', '" + SDT + "' , '" + Email + "' , '" + GioiTinh + "' , TO_DATE('" + NgSinh + "', 'DD-MM-YYYY'), TO_DATE('" + NVL + "', 'DD-MM-YYYY'), '" + BoPhan + "' , '" + Luong + "', " + TinhTrang + ", null )";
                int res = statement.executeUpdate(sql);
                System.out.println("Insert thanh cong");
                themNV_jOptionPane.setVisible(true);
                themNV_jOptionPane.showMessageDialog(formNV_jDialog, "Thêm thành công nhân viên!");
                formNV_jDialog.setVisible(false);

                Object tbdata[] = {MaNV, HoTen, GioiTinh, NVL, BoPhan, Luong, null, null};
                DefaultTableModel tbmodel = (DefaultTableModel) table_NV.getModel();
                tbmodel.addRow(tbdata);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void SuaNhanVien_Dialog(int row) {
        Dialog_form(false, row);
        formNV_jDialog.pack();
        formNV_jDialog.setLocationRelativeTo(null);
        formNV_jDialog.setVisible(true);
    }
    private void setText_currMANV(int row){
        DefaultTableModel model = (DefaultTableModel) table_NV.getModel();
        Object value_MANV = model.getValueAt(row, 0);
        System.out.println(value_MANV);
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT MANV, HOTEN, CCCD, DIACHI, SDT, EMAIL, GIOITINH, "
                    + "TO_CHAR(NGSINH, 'DD-MM-YYYY') as NGSINH, "
                    + "TO_CHAR(NGVL, 'DD-MM-YYYY') as NGVL, "
                    + "BOPHAN, LUONG, TINHTRANGLAMVIEC, TENTK "
                    + "FROM NHANVIEN WHERE MANV = '" + value_MANV + "'";
            ResultSet res = statement.executeQuery(sql);
            System.out.println(value_MANV + " thanh cong");

            while (res.next()) {
                String MaNV = res.getString("MANV");
                String HoTen = res.getString("HOTEN");
                String CCCD = res.getString("CCCD");
                String DiaChi = res.getString("DIACHI");
                String SDT = res.getString("SDT").substring(1);
                String StrEmail = res.getString("EMAIL");
                String[] parts = StrEmail.split("@");
                String prefix_email = parts[0];
                String GioiTinh = res.getString("GIOITINH");
                String NgSinh = res.getString("NGSINH");
                String NgVL = res.getString("NGVL");
                String BoPhan = res.getString("BOPHAN");
                String StrLuong = res.getString("LUONG");
                int Luong;
                if(StrLuong == null) 
                    Luong = 0;
                else 
                    Luong = Integer.parseInt(StrLuong);
                int TinhTrang = res.getInt("TINHTRANGLAMVIEC");
                String TENTK = res.getString("TENTK");

                txt_IDNhanVien.setText(MaNV);
                txt_IDNhanVien.setForeground(new Color(134, 134, 134));
                txt_IDNhanVien.setEditable(false);

                txt_HoTen.setText(HoTen);
                txt_CCCD.setText(CCCD);
                txt_DiaChi.setText(DiaChi);
                txt_SDT.setText(SDT);
                txt_Email.setText(prefix_email);
                if (GioiTinh.equals("Nam") )
                    txt_GioiTinh.setSelectedIndex(0);
                else
                    txt_GioiTinh.setSelectedIndex(1);
                txt_NgaySinh.setText(NgSinh);
                txt_NgayVaoLam.setText(NgVL);
                txt_BoPhan.setSelectedItem(BoPhan);
                txt_TinhTrang.setSelectedIndex(TinhTrang);
                txt_Luong.setValue(Luong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void suaNV_jButtonActionPerformed(ActionEvent evt, int row){
        DefaultTableModel model = (DefaultTableModel) table_NV.getModel();

        String MaNV = txt_IDNhanVien.getText();
        String HoTen = txt_HoTen.getText();
        String CCCD = txt_CCCD.getText();
        String DiaChi = txt_DiaChi.getText();
        String SDT = txt_SDT.getText();
        String Email = txt_Email.getText()+"@gmail.com";
        Object GioiTinh = txt_GioiTinh.getItemAt(txt_GioiTinh.getSelectedIndex());
        String NgSinh = txt_NgaySinh.getText();
        int NamSinh = Integer.parseInt(NgSinh.substring(6));
        String NVL = txt_NgayVaoLam.getText();
        int NamVL = Integer.parseInt(NVL.substring(6));
        Object BoPhan = txt_BoPhan.getItemAt(txt_BoPhan.getSelectedIndex());
        int TinhTrang = txt_TinhTrang.getSelectedIndex();
        Object Luong = txt_Luong.getValue();
        
        try {
            if (kiemtrarangbuocNV(MaNV, HoTen, CCCD, DiaChi, SDT, Email, Luong, NamSinh, NamVL) && kiemtrarangbuocNV_HD(MaNV, NVL)) {
                Statement statement = connection.createStatement();
                String sql = "UPDATE NHANVIEN SET HOTEN = '" + HoTen + "', CCCD = '" + CCCD + "', DIACHI = '" + DiaChi + "', SDT = '" + SDT + "', EMAIL = '" + Email + "', GIOITINH = '" + GioiTinh + "', NGSINH = TO_DATE('" + NgSinh + "', 'DD-MM-YYYY'), NGVL = TO_DATE('" + NVL + "', 'DD-MM-YYYY'), BOPHAN = '" + BoPhan + "', LUONG = " + Luong + ", TINHTRANGLAMVIEC = " + TinhTrang + " WHERE MANV = '" + MaNV + "'";
                int res = statement.executeUpdate(sql);
                suaNV_jOptionPane.setVisible(true);
                suaNV_jOptionPane.showMessageDialog(formNV_jDialog, "Cập nhật nhân viên thành công!");
                formNV_jDialog.setVisible(false);
                System.out.println("Update TK thanh cong");

                model.setValueAt(HoTen, row, 1);
                model.setValueAt(GioiTinh, row, 2);
                model.setValueAt(NVL, row, 3);
                model.setValueAt(BoPhan, row, 4);
                model.setValueAt(Luong, row, 5);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    
//    public void uploadimg(ActionEvent e) {
//        JFileChooser chooser = new JFileChooser();
//        chooser.showOpenDialog(null);
//        File f = chooser.getSelectedFile();
//        String filename = f.getAbsolutePath();
//        txt_HoTen.setText(filename);
//        try {
//            ImageIcon ii = new ImageIcon(ImageIO.read(new File(f.getAbsolutePath())));//get the image from file chooser and scale it to match JLabel size
////        jLabel1.setIcon(ii);
//            Image image = ii.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
//            ImageIcon newIcon = new ImageIcon(image);
//            JLabel j = new JLabel();
//            j.setIcon(newIcon);
////        IDNhanVien.setIcon(newIcon);
//            formNV_jDialog.add(j);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
}
