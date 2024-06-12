package Vistas;

import Modelo.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PanelDatos extends JPanel implements ActionListener {
    // -------- Paneles ------------
    JPanel panel_superior;
    JPanel panel_inferior;
    JPanel panel_preguntas;
    JPanel panel_buses;

    Asientos asientos;

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

    Timer comprobar_datos;
    public PanelDatos(){
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        this.setPreferredSize(new Dimension(500,0));
        this.setBackground(Color.CYAN);

        // -------- Asientos -------
        asientos = new Asientos();


        //------------ TITULO: DATOS------------
        panel_superior = new JPanel();
        panel_superior.setLayout(new BorderLayout());
        panel_superior.setPreferredSize(new Dimension(0, 75));
        panel_superior.setBackground(Color.GREEN);
        panel_superior.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        JLabel titulo = new JLabel("DATOS", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        panel_superior.add(titulo, BorderLayout.CENTER);
        this.add(panel_superior, BorderLayout.NORTH);

        //------------- PANEL CONTENEDOR DE LOS DATOS-----------
        panel_inferior = new JPanel();
        panel_inferior.setBackground(Color.PINK);
        panel_inferior.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        panel_inferior.setLayout(null);
        this.add(panel_inferior, BorderLayout.CENTER);

        //------------- CAMPOS DE TEXTO------------
        panel_preguntas = new JPanel();
        panel_preguntas.setOpaque(false);

        //panel_preguntas.setLayout(new BoxLayout(panel_preguntas, BoxLayout.Y_AXIS));
        panel_preguntas.setLayout(null);
        panel_inferior.add(panel_preguntas);
        panel_preguntas.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
        panel_preguntas.setBounds(50,30, 400,400);

        //---------NOMBRE----------
        JPanel panel_nombre = new JPanel();
        panel_nombre.setLayout(new FlowLayout(FlowLayout.LEFT, 0,10));
        panel_nombre.setBackground(Color.CYAN);
        panel_nombre.setBounds(0,0,400,60);
        panel_preguntas.add(panel_nombre);

        JLabel nombre_label = new JLabel("Nombre: ");
        nombre_label.setFont(new Font("Arial", Font.BOLD, 16));
        panel_nombre.add(nombre_label);

        nombre_textfield = new JTextField();
        nombre_textfield.setBackground(Color.WHITE);
        nombre_textfield.setPreferredSize(new Dimension(300,40));
        panel_nombre.add(nombre_textfield);

        //---------ORIGEN------
        JPanel panel_origen = new JPanel();
        panel_origen.setLayout(new FlowLayout(FlowLayout.LEFT, 5,10));
        panel_origen.setBackground(Color.CYAN);
        panel_origen.setBounds(0,100,400,60);
        panel_preguntas.add(panel_origen);

        JLabel origen_label = new JLabel("Origen: ");
        String[] origenes = {"Angol", "Chiguayante", "Concepcion", "Nacimiento", "Santa Juana"};
        origenComboBox = new JComboBox<>(origenes);
        origen_label.setFont(new Font("Arial", Font.BOLD, 16));
        panel_origen.add(origen_label);
        origenComboBox.setBackground(Color.WHITE);
        origenComboBox.setPreferredSize(new Dimension(300,40));
        panel_origen.add(origenComboBox);

        //---------DESTINO--------
        JPanel panel_destino = new JPanel();
        panel_destino.setLayout(new FlowLayout(FlowLayout.LEFT, 5,10));
        panel_destino.setBackground(Color.CYAN);
        panel_destino.setBounds(0,200,400,60);
        panel_preguntas.add(panel_destino);

        JLabel destino_label = new JLabel("Destino: ");
        String[] destinos = {"Angol", "Chiguayante", "Concepcion", "Nacimiento", "Santa Juana"};
        destino_label.setFont(new Font("Arial", Font.BOLD, 16));
        panel_destino.add(destino_label);
        destinoComboBox = new JComboBox(destinos);
        destinoComboBox.setBackground(Color.WHITE);
        destinoComboBox.setPreferredSize(new Dimension(300, 40));
        panel_destino.add(destinoComboBox);

        //----------FECHA---------
        JPanel panel_fecha = new JPanel();
        panel_fecha.setLayout(new FlowLayout(FlowLayout.LEFT, 5,10));
        panel_fecha.setBackground(Color.CYAN);
        panel_fecha.setBounds(0,300,400,60);
        panel_preguntas.add(panel_fecha);

        JLabel fecha_label = new JLabel("Fecha: ");
        fecha_label.setFont(new Font("Arial", Font.BOLD, 16));
        panel_fecha.add(fecha_label);

        dateChooser = new JDateChooser();
        dateChooser.setPreferredSize(new Dimension(300, 40));
        panel_fecha.add(dateChooser);

        boton_cualquiera = new JButton("Boton cualquiera");
        panel_preguntas.add(boton_cualquiera);
        boton_cualquiera.setBounds(50,30,40,40);
        boton_cualquiera.addActionListener(this);

        boton_siguiente = new JButton("Siguiente");
        panel_preguntas.add(boton_siguiente);
        boton_siguiente.setEnabled(false);
        boton_siguiente.setBounds(300,360,100,40);
        boton_siguiente.addActionListener(this);

        comprobar_datos = new Timer(100, this);
        comprobar_datos.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_cualquiera){
            asientos.mostrarAsientos();
        }
        if(e.getSource() == boton_siguiente){
            nombre = nombre_textfield.getText();
            origen = (String) origenComboBox.getSelectedItem();
            destino = (String) destinoComboBox.getSelectedItem();
            Date fecha_completa = dateChooser.getDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            fecha_simple = simpleDateFormat.format(fecha_completa);

            new ManejoBuses(nombre, origen, destino);
            System.out.println(fecha_simple);
            panel_inferior.remove(panel_preguntas);

            panel_buses = new PanelSeleccionBuses(origen, destino, fecha_simple);
            panel_inferior.add(panel_buses);

            repaint();
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
}
