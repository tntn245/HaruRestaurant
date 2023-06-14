/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import static QuanLyNhaHangHaru.QuanLyNhaHangHaru.frameKH;
import static QuanLyNhaHangHaru.QuanLyNhaHangHaru.frameQL;
import connection.ExcuteSQLStatement;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.ArrayList;
import model.DishesButton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;
import java.text.NumberFormat;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
/**
 *
 * @author jiang
 */
public final class QuanlyThucDon extends javax.swing.JPanel {

//    private final ArrayList<DishesButton> listMonAn = new ArrayList<>();
    public static int trangThaiChonXoaOrSua = 0; // 0:Huy;  1:Sua 
    private final ArrayList<String> nguyenLieuDaChon = new ArrayList<>();
    public static int themOrXoaNguyenLieu = 0; //0: Khong co j; 1:Xoa; 2:Them
    public static ArrayList<String> nguyenLieuSua = new ArrayList<>();
    public static ArrayList<JPanel> loaiMonAnJPanels = new ArrayList<>();
    private Connection connection;
    /**
     * Creates new form QuanLyThucDonJPanel
     */
    public QuanlyThucDon(Connection connection) {
        this.connection = connection;
        initComponents();
        showMonAnTuDataBase();
    }
    
    private void initComponents() {
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        
        suaTinhTrangMonAn_jLabel = new javax.swing.JLabel();
        tinhTrangMonAn_jComboBox = new javax.swing.JComboBox<>();
        suatinhTrangMonAn_jComboBox = new javax.swing.JComboBox<>();
        tinhtrangLoaiMonAn_jComboBox = new javax.swing.JComboBox<>();
        tinhtrangLoaiMonAn_jLabel = new javax.swing.JLabel();
        suatinhtrangLoaiMonAn_jComboBox = new javax.swing.JComboBox<>();
        suatinhtrangLoaiMonAn_jLabel = new javax.swing.JLabel();
        suaTinhTrangMonAn_jLabel.setText("Tình trạng:");
        tinhTrangMonAn_jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngừng sử dụng", "Sử dụng" }));
        suatinhTrangMonAn_jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngừng sử dụng", "Sử dụng" }));
        tinhTrangMonAn_jComboBox.setSelectedIndex(1);
        suatinhTrangMonAn_jComboBox.setSelectedIndex(1);
        
        themMonAn_jDialog = new javax.swing.JDialog();
        themMaMonaAn_jLabel = new javax.swing.JLabel();
        themMaMonAn_jTextField = new javax.swing.JTextField();
        themAnhMonAnTuFile_jButton = new javax.swing.JButton();
        themTenMonAn_jTextField = new javax.swing.JTextField();
        themTenMon_jLabel = new javax.swing.JLabel();
        confirmThemMonAn_jButton = new javax.swing.JButton();
        themLoaiMonAn_jLabel = new javax.swing.JLabel();
        themLoaiMonAn_jComboBox = new javax.swing.JComboBox<>();
        themAnhMonAn_jLabel = new javax.swing.JLabel();
        cancel_themMonAn_jButton = new javax.swing.JButton();
        themPathAnhMonAn_jTextField = new javax.swing.JTextField();
        themDonGia_jLabel = new javax.swing.JLabel();
        themDonGia_jTextField = new javax.swing.JFormattedTextField(formatter);
        jLabel2 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        themNguyenLieu_jList = new javax.swing.JList<>();
        confirmThemNguyenLieu_jButton = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        themShowNguyenLieuDaChon_jTextArea = new javax.swing.JTextArea();
        confirmThemMonAn_jOptionPane = new javax.swing.JOptionPane();
        themMonAn_jFileChooser = new javax.swing.JFileChooser();
        xoa_suaMonAn_jDialog = new javax.swing.JDialog();
        suaMaMonAn_jLabel = new javax.swing.JLabel();
        suaMaMonAn_jTextField = new javax.swing.JTextField();
        suaTenMon_jLabel = new javax.swing.JLabel();
        suaTenMonAn_jTextField = new javax.swing.JTextField();
        suaLoaiMonAn_jLabel = new javax.swing.JLabel();
        suaLoaiMonAn_jComboBox = new javax.swing.JComboBox<>();
        suaAnhMonAn_jLabel = new javax.swing.JLabel();
        suaPathAnhMonAn_jTextField = new javax.swing.JTextField();
        suaAnhMonAnTuFile_jButton = new javax.swing.JButton();
        confirmSuaMonAn_jButton = new javax.swing.JButton();
        cancel_xoa_suaMonAn_jButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        suaNguyenLieu_jList = new javax.swing.JList<>();
        suaDonGia_jLabel = new javax.swing.JLabel();
        suaDonGia_jTextField = new javax.swing.JFormattedTextField(formatter);
        suaNguyenLieu_jLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        suaShowNguyenLieu_jTextArea = new javax.swing.JTextArea();
        confirmSuaNguyenLieu_jButton = new javax.swing.JButton();
        confirmXoaNguyenLieu_jButton = new javax.swing.JButton();
        xoa_suaMonAn_jOptionPane = new javax.swing.JOptionPane();
        themLoaiMonAn_jDialog = new javax.swing.JDialog();
        themTenLoaiMonAn_jLabel = new javax.swing.JLabel();
        themTenLoaiMonAn_jTextField = new javax.swing.JTextField();
        themMoTaLoaiMonAn_jLabel = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        themMoTaLoaiMonAn_jTextArea = new javax.swing.JTextArea();
        confirmThemLoaiMonAn_jButton = new javax.swing.JButton();
        cancelThemLoaiMonAn_jButton = new javax.swing.JButton();
        suaLoaiMonAn_jDialog = new javax.swing.JDialog();
        suaChonLoaiMonAn_jLabel = new javax.swing.JLabel();
        suaChonLoaiMonAn_jComboBox = new javax.swing.JComboBox<>();
        chonMonAnCanSua_jButton = new javax.swing.JButton();
        tenMoiLoaiMonAn_jLabel = new javax.swing.JLabel();
        tenMoiLoaiMonAn_jTextField = new javax.swing.JTextField();
        tinhtrangLoaiMonAn_jLabel = new javax.swing.JLabel();
        tinhtrangLoaiMonAn_jComboBox = new javax.swing.JComboBox();
        suatinhtrangLoaiMonAn_jLabel = new javax.swing.JLabel();
        suatinhtrangLoaiMonAn_jComboBox = new javax.swing.JComboBox();
        moTaMoiLoaiMonAn_jLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        moTaMoiLoaiMonAn_jTextArea = new javax.swing.JTextArea();
        cancelSuaLoaiMonAn_jButton = new javax.swing.JButton();
        comfirmSuaLoaiMonAn_jButton = new javax.swing.JButton();
        quanLyThucDon_jPanel = new javax.swing.JPanel();
        quanLyThucDon_pane_bg = new javax.swing.JPanel();
        searchMonAnTheo_jComboBox = new javax.swing.JComboBox<>();
        themMonAn_jButton = new ButtonGradient();
        searchMonAn_jPanel = new javax.swing.JPanel();
        searchMonAn_jTextField = new javax.swing.JTextField();
        searchMonAn_jButton1 = new javax.swing.JButton();
        themLoaiMonAn_jButton = new ButtonGradient();
        suaLoaiMonAn_jButton = new ButtonGradient();
        showMonAn_jTabbedPane = new javax.swing.JTabbedPane();

        themMonAn_jDialog.setTitle("Thêm món ăn");
        themMonAn_jDialog.setModal(true);
        themMonAn_jDialog.setResizable(false);

        themMaMonaAn_jLabel.setText("Mã món ăn");

        themMaMonAn_jTextField.setEnabled(false);

        themAnhMonAnTuFile_jButton.setText("Browse");
        themAnhMonAnTuFile_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themAnhMonAnTuFile_jButtonActionPerformed(evt);
            }
        });

        themTenMonAn_jTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themTenMonAn_jTextFieldActionPerformed(evt);
            }
        });

        themTenMon_jLabel.setText("Tên món");

        confirmThemMonAn_jButton.setText("Xác Nhận");
        confirmThemMonAn_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmThemMonAn_jButtonActionPerformed(evt);
            }
        });

        themLoaiMonAn_jLabel.setText("Loại món ăn");

        ArrayList<String> StrTenLMA = new ArrayList<String>();
        String[] arrTenLMA = chonThongTinLoaiMonAn(StrTenLMA);
        for (int i=0; i <arrTenLMA.length; i++){
            themLoaiMonAn_jComboBox.addItem(arrTenLMA[i]);
        }

        themAnhMonAn_jLabel.setText("Chọn ảnh món ăn");

        cancel_themMonAn_jButton.setText("Hủy");
        cancel_themMonAn_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_themMonAn_jButtonActionPerformed(evt);
            }
        });

        themPathAnhMonAn_jTextField.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        themPathAnhMonAn_jTextField.setText("Path...");
        themPathAnhMonAn_jTextField.setEnabled(false);

        themDonGia_jLabel.setText("Đơn giá (VNĐ)");

        jLabel2.setText("Nguyên liệu");

        ArrayList<String> StrTenNL = new ArrayList<String>();
        String[] arrTenNL = chonTenNguyenLieu(StrTenNL);
        themNguyenLieu_jList = new javax.swing.JList(arrTenNL);
        themNguyenLieu_jList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(themNguyenLieu_jList);

        confirmThemNguyenLieu_jButton.setText("Thêm nguyên liệu");
        confirmThemNguyenLieu_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmThemNguyenLieu_jButtonActionPerformed(evt);
            }
        });

        themShowNguyenLieuDaChon_jTextArea.setColumns(20);
        themShowNguyenLieuDaChon_jTextArea.setRows(5);
        themShowNguyenLieuDaChon_jTextArea.setFocusable(false);
        jScrollPane8.setViewportView(themShowNguyenLieuDaChon_jTextArea);

        javax.swing.GroupLayout themMonAn_jDialogLayout = new javax.swing.GroupLayout(themMonAn_jDialog.getContentPane());
        themMonAn_jDialog.getContentPane().setLayout(themMonAn_jDialogLayout);
        themMonAn_jDialog.getContentPane().setBackground(Color.white);
        themMonAn_jDialogLayout.setHorizontalGroup(
            themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(themMonAn_jDialogLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(themAnhMonAn_jLabel)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, themMonAn_jDialogLayout.createSequentialGroup()
                            .addComponent(cancel_themMonAn_jButton)
                            .addGap(107, 107, 107))
                        .addGroup(themMonAn_jDialogLayout.createSequentialGroup()
                            .addComponent(themPathAnhMonAn_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(themAnhMonAnTuFile_jButton))
                        .addGroup(themMonAn_jDialogLayout.createSequentialGroup()
                            .addGroup(themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(themLoaiMonAn_jComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(themMaMonaAn_jLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(themLoaiMonAn_jLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(themMaMonAn_jTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tinhTrangMonAn_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(themTenMon_jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(themTenMonAn_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(suaTinhTrangMonAn_jLabel))))
                    .addComponent(themDonGia_jLabel)
                    .addComponent(jLabel2)
                    .addGroup(themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, themMonAn_jDialogLayout.createSequentialGroup()
                            .addGroup(themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(confirmThemNguyenLieu_jButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane8))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(themDonGia_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(confirmThemMonAn_jButton))))
                                .addContainerGap(38, Short.MAX_VALUE))
        );
        themMonAn_jDialogLayout.setVerticalGroup(
                themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(themMonAn_jDialogLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(themMaMonaAn_jLabel)
                                        .addComponent(themTenMon_jLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(themMaMonAn_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(themTenMonAn_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(themLoaiMonAn_jLabel)
                                        .addComponent(suaTinhTrangMonAn_jLabel))
                                .addGap(12, 12, 12)
                                .addGroup(themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(themLoaiMonAn_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tinhTrangMonAn_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(themAnhMonAn_jLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(themPathAnhMonAn_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(themAnhMonAnTuFile_jButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(themDonGia_jLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(themDonGia_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(themMonAn_jDialogLayout.createSequentialGroup()
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(confirmThemNguyenLieu_jButton))
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                .addGap(17, 17, 17)
                                .addGroup(themMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancel_themMonAn_jButton)
                                        .addComponent(confirmThemMonAn_jButton))
                                .addGap(15, 15, 15))
        );

        themMonAn_jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.png", "png"));
        themMonAn_jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.jpg", "jpg"));

        xoa_suaMonAn_jDialog.setTitle("Sửa món ăn");
        xoa_suaMonAn_jDialog.setModal(true);
        xoa_suaMonAn_jDialog.setResizable(false);

        suaMaMonAn_jLabel.setText("Mã món ăn");

        suaMaMonAn_jTextField.setEnabled(false);

        suaTenMon_jLabel.setText("Tên món");

        suaLoaiMonAn_jLabel.setText("Loại món ăn");

        suaLoaiMonAn_jComboBox.setModel(themLoaiMonAn_jComboBox.getModel());

        suaAnhMonAn_jLabel.setText("Chọn ảnh món ăn");

        suaPathAnhMonAn_jTextField.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        suaPathAnhMonAn_jTextField.setText("Path...");
        suaPathAnhMonAn_jTextField.setEnabled(false);

        suaAnhMonAnTuFile_jButton.setText("Browse");
        suaAnhMonAnTuFile_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaAnhMonAnTuFile_jButtonActionPerformed(evt);
            }
        });

        confirmSuaMonAn_jButton.setText("Sửa");
        confirmSuaMonAn_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmSuaMonAn_jButtonActionPerformed(evt);
                frameQL.GUIKH.add_ThucDon();
                frameKH.GUIKH.add_ThucDon();
            }
        });

        cancel_xoa_suaMonAn_jButton.setText("Hủy");
        cancel_xoa_suaMonAn_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_xoa_suaMonAn_jButtonActionPerformed(evt);
            }
        });

        suaNguyenLieu_jList.setModel(themNguyenLieu_jList.getModel());
        jScrollPane1.setViewportView(suaNguyenLieu_jList);

        suaDonGia_jLabel.setText("Đơn giá (VNĐ)");

        suaNguyenLieu_jLabel.setText("Nguyên liệu");

        suaShowNguyenLieu_jTextArea.setEditable(false);
        suaShowNguyenLieu_jTextArea.setColumns(20);
        suaShowNguyenLieu_jTextArea.setRows(5);
        jScrollPane2.setViewportView(suaShowNguyenLieu_jTextArea);

        confirmSuaNguyenLieu_jButton.setText("Thêm");
        confirmSuaNguyenLieu_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmSuaNguyenLieu_jButtonActionPerformed(evt);
            }
        });

        confirmXoaNguyenLieu_jButton.setText("Xóa");
        confirmXoaNguyenLieu_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmXoaNguyenLieu_jButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout xoa_suaMonAn_jDialogLayout = new javax.swing.GroupLayout(xoa_suaMonAn_jDialog.getContentPane());
        xoa_suaMonAn_jDialog.getContentPane().setLayout(xoa_suaMonAn_jDialogLayout);
        xoa_suaMonAn_jDialog.getContentPane().setBackground(Color.white);
        xoa_suaMonAn_jDialogLayout.setHorizontalGroup(
            xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xoa_suaMonAn_jDialogLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(xoa_suaMonAn_jDialogLayout.createSequentialGroup()
                        .addGroup(xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(suaNguyenLieu_jLabel)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(xoa_suaMonAn_jDialogLayout.createSequentialGroup()
                                .addComponent(confirmXoaNguyenLieu_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmSuaNguyenLieu_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, xoa_suaMonAn_jDialogLayout.createSequentialGroup()
                                .addComponent(cancel_xoa_suaMonAn_jButton)
                                .addGap(26, 26, 26)
                                .addComponent(confirmSuaMonAn_jButton))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(suaAnhMonAn_jLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(suaDonGia_jLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(suaDonGia_jTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, xoa_suaMonAn_jDialogLayout.createSequentialGroup()
                        .addComponent(suaPathAnhMonAn_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(suaAnhMonAnTuFile_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, xoa_suaMonAn_jDialogLayout.createSequentialGroup()
                        .addGroup(xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(suaLoaiMonAn_jComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(suaMaMonAn_jTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(suaMaMonAn_jLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(suaLoaiMonAn_jLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(suatinhTrangMonAn_jComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(suaTenMonAn_jTextField)
                            .addGroup(xoa_suaMonAn_jDialogLayout.createSequentialGroup()
                                .addGroup(xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(suaTenMon_jLabel)
                                    .addComponent(suaTinhTrangMonAn_jLabel))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        xoa_suaMonAn_jDialogLayout.setVerticalGroup(
            xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xoa_suaMonAn_jDialogLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(xoa_suaMonAn_jDialogLayout.createSequentialGroup()
                        .addGroup(xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suaMaMonAn_jLabel)
                            .addComponent(suaTenMon_jLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suaMaMonAn_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(suaTenMonAn_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(suaLoaiMonAn_jLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(suaLoaiMonAn_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(xoa_suaMonAn_jDialogLayout.createSequentialGroup()
                        .addComponent(suaTinhTrangMonAn_jLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(suatinhTrangMonAn_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(suaAnhMonAn_jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(suaAnhMonAnTuFile_jButton)
                    .addComponent(suaPathAnhMonAn_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(suaDonGia_jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(suaDonGia_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(suaNguyenLieu_jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(xoa_suaMonAn_jDialogLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(confirmSuaNguyenLieu_jButton)
                            .addComponent(confirmXoaNguyenLieu_jButton)))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(xoa_suaMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmSuaMonAn_jButton)
                    .addComponent(cancel_xoa_suaMonAn_jButton))
                .addGap(20, 20, 20))
        );

        xoa_suaMonAn_jOptionPane.setMessageType(2);
        xoa_suaMonAn_jOptionPane.setOptionType(0);

        themLoaiMonAn_jDialog.setTitle("Thêm loại món ăn");
        themLoaiMonAn_jDialog.setResizable(false);

        themTenLoaiMonAn_jLabel.setText("Tên loại món ăn");

        themMoTaLoaiMonAn_jLabel.setText("Mô tả");

        themMoTaLoaiMonAn_jTextArea.setColumns(20);
        themMoTaLoaiMonAn_jTextArea.setRows(5);
        jScrollPane9.setViewportView(themMoTaLoaiMonAn_jTextArea);

        confirmThemLoaiMonAn_jButton.setText("Xác nhận");
        confirmThemLoaiMonAn_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmThemLoaiMonAn_jButtonActionPerformed(evt);
            }
        });

        cancelThemLoaiMonAn_jButton.setText("Hủy");
        cancelThemLoaiMonAn_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelThemLoaiMonAn_jButtonActionPerformed(evt);
            }
        });
        
        tinhtrangLoaiMonAn_jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngừng sử dụng", "Sử dụng" }));
        tinhtrangLoaiMonAn_jLabel.setText("Tình trạng");        
        tinhtrangLoaiMonAn_jComboBox.setSelectedIndex(1);
        
        javax.swing.GroupLayout themLoaiMonAn_jDialogLayout = new javax.swing.GroupLayout(themLoaiMonAn_jDialog.getContentPane());
        themLoaiMonAn_jDialog.getContentPane().setLayout(themLoaiMonAn_jDialogLayout);
        themLoaiMonAn_jDialog.getContentPane().setBackground(Color.white);
        themLoaiMonAn_jDialogLayout.setHorizontalGroup(
            themLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(themLoaiMonAn_jDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(themLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(themLoaiMonAn_jDialogLayout.createSequentialGroup()
                        .addGroup(themLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(themTenLoaiMonAn_jTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tinhtrangLoaiMonAn_jLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(themTenLoaiMonAn_jLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(themLoaiMonAn_jDialogLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(themLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(themLoaiMonAn_jDialogLayout.createSequentialGroup()
                                        .addComponent(cancelThemLoaiMonAn_jButton)
                                        .addGap(24, 24, 24)
                                        .addComponent(confirmThemLoaiMonAn_jButton))
                                    .addGroup(themLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tinhtrangLoaiMonAn_jComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(themMoTaLoaiMonAn_jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        themLoaiMonAn_jDialogLayout.setVerticalGroup(
            themLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(themLoaiMonAn_jDialogLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(themTenLoaiMonAn_jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(themTenLoaiMonAn_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tinhtrangLoaiMonAn_jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tinhtrangLoaiMonAn_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(themMoTaLoaiMonAn_jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(themLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmThemLoaiMonAn_jButton)
                    .addComponent(cancelThemLoaiMonAn_jButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        suaLoaiMonAn_jDialog.setResizable(false);

        suaChonLoaiMonAn_jLabel.setText("Chọn loại món ăn");

        suaChonLoaiMonAn_jComboBox.setModel(themLoaiMonAn_jComboBox.getModel());

        chonMonAnCanSua_jButton.setText("Chọn");
        chonMonAnCanSua_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chonMonAnCanSua_jButtonActionPerformed(evt);
            }
        });

        tenMoiLoaiMonAn_jLabel.setText("Tên mới cho loại món ăn");
        suatinhtrangLoaiMonAn_jLabel.setText("Tình trạng loại món ăn");
        moTaMoiLoaiMonAn_jLabel.setText("Mô tả mới của loại món ăn");

        suatinhtrangLoaiMonAn_jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngừng sử dụng", "Sử dụng" }));
        suatinhtrangLoaiMonAn_jComboBox.setSelectedIndex(1);
        
        moTaMoiLoaiMonAn_jTextArea.setColumns(20);
        moTaMoiLoaiMonAn_jTextArea.setRows(5);
        jScrollPane3.setViewportView(moTaMoiLoaiMonAn_jTextArea);

        cancelSuaLoaiMonAn_jButton.setText("Hủy");
        cancelSuaLoaiMonAn_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelSuaLoaiMonAn_jButtonActionPerformed(evt);
            }
        });

        comfirmSuaLoaiMonAn_jButton.setText("Sửa");
        comfirmSuaLoaiMonAn_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comfirmSuaLoaiMonAn_jButtonActionPerformed(evt);
                frameQL.GUIKH.add_ThucDon();
                frameKH.GUIKH.add_ThucDon();
            }
        });

        javax.swing.GroupLayout suaLoaiMonAn_jDialogLayout = new javax.swing.GroupLayout(suaLoaiMonAn_jDialog.getContentPane());
        suaLoaiMonAn_jDialog.getContentPane().setLayout(suaLoaiMonAn_jDialogLayout);
        suaLoaiMonAn_jDialog.getContentPane().setBackground(Color.white);
        suaLoaiMonAn_jDialogLayout.setHorizontalGroup(
            suaLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suaLoaiMonAn_jDialogLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(suaLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(suaLoaiMonAn_jDialogLayout.createSequentialGroup()
                        .addGroup(suaLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(suaChonLoaiMonAn_jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suaLoaiMonAn_jDialogLayout.createSequentialGroup()
                                .addGroup(suaLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(suaLoaiMonAn_jDialogLayout.createSequentialGroup()
                                        .addComponent(suaChonLoaiMonAn_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(chonMonAnCanSua_jButton, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                                    .addGroup(suaLoaiMonAn_jDialogLayout.createSequentialGroup()
                                        .addComponent(tenMoiLoaiMonAn_jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(suaLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(suatinhtrangLoaiMonAn_jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(suatinhtrangLoaiMonAn_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(11, 11, 11)))
                        .addContainerGap())
                    .addGroup(suaLoaiMonAn_jDialogLayout.createSequentialGroup()
                        .addGroup(suaLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(suaLoaiMonAn_jDialogLayout.createSequentialGroup()
                                .addComponent(cancelSuaLoaiMonAn_jButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comfirmSuaLoaiMonAn_jButton))
                            .addGroup(suaLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                .addComponent(moTaMoiLoaiMonAn_jLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tenMoiLoaiMonAn_jTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        suaLoaiMonAn_jDialogLayout.setVerticalGroup(
            suaLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suaLoaiMonAn_jDialogLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(suaChonLoaiMonAn_jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suaLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suaChonLoaiMonAn_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chonMonAnCanSua_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suaLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(suaLoaiMonAn_jDialogLayout.createSequentialGroup()
                        .addComponent(tenMoiLoaiMonAn_jLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tenMoiLoaiMonAn_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(suaLoaiMonAn_jDialogLayout.createSequentialGroup()
                        .addComponent(suatinhtrangLoaiMonAn_jLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(suatinhtrangLoaiMonAn_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(moTaMoiLoaiMonAn_jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(suaLoaiMonAn_jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comfirmSuaLoaiMonAn_jButton)
                    .addComponent(cancelSuaLoaiMonAn_jButton))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        quanLyThucDon_pane_bg.setBackground(Color.white);
        
        quanLyThucDon_jPanel.setLayout(new WrapLayout(FlowLayout.LEFT));
        quanLyThucDon_jPanel.setSize(new Dimension(640, 1));
        quanLyThucDon_jPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(250, 250, 250, 250));
//        quanLyThucDon_jPanel.setPreferredSize(new java.awt.Dimension(900, 600));
        quanLyThucDon_jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchMonAnTheo_jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo mã món ăn", "Theo tên món ăn" }));
        searchMonAnTheo_jComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchMonAnTheo_jComboBox.setBackground(Color.white);
        searchMonAnTheo_jComboBox.setPreferredSize(new Dimension(135, 35)); 
        quanLyThucDon_jPanel.add(searchMonAnTheo_jComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 20, 170, 35));
        
        javax.swing.ImageIcon themMonAnIcon = new javax.swing.ImageIcon(getClass().getResource("/image/add_dish.png"));
        java.awt.Image themMonAnImage = themMonAnIcon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledThemMonAnIcon = new javax.swing.ImageIcon(themMonAnImage);
        themMonAn_jButton.setIcon(scaledThemMonAnIcon);
        themMonAn_jButton.setText("THÊM MÓN");
        themMonAn_jButton.setFont(new Font(themMonAn_jButton.getFont().getName(),Font.BOLD,themMonAn_jButton.getFont().getSize()));
        themMonAn_jButton.setToolTipText("Thêm món ăn mới");
        themMonAn_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themMonAn_jButtonActionPerformed(evt);
            }
        });
        quanLyThucDon_jPanel.add(themMonAn_jButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 150, 35));

        //
        
        searchMonAn_jPanel = new JPanel();
        searchMonAn_jPanel.setBackground(Color.white );
//        searchMonAn_jPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        searchMonAn_jPanel.setLayout(new javax.swing.BoxLayout(searchMonAn_jPanel, javax.swing.BoxLayout.X_AXIS));

        searchMonAn_jTextField = new JTextField(" Search");
        searchMonAn_jTextField.setPreferredSize(new Dimension(50, 31)); 
        searchMonAn_jTextField.setColumns(35);     
        searchMonAn_jTextField.setForeground(Color.GRAY);
        searchMonAn_jTextField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                searchMonAn_jTextField.setText("");
                searchMonAn_jTextField.setForeground(Color.BLACK);
            }
            public void focusLost(FocusEvent e) {
            }
        });
        searchMonAn_jPanel.add(searchMonAn_jTextField);
        
        searchMonAn_jButton1 = new JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/search1.png"));
        Image image = icon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image); 
        searchMonAn_jButton1.setIcon(newIcon);
        searchMonAn_jButton1.setBackground(Color.white);
        searchMonAn_jButton1.setPreferredSize(new Dimension(31, 31)); 
        searchMonAn_jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchMonAn_jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMonAn_jButton1ActionPerformed(evt);
            }
        });
        
        searchMonAn_jPanel.add(searchMonAn_jButton1);
        searchMonAn_jPanel.setBorder(searchMonAn_jTextField.getBorder());
        searchMonAn_jTextField.setBorder(null);
        searchMonAn_jButton1.setBorder(null);

        quanLyThucDon_jPanel.add(searchMonAn_jPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 285, 35));

        themLoaiMonAn_jButton.setText("Thêm loại món ăn");
        themLoaiMonAn_jButton.setFont(new Font(themLoaiMonAn_jButton.getFont().getName(),Font.BOLD,themLoaiMonAn_jButton.getFont().getSize()));
        themLoaiMonAn_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themLoaiMonAn_jButtonActionPerformed(evt);
            }
        });
        quanLyThucDon_jPanel.add(themLoaiMonAn_jButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, -1, 35));

        suaLoaiMonAn_jButton.setText("Sửa loại món ăn");
        suaLoaiMonAn_jButton.setFont(new Font(suaLoaiMonAn_jButton.getFont().getName(),Font.BOLD,suaLoaiMonAn_jButton.getFont().getSize()));
        suaLoaiMonAn_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaLoaiMonAn_jButtonActionPerformed(evt);
            }
        });
        quanLyThucDon_jPanel.add(suaLoaiMonAn_jButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 70, 130, 35));
        quanLyThucDon_jPanel.add(showMonAn_jTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 120, 730, 410));
        quanLyThucDon_jPanel.setOpaque(true);
        quanLyThucDon_jPanel.setBackground(Color.white);
//        quanLyThucDon_pane_bg.add(quanLyThucDon_jPanel);

        DropShadowPane pane_shadow = new DropShadowPane(4, 0, 0, 0, Color.white, 50);
        pane_shadow.setPreferredSize(new Dimension(770, 550)); 
        pane_shadow.add(quanLyThucDon_jPanel);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setBackground(new Color(230, 235, 240));
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pane_shadow, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pane_shadow, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void showMonAnTuDataBase() {
        try {

            //Xet loai mon an va tao panel
            String sqlStatementTenLoaiMonAn = "select TENLMA from LOAIMONAN ORDER BY MALMA ASC";
            ResultSet tenLoaiMonAnResultSet = ExcuteSQLStatement.ExcuteSQLQuery(sqlStatementTenLoaiMonAn,connection);
            String tenLoaiMonAn;
            while (tenLoaiMonAnResultSet.next()) {
                tenLoaiMonAn = tenLoaiMonAnResultSet.getString("TENLMA");
                JScrollPane monAn_jScrollPane = new JScrollPane();
                monAn_jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                monAn_jScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                monAn_jScrollPane.setPreferredSize(new java.awt.Dimension(400,300));
                monAn_jScrollPane.setOpaque(false);
                JPanel monAn_jPanel = new javax.swing.JPanel();
                monAn_jPanel.setBackground(Color.white);
                monAn_jPanel.setName(tenLoaiMonAn);
                monAn_jPanel.setLayout(new WrapLayout(FlowLayout.LEFT));
                monAn_jPanel.setSize(new Dimension(400, 1));
                monAn_jScrollPane.setViewportView(monAn_jPanel);
                showMonAn_jTabbedPane.addTab(tenLoaiMonAn, monAn_jScrollPane);
                loaiMonAnJPanels.add(monAn_jPanel);
            }
            //Xet tung mon an va tao 1 button cho mon an do va gan vao panel
            String sqlStatement = "select MAMON, TENMON, DONGIA, m.TINHTRANG AS TINHTRANG, LINK_IMAGE, l.TENLMA AS TENLMA from monan m join loaimonan l on m.MALMA = l.MALMA";
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            ResultSet monAnResultSet = statement.executeQuery();
            while (monAnResultSet.next()) {
                //Lay ten nguyen lieu cua mon an
                String maMonAn = monAnResultSet.getString("MAMON");
                String sqlStatementTenNguyenLieu = "select K.TENNL from CHEBIEN C JOIN KHONGUYENLIEU K ON C.MANL = K.MANL  where MAMON = '" + maMonAn + "'";
                PreparedStatement statement_SELECT = connection.prepareStatement(sqlStatementTenNguyenLieu);
                ResultSet tenNguyenLieuResultSet = statement_SELECT.executeQuery();
                while (tenNguyenLieuResultSet.next()) {
                    String tenNguyenLieu = tenNguyenLieuResultSet.getString("TENNL");
                    nguyenLieuDaChon.add(tenNguyenLieu);
                }
                //Lay link anh, ten mon, don gia
                String link_image = monAnResultSet.getString("LINK_IMAGE");
                String tenMon = monAnResultSet.getString("TENMON");
                int donGia = monAnResultSet.getInt("DONGIA");
                int tinhtrang = monAnResultSet.getInt("TINHTRANG");
                //Lay ma loai mon an (de lay ten mon an)
                Object tenloaiMonAn = monAnResultSet.getString("TENLMA");
                DishesButton newDishesButton = new DishesButton(link_image, tenMon, tenloaiMonAn, maMonAn, donGia, tinhtrang, nguyenLieuDaChon, 90, 80);
                newDishesButton.setPreferredSize(new Dimension(150, 150));
                newDishesButton.setBackground(Color.white);
                nguyenLieuDaChon.clear();
                for (JPanel loaiMonAnJPanel : loaiMonAnJPanels) {
                    if (newDishesButton.getTenLoaiMonAn().equals(loaiMonAnJPanel.getName())) {
                        loaiMonAnJPanel.add(newDishesButton);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[] chonThongTinLoaiMonAn(ArrayList<String> StrTenLMA) {
        try {
            String sql = "SELECT TENLMA FROM LOAIMONAN ORDER BY MALMA ASC";
            ResultSet res = ExcuteSQLStatement.ExcuteSQLQuery(sql,connection);
            boolean flag_Trung = false;
            while (res.next()) {
                String TENLMA = res.getString("TENLMA");
                for (int i = 0; i < StrTenLMA.size(); i++) //CHECK TRÙNG TÊN LMA
                {
                    if (StrTenLMA.get(i).equals(TENLMA)) // NẾU TRÙNG THÌ FLAG = TRUE -> BỎ QUA, KHÔNG ADD NỮA
                    {
                        flag_Trung = true;
                        break;
                    }
                }

                if (!flag_Trung) // NẾU KHÔNG TRÙNG THÌ ADD
                {
                    StrTenLMA.add(TENLMA);
                }
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println("the error is" + ex);
        }
        Object[] arr = StrTenLMA.toArray();
        String[] str = Arrays.copyOf(arr, arr.length, String[].class);
        return str;
    }

    public String[] chonTenNguyenLieu(ArrayList<String> StrTenNL) {
        try {
            String sql = "SELECT TENNL FROM KHONGUYENLIEU ORDER BY MANL ASC";
            ResultSet res = ExcuteSQLStatement.ExcuteSQLQuery(sql,connection);
            boolean flag_Trung = false;
            while (res.next()) {
                String TENNL = res.getString("TENNL");
                for (int i = 0; i < StrTenNL.size(); i++) //CHECK TRÙNG TÊN LMA
                {
                    if (StrTenNL.get(i).equals(TENNL)) // NẾU TRÙNG THÌ FLAG = TRUE -> BỎ QUA, KHÔNG ADD NỮA
                    {
                        flag_Trung = true;
                        break;
                    }
                }

                if (!flag_Trung) // NẾU KHÔNG TRÙNG THÌ ADD
                {
                    StrTenNL.add(TENNL);
                }
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println("the error is" + ex);
        }
        Object[] arr = StrTenNL.toArray();
        String[] str = Arrays.copyOf(arr, arr.length, String[].class);
        return str;
    }

    public void setThemMonAnJDialogVeTrangThaiBanDau() {
        themMaMonAn_jTextField.setText("");
        themTenMonAn_jTextField.setText("");
        themPathAnhMonAn_jTextField.setText("Path...");
        themLoaiMonAn_jComboBox.setSelectedIndex(0);
        themDonGia_jTextField.setValue(0);
        nguyenLieuDaChon.clear();
        themShowNguyenLieuDaChon_jTextArea.setText("");
    }

    public void setThemLoaiMonAnJDialogVeTrangThaiBanDau() {
        themTenLoaiMonAn_jTextField.setText("");
        themMoTaLoaiMonAn_jTextArea.setText("");
    }

    private void themMonAn_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themMonAn_jButtonActionPerformed
        // TODO add your handling code here:
        setThemMonAnJDialogVeTrangThaiBanDau();
        String maMonAn = "MAMON1";
        try {
            String sql = "SELECT TO_NUMBER(SUBSTR(MAMON, 6))+1 LAST_MAMA FROM MONAN ORDER BY TO_NUMBER(SUBSTR( MAMON, 6 )) DESC";
            ResultSet numberMaMonAn = ExcuteSQLStatement.ExcuteSQLQuery(sql,connection);
            if (numberMaMonAn.next()) {
                maMonAn = "MAMON" + numberMaMonAn.getInt("LAST_MAMA");
            }

        } catch (SQLException | HeadlessException ex) {
        }
        themMaMonAn_jTextField.setText(maMonAn);
        themMonAn_jDialog.pack();
        themMonAn_jDialog.setLocationRelativeTo(null);
        themMonAn_jDialog.setVisible(true);
    }//GEN-LAST:event_themMonAn_jButtonActionPerformed

    private void searchMonAn_jTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchMonAn_jTextFieldFocusGained
        // TODO add your handling code here:
        searchMonAn_jTextField.setText("");
        searchMonAn_jTextField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        searchMonAn_jTextField.setForeground(Color.BLACK);
    }//GEN-LAST:event_searchMonAn_jTextFieldFocusGained
    private void searchMonAn_jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMonAn_jButton1ActionPerformed
        // TODO add your handling code here:
//        xoa_suaMonAn_jDialog;
        boolean flag = false;
        int boxSearch = searchMonAnTheo_jComboBox.getSelectedIndex();
        try {
            String sql;
            if(boxSearch==0)
                sql = "SELECT * FROM MONAN WHERE MAMON = '" + searchMonAn_jTextField.getText() + "'";
            else
                sql = "SELECT * FROM MONAN WHERE TENMON = '" + searchMonAn_jTextField.getText() + "'";
            
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                flag = true;
                xoa_suaMonAn_jDialog.setVisible(true);
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println("the error is" + ex);
        }

        if (!flag) {
            JOptionPane search_jOptionPane = new JOptionPane();
            search_jOptionPane.setVisible(true);
            search_jOptionPane.showMessageDialog(this, "Không tìm thấy món ăn!");
        }

    }//GEN-LAST:event_searchMonAn_jButton1ActionPerformed

    private void cancel_themMonAn_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_themMonAn_jButtonActionPerformed
        // TODO add your handling code here:
        setThemMonAnJDialogVeTrangThaiBanDau();
        themMonAn_jDialog.setVisible(false);
    }//GEN-LAST:event_cancel_themMonAn_jButtonActionPerformed

    private void confirmThemMonAn_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmThemMonAn_jButtonActionPerformed
        // TODO add your handling code here:
        boolean success = false;
        String link_img = themPathAnhMonAn_jTextField.getText();
        String tenMon = themTenMonAn_jTextField.getText();
        Object tenLoaiMonAn = themLoaiMonAn_jComboBox.getSelectedItem();
        String maMonAn = themMaMonAn_jTextField.getText();
        int tinhtrang = tinhTrangMonAn_jComboBox.getSelectedIndex();
        int donGia;
        try {
            donGia = Integer.parseInt(themDonGia_jTextField.getValue().toString());
        } catch (NumberFormatException e) {
            donGia = 0;
        }
        if (maMonAn.equals("")) {
            success = false;
        }
        themMonAn_jDialog.setVisible(false);
        //Them vao co so du lieu
        String sql = "SELECT MALMA FROM LOAIMONAN where TENLMA ='" + tenLoaiMonAn.toString() + "'";
        ResultSet loaiMonAnResultSet = ExcuteSQLStatement.ExcuteSQLQuery(sql,connection);
        String maLoaiMonAn;
        try {
            while (loaiMonAnResultSet.next()) {
                success = true;
                maLoaiMonAn = loaiMonAnResultSet.getString("MALMA");
                String sqlStatementUpdateMonAn = "insert into MONAN values('" + maMonAn + "','" + tenMon + "','" + maLoaiMonAn + "'," + donGia + ",'" + link_img + "', "+ tinhTrangMonAn_jComboBox.getSelectedIndex() +")";
                ExcuteSQLStatement.ExcuteSQLUpdate(sqlStatementUpdateMonAn,connection);
            }
        } catch (SQLException ex) {
            success = false;
            Logger.getLogger(QuanlyThucDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String tenNL : nguyenLieuDaChon) {
            String sqlStatementMaNguyenLieu = "select MANL from KHONGUYENLIEU where TENNL = '" + tenNL + "'";
            ResultSet maNguyenLieuResultSet = ExcuteSQLStatement.ExcuteSQLQuery(sqlStatementMaNguyenLieu,connection);
            try {
                while (maNguyenLieuResultSet.next()) {
                    success = true;
                    String manl = maNguyenLieuResultSet.getString("MANL");
                    String sqlStatementUpdateCheBien = "insert into CHEBIEN values ('" + maMonAn + "', '" + manl + "')";
                    Statement statement_INSERT = connection.createStatement();
                    int res_INSERT = statement_INSERT.executeUpdate(sqlStatementUpdateCheBien);
                    success = true;
                }
            } catch (SQLException ex) {
                success = false;
                Logger.getLogger(QuanlyThucDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (success == true) {
            DishesButton newDishesButton = new DishesButton(link_img, tenMon, tenLoaiMonAn, maMonAn, donGia, tinhtrang, nguyenLieuDaChon, 90,80);
            for (JPanel loaiMonAnJPanel : loaiMonAnJPanels) {
                if (newDishesButton.getTenLoaiMonAn().equals(loaiMonAnJPanel.getName())) {
                    loaiMonAnJPanel.add(newDishesButton);
                }
            }
            confirmThemMonAn_jOptionPane.showMessageDialog(quanLyThucDon_jPanel, "Them mon an thanh cong!");
        } else {
            confirmThemMonAn_jOptionPane.showOptionDialog(quanLyThucDon_jPanel, "Thêm món ăn không thành công!", "Error", -1, 0, null, null, null);
        }
        setThemMonAnJDialogVeTrangThaiBanDau();
        reloadGUIMonAn();
    }//GEN-LAST:event_confirmThemMonAn_jButtonActionPerformed

    private void themTenMonAn_jTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themTenMonAn_jTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_themTenMonAn_jTextFieldActionPerformed

    private void themAnhMonAnTuFile_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themAnhMonAnTuFile_jButtonActionPerformed
        // TODO add your handling code here:
        themMonAn_jFileChooser.showOpenDialog(null);
        File anhMonAn = themMonAn_jFileChooser.getSelectedFile();
        String link_image = anhMonAn.getAbsolutePath();
        themPathAnhMonAn_jTextField.setText(link_image);
    }//GEN-LAST:event_themAnhMonAnTuFile_jButtonActionPerformed

    private void confirmSuaMonAn_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmSuaMonAn_jButtonActionPerformed
        // TODO add your handling code here:
        int x = xoa_suaMonAn_jOptionPane.showOptionDialog(xoa_suaMonAn_jDialog, "Bạn có chắc muốn sửa món ăn?", "Cảnh báo xác nhận sửa món ăn", 0, 2, null, null, null);
        if (x == JOptionPane.YES_OPTION) {
            try {            
                String maMonAn = suaMaMonAn_jTextField.getText();
                String tenMonAnMoi = suaTenMonAn_jTextField.getText();
                Object tenLoaiMonAnMoi = suaLoaiMonAn_jComboBox.getSelectedItem();

                ResultSet MALMAResultSet = ExcuteSQLStatement.ExcuteSQLQuery("select * from LOAIMONAN where TENLMA = '" + tenLoaiMonAnMoi + "'",connection);
                while (MALMAResultSet.next()) {
                    String maLoaiMonAnMoi = MALMAResultSet.getString("MALMA");
                    String tenLoaiMonAn = MALMAResultSet.getString("TENLMA");
                    int tinhtrangLoaiMonAnMoi = MALMAResultSet.getInt("TINHTRANG");
                    if(!(tinhtrangLoaiMonAnMoi == 0 && suatinhTrangMonAn_jComboBox.getSelectedIndex() == 1))
                        ExcuteSQLStatement.ExcuteSQLUpdate("update MONAN set TENMON = '" + tenMonAnMoi + "', MALMA = '" + maLoaiMonAnMoi + "', DONGIA = " + suaDonGia_jTextField.getValue()+ ", LINK_IMAGE ='" + suaPathAnhMonAn_jTextField.getText() + "', TINHTRANG = " + suatinhTrangMonAn_jComboBox.getSelectedIndex() + " where MAMON = '" + maMonAn + "'", connection);
                    else{
                        JOptionPane khactinhtrang_option = new JOptionPane();
                        khactinhtrang_option.setVisible(true);
                        khactinhtrang_option.showMessageDialog(xoa_suaMonAn_jDialog, "Loại món ăn này đã không còn được sử dụng nữa!");
                    }
                        
                    for (String tenNL : nguyenLieuSua) {
                        String sqlStatementMaNguyenLieu = "select MANL from KHONGUYENLIEU where TENNL = '" + tenNL + "'";
                        ResultSet maNguyenLieuResultSet = ExcuteSQLStatement.ExcuteSQLQuery(sqlStatementMaNguyenLieu, connection);
                        try {
                            while (maNguyenLieuResultSet.next()) {
                                String MANL = maNguyenLieuResultSet.getString("MANL");
                                String sqlStatementDeleteCheBien = "delete from CHEBIEN where MAMON = '" + maMonAn + "' and MANL = '" + MANL + "'";
                                ExcuteSQLStatement.ExcuteSQLUpdate(sqlStatementDeleteCheBien, connection);
                                String sqlStatementUpdateCheBien = "insert into CHEBIEN values ('" + maMonAn + "', '" + MANL + "')";
                                ExcuteSQLStatement.ExcuteSQLUpdate(sqlStatementUpdateCheBien, connection);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(QuanlyThucDon.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanlyThucDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            trangThaiChonXoaOrSua = 1;
            xoa_suaMonAn_jDialog.setVisible(false);
            reloadGUIMonAn();
        }
    }//GEN-LAST:event_confirmSuaMonAn_jButtonActionPerformed

    private void cancel_xoa_suaMonAn_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_xoa_suaMonAn_jButtonActionPerformed
        // TODO add your handling code here:
        trangThaiChonXoaOrSua = 0;
        xoa_suaMonAn_jDialog.setVisible(false);
    }//GEN-LAST:event_cancel_xoa_suaMonAn_jButtonActionPerformed

    private void suaAnhMonAnTuFile_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaAnhMonAnTuFile_jButtonActionPerformed
        // TODO add your handling code here:
        themMonAn_jFileChooser.showOpenDialog(null);
        File anhMonAn = themMonAn_jFileChooser.getSelectedFile();
        String link_image = anhMonAn.getAbsolutePath();
        if(link_image!=null)
            suaPathAnhMonAn_jTextField.setText(link_image);
    }//GEN-LAST:event_suaAnhMonAnTuFile_jButtonActionPerformed

    private void themLoaiMonAn_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themLoaiMonAn_jButtonActionPerformed
        // TODO add your handling code here:
        themLoaiMonAn_jDialog.pack();
        themLoaiMonAn_jDialog.setLocationRelativeTo(null);
        themLoaiMonAn_jDialog.setVisible(true);

    }//GEN-LAST:event_themLoaiMonAn_jButtonActionPerformed

    private void confirmThemNguyenLieu_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmThemNguyenLieu_jButtonActionPerformed
        // TODO add your handling code here:
        if (!themShowNguyenLieuDaChon_jTextArea.getText().contains(themNguyenLieu_jList.getSelectedValue())) {
            if (themShowNguyenLieuDaChon_jTextArea.getText().equals("")) {
                themShowNguyenLieuDaChon_jTextArea.setText(themNguyenLieu_jList.getSelectedValue());

            } else {
                themShowNguyenLieuDaChon_jTextArea.setText(themShowNguyenLieuDaChon_jTextArea.getText() + ", " + themNguyenLieu_jList.getSelectedValue());
            }
            nguyenLieuDaChon.add(themNguyenLieu_jList.getSelectedValue());
        }
    }//GEN-LAST:event_confirmThemNguyenLieu_jButtonActionPerformed

    private void confirmSuaNguyenLieu_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmSuaNguyenLieu_jButtonActionPerformed
        String[] temp = suaShowNguyenLieu_jTextArea.getText().split("[\\n]");

        nguyenLieuSua = new ArrayList<>(Arrays.asList(temp));
        for (String nguyenlieu : nguyenLieuSua) {
            if (!suaNguyenLieu_jList.getSelectedValue().equals(nguyenlieu)) {
                //Hien thi cai moi chon
                if (suaShowNguyenLieu_jTextArea.getText().equals("")) {
                    suaShowNguyenLieu_jTextArea.setText(suaNguyenLieu_jList.getSelectedValue());
                } else {
                    suaShowNguyenLieu_jTextArea.setText(suaShowNguyenLieu_jTextArea.getText() + "\n" + suaNguyenLieu_jList.getSelectedValue());
                }
                nguyenLieuSua.add(suaNguyenLieu_jList.getSelectedValue());
                break;
            }
        }
    }//GEN-LAST:event_confirmSuaNguyenLieu_jButtonActionPerformed

    private void suaLoaiMonAn_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaLoaiMonAn_jButtonActionPerformed
        // TODO add your handling code here:
        suaLoaiMonAn_jDialog.pack();
        suaLoaiMonAn_jDialog.setLocationRelativeTo(null);
        suaLoaiMonAn_jDialog.setVisible(true);
    }//GEN-LAST:event_suaLoaiMonAn_jButtonActionPerformed

    private void confirmThemLoaiMonAn_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmThemLoaiMonAn_jButtonActionPerformed
        // TODO add your handling code here:
        JScrollPane monAn_jScrollPane = new JScrollPane();
        monAn_jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        monAn_jScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        monAn_jScrollPane.setPreferredSize(new java.awt.Dimension(400, 100));
        JPanel monAn_jPanel = new javax.swing.JPanel();
        monAn_jPanel.setLayout(new java.awt.GridLayout(0, 3));
        monAn_jScrollPane.setViewportView(monAn_jPanel);
        showMonAn_jTabbedPane.addTab(themTenLoaiMonAn_jTextField.getText(), monAn_jScrollPane);
        confirmThemMonAn_jOptionPane.showMessageDialog(quanLyThucDon_jPanel, "Thêm loại món ăn thành công!");
        loaiMonAnJPanels.add(monAn_jPanel);
        themLoaiMonAn_jDialog.setVisible(false);
        String maLoaiMonAn = "LMA1";
        try {
            String sql = "SELECT TO_NUMBER(SUBSTR(MALMA, 4))+1 LAST_MALMA FROM MONAN ORDER BY TO_NUMBER(SUBSTR(MALMA, 4)) DESC";
            ResultSet numberMaLoaiMonAn = ExcuteSQLStatement.ExcuteSQLQuery(sql,connection);
            if (numberMaLoaiMonAn.next()) {
                maLoaiMonAn = "LMA" + numberMaLoaiMonAn.getInt("LAST_MALMA");
            }
        } catch (SQLException | HeadlessException ex) {
        }
        ExcuteSQLStatement.ExcuteSQLUpdate("insert into LOAIMONAN values ('" + maLoaiMonAn + "', '" + themTenLoaiMonAn_jTextField.getText() + "', '" + themMoTaLoaiMonAn_jTextArea.getText() + "', " +tinhtrangLoaiMonAn_jComboBox.getSelectedIndex()+ ")",connection);
        //Cap nhat lai cac loai mon an trong combobox goc
        themLoaiMonAn_jComboBox.removeAllItems();
        ArrayList<String> StrTenLMA = new ArrayList<>();
        String[] arrTenLMA = chonThongTinLoaiMonAn(StrTenLMA);
        for (String arrTenLMA1 : arrTenLMA) {
            themLoaiMonAn_jComboBox.addItem(arrTenLMA1);
        }
        // cmt cho no tach ra thoi
        setThemLoaiMonAnJDialogVeTrangThaiBanDau();
    }//GEN-LAST:event_confirmThemLoaiMonAn_jButtonActionPerformed

    private void cancelThemLoaiMonAn_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelThemLoaiMonAn_jButtonActionPerformed
        // TODO add your handling code here:
        setThemLoaiMonAnJDialogVeTrangThaiBanDau();
        themLoaiMonAn_jDialog.setVisible(false);
    }//GEN-LAST:event_cancelThemLoaiMonAn_jButtonActionPerformed

    private void comfirmSuaLoaiMonAn_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comfirmSuaLoaiMonAn_jButtonActionPerformed
        // TODO add your handling code here:
        String tenLoaiMonAnMoi = tenMoiLoaiMonAn_jTextField.getText();
        String moTaLoaiMonAnMoi = moTaMoiLoaiMonAn_jTextArea.getText();
        ResultSet maLoaiMonAnResultSet = ExcuteSQLStatement.ExcuteSQLQuery("select MALMA from LOAIMONAN where TENLMA ='" + suaChonLoaiMonAn_jComboBox.getSelectedItem().toString() + "'",connection);
        try {
            while (maLoaiMonAnResultSet.next()) {
                ExcuteSQLStatement.ExcuteSQLUpdate("update LOAIMONAN set TENLMA = '" + tenLoaiMonAnMoi + "', MOTA = '" + moTaLoaiMonAnMoi + "', TINHTRANG = " + suatinhtrangLoaiMonAn_jComboBox.getSelectedIndex() + " where MALMA = '" + maLoaiMonAnResultSet.getString("MALMA") + "'",connection);
                ResultSet TinhTrangMonAnResultSet = ExcuteSQLStatement.ExcuteSQLQuery("select MAMON from MONAN where MALMA ='" + maLoaiMonAnResultSet.getString("MALMA") + "'",connection);
                while (TinhTrangMonAnResultSet.next()) {
                    ExcuteSQLStatement.ExcuteSQLUpdate("update MONAN set TINHTRANG = '" + suatinhtrangLoaiMonAn_jComboBox.getSelectedIndex() + "' where MAMON = '" + TinhTrangMonAnResultSet.getString("MAMON") + "'",connection);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanlyThucDon.class.getName()).log(Level.SEVERE, null, ex);
        }

        suaLoaiMonAn_jDialog.setVisible(false);

        //Cap nhat lai cac loai mon an trong combobox goc
        themLoaiMonAn_jComboBox.removeAllItems();
        ArrayList<String> StrTenLMA = new ArrayList<>();
        String[] arrTenLMA = chonThongTinLoaiMonAn(StrTenLMA);
        for (String arrTenLMA1 : arrTenLMA) {
            themLoaiMonAn_jComboBox.addItem(arrTenLMA1);
        }
        // Reload GUI - Ko biet de lam gi nhma xoa thi so no loi :))
        setSuaLoaiMonAnDialogVeTrangThaiBanDau();
        reloadGUIMonAn();
    }//GEN-LAST:event_comfirmSuaLoaiMonAn_jButtonActionPerformed
    private void reloadGUIMonAn() {
        showMonAn_jTabbedPane.removeAll();
        showMonAn_jTabbedPane.revalidate();
        showMonAn_jTabbedPane.repaint();
        showMonAnTuDataBase();
    }
    private void chonMonAnCanSua_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chonMonAnCanSua_jButtonActionPerformed
        // TODO add your handling code here:
        String tenLoaiMonAnCanSua = suaLoaiMonAn_jComboBox.getSelectedItem().toString();
        tenMoiLoaiMonAn_jTextField.setText(tenLoaiMonAnCanSua);
        String sqlStatementMoTaLoaiMonAn = "select * from LOAIMONAN where TENLMA ='" + tenLoaiMonAnCanSua + "'";
        ResultSet LoaiMonAnCanSuaResultSet = ExcuteSQLStatement.ExcuteSQLQuery(sqlStatementMoTaLoaiMonAn,connection);
        try {
            while (LoaiMonAnCanSuaResultSet.next()) {
                moTaMoiLoaiMonAn_jTextArea.setText(LoaiMonAnCanSuaResultSet.getString("MOTA"));
                suatinhtrangLoaiMonAn_jComboBox.setSelectedIndex(LoaiMonAnCanSuaResultSet.getInt("TINHTRANG"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanlyThucDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chonMonAnCanSua_jButtonActionPerformed

    private void cancelSuaLoaiMonAn_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelSuaLoaiMonAn_jButtonActionPerformed
        // TODO add your handling code here:
        setSuaLoaiMonAnDialogVeTrangThaiBanDau();
        suaLoaiMonAn_jDialog.setVisible(false);

    }//GEN-LAST:event_cancelSuaLoaiMonAn_jButtonActionPerformed

    private void confirmXoaNguyenLieu_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmXoaNguyenLieu_jButtonActionPerformed
        // TODO add your handling code here:
        String[] temp = suaShowNguyenLieu_jTextArea.getText().split("[\\n]");
        nguyenLieuSua = new ArrayList<>(Arrays.asList(temp));
        if (suaShowNguyenLieu_jTextArea.getText().contains(suaNguyenLieu_jList.getSelectedValue() + "\\n")) {
            suaShowNguyenLieu_jTextArea.setText(suaShowNguyenLieu_jTextArea.getText().replace(suaNguyenLieu_jList.getSelectedValue() + "\\n", ""));
        } else if (suaShowNguyenLieu_jTextArea.getText().contains(suaNguyenLieu_jList.getSelectedValue())) {
            suaShowNguyenLieu_jTextArea.setText(suaShowNguyenLieu_jTextArea.getText().replace(suaNguyenLieu_jList.getSelectedValue(), ""));
        }
        nguyenLieuSua.remove(suaNguyenLieu_jList.getSelectedValue());
        try {
            String sqlStatementMaNguyenLieu = "select MANL from KHONGUYENLIEU where TENNL = '" + suaNguyenLieu_jList.getSelectedValue() + "'";
            ResultSet maNguyenLieuResultSet = ExcuteSQLStatement.ExcuteSQLQuery(sqlStatementMaNguyenLieu, connection);
            while (maNguyenLieuResultSet.next()) {
                String MANL = maNguyenLieuResultSet.getString("MANL");
                String sqlStatementDeleteCheBien = "delete from CHEBIEN where MAMON = '" + suaMaMonAn_jTextField.getText() + "' and MANL = '" + MANL + "'";
                ExcuteSQLStatement.ExcuteSQLUpdate(sqlStatementDeleteCheBien, connection);
                System.out.println("Delete");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanlyThucDon.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_confirmXoaNguyenLieu_jButtonActionPerformed
    private void setSuaLoaiMonAnDialogVeTrangThaiBanDau() {
        suaLoaiMonAn_jComboBox.setSelectedIndex(0);
        tenMoiLoaiMonAn_jTextField.setText("");
        moTaMoiLoaiMonAn_jTextArea.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelSuaLoaiMonAn_jButton;
    private javax.swing.JButton cancelThemLoaiMonAn_jButton;
    private javax.swing.JButton cancel_themMonAn_jButton;
    private javax.swing.JButton cancel_xoa_suaMonAn_jButton;
    private javax.swing.JButton chonMonAnCanSua_jButton;
    private javax.swing.JButton comfirmSuaLoaiMonAn_jButton;
    public static javax.swing.JButton confirmSuaMonAn_jButton;
    private javax.swing.JButton confirmSuaNguyenLieu_jButton;
    private javax.swing.JButton confirmThemLoaiMonAn_jButton;
    private javax.swing.JButton confirmThemMonAn_jButton;
    private javax.swing.JOptionPane confirmThemMonAn_jOptionPane;
    private javax.swing.JButton confirmThemNguyenLieu_jButton;
    private javax.swing.JButton confirmXoaNguyenLieu_jButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel moTaMoiLoaiMonAn_jLabel;
    private javax.swing.JTextArea moTaMoiLoaiMonAn_jTextArea;
    private javax.swing.JPanel quanLyThucDon_jPanel;
    private javax.swing.JPanel quanLyThucDon_pane_bg;
    private javax.swing.JComboBox<String> searchMonAnTheo_jComboBox;
    private javax.swing.JButton searchMonAn_jButton1;
    private javax.swing.JPanel searchMonAn_jPanel;
    private javax.swing.JTextField searchMonAn_jTextField;
    private javax.swing.JTabbedPane showMonAn_jTabbedPane;
    private javax.swing.JButton suaAnhMonAnTuFile_jButton;
    private javax.swing.JLabel suaAnhMonAn_jLabel;
    private javax.swing.JComboBox<String> suaChonLoaiMonAn_jComboBox;
    private javax.swing.JLabel suaChonLoaiMonAn_jLabel;
    private javax.swing.JLabel suaDonGia_jLabel;
    public static javax.swing.JFormattedTextField suaDonGia_jTextField;
    private ButtonGradient suaLoaiMonAn_jButton;
    public static javax.swing.JComboBox<String> suaLoaiMonAn_jComboBox;
    private javax.swing.JDialog suaLoaiMonAn_jDialog;
    private javax.swing.JLabel suaLoaiMonAn_jLabel;
    private javax.swing.JLabel suaMaMonAn_jLabel;
    public static javax.swing.JTextField suaMaMonAn_jTextField;
    private javax.swing.JLabel suaNguyenLieu_jLabel;
    public static javax.swing.JList<String> suaNguyenLieu_jList;
    public static javax.swing.JTextField suaPathAnhMonAn_jTextField;
    public static javax.swing.JTextArea suaShowNguyenLieu_jTextArea;
    public static javax.swing.JTextField suaTenMonAn_jTextField;
    public static javax.swing.JComboBox suatinhTrangMonAn_jComboBox;
    private javax.swing.JLabel suaTenMon_jLabel;
    private javax.swing.JLabel tenMoiLoaiMonAn_jLabel;
    private javax.swing.JTextField tenMoiLoaiMonAn_jTextField;
    private javax.swing.JLabel tinhtrangLoaiMonAn_jLabel;
    private javax.swing.JComboBox tinhtrangLoaiMonAn_jComboBox;
    private javax.swing.JButton themAnhMonAnTuFile_jButton;
    private javax.swing.JLabel themAnhMonAn_jLabel;
    private javax.swing.JLabel themDonGia_jLabel;
    private javax.swing.JFormattedTextField themDonGia_jTextField;
    private ButtonGradient themLoaiMonAn_jButton;
    private javax.swing.JComboBox<String> themLoaiMonAn_jComboBox;
    private javax.swing.JDialog themLoaiMonAn_jDialog;
    private javax.swing.JLabel themLoaiMonAn_jLabel;
    private javax.swing.JTextField themMaMonAn_jTextField;
    private javax.swing.JLabel themMaMonaAn_jLabel;
    private javax.swing.JLabel themMoTaLoaiMonAn_jLabel;
    public static javax.swing.JTextArea themMoTaLoaiMonAn_jTextArea;
//    private javax.swing.JButton themMonAn_jButton;    
    private ButtonGradient themMonAn_jButton;
    private javax.swing.JDialog themMonAn_jDialog;
    private javax.swing.JFileChooser themMonAn_jFileChooser;
    private javax.swing.JList<String> themNguyenLieu_jList;
    private javax.swing.JTextField themPathAnhMonAn_jTextField;
    private javax.swing.JTextArea themShowNguyenLieuDaChon_jTextArea;
    private javax.swing.JLabel themTenLoaiMonAn_jLabel;
    public static javax.swing.JTextField themTenLoaiMonAn_jTextField;
    private javax.swing.JTextField themTenMonAn_jTextField;
    private javax.swing.JLabel themTenMon_jLabel;
    public static javax.swing.JDialog xoa_suaMonAn_jDialog;
    private javax.swing.JOptionPane xoa_suaMonAn_jOptionPane;
    
    
    private JLabel suaTinhTrangMonAn_jLabel;
    private  JComboBox tinhTrangMonAn_jComboBox;
    private JComboBox suatinhtrangLoaiMonAn_jComboBox;
    private JLabel suatinhtrangLoaiMonAn_jLabel;
    // End of variables declaration//GEN-END:variables
}
