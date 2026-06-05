package org.gui;
import javax.swing.*;
import java.awt.*;
import org.logica.Expendedor;

/**
 * Panel gráfico que representa al expendedor en la interfaz.
 * Muestra los depósitos de productos, monedas y el área de entrega.
 */
public class PanelExpendedor {
    private int x;
    private int y;
    private Expendedor exp;
    private int saldo=0;
    private Image moneda100Img;
    private Image cocaImg;
    private Image spriteImg;
    private Image fantaImg;
    private Image snickersImg;
    private Image super8Img;
    private Image moneda500Img;

    /**
     * Constructor del PanelExpendedor.
     * @param x coordenada x del panel
     * @param y coordenada y del panel
     * @param exp referencia al expendedor
     */
    public PanelExpendedor(int x, int y,Expendedor exp) {
        this.x = x;
        this.y = y;
        this.exp = exp;
        cocaImg = new ImageIcon("src/main/java/org/gui/CocaCola.png").getImage();
        fantaImg = new ImageIcon("src/main/java/org/gui/Fanta.png").getImage();
        super8Img = new ImageIcon("src/main/java/org/gui/Super8.png").getImage();
        spriteImg = new ImageIcon("src/main/java/org/gui/Sprite.png").getImage();
        snickersImg = new ImageIcon("src/main/java/org/gui/Snicker.png").getImage();
        moneda100Img = new ImageIcon("src/main/java/org/gui/moneda.png").getImage();
        moneda500Img = new ImageIcon("src/main/java/org/gui/moneda500.png").getImage();
    }
    private void dibujardeposito(Graphics g, String nombre, Image img,int cantidad,int posicion_y) {
        g.setColor(Color.white);
        g.drawRect(x+20,y+posicion_y,170,55);
        g.drawString(nombre,x+25,y+posicion_y+15);
        for (int i = 0; i<cantidad; i++) {
            int posicion_x= x+25+i*25;
            int imagenY= y+posicion_y+20;
            if (nombre.equals("Snicker")||nombre.equals("Super8")) {
                g.drawImage(img,posicion_x,imagenY+10,35,15,null);
            }
            else{
                g.drawImage(img,posicion_x,imagenY,22,32,null);
            }
        }
    }
    private void dibujarMonedas(Graphics g, Image moneda, int cantidad, int posX, int posY) {
        for (int i = 0; i < cantidad; i++) {
            int fila = i / 5;
            int columna = i % 5;
            g.drawImage(moneda,
                    posX + columna * 25,
                    posY + fila * 25,
                    25,
                    25,
                    null);
        }
    }
    private Image obtenerImagenProducto(String nombre) {
        switch (nombre) {
            case "CocaCola": return cocaImg;
            case "Sprite": return spriteImg;
            case "Fanta": return fantaImg;
            case "Snickers": return snickersImg;
            case "Super8": return super8Img;
            default: return null;
        }
    }
    private void dibujarProducto(Graphics g, String nombre, Image img, int posX, int posY) {
        if (nombre.equals("Snickers") || nombre.equals("Super8")) {
            g.drawImage(img, posX, posY, 130, 50, null);
        } else {
            g.drawImage(img, posX, posY, 70, 110, null);
        }
    }

    /**
     * Dibuja el expendedor con sus depósitos y monedas.
     * @param g contexto gráfico
     * @param saldo saldo actual
     * @param vuelto vuelto disponible
     */
    public void dibujar(Graphics g, int saldo,int vuelto) {
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
        g.drawString("Vuelto: $" + vuelto, x + 250, y + 110);
        g.drawString("Monedas vuelto:",x+250,y+140);
        int monedas500 = vuelto / 500;
        int resto = vuelto % 500;
        int monedas100 = resto / 100;
        dibujarMonedas(g, moneda500Img, monedas500, x + 250, y + 155);
        dibujarMonedas(g, moneda100Img, monedas100, x + 250, y + 220);
        g.setColor(Color.white);
        g.drawRect(x + 220, y + 380, 160, 140);
        g.drawString("Entrega", x + 270, y + 400);

        if (exp.getProductoComprado() != null) {
            String nombre = exp.getProductoComprado().getClass().getSimpleName();
            Image imgProducto = obtenerImagenProducto(nombre);
            dibujarProducto(g, nombre, imgProducto, x + 235, y + 405);
        }

        dibujardeposito(g, "CocaCola", cocaImg, exp.getDepositoCoca().size(), 230);
        dibujardeposito(g, "Sprite", spriteImg, exp.getDepositoSprite().size(), 290);
        dibujardeposito(g, "Fanta", fantaImg, exp.getDepositoFanta().size(), 350);
        dibujardeposito(g, "Snicker", snickersImg, exp.getDepositoSnickers().size(), 410);
        dibujardeposito(g, "Super8", super8Img, exp.getDepositoSuper8().size(), 470);

}}