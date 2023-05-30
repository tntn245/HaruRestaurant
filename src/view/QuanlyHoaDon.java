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
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.DateFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author My PC
 */
public class QuanlyHoaDon {                  
    private javax.swing.JCheckBox CheckBox_DaThanhToan;
    private javax.swing.JScrollPane ScrollPane_CTHD;
    private javax.swing.JScrollPane ScrollPane_ViTri;

    private javax.swing.JPanel pane_TaoHoaDon;
    public view.ButtonGradient btn_TaoHoaDon  = new ButtonGradient();
    
    private ArrayList<JButton> btn_Ban;
    
    private int Tien =0;
    private int old_SL = 0;
    private int new_Sl = 0;
    
    private view.ButtonGradient btn_InHoaDon;
    private view.ButtonGradient btn_LichSuHD;
    private view.ButtonGradient btn_ThanhToan;
    private view.ButtonGradient btn_ThucDon;
    private view.ButtonGradient btn_DatMon;
    private view.ButtonGradient btn_ViTri;
    private javax.swing.JLabel label_Ban4ng;
    private javax.swing.JLabel label_Ban6ng;
    private javax.swing.JLabel label_Ban8ng;
    private view.ButtonGradient label_ChiTiet;
    private javax.swing.JLabel label_ConTrong;
    private javax.swing.JLabel label_DangSD;
    private javax.swing.JLabel label_temp;
    private javax.swing.JLabel label_SetSoBan;
    private javax.swing.JLabel label_SetSoHD;
    private javax.swing.JLabel label_SetTongTien;
    private javax.swing.JLabel label_TongTien;
    private javax.swing.JPanel pane_ChiTiet;
    private javax.swing.JPanel pane_Chung;
    private javax.swing.JPanel pane_GhiChu;
    private javax.swing.JPanel pane_HoaDon;
    private javax.swing.JPanel pane_Scroll_ViTri;
    private javax.swing.JPanel pane_SoHD_SoBan;
    private javax.swing.JPanel pane_ViTri;
    private javax.swing.JPanel pane_bg_ChiTiet;
    private javax.swing.JPanel pane_bg_ViTri;
    private javax.swing.JPanel pane_btn;
    private javax.swing.JTable table_CTHD;
    
    public JPanel pane_bg_LichSuHD;
    private JTextField txtSearch_HD;
    private JButton btn_Search_HD;
    private JComboBox boxSearch_HD;
    private JPanel pane_Search_HD;
    private JScrollPane Scrollpane_TableHoaDon;
    private JTable table_HoaDon;
    
    public JPanel pane_bg_ThucDon;
    private JTextField txtSearch_ThucDon;
    private JButton btn_Search_ThucDon;
    private JComboBox boxSearch_ThucDon;
    private JPanel pane_Search_ThucDon;    
    private JScrollPane Scrollpane_ThucDon;
    private JPanel pane_ThucDon;  
    
    private ArrayList<JLabel> label_LoaiMon_list;
    private ArrayList<ArrayList<JButton>> btn_MonAn_list;
    
    private JOptionPane option_ThanhToanHD;
    private JOptionPane option_TaoMoiHD;
    private JOptionPane option_InHD;
    
    private JDialog formHD_jDialog;
    private JTextField txt_SoHD;
    private JTextField txt_NgHD;
    private JComboBox txt_MaNV;
    private JTextField txt_TriGia;
    private JComboBox txt_TinhTrangThanhToan;
    private JComboBox txt_MaBan;
    public ButtonGradient btn_XacNhan  = new ButtonGradient();
    public ButtonGradient btn_cancel  = new ButtonGradient();
    public JOptionPane suaHD_jOptionPane = new JOptionPane();
    
    public javax.swing.JPanel pane_bg;

    private Connection connection;
 
    public QuanlyHoaDon(Connection connection){
        this.connection = connection;
        initComponents();
    }
    
    public String getSOHD(){
        return label_SetSoHD.getText();
    }
    
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pane_bg = new javax.swing.JPanel();
        pane_HoaDon = new javax.swing.JPanel();
        pane_SoHD_SoBan = new javax.swing.JPanel();
        label_SetSoHD = new javax.swing.JLabel();
        label_SetSoBan = new javax.swing.JLabel();
        btn_ThucDon = new view.ButtonGradient();
        CheckBox_DaThanhToan = new javax.swing.JCheckBox();
        label_TongTien = new javax.swing.JLabel();
        label_SetTongTien = new javax.swing.JLabel();
        btn_InHoaDon = new view.ButtonGradient();
        btn_ThanhToan = new view.ButtonGradient();
        btn_ThanhToan.setEnabled(false);
        pane_TaoHoaDon = new javax.swing.JPanel();
        
        ScrollPane_CTHD = new javax.swing.JScrollPane();
        String[] columnNames = {"", "", ""};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };
            
            @Override
            public boolean isCellEditable(int row, int column) {
               return canEdit [column];
            }
        };
        table_CTHD = new javax.swing.JTable(model);
        pane_Chung = new javax.swing.JPanel();
        pane_btn = new javax.swing.JPanel();
        btn_ViTri = new view.ButtonGradient();
        btn_LichSuHD = new view.ButtonGradient();
        pane_bg_ViTri = new javax.swing.JPanel();
        pane_bg_LichSuHD = new javax.swing.JPanel();
        pane_bg_ThucDon = new javax.swing.JPanel();
        pane_ViTri = new javax.swing.JPanel();
        pane_GhiChu = new javax.swing.JPanel();
        label_DangSD = new javax.swing.JLabel();
        label_temp = new javax.swing.JLabel();
        label_ConTrong = new javax.swing.JLabel();
        ScrollPane_ViTri = new javax.swing.JScrollPane();
        pane_Scroll_ViTri = new javax.swing.JPanel();
        
        btn_Ban = new ArrayList<JButton>();

        pane_bg_ChiTiet = new javax.swing.JPanel();
        pane_ChiTiet = new javax.swing.JPanel();
        label_ChiTiet = new view.ButtonGradient();
        label_Ban4ng = new javax.swing.JLabel();
        label_Ban6ng = new javax.swing.JLabel();
        label_Ban8ng = new javax.swing.JLabel();

        pane_bg.setBackground(new java.awt.Color(230, 235, 240));
        pane_bg.setPreferredSize(new java.awt.Dimension(100, 600));
        pane_bg.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 5));

        pane_HoaDon.setBackground(new java.awt.Color(255,255,255));
        pane_HoaDon.setPreferredSize(new java.awt.Dimension(270, 540));
        pane_HoaDon.setLayout(new java.awt.GridBagLayout());

        pane_SoHD_SoBan.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        pane_SoHD_SoBan.setPreferredSize(new java.awt.Dimension(120, 30));
        pane_SoHD_SoBan.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        label_SetSoHD.setBackground(new java.awt.Color(130, 210, 255));
        label_SetSoHD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        label_SetSoHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_SetSoHD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_SetSoHD.setText("HD");
        label_SetSoHD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_SetSoHD.setIconTextGap(0);
        label_SetSoHD.setMinimumSize(new java.awt.Dimension(50, 20));
        label_SetSoHD.setOpaque(true);
        label_SetSoHD.setPreferredSize(new java.awt.Dimension(70, 30));
        pane_SoHD_SoBan.add(label_SetSoHD);

        label_SetSoBan.setBackground(new java.awt.Color(225, 244, 255));
        label_SetSoBan.setForeground(new java.awt.Color(0, 102, 255));
        label_SetSoBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_SetSoBan.setText("Bàn");
        label_SetSoBan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_SetSoBan.setIconTextGap(0);
        label_SetSoBan.setOpaque(true);
        label_SetSoBan.setPreferredSize(new java.awt.Dimension(50, 30));
        pane_SoHD_SoBan.add(label_SetSoBan);
        option_ThanhToanHD = new JOptionPane();
        option_TaoMoiHD = new JOptionPane();
        
        pane_HoaDon.add(pane_SoHD_SoBan, new java.awt.GridBagConstraints());

        ImageIcon icon = new ImageIcon(getClass().getResource("/image/menu_1.png"));
        Image image = icon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_ThucDon.setIcon(newIcon); // NOI18N
        btn_ThucDon.setText("Thực đơn");
        btn_ThucDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_ThucDon.setPreferredSize(new java.awt.Dimension(118, 33));
        btn_ThucDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                init_ThucDon();
                if(pane_bg_ViTri.isDisplayable()){
                    pane_bg_ViTri.setVisible(false);
                    pane_bg_ThucDon.setVisible(true);
                }      
                if(pane_bg_LichSuHD.isDisplayable()){
                    pane_bg_LichSuHD.setVisible(false);
                    pane_bg_ThucDon.setVisible(true);
                }    
                pane_bg_ThucDon.setVisible(true);
                pane_Chung.add(pane_bg_ThucDon);
            }
        });
                
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pane_HoaDon.add(btn_ThucDon, gridBagConstraints);

        label_TongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_TongTien.setText("TỔNG TIỀN:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pane_HoaDon.add(label_TongTien, gridBagConstraints);
        label_TongTien.setVisible(false);

        label_SetTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_SetTongTien.setText(""+Tien);
        label_SetTongTien.setPreferredSize(new java.awt.Dimension(100, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        pane_HoaDon.add(label_SetTongTien, gridBagConstraints);
        label_SetTongTien.setVisible(false);
        
        CheckBox_DaThanhToan.setText("Đã thanh toán");
        CheckBox_DaThanhToan.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    btn_ThanhToan.setEnabled(true);

                }
            }
        });
        btn_ThanhToan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ThanhToan_jButtonActionPerformed(label_SetSoBan, label_SetSoHD);
                System.out.println("Da click thanh toan");
            }
        });
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        pane_HoaDon.add(CheckBox_DaThanhToan, gridBagConstraints);        
        CheckBox_DaThanhToan.setVisible(false);

