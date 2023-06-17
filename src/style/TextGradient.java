/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package style;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author My PC
 */
public class TextGradient extends JPanel{
    private String str;
    private Font font;
    private Color color1;
    private Color color2;
    private int axis_X;
        
    public TextGradient(String str, Font font, Color color1, Color color2, int x){
        this.str = str;
        this.font = font;
        this.color1 = color1;
        this.color2 = color2;
        this.axis_X = x;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(font);
        int stringWidth = g2d.getFontMetrics().stringWidth(str);
        int stringHeight = g2d.getFontMetrics().getHeight();
        int x = (getWidth() - stringWidth) / 2;
        int y = (getHeight() + stringHeight) / 2;
        GradientPaint gradient = new GradientPaint(x, y - stringHeight/2, color1, x, y , color2);
        g2d.setPaint(gradient);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        if(axis_X < 0)
            axis_X = x;
        g2d.drawString(str, axis_X, y);
    }
}
