package Modelo;

public enum Rutas {
    // ---------- Rutas ---------
    ANGOL_CHILLAN(10000,"Angol", "Chillán"),ANGOL_LOSANGELES(5000, "Angol", "Los Ángeles"),ANGOL_RANCAGUA(8000,"Angol", "Rancagua"),
    CONCE_CHIGUA(1000, "Concepcion", "Chiguayante"), CONCE_NACIMIENTO(5000, "Concepcion", "Nacimiento"),

    CONCE_SANTAJUANA(4000,"Concepcion","Santa Juana"), CONCE_ANGOL(7000, "Concepcion", "Angol");


    // --------- Variables ----------
    private final int precio;
    private final String partida;
    private final String llegada;

    Rutas(int precio, String partida, String llegada){
        this.precio = precio;
        this.partida = partida;
        this.llegada = llegada;
    }

    public int precioRuta(){
        return precio;
    }

    public String getPartida(){
        return partida;
    }

    public String getLlegada(){
        return llegada;
    }


}
