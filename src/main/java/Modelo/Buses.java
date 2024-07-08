package Modelo;

import javax.swing.*;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Clase abstracta que representa a un bus
 */
public abstract class Buses {
    /**
     * Constructor
     */
    public Buses() {

    }

    /**
     * Método abstracto
     * @return devuelve botones de los asientos primer piso
     */
    public abstract ArrayList<JButton> getBotonesAsientos();

    /**
     * Método abstracto
     * @return retorna botones de los asientos segundo piso
     */
    public abstract ArrayList<JButton> getBotonesAsientosPiso2();

    /**
     * Método abstracto
     * @return retorna gora de partida del bus
     */
    public abstract LocalTime getHora_partida();

    /**
     * Método abstracto
     * @return retorna el tipo de bus
     */
    public abstract String getTipoBus();

    /**
     * Método abstracto
     * @return retorna array de asientos del bus
     */
    public abstract ArrayList<tipoAsiento> getAsientos();


}
