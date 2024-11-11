package org.iesalandalus.programacion.damas;

public enum Color {
    BLANCO("Blanco"), NEGRO("Negro");

    private final String cadenaAMostrar;

    private Color(String cadena) {
        this.cadenaAMostrar = cadena;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
