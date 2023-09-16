public class matrixTest {

    private DoubleEndedList fila;
    private DoubleEndedList col1;
    private DoubleEndedList col2;
    private DoubleEndedList col3;
    private DoubleEndedList col4;
    private DoubleEndedList col5;

    public matrixTest(){
        this.fila = new DoubleEndedList();
        this.col1 = new DoubleEndedList();
        this.col2 = new DoubleEndedList();
        this.col3 = new DoubleEndedList();
        this.col4 = new DoubleEndedList();
        this.col5 = new DoubleEndedList();
    }
    public void initMatrix(){
        this.fila.insertLast(this.col1);
        this.fila.insertLast(this.col2);
        this.fila.insertLast(this.col3);
        this.fila.insertLast(this.col4);
        this.fila.insertLast(this.col5);
        this.col1.inicializar();
        this.col2.inicializar();
        this.col3.inicializar();
        this.col4.inicializar();
        this.col5.inicializar();
    }
}
