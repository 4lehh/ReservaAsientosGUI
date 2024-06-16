package Modelo;

import javax.swing.*;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Buses {
    public Buses() {

    }

    public abstract ArrayList<JButton> tipoAsientos();

    public abstract LocalTime getHora_partida();

    public abstract String getTipoBus();


}
