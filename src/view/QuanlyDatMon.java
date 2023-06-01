/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author My PC
 */
public class QuanlyDatMon {
    public JPanel pane_bg;
    
    private JPanel pane_QLDM;
    private DropShadowPane pane_shadow;
    
    private JComboBox combobox_Ban;
    private JTable table_DM;
    private JScrollPane Scrollpane_TableDM;
    
    private String SOHD;
    private Connection connection;
    
    public QuanlyDatMon(Connection connection){
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
        
        pane_QLDM = new JPanel();
        pane_QLDM.setBackground(Color.white);
        pane_QLDM.setPreferredSize(new Dimension(760, 540)); 
        pane_QLDM.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        
        combobox_Ban = new JComboBox();
        combobox_Ban.setPreferredSize(new Dimension(700, 35));
        for(int i=0; i<15;i++){
            int SoBan = i+1;
            combobox_Ban.addItem("Bàn "+SoBan);
        }
        table_DM();
        add_data_table(combobox_Ban.getSelectedItem());
        combobox_Ban.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    add_data_table(combobox_Ban.getSelectedItem());
                }
            }
        });
                
        pane_QLDM.add(combobox_Ban);
        pane_QLDM.add(Scrollpane_TableDM);
        pane_shadow.add(pane_QLDM);
        pane_bg.add(pane_shadow);
    }    
    
    private void table_DM(){
        Scrollpane_TableDM= new JScrollPane();

        String[] columnNames = {"Mã món", "Tên món", "SL", "Tình trạng", ""};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };
            
            @Override
            public boolean isCellEditable(int row, int column) {
               return canEdit [column];
            }
        };
        table_DM = new JTable(model);
        table_DM.setRowHeight(40);
        table_DM.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ? new Color(234,247,255) : new Color(255, 237, 243));
                c.setForeground(Color.black);
                return c;
            }
        });        
        
        table_DM.getTableHeader().setOpaque(false);
        table_DM.getTableHeader().setBackground(new Color(167,222,254));
        table_DM.getTableHeader().setForeground(Color.black);
        table_DM.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
//        table_NV.getTableHeader().setFont(new Font(table_NV.getFont().getName(),Font.BOLD,14));
        table_DM.getTableHeader().setPreferredSize(new Dimension(table_DM.getWidth(),40));
        table_DM.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
                
        table_DM.setShowHorizontalLines(false);
        table_DM.setGridColor(Color.white);
        table_DM.setBackground(Color.white);
        table_DM.setBorder(new EmptyBorder(5, 5, 5,5));
        table_DM.setFont(new Font("SansSerif", Font.PLAIN, 14));
//        table_NV.setFont(new Font(table_NV.getFont().getName(),Font.PLAIN,14));
        
        TableColumnModel columnModel = table_DM.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        
        table_DM.setPreferredScrollableViewportSize(table_DM.getPreferredSize());
        table_DM.setFillsViewportHeight(true);
//        table_NV.setSelectionBackground(new Color(0, 0, 0, 0));
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                DaLenMon(row);
            }

            @Override
            public void onDelete(int row) {
                ChuaLenMon(row);
            }
        };
        table_DM.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender(new Color(234,247,255), new Color(255, 237, 243),true, true, "/image/check.png", "/image/multiply.png"));
        table_DM.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event, new Color(234,247,255), new Color(255, 237, 243),true,true,"/image/check.png", "/image/multiply.png"));
        
        Scrollpane_TableDM.setViewportView(table_DM);
        Scrollpane_TableDM.setBorder(new LineBorder( Color.LIGHT_GRAY, 1, true));
        Scrollpane_TableDM.setPreferredSize(new Dimension(700, 420));
    }
    
    public void add_data_table(Object TenBan){
        String SoBan = TenBan.toString().substring(4);
        int So = Integer.parseInt(SoBan);
        DefaultTableModel tbmodel = (DefaultTableModel)table_DM.getModel();
        tbmodel.setRowCount(0);

        try{
            String sql_SOHD = "SELECT SOHD FROM HOADON WHERE TINHTRANGTHANHTOAN = 0 AND MABAN = 'BAN"+So+"'";
            Statement statement_SOHD = connection.createStatement();
            ResultSet res_SOHD = statement_SOHD.executeQuery(sql_SOHD);

            while(res_SOHD.next()){
                SOHD = res_SOHD.getString("SOHD");
                
                String sql_CTHD = "SELECT * FROM CTHD WHERE SOHD = '"+SOHD+"'";
                Statement statement_CTHD = connection.createStatement();
                ResultSet res_CTHD = statement_CTHD.executeQuery(sql_CTHD);
                
                while(res_CTHD.next()){
                    String MAMON = res_CTHD.getString("MAMON");
                    String SL = res_CTHD.getString("SL");
                    int TINHTRANGMON = res_CTHD.getInt("TINHTRANGMON");
                    String StrTinhTrang;
                    if(TINHTRANGMON == 0)
                        StrTinhTrang = "Chưa lên món";
                    else
                        StrTinhTrang = "Đã lên món";
                    
                    String sql_TENMON = "SELECT TENMON FROM MONAN WHERE MAMON = '" + MAMON + "'";
                    Statement statement_TENMON = connection.createStatement();
                    ResultSet res_TENMON = statement_TENMON.executeQuery(sql_TENMON);
                    while (res_TENMON.next()) {
                        String TENMON = res_TENMON.getString("TENMON");

                        Object tbdata[] = {MAMON, TENMON, SL, StrTinhTrang, null};
                        tbmodel.addRow(tbdata);
                    }
                }
            }
        }
        catch(SQLException | HeadlessException ex){
                    System.out.println("the error is"+ex);
        }
    }

    public void DaLenMon(int row) {
        if (table_DM.isEditing()) {
            table_DM.getCellEditor().stopCellEditing();
        }
        DefaultTableModel model = (DefaultTableModel) table_DM.getModel();
        Object value_MAMON = model.getValueAt(row, 0);
        
        try {
            Statement statement = connection.createStatement();
            
                String sql = "UPDATE CTHD SET TINHTRANGMON = 1 WHERE SOHD = '" + SOHD + "' AND MAMON = '"+value_MAMON+"'";
                int res = statement.executeUpdate(sql);
                
                model.setValueAt("Đã lên món", row, 3);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ChuaLenMon(int row) {
        if (table_DM.isEditing()) {
            table_DM.getCellEditor().stopCellEditing();
        }
        DefaultTableModel model = (DefaultTableModel) table_DM.getModel();
        Object value_MAMON = model.getValueAt(row, 0);
        
        try {
            Statement statement = connection.createStatement();
            
                String sql = "UPDATE CTHD SET TINHTRANGMON = 0 WHERE SOHD = '" + SOHD + "' AND MAMON = '"+value_MAMON+"'";
                int res = statement.executeUpdate(sql);
                
                model.setValueAt("Chưa lên món", row, 3);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
