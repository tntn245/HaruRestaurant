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
public class QuanlyKho {
    public PhieuNhap phieunhap;
    
    private JPanel pane_bg;
    
    private JPanel pane_QLKho;
    private DropShadowPane pane_shadow;
    private JTable table_Kho;
    private JScrollPane Scrollpane_TableKho;
    
    public ButtonGradient btn_PhieuNhap;
    public ButtonGradient btn_PhieuXuat;
    public ButtonGradient btn_ThemNL;
    
    public JPanel pane_Search;
    public JButton btn_Search;
    public JComboBox boxSearch;
    public JTextField txtSearch;
    
    public JDialog formNL_jDialog;
    
    public JOptionPane themNL_jOptionPane = new JOptionPane();
    public JOptionPane suaNL_jOptionPane = new JOptionPane();
    
    private JTextField txt_MaNL;
    private JTextField txt_TenNL;
    private JFormattedTextField txt_DonGia;
    private JComboBox txt_DonVi;
    private JFormattedTextField txt_SoLuong;
    private JTextField txt_MaNCC;
    private JComboBox txt_TenNCC;

    private JOptionPane ThieuThongTin_jOptionPane = new JOptionPane();
    private JOptionPane NLTontai_jOptionPane = new JOptionPane();
    private JOptionPane Delete_Confirm_jOptionPane = new JOptionPane();
    
    private Connection connection;
    
    public QuanlyKho(Connection connection){
        this.connection = connection;
        phieunhap = new PhieuNhap(connection);
        init_pane();
    }
    public void init_pane(){
        pane_bg = new JPanel();
        pane_bg.setOpaque(true);
        pane_bg.setBackground(new Color(230, 235, 240));

        pane_bg.setPreferredSize(new Dimension(800, 600)); 
        
        pane_shadow = new DropShadowPane(4, 0, 0, 0, Color.white, 50);
        pane_shadow.setPreferredSize(new Dimension(770, 550)); 
        
        pane_QLKho = new JPanel();
        pane_QLKho.setBackground(Color.white);
        pane_QLKho.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
        pane_QLKho.setPreferredSize(new Dimension(760, 540)); 
    }    
    public JPanel pane_QLKho(){
        search_bar();
        table_NL();
        btn_ThemNL();
        pane_shadow.add(pane_QLKho);
        pane_bg.add(pane_shadow);
        return pane_bg;
    }
    
