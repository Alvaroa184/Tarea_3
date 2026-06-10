package org.gui;
import javax.swing.*;
import java.awt.*;
import org.logica.Expendedor;
import org.logica.Producto;
import org.logica.Deposito;
import org.logica.Moneda;

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
        super8Img = new ImageIcon("src/main/java/org/gui/super8.png").getImage();
        spriteImg = new ImageIcon("src/main/java/org/gui/Sprite.png").getImage();
        snickersImg = new ImageIcon("src/main/java/org/gui/Snicker.png").getImage();
        moneda100Img = new ImageIcon("src/main/java/org/gui/moneda.png").getImage();
        moneda500Img = new ImageIcon("src/main/java/org/gui/moneda500.png").getImage();
    }
    private void dibujardeposito(Graphics g, String nombre, Image img, Deposito<Producto> deposito, int posicion_y) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(173, 216, 230, 60));
        g2.fillRoundRect(x + 20, y + posicion_y, 170, 55, 10, 10);
        g2.setColor(new Color(18, 19, 21, 150));
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(x + 20, y + posicion_y, 170, 55, 10, 10);
        g2.dispose();
        g.setColor(Color.BLACK);
        g.drawString(nombre, x + 25, y + posicion_y + 15);

        for (int i = 0; i < deposito.size(); i++) {
            Producto p = deposito.getElemento(i);
            int posicion_x = x + 25 + i * 25;
            int imagenY = y + posicion_y + 20;

            p.setXY(posicion_x, imagenY);

            if (nombre.contains("Snicker") || nombre.contains("Super8")) {
                g.drawImage(img, p.getX(), p.getY() + 10, 35, 15, null);
            } else {
                g.drawImage(img, p.getX(), p.getY(), 22, 32, null);
            }
        }
    }

    private void dibujarMonedas(Graphics g, Image moneda, Deposito<Moneda> deposito, int cantidad, int posX, int posY) {
        for (int i = 0; i < deposito.size(); i++) {
            Moneda m = deposito.getElemento(i);
            if(m.getValor() == cantidad){
                int fila = i / 5;
                int columna = i % 5;

                int posicion_x = posX + columna * 25;
                int imagenY = posY + fila * 25;

                m.setXY(posicion_x, imagenY);
                g.drawImage(moneda, m.getX(), m.getY(), 25, 25, null);
            }
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
        g.setColor(new Color(200, 40, 40));
        g.fillRect(x, y, 400, 600);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 400, 600);
        g.setFont(g.getFont().deriveFont(Font.BOLD, 14f));
        g.drawString("EXPENDEDOR", x + 140, y + 30);
        g.drawString("Stock de productos", x + 30, y + 60);
        g.drawString("CocaCola: " + exp.getDepositoCoca().size(), x + 30, y + 90);
        g.drawString("Sprite: " + exp.getDepositoSprite().size(), x + 30, y + 115);
        g.drawString("Fanta: " + exp.getDepositoFanta().size(), x + 30, y + 140);
        g.drawString("Snicker: " + exp.getDepositoSnickers().size(), x + 30, y + 165);
        g.drawString("Super8: " + exp.getDepositoSuper8().size(), x + 30, y + 190);
        g.drawString("Saldo:  $" + saldo, x + 250, y + 80);
        g.drawString("Vuelto: $" + vuelto, x + 250, y + 110);
        g.drawString("Monedas vuelto:", x + 250, y + 140);

        dibujarMonedas(g, moneda500Img, exp.getDepositoVuelto(), 500, x + 250, y + 155);
        dibujarMonedas(g, moneda100Img, exp.getDepositoVuelto(), 100, x + 250, y + 220);

        Graphics2D g2e = (Graphics2D) g.create();
        g2e.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2e.setColor(new Color(173, 216, 230, 60));
        g2e.fillRoundRect(x + 220, y + 380, 160, 140, 10, 10);
        g2e.setColor(new Color(24, 24, 26, 150));
        g2e.setStroke(new BasicStroke(2));
        g2e.drawRoundRect(x + 220, y + 380, 160, 140, 10, 10);
        g2e.dispose();
        g.setColor(Color.BLACK);
        g.drawString("Entrega", x + 270, y + 400);

        if (exp.getProductoComprado() != null) {
            String nombre = exp.getProductoComprado().getClass().getSimpleName();
            Image imgProducto = obtenerImagenProducto(nombre);
            dibujarProducto(g, nombre, imgProducto, x + 235, y + 405);
        }

        dibujardeposito(g, "CocaCola $1400", cocaImg, exp.getDepositoCoca(), 230);
        dibujardeposito(g, "Sprite $900", spriteImg, exp.getDepositoSprite(), 290);
        dibujardeposito(g, "Fanta $1000", fantaImg, exp.getDepositoFanta(), 350);
        dibujardeposito(g, "Snicker $1200", snickersImg, exp.getDepositoSnickers(), 410);
        dibujardeposito(g, "Super8 $700", super8Img, exp.getDepositoSuper8(), 470);
    }
}