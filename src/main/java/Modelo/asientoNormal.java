package Modelo;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa un asiento normal
 */
public class asientoNormal extends  tipoAsiento{
    /**
     * Boton interno asociado al asiento
     */
    private JButton boton_asiento;
    /**
     * Variable que representa si el asiento está reservado o no
     */
    public boolean estado = true;
    /**
     * id para identificar al asiento
     */
    private String id;

    /**
     * Constructor
     * @param pos_x posicion en x para el boton del asiento
     * @param pos_y posicion en y para el boton del asiento
     * @param numero variable que se muestra al mantener el cursor sobre el boton
     * @param id identificador del asiento
     */
    public asientoNormal(int pos_x, int pos_y, int numero, String id){
        boton_asiento = new JButton();
        boton_asiento.setFont(new Font("Arial", Font.PLAIN, 4));
        boton_asiento.setFocusable(false);
        boton_asiento.setBackground(Color.gray);
        boton_asiento.setForeground(Color.white);
        boton_asiento.setBounds(pos_x, 20 + pos_y, 35, 35);
        boton_asiento.setToolTipText("" + numero);
        boton_asiento.setText("");

        this.id = id;
    }

    /**
     * Método getter
     * @return retorna el boton asociado al asiento
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
        return 0;
    }

    /**
     * Método getter
     * @return retorna el estado del asiento
     */
    @Override
    public  boolean estadoAsiento() {
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
        return "Asiento Normal";
    }
}
