package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;


import Modelo.*;


public class PanelAsientos extends JPanel implements ActionListener {

    // -------------- BG -----------------
    private BufferedImage bg_piso1;
    private BufferedImage bg_piso2;
    private BufferedImage bg_actual;

    // --------- Panel -------------
    private JPanel panel_contenedor_grilla;
    private JPanel panel_grilla;
    private JPanel panel_info_asientos;
    private JPanel panel_asiento_prueba;
    private PanelBoleto panel_boleto;


    // ------------- Enteros -------------
    private int salto_y = 0;

    private Buses bus_seleccionado;

    JButton boton_comprar_asiento;
    Boolean estado = false;

    JLabel label_precio;
    JLabel label_estado;
    JLabel label_nombre_asiento;
    JLabel label_tipo_asiento;
    int precio;

    ArrayList<tipoAsiento> asientos;
    int indice_asiento_seleccionado;
    tipoAsiento asiento_comprado;
    JButton boton_guardar_boleto;
    JButton boton_ver_boleto;

    Timer checkear_botones;

    String nombre;
    String fecha;
    String ruta_final;
    int precio_ruta;

    int seleccion;
    int numero_asiento_comprar = 0;

    JButton boton_cambiar_piso;
    boolean es_piso2 = false;
    public PanelAsientos(Buses bus_seleccionado, String nombre, String fecha, String ruta_final, int precio_ruta, int seleccion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ruta_final = ruta_final;
        this.precio_ruta = precio_ruta;
        this.setBackground(new Color(82, 5, 123));
        this.setBorder(BorderFactory.createLineBorder(Color.RED, 3));

        this.seleccion = seleccion;
        // -------------- Configurar Panel ---------------------
        this.setLayout(new BorderLayout());
        this.bus_seleccionado = bus_seleccionado;
        this.asientos = bus_seleccionado.getAsientos();

        // --------- Panel Grilla ----------------
        panel_contenedor_grilla = new JPanel();
        // boton_cambiar_piso solo visible si se selecciona bus de 2 pisos
        boton_cambiar_piso = new JButton("Cambiar piso");
        panel_contenedor_grilla.add(boton_cambiar_piso);
        boton_cambiar_piso.setFocusable(false);
        boton_cambiar_piso.addActionListener(this);
        configurarPanel(1);

        panel_grilla = new JPanel();
        configurarPanel(2);


        // --------------- BG --------------------
        try{
            bg_piso1 = ImageIO.read(new File("./src/main/resources/Imagenes/bus-1.png"));
            bg_piso2 = ImageIO.read(new File("./src/main/resources/Imagenes/bus-2.png"));
            bg_actual = bg_piso1;
        } catch (IOException e){
            System.out.println(e);
        }

        // ----------------  Creacion botones enumerados + agregar al panel----------------
        int contador = 0;

        // --------------------- ACTION LISTENER ----------------
        for(JButton boton_asiento : bus_seleccionado.getBotonesAsientos()){
            panel_grilla.add(boton_asiento);
            boton_asiento.addActionListener(this);
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

        label_nombre_asiento = new JLabel();
        label_nombre_asiento.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_asiento_prueba.add(label_nombre_asiento);
        label_nombre_asiento.setBounds(20,5, 150,40);

        label_tipo_asiento = new JLabel();
        label_tipo_asiento.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_asiento_prueba.add(label_tipo_asiento);
        label_tipo_asiento.setBounds(20, 50, 200, 40);

        label_precio = new JLabel();
        label_precio.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_asiento_prueba.add(label_precio);
        label_precio.setBounds(20,95, 200, 40);

        label_estado = new JLabel();
        label_estado.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_asiento_prueba.add(label_estado);
        label_estado.setBounds(20, 140, 130, 40);

        boton_guardar_boleto = new JButton("Guardar boleto");
        boton_guardar_boleto.setEnabled(false);
        panel_asiento_prueba.add(boton_guardar_boleto);
        boton_guardar_boleto.setFocusable(false);
        boton_guardar_boleto.setBounds(20,250,160,40);
        boton_guardar_boleto.addActionListener(this);

        boton_ver_boleto = new JButton("Ver boleto");
        panel_asiento_prueba.add(boton_ver_boleto);
        boton_ver_boleto.setEnabled(false);
        boton_ver_boleto.setFocusable(false);
        boton_ver_boleto.setBounds(20,295, 160,40);
        boton_ver_boleto.addActionListener(this);

        checkear_botones = new Timer(100, this);
        checkear_botones.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(bg_actual != null){
            Image escalada = bg_actual.getScaledInstance(320, 720, Image.SCALE_SMOOTH);
            g2d.drawImage(escalada, 0,0,this);
        }

        if(indice_asiento_seleccionado+1 != 0){
            for (int i = 0; i < bus_seleccionado.getBotonesAsientos().size() + bus_seleccionado.getBotonesAsientosPiso2().size(); i++) {
                if(i == indice_asiento_seleccionado){
                    tipoAsiento asiento = asientos.get(i);
                    label_nombre_asiento.setText("Asiento: " + asiento.getID());
                    label_tipo_asiento.setText(asiento.getTipoAsiento());
                }
            }
        }

        // ESTADO DEL ASIENTO
        if(estado){
            label_estado.setText("     DISPONIBLE");
            label_estado.setForeground(Color.BLACK);
            label_estado.setBackground(new Color(0, 166, 50));
            label_estado.setOpaque(true);
        } else{
            label_estado.setText(" NO DISPONIBLE");
            label_estado.setForeground(Color.BLACK);
            label_estado.setBackground(new Color(230, 8, 8));
            label_estado.setOpaque(true);
        }

        label_precio.setText("" + precio);
        if(precio == 0){
            label_precio.setText("Precio: Solo precio ruta");
        } else{
            label_precio.setText("Precio: " + precio);
        }

    }

    public void configurarPanel(int i){
        if(i == 1){
            panel_contenedor_grilla.setLayout(null);
            panel_contenedor_grilla.setPreferredSize(new Dimension(350,0));
            panel_contenedor_grilla.setOpaque(false);

            if(bus_seleccionado.getTipoBus().equals("Bus 2 pisos")){
                boton_cambiar_piso.setBounds(85, 650, 150, 40);
            }


            this.add(panel_contenedor_grilla, BorderLayout.WEST);
        }

        if(i == 2){
            panel_grilla.setLayout(null);
            panel_grilla.setBounds(42,145,240,520);
            panel_grilla.setOpaque(false);
            panel_contenedor_grilla.add(panel_grilla);
        }

        if(i == 3){
            panel_info_asientos.setLayout(null);
            panel_info_asientos.setBackground(new Color(152, 141, 242));
            this.add(panel_info_asientos, BorderLayout.CENTER);
        }

        if(i == 4){
            panel_asiento_prueba.setLayout(null);
            panel_asiento_prueba.setBackground(new Color(152, 141, 242));
            panel_asiento_prueba.setBounds(10,80, 260,500);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_comprar_asiento) {
            asiento_comprado = asientos.get(indice_asiento_seleccionado);
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
                        JOptionPane.showMessageDialog(null, "No es posible realizar la compra.", "Compra", JOptionPane.PLAIN_MESSAGE);
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
            asiento_comprado.setEstado(false);

            repaint();
        }



        for (int i = 0; i < bus_seleccionado.getBotonesAsientos().size() + bus_seleccionado.getBotonesAsientosPiso2().size(); i++) {

            if(i < 36){
                if (e.getSource() == bus_seleccionado.getBotonesAsientos().get(i)) {
                    panel_info_asientos.add(panel_asiento_prueba);
                    tipoAsiento asiento = asientos.get(i);
                    indice_asiento_seleccionado = i;

                    String id_asiento = asiento.getID();
                    String numeros = id_asiento.replaceAll("[^0-9]", "");
                    numero_asiento_comprar = Integer.parseInt(numeros) + (72 * seleccion);

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
                    precio = asiento.precioAsiento();

                    repaint();
                }
            } else{
                if (e.getSource() == bus_seleccionado.getBotonesAsientosPiso2().get(i-36)) {
                    panel_info_asientos.add(panel_asiento_prueba);
                    tipoAsiento asiento = asientos.get(i);
                    indice_asiento_seleccionado = i;

                    String id_asiento = asiento.getID();
                    String numeros = id_asiento.replaceAll("[^0-9]", "");
                    numero_asiento_comprar = Integer.parseInt(numeros) + (72 * seleccion);

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
                    precio = asiento.precioAsiento();

                    repaint();
                }
            }

        }

        if(e.getSource() == boton_guardar_boleto){
            guardar_boleto(asiento_comprado);
            JOptionPane.showMessageDialog(null, "Su boleto ha sido guardado con éxito, revise HistorialBoletos. Además, puede ver su boleto presionando Ver boleto", "Información boleto", JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource() == boton_ver_boleto){
            panel_boleto = new PanelBoleto(nombre, fecha, ruta_final, precio_ruta+precio, asiento_comprado);
            if(!panel_asiento_prueba.isAncestorOf(panel_boleto)){
                panel_asiento_prueba.add(panel_boleto);
                panel_boleto.setBounds(2,320,320,300);
            }
        }

        if(e.getSource() == checkear_botones){
            tipoAsiento asiento_seleccionado = asientos.get(indice_asiento_seleccionado);
            if(!asiento_seleccionado.estadoAsiento()){
                boton_comprar_asiento.setEnabled(false);
            } else{
                boton_comprar_asiento.setEnabled(true);
            }

            if(asiento_comprado != null){
                if(asiento_comprado.equals(asiento_seleccionado)){
                    boton_guardar_boleto.setEnabled(true);
                    boton_ver_boleto.setEnabled(true);
                } else{
                    boton_guardar_boleto.setEnabled(false);
                    boton_ver_boleto.setEnabled(false);

                    if(panel_boleto != null ){
                        if(panel_asiento_prueba.isAncestorOf(panel_boleto)){
                            panel_asiento_prueba.remove(panel_boleto);
                        }
                    }
                }
            }
            repaint();
        }

        if(e.getSource() == boton_cambiar_piso){
            if(bg_actual == bg_piso1){
                bg_actual = bg_piso2;
            } else{
                bg_actual = bg_piso1;
            }

            es_piso2 = !es_piso2;
            panel_grilla.removeAll();
            repaint();
            if(es_piso2){
                for(JButton boton_asiento : bus_seleccionado.getBotonesAsientosPiso2()){
                    panel_grilla.add(boton_asiento);
                    boton_asiento.addActionListener(this);
                }
            } else if(es_piso2 == false){
                for(JButton boton_asiento : bus_seleccionado.getBotonesAsientos()){
                    panel_grilla.add(boton_asiento);
                    boton_asiento.addActionListener(this);
                }
            }



            repaint();
            revalidate();
        }
    }

    public void guardar_boleto(tipoAsiento asiento){
        String nombrearchivo = "./src/main/java/Vistas/HistorialBoletos.txt";
        File archivo = new File(nombrearchivo);

        int precio_total = precio_ruta + precio;
        try{
            FileWriter escritor = new FileWriter(archivo, true);
            PrintWriter printWriter = new PrintWriter(escritor);

            printWriter.println("");

            printWriter.println("------------------------------------");
            printWriter.println("Nombre: " + nombre);
            printWriter.println("Asiento: " + asiento.getID() + ", " + asiento.getTipoAsiento());
            printWriter.println("Fecha de viaje: " + fecha);
            printWriter.println("Precio pagado: $" + precio_total);
            printWriter.println("¡Buen viaje!");
            printWriter.println("------------------------------------");
            printWriter.close();
        } catch (Exception e){
            System.err.println(e);
        }
    }

}
