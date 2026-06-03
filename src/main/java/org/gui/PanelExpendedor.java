package org.gui;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private int x;
    private int y;

    public PanelExpendedor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(this.x, this.y, 400, 600);
    }
}

