public class Node {

    private Object element;
    private Node next;

    public Node(Object element) {
        this.next = null;
        this.element = element;
    }

    public Object getElement() { return this.element; }
    public Node getNext() { return this.next; }

    public void setElement(Object element) { this.element = element; }
    public void setNext(Node node) { this.next = node; }

}