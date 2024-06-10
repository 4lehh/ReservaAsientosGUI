package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDatos extends JPanel implements ActionListener {
    // -------- Paneles ------------
    JPanel panel_superior;
    JPanel panel_inferior;
    JPanel panel_preguntas;

    Asientos asientos;

    JButton boton_eliminar;
    JButton boton_cualquiera;
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

        JTextField nombre_textfield = new JTextField();
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
        origen_label.setFont(new Font("Arial", Font.BOLD, 16));
        panel_origen.add(origen_label);

        JTextField origen_textfield = new JTextField();
        origen_textfield.setBackground(Color.WHITE);
        origen_textfield.setPreferredSize(new Dimension(300,40));
        panel_origen.add(origen_textfield);

        //---------DESTINO--------
        JPanel panel_destino = new JPanel();
        panel_destino.setLayout(new FlowLayout(FlowLayout.LEFT, 5,10));
        panel_destino.setBackground(Color.CYAN);
        panel_destino.setBounds(0,200,400,60);
        panel_preguntas.add(panel_destino);

        JLabel destino_label = new JLabel("Destino: ");
        destino_label.setFont(new Font("Arial", Font.BOLD, 16));
        panel_destino.add(destino_label);

        JTextField destino_textfield = new JTextField();
        destino_textfield.setBackground(Color.WHITE);
        destino_textfield.setPreferredSize(new Dimension(300,40));
        panel_destino.add(destino_textfield);

        // panel_nombre.setPreferredSize();









        //-------------NOMBRE-------------
//        JPanel panel_nombre = new JPanel();
//        panel_nombre.setBackground(Color.CYAN);
//        panel_nombre.setPreferredSize(new Dimension(0,50));
//        panel_nombre.setLayout(new FlowLayout(FlowLayout.LEFT,20,30));
//        panel_nombre.setBorder(BorderFactory.createLineBorder(Color.GREEN));
//        panel_preguntas.add(panel_nombre);
//        JLabel nombre_label = new JLabel("Nombre:");
//        nombre_label.setFont(new Font("Arial", Font.BOLD, 16));
//        JTextField nombre_textfield = new JTextField(20);
//        nombre_textfield.setBackground(Color.WHITE);
//        nombre_textfield.setPreferredSize(new Dimension(100,20));
//        nombre_textfield.setForeground(Color.BLACK);
//        panel_nombre.add(nombre_label);
//        panel_nombre.add(nombre_textfield);
//        panel_preguntas.add(Box.createVerticalStrut(10));

        //------------ORIGEN-----------
//        JPanel panel_origen = new JPanel();
//        panel_origen.setBackground(Color.CYAN);
//        panel_origen.setLayout(new FlowLayout(FlowLayout.LEFT,20,30));
//        panel_origen.setBorder(BorderFactory.createLineBorder(Color.GREEN));
//        panel_preguntas.add(panel_origen);
//        JLabel origen_label = new JLabel("Origen:");
//        origen_label.setFont(new Font("Arial", Font.BOLD, 16));
//        JTextField origen_textfield = new JTextField(20);
//        origen_textfield.setBackground(Color.WHITE);
//        origen_textfield.setPreferredSize(new Dimension(100,20));
//        origen_textfield.setForeground(Color.BLACK);
//        panel_origen.add(origen_label);
//        panel_origen.add(origen_textfield);
//        panel_preguntas.add(Box.createVerticalStrut(10));

        //---------DESTINO----------
//        JPanel panel_destino = new JPanel();
//        panel_destino.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));
//        panel_preguntas.add(panel_destino);
//        JLabel destino_label = new JLabel("Destino");
//        destino_label.setFont(new Font("Arial", Font.BOLD, 16));
//        JTextField destino_textfield = new JTextField(20);
//        destino_textfield.setBackground(Color.WHITE);
//        destino_textfield.setPreferredSize(new Dimension(100,20));
//        panel_destino.add(destino_label);
//        panel_destino.add(destino_textfield);

        boton_cualquiera = new JButton("Boton cualquiera");
        panel_preguntas.add(boton_cualquiera);
        boton_cualquiera.setBounds(50,30,40,40);
        boton_cualquiera.addActionListener(this);

        boton_eliminar = new JButton("Boton para eliminar panel");
        panel_preguntas.add(boton_eliminar);
        boton_eliminar.setBounds(60,50,40,40);
        boton_eliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_cualquiera){
            asientos.mostrarAsientos();
        }
        if(e.getSource() == boton_eliminar){
            panel_inferior.remove(panel_preguntas);
            repaint();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);



    }
}
