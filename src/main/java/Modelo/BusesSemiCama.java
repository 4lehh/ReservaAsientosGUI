package Modelo;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class BusesSemiCama extends Buses{
    private LocalTime hora_partida;
    public BusesSemiCama(LocalTime hora){
        hora_partida = hora;

    }
    public LocalTime getHora_partida(){
        return hora_partida;
    }

    public String tipoAsientos(){
        return "Semi Cama";
    }

    public int cantidadAsientos(){
        return 36;
    }

    @Override
    public JButton botonAsiento(int pos_x, int pos_y, int numero) {
        JButton boton = new JButton();
        boton.setFont(new Font("Arial", Font.PLAIN, 4));
        boton.setFocusable(false);
        boton.setBackground(Color.gray);
        boton.setForeground(Color.white);
        boton.setBounds(pos_x, pos_y, 35, 35);
        boton.setToolTipText("" + numero);
        boton.setText("");
        return boton;
    }
}
