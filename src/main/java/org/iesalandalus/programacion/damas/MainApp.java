package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.damas.modelo.Dama;

public class MainApp {
    public static void main(String[] args) {
        int opcion=0;

        do {

            try {
                Consola.mostrarMenu(); // Mostramos el menú principal
                opcion = Consola.elegirOpcionMenu(); // Pedimos la opción al usuario
                ejecutarOpcion(opcion); // Ejecutamos la opción seleccionada
                if (opcion != 0) {
                    mostrarDama(); // Muestra información de la dama mientras no se elija la opción de salir
                }
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 0); // Continuamos mientras no elijamos salir
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
        System.out.println("");
    }

    private static void mover() {
        if (dama == null) {
            System.out.println("Primero debes crear una dama antes de moverla.");
            return;
        }

        Consola.mostrarMenuDirecciones();
        Direccion direccion = Consola.elegirDireccion();
        int pasos = 1;

        if (dama.isEsDamaEspecial()) { // Si es dama especial, preguntamos los pasos
            pasos = Consola.elegirPasos();
        }

        try {
            dama.mover(direccion, pasos); // Intentamos mover la dama
            System.out.println("Dama movida correctamente.");
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
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
