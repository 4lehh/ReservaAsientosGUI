package Modelo;

import javax.swing.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bus_2 extends Buses {
    private LocalTime hora_partida;
    public ArrayList<JButton> asientos;
    public ArrayList<tipoAsiento> asientos_del_bus;
    int pos_y = 0;

    public Bus_2(LocalTime hora){
        hora_partida = hora;
        asientos = new ArrayList<JButton>();
        asientos_del_bus = new ArrayList<tipoAsiento>();
        tipoAsiento a;

        for(int i = 0; i < 36; i++){

            if(i < 8){
                int num_asiento = i +1;
                switch(i % 4){
                    case 0:
                        a = new asientoSalonCama(20,20+pos_y, i+1, "a" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 1:
                        a = new asientoSalonCama(60,20+pos_y, i+1, "a" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 2:
                        a = new asientoSalonCama(145, 20+pos_y, i+1, "a" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 3:
                        a = new asientoSalonCama(185, 20+pos_y, i+1, "a" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                }
            } else if(i < 20){
                int num_asiento = i +1;
                switch(i % 4){
                    case 0:
                        a = new asientoSemiCama(20,20+pos_y, i+1, "b" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 1:
                        a = new asientoSemiCama(60,20+pos_y, i+1, "b" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 2:
                        a = new asientoSemiCama(145,20+pos_y, i+1, "b" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 3:
                        a = new asientoSemiCama(185,20+pos_y, i+1, "b" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                }
            } else {
                int num_asiento = i + 1;
                switch(i % 4){
                    case 0:
                        a = new asientoNormal(20,20+pos_y, i+1, "c" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 1:
                        a = new asientoNormal(60,20+pos_y, i+1, "c" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 2:
                        a = new asientoNormal(145,20+pos_y, i+1, "c" + num_asiento);
                        asientos_del_bus.add(a);
                        asientos.add(a.getBotonAsiento());
                        break;
                    case 3:
                        a = new asientoNormal(185,20+pos_y, i+1, "c" + num_asiento);
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

    @Override
    public LocalTime getHora_partida(){
        return hora_partida;
    }

    @Override
    public String getTipoBus(){
        return "Bus 2 piso";
    }

    public ArrayList<JButton> tipoAsientos(){
        return asientos;
    }

    public ArrayList<tipoAsiento> getAsientos(){
        return asientos_del_bus;
    }

}