package com.estructuras;

public class jugador {
    private String Nombre;
    private int puerto;
    private int cuadrosGanados;

    public jugador(String nombre, int puerto, int cuadrosGanados) {
        Nombre = nombre;
        this.puerto = puerto;
        this.cuadrosGanados = cuadrosGanados;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public int getCuadrosGanados() {
        return cuadrosGanados;
    }

    public void setCuadrosGanados(int cuadrosGanados) {
        this.cuadrosGanados = cuadrosGanados;
    }

    public void masCaja(){
        this.cuadrosGanados++;
    }
}