//        btn_InHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dollar1.png"))); // NOI18N
        btn_InHoaDon.setText("IN HÓA ĐƠN");
        btn_InHoaDon.setFont(new java.awt.Font(btn_InHoaDon.getFont().getName(), 1, 12)); // NOI18N
        btn_InHoaDon.setPreferredSize(new java.awt.Dimension(110, 33));
        btn_InHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InHoaDon();
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pane_HoaDon.add(btn_InHoaDon, gridBagConstraints);
        btn_InHoaDon.setVisible(false);

//        btn_ThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dollar1.png"))); // NOI18N
        btn_ThanhToan.setText("THANH TOÁN");
        btn_ThanhToan.setFont(new java.awt.Font(btn_ThanhToan.getFont().getName(), 1, 12)); // NOI18N
        btn_ThanhToan.setPreferredSize(new java.awt.Dimension(120, 33));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pane_HoaDon.add(btn_ThanhToan, gridBagConstraints);
        btn_ThanhToan.setVisible(false);

        pane_TaoHoaDon.setPreferredSize(new Dimension(250, 93));
        pane_TaoHoaDon.setBackground(Color.white);
        
        btn_TaoHoaDon.setText("TẠO HÓA ĐƠN");
        btn_TaoHoaDon.setFont(new java.awt.Font(btn_TaoHoaDon.getFont().getName(), 1, 16)); // NOI18N
        btn_TaoHoaDon.setPreferredSize(new java.awt.Dimension(250, 40));
        btn_TaoHoaDon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TaoMoiHD(label_SetSoBan.getText());
            }
        });
        pane_TaoHoaDon.add(btn_TaoHoaDon);
        btn_TaoHoaDon.setVisible(false);
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2; //2-4
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pane_HoaDon.add(pane_TaoHoaDon, gridBagConstraints);
        pane_TaoHoaDon.setVisible(true);
        
        ScrollPane_CTHD.setPreferredSize(new java.awt.Dimension(250, 350));

        table_CTHD.setRowHeight(40);
        table_CTHD.setFont(new Font(table_CTHD.getFont().getName(), Font.PLAIN, 14));
        table_CTHD.setShowGrid(false);
        table_CTHD.setShowHorizontalLines(true);
        table_CTHD.setSelectionBackground(new Color(167,223,255));//, 255, 184, 183
        
        TableColumnModel tcm = table_CTHD.getColumnModel();
        TableColumn tc = tcm.getColumn(2);
        tc.setCellEditor(new SpinnerEditor(0));
        
        table_CTHD.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                old_SL = Integer.parseInt(table_CTHD.getValueAt(table_CTHD.getSelectedRow(), 2).toString());
            }
        });
        tc.getCellEditor().addCellEditorListener(
                new CellEditorListener() {
            public void editingCanceled(ChangeEvent e) {
                System.out.println("editingCanceled");
            }

            public void editingStopped(ChangeEvent e) {
                System.out.println("editingStopped: apply additional action" + table_CTHD.getSelectedRow());

                String StrDG = table_CTHD.getValueAt(table_CTHD.getSelectedRow(), 1).toString();
                int DG = Integer.parseInt(StrDG);
                String Strsl = table_CTHD.getValueAt(table_CTHD.getSelectedRow(), 2).toString();
                new_Sl = Integer.parseInt(Strsl);
                Tien = Tien + (new_Sl - old_SL) * DG;

                System.out.println(Tien);
                label_SetTongTien.setText("" + Tien);
            }
        });
        
        ScrollPane_CTHD.setViewportView(table_CTHD);
        ScrollPane_CTHD.setBorder(null);
        ScrollPane_CTHD.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPane_CTHD.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        table_CTHD.setPreferredScrollableViewportSize(table_CTHD.getPreferredSize());
        table_CTHD.setTableHeader(null);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        pane_HoaDon.add(ScrollPane_CTHD, gridBagConstraints);

        pane_bg.add(pane_HoaDon);

        pane_Chung.setBackground(new java.awt.Color(230, 235, 240));
        pane_Chung.setAlignmentX(0.0F);
        pane_Chung.setAlignmentY(0.0F);
        pane_Chung.setPreferredSize(new java.awt.Dimension(490, 550));

        pane_btn.setBackground(new java.awt.Color(255, 255, 255));
        pane_btn.setAlignmentX(0.0F);
        pane_btn.setAlignmentY(0.0F);
        pane_btn.setPreferredSize(new java.awt.Dimension(500, 50));
        pane_btn.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 8));

        btn_ViTri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dollar1.png"))); // NOI18N
        btn_ViTri.setText("Vị trí");
        btn_ViTri.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_ViTri.setPreferredSize(new java.awt.Dimension(100, 33));
        btn_ViTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(pane_bg_LichSuHD.isDisplayable()){
                    pane_bg_LichSuHD.setVisible(false);
                    pane_bg_ViTri.setVisible(true);
                }      
                if(pane_bg_ThucDon.isDisplayable()){
                    pane_bg_ThucDon.setVisible(false);
                    pane_bg_ViTri.setVisible(true);
                }  
                pane_Chung.add(pane_bg_ViTri);
            }
        });
        pane_btn.add(btn_ViTri);

        btn_LichSuHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/history.png"))); // NOI18N
        btn_LichSuHD.setText("Lịch sử hóa đơn");
        btn_LichSuHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_LichSuHD.setMaximumSize(new java.awt.Dimension(100, 27));
        btn_LichSuHD.setMinimumSize(new java.awt.Dimension(100, 27));
        btn_LichSuHD.setPreferredSize(new java.awt.Dimension(150, 33));
        btn_LichSuHD.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                init_LSHD();
                if(pane_bg_ViTri.isDisplayable()){
                    pane_bg_ViTri.setVisible(false);
                    pane_bg_LichSuHD.setVisible(true);
                }      
                if(pane_bg_ThucDon.isDisplayable()){
                    pane_bg_ThucDon.setVisible(false);
                    pane_bg_LichSuHD.setVisible(true);
                }  
                pane_Chung.add(pane_bg_LichSuHD);
            }
        });
        pane_btn.add(btn_LichSuHD);

        pane_Chung.add(pane_btn);

        pane_bg_ViTri.setBackground(new java.awt.Color(255, 255, 255));
        pane_bg_ViTri.setPreferredSize(new java.awt.Dimension(500, 485));

        pane_ViTri.setBackground(new java.awt.Color(255, 255, 255));
        pane_ViTri.setPreferredSize(new java.awt.Dimension(380, 485));
        pane_ViTri.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        pane_GhiChu.setBackground(new java.awt.Color(255, 255, 255));
        pane_GhiChu.setPreferredSize(new java.awt.Dimension(360, 40));
        pane_GhiChu.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        pane_GhiChu.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        label_DangSD.setBackground(new java.awt.Color(255, 227, 227));
        label_DangSD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_DangSD.setText("Đang sử dụng");
        label_DangSD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        label_DangSD.setOpaque(true);
        label_DangSD.setPreferredSize(new java.awt.Dimension(103, 30));
        pane_GhiChu.add(label_DangSD);

        label_temp.setBackground(new java.awt.Color(255, 255, 255));
        label_temp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_temp.setText("");
        label_temp.setOpaque(true);
        label_temp.setPreferredSize(new java.awt.Dimension(7, 30));
        pane_GhiChu.add(label_temp);        
        
        label_ConTrong.setBackground(new java.awt.Color(225, 244, 255));
        label_ConTrong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_ConTrong.setText("Còn trống");
        label_ConTrong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        label_ConTrong.setOpaque(true);
        label_ConTrong.setPreferredSize(new java.awt.Dimension(100, 30));
        pane_GhiChu.add(label_ConTrong);

        pane_ViTri.add(pane_GhiChu);

        ScrollPane_ViTri.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPane_ViTri.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ScrollPane_ViTri.setPreferredSize(new java.awt.Dimension(350, 405));

        pane_Scroll_ViTri.setBackground(new java.awt.Color(255, 255, 255));
        pane_Scroll_ViTri.setMinimumSize(new java.awt.Dimension(300, 1000));
        pane_Scroll_ViTri.setPreferredSize(new java.awt.Dimension(330, 600));
        pane_Scroll_ViTri.setLayout(new java.awt.GridLayout(0, 3, 15, 15));

        for(int i=0; i<15; i++){
            JButton btn_Bantemp = new JButton();
            int soban = i+1;
            btn_Bantemp.setText("Bàn "+soban);
            btn_Bantemp.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn_Bantemp.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(0, 204, 204)), UIManager.getBorder("Button.border")));
            btn_Bantemp.setPreferredSize(new java.awt.Dimension(80, 80));
            btn_Bantemp.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn_BanActionPerformed(evt, btn_Bantemp.getText(), btn_Bantemp);
                }
            });
            set_color_ban(btn_Bantemp);
            btn_Ban.add(btn_Bantemp);
            pane_Scroll_ViTri.add(btn_Ban.get(i));
        }

        ScrollPane_ViTri.setViewportView(pane_Scroll_ViTri);

        pane_ViTri.add(ScrollPane_ViTri);

        pane_bg_ViTri.add(pane_ViTri);

        pane_bg_ChiTiet.setBackground(new java.awt.Color(255, 255, 255));
        pane_bg_ChiTiet.setPreferredSize(new java.awt.Dimension(100, 450));
        pane_bg_ChiTiet.setLayout(new java.awt.FlowLayout(FlowLayout.CENTER, 0, 0));

        pane_ChiTiet.setBackground(new java.awt.Color(255, 255, 255));
        pane_ChiTiet.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        label_ChiTiet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        label_ChiTiet.setText("Chi tiết");
        label_ChiTiet.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        label_ChiTiet.setActionCommand("Chi tiết");
        label_ChiTiet.setMaximumSize(new java.awt.Dimension(100, 27));
        label_ChiTiet.setMinimumSize(new java.awt.Dimension(100, 27));
        label_ChiTiet.setPreferredSize(new java.awt.Dimension(90, 33));
        pane_ChiTiet.add(label_ChiTiet);

        label_Ban4ng.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Ban4ng.setText("Bàn 4 người");
        label_Ban4ng.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(0, 204, 204)), javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0))));
        pane_ChiTiet.add(label_Ban4ng);

        label_Ban6ng.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Ban6ng.setText("Bàn 6 người");
        label_Ban6ng.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(204, 153, 255)), javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0))));
        pane_ChiTiet.add(label_Ban6ng);

        label_Ban8ng.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Ban8ng.setText("Bàn 8 người");
        label_Ban8ng.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(255, 153, 0)), javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0))));
        pane_ChiTiet.add(label_Ban8ng);

        pane_bg_ChiTiet.add(pane_ChiTiet);

        pane_bg_ViTri.add(pane_bg_ChiTiet);
        
        pane_Chung.add(pane_bg_ViTri); //add lsu hoa don nua
        
        pane_bg.add(pane_Chung);
    }                 
    
    private void init_LSHD(){
        pane_bg_LichSuHD.setBackground(new java.awt.Color(255, 255, 255));
        pane_bg_LichSuHD.setPreferredSize(new java.awt.Dimension(500, 485));
        
        pane_Search_HD = new JPanel();
        pane_Search_HD.setBackground(Color.white);
        pane_Search_HD.setPreferredSize(new Dimension(800, 70)); 
        
        pane_search();
        pane_bg_LichSuHD.add(pane_Search_HD);
        table_HD();
        pane_bg_LichSuHD.add(Scrollpane_TableHoaDon);
    }
    
    private void set_SOHD(String SoBan, boolean flag_setrowcount){
        DefaultTableModel tbmodel = (DefaultTableModel) table_CTHD.getModel();
        
        boolean flag_SOHD =false;
        try {
            String sql = "SELECT * FROM HOADON WHERE MABAN = 'BAN" + SoBan +"' AND TINHTRANGTHANHTOAN = 0";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);

            if(flag_setrowcount)
                tbmodel.setRowCount(0);
            
            while (res.next()) {
                flag_SOHD = true;
                String SOHD = res.getString("SOHD");
                label_SetSoHD.setText(SOHD);
                add_data_table_CTHD(SOHD);
                String TRIGIA = res.getString("TRIGIA");
                label_SetTongTien.setText(TRIGIA);
            }
            if(!flag_SOHD){
                label_SetSoHD.setText("");
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println("the error is" + ex);
        }
    }
    
    private void btn_BanActionPerformed(ActionEvent e, String TenBan, JButton btn){
        String[] parts = TenBan.split(" ");
        String SoBan = parts[1];
        label_SetSoBan.setText(TenBan);
                        
        CheckBox_DaThanhToan.setSelected(false);
        btn_ThanhToan.setEnabled(false);
        
        set_SOHD(SoBan, true);
        set_TongTienBan();
        
        if(set_color_ban(btn)){
            label_TongTien.setVisible(false);
            label_SetTongTien.setVisible(false);
            CheckBox_DaThanhToan.setVisible(false);
            btn_InHoaDon.setVisible(false);
            btn_ThanhToan.setVisible(false);
            btn_TaoHoaDon.setVisible(true);
            pane_TaoHoaDon.setVisible(true);
        }
        else{
            pane_TaoHoaDon.setVisible(false);
            label_TongTien.setVisible(true);
            label_SetTongTien.setVisible(true);
            CheckBox_DaThanhToan.setVisible(true);
            btn_InHoaDon.setVisible(true);
            btn_ThanhToan.setVisible(true);
        }
    }
    
    private void set_TongTienBan(){
        Tien = 0;
        for(int row=0; row<table_CTHD.getRowCount(); row++){
            Object dongia = table_CTHD.getValueAt(row, 1);
            int DG = Integer.parseInt(dongia.toString());
            Object sl = table_CTHD.getValueAt(row, 2);
            int SL = Integer.parseInt(sl.toString());

            Tien = Tien + SL * DG;

            System.out.println(Tien);
            label_SetTongTien.setText("" + Tien);
        }
    }
    
    private String MANV = "";
    public void setMANV(String TAIKHOANNV){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT MANV FROM NHANVIEN WHERE TENTK = '"+TAIKHOANNV+"'";
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                MANV = res.getString("MANV");
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println("the error is" + ex);
        }     
    }
    
    private boolean kiemtrarangbuoc(String SOHD, String StrNGHD, String MANV){
        try {
                Statement statement_NGVL = connection.createStatement();
                String sql_NGVL = "SELECT TO_CHAR(NGVL, 'DD-MM-YYYY') as NGVL FROM NHANVIEN WHERE MANV = '" + MANV + "'";
                ResultSet res_NGVL = statement_NGVL.executeQuery(sql_NGVL);
                while (res_NGVL.next()) {
                    String StrNGVL = res_NGVL.getString("NGVL");
                    Date NGVL=new SimpleDateFormat("dd-MM-yyyy").parse(StrNGVL);
                    Date NGHD=new SimpleDateFormat("dd-MM-yyyy").parse(StrNGHD);
                    if(NGVL.compareTo(NGHD) > 0){
                        JOptionPane date_option = new JOptionPane();
                        date_option.setVisible(true);
                        date_option.showMessageDialog(formHD_jDialog, "Ngày nhân viên lập hóa đơn không được xảy ra trước ngày vào làm!");
                        return false;
                    }
                }
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        return true;
    }
    
    private void TaoMoiHD(String TenBan) {
        String[] parts = TenBan.split(" ");
        String SOBAN = parts[1];
                
        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String today = formatter.format(date);
        try {
            if(kiemtrarangbuoc(" ", today, MANV)) {
                Statement statement = connection.createStatement();
                String sql = "UPDATE VITRI SET TINHTRANGSD = 1 WHERE SOBAN = " + SOBAN;
                int res = statement.executeUpdate(sql);
                sql = "INSERT INTO HOADON VALUES (  '' , TO_DATE('" + today + "', 'DD-MM-YYYY'), '" + MANV + "', 0, 0, 'BAN" + SOBAN + "' )";
                res = statement.executeUpdate(sql);
                
                option_TaoMoiHD.setVisible(true);
                option_TaoMoiHD.showMessageDialog(pane_HoaDon, "Tạo mới hóa đơn thành công!");

                pane_TaoHoaDon.setVisible(false);
                label_TongTien.setVisible(true);
                label_SetTongTien.setVisible(true);
                CheckBox_DaThanhToan.setVisible(true);
                btn_InHoaDon.setVisible(true);
                btn_ThanhToan.setVisible(true);

                set_SOHD(SOBAN, false);
                for (int i = 0; i < 15; i++) {
                    if (btn_Ban.get(i).getText().equals(TenBan)) {
                        set_color_ban(btn_Ban.get(i));
                    }
                }
                DatMon(label_SetSoHD.getText());
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Loop_check_MAMON(String SOHD){
        DefaultTableModel tbmodel_CTHD= (DefaultTableModel) table_CTHD.getModel();
        for(int row=0; row<table_CTHD.getRowCount(); row++){
            Object mamon = table_CTHD.getValueAt(row, 0);
            Object dongia = table_CTHD.getValueAt(row, 1);
            Object sl = table_CTHD.getValueAt(row, 2);
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
                    String sql_INSERT = "INSERT INTO CTHD VALUES (  '" + SOHD + "' , '" + mamon + "', " + sl + ", " + dongia + " )";
                    int res_INSERT = statement_INSERT.executeUpdate(sql_INSERT);
                    System.out.println("Insert thanh cong " + SOHD);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void ThanhToan_jButtonActionPerformed(JLabel TENBAN, JLabel SOHD) {
        String TenBan = TENBAN.getText();
        String[] parts = TenBan.split(" ");
        String SOBAN = parts[1];
        
        String SoHD = SOHD.getText();

        CheckBox_DaThanhToan.setSelected(false);
        btn_ThanhToan.setEnabled(false);
        
        if(SoHD.equals("")){
            option_ThanhToanHD.setVisible(true);
            option_ThanhToanHD.showMessageDialog(pane_HoaDon, "Bàn chưa có hóa đơn!");
            return;
        }
        
        Loop_check_MAMON(SoHD);
        
        try {
            Statement statement = connection.createStatement();
            String sql = "UPDATE VITRI SET TINHTRANGSD = 0 WHERE SOBAN = " + SOBAN;
            int res = statement.executeUpdate(sql);
            sql = "UPDATE HOADON SET TINHTRANGTHANHTOAN = 1 WHERE SOHD = '" + SOHD.getText() + "'";
            res = statement.executeUpdate(sql);
            System.out.println("Update ban thanh cong");
            option_ThanhToanHD.setVisible(true);
            option_ThanhToanHD.showMessageDialog(pane_HoaDon, "Thanh toán thành công!");
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel tbmodel = (DefaultTableModel) table_CTHD.getModel();
        tbmodel.setRowCount(0);

        for (int i = 0; i < 15; i++) {
            if (btn_Ban.get(i).getText().equals(TenBan)) {
                set_color_ban(btn_Ban.get(i));
            }
        }

        label_SetSoHD.setText("");
        label_TongTien.setVisible(false);
        label_SetTongTien.setVisible(false);
        CheckBox_DaThanhToan.setVisible(false);
        btn_InHoaDon.setVisible(false);
        btn_ThanhToan.setVisible(false);
        btn_TaoHoaDon.setVisible(true);
        pane_TaoHoaDon.setVisible(true);
    }
    
    private boolean set_color_ban(JButton btn){
        String TenBan = btn.getText();
        String[] parts = TenBan.split(" ");
        String SoBan = parts[1];
        try{
            String sql = "SELECT TINHTRANGSD FROM VITRI WHERE SOBAN ="+SoBan;
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);
            while(res.next()){
                String TINHTRANGSD = res.getString("TINHTRANGSD");
                if(TINHTRANGSD.equals("0")){
                    btn.setBackground(new Color(234,247,255));
                    return true;
                }
                else{
                    btn.setBackground(new Color(255, 227, 227));
                    return false;
                }
            }
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is"+ex);
        }
        return false;
    }
    
    public void add_data_table_CTHD(String SOHD) {
        DefaultTableModel tbmodel = (DefaultTableModel) table_CTHD.getModel();
        try {
            String sql_CTHD = "SELECT * FROM CTHD WHERE SOHD = '" + SOHD + "'";
            Statement statement_CTHD = connection.createStatement();
            ResultSet res_CTHD = statement_CTHD.executeQuery(sql_CTHD);
            while (res_CTHD.next()) {
                String MAMON = res_CTHD.getString("MAMON");
                int SL = res_CTHD.getInt("SL");
                String DONGIA = res_CTHD.getString("DONGIA");

                Object tbdata[] = {MAMON, DONGIA, SL};
                tbmodel.addRow(tbdata);
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println("the error " + ex);
        }
    }
        
    public void pane_search(){
        JPanel pane_search_bar = new JPanel();
        pane_search_bar.setBackground(Color.white );
        pane_search_bar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        txtSearch_HD = new JTextField(" Search");
        txtSearch_HD.setPreferredSize(new Dimension(50, 31)); 
        txtSearch_HD.setColumns(25);     
        txtSearch_HD.setForeground(Color.GRAY);
        txtSearch_HD.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtSearch_HD.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                txtSearch_HD.setText("");
                txtSearch_HD.setFont(new Font("SansSerif", Font.PLAIN, 14));
                txtSearch_HD.setForeground(Color.BLACK);
            }
            public void focusLost(FocusEvent e) {
            }
        });
        
        btn_Search_HD = new JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/search1.png"));
        Image image = icon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_Search_HD.setIcon(newIcon);
        btn_Search_HD.setBackground(Color.white);
        btn_Search_HD.setPreferredSize(new Dimension(40, 31)); 
        btn_Search_HD.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        pane_search_bar.add(txtSearch_HD);
        pane_search_bar.add(btn_Search_HD);
        
        String colname_HD[] = { "SOHD", "NGHD", "MANV", "TRIGIA", "TINHTRANGTHANHTOAN", "MABAN"};
        boxSearch_HD = new JComboBox(colname_HD);
        boxSearch_HD.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boxSearch_HD.setSelectedItem("SOHD");
        boxSearch_HD.setFont(new Font("SansSerif", Font.BOLD, 14));
        boxSearch_HD.setBackground(Color.white);
        boxSearch_HD.setPreferredSize(new Dimension(130, 35)); 

        Search();
        
        pane_search_bar.setBorder(txtSearch_HD.getBorder());
        txtSearch_HD.setBorder(null);
        btn_Search_HD.setBorder(null);
        
        pane_Search_HD.add(pane_search_bar);
        pane_Search_HD.add(boxSearch_HD);
        pane_Search_HD.setBorder(new EmptyBorder(10, 0, 0, 0));
    }
    
    public void Search(){
        btn_Search_HD.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){                
                if(txtSearch_HD.getText().equals("") || txtSearch_HD.getText().equals(" Search"))
                    add_data_table_HD();
                else {
                    boolean flag = false;
                    try {
                        String sql = "SELECT SOHD, "
                                + "TO_CHAR(NGHD, 'DD-MM-YYYY') as NGHD, "
                                + "MANV, TRIGIA, TINHTRANGTHANHTOAN, MABAN "
                                + "FROM HOADON WHERE "
                                + boxSearch_HD.getSelectedItem().toString() + " LIKE '%" + txtSearch_HD.getText() + "%'";
                        Statement statement = connection.createStatement();
                        ResultSet res = statement.executeQuery(sql);

                        DefaultTableModel tbmodel = (DefaultTableModel) table_HoaDon.getModel();
                        tbmodel.setRowCount(0);

                        while (res.next()) {
                            String SOHD = res.getString("SOHD");
                            String NGHD = res.getString("NGHD");
                            String TRIGIA = res.getString("TRIGIA");
                            Object TINHTRANGTHANHTOAN = res.getObject("TINHTRANGTHANHTOAN");

                            Object tbdata[] = {SOHD, NGHD, TRIGIA, TINHTRANGTHANHTOAN, null};
                            tbmodel.addRow(tbdata);
                        }
                    } catch (SQLException | HeadlessException ex) {
                        System.out.println("the error is" + ex);
                    }

                    if (!flag) {
                        JOptionPane search_jOptionPane = new JOptionPane();
                        search_jOptionPane.setVisible(true);
                        search_jOptionPane.showMessageDialog(pane_bg_LichSuHD, "Không tìm thấy hóa đơn!");
                    }
                }
            }
        });
    }
        
    public void table_HD(){
        Scrollpane_TableHoaDon= new JScrollPane();

        String[] columnNames = {"Số HD", "Ngày HD", "Trị giá", "Tình trạng", ""};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };
            
            @Override
            public boolean isCellEditable(int row, int column) {
               return canEdit [column];
            }
        };
        table_HoaDon = new JTable(model);
        table_HoaDon.setRowHeight(40);
        table_HoaDon.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ?  new Color(234,247,255): new Color(255, 237, 243));
                c.setForeground(Color.black);
                return c;
            }
        });        
        
        table_HoaDon.getTableHeader().setOpaque(false);
        table_HoaDon.getTableHeader().setBackground(new Color(167,222,254));
        table_HoaDon.getTableHeader().setForeground(Color.black);
        table_HoaDon.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table_HoaDon.getTableHeader().setPreferredSize(new Dimension(table_HoaDon.getWidth(),40));
        table_HoaDon.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
                
        table_HoaDon.setShowHorizontalLines(false);
        table_HoaDon.setGridColor(Color.white);
        table_HoaDon.setBackground(Color.white);
        table_HoaDon.setBorder(new EmptyBorder(5, 5, 5,5));
        table_HoaDon.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        TableColumnModel columnModel = table_HoaDon.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(50);
        
        add_data_table_HD();
        
        table_HoaDon.setPreferredScrollableViewportSize(table_HoaDon.getPreferredSize());
        table_HoaDon.setFillsViewportHeight(true);
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                SuaHoaDon_Dialog(row);
            }

            @Override
            public void onDelete(int row) {
            }
        };
        table_HoaDon.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender( new Color(234,247,255), new Color(255, 237, 243),true, false));
        table_HoaDon.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event, new Color(234,247,255), new Color(255, 237, 243),true, false));
        
        Scrollpane_TableHoaDon.setViewportView(table_HoaDon);
        Scrollpane_TableHoaDon.setBorder(new LineBorder( Color.LIGHT_GRAY, 1, true));
        Scrollpane_TableHoaDon.setPreferredSize(new Dimension(450, 390));
    }
    
    public void add_data_table_HD(){
        try{
            DefaultTableModel tbmodel = (DefaultTableModel)table_HoaDon.getModel();
            String sql = "SELECT SOHD, "
                    + "TO_CHAR(NGHD, 'DD-MM-YYYY') as NGHD, "
                    + "MANV, TRIGIA, TINHTRANGTHANHTOAN, MABAN "
                    + "FROM HOADON ORDER BY TO_NUMBER(SUBSTR( SOHD, 3 ))";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);

            tbmodel.setRowCount(0);
            while(res.next()){
                String SOHD = res.getString("SOHD");
                String NGHD = res.getString("NGHD");
                String TRIGIA = res.getString("TRIGIA");
                String TINHTRANGTHANHTOAN = res.getString("TINHTRANGTHANHTOAN");
                
                Object tbdata[] = {SOHD, NGHD, TRIGIA, TINHTRANGTHANHTOAN, null};
                tbmodel.addRow(tbdata);
            }
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is"+ex);
        }
    }
    
    public void init_Dialog(){
        formHD_jDialog = new JDialog();
        formHD_jDialog.getContentPane().setBackground(new Color(255, 255, 255));
        formHD_jDialog.setPreferredSize(new Dimension(700, 400));
        formHD_jDialog.setModal(true);
        formHD_jDialog.setResizable(false);
        formHD_jDialog.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0,10));
    }
    
    public void Dialog_form( boolean loaiDialog, int row){
        boolean loai = loaiDialog;
        init_Dialog();
        
        JLabel SOHD = new JLabel("Số hóa đơn");
        JLabel NGHD = new JLabel("Ngày hóa đơn:");
        JLabel MANV = new JLabel("Mã nhân viên:");
        JLabel TRIGIA = new JLabel("Trị giá:");
        JLabel TINHTRANG = new JLabel("Tình trạng thanh toán:");
        JLabel MABAN = new JLabel("Mã bàn:");
    
        txt_SoHD = new JTextField();
        String StrTinhTrangThanhToan[] = { "Chưa thanh toán", "Đã thanh toán"};
        txt_TinhTrangThanhToan = new JComboBox(StrTinhTrangThanhToan);
        
        txt_MaNV = new JComboBox(); 
        ArrayList<String> StrMaNV = new ArrayList<String>(); 
        txt_MaNV = new JComboBox();
        Object[] arrMaNV = ChonMaNV(StrMaNV);
        for (int i=0; i <arrMaNV.length; i++){
            txt_MaNV.addItem(arrMaNV[i]);
        }
        txt_MaNV.setSelectedIndex(0);
        
        txt_MaBan = new JComboBox(); 
        ArrayList<String> StrMaBan = new ArrayList<String>(); 
        txt_MaBan = new JComboBox();
        Object[] arrMaBan = ChonMaBan(StrMaBan);
        for (int i=0; i <arrMaBan.length; i++){
            txt_MaBan.addItem(arrMaBan[i]);
        }
        txt_MaBan.setSelectedIndex(0);    
        
        txt_NgHD = new JTextField();
        DateChooser NgayHD_dateChooser = new DateChooser();
        NgayHD_dateChooser.setForeground(new java.awt.Color(167, 223, 255));
        NgayHD_dateChooser.setTextRefernce(txt_NgHD);
//        NgayHetHan_dateChooser.setForeground(new java.awt.Color(255, 184, 183));
        txt_TriGia = new JTextField();
        
        JPanel pane1 = new JPanel();
        pane1.setPreferredSize(new Dimension(600, 60));
        pane1.setLayout(new GridLayout(2, 2, 100, 3));
        pane1.setBackground(Color.white);
        pane1.add(SOHD);
        pane1.add(NGHD);
        pane1.add(txt_SoHD);
        pane1.add(txt_NgHD);
        
        JPanel pane2= new JPanel();
        pane2.setPreferredSize(new Dimension(600, 60));
        pane2.setLayout(new GridLayout(2, 2, 100, 3));
        pane2.setBackground(Color.white);
        pane2.add(MANV);
        pane2.add(TRIGIA);
        pane2.add(txt_MaNV);
        pane2.add(txt_TriGia);

        JPanel pane3 = new JPanel();
        pane3.setPreferredSize(new Dimension(600, 60));
        pane3.setLayout(new GridLayout(2, 2, 100, 3));
        pane3.setBackground(Color.white);        
        pane3.add(TINHTRANG);
        pane3.add(MABAN);
        pane3.add(txt_TinhTrangThanhToan);
        pane3.add(txt_MaBan);

        setText_currSOHD(row); 
        
        formHD_jDialog.getContentPane().add(pane1);
        formHD_jDialog.getContentPane().add(pane2);
        formHD_jDialog.getContentPane().add(pane3);
        
        JPanel pane_btn_DialogPN = new JPanel();
        pane_btn_DialogPN.setLayout(new FlowLayout(FlowLayout.RIGHT, 15,0));
        pane_btn_DialogPN.setPreferredSize(new Dimension(500, 80));
        pane_btn_DialogPN.setBorder(new EmptyBorder(50, 0, 0, 0));
        pane_btn_DialogPN.setBackground(Color.white);
        
        btn_XacNhan = new ButtonGradient();
        btn_XacNhan.setText("XÁC NHẬN");
        btn_XacNhan.setColor1(new Color(225,244,255));
        btn_XacNhan.setColor2(new Color(133,210,255));
        
        btn_cancel = new ButtonGradient();
        btn_cancel.setText("HỦY");
        btn_cancel.setColor1(new Color(255,231,231));
        btn_cancel.setColor2(new Color(255,130,145));
        
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formHD_jDialog.setVisible(false);
            }
        });
        pane_btn_DialogPN.add(btn_cancel);
        
        btn_XacNhan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                suaHD_jButtonActionPerformed(evt, row);
            }
        });
        pane_btn_DialogPN.add(btn_XacNhan);
        formHD_jDialog.getContentPane().add(pane_btn_DialogPN);
    }
    
    public Object[] ChonMaNV(ArrayList<String> StrMaNV){
        try{
            String sql = "SELECT MANV FROM NHANVIEN";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);
            boolean flag_Trung = false;
            while(res.next()){
                String MANV = res.getString("MANV");
                for(int i=0; i<StrMaNV.size(); i++)
                    if(StrMaNV.get(i).equals(MANV)) 
                        flag_Trung = true;
                
                if(!flag_Trung)
                    StrMaNV.add(MANV);
            }
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is"+ex);
        }
        Object[] arr = StrMaNV.toArray();
        return arr;
    }
    
    public Object[] ChonMaBan(ArrayList<String> StrMaBan){
        try{
            String sql = "SELECT MABAN FROM VITRI";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);
            boolean flag_Trung = false;
            while(res.next()){
                String MABAN = res.getString("MABAN");
                for(int i=0; i<StrMaBan.size(); i++)
                    if(StrMaBan.get(i).equals(MABAN)) 
                        flag_Trung = true;
                
                if(!flag_Trung)
                    StrMaBan.add(MABAN);
            }
        }
        catch(SQLException | HeadlessException ex){
            System.out.println("the error is"+ex);
        }
        Object[] arr = StrMaBan.toArray();
        return arr;
    }    
    
    private void SuaHoaDon_Dialog(int row) {
        Dialog_form(false, row);
        formHD_jDialog.pack();
        formHD_jDialog.setLocationRelativeTo(null);
        formHD_jDialog.setVisible(true);
    }
    private void setText_currSOHD(int row){
        DefaultTableModel model = (DefaultTableModel) table_HoaDon.getModel();
        Object value_SOHD = model.getValueAt(row, 0);
        System.out.println(value_SOHD);
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT SOHD, "
                    + "TO_CHAR(NGHD, 'DD-MM-YYYY') as NGHD, MANV, TRIGIA, TINHTRANGTHANHTOAN, MABAN "
                    + "FROM HOADON WHERE SOHD = '" + value_SOHD + "'";
            ResultSet res = statement.executeQuery(sql);
            System.out.println(value_SOHD + " thanh cong");

            while (res.next()) {
                String SOHD = res.getString("SOHD");
                String NGHD = res.getString("NGHD");
                String MANV = res.getString("MANV");
                String TRIGIA = res.getString("TRIGIA");
                String sql_TINHTRANGTHANHTOAN = res.getString("TINHTRANGTHANHTOAN");
                String TINHTRANGTHANHTOAN;
                if(sql_TINHTRANGTHANHTOAN.equals("0"))
                    TINHTRANGTHANHTOAN = "Chưa thanh toán";
                else
                    TINHTRANGTHANHTOAN = "Đã thanh toán";
                String MABAN = res.getString("MABAN");

                txt_SoHD.setText(SOHD);
                txt_SoHD.setForeground(new Color(134, 134, 134));
                txt_SoHD.setEditable(false);

                txt_TriGia.setText(TRIGIA);
                txt_TriGia.setForeground(new Color(134, 134, 134));
                txt_TriGia.setEditable(false);
                
                txt_NgHD.setText(NGHD);
                txt_MaNV.setSelectedItem(MANV);
                txt_MaBan.setSelectedItem(MABAN);
                txt_TinhTrangThanhToan.setSelectedItem(TINHTRANGTHANHTOAN);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void suaHD_jButtonActionPerformed(ActionEvent evt, int row){
        DefaultTableModel model = (DefaultTableModel) table_HoaDon.getModel();
        
        String SOHD = txt_SoHD.getText();        
        String TRIGIA = txt_TriGia.getText();
        String NGHD = txt_NgHD.getText();
        Object MANV = txt_MaNV.getItemAt(txt_MaNV.getSelectedIndex());
        Object MABAN = txt_MaBan.getItemAt(txt_MaBan.getSelectedIndex());
        Object TINHTRANGTHANHTOAN = txt_TinhTrangThanhToan.getSelectedIndex();

        String MaBan = MABAN.toString();
        String SoBan = MaBan.substring(3);
        int So = Integer.parseInt(SoBan);
        String TenBan = "Bàn "+SoBan;
        
        //check xem bàn đang có hóa đơn chưa. nếu có ??? else ->
        if(KiemTraHDvaTTSDBan(MaBan, SOHD)) {
            try {
                if (kiemtrarangbuoc(SOHD, NGHD, MANV.toString())) {
                    Statement statement = connection.createStatement();
                    String sql = "UPDATE HOADON SET TRIGIA = '" + TRIGIA + "', NGHD = TO_DATE('" + NGHD + "', 'DD-MM-YYYY'), MANV = '" + MANV + "', MABAN = '" + MABAN + "', TINHTRANGTHANHTOAN = '" + TINHTRANGTHANHTOAN + "' WHERE SOHD = '" + SOHD + "'";
                    int res = statement.executeUpdate(sql);

                    if (TINHTRANGTHANHTOAN.toString().equals("0")) {
                        sql = "UPDATE VITRI SET TINHTRANGSD = 1 WHERE SOBAN = '" + SoBan + "'";
                        res = statement.executeUpdate(sql);
                    } else {
                        sql = "UPDATE VITRI SET TINHTRANGSD = 0 WHERE SOBAN = '" + SoBan + "'";
                        res = statement.executeUpdate(sql);
                    }
                    set_color_ban(btn_Ban.get(So - 1));
                    System.out.println(btn_Ban.get(So - 1).getText());

                    suaHD_jOptionPane.setVisible(true);
                    suaHD_jOptionPane.showMessageDialog(formHD_jDialog, "Cập nhật hóa đơn thành công!");
                    formHD_jDialog.setVisible(false);

                    model.setValueAt(NGHD, row, 1);
                    model.setValueAt(TRIGIA, row, 2);
                    model.setValueAt(TINHTRANGTHANHTOAN, row, 3);

                    System.out.println("Update HD thanh cong");
                }
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            suaHD_jOptionPane.setVisible(true);
            suaHD_jOptionPane.showMessageDialog(formHD_jDialog, "Không thể cập nhật tình trạng thanh toán!");
        }       
    }

    private boolean KiemTraHDvaTTSDBan(String MABAN, String SOHD) {
        boolean flag_SD = false;
        boolean flag_currSOHD = false;
        
        try {
            Statement statement_tinhtrangSDban = connection.createStatement();
            String sql_tinhtrangSDban = "SELECT TINHTRANGSD FROM VITRI WHERE MABAN = '" + MABAN + "' AND TINHTRANGSD = 1";
            ResultSet res_tinhtrangSDban = statement_tinhtrangSDban.executeQuery(sql_tinhtrangSDban);
            while (res_tinhtrangSDban.next()) {
                flag_SD = true;
            }

            Statement statement_currSOHD = connection.createStatement();
            String sql_currSOHD = "SELECT SOHD FROM HOADON WHERE MABAN = '" + MABAN + "' AND TINHTRANGTHANHTOAN = 0";
            ResultSet res_currSOHD = statement_currSOHD.executeQuery(sql_currSOHD);
            while (res_currSOHD.next()) {
                String curr_SOHD = res_currSOHD.getString("SOHD");
                if(curr_SOHD.equals(SOHD))
                    flag_currSOHD = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!flag_SD) return true;
        
        if (flag_SD && flag_currSOHD) 
            return true;
        else 
            return false;
    }
    
    
    private void init_ThucDon(){
        pane_bg_ThucDon.setBackground(new java.awt.Color(255, 255, 255));
        pane_bg_ThucDon.setPreferredSize(new java.awt.Dimension(500, 485));
        
        pane_Search_ThucDon = new JPanel();
        pane_Search_ThucDon.setBackground(Color.white);
        pane_Search_ThucDon.setPreferredSize(new Dimension(800, 70)); 
        
        label_LoaiMon_list = new ArrayList<JLabel>();
        btn_MonAn_list = new ArrayList<ArrayList<JButton>>();        
        
        pane_search_ThucDon();
        pane_bg_ThucDon.add(pane_Search_ThucDon);
        add_ThucDon();
        pane_bg_ThucDon.add(Scrollpane_ThucDon);
    }
    
    public void pane_search_ThucDon(){
        JPanel pane_search_bar = new JPanel();
        pane_search_bar.setBackground(Color.white );
        pane_search_bar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        txtSearch_ThucDon = new JTextField(" Search");
        txtSearch_ThucDon.setPreferredSize(new Dimension(50, 31)); 
        txtSearch_ThucDon.setColumns(25);     
        txtSearch_ThucDon.setForeground(Color.GRAY);
        txtSearch_ThucDon.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtSearch_ThucDon.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                txtSearch_ThucDon.setText("");
                txtSearch_ThucDon.setFont(new Font("SansSerif", Font.PLAIN, 14));
                txtSearch_ThucDon.setForeground(Color.BLACK);
            }
            public void focusLost(FocusEvent e) {
            }
        });
        
        btn_Search_ThucDon = new JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/search1.png"));
        Image image = icon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        btn_Search_ThucDon.setIcon(newIcon);
        btn_Search_ThucDon.setBackground(Color.white);
        btn_Search_ThucDon.setPreferredSize(new Dimension(40, 31)); 
        btn_Search_ThucDon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        pane_search_bar.add(txtSearch_ThucDon);
        pane_search_bar.add(btn_Search_ThucDon);
        
        String colname_NV[] = { "MAMON", "TENMON", "MALMA", "DONGIA"};
        boxSearch_ThucDon = new JComboBox(colname_NV);
        boxSearch_ThucDon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boxSearch_ThucDon.setSelectedItem("TENMON");
        boxSearch_ThucDon.setFont(new Font("SansSerif", Font.BOLD, 14));
        boxSearch_ThucDon.setBackground(Color.white);
        boxSearch_ThucDon.setPreferredSize(new Dimension(130, 35)); 
        
        pane_search_bar.setBorder(txtSearch_ThucDon.getBorder());
        txtSearch_ThucDon.setBorder(null);
        btn_Search_ThucDon.setBorder(null);
        
        pane_Search_ThucDon.add(pane_search_bar);
        pane_Search_ThucDon.add(boxSearch_ThucDon);
        pane_Search_ThucDon.setBorder(new EmptyBorder(10, 0, 0, 0));
        
        Search_ThucDon();
    }
    
    public void Search_ThucDon(){
        btn_Search_ThucDon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean flag = false;
                System.out.println("Da bam search thuc don");
                try{
                    String sql = "SELECT * FROM MONAN WHERE "
                    + boxSearch_ThucDon.getSelectedItem().toString() + " LIKE '%" + txtSearch_ThucDon.getText() + "%'";
                    Statement statement = connection.createStatement();
                    ResultSet res = statement.executeQuery(sql);
                    
                    //REMOVE ALL VÀ ADD MÓN VÀO
                    String text = txtSearch_ThucDon.getText();
                    if((!(text.equals(" Search"))) || (!(text.equals("")))){
                        for(int i=0;i<label_LoaiMon_list.size();i++){ 
                            label_LoaiMon_list.get(i).setVisible(false);
                            for(int j=0;j<btn_MonAn_list.get(i).size();j++){
                                btn_MonAn_list.get(i).get(j).setVisible(false);
                            }
                        }
                        while (res.next()) {
                            flag =true;
                            String MAMON = res.getString("MAMON");
                            String TENMON = res.getString("TENMON");
                            String MALMA = res.getString("MALMA");
                            String DONGIA = res.getString("DONGIA");
                            search_ThucDon(TENMON);
                        }
                    }

                }
                catch(SQLException | HeadlessException ex){
                    System.out.println("the error is" + ex);
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
    
    public void add_ThucDon(){
        Scrollpane_ThucDon= new JScrollPane();
        
        pane_ThucDon= new JPanel();
        pane_ThucDon.setLayout(new WrapLayout(FlowLayout.LEFT));
        pane_ThucDon.setSize(new Dimension(450, 1));
        pane_ThucDon.setBackground(Color.white);
        
        try {
            Statement statement = connection.createStatement();
            String sql_LOAIMONAN = "SELECT * FROM LOAIMONAN";
            ResultSet res_LOAIMONAN = statement.executeQuery(sql_LOAIMONAN);
            while (res_LOAIMONAN.next()) {
                String MALMA = res_LOAIMONAN.getString("MALMA");
                String TENLMA = res_LOAIMONAN.getString("TENLMA");
                int TINHTRANG = res_LOAIMONAN.getInt("TINHTRANG");
                
                if(TINHTRANG == 1){
                    JLabel label_temp = new JLabel(TENLMA);
                    label_LoaiMon_list.add(label_temp);

                    ArrayList<JButton> temp_btn_list = new ArrayList<JButton>();

                    Statement statement_MONAN = connection.createStatement();
                    String sql_MONAN = "SELECT * FROM MONAN WHERE MALMA = '" + MALMA + "'";
                    ResultSet res_MONAN = statement_MONAN.executeQuery(sql_MONAN);
                    while (res_MONAN.next()) {
                        String MAMON = res_MONAN.getString("MAMON");
                        String TENMON = res_MONAN.getString("TENMON");
                        String DONGIA = res_MONAN.getString("DONGIA");
                        String IMAGE = res_MONAN.getString("LINK_IMAGE");
                        int TINHTRANGMON = res_MONAN.getInt("TINHTRANG");

                        if(TINHTRANGMON == 1){
                            JButton btn_temp = new JButton(TENMON);
                            btn_temp.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            btn_temp.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    ChonMonAn(MAMON, DONGIA);
                                }
                            });
                            temp_btn_list.add(btn_temp);
                        }
                    }
                    btn_MonAn_list.add(temp_btn_list);
                }
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println("the error is" + ex);
        }

        for(int i=0;i<label_LoaiMon_list.size();i++){
            label_LoaiMon_list.get(i).setPreferredSize(new Dimension(430, 50));
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
                btn_MonAn_list.get(i).get(j).setPreferredSize(new Dimension(130, 130));
                pane_ThucDon.add(btn_MonAn_list.get(i).get(j));
                System.out.println(btn_MonAn_list.get(i).get(j).getText());    
            }
            System.out.println("-----------------------------------------");    
        }
        
        Scrollpane_ThucDon.setViewportView(pane_ThucDon);
        Scrollpane_ThucDon.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scrollpane_ThucDon.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Scrollpane_ThucDon.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        Scrollpane_ThucDon.setPreferredSize(new Dimension(450, 380));
    }
    
    private void DatMon(String SOHD){
        for(int row=0; row<table_CTHD.getRowCount(); row++){
            Object mamon = table_CTHD.getValueAt(row, 0);
            Object dongia = table_CTHD.getValueAt(row, 1);
            Object sl = table_CTHD.getValueAt(row, 2);
            try {
                Statement statement_INSERT = connection.createStatement();
                String sql_INSERT = "INSERT INTO CTHD VALUES (  '" + SOHD + "' , '" + mamon + "', " + sl + ", " + dongia + " )";
                int res_INSERT = statement_INSERT.executeUpdate(sql_INSERT);
                System.out.println("Insert thanh cong " + SOHD);
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println(mamon);
        }
    }
    
    private void ChonMonAn(String MAMON, String DONGIA){
        DefaultTableModel tbmodel = (DefaultTableModel) table_CTHD.getModel();
        boolean flagTonTai = false;
        JOptionPane ChonMon_joption= new JOptionPane();
        
        for(int row=0; row<table_CTHD.getRowCount(); row++){
            Object mamon = table_CTHD.getValueAt(row, 0);
            String Strsl = table_CTHD.getValueAt(row, 2).toString();
            int sl = Integer.parseInt(Strsl);
            String StrMaMon = mamon.toString();
            if(StrMaMon.equals(MAMON)){
                flagTonTai = true;
                sl = sl+1;
                tbmodel.setValueAt(sl, row, 2);
                break;
            }
        }
        if(!flagTonTai){        
            Object new_tbdata[] = {MAMON, DONGIA, 1};
            tbmodel.addRow(new_tbdata);
        }
        
        Tien = Tien + Integer.parseInt(DONGIA);
        label_SetTongTien.setText(""+Tien);
        System.out.println("Tien: "+Tien);
        
        ChonMon_joption.setVisible(true);
        ChonMon_joption.showMessageDialog(pane_bg_ThucDon, "Chọn món ăn thành công!");
    }
    
    private void InHoaDon(){
        PDFitext pdf = new PDFitext(connection, table_CTHD, MANV, label_SetSoHD.getText());
        option_InHD = new JOptionPane();
        option_InHD.setVisible(true);
        option_InHD.showMessageDialog(pane_HoaDon, "Đã in hóa đơn!");
    }
}

