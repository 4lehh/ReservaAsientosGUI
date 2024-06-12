package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelPaisaje extends JPanel {
    BufferedImage bg;

    public PanelPaisaje(){
        // Dimensiones actuales: 780x720
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(780,720));
        this.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        this.setBackground(Color.MAGENTA);


        try{
            bg = ImageIO.read(new File("./src/main/java/Vistas/Imagenes/paisaje_bus.png"));
        } catch (IOException e){
            System.out.println(e);
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(bg != null){
            Image escalada = bg.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            g2d.drawImage(escalada, 0,0,this);
        }
    }
}