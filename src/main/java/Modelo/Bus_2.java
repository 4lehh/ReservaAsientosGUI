package Modelo;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bus_2 extends Buses {
    private LocalTime hora_partida;
    private ArrayList<JButton> asientos;
    int pos_y = 0;
    ArrayList<tipoAsiento> asientos_del_bus;

    public Bus_2(LocalTime hora){
        hora_partida = hora;
        asientos = new ArrayList<JButton>();
        asientos_del_bus = new ArrayList<tipoAsiento>();

        for(int i = 0; i < 36; i++){
            if(i < 8){
                switch(i % 4){
                    case 0:
                        asientos.add(new asientoSalonCama(20,20+pos_y, i+1).getAsiento());
                        break;
                    case 1:
                        asientos.add(new asientoSalonCama(60,20+pos_y, i+1).getAsiento());
                        break;
                    case 2:
                        asientos.add(new asientoSalonCama(145,20+pos_y, i+1).getAsiento());
                        break;
                    case 3:
                        asientos.add(new asientoSalonCama(185,20+pos_y, i+1).getAsiento());
                        break;
                }
            } else if(i < 20){
                switch(i % 4){
                    case 0:
                        asientos.add(new asientoSemiCama(20,20+pos_y, i+1).getAsiento());
                        break;
                    case 1:
                        asientos.add(new asientoSemiCama(60,20+pos_y, i+1).getAsiento());
                        break;
                    case 2:
                        asientos.add(new asientoSemiCama(145,20+pos_y, i+1).getAsiento());
                        break;
                    case 3:
                        asientos.add(new asientoSemiCama(185,20+pos_y, i+1).getAsiento());
                        break;
                }
            } else {
                switch(i % 4){
                    case 0:
                        asientos.add(new asientoNormal(20,20+pos_y, i+1).getAsiento());
                        break;
                    case 1:
                        asientos.add(new asientoNormal(60,20+pos_y, i+1).getAsiento());
                        break;
                    case 2:
                        asientos.add(new asientoNormal(145,20+pos_y, i+1).getAsiento());
                        break;
                    case 3:
                        asientos.add(new asientoNormal(185,20+pos_y, i+1).getAsiento());
                        break;
                }
            }
            if(i % 4 == 3){
                pos_y += 50;
            }
        }
    }

    @Override
    public LocalTime getHora_partida(){
        return hora_partida;
    }

    @Override
    public String getTipoBus(){
        return "Bus 2 pisos";
    }

    public ArrayList<JButton> tipoAsientos(){
        return asientos;
    }

    public ArrayList<tipoAsiento> asientos(){
        return asientos_del_bus;
    }

}