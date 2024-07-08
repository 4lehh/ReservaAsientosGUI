package Modelo;

/**
 * Clase Factory de rutas para crear todas las rutas existentes
 */
public class RutasFactory {

    /**
     * Precio de la ruta
     */
    private int precio;
    /**
     * Ruta completa
     */
    public String ruta_final;

    /**
     * Método que configura las rutas
     * @param punto_inicio lugar de origen
     * @param punto_final lugar de destino
     * @throws RutaInvalidaException en caso de que se elija un ruta inválida
     */
    public void obtenerRuta(String punto_inicio, String punto_final) throws RutaInvalidaException{
        if(punto_inicio.equals(Rutas.CONCE_CHIGUA.getPartida()) && punto_final.equals(Rutas.CONCE_CHIGUA.getLlegada())){
            this.precio = Rutas.CONCE_CHIGUA.precioRuta();
            ruta_final =  "Concepcion - Chiguayante";
        } else if(punto_inicio.equals(Rutas.CONCE_CHIGUA.getLlegada()) && punto_final.equals(Rutas.CONCE_CHIGUA.getPartida())){
            this.precio = Rutas.CONCE_CHIGUA.precioRuta();
            ruta_final =  "Chiguayante - Concepcion";
        } else if(punto_inicio.equals(Rutas.CONCE_SANTAJUANA.getPartida()) && punto_final.equals(Rutas.CONCE_SANTAJUANA.getLlegada())){
            this.precio = Rutas.CONCE_SANTAJUANA.precioRuta();
            ruta_final =  "Concepcion - Santa Juana";
        } else if(punto_inicio.equals(Rutas.CONCE_SANTAJUANA.getLlegada()) && punto_final.equals(Rutas.CONCE_SANTAJUANA.getPartida())){
            this.precio = Rutas.CONCE_SANTAJUANA.precioRuta();
            ruta_final =  "Santa Juana - Concepcion";
        } else if(punto_inicio.equals(Rutas.CONCE_NACIMIENTO.getPartida()) && punto_final.equals(Rutas.CONCE_NACIMIENTO.getLlegada())){
            this.precio = Rutas.CONCE_NACIMIENTO.precioRuta();
            ruta_final =  "Concepcion - Nacimiento";
        } else if(punto_inicio.equals(Rutas.CONCE_NACIMIENTO.getLlegada()) && punto_final.equals(Rutas.CONCE_NACIMIENTO.getPartida())){
            this.precio = Rutas.CONCE_NACIMIENTO.precioRuta();
            ruta_final =  "Nacimiento - Concepcion";
        } else if(punto_inicio.equals(Rutas.CONCE_ANGOL.getPartida()) && punto_final.equals(Rutas.CONCE_ANGOL.getLlegada())){
            this.precio = Rutas.CONCE_ANGOL.precioRuta();
            ruta_final =  "Concepcion - Angol";
        } else if(punto_inicio.equals(Rutas.CONCE_ANGOL.getLlegada()) && punto_final.equals(Rutas.CONCE_ANGOL.getPartida())){
            this.precio = Rutas.CONCE_ANGOL.precioRuta();
            ruta_final =  "Angol - Concepcion";
        } else if(punto_inicio.equals(Rutas.CHIGUA_SANTAJUANA.getPartida()) && punto_final.equals(Rutas.CHIGUA_SANTAJUANA.getLlegada())){
            this.precio = Rutas.CHIGUA_SANTAJUANA.precioRuta();
            ruta_final =  "Chiguayante - Santa Juana";
        } else if(punto_inicio.equals(Rutas.CHIGUA_SANTAJUANA.getLlegada()) && punto_final.equals(Rutas.CHIGUA_SANTAJUANA.getPartida())) {
            this.precio = Rutas.CHIGUA_SANTAJUANA.precioRuta();
            ruta_final =  "Santa Juana - Chiguayante";
        } else if(punto_inicio.equals(Rutas.CHIGUA_NACIMIENTO.getPartida()) && punto_final.equals(Rutas.CHIGUA_NACIMIENTO.getLlegada())){
            this.precio = Rutas.CHIGUA_NACIMIENTO.precioRuta();
            ruta_final =  "Chiguayante - Nacimiento";
        } else if(punto_inicio.equals(Rutas.CHIGUA_NACIMIENTO.getLlegada()) && punto_final.equals(Rutas.CHIGUA_NACIMIENTO.getPartida())) {
            this.precio = Rutas.CHIGUA_NACIMIENTO.precioRuta();
            ruta_final =  "Nacimiento - Chiguayante";
        } else if(punto_inicio.equals(Rutas.CHIGUA_ANGOL.getPartida()) && punto_final.equals(Rutas.CHIGUA_ANGOL.getLlegada())){
            this.precio = Rutas.CHIGUA_ANGOL.precioRuta();
            ruta_final =  "Chiguayante - Angol";
        } else if(punto_inicio.equals(Rutas.CHIGUA_ANGOL.getLlegada()) && punto_final.equals(Rutas.CHIGUA_ANGOL.getPartida())) {
            this.precio = Rutas.CHIGUA_NACIMIENTO.precioRuta();
            ruta_final =  "Angol - Chiguayante";
        } else if(punto_inicio.equals(Rutas.SANTAJUANA_NACIMIENTO.getPartida()) && punto_final.equals(Rutas.SANTAJUANA_NACIMIENTO.getLlegada())){
            this.precio = Rutas.SANTAJUANA_NACIMIENTO.precioRuta();
            ruta_final =  "Santa Juana - Nacimiento";
        } else if(punto_inicio.equals(Rutas.SANTAJUANA_NACIMIENTO.getLlegada()) && punto_final.equals(Rutas.SANTAJUANA_NACIMIENTO.getPartida())) {
            this.precio = Rutas.SANTAJUANA_NACIMIENTO.precioRuta();
            ruta_final =  "Nacimiento - Santa Juana";
        } else if(punto_inicio.equals(Rutas.SANTAJUANA_ANGOL.getPartida()) && punto_final.equals(Rutas.SANTAJUANA_ANGOL.getLlegada())){
            this.precio = Rutas.SANTAJUANA_ANGOL.precioRuta();
            ruta_final =  "Santa Juana - Angol";
        } else if(punto_inicio.equals(Rutas.SANTAJUANA_ANGOL.getLlegada()) && punto_final.equals(Rutas.SANTAJUANA_ANGOL.getPartida())) {
            this.precio = Rutas.SANTAJUANA_ANGOL.precioRuta();
            ruta_final =  "Angol - Santa Juana";
        } else if(punto_inicio.equals(Rutas.NACIMIENTO_ANGOL.getPartida()) && punto_final.equals(Rutas.NACIMIENTO_ANGOL.getLlegada())){
            this.precio = Rutas.NACIMIENTO_ANGOL.precioRuta();
            ruta_final =  "Nacimiento - Angol";
        } else if(punto_inicio.equals(Rutas.NACIMIENTO_ANGOL.getLlegada()) && punto_final.equals(Rutas.NACIMIENTO_ANGOL.getPartida())) {
            this.precio = Rutas.NACIMIENTO_ANGOL.precioRuta();
            ruta_final =  "Angol - Nacimiento";
        } else {
            ruta_final = "";
            throw new RutaInvalidaException("Seleccione una ruta valida.");
        }
    }

    /**
     * Método getter
     * @return retorna el precio de la ruta
     */
    public int getPrecio(){
        return this.precio;
    }

}
