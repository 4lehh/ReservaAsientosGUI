package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipalFormulario extends JPanel {
    PanelDatos panelDatos;
    PanelPaisaje panelPaisaje;


    public PanelPrincipalFormulario(){
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(157, 105, 217));
        this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
        this.setOpaque(false);

        panelDatos = new PanelDatos();
        panelPaisaje = new PanelPaisaje();
        this.add(panelDatos, BorderLayout.WEST);
        this.add(panelPaisaje, BorderLayout.CENTER);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

    }
}