package com.btmstudio;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;
import javax.swing.JTextField;

public class RoundedBorder implements Border {
    private int radius;
    private Color textColor;
    private boolean opaque;

    public RoundedBorder(int radius) {
        this(radius, Color.BLACK, false);
    }

    public RoundedBorder(int radius, Color textColor, boolean opaque) {
        this.radius = radius;
        this.textColor = textColor;
        this.opaque = opaque;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (c instanceof JTextField) {
            JTextField textField = (JTextField) c;
            textField.setOpaque(this.opaque);
            textField.setForeground(this.textColor);
        }
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}
