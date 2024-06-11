package Modelo;

import java.util.ArrayList;

public class ManejoBuses {
    // ------------ Strings ---------------
    private String nombreDestino;

    // ------------ int --------------
    private int precio;

    // ------------- ArrayList ----------------
    private ArrayList<Buses> buses_ruta;

    public ManejoBuses(String nombre, String punto_inicio, String punto_final){
        RutasFactory ruta = new RutasFactory();
        this.nombreDestino = ruta.obtenerRuta(punto_inicio, punto_final);
        this.precio = ruta.getPrecio();
        this.buses_ruta = new ArrayList<Buses>();


        System.out.println("Nombre: " + nombre + ". Ruta: " + nombreDestino + ". Precio: " + precio);


    }

    public ArrayList<Buses> getBuses(){
        for(int i = 0; i < 10; i++){
            if(i == 2){
                buses_ruta.add(new BusesSalonCama());
            } else if(i%4 == 0){
                buses_ruta.add(new BusesSemiCama());
            } else {
                buses_ruta.add(new BusesNormal());
            }
        }
        return buses_ruta;
    }
}
