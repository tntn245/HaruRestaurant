/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author My PC
 */
public class ButtonGradient extends JButton {
    private Color color1 = Color.decode("#A7DFFF");
    private Color color2 = Color.decode("#FFB7B6");
    
    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public ButtonGradient() {
        setFocusPainted(false); //khong bi vien chu sau khi bam
        setContentAreaFilled(false);
        setForeground(Color.BLACK); 
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //chua can den
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }
        });
    }
   
    @Override
    protected void paintComponent(Graphics g) {
        final Graphics2D g2 = (Graphics2D) g.create();
        
        g2.setPaint(new GradientPaint(new Point(0, 0), color1, new Point(0, getHeight()), color2));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        g2.dispose();
        super.paintComponent(g);
    }
}
