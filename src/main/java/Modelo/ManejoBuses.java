package Modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;

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

    }

    public ArrayList<Buses> getBuses(){

        // ---------------- Arreglar -----------------


        ArrayList<Buses> m = new ArrayList<Buses>();
        for(int i = 0; i < 6; i++) {
            Random rand = new Random();
            int random = rand.nextInt(2);
            if(random%2 == 1){
                m.add(new Bus_2(LocalTime.of(8+2*i, 0)));
            } else {
                m.add(new Bus_1(LocalTime.of(8+2*i, 0)));
            }
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