    public void search_bar(){
        pane_Search = new JPanel();
        pane_Search.setBackground(Color.white);
        pane_Search.setPreferredSize(new Dimension(800, 50)); 
        pane_Search.setBorder(new EmptyBorder(10, 0, 0, 0));
        pane_Search.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 0));
        
        pane_search();
        
        btn_PhieuNhap();
        btn_PhieuXuat();
        
        pane_QLKho.add(pane_Search);
    }
    
    public void pane_search(){
        JPanel pane_search_bar = new JPanel();
        pane_search_bar.setBackground(Color.white );
        pane_search_bar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        txtSearch = new JTextField(" Search");
        txtSearch.setPreferredSize(new Dimension(50, 31)); 
        txtSearch.setColumns(21);     
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
        
        String colname_NL[] = {"MANL", "TENNL", "DONGIA", "DONVI", "TONGSL"};
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
    
    public void Search(){
        btn_Search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (txtSearch.getText().equals("") || txtSearch.getText().equals(" Search")) {
                    add_data_table();
                } else {
                    boolean flag = false;
                    try {
                        String sql = "SELECT * FROM KHONGUYENLIEU WHERE " + boxSearch.getSelectedItem().toString() + " LIKE '%" + txtSearch.getText() + "%'";
                        Statement statement = connection.createStatement();
                        ResultSet res = statement.executeQuery(sql);

                        DefaultTableModel tbmodel = (DefaultTableModel) table_Kho.getModel();
                        tbmodel.setRowCount(0);

                        while (res.next()) {
                            flag = true;
                            String MANL = res.getString("MANL");
                            String TENNL = res.getString("TENNL");
                            String DONGIA = res.getString("DONGIA");
                            String DONVI = res.getString("DONVI");
                            String TONGSL = res.getString("TONGSL");

                            Object tbdata[] = {MANL, TENNL, DONGIA, DONVI, TONGSL, null};
                            tbmodel.addRow(tbdata);
                        }
                    } catch (SQLException | HeadlessException ex) {
                        System.out.println("the error is" + ex);
                    }

                    if (!flag) {
                        JOptionPane search_jOptionPane = new JOptionPane();
                        search_jOptionPane.setVisible(true);
                        search_jOptionPane.showMessageDialog(pane_QLKho, "Không tìm thấy nguyên liệu!");
                    }
                }
            }
        });
    }

    public void init_Dialog(){
        formNL_jDialog = new JDialog();
        formNL_jDialog.getContentPane().setBackground(new Color(255, 255, 255));
        formNL_jDialog.setPreferredSize(new Dimension(600, 400));
        formNL_jDialog.setModal(true);
        formNL_jDialog.setResizable(false);
        formNL_jDialog.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0,30));
    }
    
    public void Dialog_form( boolean loaiDialog, int row){
        boolean loai = loaiDialog;
        init_Dialog();
        
        JLabel MANL = new JLabel("Mã nguyên liệu:");
        JLabel TENNL = new JLabel("Tên nguyên liệu:");
        JLabel DONGIA = new JLabel("Đơn giá:");
        JLabel DONVI = new JLabel("Đơn vị:");
        JLabel TONGSL = new JLabel("Tổng số lượng:");
        JLabel MANCC = new JLabel("Mã nhà cung cấp:");
        JLabel TENNCC = new JLabel("Tên nhà cung cấp:");
        
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        
        txt_MaNL = new JTextField();
        txt_TenNL = new JTextField();
        txt_DonGia = new JFormattedTextField(formatter);
        txt_SoLuong = new JFormattedTextField(formatter);
        String StrDonVi[] = { "Kg", "g", "Cái", "Lon", "Chai", "Lít", "ml"}; 
        txt_DonVi = new JComboBox(StrDonVi);
        txt_DonVi.setSelectedIndex(0);
        txt_MaNCC = new JTextField();
        txt_TenNCC = new JComboBox();
        ArrayList<String> StrTenNCC = new ArrayList<String>(); 
        Object[] arrTenNCC = ChonThongTinNCC(StrTenNCC);
        for (int i=0; i <arrTenNCC.length; i++){
            txt_TenNCC.addItem(arrTenNCC[i]);
        }
        setText_NCC(txt_TenNCC.getItemAt(txt_TenNCC.getSelectedIndex()));
        txt_TenNCC.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Object item = e.getItem();
                    setText_NCC(item);
                }
            }
        });
