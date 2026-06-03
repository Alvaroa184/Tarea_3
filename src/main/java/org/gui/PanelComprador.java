package org.gui;

import org.logica.Expendedor;

import java.awt.*;

public class PanelComprador {
    private int x;
    private int y;
    private Expendedor exp;

    public PanelComprador(int x, int y, Expendedor exp) {
        this.x = x;
        this.y = y;
        this.exp = exp;
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 400, 600);

        g.setColor(Color.WHITE);
        g.drawString("COMPRADOR", x + 140, y + 30);
    }
}