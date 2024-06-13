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
        ArrayList<Buses> m = new ArrayList<Buses>();
        int hora = 8;
        for(int i = 0; i < 6; i++){
            if(i == 2){
                m.add(new BusesSalonCama(LocalTime.of(hora, 0)));
            } else if(i%4 == 0){
                m.add(new BusesSemiCama(LocalTime.of(hora, 0)));
            } else {
                m.add(new BusesNormal(LocalTime.of(hora, 0)));
            }
            hora += 2;
        }
        return m;
    }

    public String getRuta(){
        return nombreDestino;
    }
}
