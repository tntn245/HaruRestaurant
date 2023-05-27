/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author My PC
 */
public class JPanelGradient extends JPanel {
    private int r1;    
    private int g1;
    private int b1;
    
    private int r2;
    private int g2;
    private int b2;
    
    public JPanelGradient(int r1, int g1, int b1, int r2, int g2, int b2){
        this.r1 = r1;
        this.g1 = g1;
        this.b1 = b1;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
            
        Color color1 = new Color(this.r1, this.g1, this.b1);
        Color color2 = new Color(this.r2, this.g2, this.b2);
        GradientPaint gp = new GradientPaint(0, 0, color1, 180, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
        }
}

