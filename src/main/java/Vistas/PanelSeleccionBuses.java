package Vistas;

import Modelo.PanelesFactory;
import Modelo.Rutas;

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
    Font font = new Font("Arial", Font.BOLD, 16);

    String ruta_final;
    String fecha;
    String nombre;

    JButton boton_seleccionar;

    PanelPaisaje panelPaisaje;
    BufferedImage bg;

    PanelesFactory panelesFactory;
    public PanelSeleccionBuses(String nombre, String ruta_final, String fecha, PanelPaisaje panelPaisaje){
        this.ruta_final = ruta_final;
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


        boton_seleccionar = new JButton("Seleccionar asiento");
        boton_seleccionar.setFocusable(false);
        panel_opciones.add(boton_seleccionar);
        boton_seleccionar.setBounds(75,210,200,40);
        boton_seleccionar.addActionListener(this);

        //-----AQUI SE PUEDE MODIFICAR DEPENDIENDO DE LA RUTA
        backgroundRuta(ruta_final);

        panelesFactory = new PanelesFactory();
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
            panel_opciones.setPreferredSize(new Dimension(500, 0));
            panel_inferior.add(panel_opciones, BorderLayout.WEST);

            JLabel recorrido = new JLabel(ruta_final);
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
