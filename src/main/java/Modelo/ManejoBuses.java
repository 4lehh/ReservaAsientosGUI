package Modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;

/**
 * Clase que sirve para el manejo de los buses (ruta, precio de ruta)
 */
public class ManejoBuses {
    /**
     * Nombre de la ruta completa
     */
    private String nombreDestino;

    /**
     * Precio de la ruta
     */
    private int precio;

    /**
     * Constructor
     * @param nombre
     * @param punto_inicio lugar de partida
     * @param punto_final lugar de destino
     */
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

    /**
     * Método getter
     * @return retorna un array de buses
     */
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

    /**
     * Método getter
     * @return retorna el precio de la ruta
     */
    public int getPrecio_ruta(){
        return this.precio;
    }

    /**
     * Método getter
     * @return retorna la ruta
     */
    public String getRuta(){
        return nombreDestino;
    }
}
