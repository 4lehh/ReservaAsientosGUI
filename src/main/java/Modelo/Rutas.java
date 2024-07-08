package Modelo;

/**
 * Enum para definir las rutas existentes
 */
public enum Rutas {
    // ---------- Rutas ---------

    CONCE_CHIGUA(1000, "Concepcion", "Chiguayante"),CONCE_NACIMIENTO(5000, "Concepcion", "Nacimiento"),
    CONCE_SANTAJUANA(4000,"Concepcion","Santa Juana"),CONCE_ANGOL(7000, "Concepcion", "Angol"),
    CHIGUA_NACIMIENTO(4000, "Chiguayante", "Nacimiento"), CHIGUA_SANTAJUANA(3000, "Chiguayante", "Santa Juana"),
    CHIGUA_ANGOL(5500, "Chiguayante", "Angol"), SANTAJUANA_NACIMIENTO(2000, "Santa Juana", "Nacimiento"),
    SANTAJUANA_ANGOL(3500, "Santa Juana", "Angol"), NACIMIENTO_ANGOL(2000, "Nacimiento", "Angol");

    // --------- Variables ----------
    private final int precio;
    private final String partida;
    private final String llegada;

    /**
     * Constructor
     * @param precio precio de la ruta
     * @param partida lugar de partida
     * @param llegada lugar de origen
     */
    Rutas(int precio, String partida, String llegada){
        this.precio = precio;
        this.partida = partida;
        this.llegada = llegada;
    }

    /**
     * Método getter
     * @return retorna el precio de la ruta
     */
    public int precioRuta(){
        return precio;
    }

    /**
     * Método getter
     * @return retorna lugar de partida
     */
    public String getPartida(){
        return partida;
    }

    /**
     * Método getter
     * @return retorna el lugar de destino
     */
    public String getLlegada(){
        return llegada;
    }


}
