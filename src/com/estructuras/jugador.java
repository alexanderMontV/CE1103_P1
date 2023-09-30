package com.estructuras;

/**
 * Clase que maneja la informacion de un jugador
 * @author Alex M., Bryan S., Ernesto Z.
 */
public class jugador {
    /**
     * Propiedad que representa el nombre del jugador
     */
    private String Nombre;
    /**
     * Propiedad que representa el puerto donde se conecta el jugador
     */
    private int puerto;
    /**
     * Propiedad que representa los puntos del jugador con los cuadros que ha cerrado
     */
    private int cuadrosGanados;

    /**
     * Constructor de los jugadores
     * @param nombre nombre del jugador
     * @param puerto puerto donde se conecta el jugador
     * @param cuadrosGanados numero de cuadros que ha cerrado el jugador
     */
    public jugador(String nombre, int puerto, int cuadrosGanados) {
        Nombre = nombre;
        this.puerto = puerto;
        this.cuadrosGanados = cuadrosGanados;
    }

    /**
     * Metodo que retorna el nombre del jugador
     * @return nombre del jugador
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Metodo para nombrar un jugador
     * @param nombre nombre para el jugador
     */
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    /**
     * Metodo que retorna el puerto donde se conecta el jugador
     * @return puerto donde se conecta el jugador
     */
    public int getPuerto() {
        return puerto;
    }

    /**
     * Metodo para escoger un puerto
     * @param puerto puerto deseea conectar
     */
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    /**
     * Metodo que retorna el numero de cuadros que ha cerrado el jugador
     * @return el numero de cuadros que ha cerrado el jugador
     */
    public int getCuadrosGanados() {
        return cuadrosGanados;
    }

    /**
     * Metodo para escoger cuantos cuadros ha cerrado un jugador
     * @param cuadrosGanados cantidad de puntos deseada
     */
    public void setCuadrosGanados(int cuadrosGanados) {
        this.cuadrosGanados = cuadrosGanados;
    }

    /**
     * Metodo para incrementar el puntaje del jugador
     */
    public void masCaja(){
        this.cuadrosGanados++;
    }
}
