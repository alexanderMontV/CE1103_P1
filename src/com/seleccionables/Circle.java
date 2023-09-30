package com.seleccionables;

/**
 * Clase que crea los circulos dentro de la interfaz
 * @author Alex M., Bryan S., Ernesto Z.
 */
public class Circle extends Seleccionable {

    /**
     * Propiedad que representa un estado temporario
     */
    private boolean tempSelect;

    /**
     * Constructor del circulo
     */
    public Circle() {
        this.tempSelect=false;
    }

    public void set(boolean status) { this.tempSelect = status; }


    @Override
    public String toString() {
        return "CR";
    }
}