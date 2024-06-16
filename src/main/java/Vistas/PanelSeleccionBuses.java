package Vistas;

import Modelo.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class PanelSeleccionBuses extends JPanel implements ActionListener {
    Asientos asientos;

    JPanel panel_superior;
    JPanel panel_opciones;
    Font font = new Font("Arial", Font.BOLD, 16);

    String ruta_final;
    String fecha;
    String nombre;
    int precio_ruta;

    JButton boton_seleccionar;

    PanelPaisaje panelPaisaje;
    BufferedImage bg;

    PanelesFactory panelesFactory;

    ArrayList<Buses> buses;
    ArrayList<JPanel> paneles;
    ArrayList<JRadioButton> botones_buses;
    ButtonGroup buttonGroup;
    public PanelSeleccionBuses(String nombre, String ruta_final, String fecha, PanelPaisaje panelPaisaje, ArrayList<Buses> buses, int precio_ruta){
        this.ruta_final = ruta_final;
        this.fecha = fecha;
        this.nombre = nombre;
        this.buses = buses;
        this.panelPaisaje = panelPaisaje;
        this.precio_ruta = precio_ruta;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.PINK);
        // this.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        this.setBounds(0,0, 500,0);


        asientos = new Asientos(buses);

        panel_superior = new JPanel();
        configurarPanel(1);

        panel_opciones = new JPanel();
        configurarPanel(2);


        //-----AQUI SE PUEDE MODIFICAR DEPENDIENDO DE LA RUTA
        backgroundRuta(ruta_final);

        panelesFactory = new PanelesFactory();

        paneles = new ArrayList<JPanel>();
        paneles = panelesFactory.crearPaneles(buses, precio_ruta);

        botones_buses = new ArrayList<JRadioButton>();
        buttonGroup = new ButtonGroup();

        for(JPanel panel : paneles){
            JRadioButton seleccionar = new JRadioButton("Seleccionar Bus");
            seleccionar.addActionListener(this);
            seleccionar.setFocusable(false);
            seleccionar.setBounds(400, 50, 140,40);
            botones_buses.add(seleccionar);
            buttonGroup.add(seleccionar);

            panel.add(seleccionar);
            panel_opciones.add(panel);
        }

        boton_seleccionar = new JButton("Seleccionar asiento");
        boton_seleccionar.setFocusable(false);
        panel_opciones.add(boton_seleccionar);
        boton_seleccionar.setBounds(200,210,200,40);
        boton_seleccionar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(JRadioButton boton : botones_buses){
            if (e.getSource() == boton){
                asientos.mostrarAsientos();
            }
        }

        if (e.getSource() == boton_seleccionar){
            asientos.mostrarAsientos();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }

    public void configurarPanel(int i) {
        if (i == 1) {
            panel_superior.setLayout(new BorderLayout());
            panel_superior.setPreferredSize(new Dimension(0, 75));
            panel_superior.setBackground(new Color(115, 102, 102));
            // panel_superior.setBorder(BorderFactory.createLineBorder(Color.GREEN));
            JLabel titulo = new JLabel("Selección de bus", SwingConstants.CENTER);
            titulo.setFont(new Font("Arial", Font.BOLD, 24));
            titulo.setForeground(Color.WHITE);
            panel_superior.add(titulo);

            JLabel label_ruta = new JLabel(ruta_final, SwingConstants.CENTER);
            label_ruta.setFont(new Font("Arial", Font.BOLD, 24));
            label_ruta.setForeground(Color.WHITE);
            panel_superior.add(label_ruta, BorderLayout.SOUTH);
            this.add(panel_superior, BorderLayout.NORTH);
        }

        if (i == 2) {
            panel_opciones.setLayout(new BoxLayout(panel_opciones, BoxLayout.Y_AXIS));
            panel_opciones.setOpaque(false);
            panel_opciones.setPreferredSize(new Dimension(550, 0));
            this.add(panel_opciones, BorderLayout.CENTER);

        }
    }

    public void backgroundRuta(String ruta_final){
        if(ruta_final.equals("Angol - Chiguayante") || ruta_final.equals("Chiguayante - Angol")){
            try{
                bg = ImageIO.read(new File("./src/main/java/Vistas/Imagenes/paisaje angol-chigua.png"));
            } catch (IOException e){
                System.out.println(e);
            }
        }
        if(ruta_final.equals("Angol - Concepcion") || ruta_final.equals("Concepcion - Angol")){
            try{
                bg = ImageIO.read(new File("./src/main/java/Vistas/Imagenes/paisaje angol-conce.png"));
            } catch (IOException e){
                System.out.println(e);
            }

        }
        if(ruta_final.equals("Angol - Nacimiento") || ruta_final.equals("Nacimiento - Angol")){
            try{
                bg = ImageIO.read(new File("./src/main/java/Vistas/Imagenes/paisaje angol-nacimiento.png"));
            } catch (IOException e){
                System.out.println(e);
            }

        }
        if(ruta_final.equals("Angol - Santa Juana") || ruta_final.equals("Santa Juana - Angol")){
            try{
                bg = ImageIO.read(new File("./src/main/java/Vistas/Imagenes/paisaje angol-santajuana.png"));
            } catch (IOException e){
                System.out.println(e);
            }

        }
        if(ruta_final.equals("Chiguayante - Nacimiento") || ruta_final.equals("Nacimiento - Chiguayante")){
            try{
                bg = ImageIO.read(new File("./src/main/java/Vistas/Imagenes/paisaje chigua-nacimiento.png"));
            } catch (IOException e){
                System.out.println(e);
            }

        }
        if(ruta_final.equals("Chiguayante - Santa Juana") || ruta_final.equals("Santa Juana - Chiguayante")){
            try{
                bg = ImageIO.read(new File("./src/main/java/Vistas/Imagenes/paisaje chigua-nacimiento.png"));
            } catch (IOException e){
                System.out.println(e);
            }

        }
        if(ruta_final.equals("Concepcion - Chiguayante") || ruta_final.equals("Chiguayante - Concepcion") ){
            try{
                bg = ImageIO.read(new File("./src/main/java/Vistas/Imagenes/paisaje conce-chigua.png"));
            } catch (IOException e){
                System.out.println(e);
            }
        }
        if(ruta_final.equals("Concepcion - Nacimiento") || ruta_final.equals("Nacimiento - Concepcion")){
            try{
                bg = ImageIO.read(new File("./src/main/java/Vistas/Imagenes/paisaje conce-nacimiento.png"));
            } catch (IOException e){
                System.out.println(e);
            }
        }
        if(ruta_final.equals("Concepcion - Santa Juana") || ruta_final.equals("Santa Juana - Concepcion")){
            try{
                bg = ImageIO.read(new File("./src/main/java/Vistas/Imagenes/paisaje conce-santajuana.png"));
            } catch (IOException e){
                System.out.println(e);
            }

        }
        if(ruta_final.equals("Santa Juana - Nacimiento") || ruta_final.equals("Nacimiento - Santa Juana")){
            try{
                bg = ImageIO.read(new File("./src/main/java/Vistas/Imagenes/paisaje santajuana-nacimiento.png"));
            } catch (IOException e){
                System.out.println(e);
            }
        }

        panelPaisaje.cambiarImagen(bg);
    }


}
