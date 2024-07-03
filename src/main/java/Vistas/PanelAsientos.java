package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    private PanelBoleto panel_boleto;

    // ------------- Enteros -------------
    private int salto_y = 0;

    private Buses buses;

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

    public PanelAsientos(Buses bus_disponibles, String nombre, String fecha, String ruta_final, int precio_ruta) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ruta_final = ruta_final;
        this.precio_ruta = precio_ruta;

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
        if(bg_piso1 != null){
            Image escalada = bg_piso1.getScaledInstance(320, 720, Image.SCALE_SMOOTH);
            g2d.drawImage(escalada, 0,0,this);
        }

        if(indice_asiento_seleccionado+1 != 0){
            for (int i = 0; i < buses.tipoAsientos().size(); i++) {
                if(i == indice_asiento_seleccionado){
                    tipoAsiento asiento = asientos.get(i);
                    label_nombre_asiento.setText("Asiento: " + asiento.getID());
                    label_tipo_asiento.setText(asiento.getTipoAsiento());
                }
            }
        }

        // ESTADO DEL ASIENTO
        if(estado){
            label_estado.setText("DISPONIBLE");
            label_estado.setForeground(Color.GREEN);
        } else{
            label_estado.setText("NO DISPONIBLE");
            label_estado.setForeground(Color.RED);
        }

        if(precio == 0){
            label_precio.setText("Precio: Solo precio ruta");
        } else{
            label_precio.setText("Precio: " + precio);
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
            panel_asiento_prueba.setBounds(10,80, 260,500);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_comprar_asiento) {
            asiento_comprado = asientos.get(indice_asiento_seleccionado);
            estado = false;
            asiento_comprado.setEstado(false);
            repaint();
        }

        for (int i = 0; i < buses.tipoAsientos().size(); i++) {
            if (e.getSource() == buses.tipoAsientos().get(i)) {
                panel_info_asientos.add(panel_asiento_prueba);
                tipoAsiento asiento = asientos.get(i);
                indice_asiento_seleccionado = i;

                estado = asiento.estadoAsiento();
                precio = asiento.precioAsiento();

//                if(panel_boleto != null ){
//                    if(panel_asiento_prueba.isAncestorOf(panel_boleto)){
//                        panel_asiento_prueba.remove(panel_boleto);
//                    }
//                }
                repaint();
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
                panel_boleto.setBounds(8,300,300,300);
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
