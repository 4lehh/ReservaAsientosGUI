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
        // ------------ RUTA -------------
        RutasFactory ruta = new RutasFactory();
        this.nombreDestino = ruta.obtenerRuta(punto_inicio, punto_final);

        // ------------- PRECIO ---------------
        this.precio = ruta.getPrecio();

        // -------------- BUSES ---------------------
        this.buses_ruta = new ArrayList<Buses>();
        this.buses_ruta = getBuses();


        System.out.println("Nombre: " + nombre + ". Ruta: " + nombreDestino + ". Precio: " + precio);
    }

    public ArrayList<Buses> getBuses(){
        ArrayList<Buses> m = new ArrayList<Buses>();
        for(int i = 0; i < 10; i++){
            if(i == 2){
                m.add(new BusesSalonCama());
            } else if(i%4 == 0){
                m.add(new BusesSemiCama());
            } else {
                m.add(new BusesNormal());
            }
        }
        return m;
    }
}
