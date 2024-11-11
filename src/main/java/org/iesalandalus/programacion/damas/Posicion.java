package org.iesalandalus.programacion.damas;

public class Posicion {

    private int fila;        // Atributo para la fila (1-8)
    private char columna;

    public int getFila() {
        return fila;
    }

    public void setFila(int fila)
    {
        if (fila < 1 || fila > 8)
            throw new IllegalArgumentException("ERROR: La fila debe estar entre 1 y 8.");

        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna)
    {
        if (columna < 'a' || columna > 'h')
            throw new IllegalArgumentException("ERROR: La columna debe estar entre la 'a' y la 'h'.");

        this.columna = columna;
    }
}
