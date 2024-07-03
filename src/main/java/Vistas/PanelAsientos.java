package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Modelo.*;


public class PanelAsientos extends JPanel implements ActionListener {

    // -------------- BG -----------------
    private BufferedImage bg_piso1;
    private BufferedImage bg_piso2;

    // --------- Panel -------------
    private JPanel panel_contenedor_grilla;
    private JPanel panel_grilla;
    private JPanel panel_info_asientos;
    private JPanel panel_asiento_prueba;

    // ------------- Enteros -------------
    private int salto_y = 0;

    private Buses buses;

    JButton boton_comprar_asiento;
    Boolean estado = false;

    JLabel label_precio;
    JLabel label_estado;

    int precio;
    String texto_estado;

    ArrayList<tipoAsiento> asientos;
    int indice_asiento_seleccionado;

    JButton mostrar_info_asiento;

    int seleccion;
    int numero_asiento_comprar = 0;
    public PanelAsientos(Buses bus_disponibles, int seleccion) {

        this.seleccion = seleccion;
        // -------------- Configurar Panel ---------------------
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.buses = bus_disponibles;
        this.asientos = buses.getAsientos();

        // --------- Panel Grilla ----------------
        panel_contenedor_grilla = new JPanel();
        configurarPanel(1);

        panel_grilla = new JPanel();
        configurarPanel(2);


        // --------------- BG --------------------
        try{
            bg_piso1 = ImageIO.read(new File("./src/main/resources/Imagenes/bus-1.png"));
            bg_piso2 = ImageIO.read(new File("./src/main/resources/Imagenes/bus-2.png"));

        } catch (IOException e){
            System.out.println(e);
        }

        // ----------------  Creacion botones enumerados + agregar al panel----------------
        int contador = 0;

        // --------------------- ACTION LISTENER ----------------
        for(JButton botones_buses : buses.tipoAsientos()){
            panel_grilla.add(botones_buses);
            botones_buses.addActionListener(this);
        }

        panel_info_asientos = new JPanel();
        configurarPanel(3);

        panel_asiento_prueba = new JPanel();
        configurarPanel(4);



        boton_comprar_asiento = new JButton("Comprar");
        boton_comprar_asiento.setFocusable(false);
        boton_comprar_asiento.setBounds(20,200, 120,40);
        boton_comprar_asiento.addActionListener(this);
        panel_asiento_prueba.add(boton_comprar_asiento);

        label_precio = new JLabel();
        label_precio.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_asiento_prueba.add(label_precio);
        label_precio.setBounds(20,5, 150, 40);

        label_estado = new JLabel();
        panel_asiento_prueba.add(label_estado);
        label_estado.setBounds(20, 50, 130, 40);

        mostrar_info_asiento = new JButton("Imprimir info");
        panel_asiento_prueba.add(mostrar_info_asiento);
        mostrar_info_asiento.setBounds(20,400,130,40);
        mostrar_info_asiento.setFocusable(false);
        mostrar_info_asiento.addActionListener(this);


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(bg_piso1 != null){
            Image escalada = bg_piso1.getScaledInstance(320, 720, Image.SCALE_SMOOTH);
            g2d.drawImage(escalada, 0,0,this);
        }

        // ESTADO DEL ASIENTO
        if(estado){
            label_estado.setText("DISPONIBLE");
            label_estado.setForeground(Color.GREEN);
        } else{
            label_estado.setText("NO DISPONIBLE");
            label_estado.setForeground(Color.RED);
        }

        label_precio.setText("" + precio);
        if(precio == 0){
            label_precio.setText("Solo precio ruta");
        } else{
            label_precio.setText("" + precio);
        }

    }

