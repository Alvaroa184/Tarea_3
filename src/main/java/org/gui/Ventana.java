package org.gui;

import javax.swing.*;

/**
 * Ventana principal de la aplicación.
 * Crea y muestra la interfaz gráfica del expendedor.
 */
public class Ventana extends JFrame {

    /**
     * Constructor que configura y muestra la ventana principal.
     */
    public Ventana() {
        setTitle("Expendedor");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new PanelPrincipal());

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}