//"<Thêm mới>",
//        txt_DonVi.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent e) { 
//                if (e.getStateChange() == ItemEvent.SELECTED) {
//                    Object item = e.getItem();
//                    if(item == "<Thêm mới>"){
//                        DonVi_Input_OptionPane();
//                    }
//                }
//            }
//        });
 
        JPanel pane_TongQuanNL = new JPanel();
        pane_TongQuanNL.setPreferredSize(new Dimension(500, 50));
        pane_TongQuanNL.setLayout(new GridLayout(2, 2, 100, 0));
        pane_TongQuanNL.setBackground(Color.white);
        pane_TongQuanNL.add(MANL);
        pane_TongQuanNL.add(TENNL);
        pane_TongQuanNL.add(txt_MaNL);
        pane_TongQuanNL.add(txt_TenNL);

        JPanel pane_ChiTietNL = new JPanel();
        pane_ChiTietNL.setPreferredSize(new Dimension(500, 50));
        pane_ChiTietNL.setLayout(new GridLayout(2, 3, 50, 0));
        pane_ChiTietNL.setBackground(Color.white);
        pane_ChiTietNL.add(DONGIA);
        pane_ChiTietNL.add(DONVI);
        pane_ChiTietNL.add(TONGSL);
        pane_ChiTietNL.add(txt_DonGia);
        pane_ChiTietNL.add(txt_DonVi);
        pane_ChiTietNL.add(txt_SoLuong);
        
        JPanel pane_NCC = new JPanel();
        pane_NCC.setPreferredSize(new Dimension(500, 50));
        pane_NCC.setLayout(new GridLayout(2, 2, 100, 0));
        pane_NCC.setBackground(Color.white);
        pane_NCC.add(MANCC);
        pane_NCC.add(TENNCC);
        pane_NCC.add(txt_MaNCC);
        pane_NCC.add(txt_TenNCC);        

        if(loai){
            setText_nextMANL();
            setText_init_SL0();
        }
        else{
            setText_currNL(row);
        }
        
        formNL_jDialog.getContentPane().add(pane_TongQuanNL);
        formNL_jDialog.getContentPane().add(pane_NCC);  
        formNL_jDialog.getContentPane().add(pane_ChiTietNL);      
               
        JPanel pane_btn_DialogNL = new JPanel();
        pane_btn_DialogNL.setLayout(new FlowLayout(FlowLayout.RIGHT, 15,0));
        pane_btn_DialogNL.setPreferredSize(new Dimension(500, 80));
        pane_btn_DialogNL.setBorder(new EmptyBorder(30, 0, 0, 0));
        pane_btn_DialogNL.setBackground(Color.white);
        
        ButtonGradient btn_cancel_themNL = new ButtonGradient();
        btn_cancel_themNL.setText("HỦY");
        btn_cancel_themNL.setColor1(new Color(255,231,231));
        btn_cancel_themNL.setColor2(new Color(255,130,145));
        btn_cancel_themNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_Dialog_jButtonActionPerformed(evt);
            }
        });
        pane_btn_DialogNL.add(btn_cancel_themNL);
        
        ButtonGradient btn_XacNhan = new ButtonGradient();
        btn_XacNhan.setText("XÁC NHẬN");
        btn_XacNhan.setColor1(new Color(225,244,255));
        btn_XacNhan.setColor2(new Color(133,210,255));
        btn_XacNhan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(loai)
                    themNL_jButtonActionPerformed(evt);
                else 
                    suaNL_jButtonActionPerformed(evt, row);
            }
        });
        pane_btn_DialogNL.add(btn_XacNhan);
        formNL_jDialog.getContentPane().add(pane_btn_DialogNL);
    }
    
    public Object[] ChonThongTinNCC(ArrayList<String> StrTenNCC){
        try{
            String sql = "SELECT TENNCC FROM NHACUNGCAP";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);

            while(res.next()){
                String TENNCC = res.getString("TENNCC");
                StrTenNCC.add(TENNCC);
            }
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is"+ex);
        }
        
        Object[] arr = StrTenNCC.toArray();
        return arr;
    }
    
    private void setText_NCC(Object TENNCC){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM NHACUNGCAP WHERE TENNCC = '"+TENNCC+"'";
            ResultSet res = statement.executeQuery(sql);
            while(res.next()){
                String MANCC = res.getString("MANCC");
                txt_MaNCC.setText(MANCC);
                txt_MaNCC.setForeground(new Color (134, 134, 134));
                txt_MaNCC.setEditable(false);
                
//                String DIACHI = res.getString("DIACHI");
//                txt_DiaChi.setText(DIACHI);
//                txt_DiaChi.setForeground(new Color (134, 134, 134));
//                txt_DiaChi.setEditable(false);
                
                break;
            }
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is "+ex);
        }
    }
    
    public void btn_PhieuNhap(){
        btn_PhieuNhap = new ButtonGradient();
        btn_PhieuNhap.setColor1(new Color(255,231,231));
        btn_PhieuNhap.setColor2(new Color(255,130,145));
        
        btn_PhieuNhap.setText("PHIẾU NHẬP");
        btn_PhieuNhap.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_PhieuNhap.setFont(new Font(btn_PhieuNhap.getFont().getName(),Font.BOLD,btn_PhieuNhap.getFont().getSize()));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/nhapkho.png"));
        Image image = icon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_PhieuNhap.setIcon(newIcon);
        
        btn_PhieuNhap.setVerticalTextPosition(SwingConstants.CENTER);
        btn_PhieuNhap.setHorizontalTextPosition(SwingConstants.RIGHT);
        
        pane_Search.add(btn_PhieuNhap);
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
        
        pane_Search.add(btn_PhieuXuat);
    }      
    
    public void btn_ThemNL(){
        JPanel pane_themNL = new JPanel();
        pane_themNL.setPreferredSize(new Dimension(700,50));
        pane_themNL.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        pane_themNL.setBackground(Color.white);

        btn_ThemNL = new ButtonGradient();
        btn_ThemNL.setText("THÊM NGUYÊN LIỆU");
        btn_ThemNL.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_ThemNL.setFont(new Font(btn_ThemNL.getFont().getName(),Font.BOLD,btn_ThemNL.getFont().getSize()));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/add.png"));
        Image image = icon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_ThemNL.setIcon(newIcon);
        
        btn_ThemNL.setVerticalTextPosition(SwingConstants.CENTER);
        btn_ThemNL.setHorizontalTextPosition(SwingConstants.RIGHT);
        btn_ThemNL.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Da bam them NL");
                ThemNguyenLieu_Dialog(e);
            }
        });
        
        pane_themNL.add(btn_ThemNL);
        pane_QLKho.add(pane_themNL);
    }  
    
    public void table_NL(){
        Scrollpane_TableKho= new JScrollPane();

        String[] columnNames = {"Mã NL", "Tên nguyên liệu", "Đơn giá", "Đơn vị", "Tổng số lượng", "Mã NCC", ""};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };
            
            @Override
            public boolean isCellEditable(int row, int column) {
               return canEdit [column];
            }
        };
        table_Kho = new JTable(model);
        table_Kho.setRowHeight(40);
        table_Kho.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ? new Color(234,247,255) : new Color(255, 237, 243));
                c.setForeground(Color.black);
                return c;
            }
        });        
        
        table_Kho.getTableHeader().setOpaque(false);
        table_Kho.getTableHeader().setBackground(new Color(167,222,254));
        table_Kho.getTableHeader().setForeground(Color.black);
        table_Kho.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table_Kho.getTableHeader().setPreferredSize(new Dimension(table_Kho.getWidth(),40));
        table_Kho.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
                
        table_Kho.setShowHorizontalLines(false);
        table_Kho.setGridColor(Color.white);
        table_Kho.setBackground(Color.white);
        table_Kho.setBorder(new EmptyBorder(5, 5, 5,5));
        table_Kho.setFont(new Font("SansSerif", Font.PLAIN, 14));
