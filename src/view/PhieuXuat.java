/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import style.TableActionCellEditor;
import style.TableActionCellRender;
import style.TableActionEvent;
import style.DropShadowPane;
import style.ButtonGradient;
import com.raven.datechooser.DateChooser;
import java.awt.Color;
import java.awt.Component;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
public class PhieuXuat {
    private JPanel pane_bg;
    
    private JPanel pane_QLPhieuXuat;
    private DropShadowPane pane_shadow;
    private JTable table_PhieuXuat;
    private JScrollPane Scrollpane_TablePhieuXuat;
    
    public ButtonGradient btn_PhieuNhap;
    public ButtonGradient btn_Kho;
    public ButtonGradient btn_ThemPhieuXuat;
    public ButtonGradient btn_XacNhan  = new ButtonGradient();;
    public ButtonGradient btn_cancel_themPX  = new ButtonGradient();;
        
    public JPanel pane_Search;
    public JButton btn_Search;
    public JComboBox boxSearch;
    public JTextField txtSearch;
    
    private JPanel pane_textPhieuXuat;    
    public JPanel pane_bg_ThemPhieuXuat;
    
    private JDialog formPX_jDialog;

    private JTextField txt_MaPX;
    private JTextField txt_MaNL;
    private JComboBox txt_MaNCC;
    private JComboBox txt_TenNL;
    private JFormattedTextField txt_SoLuong;
    private JTextField txt_DonVi;
    private JTextField txt_NgayXuat;
    private JComboBox txt_GhiChu;
    
    public JOptionPane themPX_jOptionPane = new JOptionPane();
    public JOptionPane suaPX_jOptionPane = new JOptionPane();
    private JOptionPane ThieuThongTin_jOptionPane = new JOptionPane();
    private JOptionPane Delete_Confirm_jOptionPane = new JOptionPane();
    
    private Connection connection;
    
    public PhieuXuat(Connection connection){        
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
        
        pane_QLPhieuXuat = new JPanel();
        pane_QLPhieuXuat.setBackground(Color.white);
        pane_QLPhieuXuat.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
        pane_QLPhieuXuat.setPreferredSize(new Dimension(760, 540)); 
    }   
      
