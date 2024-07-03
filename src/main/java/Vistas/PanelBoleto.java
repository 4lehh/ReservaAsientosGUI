package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import Modelo.*;

public class PanelBoleto extends JPanel {
    private BufferedImage img_boleto;
    Font font = new Font("Arial", Font.PLAIN, 13);
    public PanelBoleto(String nombre, String fecha, String ruta_final, int precio_total, tipoAsiento asiento_comprado){
        try{
            img_boleto = ImageIO.read(new File("./src/main/resources/Imagenes/Ticket bus.png"));
        } catch (IOException e){
            System.out.println(e);
        }
        this.setLayout(null);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createLineBorder(Color.green, 3));

        JLabel label_nombre = new JLabel(nombre);
        label_nombre.setFont(new Font("Arial", Font.PLAIN, 13));
        label_nombre.setBounds(4,120,140,60);
        this.add(label_nombre);

        JLabel label_ruta = new JLabel(ruta_final);
        label_ruta.setFont(new Font("Arial", Font.PLAIN, 11));
        label_ruta.setBounds(4, 132, 140,60);
        this.add(label_ruta);

        JLabel label_fecha = new JLabel(fecha);
        label_fecha.setFont(new Font("Arial", Font.PLAIN, 13));
        label_fecha.setBounds(4,140,140,60);
        this.add(label_fecha);

        JLabel label_tipo_asiento = new JLabel(asiento_comprado.getTipoAsiento());
        label_tipo_asiento.setFont(new Font("Arial", Font.PLAIN, 13));
        label_tipo_asiento.setBounds(4, 160, 140, 60);
        this.add(label_tipo_asiento);

        JLabel label_precio = new JLabel("" + precio_total);
        label_precio.setFont(new Font("Arial", Font.PLAIN, 13));
        label_precio.setBounds(4,200,140,60);
        this.add(label_precio);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(img_boleto != null){
            Image escalada = img_boleto.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            g.drawImage(escalada, 0,0,this);
        }
    }

}
