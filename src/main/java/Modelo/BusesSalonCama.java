package Modelo;

import java.util.ArrayList;

public class BusesSalonCama extends Buses implements Bus{

    public BusesSalonCama(){

    }

    public String tipoAsientos(){
        return "Salon Cama";
    }

    public int cantidadAsientos(){
        return 30;
    }

    @Override
    public void crearBuses() {

    }
}
