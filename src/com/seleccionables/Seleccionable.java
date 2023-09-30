package com.seleccionables;

/**
 * Clase que maneja los objetos interactuables de la matriz
 * @author Alex M., Bryan S., Ernesto Z.
 */
public class Seleccionable {
    /**
     * Propiedad que indica si hay algo seleccionado
     */
    private Boolean select;
    /**
     * Propiedad que representa un estado temporario
     */
    private Boolean temp;
    /**
     * Propiedad que representa texto
     */
    private String label;

    /**
     * Constructor para los seleccionables
     */
    public Seleccionable() {
        this.temp = false;
        this.select = false;
        this.label="";
    }

    /**
     * Constructor para los seleccionables
     * @param seleccionado indica si hay algo seleccionado
     */
    public Seleccionable(Boolean seleccionado){
        this.temp=seleccionado;
        this.select=false;
        this.label="";
    }

    /**
     * Metodo que alterna el estado de seleccionado
     */
    public void changeState(){
        this.select = !this.select;
    }

    /**
     * Metodo que
     * @param status
     */
    public void setTemp(boolean status) { this.temp = status; }

    /**
     * Metodo que
     * @param status
     */
    public void setSelect(boolean status) { this.select = status; }

    /**
     * Metodo que retorna
     * @return
     */
    public Boolean getTemp() {
        return temp;
    }

    public void setTemp(Boolean temp) {
        this.temp = temp;
    }

    public boolean getSelected(){
        return this.select;
    }
}
