/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.raven.datechooser.DateChooser;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author My PC
 */
public class PhieuNhap {
    private JPanel pane_bg;
    
    private JPanel pane_QLPhieuNhap;
    private DropShadowPane pane_shadow;
    private JTable table_PhieuNhap;
    private JScrollPane Scrollpane_TablePhieuNhap;
    
    public ButtonGradient btn_Kho;
    public ButtonGradient btn_PhieuXuat;
    public ButtonGradient btn_ThemPhieuNhap;
    public ButtonGradient btn_XacNhan  = new ButtonGradient();;
    public ButtonGradient btn_cancel_themPN  = new ButtonGradient();;
        
    public JPanel pane_Search;
    public JButton btn_Search;
    public JComboBox boxSearch;
    public JTextField txtSearch;
    
    private JPanel pane_textPhieuNhap;    

    private JTextField txt_MaPN;
    private JComboBox txt_GhiChu;
    private JTextField txt_MaNL;
    private JComboBox txt_TenNL;
    private JTextField txt_NgayNhap;
    private JTextField txt_NgayHetHan;
    private JFormattedTextField txt_SoLuong;
    private JTextField txt_DonVi;
    private JTextField txt_DonGia;
    private JComboBox txt_MaNCC;

    private JDialog formPN_jDialog;
    
    public JPanel pane_bg_ThemPhieuNhap;

    public JOptionPane themPN_jOptionPane = new JOptionPane();
    public JOptionPane suaPN_jOptionPane = new JOptionPane();
    private JOptionPane ThieuThongTin_jOptionPane = new JOptionPane();
    private JOptionPane Delete_Confirm_jOptionPane = new JOptionPane();
    
    private Connection connection;
    
    public PhieuNhap(Connection connection){        
        this.connection = connection;
        init_pane();
    }
    public void init_pane(){
        pane_bg = new JPanel();
        pane_bg.setOpaque(true);
        pane_bg.setBackground(new Color(230, 235, 240));

        pane_bg.setPreferredSize(new Dimension(800, 600)); 
        
        pane_shadow = new DropShadowPane(4, 0, 0, 0, Color.white, 50);
        pane_shadow.setPreferredSize(new Dimension(770, 550)); 
        
        pane_QLPhieuNhap = new JPanel();
        pane_QLPhieuNhap.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
        pane_QLPhieuNhap.setBackground(Color.white);
        pane_QLPhieuNhap.setPreferredSize(new Dimension(760, 540)); 
    }   
      
    public JPanel pane_PhieuNhap(){
        search_bar();
        pane_textPhieuNhap();
        table_PN();
        btn_ThemPhieuNhap();
        pane_shadow.add(pane_QLPhieuNhap);
        pane_bg.add(pane_shadow);
        return pane_bg;
    }
    
    public void search_bar(){
        pane_Search = new JPanel();
        pane_Search.setBackground(Color.white);
        pane_Search.setPreferredSize(new Dimension(800, 50));
        pane_Search.setBorder(new EmptyBorder(10, 0, 0, 0));
        pane_Search.setLayout(new FlowLayout(FlowLayout.CENTER, 9, 0)); 
        
        pane_search();
        btn_Kho();
        btn_PhieuXuat();
        
        pane_QLPhieuNhap.add(pane_Search);
    }
    
    public void pane_search(){
        JPanel pane_search_bar = new JPanel();
        pane_search_bar.setBackground(Color.white );
        pane_search_bar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        txtSearch = new JTextField(" Search");
        txtSearch.setPreferredSize(new Dimension(50, 31)); 
        txtSearch.setColumns(25);     
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
        
        String colname_NL[] = {"MAPN", "MANL", "SL", "DONGIA", "NGAYNHAP", "NGAYHETHAN", "GHICHU"};
        boxSearch = new JComboBox(colname_NL);
        boxSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boxSearch.setSelectedItem("TENNL");
        boxSearch.setFont(new Font("SansSerif", Font.BOLD, 14));
        boxSearch.setBackground(Color.white);
        boxSearch.setPreferredSize(new Dimension(135, 35)); 

        Search();
        
        pane_search_bar.setBorder(txtSearch.getBorder());
        txtSearch.setBorder(null);
        btn_Search.setBorder(null);
        
        pane_Search.add(pane_search_bar);
        pane_Search.add(boxSearch);
    }
    
