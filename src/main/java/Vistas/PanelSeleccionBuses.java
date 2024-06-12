package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelSeleccionBuses extends JPanel implements ActionListener {
    Asientos asientos;

    JPanel panel_superior;
    JPanel panel_inferior;

    JPanel panel_opciones;
    JPanel panel_imagen;
    Font font = new Font("Arial", Font.BOLD, 16);

    String origen;
    String destino;
    String fecha;
    String nombre;

    JButton boton_seleccionar;

    PanelPaisaje panelPaisaje;
    BufferedImage bg;
    public PanelSeleccionBuses(String nombre, String origen, String destino, String fecha, PanelPaisaje panelPaisaje){
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.nombre = nombre;
        this.panelPaisaje = panelPaisaje;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.PINK);
        // this.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        this.setBounds(0,0, 500,0);

        asientos = new Asientos();

        panel_superior = new JPanel();
        configurarPanel(1);


        panel_inferior = new JPanel();
        configurarPanel(2);

        panel_opciones = new JPanel();
        configurarPanel(3);

        panel_imagen = new JPanel();
        configurarPanel(4);

        boton_seleccionar = new JButton("Seleccionar asiento");
        boton_seleccionar.setFocusable(false);
        panel_opciones.add(boton_seleccionar);
        boton_seleccionar.setBounds(75,210,200,40);
        boton_seleccionar.addActionListener(this);

        //-----AQUI SE PUEDE MODIFICAR DEPENDIENDO DE LA RUTA
        try{
            bg = ImageIO.read(new File("./src/main/java/Vistas/Imagenes/prueba_bus.png"));
        } catch (IOException e){
            System.out.println(e);
        }
        panelPaisaje.cambiarImagen(bg);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_seleccionar){
            asientos.mostrarAsientos();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }

    public void configurarPanel(int i){
        if(i == 1){
            panel_superior.setLayout(new BorderLayout());
            panel_superior.setPreferredSize(new Dimension(0, 75));
            panel_superior.setBackground(new Color(115, 102, 102));
            // panel_superior.setBorder(BorderFactory.createLineBorder(Color.GREEN));
            JLabel titulo = new JLabel("Selección de bus", SwingConstants.CENTER);
            titulo.setFont(new Font("Arial", Font.BOLD, 24));
            titulo.setForeground(Color.WHITE);
            panel_superior.add(titulo, BorderLayout.CENTER);
            this.add(panel_superior, BorderLayout.NORTH);
        }

        if(i == 2){
            panel_inferior.setBackground(Color.PINK);
            // panel_inferior.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            panel_inferior.setLayout(new BorderLayout());
            this.add(panel_inferior, BorderLayout.CENTER);
        }

        if(i == 3){
            panel_opciones.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
            panel_opciones.setLayout(null);
            panel_opciones.setOpaque(false);
            panel_opciones.setPreferredSize(new Dimension(320, 0));
            panel_inferior.add(panel_opciones, BorderLayout.WEST);

            JLabel recorrido = new JLabel(origen + " - " + destino);
            recorrido.setFont(font);
            recorrido.setBounds(75,30, 250,40);
            panel_opciones.add(recorrido);

            JLabel nombre_label = new JLabel("Hola, " + nombre);
            nombre_label.setFont(font);
            nombre_label.setBounds(75,90, 250,40);
            panel_opciones.add(nombre_label);

            JLabel fecha_label = new JLabel(fecha);
            fecha_label.setFont(font);
            fecha_label.setBounds(75,150, 150,40);
            panel_opciones.add(fecha_label);
        }

        if(i == 4){
            panel_imagen.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            panel_imagen.setOpaque(false);
            panel_inferior.add(panel_imagen, BorderLayout.CENTER);
        }
    }
}
