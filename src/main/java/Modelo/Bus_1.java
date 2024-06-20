package Modelo;

import Vistas.Botones_Asientos;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bus_1 extends Buses {
    private LocalTime hora_partida;
    public ArrayList<JButton> asientos;
    public ArrayList<tipoAsiento> asientos_del_bus;
    int pos_y = 0;

    public Bus_1(LocalTime hora){
        hora_partida = hora;
        asientos = new ArrayList<JButton>();
        asientos_del_bus = new ArrayList<tipoAsiento>();
        asientoNormal a           ;

        for(int i = 0; i < 36; i++){
            if(i < 8){
                switch(i % 4){
                    case 0:
                        a = new asientoNormal(20,20+pos_y, i+1);
                        asientos_del_bus.add(a);
                        asientos.add(a.getAsiento());
                        break;
                    case 1:
                        a = new asientoNormal(60,20+pos_y, i+1);
                        asientos_del_bus.add(a);
                        asientos.add(a.getAsiento());
                        break;
                    case 2:
                        a = new asientoNormal(145, 20+pos_y, i+1);
                        asientos_del_bus.add(a);
                        asientos.add(a.getAsiento());
                        break;
                    case 3:
                        a = new asientoNormal(185, 20+pos_y, i+1);
                        asientos_del_bus.add(a);
                        asientos.add(a.getAsiento());
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
        return "Bus 1 piso";
    }

    public ArrayList<JButton> tipoAsientos(){
        return asientos;
    }

    public ArrayList<tipoAsiento> asientos(){
        return asientos_del_bus;
    }

}