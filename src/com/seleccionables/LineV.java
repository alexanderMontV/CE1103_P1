package com.seleccionables;

/**
 * Clase que crea y maneja las lineas verticales de la interfaz
 * @author Alex M., Bryan S., Ernesto Z.
 */
public class LineV extends Seleccionable {

    /**
     * Constructor de las lineas verticales
     */
    public LineV() {
        super();
    }

    public LineV(Boolean seleccionado) {
        super(seleccionado);
    }

    @Override
    public String toString() {
        return "LV";
    }
}
