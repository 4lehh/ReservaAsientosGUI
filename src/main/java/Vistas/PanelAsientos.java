package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import Modelo.*;

public class PanelAsientos extends JPanel  {

    // -------------- BG -----------------
    private BufferedImage bg_piso1;
    private BufferedImage bg_piso2;

    // --------- Panel -------------
    private JPanel panel_grilla;

    // ------------- Enteros -------------
    private int salto_y = 0;


    public PanelAsientos(Buses bus_disponibles) {

        // -------------- Configurar Panel ---------------------
        this.setLayout(null);
        this.setOpaque(false);


        // --------- Panel Grilla ----------------
        panel_grilla = new JPanel();
        panel_grilla.setLayout(null);
        panel_grilla.setBounds(42,145,240,520);
        panel_grilla.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
        panel_grilla.setOpaque(false);


        // --------------- BG --------------------
        try{
            bg_piso1 = ImageIO.read(new File("./src/main/resources/Imagenes/bus-1.png"));
            bg_piso2 = ImageIO.read(new File("./src/main/resources/Imagenes/bus-2.png"));

        } catch (IOException e){
            System.out.println(e);
        }

        // ----------------  Creacion botones enumerados + agregar al panel----------------
        int contador = 0;

        for(JButton botones_buses : bus_disponibles.tipoAsientos()){
            panel_grilla.add(botones_buses);
        }

        this.add(panel_grilla);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(bg_piso1 != null){
            Image escalada = bg_piso1.getScaledInstance(320, 720, Image.SCALE_SMOOTH);
            g2d.drawImage(escalada, 0,0,this);
        }


    }



}
