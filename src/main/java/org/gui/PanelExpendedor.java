package org.gui;

import java.awt.*;
import org.logica.Expendedor;

public class PanelExpendedor {
    private int x;
    private int y;
    private Expendedor exp;
    private int saldo=0;


    public PanelExpendedor(int x, int y,Expendedor exp) {
        this.x = x;
        this.y = y;
        this.exp = exp;

    }

    public void dibujar(Graphics g, int saldo) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 400, 600);

        g.setColor(Color.WHITE);
        g.drawRect(x, y, 450, 600);
        g.drawString("EXPENDEDOR", x + 140, y + 30);
        g.drawString("CocaCola:"+exp.getDepositoCoca().size(),x+30,y+80);
        g.drawString("Sprite:"+exp.getDepositoSprite().size(),x+30,y+110);
        g.drawString("Fanta:"+exp.getDepositoFanta().size(),x+30,y+140);
        g.drawString("Snicker:"+exp.getDepositoSnickers().size(),x+30,y+170);
        g.drawString("Super8:"+exp.getDepositoSuper8().size(),x+30,y+200);
        g.drawString("Saldo:  $"+ saldo,x+250,y+80);
        g.setColor(Color.white);
        g.drawRect(x+250,y+450,120,80);
        g.drawString("Entrega",x+270,y+470);
        if(exp.getProductoComprado()!=null) {
            g.drawString(
                    exp.getProductoComprado().getClass().getSimpleName(),x+260,y+510
            );
        }
    }
}