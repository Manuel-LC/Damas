package org.iesalandalus.programacion.damas;

public class Dama {

    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    public Dama() {
        this.color = Color.BLANCO;
        this.posicion =
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
}
