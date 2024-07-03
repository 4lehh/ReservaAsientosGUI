package Modelo;

import javax.swing.*;

public abstract class tipoAsiento {

    public tipoAsiento(){

    }

    public abstract JButton getBotonAsiento();

    public abstract int precioAsiento();

    public abstract boolean estadoAsiento();

    public abstract void setEstado(boolean estado);

    public abstract String getID();
}
