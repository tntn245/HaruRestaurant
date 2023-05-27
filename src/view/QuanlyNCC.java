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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
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
public class QuanlyNCC {
    private JPanel pane_bg;
    
    private JPanel pane_QLNCC;
    private DropShadowPane pane_shadow;
    private JTable table_NCC;
    private JScrollPane Scrollpane_TableNCC;
    public ButtonGradient btn_ThemNCC;
    public JPanel pane_Search;
    public JButton btn_Search;
    public JComboBox boxSearch;
    public JTextField txtSearch;
    
    public JDialog formNCC_jDialog;
    public JOptionPane themNCC_jOptionPane = new JOptionPane();
    public JOptionPane suaNCC_jOptionPane = new JOptionPane();
    
    private JTextField txt_MaNCC;
    private JTextField txt_TenNCC;
    private JTextField txt_DiaChi;
    private JComboBox txt_TinhTrangCungCap;

    private JOptionPane ThieuThongTin_jOptionPane = new JOptionPane();
    private JOptionPane CCCDTontai_jOptionPane = new JOptionPane();
    private JOptionPane Delete_Confirm_jOptionPane = new JOptionPane();
    
    private Connection connection;
    
    public QuanlyNCC(Connection connection){
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
        
        pane_QLNCC = new JPanel();
        pane_QLNCC.setBackground(Color.white);
        pane_QLNCC.setPreferredSize(new Dimension(760, 540)); 
    }    
    public JPanel pane_QLNCC(){
        search_bar();
        table_NCC();
        pane_shadow.add(pane_QLNCC);
        pane_bg.add(pane_shadow);
        return pane_bg;
    }
    
