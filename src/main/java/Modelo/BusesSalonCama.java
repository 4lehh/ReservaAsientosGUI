package Modelo;

import java.util.ArrayList;

public class BusesSalonCama extends Buses implements Bus{

    public BusesSalonCama(){

    }

    public int tipoAsientos(){
        return 3;
    }

    public int cantidadAsientos(){
        return 30;
    }

    @Override
    public void crearBuses() {

    }
}
