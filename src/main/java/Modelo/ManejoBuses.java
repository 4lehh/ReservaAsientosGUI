package Modelo;

import java.time.LocalTime;
import java.util.ArrayList;

public class ManejoBuses {
    // ------------ Strings ---------------
    private String nombreDestino;

    // ------------ int --------------
    private int precio;

    public ManejoBuses(String nombre, String punto_inicio, String punto_final){
        // ------------ RUTA -------------
        RutasFactory ruta = new RutasFactory();
        try{
            ruta.obtenerRuta(punto_inicio, punto_final);
            this.nombreDestino = ruta.ruta_final;
            this.precio = ruta.getPrecio();
        } catch(RutaInvalidaException e){
            System.out.println("Error, " + e);
        }
        System.out.println("Nombre: " + nombre + ". Ruta: " + nombreDestino + ". Precio: " + precio);
    }

    public ArrayList<Buses> getBuses(){

        // ---------------- Arreglar -----------------

        ArrayList<Buses> m = new ArrayList<Buses>();
        int hora = 8;
        for(int i = 0; i < 6; i++){
            if(i == 4){
                m.add(new Bus_2(LocalTime.of(8+i, 0)));
            } else {
                m.add(new Bus_1(LocalTime.of(8+i, 0)));
            }
            hora += 2;
        }
        return m;
    }

    public int getPrecio_ruta(){
        return this.precio;
    }

    public String getRuta(){
        return nombreDestino;
    }
}
