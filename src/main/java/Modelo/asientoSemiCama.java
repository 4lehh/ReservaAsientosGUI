package Modelo;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa al asiento semi cama
 */
public class asientoSemiCama extends tipoAsiento{
    /**
     * Boton interno asociado al asiento
     */
    private JButton boton_asiento;
    /**
     * Variable que representa el estado interno del asiento
     */
    public boolean estado = true;
    /**
     * Identificador del asiento
     */
    private String id;

    /**
     * Constructor
     * @param pos_x posicion en x del boton
     * @param pos_y posicion en y del boton
     * @param numero variable que se muestra al posicionar el cursor sobre el boton
     * @param id identificador del asiento
     */
    public asientoSemiCama(int pos_x, int pos_y, int numero, String id){
        boton_asiento = new JButton();
        boton_asiento.setFont(new Font("Arial", Font.PLAIN, 4));
        boton_asiento.setFocusable(false);
        boton_asiento.setBackground(Color.green);
        boton_asiento.setForeground(Color.white);
        boton_asiento.setBounds(pos_x, 20 + pos_y, 35, 35);
        boton_asiento.setToolTipText("" + numero);
        boton_asiento.setText("");

        this.id = id;

    }

    /**
     * Método getter
     * @return retorna el boton del asiento
     */
    @Override
    public JButton getBotonAsiento() {
        return boton_asiento;
    }

    /**
     * Método getter
     * @return retorna el precio del asiento
     */
    @Override
    public int precioAsiento() {
        return 1500;
    }

    /**
     * Método getter
     * @return retorna el estado del asiento
     */
    @Override
    public boolean estadoAsiento() {
        return estado;
    }

    /**
     * Método setter
     * @param estado modifica el estado del asiento
     */
    @Override
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Método getter
     * @return retorna el id del asiento
     */
    @Override
    public String getID() {
        return id;
    }

    /**
     * Método getter
     * @return retorna el tipo de asiento como String
     */
    @Override
    public String getTipoAsiento() {
        return "Asiento Semi-Cama";
    }
}
