package com.seleccionables;

/**
 * Clase que crea y maneja las lienas horizontales de la interfaz
 * @author Alex M., Bryan S., Ernesto Z.
 */
public class LineH extends Seleccionable {

    /**
     * Constructor de las lineas horizontales
     */
    public LineH() {
        super();
    }

    public LineH(Boolean seleccionado) {
        super(seleccionado);
    }

    @Override
    public String toString() {
        return "LH";
    }
}
