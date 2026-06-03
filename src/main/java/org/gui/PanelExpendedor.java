package org.gui;

import java.awt.*;
import org.logica.Expendedor;

public class PanelExpendedor {
    private int x;
    private int y;
    private Expendedor exp;

    public PanelExpendedor(int x, int y) {
        this.x = x;
        this.y = y;
        exp= new Expendedor(5);
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 400, 600);

        g.setColor(Color.WHITE);
        g.drawString("EXPENDEDOR", x + 140, y + 30);
        g.drawString("CocaCola:"+exp.getDepositoCoca().size(),x+30,y+80);
        g.drawString("Sprite:"+exp.getDepositoSprite().size(),x+30,y+110);
        g.drawString("Fanta:"+exp.getDepositoFanta().size(),x+30,y+140);
        g.drawString("snicker:"+exp.getDepositoSnickers().size(),x+30,y+170);
        g.drawString("Super8:"+exp.getDepositoSuper8().size(),x+30,y+200);
    }
}