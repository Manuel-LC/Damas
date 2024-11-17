package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.damas.modelo.Dama;

public class MainApp {

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
}
