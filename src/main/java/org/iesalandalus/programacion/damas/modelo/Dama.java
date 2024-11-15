package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;

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

    private void setColor(Color color) {
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

    // Método que marcará el número de pasos y la dirección de la dama
    public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
        if (direccion == null)
            throw new NullPointerException("ERROR: Dirección nula.");

        if (pasos < 1)
            throw new IllegalArgumentException("ERROR: El número de pasos debe ser mayor o igual a 1.");

        if (esDamaEspecial == false && pasos != 1)
            throw new OperationNotSupportedException("ERROR: La dama solo puede moverse una casilla si no es especial.");

        int nuevaFila = posicion.getFila();
        char nuevaColumna = posicion.getColumna();

        // Valida el movimiento según el color y la dirección
        switch (direccion) {
            case NORESTE:
                if (color == Color.NEGRO && esDamaEspecial) {
                    throw new OperationNotSupportedException("ERROR: La dama negra no puede moverse hacia esa posición.");
                } else if ((nuevaFila < 1) || (nuevaFila > 8) || (nuevaColumna < 'a') || (nuevaColumna > 'h')) {
                    throw new OperationNotSupportedException("ERROR: El movimiento se sale del tablero.");
                }

                nuevaFila -= pasos;
                nuevaColumna = (char) (nuevaColumna + pasos);

                break;
            case NOROESTE:
                if (color == Color.NEGRO && esDamaEspecial) {
                    throw new OperationNotSupportedException("ERROR: La dama negra no puede moverse hacia esa posición.");
                } else if ((nuevaFila < 1) || (nuevaFila > 8) || (nuevaColumna < 'a') || (nuevaColumna > 'h')) {
                    throw new OperationNotSupportedException("ERROR: El movimiento se sale del tablero.");
                }

                nuevaFila -= pasos;
                nuevaColumna = (char) (nuevaColumna - pasos);

                break;
            case SURESTE:
                if (color == Color.BLANCO && esDamaEspecial) {
                    throw new OperationNotSupportedException("ERROR: La dama blanca no puede moverse hacia esa posición.");
                } else if ((nuevaFila < 1) || (nuevaFila > 8) || (nuevaColumna < 'a') || (nuevaColumna > 'h')) {
                    throw new OperationNotSupportedException("ERROR: El movimiento se sale del tablero.");
                }

                nuevaFila += pasos;
                nuevaColumna = (char) (nuevaColumna + pasos);

                break;
            case SUROESTE:
                if (color == Color.BLANCO && esDamaEspecial) {
                    throw new OperationNotSupportedException("ERROR: La dama blanca no puede moverse hacia esa posición.");
                } else if ((nuevaFila < 1) || (nuevaFila > 8) || (nuevaColumna < 'a') || (nuevaColumna > 'h')) {
                    throw new OperationNotSupportedException("ERROR: El movimiento se sale del tablero.");
                }

                nuevaFila += pasos;
                nuevaColumna = (char) (nuevaColumna - pasos);

                break;
        }

        // Actualiza la posición
        this.posicion = new Posicion(nuevaFila, nuevaColumna);

        // Se convierte en dama especial si alcanza el borde opuesto
        if ((color == Color.BLANCO && nuevaFila == 1) || (color == Color.NEGRO && nuevaFila == 8)) {
            esDamaEspecial = true;
        }
    }
}