    public JPanel pane_PhieuXuat(){
        search_bar();
        pane_textPhieuXuat();
        table_PX();
        btn_ThemPhieuXuat();
        pane_shadow.add(pane_QLPhieuXuat);
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
        pane_ThemPhieuXuat();
        
        btn_PhieuNhap();
        btn_Kho();
        
        pane_QLPhieuXuat.add(pane_Search);
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
        
        String colname_NL[] = {"MAPX", "MANL", "SL", "NGAYXUAT", "GHICHU"};
        boxSearch = new JComboBox(colname_NL);
        boxSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boxSearch.setSelectedItem("MAPX");
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
    
    public void pane_ThemPhieuXuat(){
        pane_bg_ThemPhieuXuat = new JPanel();
        pane_bg_ThemPhieuXuat.setBackground(Color.white);
        pane_bg_ThemPhieuXuat.setPreferredSize(new Dimension(600, 500));
        pane_bg_ThemPhieuXuat.setBounds(70, 30, 600, 500);
    }
    
    public void Search(){
        btn_Search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (txtSearch.getText().equals("") || txtSearch.getText().equals(" Search")) {
                    add_data_table();
                } else {
                    boolean flag = false;
                    try {
                        String sql = "SELECT MAPX, MANL, SL, "
                                + "TO_CHAR(NGAYXUAT, 'DD-MM-YYYY') as NGAYXUAT, GHICHU "
                                + "FROM PHIEUXUAT WHERE " + boxSearch.getSelectedItem().toString() + " LIKE '%" + txtSearch.getText() + "%'";
                        Statement statement = connection.createStatement();
                        ResultSet res = statement.executeQuery(sql);

                        DefaultTableModel tbmodel = (DefaultTableModel) table_PhieuXuat.getModel();
                        tbmodel.setRowCount(0);

                        while (res.next()) {
                            flag = true;
                            String MAPX = res.getString("MAPX");
                            String MANL = res.getString("MANL");
                            String SL = res.getString("SL");
                            String NGAYXUAT = res.getString("NGAYXUAT");
                            String GHICHU = res.getString("GHICHU");

                            Object tbdata[] = {MAPX, MANL, SL, NGAYXUAT, GHICHU, null};
                            tbmodel.addRow(tbdata);
                        }
                    } catch (SQLException | HeadlessException ex) {
                        System.out.println("the error is" + ex);
                    }

                    if (!flag) {
                        JOptionPane search_jOptionPane = new JOptionPane();
                        search_jOptionPane.setVisible(true);
                        search_jOptionPane.showMessageDialog(pane_QLPhieuXuat, "Không tìm thấy phiếu xuất!");
                    }
                }
            }
        });
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
                System.out.println("Da bam kho");
            }
        });
        
        pane_Search.add(btn_Kho);
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
        btn_PhieuNhap.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Da bam phieu xuat");
            }
        });
        
        pane_Search.add(btn_PhieuNhap);
    }      
    
    public void btn_ThemPhieuXuat(){
        JPanel pane_ThemPhieuXuat = new JPanel();
        pane_ThemPhieuXuat.setPreferredSize(new Dimension(700,50));
        pane_ThemPhieuXuat.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        pane_ThemPhieuXuat.setBackground(Color.white);

        btn_ThemPhieuXuat = new ButtonGradient();
        btn_ThemPhieuXuat.setColor1(new Color(225,244,255));
        btn_ThemPhieuXuat.setColor2(new Color(133,210,255));
        btn_ThemPhieuXuat.setText("THÊM PHIẾU XUẤT");
        btn_ThemPhieuXuat.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_ThemPhieuXuat.setFont(new Font(btn_ThemPhieuXuat.getFont().getName(),Font.BOLD,btn_ThemPhieuXuat.getFont().getSize()));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/add.png"));
        Image image = icon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_ThemPhieuXuat.setIcon(newIcon);
        
        btn_ThemPhieuXuat.setVerticalTextPosition(SwingConstants.CENTER);
        btn_ThemPhieuXuat.setHorizontalTextPosition(SwingConstants.RIGHT);
        btn_ThemPhieuXuat.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Da bam them phieu xuat");
                ThemPhieuXuat_Dialog(e);
            }
        });
        
        pane_ThemPhieuXuat.add(btn_ThemPhieuXuat);
        pane_QLPhieuXuat.add(pane_ThemPhieuXuat);
    }  
    
    private void pane_textPhieuXuat(){
        JLabel textPhieuXuat = new JLabel("PHIẾU XUẤT");
        textPhieuXuat.setFont(new Font(textPhieuXuat.getFont().getName(), Font.BOLD, 20));
        
        pane_textPhieuXuat = new JPanel();
        pane_textPhieuXuat.setBackground(new Color(167,222,254));
        pane_textPhieuXuat.setPreferredSize(new Dimension(760, 50));
        pane_textPhieuXuat.setBorder(new EmptyBorder(7, 0, 0,0));
        
        pane_textPhieuXuat.add(textPhieuXuat);
        pane_QLPhieuXuat.add(pane_textPhieuXuat);
    }    
    
    public void table_PX(){
        Scrollpane_TablePhieuXuat= new JScrollPane();

        String[] columnNames = {"Mã phiếu xuất", "Mã nguyên liệu", "Số lượng", "Ngày xuất", "Ghi chú", ""};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };
            
            @Override
            public boolean isCellEditable(int row, int column) {
               return canEdit [column];
            }
        };
        table_PhieuXuat = new JTable(model);
        table_PhieuXuat.setRowHeight(40);
        table_PhieuXuat.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ? new Color(246,253,255): new Color(229,246,255));
                c.setForeground(Color.black);
                return c;
            }
        });        
        
        table_PhieuXuat.getTableHeader().setOpaque(false);
        table_PhieuXuat.getTableHeader().setBackground(new Color(167,222,254));
        table_PhieuXuat.getTableHeader().setForeground(Color.black);
        table_PhieuXuat.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table_PhieuXuat.getTableHeader().setPreferredSize(new Dimension(table_PhieuXuat.getWidth(),40));
        table_PhieuXuat.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
                
        table_PhieuXuat.setShowHorizontalLines(false);
        table_PhieuXuat.setGridColor(Color.white);
        table_PhieuXuat.setBackground(Color.white);
        table_PhieuXuat.setBorder(new EmptyBorder(5, 5, 5,5));
        table_PhieuXuat.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        TableColumnModel columnModel = table_PhieuXuat.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        
        add_data_table();
        
        table_PhieuXuat.setPreferredScrollableViewportSize(table_PhieuXuat.getPreferredSize());
        table_PhieuXuat.setFillsViewportHeight(true);
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                SuaPhieuXuat_Dialog(row);
            }

            @Override
            public void onDelete(int row) {
                if(table_PhieuXuat.isEditing()) {
                    table_PhieuXuat.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) table_PhieuXuat.getModel();
                Object value_MAPX = model.getValueAt(row, 0);
                System.out.println(value_MAPX);
                try {
                    Statement statement = connection.createStatement();
                    Delete_Confirm_jOptionPane.setVisible(true);
                    int flag_OK = Delete_Confirm_jOptionPane.showConfirmDialog(formPX_jDialog, "Bạn chắc chắn muốn xóa phiếu xuất?",null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(flag_OK == JOptionPane.OK_OPTION){
                        String sql = "DELETE FROM PHIEUXUAT WHERE MAPX = '" + value_MAPX + "'";
                        int res = statement.executeUpdate(sql);
                        System.out.println("Delete PX thanh cong");
                        model.removeRow(row);
                    }
                } catch (SQLException ex) {
                    JOptionPane option_Xoa_KhongDuoc = new JOptionPane();
                    option_Xoa_KhongDuoc.setVisible(true);
                    option_Xoa_KhongDuoc.showMessageDialog(formPX_jDialog, "Không thể xóa phiếu nhập!");
                    option_Xoa_KhongDuoc.setMessageType(JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        table_PhieuXuat.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender(new Color(246,253,255), new Color(229,246,255),true, true));
        table_PhieuXuat.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event, new Color(246,253,255), new Color(229,246,255),true, true, false, 3));
        
        Scrollpane_TablePhieuXuat.setViewportView(table_PhieuXuat);
        Scrollpane_TablePhieuXuat.setBorder(new LineBorder( Color.LIGHT_GRAY, 1, true));
        Scrollpane_TablePhieuXuat.setPreferredSize(new Dimension(700, 330));
        pane_QLPhieuXuat.add(Scrollpane_TablePhieuXuat);
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
    
    public void add_data_table(){
        try{
            DefaultTableModel tbmodel = (DefaultTableModel)table_PhieuXuat.getModel();
            String sql = "SELECT MAPX, MANL, SL, "
                    + "TO_CHAR(NGAYXUAT, 'DD-MM-YYYY') as NGAYXUAT, GHICHU "
                    + "FROM PHIEUXUAT ORDER BY TO_NUMBER(SUBSTR( MAPX, 3 ))";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);

            tbmodel.setRowCount(0);
            while(res.next()){
                String MAPX = res.getString("MAPX");
                String MANL = res.getString("MANL");
                String SL = res.getString("SL");
                String NGAYXUAT = res.getString("NGAYXUAT");
                String GHICHU = res.getString("GHICHU");

                Object tbdata[] = {MAPX, MANL, SL, NGAYXUAT, GHICHU};
                tbmodel.addRow(tbdata);
            }
        }
        catch(SQLException | HeadlessException ex){
                    System.out.println("the error is"+ex);
        }
    }
    

    public void init_Dialog(){
        formPX_jDialog = new JDialog();
        formPX_jDialog.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
        formPX_jDialog.getContentPane().setBackground(new Color(255, 255, 255));
        formPX_jDialog.setPreferredSize(new Dimension(700, 450));
        formPX_jDialog.setModal(true);
        formPX_jDialog.setResizable(false);
        formPX_jDialog.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0,10));
    }
    
    public void Dialog_form( boolean loaiDialog, int row){
        boolean loai = loaiDialog;
        init_Dialog();
        
        JLabel MAPX = new JLabel("Mã phiếu xuất:");
        JLabel MANL = new JLabel("Mã nguyên liệu:");
        JLabel TENNL = new JLabel("Tên nguyên liệu:");
        JLabel MANCC = new JLabel("Mã nhà cung cấp:");
        JLabel SL = new JLabel("Số lượng:");
        JLabel DONVI = new JLabel("Đơn vị:");
        JLabel NGAYXUAT = new JLabel("Ngày xuất:");
        JLabel GHICHU = new JLabel("Ghi chú:");
        
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        
        txt_MaPX = new JTextField();
        txt_MaNL = new JTextField(); 
        txt_MaNCC = new JComboBox(); 
        txt_DonVi = new JTextField(); 
        String StrGhiChu[] = { "<Lý do>", "Đầu ngày"};
        txt_GhiChu = new JComboBox(StrGhiChu);
        txt_GhiChu.setSelectedIndex(1);
        txt_GhiChu.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    Object item = event.getItem();
                    if(item.equals("<Lý do>")){
                    String lydo = JOptionPane.showInputDialog(formPX_jDialog, "Ghi chú/Lý do là?");
                    System.out.println(lydo);
                    txt_GhiChu.addItem(lydo);
                    txt_GhiChu.setSelectedItem(lydo);      
                    }
                 }
            }
        });

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
        
        txt_NgayXuat = new JTextField();
        DateChooser NgayNhap_dateChooser = new DateChooser();
        NgayNhap_dateChooser.setForeground(new java.awt.Color(167, 223, 255));
        NgayNhap_dateChooser.setTextRefernce(txt_NgayXuat);
        
        txt_SoLuong = new JFormattedTextField(formatter);
        
        JPanel pane1 = new JPanel();
        pane1.setPreferredSize(new Dimension(600, 60));
        pane1.setLayout(new GridLayout(2, 2, 100, 3));
        pane1.setBackground(Color.white);
        pane1.add(MAPX);
        pane1.add(MANL);
        pane1.add(txt_MaPX);
        pane1.add(txt_MaNL);
        
        JPanel pane2= new JPanel();
        pane2.setPreferredSize(new Dimension(600, 60));
        pane2.setLayout(new GridLayout(2, 2, 100, 3));
        pane2.setBackground(Color.white);
        pane2.add(TENNL);
        pane2.add(MANCC);
        pane2.add(txt_TenNL);
        pane2.add(txt_MaNCC);

        JPanel pane3 = new JPanel();
        pane3.setPreferredSize(new Dimension(600, 60));
        pane3.setLayout(new GridLayout(2, 2, 100, 3));
        pane3.setBackground(Color.white);        
        pane3.add(SL);
        pane3.add(DONVI);
        pane3.add(txt_SoLuong);
        pane3.add(txt_DonVi);
        
        JPanel pane4 = new JPanel();
        pane4.setPreferredSize(new Dimension(600, 60));
        pane4.setLayout(new GridLayout(2, 2, 100, 3));
        pane4.setBackground(Color.white); 
        pane4.add(NGAYXUAT);
        pane4.add(GHICHU);
        pane4.add(txt_NgayXuat);
        pane4.add(txt_GhiChu);
        
        if(loai)
            setText_nextMAPX();
        else
            setText_currPX(row); //Lưu ý: sửa trong ngày!
        
        formPX_jDialog.getContentPane().add(pane1);
        formPX_jDialog.getContentPane().add(pane2);
        formPX_jDialog.getContentPane().add(pane3);
        formPX_jDialog.getContentPane().add(pane4);
        
        JPanel pane_btn_DialogPX = new JPanel();
        pane_btn_DialogPX.setLayout(new FlowLayout(FlowLayout.RIGHT, 15,0));
        pane_btn_DialogPX.setPreferredSize(new Dimension(600, 80));
        pane_btn_DialogPX.setBorder(new EmptyBorder(50, 0, 0, 0));
        pane_btn_DialogPX.setBackground(Color.white);
        
        btn_XacNhan = new ButtonGradient();
        btn_XacNhan.setText("XÁC NHẬN");
        btn_XacNhan.setColor1(new Color(225,244,255));
        btn_XacNhan.setColor2(new Color(133,210,255));
        
        btn_cancel_themPX = new ButtonGradient();
        btn_cancel_themPX.setText("HỦY");
        btn_cancel_themPX.setColor1(new Color(255,231,231));
        btn_cancel_themPX.setColor2(new Color(255,130,145));
        
        btn_cancel_themPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_Dialog_jButtonActionPerformed(evt);
            }
        });
        pane_btn_DialogPX.add(btn_cancel_themPX);
        
        btn_XacNhan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(loai)
                    themPX_jButtonActionPerformed(evt);
                else
                    suaPX_jButtonActionPerformed(evt, row);
            
            }
        });
        pane_btn_DialogPX.add(btn_XacNhan);
        formPX_jDialog.getContentPane().add(pane_btn_DialogPX);
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
    
    private void setText_nextMAPX(){
        String MAPX;
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT TO_NUMBER(SUBSTR(MAPX, 3))+1 NUM_PX FROM PHIEUXUAT ORDER BY TO_NUMBER(SUBSTR( MAPX, 3 )) DESC";
            ResultSet res = statement.executeQuery(sql);
            boolean flag = false;
            while(res.next()){
                flag = true;
                MAPX = "PX" + res.getInt("NUM_PX");
                txt_MaPX.setText(MAPX);
                txt_MaPX.setForeground(new Color (134, 134, 134));
                txt_MaPX.setEditable(false);
                break;
            }
            if(!flag){
                MAPX = "PX1";
                txt_MaPX.setText(MAPX);
                txt_MaPX.setForeground(new Color (134, 134, 134));
                txt_MaPX.setEditable(false);
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
                String DONVI = res.getString("DONVI");
                
                txt_MaNL.setText(MANL);
                txt_MaNL.setForeground(new Color (134, 134, 134));
                txt_MaNL.setEditable(false);
                
                txt_DonVi.setText(DONVI);
                txt_DonVi.setForeground(new Color (134, 134, 134));
                txt_DonVi.setEditable(false);
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
    private void ThemPhieuXuat_Dialog(ActionEvent evt) {
        Dialog_form(true, -1);
        formPX_jDialog.pack();
        formPX_jDialog.setLocationRelativeTo(null);
        formPX_jDialog.setVisible(true);
    }   
    private void Exit_Dialog_jButtonActionPerformed(ActionEvent evt) {
        formPX_jDialog.setVisible(false);
    }
    public void themPX_jButtonActionPerformed(ActionEvent evt){
        String MaPX = txt_MaPX.getText();            
        String MaNL = txt_MaNL.getText(); 
        Object SoLuong = txt_SoLuong.getValue();
        String NgayXuat = txt_NgayXuat.getText();
        Object GhiChu = txt_GhiChu.getItemAt(txt_GhiChu.getSelectedIndex());
             
        try {
            Statement statement = connection.createStatement();
            if (SoLuong == null) {
                ThieuThongTin_jOptionPane.setVisible(true);
                ThieuThongTin_jOptionPane.showMessageDialog(formPX_jDialog, "Vui lòng nhập đầy đủ thông tin!");
                ThieuThongTin_jOptionPane.setMessageType(JOptionPane.WARNING_MESSAGE);
            } else {
                if(Check_SL_TrongKho(MaNL, SoLuong)){
                    String sql = "INSERT INTO PHIEUXUAT VALUES (  '" + MaPX + "' , '" + MaNL + "', " + SoLuong + ", TO_DATE('" + NgayXuat + "', 'DD-MM-YYYY'), '" + GhiChu + "')";
                    int res = statement.executeUpdate(sql);
                    System.out.println("Insert thanh cong");
                    themPX_jOptionPane.setVisible(true);
                    themPX_jOptionPane.showMessageDialog(formPX_jDialog, "Thêm phiếu xuất kho và cập nhật số lượng nguyên liệu thành công!");
                    formPX_jDialog.setVisible(false);
                    Object tbdata[] = {MaPX, MaNL, SoLuong, NgayXuat, GhiChu, null};
                    DefaultTableModel tbmodel = (DefaultTableModel)table_PhieuXuat.getModel();
                    tbmodel.addRow(tbdata);
                }
                else{
                    themPX_jOptionPane.setVisible(true);
                    themPX_jOptionPane.showMessageDialog(formPX_jDialog, "Số lượng trong kho không đủ để xuất!");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean Check_SL_TrongKho(String MANL, Object ObjSL){
        try{
            String sql= "SELECT TONGSL FROM KHONGUYENLIEU WHERE MANL = '" + MANL +"'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);

            while(res.next()){
                String StrTONGSL = res.getString("TONGSL");
                int TONGSL = Integer.parseInt(StrTONGSL);
                int SL = Integer.parseInt(ObjSL.toString());
                if(TONGSL>=SL)
                    return true;
            }
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is "+ex);
        }
        return false;
    }
    
    private void SuaPhieuXuat_Dialog(int row) {
        Dialog_form(false, row);
        formPX_jDialog.pack();
        formPX_jDialog.setLocationRelativeTo(null);
        formPX_jDialog.setVisible(true);
    }
    
    private void setText_currPX(int row){
        DefaultTableModel model = (DefaultTableModel) table_PhieuXuat.getModel();
        Object value_MAPX = model.getValueAt(row, 0);
        System.out.println(value_MAPX);
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT MAPX, MANL, SL, "
                    + "TO_CHAR(NGAYXUAT, 'DD-MM-YYYY') as NGAYXUAT, GHICHU "
                    + "FROM PHIEUXUAT WHERE MAPX = '" + value_MAPX + "'";
            ResultSet res = statement.executeQuery(sql);
            System.out.println(value_MAPX + " thanh cong");

            while (res.next()) {
                String MaPX = res.getString("MAPX");
                String MaNL = res.getString("MANL");
                String SoLuong = res.getString("SL");
                String NgayXuat = res.getString("NGAYXUAT");
                String GhiChu = res.getString("GHICHU");

                txt_MaPX.setText(MaPX);
                txt_MaPX.setForeground(new Color(134, 134, 134));
                txt_MaPX.setEditable(false);
                
                txt_MaNL.setText(MaNL);
                txt_MaNL.setForeground(new Color(134, 134, 134));
                txt_MaNL.setEditable(false);
                
                txt_SoLuong.setText(SoLuong);
                txt_NgayXuat.setText(NgayXuat);
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
    
    private void suaPX_jButtonActionPerformed(ActionEvent evt, int row){
        DefaultTableModel model = (DefaultTableModel) table_PhieuXuat.getModel();
        String MaPX = txt_MaPX.getText();
        String MaNL = txt_MaNL.getText();
        Object MaNCC = txt_MaNCC.getItemAt(txt_MaNCC.getSelectedIndex());
        Object SoLuong = txt_SoLuong.getValue();
        String NgayXuat = txt_NgayXuat.getText();
        Object GhiChu = txt_GhiChu.getItemAt(txt_GhiChu.getSelectedIndex());
        
        try {
            if(Check_SL_TrongKho(MaNL, SoLuong)){
                Statement statement = connection.createStatement();
                String sql = "UPDATE PHIEUXUAT SET MANL = '" + MaNL + "', SL = '" + SoLuong + "', NGAYXUAT = TO_DATE('" + NgayXuat + "', 'DD-MM-YYYY'), GHICHU = '" + GhiChu + "' WHERE MAPX = '" + MaPX + "'";
                int res = statement.executeUpdate(sql);
                suaPX_jOptionPane.setVisible(true);
                suaPX_jOptionPane.showMessageDialog(formPX_jDialog, "Cập nhật phiếu xuất và số lượng nguyên liệu thành công!");
                formPX_jDialog.setVisible(false);
                System.out.println("Update PX thanh cong");

                model.setValueAt(MaNL, row, 1);
                model.setValueAt(SoLuong, row, 2);
                model.setValueAt(NgayXuat, row, 3);
                model.setValueAt(GhiChu, row, 4);
            }
            else{
                suaPX_jOptionPane.setVisible(true);
                suaPX_jOptionPane.showMessageDialog(formPX_jDialog, "Số lượng trong kho không đủ để xuất!");                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
