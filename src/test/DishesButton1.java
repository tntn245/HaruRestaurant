package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import static test.QuanLyThucDonJPanel.*;

public final class DishesButton1 extends JButton {

    private String maMonAn;
    private String tenMon;
    private String link_img;
    
    private Object tenLoaiMonAn;
    private int donGia;
    private ArrayList<String> nguyenLieu = new ArrayList<>();
    private ArrayList<String> nguyenLieuTemp = new ArrayList<>();

    public DishesButton1(String link_img, String tenMon, Object tenLoaiMonAn, String maMonAn, int donGia, ArrayList<String> nguyenLieu) {
        try {
            setLink_img(link_img);
            ImageIcon dishIcon = new ImageIcon(getClass().getResource(getLink_img()));
            Image dishImage = dishIcon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
            javax.swing.ImageIcon scaledDishIcon = new ImageIcon(dishImage);
            setIcon(scaledDishIcon);
        } catch (Exception e) {
            ImageIcon dishIcon = new ImageIcon(getLink_img());
            Image dishImage = dishIcon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
            javax.swing.ImageIcon scaledDishIcon = new ImageIcon(dishImage);
            setIcon(scaledDishIcon);
        }
        setTenMon(tenMon);
        setTenLoaiMonAn(tenLoaiMonAn);
        setMaMonAn(maMonAn);
        setDonGia(donGia);
        setNguyenLieu(nguyenLieu);
        nguyenLieuTemp = new ArrayList<>(this.nguyenLieu);
        setIconTextGap(20);
        setBackground(Color.decode("#E9F7FF"));
        setHorizontalTextPosition(CENTER);
        setVerticalTextPosition(BOTTOM);
        addActionListener(DishesButtonActionListener);
    }

    ActionListener DishesButtonActionListener = (ActionEvent e) -> {
        suaLoaiMonAn_jComboBox.setSelectedItem(tenLoaiMonAn);
        suaMaMonAn_jTextField.setText(this.getMaMonAn());
        suaTenMonAn_jTextField.setText(this.getTenMon());
        suaPathAnhMonAn_jTextField.setText(this.getLink_img());
        suaDonGia_jTextField.setText(String.valueOf(donGia));
        for (String str : nguyenLieu) {
            if (suaShowNguyenLieu_jTextArea.getText().equals("")) {
                suaShowNguyenLieu_jTextArea.setText(str);
            } else {
                suaShowNguyenLieu_jTextArea.setText(suaShowNguyenLieu_jTextArea.getText() + ", " + str);
            }
        }
        System.out.println(getNguyenLieu());
        //Hien dialog sua de sua
        xoa_suaMonAn_jDialog.pack();
        xoa_suaMonAn_jDialog.setLocationRelativeTo(null);
        xoa_suaMonAn_jDialog.setVisible(true);
        //Xu ly
        

        switch (trangThaiChonXoaOrSua) {
            case 2 -> {
                suaThongTin();
                trangThaiChonXoaOrSua = 0;
            }
            case 1 -> {
                trangThaiChonXoaOrSua = 0;
            }
            default -> {
                trangThaiChonXoaOrSua = 0;
            }
        }
        //suaShowNguyenLieu phai o cuoi de thuc hien dung
        suaShowNguyenLieu_jTextArea.setText("");
    };

    public void suaThongTin() {
        String new_link_img = suaPathAnhMonAn_jTextField.getText();
        setTenMon(suaTenMonAn_jTextField.getText());
        setTenLoaiMonAn(suaLoaiMonAn_jComboBox.getSelectedItem());
        setLink_img(new_link_img);
        setDonGia(Integer.parseInt(suaDonGia_jTextField.getText()));
        setNguyenLieu(nguyenLieuTemp);
        try {
            ImageIcon dishIcon = new ImageIcon(getClass().getResource(this.link_img));
            Image dishImage = dishIcon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledDishIcon = new ImageIcon(dishImage);
            setIcon(scaledDishIcon);
        } catch (Exception e) {
            ImageIcon dishIcon = new ImageIcon(this.link_img);
            Image dishImage = dishIcon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledDishIcon = new ImageIcon(dishImage);
            setIcon(scaledDishIcon);
        }
        //Doan nay can xem lai de xem vi tri xuat hien
        for (JPanel loaiMonAnJPanel: loaiMonAnJPanels)
        {
            if (getTenLoaiMonAn().equals(loaiMonAnJPanel.getName())) loaiMonAnJPanel.add(this);
        }
    }

    public void SuaNguyenLieuMonAn()
    {
        if (themOrXoaNguyenLieu != 0) {
            boolean flag_trung = false;
            String tenNguyenLieuMoiThem = suaNguyenLieu_jList.getSelectedValue();
            for (String str : nguyenLieu) {
                if (str.equals(tenNguyenLieuMoiThem)) {
                    flag_trung = true;
                    break;
                }
            }
            if (themOrXoaNguyenLieu == 2) /*Bam nut them*/ {
                if (flag_trung == false) {
                    nguyenLieuTemp.add(tenNguyenLieuMoiThem);
                }
            } else if (themOrXoaNguyenLieu == 1) /*Bam nut xoa*/{
                if (flag_trung == true) nguyenLieuTemp.remove(tenNguyenLieuMoiThem);
            }
        }
    }
    public String getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(String maMonAn) {
        this.maMonAn = maMonAn;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
        setText(this.tenMon);
    }

    public String getLink_img() {
        return link_img;
    }

    public void setLink_img(String link_img) {
        this.link_img = link_img;
    }

    public Object getTenLoaiMonAn() {
        return tenLoaiMonAn;
    }

    public void setTenLoaiMonAn(Object tenLoaiMonAn) {
        this.tenLoaiMonAn = tenLoaiMonAn;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public ArrayList<String> getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(ArrayList<String> nguyenLieu) {
        this.nguyenLieu = new ArrayList<>(nguyenLieu);
    }
}
