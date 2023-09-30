package com.estructuras;

import com.seleccionables.Box;
import com.seleccionables.Circle;
import com.seleccionables.LineH;
import com.seleccionables.LineV;

public class DoubleEndedList {

    private Node head;
    private Node tail;
    private int size;

    private Node current;


    public DoubleEndedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.current = null;
    }

    public boolean isEmpty() { return this.head == null; }

    public int size() { return this.size; }

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

    public Node removeFirst() {
        if (this.head != null) {
            Node temp = this.head;
            this.head = this.head.getNext();
            this.size--;
        }
        return null;
    }
    public Node getLast() {
        return this.tail;
    }

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
    public Object currentEl(){
        Node crr = (Node) this.current.getElement();
        return crr.getElement();
    }

    public void nextElement (){
        if (this.current.getNext() != null){
        this.current=this.current.getNext();
        }
    }
    public void prevElement (){
        if (this.current.getPrev() != null){
            this.current=this.current.getPrev();
        }
    }
    public void displayList() {
        String colP ="";
        Node current = this.head;
        while (current != null) {
            colP+=current.getElement()+"  ";
            current = current.getNext();
        }
        System.out.println(colP);
    }
    public Node getCurrent(){
        return  this.current;
    }
    public void setCurrent(Node current){
          this.current = current;
    }

    public void initCurrent(){
        this.current =this.head;
    }

    public Node getHead(){
        return this.head;
    }


}