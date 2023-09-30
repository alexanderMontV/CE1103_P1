package com.estructuras;

/**
 * Clase que crea y maneja la cola
 * @author Alex M., Bryan S., Ernesto Z.
 */
public class Queue {

    /**
     * Propiedad que representa una lista
     */
    private DoubleEndedList list;

    /**
     * Constructor de la cola
     */
    public Queue() {
        this.list = new DoubleEndedList();
    }

    /**
     * Metodo que mete a un nuevo elemento al final de la cola
     * @param element
     */
    public void enqueue(Object element) { this.list.insertLast(element); }

    /**
     * Metodo que quita el primer elemento de la cola
     * @param element objeto que representa un elemento de la lista
     * @return cola con un nuevo elemento al inicio
     */
    public Object dequeue(Object element) { return this.list.removeFirst(); }

    /**
     * Metodo que quita el primer elemento de la cola
     */
    public void dequeue(){
        this.list.removeFirst();
    }

    /**
     * Metodo que obtiene el primer elemento de la cola
     * @return el primer elemento de la cola
     */
    public Node getFirst(){
      return this.list.getHead();
    }

}
