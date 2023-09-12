public class DoubleEndedList {

    private Node head;
    private Node tail;
    private int size;

    public DoubleEndedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() { return this.head == null; }

    public int size() { return this.size; }

    public void insertFirst(Object element) {
        Node newNode = new Node(element);
        this.size++;

        if (this.isEmpty()) {
            this.head = this.tail = newNode;
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
        } else {
            this.tail.setNext(newNode);
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

}