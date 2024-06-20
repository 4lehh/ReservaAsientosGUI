package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import Modelo.*;

public class PanelAsientos extends JPanel implements ActionListener {

    // -------------- BG -----------------
    private BufferedImage bg_piso1;
    private BufferedImage bg_piso2;

    // --------- Panel -------------
    private JPanel panel_contenedor_grilla;
    private JPanel panel_grilla;
    private JPanel panel_info_asientos;
    private JPanel panel_asiento_prueba;

    // ------------- Enteros -------------
    private int salto_y = 0;

    private Buses buses;

    JButton boton_prueba;
    Boolean estado = false;

    JLabel label_precio;
    JLabel label_estado;
    public PanelAsientos(Buses bus_disponibles) {

        // -------------- Configurar Panel ---------------------
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.buses = bus_disponibles;

        // --------- Panel Grilla ----------------
        panel_contenedor_grilla = new JPanel();
        configurarPanel(1);

        panel_grilla = new JPanel();
        configurarPanel(2);


        // --------------- BG --------------------
        try{
            bg_piso1 = ImageIO.read(new File("./src/main/resources/Imagenes/bus-1.png"));
            bg_piso2 = ImageIO.read(new File("./src/main/resources/Imagenes/bus-2.png"));

        } catch (IOException e){
            System.out.println(e);
        }

        // ----------------  Creacion botones enumerados + agregar al panel----------------
        int contador = 0;

        // --------------------- ACTION LISTENER ----------------
        for(JButton botones_buses : buses.tipoAsientos()){
            panel_grilla.add(botones_buses);
            botones_buses.addActionListener(this);

        }

        panel_info_asientos = new JPanel();
        configurarPanel(3);

        panel_asiento_prueba = new JPanel();
        panel_asiento_prueba.setLayout(null);
        panel_asiento_prueba.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 3));
        panel_asiento_prueba.setBounds(10,80, 175,500);
        panel_info_asientos.add(panel_asiento_prueba);

        boton_prueba = new JButton("asdasd");
        boton_prueba.setFocusable(false);
        boton_prueba.setBounds(20,200, 40,40);
        boton_prueba.addActionListener(this);
        panel_asiento_prueba.add(boton_prueba);


        label_precio = new JLabel();
        label_precio.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_asiento_prueba.add(label_precio);
        label_precio.setBounds(20,5, 100, 40);

        label_estado = new JLabel();
        panel_asiento_prueba.add(label_estado);
        label_estado.setBounds(20, 50, 130, 40);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(bg_piso1 != null){
            Image escalada = bg_piso1.getScaledInstance(320, 720, Image.SCALE_SMOOTH);
            g2d.drawImage(escalada, 0,0,this);
        }

        // ESTADO DEL ASIENTO
        if(estado){
            label_estado.setText("DISPONIBLE");
            label_estado.setForeground(Color.GREEN);
        } else{
            label_estado.setText("NO DISPONIBLE");
            label_estado.setForeground(Color.RED);
        }

    }

    public void configurarPanel(int i){
        if(i == 1){
            panel_contenedor_grilla.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
            panel_contenedor_grilla.setLayout(null);
            panel_contenedor_grilla.setPreferredSize(new Dimension(300,0));
            panel_contenedor_grilla.setOpaque(false);
            this.add(panel_contenedor_grilla, BorderLayout.WEST);
        }

        if(i == 2){
            panel_grilla.setLayout(null);
            panel_grilla.setBounds(42,145,240,520);
            panel_grilla.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
            panel_grilla.setOpaque(false);
            panel_contenedor_grilla.add(panel_grilla);
        }

        if(i == 3){
            panel_info_asientos.setPreferredSize(new Dimension(150, 0));
            panel_info_asientos.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
            panel_info_asientos.setLayout(null);
            this.add(panel_info_asientos, BorderLayout.CENTER);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        boolean i = false;
        if(e.getSource() == boton_prueba){
            if(!estado){
                estado = true;
            } else{
                estado = false;
            }
            repaint();
        }

        for(JButton botones_buses : buses.tipoAsientos()){
            if(e.getSource() == botones_buses){
                System.out.println("semen");
                if(!estado){
                    estado = true;
                    label_precio.setText("kasdkasdkas");
                } else{
                    estado = false;
                    label_precio.setText("xxxx::C:C:C:C:C:");
                }
                repaint();




            }

        }

    }
}
