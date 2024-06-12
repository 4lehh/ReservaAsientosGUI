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
        } else if(punto_inicio.equals(Rutas.CHIGUA_SANTAJUANA.getPartida()) && punto_final.equals(Rutas.CHIGUA_SANTAJUANA.getLlegada())){
            this.precio = Rutas.CHIGUA_SANTAJUANA.precioRuta();
            return "Chiguayante - Santa Juana";
        } else if(punto_inicio.equals(Rutas.CHIGUA_SANTAJUANA.getLlegada()) && punto_final.equals(Rutas.CHIGUA_SANTAJUANA.getPartida())) {
            this.precio = Rutas.CHIGUA_SANTAJUANA.precioRuta();
            return "Santa Juana - Chiguayante";
        } else if(punto_inicio.equals(Rutas.CHIGUA_NACIMIENTO.getPartida()) && punto_final.equals(Rutas.CHIGUA_NACIMIENTO.getLlegada())){
            this.precio = Rutas.CHIGUA_NACIMIENTO.precioRuta();
            return "Chiguayante - Nacimiento";
        } else if(punto_inicio.equals(Rutas.CHIGUA_NACIMIENTO.getLlegada()) && punto_final.equals(Rutas.CHIGUA_NACIMIENTO.getPartida())) {
            this.precio = Rutas.CHIGUA_NACIMIENTO.precioRuta();
            return "Nacimiento - Chiguayante";
        } else if(punto_inicio.equals(Rutas.CHIGUA_ANGOL.getPartida()) && punto_final.equals(Rutas.CHIGUA_ANGOL.getLlegada())){
            this.precio = Rutas.CHIGUA_ANGOL.precioRuta();
            return "Chiguayante - Angol";
        } else if(punto_inicio.equals(Rutas.CHIGUA_ANGOL.getLlegada()) && punto_final.equals(Rutas.CHIGUA_ANGOL.getPartida())) {
            this.precio = Rutas.CHIGUA_NACIMIENTO.precioRuta();
            return "Angol - Chiguayante";
        } else if(punto_inicio.equals(Rutas.SANTAJUANA_NACIMIENTO.getPartida()) && punto_final.equals(Rutas.SANTAJUANA_NACIMIENTO.getLlegada())){
            this.precio = Rutas.SANTAJUANA_NACIMIENTO.precioRuta();
            return "Santa Juana - Nacimiento";
        } else if(punto_inicio.equals(Rutas.SANTAJUANA_NACIMIENTO.getLlegada()) && punto_final.equals(Rutas.SANTAJUANA_NACIMIENTO.getPartida())) {
            this.precio = Rutas.SANTAJUANA_NACIMIENTO.precioRuta();
            return "Nacimiento - Santa Juana";
        } else if(punto_inicio.equals(Rutas.SANTAJUANA_ANGOL.getPartida()) && punto_final.equals(Rutas.SANTAJUANA_ANGOL.getLlegada())){
            this.precio = Rutas.SANTAJUANA_ANGOL.precioRuta();
            return "Santa Juana - Angol";
        } else if(punto_inicio.equals(Rutas.SANTAJUANA_ANGOL.getLlegada()) && punto_final.equals(Rutas.SANTAJUANA_ANGOL.getPartida())) {
            this.precio = Rutas.SANTAJUANA_ANGOL.precioRuta();
            return "Angol - Santa Juana";
        } else if(punto_inicio.equals(Rutas.NACIMIENTO_ANGOL.getPartida()) && punto_final.equals(Rutas.NACIMIENTO_ANGOL.getLlegada())){
            this.precio = Rutas.NACIMIENTO_ANGOL.precioRuta();
            return "Nacimiento - Angol";
        } else if(punto_inicio.equals(Rutas.NACIMIENTO_ANGOL.getLlegada()) && punto_final.equals(Rutas.NACIMIENTO_ANGOL.getPartida())) {
            this.precio = Rutas.NACIMIENTO_ANGOL.precioRuta();
            return "Angol - Nacimiento";
        } else {
            return "";
        }
    }

    public int getPrecio(){
        return this.precio;
    }

}
