/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QuanLyNhaHangHaru;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.MainFrame;

/**
 *
 * @author My PC
 */
public class QuanLyNhaHangHaru {

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
        

        MainFrame frame = new MainFrame();
    }
}
