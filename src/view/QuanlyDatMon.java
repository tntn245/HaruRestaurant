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
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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
    private JOptionPane option;

    private String SOHD;
    private Connection connection;

    public QuanlyDatMon(Connection connection) {
        this.connection = connection;
        init_pane();
    }

    public void init_pane() {
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
        for (int i = 0; i < 15; i++) {
            int SoBan = i + 1;
            combobox_Ban.addItem("Bàn " + SoBan);
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

        option = new JOptionPane();

        pane_QLDM.add(combobox_Ban);
        pane_QLDM.add(Scrollpane_TableDM);
        pane_shadow.add(pane_QLDM);
        pane_bg.add(pane_shadow);
    }

    private void table_DM() {
        Scrollpane_TableDM = new JScrollPane();

        String[] columnNames = {"Mã món", "Tên món", "SL", "SL món đã lên"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            boolean[] canEdit = new boolean[]{
                false, false, false, true
            };

            @Override
            public boolean isCellEditable(int row, int column) {
                return canEdit[column];
            }
        };
        table_DM = new JTable(model);
        table_DM.setRowHeight(40);

        table_DM.getTableHeader().setOpaque(false);
        table_DM.getTableHeader().setBackground(new Color(167, 222, 254));
        table_DM.getTableHeader().setForeground(Color.black);
        table_DM.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
//        table_NV.getTableHeader().setFont(new Font(table_NV.getFont().getName(),Font.BOLD,14));
        table_DM.getTableHeader().setPreferredSize(new Dimension(table_DM.getWidth(), 40));
        table_DM.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));

        table_DM.setShowHorizontalLines(false);
        table_DM.setGridColor(Color.white);
        table_DM.setBackground(Color.white);
        table_DM.setBorder(new EmptyBorder(5, 5, 5, 5));
        table_DM.setFont(new Font("SansSerif", Font.PLAIN, 14));
//        table_NV.setFont(new Font(table_NV.getFont().getName(),Font.PLAIN,14));

        table_DM.setPreferredScrollableViewportSize(table_DM.getPreferredSize());
        table_DM.setFillsViewportHeight(true);
        
        table_DM.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

                String sl = table.getModel().getValueAt(row, 2).toString();
                String slhoanthanh = table.getModel().getValueAt(row, 3).toString();
                if (sl.equals(slhoanthanh)) {
                    setBackground(new Color(234, 247, 255));
                    setForeground(Color.BLACK);
                } else {
                    setBackground(new Color(255, 237, 243));
                    setForeground(Color.BLACK);
                }
                return this;
            }
        });

        TableColumnModel tcm = table_DM.getColumnModel();
        TableColumn tc = tcm.getColumn(3);
        tc.setCellEditor(new SpinnerEditor(0));
        
        tc.getCellEditor().addCellEditorListener(new CellEditorListener() {
            public void editingCanceled(ChangeEvent e) {
                System.out.println("editingCanceled");
            }

            public void editingStopped(ChangeEvent e) {
                String StrSL = table_DM.getValueAt(table_DM.getSelectedRow(), 2).toString();
                int SL = Integer.parseInt(StrSL);
                String StrSLHOANTHANH = table_DM.getValueAt(table_DM.getSelectedRow(), 3).toString();
                int SLHOANTHANH= Integer.parseInt(StrSLHOANTHANH);

                if(SLHOANTHANH > SL) {
                    SLHOANTHANH = SL;
                    table_DM.setValueAt(SLHOANTHANH, table_DM.getSelectedRow(), 3);
                }
                try {
                    Statement statement = connection.createStatement();
                    String sql = "UPDATE CTHD SET SLHOANTHANH = "+SLHOANTHANH+" WHERE SOHD = '" + SOHD + "' AND MAMON = '" + table_DM.getValueAt(table_DM.getSelectedRow(), 0) + "'";
                    int res = statement.executeUpdate(sql);

                    option.setVisible(true);
                    option.showMessageDialog(pane_bg, "Cập nhật tình trạng lên món thành công!");
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    option.setVisible(true);
                    option.showMessageDialog(pane_bg, "Có lỗi xảy ra, không thể cập nhật tình trạng lên món!");
                }
                
            }
        });
        
        Scrollpane_TableDM.setViewportView(table_DM);
        Scrollpane_TableDM.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        Scrollpane_TableDM.setPreferredSize(new Dimension(700, 420));
    }

    public void add_data_table(Object TenBan) {
        String SoBan = TenBan.toString().substring(4);
        int So = Integer.parseInt(SoBan);
        DefaultTableModel tbmodel = (DefaultTableModel) table_DM.getModel();
        tbmodel.setRowCount(0);

        try {
            String sql_SOHD = "SELECT SOHD FROM HOADON WHERE TINHTRANGTHANHTOAN = 0 AND MABAN = 'BAN" + So + "'";
            Statement statement_SOHD = connection.createStatement();
            ResultSet res_SOHD = statement_SOHD.executeQuery(sql_SOHD);

            while (res_SOHD.next()) {
                SOHD = res_SOHD.getString("SOHD");

                String sql_CTHD = "SELECT * FROM CTHD WHERE SOHD = '" + SOHD + "'";
                Statement statement_CTHD = connection.createStatement();
                ResultSet res_CTHD = statement_CTHD.executeQuery(sql_CTHD);

                while (res_CTHD.next()) {
                    String MAMON = res_CTHD.getString("MAMON");
                    String SL = res_CTHD.getString("SL");
                    int SLHOANTHANH = res_CTHD.getInt("SLHOANTHANH");

                    String sql_TENMON = "SELECT TENMON FROM MONAN WHERE MAMON = '" + MAMON + "'";
                    Statement statement_TENMON = connection.createStatement();
                    ResultSet res_TENMON = statement_TENMON.executeQuery(sql_TENMON);
                    while (res_TENMON.next()) {
                        String TENMON = res_TENMON.getString("TENMON");

                        Object tbdata[] = {MAMON, TENMON, SL, SLHOANTHANH, null};
                        tbmodel.addRow(tbdata);
                    }
                }
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println("the error is" + ex);
        }
    }
}
