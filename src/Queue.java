public class Queue {

    private DoubleEndedList list;

    public void enqueue(Object element) { this.list.insertLast(element); }
    public Object dequeue(Object element) { return this.list.removeFirst(); }

}
