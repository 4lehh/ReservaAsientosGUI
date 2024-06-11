package Modelo;

import java.util.ArrayList;

public class BusesNormal extends Buses implements Bus {

    public BusesNormal(){

    }

    public String tipoAsientos(){
        return "Normal";
    }

    public int cantidadAsientos(){
        return 42;
    }

    @Override
    public void crearBuses() {

    }
}
