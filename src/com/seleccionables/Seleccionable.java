package com.seleccionables;

public class Seleccionable {
    private Boolean select;
    private Boolean temp;

    private String label;
    public Seleccionable() {
        this.temp = false;
        this.select = false;
        this.label="";
    }

    public Seleccionable(Boolean seleccionado){
        this.temp=seleccionado;
        this.select=false;
        this.label="";
    }

    public void changeState(){
        this.select = !this.select;
    }

    public void setTemp(boolean status) { this.temp = status; }
    public void setSelect(boolean status) { this.select = status; }

    public Boolean getTemp() {
        return temp;
    }

    public void setTemp(Boolean temp) {
        this.temp = temp;
    }

    public boolean getSelected(){
        return this.select;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
