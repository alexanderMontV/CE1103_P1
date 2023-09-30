package com.estructuras;

public class Node {

    private Object element;
    private Node next;

    private Node prev;

    public Node(Object element) {
        this.next = null;
        this.element = element;
        this.prev = null;
    }

    public Object getElement() { return this.element; }
    public Node getNext() { return this.next; }
    public Node getPrev() { return this.prev; }

    public void setElement(Object element) { this.element = element; }
    public void setNext(Node node) { this.next = node; }
    public void setPrev(Node node) { this.prev = node; }

}