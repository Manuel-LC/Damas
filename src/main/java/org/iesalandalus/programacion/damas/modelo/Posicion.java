package org.iesalandalus.programacion.damas.modelo;

public class Posicion {

    private int fila;
    private char columna;

    // Constructor con parámetros
    public Posicion(int fila, char columna) {
        if (fila < 1 || fila > 8) {
            throw new IllegalArgumentException("ERROR: La dama se sale del tablero.");
        } else {
            setFila(fila);
        }

        if (columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("ERROR: La dama se sale del tablero.");
        } else {
            setColumna(columna);
        }
    }

    // Constructor copia
    public Posicion(Posicion posicion) {
        setFila(posicion.getFila());
        setColumna(posicion.getColumna());
    }

    // Getters y setters
    public int getFila() {
        return fila;
    }

    private void setFila(int fila)
    {
        if (fila < 1 || fila > 8)
            throw new IllegalArgumentException("ERROR: La fila debe estar entre 1 y 8.");

        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    private void setColumna(char columna)
    {
        if (columna < 'a' || columna > 'h')
            throw new IllegalArgumentException("ERROR: La columna debe estar entre la 'a' y la 'h'.");

        this.columna = columna;
    }

    // Método equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Posicion posicion = (Posicion) obj;
        return fila == posicion.fila && columna == posicion.columna;
    }

    // Método hashCode
    @Override
    public int hashCode() {
        int result = Integer.hashCode(fila);
        result = 31 * result + Character.hashCode(columna);
        return result;
    }

    // Método toString
    @Override
    public String toString() {
        return "{fila = " + fila + ", columna = " + columna + '}';
    }
}
