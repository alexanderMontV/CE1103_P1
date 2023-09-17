public class Matriz {

    private DoubleEndedList fila;
    private DoubleEndedList col1;
    private DoubleEndedList col2;
    private DoubleEndedList col3;
    private DoubleEndedList col4;
    private DoubleEndedList col5;

    public Matriz(){
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
        this.col1.inicializar(1);
        this.col2.inicializar(2);
        this.col3.inicializar(3);
        this.col4.inicializar(4);
        this.col5.inicializar(5);
    }
    public void moverArriba(){
        this.fila.prevElement();
    }
    public void moverAbajo(){
        this.fila.nextElement();
    }
    public void moverDerecha(){
        this.col1.nextElement();
        this.col2.nextElement();
        this.col3.nextElement();
        this.col4.nextElement();
        this.col5.nextElement();
    }
    public void moverIzquierda(){
        this.col1.prevElement();
        this.col2.prevElement();
        this.col3.prevElement();
        this.col4.prevElement();
        this.col5.prevElement();
    }
    public Node actual(){
        Node col = this.fila.getCurrent();
        DoubleEndedList colum = (DoubleEndedList) col.getElement();
        return colum.getCurrent();
    }

}
