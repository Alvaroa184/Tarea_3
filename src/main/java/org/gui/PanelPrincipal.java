package org.gui;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal() {
        this.setBackground(Color.WHITE);

        this.exp = new PanelExpendedor(100, 50);
        this.com = new PanelComprador(600, 50);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        exp.paintComponent(g);
        com.paintComponent(g);
    }
}