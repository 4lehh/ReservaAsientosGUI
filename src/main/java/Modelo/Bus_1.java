package Modelo;

import javax.swing.*;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Clase que representa a un bus de 1 piso
 */
public class Bus_1 extends Buses {
    /**
     * Variable que representa hora de partida del bus
     */
    private LocalTime hora_partida;
    /**
     * Array interno de botones asociados a sus asientos del primer piso
     */
    public ArrayList<JButton> asientos;
    /**
     * Array interno de botones asociados a sus asientos del segundo piso (que tiene 0 asientos)
     */
    public ArrayList<JButton> asientos_piso2;
    /**
     * Array interno de asientos del bus
     */
    public ArrayList<tipoAsiento> asientos_del_bus;
    /**
     * Posicion en y de cada boton
     */
    int pos_y = 0;

    /**
     * Constructor
     * @param hora hora de partida del bus
     */
    public Bus_1(LocalTime hora){
        hora_partida = hora;
        asientos = new ArrayList<JButton>();
        asientos_piso2 = new ArrayList<JButton>();
        asientos_del_bus = new ArrayList<tipoAsiento>();
        tipoAsiento a;

        for(int i = 0; i < 36; i++){
            if(i < 8){
                int num_asiento = i+1;
                switch(i % 4){
                    case 0:
                        a = new asientoSalonCama(20,20+pos_y, i+1, "A" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 1:
                        a = new asientoSalonCama(60,20+pos_y, i+1, "A" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 2:
                        a = new asientoSalonCama(145, 20+pos_y, i+1, "A" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 3:
                        a = new asientoSalonCama(185, 20+pos_y, i+1, "A" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                }
            } else if(i < 20){
                int num_asiento = i+1;
                switch(i % 4){
                    case 0:
                        a = new asientoSemiCama(20,20+pos_y, i+1, "B" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 1:
                        a = new asientoSemiCama(60,20+pos_y, i+1, "B" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 2:
                        a = new asientoSemiCama(145,20+pos_y, i+1, "B" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 3:
                        a = new asientoSemiCama(185,20+pos_y, i+1, "B" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                }
            } else {
                int num_asiento = i+1;
                switch(i % 4){
                    case 0:
                        a = new asientoNormal(20,20+pos_y, i+1, "C" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 1:
                        a = new asientoNormal(60,20+pos_y, i+1, "C" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 2:
                        a = new asientoNormal(145,20+pos_y, i+1, "C" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 3:
                        a = new asientoNormal(185,20+pos_y, i+1, "C" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                }
            }
            if(i % 4 == 3){
                pos_y += 50;
            }
        }
    }

    /**
     * Método getter
     * @return retorna la hora de partida del bus
     */
    @Override
    public LocalTime getHora_partida(){
        return hora_partida;
    }

    /**
     * Método getter
     * @return retorna el tipo de bus como String
     */
    @Override
    public String getTipoBus(){
        return "Bus 1 piso";
    }

    /**
     * Método getter
     * @return retorna el array de botones de los asientos del primer piso
     */
    public ArrayList<JButton> getBotonesAsientos(){
        return asientos;
    }

    /**
     * Método getter
     * @return retorna el array de botones de los asientos del segundo piso (que tiene 0 asientos)
     */
    @Override
    public ArrayList<JButton> getBotonesAsientosPiso2() {
        return asientos_piso2;
    }

    /**
     * Método getter
     * @return retorna el array de asientos del bus
     */
    public ArrayList<tipoAsiento> getAsientos(){
        return asientos_del_bus;
    }

}