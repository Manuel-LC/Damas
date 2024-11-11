package org.iesalandalus.programacion.damas;

public enum Direccion {
    NORESTE("Noreste"), SURESTE("Sureste"), SUROESTE("Suroeste"), NOROESTE("Noroeste");

    private final String cadenaAMostrar;

    private Direccion(String cadena) {
        this.cadenaAMostrar = cadena;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
