package Modelo;

import javax.swing.*;

/**
 * Clase abstracta que representa a un asiento
 */
public abstract class tipoAsiento {

    /**
     * Constructor
     */
    public tipoAsiento(){

    }

    /**
     * Método abstracto
     * @return retorna el boton asociado al asiento
     */
    public abstract JButton getBotonAsiento();

    /**
     * Método getter
     * @return retorna el precio del asiento
     */
    public abstract int precioAsiento();

    /**
     * Método getter
     * @return retorna el estado del asiento
     */
    public abstract boolean estadoAsiento();

    /**
     * Método setter
     * @param estado modifca el estado del asiento
     */
    public abstract void setEstado(boolean estado);

    /**
     * Método getter
     * @return retorna el id del asiento
     */
    public abstract String getID();

    /**
     * Método getter
     * @return retorna el tipo de asiento como String
     */
    public abstract String getTipoAsiento();
}
