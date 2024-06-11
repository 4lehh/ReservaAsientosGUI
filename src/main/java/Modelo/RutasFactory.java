package Modelo;

public class RutasFactory {

    private int precio;

    public String obtenerRuta(String punto_inicio, String punto_final){
        if(punto_inicio.equals(Rutas.CONCE_CHIGUA.getPartida()) && punto_final.equals(Rutas.CONCE_CHIGUA.getLlegada())){
            this.precio = Rutas.CONCE_CHIGUA.precioRuta();
            return "Concepcion - Chiguayante";
        } else if(punto_inicio.equals(Rutas.CONCE_CHIGUA.getLlegada()) && punto_final.equals(Rutas.CONCE_CHIGUA.getPartida())){
            this.precio = Rutas.CONCE_CHIGUA.precioRuta();
            return "Chiguayante - Concepcion";
        } else if(punto_inicio.equals(Rutas.CONCE_SANTAJUANA.getPartida()) && punto_final.equals(Rutas.CONCE_SANTAJUANA.getLlegada())){
            this.precio = Rutas.CONCE_SANTAJUANA.precioRuta();
            return "Concepcion - Santa Juana";
        } else if(punto_inicio.equals(Rutas.CONCE_SANTAJUANA.getLlegada()) && punto_final.equals(Rutas.CONCE_SANTAJUANA.getPartida())){
            this.precio = Rutas.CONCE_SANTAJUANA.precioRuta();
            return "Santa Juana - Concepcion";
        } else if(punto_inicio.equals(Rutas.CONCE_NACIMIENTO.getPartida()) && punto_final.equals(Rutas.CONCE_NACIMIENTO.getLlegada())){
            this.precio = Rutas.CONCE_NACIMIENTO.precioRuta();
            return "Concepcion - Nacimiento";
        } else if(punto_inicio.equals(Rutas.CONCE_NACIMIENTO.getLlegada()) && punto_final.equals(Rutas.CONCE_NACIMIENTO.getPartida())){
            this.precio = Rutas.CONCE_NACIMIENTO.precioRuta();
            return "Nacimiento - Concepcion";
        } else if(punto_inicio.equals(Rutas.CONCE_ANGOL.getPartida()) && punto_final.equals(Rutas.CONCE_ANGOL.getLlegada())){
            this.precio = Rutas.CONCE_ANGOL.precioRuta();
            return "Concepcion - Angol";
        } else if(punto_inicio.equals(Rutas.CONCE_ANGOL.getLlegada()) && punto_final.equals(Rutas.CONCE_ANGOL.getPartida())){
            this.precio = Rutas.CONCE_ANGOL.precioRuta();
            return "Angol - Concepcion";
        } else {
            return "";
        }
    }

    public int getPrecio(){
        return this.precio;
    }



}
