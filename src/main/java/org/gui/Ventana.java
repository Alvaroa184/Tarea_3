package org.gui;
import javax.swing.*;

public class Ventana extends JFrame {
    public Ventana() {
        setTitle("Expendedor");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        PanelPrincipal pc = new PanelPrincipal();
        add(pc);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