    public void search_bar(){
        pane_Search = new JPanel();
        pane_Search.setBackground(Color.white);
        pane_Search.setPreferredSize(new Dimension(800, 70)); 
        pane_search();
        btn_ThemNCC();
        pane_QLNCC.add(pane_Search);
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
        
        String colname_NCC[] = { "MANCC", "TENNCC", "DIACHI", "TINHTRANGCUNGCAP" };
        boxSearch = new JComboBox(colname_NCC);
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
            public void actionPerformed(ActionEvent e) {
                if (txtSearch.getText().equals("") || txtSearch.getText().equals(" Search")) {
                    add_data_table();
                } else {
                    boolean flag = false;
                    try {
                        String sql = "SELECT *FROM NHACUNGCAP WHERE "
                                + boxSearch.getSelectedItem().toString() + " LIKE '%" + txtSearch.getText() + "%'";
                        Statement statement = connection.createStatement();
                        ResultSet res = statement.executeQuery(sql);

                        DefaultTableModel tbmodel = (DefaultTableModel) table_NCC.getModel();
                        tbmodel.setRowCount(0);

                        while (res.next()) {
                            flag = true;
                            String MANCC = res.getString("MANCC");
                            String TENNCC = res.getString("TENNCC");
                            String DIACHI = res.getString("DIACHI");
                            String TINHTRANG = res.getString("TINHTRANGCUNGCAP");

                            Object tbdata[] = {MANCC, TENNCC, DIACHI, TINHTRANG, null};
                            tbmodel.addRow(tbdata);
                        }
                    } catch (SQLException | HeadlessException ex) {
                        System.out.println("the error is" + ex);
                    }

                    if (!flag) {
                        JOptionPane search_jOptionPane = new JOptionPane();
                        search_jOptionPane.setVisible(true);
                        search_jOptionPane.showMessageDialog(pane_QLNCC, "Không tìm thấy nhà cung cấp!");
                    }
                }
            }
        });
    }

    public void init_Dialog(){
        formNCC_jDialog = new JDialog();
        formNCC_jDialog.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        formNCC_jDialog.getContentPane().setBackground(new Color(255, 255, 255));
        formNCC_jDialog.setPreferredSize(new Dimension(700, 300));
        formNCC_jDialog.setResizable(false);
    }
    
    public void Dialog_form( boolean loaiDialog, int row){
        boolean loai = loaiDialog;
        init_Dialog();
        
        JPanel pane_ThongTinCoBan_Dialog = new JPanel();
        pane_ThongTinCoBan_Dialog.setLayout(new GridLayout(2, 2, 20,5));
        pane_ThongTinCoBan_Dialog.setPreferredSize(new Dimension(600, 60));
        pane_ThongTinCoBan_Dialog.setBackground(Color.white);
        
        JPanel pane_ThongTinChiTiet_Dialog = new JPanel();
        pane_ThongTinChiTiet_Dialog.setLayout(new GridLayout(2, 2, 20,5));
        pane_ThongTinChiTiet_Dialog.setPreferredSize(new Dimension(600, 60));
        pane_ThongTinChiTiet_Dialog.setBackground(Color.white);
        
        JLabel MaNCC = new JLabel("Mã nhà cung cấp:");
        JLabel TenNCC = new JLabel("Tên nhà cung cấp:");
        JLabel DiaChi = new JLabel("Địa chỉ:");
        JLabel TinhTrangCungCap = new JLabel("Tình trạng cung cấp:");
        
        txt_MaNCC = new JTextField();
        txt_TenNCC = new JTextField();
        txt_DiaChi = new JTextField();
        String StrTinhTrangCungCap[] = {"Đang cung cấp", "Ngừng cung cấp"};
        txt_TinhTrangCungCap = new JComboBox(StrTinhTrangCungCap);
        txt_TinhTrangCungCap.setSelectedIndex(0);
        
        pane_ThongTinCoBan_Dialog.add(MaNCC);
        pane_ThongTinCoBan_Dialog.add(TenNCC);
        pane_ThongTinCoBan_Dialog.add(txt_MaNCC);
        pane_ThongTinCoBan_Dialog.add(txt_TenNCC);
        
        pane_ThongTinChiTiet_Dialog.add(DiaChi);
        pane_ThongTinChiTiet_Dialog.add(TinhTrangCungCap);
        pane_ThongTinChiTiet_Dialog.add(txt_DiaChi);
        pane_ThongTinChiTiet_Dialog.add(txt_TinhTrangCungCap);        
        
        JPanel pane_btn_Dialog = new JPanel();
        pane_btn_Dialog.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pane_btn_Dialog.setPreferredSize(new Dimension(600, 50));
        pane_btn_Dialog.setBackground(Color.white);
        
        ButtonGradient btn_cancel_themNCC = new ButtonGradient();
        btn_cancel_themNCC.setText("HỦY");
        btn_cancel_themNCC.setColor1(new Color(255,231,231));
        btn_cancel_themNCC.setColor2(new Color(255,130,145));
        btn_cancel_themNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_Dialog_jButtonActionPerformed(evt);
            }
        });
        
        ButtonGradient btn_XacNhan = new ButtonGradient();
        btn_XacNhan.setText("XÁC NHẬN");
        btn_XacNhan.setColor1(new Color(225,244,255));
        btn_XacNhan.setColor2(new Color(133,210,255));
        btn_XacNhan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(loai)
                    themNCC_jButtonActionPerformed(evt);
                else 
                    suaNCC_jButtonActionPerformed(evt, row);
            }
        });
        pane_btn_Dialog.add(btn_cancel_themNCC);
        pane_btn_Dialog.add(btn_XacNhan);
        
        if(loai)
            setText_nextMANCC();
        else
            setText_currMANCC(row);
        
        formNCC_jDialog.getContentPane().add(pane_ThongTinCoBan_Dialog);        
        formNCC_jDialog.getContentPane().add(pane_ThongTinChiTiet_Dialog);        
        formNCC_jDialog.getContentPane().add(pane_btn_Dialog);
    }

    public void btn_ThemNCC(){
        btn_ThemNCC = new ButtonGradient();
        btn_ThemNCC.setText("THÊM MỚI");
        btn_ThemNCC.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_ThemNCC.setFont(new Font(btn_ThemNCC.getFont().getName(),Font.BOLD,btn_ThemNCC.getFont().getSize()));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/parcel.png"));
        Image image = icon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_ThemNCC.setIcon(newIcon);
        
        btn_ThemNCC.setVerticalTextPosition(SwingConstants.CENTER);
        btn_ThemNCC.setHorizontalTextPosition(SwingConstants.RIGHT);
        btn_ThemNCC.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Da bam them NCC");
                ThemNCC_Dialog(e);
            }
        });
        
        pane_Search.add(btn_ThemNCC);
    }  
    
    public void table_NCC(){
        Scrollpane_TableNCC= new JScrollPane();

        String[] columnNames = {"Mã NCC", "Tên NCC", "Địa chỉ", "Tình trạng", ""};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };
            
            @Override
            public boolean isCellEditable(int row, int column) {
               return canEdit [column];
            }
        };
        table_NCC = new JTable(model);
        table_NCC.setRowHeight(40);
        table_NCC.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ? new Color(234,247,255) : new Color(255, 237, 243));
                c.setForeground(Color.black);
                return c;
            }
        });        
        
        table_NCC.getTableHeader().setOpaque(false);
        table_NCC.getTableHeader().setBackground(new Color(167,222,254));
        table_NCC.getTableHeader().setForeground(Color.black);
        table_NCC.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table_NCC.getTableHeader().setPreferredSize(new Dimension(table_NCC.getWidth(),40));
        table_NCC.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
                
        table_NCC.setShowHorizontalLines(false);
        table_NCC.setGridColor(Color.white);
        table_NCC.setBackground(Color.white);
        table_NCC.setBorder(new EmptyBorder(5, 5, 5,5));
        table_NCC.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        TableColumnModel columnModel = table_NCC.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(100);
        
        add_data_table();

        table_NCC.setPreferredScrollableViewportSize(table_NCC.getPreferredSize());
        table_NCC.setFillsViewportHeight(true);
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                SuaNCC_Dialog(row);
            }

            @Override
            public void onDelete(int row) {
                if(table_NCC.isEditing()) {
                    table_NCC.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) table_NCC.getModel();
                Object value_MANCC = model.getValueAt(row, 0);
                System.out.println(value_MANCC);
                try {
                    Statement statement = connection.createStatement();
                    Delete_Confirm_jOptionPane.setVisible(true);
                    int flag_OK = Delete_Confirm_jOptionPane.showConfirmDialog(formNCC_jDialog, "Bạn chắc chắn muốn xóa nhà cung cấp?",null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(flag_OK == JOptionPane.OK_OPTION){
                        String sql = "DELETE FROM NHACUNGCAP WHERE MANCC = '" + value_MANCC + "'";
                        int res = statement.executeUpdate(sql);
                        System.out.println("Delete NCC thanh cong");
                        model.removeRow(row);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
//        PanelAction1 action = new PanelAction1(true, false);
        table_NCC.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender(new Color(234,247,255), new Color(255, 237, 243),true,false));
        table_NCC.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event, new Color(234,247,255), new Color(255, 237, 243),true,false));
        
        
        Scrollpane_TableNCC.setViewportView(table_NCC);
        Scrollpane_TableNCC.setBorder(new LineBorder( Color.LIGHT_GRAY, 1, true));
        Scrollpane_TableNCC.setPreferredSize(new Dimension(700, 450));
        pane_QLNCC.add(Scrollpane_TableNCC);
    }
    
    public void add_data_table(){
        try{
            DefaultTableModel tbmodel = (DefaultTableModel)table_NCC.getModel();
            String sql = "SELECT * FROM NHACUNGCAP ORDER BY TO_NUMBER(SUBSTR( MANCC, 4 ))";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);

            tbmodel.setRowCount(0);
            while(res.next()){
                String MANCC = res.getString("MANCC");
                String TENNCC = res.getString("TENNCC");
                String DIACHI = res.getString("DIACHI");
                String TINHTRANGCUNGCAP = res.getString("TINHTRANGCUNGCAP");

                Object tbdata[] = {MANCC, TENNCC, DIACHI, TINHTRANGCUNGCAP, null};
                tbmodel.addRow(tbdata);
            }
        }
        catch(SQLException | HeadlessException ex){
                    System.out.println("the error is"+ex);
        }
    }
    
    private void Exit_Dialog_jButtonActionPerformed(ActionEvent evt) {
        formNCC_jDialog.setVisible(false);
    }

    private void ThemNCC_Dialog(ActionEvent evt) {
        Dialog_form(true, -1);
        formNCC_jDialog.pack();
        formNCC_jDialog.setLocationRelativeTo(null);
        formNCC_jDialog.setVisible(true);
    }
    private void setText_nextMANCC(){
        String MANCC;
                        System.out.println("set  thanh cong" );

        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT TO_NUMBER(SUBSTR(MANCC, 4))+1 NUM_NCC FROM NHACUNGCAP ORDER BY TO_NUMBER(SUBSTR( MANCC, 4 )) DESC";
            ResultSet res = statement.executeQuery(sql);
            boolean flag = false;
            while(res.next()){
                flag = true;
                MANCC = "NCC" + res.getInt("NUM_NCC");
                txt_MaNCC.setText(MANCC);
                txt_MaNCC.setForeground(new Color (134, 134, 134));
                txt_MaNCC.setEditable(false);
                break;
            }
            if(!flag){
                MANCC = "NCC1";
                txt_MaNCC.setText(MANCC);
                txt_MaNCC.setForeground(new Color (134, 134, 134));
                txt_MaNCC.setEditable(false);
            }
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is "+ex);
        }
    }
    private void themNCC_jButtonActionPerformed(ActionEvent evt){
        String MaNCC = txt_MaNCC.getText();            
        String TenNCC = txt_TenNCC.getText();
        String DiaChi = txt_DiaChi.getText();
        Object TinhTrangCungCap = txt_TinhTrangCungCap.getItemAt(txt_TinhTrangCungCap.getSelectedIndex());
                    
        try {
            Statement statement = connection.createStatement();
            if (TenNCC.equals("") || DiaChi.equals("")) {
                ThieuThongTin_jOptionPane.setVisible(true);
                ThieuThongTin_jOptionPane.showMessageDialog(formNCC_jDialog, "Vui lòng nhập đầy đủ thông tin!");
                ThieuThongTin_jOptionPane.setMessageType(JOptionPane.WARNING_MESSAGE);
            } else {
                String sql = "INSERT INTO NHACUNGCAP VALUES (  '" + MaNCC + "' , '" + TenNCC + "', '" + DiaChi + "', '" + TinhTrangCungCap + "')";
                int res = statement.executeUpdate(sql);
                System.out.println("Insert thanh cong");
                themNCC_jOptionPane.setVisible(true);
                themNCC_jOptionPane.showMessageDialog(formNCC_jDialog, "Thêm thành công nhà cung cấp!");
                formNCC_jDialog.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            String sql = "SELECT * FROM NHACUNGCAP WHERE MANCC = '" + MaNCC +"'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);

            while(res.next()){
                MaNCC = res.getString("MANCC");
                TenNCC = res.getString("TENNCC");
                DiaChi = res.getString("DIACHI");
                TinhTrangCungCap = res.getString("TINHTRANGCUNGCAP");
                
                Object tbdata[] = {MaNCC, TenNCC, DiaChi, TinhTrangCungCap, null};
                DefaultTableModel tbmodel = (DefaultTableModel)table_NCC.getModel();
                tbmodel.addRow(tbdata);
                break;
            }
        }
        catch(SQLException | HeadlessException ex){
                    System.out.println("the error is "+ex);
        }
    }

    private void SuaNCC_Dialog(int row) {
        Dialog_form(false, row);
        formNCC_jDialog.pack();
        formNCC_jDialog.setLocationRelativeTo(null);
        formNCC_jDialog.setVisible(true);
    }
    private void setText_currMANCC(int row){
        DefaultTableModel model = (DefaultTableModel) table_NCC.getModel();
        Object value_MANCC = model.getValueAt(row, 0);
        System.out.println(value_MANCC);
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM NHACUNGCAP WHERE MANCC = '" + value_MANCC + "'";
            ResultSet res = statement.executeQuery(sql);
            System.out.println(value_MANCC + " thanh cong");

            while (res.next()) {
                String MaNCC = res.getString("MANCC");
                String TenNCC = res.getString("TENNCC");
                String DiaChi = res.getString("DIACHI");
                String TinhTrangCungCap = res.getString("TINHTRANGCUNGCAP");
                txt_MaNCC.setText(MaNCC);
                txt_MaNCC.setForeground(new Color (134, 134, 134));
                txt_MaNCC.setEditable(false);                
                txt_TenNCC.setText(TenNCC);
                txt_DiaChi.setText(DiaChi);
                if (TinhTrangCungCap.equals("Đang cung cấp") )
                    txt_TinhTrangCungCap.setSelectedIndex(0);
                else
                    txt_TinhTrangCungCap.setSelectedIndex(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void suaNCC_jButtonActionPerformed(ActionEvent evt, int row){
        DefaultTableModel model = (DefaultTableModel) table_NCC.getModel();

        String MaNCC = txt_MaNCC.getText();
        String TenNCC = txt_TenNCC.getText();
        String DiaChi = txt_DiaChi.getText();
        Object TinhTrangCungCap = txt_TinhTrangCungCap.getItemAt(txt_TinhTrangCungCap.getSelectedIndex());
        
        try {
            Statement statement = connection.createStatement();
            String sql = "UPDATE NHACUNGCAP SET TENNCC = '"+TenNCC+"', DIACHI = '" +DiaChi+ "', TINHTRANGCUNGCAP = '"+TinhTrangCungCap+"' WHERE MANCC = '" + MaNCC + "'";
            int res = statement.executeUpdate(sql); 
            suaNCC_jOptionPane.setVisible(true);
            suaNCC_jOptionPane.showMessageDialog(formNCC_jDialog, "Cập nhật nhà cung cấp thành công!");
            formNCC_jDialog.setVisible(false);
            System.out.println("Update TK thanh cong");
            
            model.setValueAt(TenNCC, row, 1);
            model.setValueAt(DiaChi, row, 2);
            model.setValueAt(TinhTrangCungCap, row, 3);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

