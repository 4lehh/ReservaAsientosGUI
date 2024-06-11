package Modelo;

public class BusesSemiCama extends Buses implements Bus{

    public BusesSemiCama(){

    }

    public int tipoAsientos(){
        return 2;
    }

    public int cantidadAsientos(){
        return 36;
    }

    @Override
    public void crearBuses() {

    }
}
