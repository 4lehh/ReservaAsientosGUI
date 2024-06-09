package Vistas;

import javax.swing.*;
import java.awt.*;

public class VentanaFormulario extends JFrame {
    private PanelPrincipalFormulario panelPrincipalFormulario;
    public VentanaFormulario(){
        this.setSize(1280,720);
        this.setTitle("Formulario de Usuario");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelPrincipalFormulario = new PanelPrincipalFormulario();
        this.add(panelPrincipalFormulario);
    }
}