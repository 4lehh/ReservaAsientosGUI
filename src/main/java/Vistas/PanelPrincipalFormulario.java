package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipalFormulario extends JPanel {
    PanelDatos panelDatos;
    PanelPaisaje panelPaisaje;

    MusicPlayer musica_bg;


    public PanelPrincipalFormulario(){
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(157, 105, 217));
        // this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
        this.setOpaque(false);

        panelPaisaje = new PanelPaisaje();
        panelDatos = new PanelDatos(panelPaisaje);
        this.add(panelDatos, BorderLayout.WEST);
        this.add(panelPaisaje, BorderLayout.CENTER);

        musica_bg = new MusicPlayer();
        musica_bg.play("./src/main/resources/Sonidos/pilotwings.wav");
        musica_bg.loop();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

    }
}