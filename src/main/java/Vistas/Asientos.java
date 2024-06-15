package Vistas;

import Modelo.Buses;

import javax.swing.*;
import java.util.ArrayList;

public class Asientos extends JFrame {
    private PanelAsientos panel_asientos;

    public Asientos(ArrayList<Buses> buses){
        panel_asientos = new PanelAsientos(buses);
        this.add(panel_asientos);
    }

    public void mostrarAsientos(){
        // -------------- Visualizacion ventana --------------
        this.setSize(320,720);
        this.setTitle("Asientos");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