    public void pane_ThemPhieuNhap(){
        pane_bg_ThemPhieuNhap = new JPanel();
        pane_bg_ThemPhieuNhap.setBackground(Color.white);
        pane_bg_ThemPhieuNhap.setPreferredSize(new Dimension(600, 500));
        pane_bg_ThemPhieuNhap.setBounds(70, 30, 600, 500);
    }
    
    public void Search(){
        btn_Search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (txtSearch.getText().equals("") || txtSearch.getText().equals(" Search")) {
                    add_data_table();
                } else {
                    boolean flag = false;
                    try {
                        String sql = "SELECT MAPN, MANL, SL, DONGIA, "
                                + "TO_CHAR(NGAYNHAP, 'DD-MM-YYYY') as NGAYNHAP, "
                                + "TO_CHAR(NGAYHETHAN, 'DD-MM-YYYY') as NGAYHETHAN, GHICHU "
                                + "FROM PHIEUNHAP WHERE " + boxSearch.getSelectedItem().toString() + " LIKE '%" + txtSearch.getText() + "%'";
                        Statement statement = connection.createStatement();
                        ResultSet res = statement.executeQuery(sql);

                        DefaultTableModel tbmodel = (DefaultTableModel) table_PhieuNhap.getModel();
                        tbmodel.setRowCount(0);

                        while (res.next()) {
                            flag = true;
                            String MAPN = res.getString("MAPN");
                            String MANL = res.getString("MANL");
                            String SL = res.getString("SL");
                            String DONGIA = res.getString("DONGIA");
                            String NGAYNHAP = res.getString("NGAYNHAP");
                            String GHICHU = res.getString("GHICHU");
                            String NGAYHETHAN = res.getString("NGAYHETHAN");

                            Object tbdata[] = {MAPN, MANL, SL, DONGIA, NGAYNHAP, NGAYHETHAN, GHICHU, null};
                            tbmodel.addRow(tbdata);
                        }
                    } catch (SQLException | HeadlessException ex) {
                        System.out.println("the error is" + ex);
                    }

                    if (!flag) {
                        JOptionPane search_jOptionPane = new JOptionPane();
                        search_jOptionPane.setVisible(true);
                        search_jOptionPane.showMessageDialog(pane_QLPhieuNhap, "Không tìm thấy phiếu nhập!");
                    }
                }
            }
        });
    }

    public void init_Dialog(){
        formPN_jDialog = new JDialog();
        formPN_jDialog.getContentPane().setBackground(new Color(255, 255, 255));
        formPN_jDialog.setPreferredSize(new Dimension(700, 500));
        formPN_jDialog.setModal(true);
        formPN_jDialog.setResizable(false);
        formPN_jDialog.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0,10));
    }
    
    public void Dialog_form( boolean loaiDialog, int row){
        boolean loai = loaiDialog;
        init_Dialog();
        
        JLabel MAPN = new JLabel("Mã phiếu nhập:");
        JLabel MANL = new JLabel("Mã nguyên liệu:");
        JLabel TENNL = new JLabel("Tên nguyên liệu:");
        JLabel DONVI = new JLabel("Đơn vị:");
        JLabel SL = new JLabel("Số lượng:");
        JLabel DONGIA = new JLabel("Đơn giá:");
        JLabel NGAYNHAP = new JLabel("Ngày nhập:");
        JLabel NGAYHETHAN = new JLabel("Ngày hết hạn:");
        JLabel TENNCC = new JLabel("Mã nhà cung cấp:");
        JLabel GHICHU = new JLabel("Ghi chú:");
        
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        
        txt_MaPN = new JTextField();
        String StrGhiChu[] = { "Thêm mới", "Cuối ngày"};
        txt_GhiChu = new JComboBox(StrGhiChu);
        txt_MaNL = new JTextField(); 
        txt_DonVi = new JTextField();
        txt_DonGia = new JTextField();
        txt_MaNCC = new JComboBox();

        ArrayList<String> StrTenNL = new ArrayList<String>(); 
        txt_TenNL = new JComboBox();
        Object[] arrTenNL = ChonThongTinNguyenLieu(StrTenNL);
        for (int i=0; i <arrTenNL.length; i++){
            txt_TenNL.addItem(arrTenNL[i]);
        }
        txt_TenNL.setSelectedIndex(1);
        setText_NCC(txt_TenNL.getItemAt(txt_TenNL.getSelectedIndex()));
        txt_TenNL.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    setText_NCC(txt_TenNL.getItemAt(txt_TenNL.getSelectedIndex()));
                }
            }
        });
        
        txt_NgayNhap = new JTextField();
        DateChooser NgayNhap_dateChooser = new DateChooser();
        NgayNhap_dateChooser.setForeground(new java.awt.Color(167, 223, 255));
        NgayNhap_dateChooser.setTextRefernce(txt_NgayNhap);
        
        txt_NgayHetHan = new JTextField();
        DateChooser NgayHetHan_dateChooser = new DateChooser();
        NgayHetHan_dateChooser.setForeground(new java.awt.Color(255, 184, 183));
        NgayHetHan_dateChooser.setTextRefernce(txt_NgayHetHan);
        
        txt_SoLuong = new JFormattedTextField(formatter);
        String StrDonVi[] = { "Kg", "g", "Cái", "Lon", "Chai", "Lít", "ml"};
        
        JPanel pane1 = new JPanel();
        pane1.setPreferredSize(new Dimension(600, 60));
        pane1.setLayout(new GridLayout(2, 2, 100, 3));
        pane1.setBackground(Color.white);
        pane1.add(MAPN);
        pane1.add(GHICHU);
        pane1.add(txt_MaPN);
        pane1.add(txt_GhiChu);
        
        JPanel pane2= new JPanel();
        pane2.setPreferredSize(new Dimension(600, 60));
        pane2.setLayout(new GridLayout(2, 2, 100, 3));
        pane2.setBackground(Color.white);
        pane2.add(MANL);
        pane2.add(TENNL);
        pane2.add(txt_MaNL);
        pane2.add(txt_TenNL);

        JPanel pane3 = new JPanel();
        pane3.setPreferredSize(new Dimension(600, 60));
        pane3.setLayout(new GridLayout(2, 2, 100, 3));
        pane3.setBackground(Color.white);        
        pane3.add(NGAYNHAP);
        pane3.add(NGAYHETHAN);
        pane3.add(txt_NgayNhap);
        pane3.add(txt_NgayHetHan);
        
        JPanel pane4 = new JPanel();
        pane4.setPreferredSize(new Dimension(600, 60));
        pane4.setLayout(new GridLayout(2, 2, 100, 3));
        pane4.setBackground(Color.white);  
        pane4.add(SL);
        pane4.add(TENNCC);
        pane4.add(txt_SoLuong);
        pane4.add(txt_MaNCC);
        
        JPanel pane5 = new JPanel();
        pane5.setPreferredSize(new Dimension(600, 60));
        pane5.setLayout(new GridLayout(2, 2, 100, 3));
        pane5.setBackground(Color.white);  
        pane5.add(DONVI);
        pane5.add(DONGIA);
        pane5.add(txt_DonVi);
        pane5.add(txt_DonGia);

        if(loai)
            setText_nextMAPN();
        else
            setText_currPN(row); //Lưu ý: sửa trong ngày!
        
        formPN_jDialog.getContentPane().add(pane1);
        formPN_jDialog.getContentPane().add(pane2);
        formPN_jDialog.getContentPane().add(pane3);
        formPN_jDialog.getContentPane().add(pane4);
        formPN_jDialog.getContentPane().add(pane5);
        
        JPanel pane_btn_DialogPN = new JPanel();
        pane_btn_DialogPN.setLayout(new FlowLayout(FlowLayout.RIGHT, 15,0));
        pane_btn_DialogPN.setPreferredSize(new Dimension(500, 80));
        pane_btn_DialogPN.setBorder(new EmptyBorder(50, 0, 0, 0));
        pane_btn_DialogPN.setBackground(Color.white);
        
        btn_XacNhan = new ButtonGradient();
        btn_XacNhan.setText("XÁC NHẬN");
        btn_XacNhan.setColor1(new Color(225,244,255));
        btn_XacNhan.setColor2(new Color(133,210,255));
        
        btn_cancel_themPN = new ButtonGradient();
        btn_cancel_themPN.setText("HỦY");
        btn_cancel_themPN.setColor1(new Color(255,231,231));
        btn_cancel_themPN.setColor2(new Color(255,130,145));
        
        btn_cancel_themPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_Dialog_jButtonActionPerformed(evt);
            }
        });
        pane_btn_DialogPN.add(btn_cancel_themPN);
        
        btn_XacNhan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(loai)
                    themPN_jButtonActionPerformed(evt);
                else
                    suaPN_jButtonActionPerformed(evt, row);
            
            }
        });
        pane_btn_DialogPN.add(btn_XacNhan);
        formPN_jDialog.getContentPane().add(pane_btn_DialogPN);
    }
    
    public Object[] ChonThongTinNguyenLieu(ArrayList<String> StrTenNL){
        try{
            String sql = "SELECT TENNL FROM KHONGUYENLIEU";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);
            while(res.next()){
                boolean flag_Trung = false;
                String TENNL = res.getString("TENNL");
                for(int i=0; i<StrTenNL.size(); i++)
                    if(StrTenNL.get(i).equals(TENNL)) 
                        flag_Trung = true;
                
                if(!flag_Trung)
                    StrTenNL.add(TENNL);
            }
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is"+ex);
        }
        Object[] arr = StrTenNL.toArray();
        return arr;
    }
    
    public void btn_Kho(){
        btn_Kho = new ButtonGradient();
        
        btn_Kho.setText("KHO");
        btn_Kho.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_Kho.setFont(new Font(btn_Kho.getFont().getName(),Font.BOLD,btn_Kho.getFont().getSize()));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/cardboard.png"));
        Image image = icon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_Kho.setIcon(newIcon);
        
        btn_Kho.setVerticalTextPosition(SwingConstants.CENTER);
        btn_Kho.setHorizontalTextPosition(SwingConstants.RIGHT);
        btn_Kho.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Da bam phieu nhap");
//                PhieuNhap_Dialog(e);
            }
        });
        
        pane_Search.add(btn_Kho);
    }  

    public void btn_PhieuXuat(){
        btn_PhieuXuat = new ButtonGradient();
        btn_PhieuXuat.setColor1(new Color(225,244,255));
        btn_PhieuXuat.setColor2(new Color(133,210,255));
        
        btn_PhieuXuat.setText("PHIẾU XUẤT");
        btn_PhieuXuat.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_PhieuXuat.setFont(new Font(btn_PhieuXuat.getFont().getName(),Font.BOLD,btn_PhieuXuat.getFont().getSize()));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/xuatkho.png"));
        Image image = icon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_PhieuXuat.setIcon(newIcon);
        
        btn_PhieuXuat.setVerticalTextPosition(SwingConstants.CENTER);
        btn_PhieuXuat.setHorizontalTextPosition(SwingConstants.RIGHT);
        btn_PhieuXuat.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Da bam phieu xuat");
//                PhieuXuat_Dialog(e);
            }
        });
        
        pane_Search.add(btn_PhieuXuat);
    }      
    
    public void btn_ThemPhieuNhap(){
        JPanel pane_ThemPhieuNhap = new JPanel();
        pane_ThemPhieuNhap.setPreferredSize(new Dimension(700,50));
        pane_ThemPhieuNhap.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        pane_ThemPhieuNhap.setBackground(Color.white);

        btn_ThemPhieuNhap = new ButtonGradient();
        btn_ThemPhieuNhap.setColor1(new Color(255,231,231));
        btn_ThemPhieuNhap.setColor2(new Color(255,130,145));
        btn_ThemPhieuNhap.setText("THÊM PHIẾU NHẬP");
        btn_ThemPhieuNhap.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_ThemPhieuNhap.setFont(new Font(btn_ThemPhieuNhap.getFont().getName(),Font.BOLD,btn_ThemPhieuNhap.getFont().getSize()));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/add.png"));
        Image image = icon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_ThemPhieuNhap.setIcon(newIcon);
        
        btn_ThemPhieuNhap.setVerticalTextPosition(SwingConstants.CENTER);
        btn_ThemPhieuNhap.setHorizontalTextPosition(SwingConstants.RIGHT);
        btn_ThemPhieuNhap.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ThemPhieuNhap_Dialog(e);
            }
        });
        
        pane_ThemPhieuNhap.add(btn_ThemPhieuNhap);
        pane_QLPhieuNhap.add(pane_ThemPhieuNhap);
    }  
    
    private void pane_textPhieuNhap(){
        JLabel textPhieuNhap = new JLabel("PHIẾU NHẬP");
        textPhieuNhap.setFont(new Font(textPhieuNhap.getFont().getName(), Font.BOLD, 20));
        
        pane_textPhieuNhap = new JPanel();
        pane_textPhieuNhap.setBackground(new Color(255,183,182));
        pane_textPhieuNhap.setPreferredSize(new Dimension(760, 50));
        pane_textPhieuNhap.setBorder(new EmptyBorder(7, 0, 0,0));
        
        pane_textPhieuNhap.add(textPhieuNhap);
        pane_QLPhieuNhap.add(pane_textPhieuNhap);
    }
    
    public void table_PN(){
        Scrollpane_TablePhieuNhap= new JScrollPane();

        String[] columnNames = {"Mã phiếu nhập", "Mã nguyên liệu", "Số lượng", "Đơn giá", "Ngày nhập", "Ngày hết hạn", "Ghi chú", ""};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };
            
            @Override
            public boolean isCellEditable(int row, int column) {
               return canEdit [column];
            }
        };
        table_PhieuNhap = new JTable(model);
        table_PhieuNhap.setRowHeight(40);
        table_PhieuNhap.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ?  new Color(255, 234, 234): new Color(255,244,248));
                c.setForeground(Color.black);
                return c;
            }
        });        
        
        table_PhieuNhap.getTableHeader().setOpaque(false);
        table_PhieuNhap.getTableHeader().setBackground(new Color(255,183,182));
        table_PhieuNhap.getTableHeader().setForeground(Color.black);
        table_PhieuNhap.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table_PhieuNhap.getTableHeader().setPreferredSize(new Dimension(table_PhieuNhap.getWidth(),40));
        table_PhieuNhap.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
                
        table_PhieuNhap.setShowHorizontalLines(false);
        table_PhieuNhap.setGridColor(Color.white);
        table_PhieuNhap.setBackground(Color.white);
        table_PhieuNhap.setBorder(new EmptyBorder(5, 5, 5,5));
        table_PhieuNhap.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        TableColumnModel columnModel = table_PhieuNhap.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
        
        add_data_table();
        
        table_PhieuNhap.setPreferredScrollableViewportSize(table_PhieuNhap.getPreferredSize());
        table_PhieuNhap.setFillsViewportHeight(true);
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                SuaPhieuNhap_Dialog(row);
            }

            @Override
            public void onDelete(int row) {
                if(table_PhieuNhap.isEditing()) {
                    table_PhieuNhap.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) table_PhieuNhap.getModel();
                Object value_MAPN = model.getValueAt(row, 0);
                System.out.println(value_MAPN);
                try {
                    Statement statement = connection.createStatement();
                    Delete_Confirm_jOptionPane.setVisible(true);
                    int flag_OK = Delete_Confirm_jOptionPane.showConfirmDialog(formPN_jDialog, "Bạn chắc chắn muốn xóa phiếu nhập?",null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(flag_OK == JOptionPane.OK_OPTION){
                        String sql = "DELETE FROM PHIEUNHAP WHERE MAPN = '" + value_MAPN + "'";
                        int res = statement.executeUpdate(sql);
                        System.out.println("Delete PN thanh cong");
                        model.removeRow(row);
                    }
                } catch (SQLException ex) {
                    JOptionPane option_Xoa_KhongDuoc = new JOptionPane();
                    option_Xoa_KhongDuoc.setVisible(true);
                    option_Xoa_KhongDuoc.showMessageDialog(formPN_jDialog, "Không thể xóa phiếu nhập!");
                    option_Xoa_KhongDuoc.setMessageType(JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        table_PhieuNhap.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender( new Color(255, 234, 234), new Color(255,244,248),true, true));
        table_PhieuNhap.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event, new Color(255, 234, 234), new Color(255,244,248),true, true, false, 4));
        
        Scrollpane_TablePhieuNhap.setViewportView(table_PhieuNhap);
        Scrollpane_TablePhieuNhap.setBorder(new LineBorder( Color.LIGHT_GRAY, 1, true));
        Scrollpane_TablePhieuNhap.setPreferredSize(new Dimension(700, 330));
        pane_QLPhieuNhap.add(Scrollpane_TablePhieuNhap);
    }
    
    public void add_data_table(){
        try{
            DefaultTableModel tbmodel = (DefaultTableModel)table_PhieuNhap.getModel();
            String sql = "SELECT MAPN, MANL, SL, DONGIA, "
                    + "TO_CHAR(NGAYNHAP, 'DD-MM-YYYY') as NGAYNHAP, "
                    + "TO_CHAR(NGAYHETHAN, 'DD-MM-YYYY') as NGAYHETHAN, GHICHU "
                    + "FROM PHIEUNHAP ORDER BY TO_NUMBER(SUBSTR( MAPN, 3 ))";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);

            tbmodel.setRowCount(0);
            while(res.next()){
                String MAPN = res.getString("MAPN");
                String MANL = res.getString("MANL");
                String SL = res.getString("SL");
                String DONGIA = res.getString("DONGIA");
                String NGAYNHAP = res.getString("NGAYNHAP");
                String GHICHU = res.getString("GHICHU");
                String NGAYHETHAN = res.getString("NGAYHETHAN");
                
                Object tbdata[] = {MAPN, MANL, SL, DONGIA, NGAYNHAP, NGAYHETHAN, GHICHU, null};
                tbmodel.addRow(tbdata);
            }
        }
        catch(SQLException | HeadlessException ex){
                    System.out.println("the error is"+ex);
        }
    }
    
    private void Number_keyPressed(KeyEvent e, JTextField txt, int len) {
        String PhoneNumber = txt.getText();
        int length = PhoneNumber.length();
        char c = e.getKeyChar();
        if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9'){
            if(length < len)
                txt.setEditable(true);
            else 
                txt.setEditable(false);
        }
        else {
            if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE)
                txt.setEditable(true);
            else 
                txt.setEditable(false);
        }
    }
    private void setText_nextMAPN(){
        String MAPN;
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT TO_NUMBER(SUBSTR(MAPN, 3))+1 NUM_PN FROM PHIEUNHAP ORDER BY TO_NUMBER(SUBSTR( MAPN, 3 )) DESC";
            ResultSet res = statement.executeQuery(sql);
            boolean flag = false;
            while(res.next()){
                flag = true;
                MAPN = "PN" + res.getInt("NUM_PN");
                txt_MaPN.setText(MAPN);
                txt_MaPN.setForeground(new Color (134, 134, 134));
                txt_MaPN.setEditable(false);
                break;
            }
            if(!flag){
                MAPN = "PN1";
                txt_MaPN.setText(MAPN);
                txt_MaPN.setForeground(new Color (134, 134, 134));
                txt_MaPN.setEditable(false);
            }
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is "+ex);
        }
    }
    
    private void setText_NL(Object TENNL, Object MANCC){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM KHONGUYENLIEU WHERE TENNL = '"+TENNL+"' AND MANCC = '" + MANCC + "'";
            ResultSet res = statement.executeQuery(sql);
            while(res.next()){
                String MANL = res.getString("MANL");
                txt_MaNL.setText(MANL);
                txt_MaNL.setForeground(new Color (134, 134, 134));
                txt_MaNL.setEditable(false);
                
                String DONVI = res.getString("DONVI");
                txt_DonVi.setText(DONVI);
                txt_DonVi.setForeground(new Color (134, 134, 134));
                txt_DonVi.setEditable(false);
                
                String DONGIA = res.getString("DONGIA");
                txt_DonGia.setText(DONGIA);
                txt_DonGia.setForeground(new Color (134, 134, 134));
                txt_DonGia.setEditable(false);
    
            }
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is "+ex);
        }
    }    
    
    private void setText_NCC(Object TENNL){
        ArrayList<String> StrMaNCC = new ArrayList<String>();
        txt_MaNCC.removeAllItems();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT MANCC FROM KHONGUYENLIEU WHERE TENNL = '"+TENNL.toString()+"'";
            ResultSet res = statement.executeQuery(sql);
            while(res.next()){
                String MANCC = res.getString("MANCC");
                StrMaNCC.add(MANCC);
            }
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is "+ex);
        }
        
        Object[] arrMaNCC = StrMaNCC.toArray();
        for (int i=0; i <arrMaNCC.length; i++)
            txt_MaNCC.addItem(arrMaNCC[i]);
        setText_NL(txt_TenNL.getItemAt(txt_TenNL.getSelectedIndex()), txt_MaNCC.getItemAt(txt_MaNCC.getSelectedIndex()));        
        txt_MaNCC.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
                if (e.getStateChange() == ItemEvent.SELECTED) 
                    setText_NL(txt_TenNL.getItemAt(txt_TenNL.getSelectedIndex()), txt_MaNCC.getItemAt(txt_MaNCC.getSelectedIndex()));
            }
        }); 
    }
    private void ThemPhieuNhap_Dialog(ActionEvent evt) {
        Dialog_form(true, -1);
        formPN_jDialog.pack();
        formPN_jDialog.setLocationRelativeTo(null);
        formPN_jDialog.setVisible(true);
    }   
    private void Exit_Dialog_jButtonActionPerformed(ActionEvent evt) {
        formPN_jDialog.setVisible(false);
    }
    public void themPN_jButtonActionPerformed(ActionEvent evt){
        String MaPN = txt_MaPN.getText();            
        String MaNL = txt_MaNL.getText();
        Object MaNCC = txt_MaNCC.getItemAt(txt_MaNCC.getSelectedIndex());      
        Object SoLuong = txt_SoLuong.getValue();
        String DonGia = txt_DonGia.getText();
        String NgayNhap = txt_NgayNhap.getText();
        String NgayHetHan = txt_NgayHetHan.getText();
        Object GhiChu = txt_GhiChu.getItemAt(txt_GhiChu.getSelectedIndex());
             
        try {
            Statement statement = connection.createStatement();
            if (SoLuong == null) {
                ThieuThongTin_jOptionPane.setVisible(true);
                ThieuThongTin_jOptionPane.showMessageDialog(formPN_jDialog, "Vui lòng nhập đầy đủ thông tin!");
                ThieuThongTin_jOptionPane.setMessageType(JOptionPane.WARNING_MESSAGE);
            } else {
                String sql = "INSERT INTO PHIEUNHAP VALUES (  '" + MaPN + "' , '" + MaNL + "', " + SoLuong + ", " + DonGia + ", TO_DATE('" + NgayNhap + "', 'DD-MM-YYYY'), TO_DATE('" + NgayHetHan + "', 'DD-MM-YYYY'), '"+ GhiChu +"' )";
                int res = statement.executeUpdate(sql);
                System.out.println("Insert thanh cong");
                themPN_jOptionPane.setVisible(true);
                themPN_jOptionPane.showMessageDialog(formPN_jDialog, "Thêm phiếu nhập kho và cập nhật số lượng nguyên liệu thành công!");
                formPN_jDialog.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            String sql= "SELECT * FROM PHIEUNHAP WHERE MAPN = '" + MaPN +"'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);

            while(res.next()){
                Object tbdata[] = {MaPN, MaNL, SoLuong, DonGia, NgayNhap, NgayHetHan, GhiChu, null};
                DefaultTableModel tbmodel = (DefaultTableModel)table_PhieuNhap.getModel();
                tbmodel.addRow(tbdata);
                break;
            }
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is "+ex);
        }
    }
    
    private void SuaPhieuNhap_Dialog(int row) {
        Dialog_form(false, row);
        formPN_jDialog.pack();
        formPN_jDialog.setLocationRelativeTo(null);
        formPN_jDialog.setVisible(true);
    }
    
    private void setText_currPN(int row){
        DefaultTableModel model = (DefaultTableModel) table_PhieuNhap.getModel();
        Object value_MAPN = model.getValueAt(row, 0);
        System.out.println(value_MAPN);
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT MAPN, MANL, SL, DONGIA, "
                    + "TO_CHAR(NGAYNHAP, 'DD-MM-YYYY') as NGAYNHAP, "
                    + "TO_CHAR(NGAYHETHAN, 'DD-MM-YYYY') as NGAYHETHAN, GHICHU "
                    + "FROM PHIEUNHAP WHERE MAPN = '" + value_MAPN + "'";
            ResultSet res = statement.executeQuery(sql);
            System.out.println(value_MAPN + " thanh cong");

            while (res.next()) {
                String MaPN = res.getString("MAPN");
                String MaNL = res.getString("MANL");
                String SoLuong = res.getString("SL");
                String DonGia = res.getString("DONGIA");
                String NgayNhap = res.getString("NGAYNHAP");
                String GhiChu = res.getString("GHICHU");
                String NgayHetHan = res.getString("NGAYHETHAN");

                txt_MaPN.setText(MaPN);
                txt_MaPN.setForeground(new Color(134, 134, 134));
                txt_MaPN.setEditable(false);
                
                txt_MaNL.setText(MaNL);
                txt_MaNL.setForeground(new Color(134, 134, 134));
                txt_MaNL.setEditable(false);
                
                txt_SoLuong.setText(SoLuong);
                txt_DonGia.setText(DonGia);
                txt_NgayNhap.setText(NgayNhap);
                txt_NgayHetHan.setText(NgayHetHan);
                txt_GhiChu.setSelectedItem(GhiChu);

                Statement statement1 = connection.createStatement();
                String sql1 = "SELECT * FROM KHONGUYENLIEU WHERE MANL = '" + MaNL + "'";
                ResultSet res1 = statement1.executeQuery(sql1);
                while (res1.next()) {
                    String TenNL = res1.getString("TENNL");
                    String MaNCC = res1.getString("MANCC");
                    txt_TenNL.setSelectedItem(TenNL);
                    txt_MaNCC.setSelectedItem(MaNCC);
                    setText_NCC(TenNL);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void suaPN_jButtonActionPerformed(ActionEvent evt, int row){
        DefaultTableModel model = (DefaultTableModel) table_PhieuNhap.getModel();
        String MaPN = txt_MaPN.getText();
        String MaNL = txt_MaNL.getText();
        Object MaNCC = txt_MaNCC.getItemAt(txt_MaNCC.getSelectedIndex());
        Object SoLuong = txt_SoLuong.getValue();
        String DonGia = txt_DonGia.getText();
        String NgayNhap = txt_NgayNhap.getText();
        String NgayHetHan = txt_NgayHetHan.getText();
        Object GhiChu = txt_GhiChu.getItemAt(txt_GhiChu.getSelectedIndex());
        
        try {
            Statement statement = connection.createStatement();
            String sql = "UPDATE PHIEUNHAP SET MANL = '"+MaNL+"', SL = '" +SoLuong+ "', DONGIA = '" +DonGia+ "', NGAYNHAP = TO_DATE('"+NgayNhap+"', 'DD-MM-YYYY'), GHICHU = '" +GhiChu+ "', NGAYHETHAN = TO_DATE('"+NgayHetHan+"', 'DD-MM-YYYY') WHERE MAPN = '" + MaPN + "'";
            int res = statement.executeUpdate(sql); 
            suaPN_jOptionPane.setVisible(true);
            suaPN_jOptionPane.showMessageDialog(formPN_jDialog, "Cập nhật phiếu nhập và số lượng nguyên liệu thành công!");
            formPN_jDialog.setVisible(false);
            System.out.println("Update PN thanh cong");
            
            model.setValueAt(MaNL, row, 1);
            model.setValueAt(SoLuong, row, 2);
            model.setValueAt(DonGia, row, 3);
            model.setValueAt(NgayNhap, row, 4);
            model.setValueAt(NgayHetHan, row, 5);
            model.setValueAt(GhiChu, row, 6);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}