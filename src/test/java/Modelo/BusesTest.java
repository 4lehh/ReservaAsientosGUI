package Modelo;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BusesTest {
    Buses bus1;
    Buses bus2;

    @BeforeEach
    void setUp() {
        bus1 = new Bus_1(LocalTime.of(10, 0));
        bus2 = new Bus_2(LocalTime.of(10, 0));
    }

    @Test
    @DisplayName("Test getBotonesAsientos bus_1")

    public void testGetBotonesBus_1() {
        ArrayList<JButton> arr_esperado_bus1piso = new ArrayList<>();
        tipoAsiento a;
        for (int i = 0; i < 36; i++) {
            if (i < 8) {
                int num_asiento = i + 1;
                switch (i % 4) {
                    case 0:
                        a = new asientoSalonCama(20, 20, i + 1, "A" + num_asiento);
                        arr_esperado_bus1piso.add(a.getBotonAsiento());
                        break;
                    case 1:
                        a = new asientoSalonCama(60, 20, i + 1, "A" + num_asiento);
                        arr_esperado_bus1piso.add(a.getBotonAsiento());
                        break;
                    case 2:
                        a = new asientoSalonCama(145, 20, i + 1, "A" + num_asiento);
                        arr_esperado_bus1piso.add(a.getBotonAsiento());
                        break;
                    case 3:
                        a = new asientoSalonCama(185, 20, i + 1, "A" + num_asiento);
                        arr_esperado_bus1piso.add(a.getBotonAsiento());
                        break;
                }
            } else if (i < 20) {
                int num_asiento = i + 1;
                switch (i % 4) {
                    case 0:
                        a = new asientoSemiCama(20, 20, i + 1, "B" + num_asiento);
                        arr_esperado_bus1piso.add(a.getBotonAsiento());
                        break;
                    case 1:
                        a = new asientoSemiCama(60, 20, i + 1, "B" + num_asiento);
                        arr_esperado_bus1piso.add(a.getBotonAsiento());
                        break;
                    case 2:
                        a = new asientoSemiCama(145, 20, i + 1, "B" + num_asiento);
                        arr_esperado_bus1piso.add(a.getBotonAsiento());
                        break;
                    case 3:
                        a = new asientoSemiCama(185, 20, i + 1, "B" + num_asiento);
                        arr_esperado_bus1piso.add(a.getBotonAsiento());
                        break;
                }
            } else {
                int num_asiento = i + 1;
                switch (i % 4) {
                    case 0:
                        a = new asientoNormal(20, 20, i + 1, "C" + num_asiento);
                        arr_esperado_bus1piso.add(a.getBotonAsiento());
                        break;
                    case 1:
                        a = new asientoNormal(60, 20, i + 1, "C" + num_asiento);
                        arr_esperado_bus1piso.add(a.getBotonAsiento());
                        break;
                    case 2:
                        a = new asientoNormal(145, 20, i + 1, "C" + num_asiento);
                        arr_esperado_bus1piso.add(a.getBotonAsiento());
                        break;
                    case 3:
                        a = new asientoNormal(185, 20, i + 1, "C" + num_asiento);
                        arr_esperado_bus1piso.add(a.getBotonAsiento());
                        break;
                }
            }
        }
        int indice = 0;
        for (JButton boton_asiento : arr_esperado_bus1piso) {
            if (!boton_asiento.getUIClassID().equals(arr_esperado_bus1piso.get(indice).getUIClassID())) {
                assertTrue(false, "Asiento distinto");
            }
            indice++;
        }
        assertTrue(true, "Test exitoso");

    }

    @Test
    @DisplayName("Test getBotonesAsientoBus_2")
    public void testgetBotonesBus_2() {
        tipoAsiento a;
        ArrayList<JButton> asientos_piso1_esperado = new ArrayList<JButton>();
        ArrayList<JButton> asientos_piso2_esperado = new ArrayList<JButton>();

        for (int i = 0; i < 72; i++) {
            if (i < 36) {
                if (i < 8) {
                    int num_asiento = i + 1;
                    switch (i % 4) {
                        case 0:
                            a = new asientoSalonCama(20, 20, i + 1, "A" + num_asiento);
                            asientos_piso1_esperado.add(a.getBotonAsiento());
                            break;
                        case 1:
                            a = new asientoSalonCama(60, 20, i + 1, "A" + num_asiento);
                            asientos_piso1_esperado.add(a.getBotonAsiento());
                            break;
                        case 2:
                            a = new asientoSalonCama(145, 20, i + 1, "A" + num_asiento);
                            asientos_piso1_esperado.add(a.getBotonAsiento());
                            break;
                        case 3:
                            a = new asientoSalonCama(185, 20, i + 1, "A" + num_asiento);
                            asientos_piso1_esperado.add(a.getBotonAsiento());
                            break;
                    }
                } else if (i < 20) {
                    int num_asiento = i + 1;
                    switch (i % 4) {
                        case 0:
                            a = new asientoSemiCama(20, 20, i + 1, "B" + num_asiento);
                            asientos_piso1_esperado.add(a.getBotonAsiento());
                            break;
                        case 1:
                            a = new asientoSemiCama(60, 20, i + 1, "B" + num_asiento);
                            asientos_piso1_esperado.add(a.getBotonAsiento());
                            break;
                        case 2:
                            a = new asientoSemiCama(145, 20, i + 1, "B" + num_asiento);
                            asientos_piso1_esperado.add(a.getBotonAsiento());
                            break;
                        case 3:
                            a = new asientoSemiCama(185, 20, i + 1, "B" + num_asiento);
                            asientos_piso1_esperado.add(a.getBotonAsiento());
                            break;
                    }
                } else {
                    int num_asiento = i + 1;
                    switch (i % 4) {
                        case 0:
                            a = new asientoNormal(20, 20, i + 1, "C" + num_asiento);
                            asientos_piso1_esperado.add(a.getBotonAsiento());
                            break;
                        case 1:
                            a = new asientoNormal(60, 20, i + 1, "C" + num_asiento);
                            asientos_piso1_esperado.add(a.getBotonAsiento());
                            break;
                        case 2:
                            a = new asientoNormal(145, 20, i + 1, "C" + num_asiento);
                            asientos_piso1_esperado.add(a.getBotonAsiento());
                            break;
                        case 3:
                            a = new asientoNormal(185, 20, i + 1, "C" + num_asiento);
                            asientos_piso1_esperado.add(a.getBotonAsiento());
                            break;
                    }
                }

            } else {
                if (i < 44) {
                    int num_asiento = i + 1;
                    switch (i % 4) {
                        case 0:
                            a = new asientoSalonCama(20, 20, i + 1, "A" + num_asiento);
                            asientos_piso2_esperado.add(a.getBotonAsiento());
                            break;
                        case 1:
                            a = new asientoSalonCama(60, 20, i + 1, "A" + num_asiento);
                            asientos_piso2_esperado.add(a.getBotonAsiento());
                            break;
                        case 2:
                            a = new asientoSalonCama(145, 20, i + 1, "A" + num_asiento);
                            asientos_piso2_esperado.add(a.getBotonAsiento());
                            break;
                        case 3:
                            a = new asientoSalonCama(185, 20, i + 1, "A" + num_asiento);
                            asientos_piso2_esperado.add(a.getBotonAsiento());
                            break;
                    }
                } else if (i < 56) {
                    int num_asiento = i + 1;
                    switch (i % 4) {
                        case 0:
                            a = new asientoSemiCama(20, 20, i + 1, "B" + num_asiento);
                            asientos_piso2_esperado.add(a.getBotonAsiento());
                            break;
                        case 1:
                            a = new asientoSemiCama(60, 20, i + 1, "B" + num_asiento);
                            asientos_piso2_esperado.add(a.getBotonAsiento());
                            break;
                        case 2:
                            a = new asientoSemiCama(145, 20, i + 1, "B" + num_asiento);
                            asientos_piso2_esperado.add(a.getBotonAsiento());
                            break;
                        case 3:
                            a = new asientoSemiCama(185, 20, i + 1, "B" + num_asiento);
                            asientos_piso2_esperado.add(a.getBotonAsiento());
                            break;
                    }
                } else {
                    int num_asiento = i + 1;
                    switch (i % 4) {
                        case 0:
                            a = new asientoNormal(20, 20, i + 1, "C" + num_asiento);
                            asientos_piso2_esperado.add(a.getBotonAsiento());
                            break;
                        case 1:
                            a = new asientoNormal(60, 20, i + 1, "C" + num_asiento);
                            asientos_piso2_esperado.add(a.getBotonAsiento());
                            break;
                        case 2:
                            a = new asientoNormal(145, 20, i + 1, "C" + num_asiento);
                            asientos_piso2_esperado.add(a.getBotonAsiento());
                            break;
                        case 3:
                            a = new asientoNormal(185, 20, i + 1, "C" + num_asiento);
                            asientos_piso2_esperado.add(a.getBotonAsiento());
                            break;
                    }
                }
            }
        }

        ArrayList<JButton> asientos_piso1_real = bus2.getBotonesAsientos();
        ArrayList<JButton> asientos_piso2_real = bus2.getBotonesAsientosPiso2();

        int indice = 0;
        for(JButton boton : asientos_piso1_esperado){
            if(!boton.getUIClassID().equals(asientos_piso1_real.get(indice).getUIClassID())){
                assertTrue(false, "Asiento distinto");
            }
            indice++;
        }
        assertTrue(true, "Test exitoso");

        indice = 0;
        for(JButton boton : asientos_piso2_esperado){
            if(!boton.getUIClassID().equals(asientos_piso2_real.get(indice).getUIClassID())){
                assertTrue(false, "Asiento distinto");
            }
            indice++;
        }
        assertTrue(true, "Test exitoso");
    }
}