//        table_NV.setFont(new Font(table_NV.getFont().getName(),Font.PLAIN,14));
        
        TableColumnModel columnModel = table_Kho.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
        
        add_data_table();
        
        table_Kho.setPreferredScrollableViewportSize(table_Kho.getPreferredSize());
        table_Kho.setFillsViewportHeight(true);
//        table_NV.setSelectionBackground(new Color(56, 138, 112));
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                SuaNguyenLieu_Dialog(row);
            }

            @Override
            public void onDelete(int row) {
                if(table_Kho.isEditing()) {
                    table_Kho.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) table_Kho.getModel();
                Object value_MANL = model.getValueAt(row, 0);
                System.out.println(value_MANL);
                try {
                    Statement statement = connection.createStatement();
                    Delete_Confirm_jOptionPane.setVisible(true);
                    int flag_OK = Delete_Confirm_jOptionPane.showConfirmDialog(formNL_jDialog, "Bạn chắc chắn muốn xóa nguyên liệu?",null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(flag_OK == JOptionPane.OK_OPTION){
                        String sql = "DELETE FROM KHONGUYENLIEU WHERE MANL = '" + value_MANL + "'";
                        int res = statement.executeUpdate(sql);
                        System.out.println("Delete NL thanh cong");
                        model.removeRow(row);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
//        PanelAction1 action = new PanelAction1(true, true);
        table_Kho.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender(new Color(234,247,255), new Color(255, 237, 243),true, false));
        table_Kho.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event, new Color(234,247,255), new Color(255, 237, 243),true, false));
        
        Scrollpane_TableKho.setViewportView(table_Kho);
        Scrollpane_TableKho.setBorder(new LineBorder( Color.LIGHT_GRAY, 1, true));
        Scrollpane_TableKho.setPreferredSize(new Dimension(700, 400));
        pane_QLKho.add(Scrollpane_TableKho);
    }
    
    public void add_data_table(){
        DefaultTableModel tbmodel = (DefaultTableModel)table_Kho.getModel();
        try{
            String sql = "SELECT * FROM KHONGUYENLIEU ORDER BY TO_NUMBER(SUBSTR( MANL, 3 ))";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);

            tbmodel.setRowCount(0);
            while(res.next()){
                String MANL = res.getString("MANL");
                String TENNL = res.getString("TENNL");
                String DONGIA = res.getString("DONGIA");
                String DONVI = res.getString("DONVI");
                String TONGSL = res.getString("TONGSL");
                String MANCC = res.getString("MANCC");

                Object tbdata[] = {MANL, TENNL, DONGIA, DONVI, TONGSL, MANCC, null};
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

    private void DonVi_Input_OptionPane(){
        String new_DonVi = JOptionPane.showInputDialog("Mời bạn nhập đơn vị mới:");
        txt_DonVi.addItem(new_DonVi);
        txt_DonVi.setSelectedItem(new_DonVi);
        //lưu tạm thời
        System.out.println(new_DonVi);
    }
    
    private void Exit_Dialog_jButtonActionPerformed(ActionEvent evt) {
        formNL_jDialog.setVisible(false);
    }

    private void ThemNguyenLieu_Dialog(ActionEvent evt) {
        Dialog_form(true, -1);
        formNL_jDialog.pack();
        formNL_jDialog.setLocationRelativeTo(null);
        formNL_jDialog.setVisible(true);
    }
    private void setText_nextMANL(){
        String MANL;
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT TO_NUMBER(SUBSTR(MANL, 3))+1 NUM_NL FROM KHONGUYENLIEU ORDER BY TO_NUMBER(SUBSTR( MANL, 3 )) DESC";
            ResultSet res = statement.executeQuery(sql);
            boolean flag = false;
            while(res.next()){
                flag = true;
                MANL = "NL" + res.getInt("NUM_NL");
                txt_MaNL.setText(MANL);
                txt_MaNL.setForeground(new Color (134, 134, 134));
                txt_MaNL.setEditable(false);
                System.out.println("Set " + MANL + " thanh cong" );
                break;
            }
            if(!flag){
                MANL = "NL1";
                txt_MaNL.setText(MANL);
                txt_MaNL.setForeground(new Color (134, 134, 134));
                txt_MaNL.setEditable(false);
                System.out.println("Set " + MANL + " thanh cong" );
            }
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is "+ex);
        }
    }
    private void setText_init_SL0(){
        txt_SoLuong.setText("0");
        txt_SoLuong.setForeground(new Color(134, 134, 134));
        txt_SoLuong.setEditable(false);
    }
    private void themNL_jButtonActionPerformed(ActionEvent evt){
        String MaNL = txt_MaNL.getText();            
        String TenNL = txt_TenNL.getText();
        Object DonGia = txt_DonGia.getValue();
        Object DonVi = txt_DonVi.getItemAt(txt_DonVi.getSelectedIndex());
        Object SoLuong = txt_SoLuong.getValue();
        String MaNCC = txt_MaNCC.getText();            
                
        try {
            Statement statement = connection.createStatement();
            if (TenNL.equals("") || DonGia == null || DonVi.equals("") || SoLuong.equals("")) {
                ThieuThongTin_jOptionPane.setVisible(true);
                ThieuThongTin_jOptionPane.showMessageDialog(formNL_jDialog, "Vui lòng nhập đầy đủ thông tin!");
                ThieuThongTin_jOptionPane.setMessageType(JOptionPane.WARNING_MESSAGE);
            } else {
                boolean flag_NLtontai = false;
                String sql = "SELECT * FROM KHONGUYENLIEU WHERE TENNL = '" + TenNL + "' AND MANCC = '" + MaNCC + "'";
                ResultSet res_select = statement.executeQuery(sql);
                while (res_select.next()) {
                    flag_NLtontai = true;
                }
                if(flag_NLtontai){
                    NLTontai_jOptionPane.setVisible(true);
                    NLTontai_jOptionPane.showMessageDialog(formNL_jDialog, "Nguyên liệu đã tồn tại!");
                    NLTontai_jOptionPane.setMessageType(JOptionPane.ERROR_MESSAGE);                    
                }
                else {
                    sql = "INSERT INTO KHONGUYENLIEU VALUES (  '" + MaNL + "' , '" + TenNL + "', '" + DonGia + "', '" + DonVi + "', 0, '" + MaNCC + "' )";
                    int res = statement.executeUpdate(sql);
                    System.out.println("Insert thanh cong");
                    themNL_jOptionPane.setVisible(true);
                    themNL_jOptionPane.showMessageDialog(formNL_jDialog, "Thêm thành công nguyên liệu!");
                    formNL_jDialog.setVisible(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            String sql= "SELECT * FROM KHONGUYENLIEU WHERE MANL = '" + MaNL +"'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);

            while(res.next()){
                String MANL = res.getString("MANL");
                String TENNL = res.getString("TENNL");
                String DONGIA = res.getString("DONGIA");
                String DONVI = res.getString("DONVI");
                String TONGSL = res.getString("TONGSL");
                String MANCC = res.getString("MANCC");
                
                Object tbdata[] = {MANL, TENNL, DONGIA, DONVI, TONGSL, MANCC, null};
                DefaultTableModel tbmodel = (DefaultTableModel)table_Kho.getModel();
                tbmodel.addRow(tbdata);
                break;
            }
        }
        catch(SQLException | HeadlessException ex){
                    System.out.println("the error is "+ex);
        }
    }

    private void SuaNguyenLieu_Dialog(int row) {
        Dialog_form(false, row);
        formNL_jDialog.pack();
        formNL_jDialog.setLocationRelativeTo(null);
        formNL_jDialog.setVisible(true);
    }
    private void setText_currNL(int row){
        DefaultTableModel model = (DefaultTableModel) table_Kho.getModel();
        Object value_MANL = model.getValueAt(row, 0);
        System.out.println(value_MANL);
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM KHONGUYENLIEU WHERE MANL"
                    + " = '" + value_MANL + "'";
            ResultSet res = statement.executeQuery(sql);
            System.out.println(value_MANL + " thanh cong");

            while (res.next()) {
                String MANL = res.getString("MANL");
                String TENNL = res.getString("TENNL");
                String StrDONGIA = res.getString("DONGIA");
                int DONGIA;
                if(StrDONGIA == null) 
                    DONGIA = 0;
                else 
                    DONGIA = Integer.parseInt(StrDONGIA);
                String DONVI = res.getString("DONVI");
                String StrTONGSL = res.getString("TONGSL");
                int TONGSL;
                if(StrTONGSL == null) 
                    TONGSL = 0;
                else 
                    TONGSL = Integer.parseInt(StrTONGSL);
                String MANCC = res.getString("MANCC");
                
                txt_MaNL.setText(MANL);
                txt_MaNL.setForeground(new Color(134, 134, 134));
                txt_MaNL.setEditable(false);
                
                txt_TenNL.setText(TENNL);
                txt_DonGia.setValue(DONGIA);
                txt_DonVi.setSelectedItem(DONVI);
                txt_SoLuong.setValue(TONGSL);
                txt_SoLuong.setForeground(new Color(134, 134, 134));
                txt_SoLuong.setEditable(false);
                                
                txt_MaNCC.setText(MANCC);
                txt_MaNCC.setForeground(new Color(134, 134, 134));
                txt_MaNCC.setEditable(false);
                sql = "SELECT * FROM NHACUNGCAP WHERE MANCC = '" + MANCC + "'";
                res = statement.executeQuery(sql);
                while (res.next()) {
                    String TENNCC = res.getString("TENNCC");
                    txt_TenNCC.setSelectedItem(TENNCC);
                }
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void suaNL_jButtonActionPerformed(ActionEvent evt, int row){
        DefaultTableModel model = (DefaultTableModel) table_Kho.getModel();

        String MaNL = txt_MaNL.getText();
        String TenNL = txt_TenNL.getText();
        Object DonGia = txt_DonGia.getValue();
        Object DonVi = txt_DonVi.getItemAt(txt_DonVi.getSelectedIndex());
        Object SoLuong = txt_SoLuong.getValue();
        String MaNCC = txt_MaNCC.getText();
        try {
            boolean flag_NLtontai = false;
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM KHONGUYENLIEU WHERE TENNL = '" + TenNL + "' AND MANCC = '" + MaNCC + "'";
            ResultSet res_select = statement.executeQuery(sql);
            while (res_select.next()) {
                String MANL = res_select.getString("MANL");
                if(!MANL.equals(MaNL))
                    flag_NLtontai = true;
            }
            if (flag_NLtontai) {
                NLTontai_jOptionPane.setVisible(true);
                NLTontai_jOptionPane.showMessageDialog(formNL_jDialog, "Nguyên liệu đã tồn tại!");
                NLTontai_jOptionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
            } else {
                sql = "UPDATE KHONGUYENLIEU SET MANL = '" + MaNL + "', TENNL = '" + TenNL + "', DONGIA = " + DonGia + ", DONVI = '" + DonVi + "', TONGSL = " + SoLuong + ", MANCC = '" + MaNCC + "' WHERE MANL = '" + MaNL + "'";
                int res = statement.executeUpdate(sql);
                suaNL_jOptionPane.setVisible(true);
                suaNL_jOptionPane.showMessageDialog(formNL_jDialog, "Cập nhật nguyên liệu thành công!");
                formNL_jDialog.setVisible(false);
                System.out.println("Update NL thanh cong");

                model.setValueAt(TenNL, row, 1);
                model.setValueAt(DonGia, row, 2);
                model.setValueAt(DonVi, row, 3);
                model.setValueAt(SoLuong, row, 4);
                model.setValueAt(MaNCC, row, 5);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
