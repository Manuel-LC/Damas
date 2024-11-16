package org.iesalandalus.programacion.damas;

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
}
