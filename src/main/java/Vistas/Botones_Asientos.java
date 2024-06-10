package Vistas;

import javax.swing.*;
import java.awt.*;

public class Botones_Asientos extends JButton {
    public Botones_Asientos(int numero, int pos_x, int pos_y){
        this.setFont(new Font("Arial", Font.PLAIN, 4));
        this.setFocusable(false);
        this.setBackground(Color.gray);
        this.setForeground(Color.white);
        this.setBounds(pos_x, pos_y, 35, 35);
        this.setToolTipText("" + numero);
        this.setText("");
        retornar_asiento();

        // IMPLEMENTAR ASIENTOS USADOS Y NO USADOS
    }

    public JButton retornar_asiento(){
        return this;
    }
}