    public void configurarPanel(int i){
        if(i == 1){
            panel_contenedor_grilla.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
            panel_contenedor_grilla.setLayout(null);
            panel_contenedor_grilla.setPreferredSize(new Dimension(300,0));
            panel_contenedor_grilla.setOpaque(false);
            this.add(panel_contenedor_grilla, BorderLayout.WEST);
        }

        if(i == 2){
            panel_grilla.setLayout(null);
            panel_grilla.setBounds(42,145,240,520);
            panel_grilla.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
            panel_grilla.setOpaque(false);
            panel_contenedor_grilla.add(panel_grilla);
        }

        if(i == 3){
            panel_info_asientos.setPreferredSize(new Dimension(150, 0));
            panel_info_asientos.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
            panel_info_asientos.setLayout(null);
            this.add(panel_info_asientos, BorderLayout.CENTER);
        }

        if(i == 4){
            panel_asiento_prueba.setLayout(null);
            panel_asiento_prueba.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 3));
            panel_asiento_prueba.setBounds(10,80, 175,500);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_comprar_asiento) {
            System.out.println(numero_asiento_comprar);
            tipoAsiento asiento = asientos.get(indice_asiento_seleccionado);
            if (numero_asiento_comprar != 0){
                try {
                    // Importamos el archivo
                    File archivo = new File("./src/main/java/Modelo/datos.txt");

                    // Leer el archivo y almacenar las líneas en una lista
                    BufferedReader leer = new BufferedReader(new FileReader(archivo));
                    List<String> lineas = new ArrayList<>();
                    String linea;

                    while ((linea = leer.readLine()) != null) {
                        lineas.add(linea);
                    }
                    leer.close();

                    // Modificar la línea específica (convertir número de línea a índice basado en 0)
                    int indice = numero_asiento_comprar - 1;

                    if(lineas.get(indice).equals("0")){
                        lineas.set(indice, "1");
                    } else{
                        System.out.println("No es posible la compra");
                    }


                    // Escribir las líneas modificadas de vuelta al archivo
                    BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo));
                    for (String l : lineas) {
                        escribir.write(l);
                        escribir.newLine();
                    }
                    escribir.close();

                } catch (IOException i) {
                    i.printStackTrace(System.out);
                }
            }
            estado = false;
            asiento.setEstado(false);
            repaint();

        }

        for (int i = 0; i < buses.tipoAsientos().size(); i++) {
            if (e.getSource() == buses.tipoAsientos().get(i)) {
                panel_info_asientos.add(panel_asiento_prueba);
                tipoAsiento asiento = asientos.get(i);
                indice_asiento_seleccionado = i;

                String id_asiento = asiento.getID();
                String numeros = id_asiento.replaceAll("[^0-9]", "");
                numero_asiento_comprar = Integer.parseInt(numeros) + (36 * seleccion);

                try {
                    // Importamos el archivo
                    File archivo = new File("./src/main/java/Modelo/datos.txt");

                    // Leer el archivo y almacenar las líneas en una lista
                    BufferedReader leer = new BufferedReader(new FileReader(archivo));
                    List<String> lineas = new ArrayList<>();
                    String linea;

                    while ((linea = leer.readLine()) != null) {
                        lineas.add(linea);
                    }
                    leer.close();

                    if(lineas.get(numero_asiento_comprar - 1).equals("1")){
                        tipoAsiento asient = asientos.get(indice_asiento_seleccionado);
                        asient.setEstado(false);
                        estado = asient.estadoAsiento();
                    }


                } catch (IOException p) {
                    p.printStackTrace(System.out);
                }

                estado = asiento.estadoAsiento();

                repaint();


                System.out.println("Bus: " + seleccion + ", Asiento: " + numero_asiento_comprar);
            }
        }

        if(e.getSource() == mostrar_info_asiento){
            tipoAsiento asiento = asientos.get(indice_asiento_seleccionado);
            System.out.println("Precio: " + asiento.precioAsiento());
            System.out.println("Estado: " + asiento.estadoAsiento());
        }





//        for(JButton botones_buses : buses.tipoAsientos()){
//            if(e.getSource() == botones_buses){
//                System.out.println("sdfsdfsdfsdf");
//
//                repaint();
//            }
//        }

    }
    public void comprarAsiento(){

    }

}
