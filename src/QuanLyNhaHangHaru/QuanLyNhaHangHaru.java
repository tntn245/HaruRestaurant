/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QuanLyNhaHangHaru;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.MainFrame;
//import static view.GUIKhachHang.label_SetSoHD_KH;
//import static view.GUIKhachHang.label_SetSoBan_KH;

/**
 *
 * @author My PC
 */
public class QuanLyNhaHangHaru {
    public static MainFrame frameQL;
    public static MainFrame frameKH;
    /**
     * @param args the command line arguments
     */         
            
    public static void main(String[] args) throws IOException, SQLException {
        try {
                UIManager.setLookAndFeel(new FlatArcIJTheme());
           }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        
        //mở để gọi xử lý transaction, tắt để trở về read commited 
        //=> NẾU muốn tương tác với giao diện KHÁCH HÀNG thì mở comment từ dòng 45
//        MainFrame frame = new MainFrame(true);
//        frame.Transaction();
        


        // Để xử lý transaction -> PHẢI tắt 2 giao diện tương tác giữa khách hàng và quản lý -> comment từ đây
        frameQL = new MainFrame(false);
        frameKH = new MainFrame(false);
                
        frameQL.QLHD.btn_ThanhToan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String SOBAN_QL = frameQL.QLHD.label_SetSoBan.getText().substring(4);
                String SOBAN_KH = frameKH.GUIKH.label_SetSoBan_KH.getText().substring(4);
                System.out.println(SOBAN_QL+"+"+SOBAN_KH);
                if(SOBAN_QL.equals(SOBAN_KH)){
                    frameKH.GUIKH.label_SetSoHD_KH.setText("");
                }
            }
        });
        
//        frameQL.QLHD.btn_TaoHoaDon.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String SOBAN_QL = frameQL.QLHD.label_SetSoBan.getText().substring(4);
//                String SOBAN_KH = frameKH.GUIKH.label_SetSoBan_KH.getText().substring(4);
//                System.out.println(SOBAN_QL+"+"+SOBAN_KH);
//                if(SOBAN_QL.equals(SOBAN_KH)){
//                    frameQL.QLHD.TaoMoiHD(frameKH.GUIKH.label_SetSoBan_KH.getText());
//                    frameKH.GUIKH.setSOHD(SOBAN_KH);
//                }
//            }
//        });
        
        //ĐẢO FRAME       
        frameKH.QLHD.btn_ThanhToan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String SOBAN_QL = frameKH.QLHD.label_SetSoBan.getText().substring(4);
                String SOBAN_KH = frameQL.GUIKH.label_SetSoBan_KH.getText().substring(4);
                if(SOBAN_QL.equals(SOBAN_KH)){
                    frameQL.GUIKH.label_SetSoHD_KH.setText("");
                }
            }
        });
        
//        frameKH.QLHD.btn_TaoHoaDon.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String SOBAN_QL = frameKH.QLHD.label_SetSoBan.getText().substring(4);
//                String SOBAN_KH = frameQL.GUIKH.label_SetSoBan_KH.getText().substring(4);
//                System.out.println(SOBAN_QL+"+"+SOBAN_KH);
//                if(SOBAN_QL.equals(SOBAN_KH)){
//                    frameKH.QLHD.TaoMoiHD(frameQL.GUIKH.label_SetSoBan_KH.getText());
//                    frameQL.GUIKH.setSOHD(SOBAN_KH);
//                }
//            }
//        });
        //đến đây
    }
}
