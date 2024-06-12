package Modelo;

import javax.swing.*;

public abstract class Buses {
    public Buses(){

    }

    public abstract String tipoAsientos();

    public abstract int cantidadAsientos();

    public abstract JButton botonAsiento(int pos_x, int pos_y, int numero);


}
