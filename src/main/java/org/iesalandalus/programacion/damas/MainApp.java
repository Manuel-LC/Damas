package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.damas.modelo.Dama;

public class MainApp {
    public static void main(String[] args) {

    }

    private static Dama dama;

    private static void ejecutarOpcion(int opcion) {
        switch(opcion)
        {
            case 1: //Crear una dama por defecto
                crearDamaDefecto();
                break;
            case 2: //Crear una dama eligiendo el color
                crearDamaColor();
                break;
            case 3: //Mover la dama
                mover();
                break;
            default:
                Consola.despedirse();
                break;
        }
    }

    private static void crearDamaDefecto() {
        dama = new Dama();
        System.out.println("La dama por defecto se ha creado correctamente.");
    }

    private static void crearDamaColor() {
        Color color = Consola.elegirColor(); // Se pide al usuario el color
        dama = new Dama(color); // Instanciamos la dama con el constructor correspondiente
        System.out.println("Dama creada de color: " + color);
    }

    private static void mover() {
        if (dama == null) {
            System.out.println("Primero debes crear una dama antes de moverla.");
            return;
        }

        Consola.mostrarMenuDirecciones();
        Direccion direccion = Consola.elegirDireccion();
        int pasos = 1;

        if (dama.esDamaEspecial) { // Si es dama especial, preguntamos los pasos
            pasos = Consola.elegirPasos();
        }

        try {
            dama.mover(direccion, pasos); // Intentamos mover la dama
            System.out.println("Dama movida correctamente.");
        } catch (OperationNotSupportedException e) {
            System.out.println("Error al mover la dama: " + e.getMessage());
        }
    }

    private static void mostrarDama() {
        if (dama == null) {
            System.out.println("No hay ninguna dama creada.");
        } else {
            System.out.println("Información de la dama: " + dama);
        }
    }
}
