package Vistas;

import Modelo.Buses;

import javax.swing.*;
import java.awt.*;

public class VentanaAsientos extends JFrame {
    private PanelAsientos panel_asientos;

    JPanel panel_cosas;
    public VentanaAsientos(Buses bus_disponible){
        this.setLayout(new BorderLayout());
        panel_asientos = new PanelAsientos(bus_disponible);
        this.add(panel_asientos, BorderLayout.CENTER);

        panel_cosas = new JPanel();
        panel_cosas.setBackground(Color.MAGENTA);
        panel_cosas.setPreferredSize(new Dimension(180, 0));

        JButton boton_random = new JButton("yow");
        panel_cosas.add(boton_random);
        boton_random.setBounds(50, 10, 30,30);

        this.add(panel_cosas, BorderLayout.EAST);

    }

    public void mostrarAsientos(){
        // -------------- Visualizacion ventana --------------
        this.setSize(500,750);
        this.setTitle("Asientos");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }
}
