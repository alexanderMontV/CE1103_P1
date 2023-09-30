package com.estructuras;

public class Queue {

    private DoubleEndedList list;

    public Queue() {
        this.list = new DoubleEndedList();
    }

    public void enqueue(Object element) { this.list.insertLast(element); }
    public Object dequeue(Object element) { return this.list.removeFirst(); }

    public Node getFirst(){
      return this.list.getHead();
    }

}
