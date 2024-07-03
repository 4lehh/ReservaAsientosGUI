package Vistas;

import Modelo.Buses;

import javax.swing.*;
import java.awt.*;

public class VentanaAsientos extends JFrame {
    private PanelAsientos panel_asientos;

    public VentanaAsientos(Buses bus_disponible, String nombre, String fecha, String ruta_final, int precio_ruta){
        this.setLayout(null);


        panel_asientos = new PanelAsientos(bus_disponible, nombre, fecha, ruta_final, precio_ruta);
        panel_asientos.setBounds(0,0,600,750);
        this.add(panel_asientos);


    }

    public void mostrarAsientos(){
        // -------------- Visualizacion ventana --------------
        this.setSize(600,750);
        this.setTitle("Asientos");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }
}
