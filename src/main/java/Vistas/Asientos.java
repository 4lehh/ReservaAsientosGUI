package Vistas;

import javax.swing.*;

public class Asientos extends JFrame {
    private PanelAsientos panel_asientos;

    public Asientos(){
        panel_asientos = new PanelAsientos(36);
        this.add(panel_asientos);
    }

    public void mostrarAsientos(){
        // -------------- Visualizacion ventana --------------
        this.setSize(320,720);
        this.setTitle("Asientos");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
