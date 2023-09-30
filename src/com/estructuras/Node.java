package com.estructuras;

/**
 * Clase que crea y maneja nodos
 * @author Alex M., Bryan S., Ernesto Z.
 */
public class Node {

    /**
     * Propiedad que representa un elemento
     */
    private Object element;
    /**
     * Propeidad que representa el siguiente elemento
     */
    private Node next;
    /**
     * Propiedad que representa el elemento previo
     */
    private Node prev;


    /**
     * Constructor de nodos
     * @param element elemento
     */
    public Node(Object element) {
        this.next = null;
        this.element = element;
        this.prev = null;
    }

    /**
     * Metodo que retorna un elemento
     * @return elemento
     */
    public Object getElement() { return this.element; }

    /**
     * Metodo que retorna el siguiente nodo
     * @return siguiente nodo
     */
    public Node getNext() { return this.next; }

    /**
     * Metodo que retorna el nodo previo
     * @return nodo previo
     */
    public Node getPrev() { return this.prev; }

    /**
     * Metodo para poner un elemento
     * @param element elemento
     */
    public void setElement(Object element) { this.element = element; }

    /**
     * Metodo para poner el siguiente nodo
     * @param node nodo
     */
    public void setNext(Node node) { this.next = node; }

    /**
     * Metodo para poner el nodo previo
     * @param node nodo
     */
    public void setPrev(Node node) { this.prev = node; }

}