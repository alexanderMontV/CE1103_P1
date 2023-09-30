package com.estructuras;

import com.seleccionables.Box;
import com.seleccionables.Circle;
import com.seleccionables.LineH;
import com.seleccionables.LineV;

/**
 * Clase que crea una lista doblemente enlazada
 * @author Alex M., Bryan S., Ernesto Z.
 */
public class DoubleEndedList {
    /**
     * Propiedad que representa el elemento inicial de la lista
     */
    private Node head;
    /**
     * Propiedad que representa el elemento final de la lista
     */
    private Node tail;
    /**
     * Propiedad que representa el tamano de la lista
     */
    private int size;
    /**
     * Propiedad que representa el puntero o elemento donde se esta situado
     */
    private Node current;

    /**
     * Constructor de la lista doblemente enlazada
     */
    public DoubleEndedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.current = null;
    }

    /**
     * Metodo que verifica si la lista es vacia mediante su primer elemento
     * @return True or False
     */
    public boolean isEmpty() { return this.head == null; }

    /**
     * Metodo que verifica el tamano de la lista
     * @return tamano de la lista
     */
    public int size() { return this.size; }

    /**
     * Metodo que inserta un nuevo elemento al inicio de la lista
     * @param element objeto que representa un elemento de la lista
     */
    public void insertFirst(Object element) {
        Node newNode = new Node(element);
        this.size++;

        if (this.isEmpty()) {
            this.head = this.tail = newNode;
            this.current = this.head;
        } else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
    }

    /**
     * Metodo que inserta un nuevo elemento al final de la lista
     * @param element objeto que representa un elemento de la lista
     */
    public void insertLast(Object element) {
        Node newNode = new Node(element);
        this.size++;

        if (this.isEmpty()) {
            this.head = this.tail = newNode;
            this.current=this.head;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            this.tail = newNode;
        }
    }

    /**
     * Metodo que quita el primer elemento y lo cambia por el segundo
     * @return cuando la lista es vacia, no retorna nada
     */
    public Node removeFirst() {
        if (this.head != null) {
            Node temp = this.head;
            this.head = this.head.getNext();
            this.size--;
        }
        return null;
    }

    /**
     * Metodo que retorna el ultimo elemento de la lista
     * @return retorna el ultimo elemento de la lista
     */
    public Node getLast() {
        return this.tail;
    }

    /**
     * Metodo que crea los objetos seleccionables dentro de una lista
     * @param num variable generico
     */
    public void inicializar(int num){
        if (num==1){
            this.insertLast(new Circle());
            this.insertLast(new LineH());
            this.insertLast(new Circle());
            this.insertLast(new LineH());
            this.insertLast(new Circle());
            this.insertLast(new LineH());
            this.insertLast(new Circle());
            this.insertLast(new LineH());
            this.insertLast(new Circle());
        } else{
            this.insertLast(new LineV());
            this.insertLast(new Box());
            this.insertLast(new LineV());
            this.insertLast(new Box());
            this.insertLast(new LineV());
            this.insertLast(new Box());
            this.insertLast(new LineV());
            this.insertLast(new Box());
            this.insertLast(new LineV());
        }
    }

    /**
     * Metodo que retorna el elemento actual
     * @return elemento actual
     */
    public Object currentEl(){
        Node crr = (Node) this.current.getElement();
        return crr.getElement();
    }

    /**
     * Metodo para moverse hacia el siguiente elemento de la lista
     */
    public void nextElement (){
        if (this.current.getNext() != null){
        this.current=this.current.getNext();
        }
    }

    /**
     * Metodo para moverse hacia el elemento previo de la lista
     */
    public void prevElement (){
        if (this.current.getPrev() != null){
            this.current=this.current.getPrev();
        }
    }

    /**
     * Metodo para observar la lista entera
     */
    public void displayList() {
        String colP ="";
        Node current = this.head;
        while (current != null) {
            colP+=current.getElement()+"  ";
            current = current.getNext();
        }
        System.out.println(colP);
    }

    /**
     * Metodo para obtener el elemento actual
     * @return
     */
    public Node getCurrent(){
        return  this.current;
    }

    /**
     * Metodo para elegir cual es el elemento actual
     * @param current
     */
    public void setCurrent(Node current){
          this.current = current;
    }

    /**
     * Metodo que pone al primer elemento como el elemento actual
     */
    public void initCurrent(){
        this.current =this.head;
    }

    /**
     * Metodo para obtener el primer elemento
     * @return el primer elemento de la lista
     */
    public Node getHead(){
        return this.head;
    }


}