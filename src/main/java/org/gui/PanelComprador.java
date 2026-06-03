package org.gui;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    private int x;
    private int y;

    public PanelComprador(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(this.x, this.y, 400, 600);
    }
}
