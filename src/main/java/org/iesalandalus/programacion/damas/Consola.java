package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    //Constructor privado
    private Consola() {
    }

    // Método que muestra el menú
    public static void mostrarMenu() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Programa que crea damas y simula su movimiento en el tablero");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("1.- Crear una dama por defecto.");
        System.out.println("2.- Crear una dama eligiendo su color.");
        System.out.println("3.- Mover dama.");
        System.out.println("");
        System.out.println("0.- Salir.");
        System.out.println("");
    }

    public static int elegirOpcionMenu() {
        int opcion;

        do {
            System.out.println("Elige una opción (0-3): ");
            opcion = Entrada.entero();
        }while(opcion < 0 || opcion > 3);

        return opcion;
    }

    public static Color elegirOpcion() {
        int opcionColor;

        System.out.println("Elige un color para la dama:");
        System.out.println("1. Blanco");
        System.out.println("2. Negro");
        System.out.print("Introduce tu elección (1 o 2): ");
        opcionColor = Entrada.entero();

        while (opcionColor < 1 || opcionColor > 2) {
            System.out.println("Opción no válida. Elige 1 (Blanco) o 2 (Negro).");
            opcionColor = Entrada.entero();
        }

        if (opcionColor == 1) {
            return Color.BLANCO;
        } else {
            return Color.NEGRO;
        }
    }

    public static void mostrarMenuDirecciones () {
        System.out.println("Menú de direcciones disponibles:");
        System.out.println("1. Noreste");
        System.out.println("2. Sureste");
        System.out.println("3. Suroeste");
        System.out.println("4. Noroeste");
    }
}
