package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelDatos extends JPanel {
    JPanel panel_superior;
    JPanel panel_inferior;
    public PanelDatos(){
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        this.setPreferredSize(new Dimension(500,0));
        this.setBackground(Color.CYAN);


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
        JPanel panel_preguntas = new JPanel();
        panel_preguntas.setOpaque(false);
        panel_preguntas.setLayout(new BoxLayout(panel_preguntas, BoxLayout.Y_AXIS));
        panel_inferior.add(panel_preguntas);
        panel_preguntas.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
        panel_preguntas.setBounds(50,30, 400,400);


        JPanel panel_nombre = new JPanel();
        panel_nombre.setBackground(Color.CYAN);
        panel_nombre.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
        panel_nombre.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        panel_preguntas.add(panel_nombre);
        JLabel nombre_label = new JLabel("Nombre:");
        nombre_label.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField nombre_textfield = new JTextField(20);
        nombre_textfield.setBackground(Color.WHITE);
        nombre_textfield.setPreferredSize(new Dimension(100,20));
        nombre_textfield.setForeground(Color.BLACK);
        panel_nombre.add(nombre_label);
        panel_nombre.add(nombre_textfield);
        panel_preguntas.add(Box.createVerticalStrut(100));

        JPanel panel_origen = new JPanel();
        panel_origen.setBackground(Color.CYAN);
        panel_origen.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
        panel_origen.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        panel_preguntas.add(panel_origen);
        JLabel origen_label = new JLabel("Origen:");
        origen_label.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField origen_textfield = new JTextField(20);
        origen_textfield.setBackground(Color.WHITE);
        origen_textfield.setPreferredSize(new Dimension(100,20));
        origen_textfield.setForeground(Color.BLACK);
        panel_origen.add(origen_label);
        panel_origen.add(origen_textfield);
        panel_preguntas.add(Box.createVerticalStrut(100));



    }
}
