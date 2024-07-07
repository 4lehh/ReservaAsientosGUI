package Modelo;

import javax.swing.*;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Buses {
    public Buses() {

    }

    public abstract ArrayList<JButton> getBotonesAsientos();

    public abstract ArrayList<JButton> getBotonesAsientosPiso2();

    public abstract LocalTime getHora_partida();

    public abstract String getTipoBus();

    public abstract ArrayList<tipoAsiento> getAsientos();


}
