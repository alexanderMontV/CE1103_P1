package com.seleccionables;

public class Box extends Seleccionable {
    private String label;
    private Boolean fill;
    private LineV left;
    private LineV right;
    private LineH arriba;
    private LineH abajo;

    public Box() {
        this.label = "";
        this.fill = false;
        this.left = null;
        this.right = null;
        this.arriba = null;
        this.abajo = null;
    }
    public void setUP(LineH arriba){
        this.arriba = arriba;
    }
    public void setDW(LineH abajo){
        this.abajo = abajo;
    }
    public void setLF(LineV left){
        this.left = left;
    }
    public void setRG(LineV right){
        this.right=right;
    }

    public void setName(String nombre){
        if (!this.fill){this.label=nombre; this.fill=true;}
    }

    public boolean isFull(){
        return this.fill;
    }
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
