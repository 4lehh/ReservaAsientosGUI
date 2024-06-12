package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSeleccionBuses extends JPanel implements ActionListener {
    JPanel panel_opciones;
    JPanel panel_imagen;
    Font font = new Font("Arial", Font.BOLD, 16);

    String origen;
    String destino;
    String fecha;
    public PanelSeleccionBuses(String origen, String destino, String fecha){
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        this.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        this.setBounds(50,30, 400,400);

        panel_opciones = new JPanel();
        panel_opciones.setLayout(null);
        panel_opciones.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
        panel_opciones.setPreferredSize(new Dimension(200, 400));
        this.add(panel_opciones, BorderLayout.WEST);

        JLabel titulo = new JLabel(origen + " - " + destino);
        titulo.setFont(font);
        titulo.setBounds(200,200, 100,40);
        panel_opciones.add(titulo);






        panel_imagen = new JPanel();
        panel_imagen.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        this.add(panel_imagen, BorderLayout.CENTER);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
