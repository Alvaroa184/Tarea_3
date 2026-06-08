package org.gui;

import org.logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Panel principal de la interfaz gráfica.
 * Contiene el PanelExpendedor y el PanelComprador y gestiona los eventos de compra.
 */
public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor expPanel;
    private Expendedor exp;
    private int saldo=0;
    private int vuelto=0;
    private ArrayList<String>inventario =new ArrayList<>();

    /**
     * Constructor que inicializa el panel con el expendedor y comprador.
     */
    public PanelPrincipal() {
        setBackground(Color.WHITE);
        exp =new Expendedor(6);
        expPanel = new PanelExpendedor(100, 50,exp);
        com = new PanelComprador(600, 50,exp);
        setLayout(null);
        crearBotonMoneda("$100", 820, 100, 100);
        crearBotonMoneda("$500", 820, 140, 500);
        crearBotonMoneda("$1000", 820, 180, 1000);
        crearBotonMoneda("$1500", 820, 220, 1500);
        crearBotonProducto("Coca Cola", 680, 100, TipoProducto.COCACOLA, 1400);
        crearBotonProducto("Sprite", 680, 140, TipoProducto.SPRITE, 900);
        crearBotonProducto("Fanta", 680, 180, TipoProducto.FANTA, 1000);
        crearBotonProducto("Snickers", 680, 220, TipoProducto.SNICKERS, 1200);
        crearBotonProducto("Super8", 680, 260, TipoProducto.SUPER8, 700);

        configurarBotonVuelto();
    }
    private JButton crearBotonProducto(String nombre, int x, int y, TipoProducto tipo,int precio) {
        JButton boton = new JButton(nombre);
        boton.setBounds(x, y, 120, 30);
        boton.addActionListener(e -> {
            try {
                if (saldo < precio) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                    return;
                }

                Moneda monedapago = null;
                if (precio <= 500 && saldo >= 500) {
                    monedapago = new Moneda500();
                    saldo -= 500;
                } else if (precio <= 1000 && saldo >= 1000) {
                    monedapago = new Moneda1000();
                    saldo -= 1000;
                } else if (precio <= 1500 && saldo >= 1500) {
                    monedapago = new Moneda1500();
                    saldo -= 1500;
                }

                exp.comprarProducto(monedapago, tipo);
                inventario.add(nombre);

                vuelto += (monedapago.getValor() - precio);
                repaint();
                JOptionPane.showMessageDialog(this, "Producto Comprado");
            } catch (PagoInsuficienteException ex) {
                JOptionPane.showMessageDialog(this, "Pago insuficiente");
            } catch (NoHayProductoException ex) {
                JOptionPane.showMessageDialog(this, "No hay stock de este producto");
            } catch (PagoIncorrectoException ex) {
                JOptionPane.showMessageDialog(this, "Debe ingresar dinero");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        add(boton);
        return boton;
    }
    private JButton crearBotonMoneda(String texto, int x, int y, int valor) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, 100, 30);
        boton.addActionListener(e -> {
            saldo+=valor;
            repaint();
        });
        add(boton);
        return boton;
    }

    private void configurarBotonVuelto() {
        JButton botonVuelto = new JButton("Recoger Vuelto");
        botonVuelto.setBounds(680, 310, 100, 30);
        botonVuelto.addActionListener(e -> {
            if (vuelto == 0) {
                JOptionPane.showMessageDialog(this, "No tienes vuelto pendiente");
                return;
            }
            Moneda m=exp.getVuelto();
            if (m != null) {
                saldo += m.getValor();
                if (vuelto >= m.getValor()) {
                    vuelto -= m.getValor();
                } else {
                    vuelto=0;
                }
                repaint();
            } else {
                vuelto=0;
                repaint();
                JOptionPane.showMessageDialog(this, "Error: El Expendedor se quedo sin monedas fisicas para dar el vuelto");
            }
        });
        add(botonVuelto);
    }

    /**
     * Dibuja todos los componentes gráficos de la interfaz.
     * @param g contexto gráfico
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        expPanel.dibujar(g,saldo,vuelto);
        com.dibujar(g,saldo,inventario);
    }
}