package Modelo;

public class BusesSemiCama extends Buses implements Bus{

    public BusesSemiCama(){

    }

    public String tipoAsientos(){
        return "Semi Cama";
    }

    public int cantidadAsientos(){
        return 36;
    }

    @Override
    public void crearBuses() {

    }
}
