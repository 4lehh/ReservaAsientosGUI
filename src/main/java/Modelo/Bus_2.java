package Modelo;

import javax.swing.*;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Clase que representa a un bus de 2 pisos
 */
public class Bus_2 extends Buses {
    /**
     * Variable que representa la hora de partida del bus
     */
    private LocalTime hora_partida;
    /**
     * Array de botones de los asientos del primer piso
     */
    private ArrayList<JButton> asientos_piso1;
    /**
     * Array de botones de los asientos del segundo pisp
     */
    private ArrayList<JButton> asientos_piso2;
    /**
     * Posicion en y de los botones del primer piso
     */
    int pos_y1 = 0;
    /**
     * Posicion en y de los botones del segundo piso
     */
    int pos_y2 = 0;
    /**
     * Asientos del bus
     */
    ArrayList<tipoAsiento> asientos_del_bus;

    /**
     * Constructor
     * @param hora hora de partida del bus
     */
    public Bus_2(LocalTime hora){
        hora_partida = hora;
        asientos_piso1 = new ArrayList<JButton>();
        asientos_piso2 = new ArrayList<JButton>();
        asientos_del_bus = new ArrayList<tipoAsiento>();
        tipoAsiento a;

        for(int i = 0; i < 72; i++){
            if(i < 36){
                if(i < 8){
                    int num_asiento = i+1;
                    switch(i % 4){
                        case 0:
                            a = new asientoSalonCama(20,20+pos_y1, i+1, "A" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso1.add(a.getBotonAsiento());
                            break;
                        case 1:
                            a = new asientoSalonCama(60,20+pos_y1, i+1, "A" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso1.add(a.getBotonAsiento());
                            break;
                        case 2:
                            a = new asientoSalonCama(145, 20+pos_y1, i+1, "A" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso1.add(a.getBotonAsiento());
                            break;
                        case 3:
                            a = new asientoSalonCama(185, 20+pos_y1, i+1, "A" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso1.add(a.getBotonAsiento());
                            break;
                    }
                } else if(i < 20){
                    int num_asiento = i+1;
                    switch(i % 4){
                        case 0:
                            a = new asientoSemiCama(20,20+pos_y1, i+1, "B" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso1.add(a.getBotonAsiento());
                            break;
                        case 1:
                            a = new asientoSemiCama(60,20+pos_y1, i+1, "B" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso1.add(a.getBotonAsiento());
                            break;
                        case 2:
                            a = new asientoSemiCama(145,20+pos_y1, i+1, "B" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso1.add(a.getBotonAsiento());
                            break;
                        case 3:
                            a = new asientoSemiCama(185,20+pos_y1, i+1, "B" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso1.add(a.getBotonAsiento());
                            break;
                    }
                } else {
                    int num_asiento = i+1;
                    switch(i % 4){
                        case 0:
                            a = new asientoNormal(20,20+pos_y1, i+1, "C" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso1.add(a.getBotonAsiento());
                            break;
                        case 1:
                            a = new asientoNormal(60,20+pos_y1, i+1, "C" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso1.add(a.getBotonAsiento());
                            break;
                        case 2:
                            a = new asientoNormal(145,20+pos_y1, i+1, "C" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso1.add(a.getBotonAsiento());
                            break;
                        case 3:
                            a = new asientoNormal(185,20+pos_y1, i+1, "C" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso1.add(a.getBotonAsiento());
                            break;
                    }
                }
                if(i % 4 == 3){
                    pos_y1 += 50;
                }
            } else{
                if(i < 44){
                    int num_asiento = i+1;
                    switch(i % 4){
                        case 0:
                            a = new asientoSalonCama(20,20+pos_y2, i+1, "A" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso2.add(a.getBotonAsiento());
                            break;
                        case 1:
                            a = new asientoSalonCama(60,20+pos_y2, i+1, "A" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso2.add(a.getBotonAsiento());
                            break;
                        case 2:
                            a = new asientoSalonCama(145, 20+pos_y2, i+1, "A" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso2.add(a.getBotonAsiento());
                            break;
                        case 3:
                            a = new asientoSalonCama(185, 20+pos_y2, i+1, "A" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso2.add(a.getBotonAsiento());
                            break;
                    }
                } else if(i < 56){
                    int num_asiento = i+1;
                    switch(i % 4){
                        case 0:
                            a = new asientoSemiCama(20,20+pos_y2, i+1, "B" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso2.add(a.getBotonAsiento());
                            break;
                        case 1:
                            a = new asientoSemiCama(60,20+pos_y2, i+1, "B" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso2.add(a.getBotonAsiento());
                            break;
                        case 2:
                            a = new asientoSemiCama(145,20+pos_y2, i+1, "B" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso2.add(a.getBotonAsiento());
                            break;
                        case 3:
                            a = new asientoSemiCama(185,20+pos_y2, i+1, "B" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso2.add(a.getBotonAsiento());
                            break;
                    }
                } else {
                    int num_asiento = i+1;
                    switch(i % 4){
                        case 0:
                            a = new asientoNormal(20,20+pos_y2, i+1, "C" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso2.add(a.getBotonAsiento());
                            break;
                        case 1:
                            a = new asientoNormal(60,20+pos_y2, i+1, "C" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso2.add(a.getBotonAsiento());
                            break;
                        case 2:
                            a = new asientoNormal(145,20+pos_y2, i+1, "C" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso2.add(a.getBotonAsiento());
                            break;
                        case 3:
                            a = new asientoNormal(185,20+pos_y2, i+1, "C" + num_asiento);
                            asientos_del_bus.add(a);
                            asientos_piso2.add(a.getBotonAsiento());
                            break;
                    }
                }
                if(i % 4 == 3){
                    pos_y2 += 50;
                }
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
        return "Bus 2 pisos";
    }

    /**
     * Método getter
     * @return retorna el array de botones de los asientos del primer piso
     */
    public ArrayList<JButton> getBotonesAsientos(){
        return asientos_piso1;
    }

    /**
     * Método getter
     * @return retorna el array de botones de los asientos del segundo piso
     */
    public ArrayList<JButton> getBotonesAsientosPiso2(){
        return asientos_piso2;
    }

    /**
     * Método getter
     * @return retorna los asientos del bus
     */
    public ArrayList<tipoAsiento> getAsientos(){
        return asientos_del_bus;
    }

}