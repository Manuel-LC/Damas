package org.iesalandalus.programacion.damas;

public class Dama {

    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    // Constructor por defecto
    public Dama() {
        this.color = Color.BLANCO;
        this.posicion = crearPosicionInicial(color);
        this.esDamaEspecial = false;
    }

    // Constructor para crear una dama en una posición inicial
    public Dama(Color color) {
        if (color == null) {
            throw new NullPointerException("ERROR: El color no es válido.");
        }
        this.color = color;
        this.posicion = crearPosicionInicial(color);
        this.esDamaEspecial = false;
    }

    // Métodos getter y setter
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color == null)
            throw new NullPointerException("ERROR: El color no es válido.");

        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        if (posicion == null)
            throw new NullPointerException("ERROR: La posición no es válida.");

        this.posicion = posicion;
    }

    public boolean getEsDamaEspecial() {
        return esDamaEspecial;
    }

    public void setEsDamaEspecial(boolean esDamaEspecial) {
        this.esDamaEspecial = esDamaEspecial;
    }

    // Método para crear la posición inicial de la dama
    private Posicion crearPosicionInicial(Color color) {
        int fila;
        char columna;

        if (color == Color.BLANCO) {
            fila = (int) (Math.random() * 3) + 1; // Filas 1 a 3 para dama blanca
        } else {
            fila = (int) (Math.random() * 3) + 6; // Filas 6 a 8 para dama negra
        }

        int numeroColumna = (int) (Math.random() * 4);
        columna = (char) ('a' + numeroColumna * 2);

        return new Posicion(fila, columna);
    }
}
