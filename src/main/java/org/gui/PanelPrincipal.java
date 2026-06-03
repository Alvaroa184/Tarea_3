package org.gui;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal() {
        setBackground(Color.WHITE);
        exp = new PanelExpendedor(100, 50);
        com = new PanelComprador(600, 50);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        exp.dibujar(g);
        com.dibujar(g);
    }
}