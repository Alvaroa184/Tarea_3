package org.gui;

import org.logica.Expendedor;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Panel gráfico que representa al comprador en la interfaz.
 * Muestra el monedero y el inventario de productos del comprador.
 */
public class PanelComprador {
    private int x;
    private int y;
    private Expendedor exp;
    private Image moneda100Img;
    private Image cocaImg;
    private Image spriteImg;
    private Image fantaImg;
    private Image snickersImg;
    private Image super8Img;
    private Image moneda500Img;

    /**
     * Constructor del PanelComprador.
     * @param x coordenada x del panel
     * @param y coordenada y del panel
     * @param exp referencia al expendedor
     */
    public PanelComprador(int x, int y, Expendedor exp) {
        this.x = x;
        this.y = y;
        this.exp = exp;
        moneda100Img = new ImageIcon("src/main/java/org/gui/moneda.png").getImage();
        cocaImg = new ImageIcon("src/main/java/org/gui/CocaCola.png").getImage();
        fantaImg = new ImageIcon("src/main/java/org/gui/Fanta.png").getImage();
        spriteImg = new ImageIcon("src/main/java/org/gui/Sprite.png").getImage();
        snickersImg = new ImageIcon("src/main/java/org/gui/Snicker.png").getImage();
        super8Img = new ImageIcon("src/main/java/org/gui/Super8.png").getImage();
        moneda500Img = new ImageIcon("src/main/java/org/gui/moneda500.png").getImage();
    }
    private void dibujarProductoInventario(Graphics g, String nombre, Image img, int posX, int posY) {
        if (nombre.equals("Snickers") || nombre.equals("Super8")) {
            g.drawImage(img, posX, posY + 25, 35, 15, null);
        } else {
            g.drawImage(img, posX, posY, 22, 40, null);
        }
    }
    private Image obtenerImagenProducto(String nombre) {
        switch (nombre) {
            case "Coca Cola": return cocaImg;
            case "Sprite": return spriteImg;
            case "Fanta": return fantaImg;
            case "Snickers": return snickersImg;
            case "Super8": return super8Img;
            default: return null;
        }
    }
    private void dibujarMonedas(Graphics g, Image moneda, int cantidad, int posX, int posY) {
        for (int i = 0; i < cantidad; i++) {
            int fila = i / 8;
            int columna = i % 8;
            g.drawImage(moneda,
                    posX + columna * 25,
                    posY + fila * 25,
                    25,
                    25,
                    null);
        }
    }

    /**
     * Dibuja el comprador con su monedero e inventario.
     * @param g contexto gráfico
     * @param saldo saldo actual del comprador
     * @param inventario lista de productos del comprador
     */
    public void dibujar(Graphics g, int saldo, ArrayList<String> inventario) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 400, 600);
        g.setColor(Color.WHITE);
        g.drawString("COMPRADOR", x + 155, y + 30);
        g.drawString("Monedero", x + 165, y + 270);
        g.drawRect(x + 60, y + 290, 280, 90);
        int monedas500 = saldo / 500;
        int resto = saldo % 500;
        int monedas100 = resto / 100;
        g.drawString("$500", x + 70, y + 315);
        dibujarMonedas(g, moneda500Img, monedas500, x + 120, y + 300);
        g.drawString("$100", x + 70, y + 355);
        dibujarMonedas(g, moneda100Img, monedas100, x + 120, y + 340);
        g.drawString("Inventario", x + 165, y + 420);
        g.drawRect(x + 60, y + 440, 280, 150);
        for (int i = 0; i < inventario.size(); i++) {
            String nombre = inventario.get(i);
            int fila = i / 8;
            int columna = i % 8;
            dibujarProductoInventario(g, nombre, obtenerImagenProducto(nombre), x + 65 + columna * 33, y + 450 + fila * 50);
        }
        }
    }
