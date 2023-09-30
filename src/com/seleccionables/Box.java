package com.seleccionables;

/**
 * Clase que crea y maneja las cajas de la interfaz
 * @author Alex M., Bryan S., Ernesto Z.
 */
public class Box {
    /**
     * Propiedad que representa texto
     */
    private String label;
    /**
     * Propiedad que determina si una caja esta llena o vacia
     */
    private Boolean fill;
    /**
     * Propiedad que representa la linea izquierda en una caja
     */
    private LineV left;
    /**
     * Propiedad que representa la linea derecha en una caja
     */
    private LineV right;
    /**
     * Propiedad que representa la linea de arriba en una caja
     */
    private LineH arriba;
    /**
     * Propiedad que representa la linea de abajo en una caja
     */
    private LineH abajo;

    /**
     * Constructor de las cajas
     */
    public Box() {
        this.label = "";
        this.fill = false;
        this.left = null;
        this.right = null;
        this.arriba = null;
        this.abajo = null;
    }

    /**
     * Metodo que pone la linea de arriba de la caja
     * @param arriba la linea de arriba
     */
    public void setUP(LineH arriba){
        this.arriba = arriba;
    }

    /**
     * Metodo que pone la linea de abajo de la caja
     * @param abajo la linea de abajo
     */
    public void setDW(LineH abajo){
        this.abajo = abajo;
    }

    /**
     * Metodo que pone la linea izquierda de la caja
     * @param left la linea izquierda
     */
    public void setLF(LineV left){
        this.left = left;
    }

    /**
     * Metodo que pone la linea derecha de la caja
     * @param right la linea derecha
     */
    public void setRG(LineV right){
        this.right=right;
    }

    /**
     * Metodo que pone el nombre del jugador que lleno la caja
     * @param nombre nombre de un jugador
     */
    public void setName(String nombre){
        if (!this.fill){this.label=nombre; this.fill=true;}
    }

    /**
     * Metodo que revisa si la caja esta llena o no
     * @return True o False
     */
    public boolean isFull(){
        return this.fill;
    }

    /**
     * Metodo que revisa si todos los lados de la caja fueron seleccionados
     * @return True o False
     */
    public boolean getSides(){
        if (this.left.getSelected() && this.right.getSelected() && this.arriba.getSelected() && this.abajo.getSelected()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "BX";
    }
}
