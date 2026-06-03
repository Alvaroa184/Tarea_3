package org.gui;

import java.awt.*;

public class PanelComprador {
    private int x;
    private int y;

    public PanelComprador(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 400, 600);

        g.setColor(Color.WHITE);
        g.drawString("COMPRADOR", x + 140, y + 30);
    }
}