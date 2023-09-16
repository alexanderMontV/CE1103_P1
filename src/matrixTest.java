public class matrixTest {
    public static void main(String[] args) {
        DoubleEndedList fila = new DoubleEndedList();
        DoubleEndedList col1 = new DoubleEndedList();
        DoubleEndedList col2 = new DoubleEndedList();
        DoubleEndedList col3 = new DoubleEndedList();
        DoubleEndedList col4 = new DoubleEndedList();
        DoubleEndedList col5 = new DoubleEndedList();
        fila.insertLast(col1);
        fila.insertLast(col2);
        fila.insertLast(col3);
        fila.insertLast(col4);
        fila.insertLast(col5);
        col1.inicializar();
        col2.inicializar();
        col3.inicializar();
        col4.inicializar();
        col5.inicializar();

        col5.displayList();

        Node hola = fila.getLast();
        DoubleEndedList vam = (DoubleEndedList) hola.getElement();
        Node hello = vam.getLast();
        System.out.println(hello.getElement());

    }
}
