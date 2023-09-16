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

    public void inicializar(){
        int i;
        for (i=0;i<5;i++){
            this.insertLast(i);
        }
        this.current=this.head;
    }

    public void nextElement (){
        if (this.current.getNext() != null){
        this.current=this.current.getNext();}
    }
    public void prevElement (){
        if (this.current.getPrev() != null){
            this.current=this.current.getPrev();}
    }
    public void displayList() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }
    public Node getCurrent(){
        return  this.current;
    }


}