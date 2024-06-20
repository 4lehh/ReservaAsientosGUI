package Vistas;

import Modelo.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class PanelDatos extends JPanel implements ActionListener {
    // -------- Paneles ------------
    JPanel panel_superior;
    JPanel panel_inferior;
    JPanel panel_preguntas;

    JButton boton_siguiente;
    JButton boton_cualquiera;

    JTextField nombre_textfield;
    JComboBox origenComboBox;
    JComboBox destinoComboBox;
    JDateChooser dateChooser;
    //---------DATOS USUARIO------
    String nombre;
    String origen;
    String destino;
    String fecha_simple;

    // ---------- ARRAYLIST -----------------
    ArrayList<Buses> buses;

    Timer comprobar_datos;
    PanelPaisaje panelPaisaje;
    public PanelDatos(PanelPaisaje panelPaisaje){
        this.setLayout(new BorderLayout());
        // this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        this.setPreferredSize(new Dimension(550,0));
        this.setBackground(Color.CYAN);

        this.panelPaisaje = panelPaisaje;
        //------------ TITULO: DATOS------------
        panel_superior = new JPanel();
        configurarPanel(panel_superior, 1);

        //------------- PANEL CONTENEDOR DE LOS DATOS-----------
        panel_inferior = new JPanel();
        configurarPanel(panel_inferior, 2);

        //------------- CAMPOS DE TEXTO------------
        panel_preguntas = new JPanel();
        configurarPanel(panel_preguntas, 3);

        //---------NOMBRE----------
        JPanel panel_nombre = new JPanel();
        configurarPanel(panel_nombre, 4);

        //---------ORIGEN------
        JPanel panel_origen = new JPanel();
        configurarPanel(panel_origen, 5);

        //---------DESTINO--------
        JPanel panel_destino = new JPanel();
        configurarPanel(panel_destino, 6);

        //----------FECHA---------
        JPanel panel_fecha = new JPanel();
        configurarPanel(panel_fecha, 7);

        boton_siguiente = new JButton("Siguiente");
        panel_preguntas.add(boton_siguiente);
        boton_siguiente.setEnabled(false);
        boton_siguiente.setBackground(new Color(110, 105, 105, 255));
        boton_siguiente.setForeground(Color.WHITE);
        boton_siguiente.setBounds(270,380,120,40);
        boton_siguiente.addActionListener(this);

        comprobar_datos = new Timer(100, this);
        comprobar_datos.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton_siguiente){
            nombre = nombre_textfield.getText();
            origen = (String) origenComboBox.getSelectedItem();
            destino = (String) destinoComboBox.getSelectedItem();
            Date fecha_completa = dateChooser.getDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            fecha_simple = simpleDateFormat.format(fecha_completa);

            // ------------ Retornar buses -----------------
            ManejoBuses m = new ManejoBuses(nombre, origen, destino);
            buses = m.getBuses();
            String ruta_final = m.getRuta();

            LocalDate fecha_actualizada = fecha_completa.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fecha_actual = LocalDate.now();

            if(origen.equals(destino)){
                JOptionPane.showMessageDialog(this, "Debe seleccionar una ruta válida", "Ruta inválida", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (fecha_actualizada.isBefore(fecha_actual)){
                JOptionPane.showMessageDialog(this, "La fecha seleccionada es anterior a la fecha actual.", "Fecha inválida", JOptionPane.ERROR_MESSAGE);
                return;
            }

            System.out.println(fecha_simple);
            this.remove(panel_inferior);
            this.remove(panel_superior);

            int precio_ruta = m.getPrecio_ruta();

            this.add(new PanelSeleccionBuses(nombre, ruta_final, fecha_simple, panelPaisaje, buses, precio_ruta, dateChooser.getDate()));

            repaint();
            revalidate();
        }
        if(e.getSource() == comprobar_datos){
            if(!nombre_textfield.getText().isEmpty() && origenComboBox.getSelectedItem() != null && destinoComboBox.getSelectedItem() != null && dateChooser.getDate() != null){
                boton_siguiente.setEnabled(true);
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }

    public void configurarPanel(JPanel panel, int i){
        if(i == 1){ // PANEL SUPERIOR
            panel.setLayout(new BorderLayout());
            panel.setPreferredSize(new Dimension(0, 75));
            panel.setBackground(new Color(115,102,102));
            // panel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
            JLabel titulo = new JLabel("Datos", SwingConstants.CENTER);
            titulo.setFont(new Font("Arial", Font.BOLD, 24));
            titulo.setForeground(Color.WHITE);
            panel.add(titulo, BorderLayout.CENTER);
            this.add(panel, BorderLayout.NORTH);
        }

        if(i == 2){ // PANEL INFERIOR
            panel.setBackground(Color.PINK);
            // panel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            panel.setLayout(null);
            this.add(panel, BorderLayout.CENTER);
        }

        if(i == 3){ // PANEL PREGUNTAS
            panel.setOpaque(false);
            panel.setLayout(null);
            panel_inferior.add(panel);
            panel.setBounds(50,30, 450,450);
        }

        if(i == 4){ // PANEL NOMBRE
            panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0,10));
            panel.setBackground(Color.CYAN);
            panel.setBounds(0,0,450,60);
            panel_preguntas.add(panel);

            JLabel nombre_label = new JLabel("Nombre: ");
            nombre_label.setFont(new Font("Arial", Font.BOLD, 16));
            panel.add(nombre_label);

            nombre_textfield = new JTextField();
            nombre_textfield.setBackground(Color.WHITE);
            nombre_textfield.setPreferredSize(new Dimension(300,40));
            panel.add(nombre_textfield);
        }

        if(i == 5){ // PANEL ORIGEN
            panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5,10));
            panel.setBackground(Color.CYAN);
            panel.setBounds(0,100,450,60);
            panel_preguntas.add(panel);

            JLabel origen_label = new JLabel("Origen: ");
            String[] origenes = {"Angol", "Chiguayante", "Concepcion", "Nacimiento", "Santa Juana"};
            origenComboBox = new JComboBox<>(origenes);
            origen_label.setFont(new Font("Arial", Font.BOLD, 16));
            panel.add(origen_label);
            origenComboBox.setBackground(Color.WHITE);
            origenComboBox.setPreferredSize(new Dimension(300,40));
            panel.add(origenComboBox);
        }

        if(i == 6){ // PANEL DESTINO
            panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5,10));
            panel.setBackground(Color.CYAN);
            panel.setBounds(0,200,450,60);
            panel_preguntas.add(panel);

            JLabel destino_label = new JLabel("Destino: ");
            String[] destinos = {"Angol", "Chiguayante", "Concepcion", "Nacimiento", "Santa Juana"};
            destino_label.setFont(new Font("Arial", Font.BOLD, 16));
            panel.add(destino_label);
            destinoComboBox = new JComboBox(destinos);
            destinoComboBox.setBackground(Color.WHITE);
            destinoComboBox.setPreferredSize(new Dimension(300, 40));
            panel.add(destinoComboBox);
        }

        if(i == 7){ // PANEL FECHA
            panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5,10));
            panel.setBackground(Color.CYAN);
            panel.setBounds(0,300,450,60);
            panel_preguntas.add(panel);

            JLabel fecha_label = new JLabel("Fecha: ");
            fecha_label.setFont(new Font("Arial", Font.BOLD, 16));
            panel.add(fecha_label);

            dateChooser = new JDateChooser();
            dateChooser.setPreferredSize(new Dimension(317, 40));
            panel.add(dateChooser);
        }


    }
}
