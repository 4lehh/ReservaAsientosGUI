package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PanelAsientos extends JPanel {
    // ----------- Array Botones -------------
    private ArrayList<Botones_Asientos> botones;

    // -------------- BG -----------------
    private BufferedImage bg;

    // --------- Panel -------------
    private JPanel panel_grilla;

    // ------------- Enteros -------------
    private int salto_y = 0;


    public PanelAsientos(int numero_asientos) {
        // --------- Instancias --------------
        botones = new ArrayList<Botones_Asientos>();

        // -------------- Configurar Panel ---------------------
        this.setLayout(null);
        this.setOpaque(false);

        // --------- Panel Grilla ----------------
        panel_grilla = new JPanel();
        panel_grilla.setLayout(null);
        panel_grilla.setBounds(33,145,240,505);
        panel_grilla.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
        panel_grilla.setOpaque(false);


        // --------------- BG --------------------
        try{
            bg = ImageIO.read(new File("./src/main/java/Vistas/Imagenes/bus-1.png"));
        } catch (IOException e){
            System.out.println(e);
        }

        // ----------------  Creacion botones enumerados + agregar al panel----------------
        for (int i = 0; i < numero_asientos; i++) {
            switch(i%4){
                case 0:
                    botones.add(new Botones_Asientos(i + 1, 20, 20 + salto_y));
                    break;
                case 1:
                    botones.add(new Botones_Asientos(i + 1, 60, 20 + salto_y));
                    break;
                case 2:
                    botones.add(new Botones_Asientos(i + 1, 145, 20 + salto_y));
                    break;
                case 3:
                    botones.add(new Botones_Asientos(i + 1, 185, 20 + salto_y));
                    salto_y += 50;
                    break;
            }
        }
        for(Botones_Asientos button : botones){
            panel_grilla.add(button);
        }

        this.add(panel_grilla);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(bg != null){
            Image escalada = bg.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            g2d.drawImage(escalada, 0,0,this);
        }
    }



}
