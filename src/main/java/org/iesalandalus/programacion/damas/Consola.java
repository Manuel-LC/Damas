package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
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

        do {
        System.out.println("Elige un color para la dama:");
        System.out.println("1. Blanco");
        System.out.println("2. Negro");
        System.out.print("Introduce tu elección (1 o 2): ");
        opcionColor = Entrada.entero();
        } while (opcionColor < 1 || opcionColor > 2);

        if (opcionColor == 1) {
            return Color.BLANCO;
        } else {
            return Color.NEGRO;
        }
    }

    public static void mostrarMenuDirecciones () {
        System.out.println("Menú de direcciones disponibles:");
        System.out.println("1. Noroeste");
        System.out.println("2. Noreste");
        System.out.println("3. Suroeste");
        System.out.println("4. Sureste");
    }

    public static Direccion elegirDireccion() {
        int opcionDirecccion;

        do {
            System.out.print("Elige una dirección (1-4): ");
            opcionDirecccion = Entrada.entero();
        } while (opcionDirecccion < 1 || opcionDirecccion > 4);

        if (opcionDirecccion == 1) {
            return Direccion.NOROESTE;
        } else if (opcionDirecccion == 2) {
            return Direccion.NORESTE;
        } else if (opcionDirecccion == 3) {
            return Direccion.SUROESTE;
        } else {
            return Direccion.SURESTE;
        }
    }
}
