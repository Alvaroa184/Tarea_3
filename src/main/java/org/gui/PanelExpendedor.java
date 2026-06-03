package org.gui;
import javax.swing.*;
import java.awt.*;
import org.logica.Expendedor;

public class PanelExpendedor {
    private int x;
    private int y;
    private Expendedor exp;
    private int saldo=0;
    private Image monedaImg;
    private Image cocaImg;
    private Image spriteImg;
    private Image fantaImg;
    private Image snickersImg;
    private Image super8Img;


    public PanelExpendedor(int x, int y,Expendedor exp) {
        this.x = x;
        this.y = y;
        this.exp = exp;
        cocaImg = new ImageIcon("src/main/java/org/gui/CocaCola.png").getImage();
        fantaImg = new ImageIcon("src/main/java/org/gui/Fanta.png").getImage();
        super8Img = new ImageIcon("src/main/java/org/gui/Super8.png").getImage();
        spriteImg = new ImageIcon("src/main/java/org/gui/Sprite.png").getImage();
        snickersImg = new ImageIcon("src/main/java/org/gui/Snicker.png").getImage();
        monedaImg = new ImageIcon("src/main/java/org/gui/moneda.png").getImage();
        System.out.println("CocaCola: " + cocaImg);

        System.out.println("Fanta: " + fantaImg);
        System.out.println("Sprite: " + spriteImg);
        System.out.println("Snicker: " + snickersImg);
        System.out.println("Super8: " + super8Img);
    }

    public void dibujar(Graphics g, int saldo,int vuelto) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 400, 600);
        int cantidadMonedas=vuelto/100;

        g.setColor(Color.WHITE);
        g.drawRect(x, y, 450, 600);
        g.drawString("EXPENDEDOR", x + 140, y + 30);
        g.drawString("CocaCola:"+exp.getDepositoCoca().size(),x+30,y+80);
        g.drawString("Sprite:"+exp.getDepositoSprite().size(),x+30,y+110);
        g.drawString("Fanta:"+exp.getDepositoFanta().size(),x+30,y+140);
        g.drawString("Snicker:"+exp.getDepositoSnickers().size(),x+30,y+170);
        g.drawString("Super8:"+exp.getDepositoSuper8().size(),x+30,y+200);
        g.drawString("Saldo:  $"+ saldo,x+250,y+80);
        g.drawString("Vuelto: $" + vuelto, x + 250, y + 110);
        g.drawString("Monedas vuelto:",x+250,y+140);
        for(int i=0;i<cantidadMonedas;i++){
            int fila= i/5;
            int columna= i%5;
            g.drawImage(monedaImg,x+250+columna*25,y+155+fila*25,25,25,null);
        }
        g.setColor(Color.white);
        g.drawRect(x + 220, y + 380, 160, 140);
        g.drawString("Entrega", x + 270, y + 400);
        if (exp.getProductoComprado() != null) {
            String nombre = exp.getProductoComprado().getClass().getSimpleName();

            Image imgProducto = null;

            if (nombre.equals("CocaCola")) {
                imgProducto = cocaImg;
            } else if (nombre.equals("Sprite")) {
                imgProducto = spriteImg;
            } else if (nombre.equals("Fanta")) {
                imgProducto = fantaImg;
            } else if (nombre.equals("Snickers")) {
                imgProducto = snickersImg;
            } else if (nombre.equals("Super8")) {
                imgProducto = super8Img;
            }

            if(nombre.equals("Snickers") || nombre.equals("Super8")) {
                g.drawImage(imgProducto,
                        x + 235,
                        y + 440,
                        130,
                        50,
                        null);
            }
            else {
                g.drawImage(imgProducto,
                        x + 265,
                        y + 405,
                        70,
                        110,
                        null);
            }

        }
}}