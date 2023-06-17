/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import style.TextGradient;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author My PC
 */
public class TrangChuQL {
    public JLayeredPane pane_layer;
    private JLabel label_background_mountain;
    private JLabel label_background_flower;
    private TextGradient HARU;

    public TrangChuQL(){
        init();
    }   
    public void init(){
        pane_layer = new JLayeredPane();
        pane_layer.setOpaque(true);
        pane_layer.setBackground(Color.white);
        label_background_mountain = new JLabel();
        label_background_flower = new JLabel();
        background_mountain();
        background_flower();
        Haru_text();
        pane_layer = set_pane();
    }
    public void background_mountain(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/—Pngtree—japan fuji mountain landscape illustration_4622958.png"));
        Image image = icon.getImage().getScaledInstance(640, 600, java.awt.Image.SCALE_SMOOTH);
//        ImageIcon icon = new ImageIcon(getClass().getResource("/image/Pngtree_41454231.png"));
//        Image image = icon.getImage().getScaledInstance(518, 518, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image);
        label_background_mountain = new JLabel();
        label_background_mountain.setIcon(newIcon);
    }
    public void background_flower(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/flower_transparent.png"));
        Image image = icon.getImage().getScaledInstance(676, 588, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(image);   
        label_background_flower = new JLabel();
        label_background_flower.setIcon(newIcon);
    }
    public void Haru_text(){
        Font font = new Font("SansSerif", Font.BOLD, 45);
        HARU = new TextGradient("HARU", font, new Color(70,190,255), new Color( 255, 130, 130), -1);
        HARU.setBackground(Color.white);
        HARU.setPreferredSize(new Dimension(200, 50));
    }
    public JLayeredPane set_pane(){
        label_background_mountain.setBounds(50, -30, 700, 600);
        label_background_flower.setBounds(0, 0, 700, 600);
        HARU.setBounds(150, 400, 500, 150);
        pane_layer.add(label_background_mountain, new Integer(1));
        pane_layer.add(HARU, new Integer(2));
        pane_layer.add(label_background_flower, new Integer(3));
        return pane_layer;
    }
}
