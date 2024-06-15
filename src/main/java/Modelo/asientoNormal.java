package Modelo;

import Vistas.Botones_Asientos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class asientoNormal extends  tipoAsiento{
    private JButton boton_asiento;


    public asientoNormal(int pos_x, int pos_y, int numero){
        boton_asiento = new JButton();
        boton_asiento.setFont(new Font("Arial", Font.PLAIN, 4));
        boton_asiento.setFocusable(false);
        boton_asiento.setBackground(Color.gray);
        boton_asiento.setForeground(Color.white);
        boton_asiento.setBounds(pos_x, 20 + pos_y, 35, 35);
        boton_asiento.setToolTipText("" + numero);
        boton_asiento.setText("");
    }

    @Override
    public JButton getAsiento() {
        return boton_asiento;
    }


    @Override
    public int precioAsiento() {
        return 0;
    }
}
