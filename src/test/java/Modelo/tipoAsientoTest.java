package Modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class tipoAsientoTest {
    tipoAsiento asientoSalonCama;
    tipoAsiento asientoSemiCama;
    tipoAsiento asientoNormal;
    @BeforeEach
    void setUp() {
        asientoSalonCama = new asientoSalonCama(0,0,1, "A1");
        asientoSemiCama = new asientoSemiCama(0,0,1, "B1");
        asientoNormal = new asientoNormal(0,0,1, "C1");
    }

    @Test
    @DisplayName("Test EstadoAsiento")
    public void testEstadoAsiento(){
        boolean estado_esperado = true;
        boolean estado_real;

        estado_real = asientoSalonCama.estadoAsiento();
        if(estado_esperado != estado_real){
            assertTrue(false);
        }

        estado_real = asientoSemiCama.estadoAsiento();
        if(estado_esperado != estado_real){
            assertTrue(false);
        }

        estado_real = asientoNormal.estadoAsiento();
        if(estado_esperado != estado_real){
            assertTrue(false);
        }

        assertTrue(true);
    }

    @Test
    @DisplayName("Test precioAsiento")
    public void testPrecioAsiento(){
        int precio_salon_cama_esperado = 3000;
        int precio_salon_cama_real = asientoSalonCama.precioAsiento();
        int precio_semi_cama_esperado = 1500;
        int precio_semi_cama_real = asientoSalonCama.precioAsiento();
        int precio_normal_esperado = 0;
        int precio_normal_real = asientoSalonCama.precioAsiento();
        if(precio_salon_cama_esperado != precio_salon_cama_real && precio_semi_cama_esperado != precio_semi_cama_real && precio_normal_esperado != precio_normal_real){
            assertTrue(false);
        }
        assertTrue(true);
    }
}