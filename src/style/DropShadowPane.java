/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package style;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author My PC
 */
public class DropShadowPane extends JPanel {

    private static final long serialVersionUID = 1L;

    public int pixels;
    public int r;
    public int g;
    public int b;
    public Color color_bg;
    public int topOpacity = 80;

    public DropShadowPane(int pix, int r, int g, int b, int topOpacity) {
        this.pixels = pix;
        this.r = r;
        this.g = g;
        this.b = b;
        this.topOpacity = topOpacity;
        Border border = BorderFactory.createEmptyBorder(pixels, pixels, pixels, pixels);
        this.setBorder(BorderFactory.createCompoundBorder(  border, this.getBorder()));
        this.setLayout(new BorderLayout());
    }
        
    public DropShadowPane(int pix, int r, int g, int b, Color color_bg, int topOpacity) {
        this.pixels = pix;
        this.r = r;
        this.g = g;
        this.b = b;
        this.color_bg = color_bg;
        this.topOpacity = topOpacity;
        Border border = BorderFactory.createEmptyBorder(pixels, pixels, pixels, pixels);
        this.setBorder(BorderFactory.createCompoundBorder(  border, this.getBorder()));
        this.setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Insets insets = getBorder().getBorderInsets(this);
        if(color_bg != null)
            g.setColor(color_bg);
        g.fillRect(insets.left, insets.top,
        getWidth() - insets.left - insets.right,
        getHeight() - insets.top - insets.bottom);

        for (int i = 0; i < pixels; i++) {
            g.setColor(new Color(this.r, this.g, this.b, ((topOpacity / pixels) * i)));
            g.drawRect(i, i, this.getWidth() - ((i * 2) + 1), this.getHeight() - ((i * 2) + 1));
        }
    }
}
