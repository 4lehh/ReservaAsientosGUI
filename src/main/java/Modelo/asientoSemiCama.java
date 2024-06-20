package Modelo;

import javax.swing.*;
import java.awt.*;

public class asientoSemiCama extends tipoAsiento{
    private JButton boton_asiento;
    public boolean estado = true;

    public asientoSemiCama(int pos_x, int pos_y, int numero){
        boton_asiento = new JButton();
        boton_asiento.setFont(new Font("Arial", Font.PLAIN, 4));
        boton_asiento.setFocusable(false);
        boton_asiento.setBackground(Color.green);
        boton_asiento.setForeground(Color.white);
        boton_asiento.setBounds(pos_x, 20 + pos_y, 35, 35);
        boton_asiento.setToolTipText("" + numero);
        boton_asiento.setText("");
    }

    @Override
    public JButton getBotonAsiento() {
        return boton_asiento;
    }

    @Override
    public int precioAsiento() {
        return 1500;
    }

    @Override
    public boolean estadoAsiento() {
        return estado;
    }
}
