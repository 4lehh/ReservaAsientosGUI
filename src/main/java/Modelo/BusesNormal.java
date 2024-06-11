package Modelo;

import java.util.ArrayList;

public class BusesNormal extends Buses implements Bus {

    public BusesNormal(){

    }

    public int tipoAsientos(){
        return 1;
    }

    public int cantidadAsientos(){
        return 42;
    }

    @Override
    public void crearBuses() {

    }
}
