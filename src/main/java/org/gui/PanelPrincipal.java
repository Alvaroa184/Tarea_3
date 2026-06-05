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
        crearBotonMoneda("$100", 800, 100, 100);
        crearBotonMoneda("$500", 800, 140, 500);
        crearBotonMoneda("$1000", 800, 180, 1000);
        crearBotonMoneda("$1500", 800, 220, 1500);
        crearBotonProducto("Coca Cola", 650, 100, TipoProducto.COCACOLA,1400);
        crearBotonProducto("Sprite", 650, 140, TipoProducto.SPRITE,900);
        crearBotonProducto("Fanta", 650, 180, TipoProducto.FANTA,1000);
        crearBotonProducto("Snickers", 650, 220, TipoProducto.SNICKERS,1200);
        crearBotonProducto("Super8", 650, 260, TipoProducto.SUPER8,700);
}
    private JButton crearBotonProducto(String nombre, int x, int y, TipoProducto tipo,int precio) {
        JButton boton = new JButton(nombre);
        boton.setBounds(x, y, 120, 30);
        boton.addActionListener(e -> {
            try {
                if(saldo<precio) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                    return;
                }
                exp.comprarProducto(new Moneda1500(), tipo);
                inventario.add(nombre);
                vuelto =saldo-precio;
                saldo =0;
                repaint();
                JOptionPane.showMessageDialog(this, "Producto Comprado");
            } catch (PagoInsuficienteException ex){
                JOptionPane.showMessageDialog(this, "Pago insuficiente");
            } catch (NoHayProductoException ex) {
                JOptionPane.showMessageDialog(this,"No hay stock de este producto");
            }catch (PagoIncorrectoException ex){
                JOptionPane.showMessageDialog(this,"Debe ingresar dinero");
            }catch (Exception ex){
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