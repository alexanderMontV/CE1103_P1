public class Matriz {

    private DoubleEndedList fila;
    private DoubleEndedList col1;
    private DoubleEndedList col2;
    private DoubleEndedList col3;
    private DoubleEndedList col4;
    private DoubleEndedList col5;
    private DoubleEndedList col6;
    private DoubleEndedList col7;
    private DoubleEndedList col8;
    private DoubleEndedList col9;

    public Matriz(){
        this.fila = new DoubleEndedList();
        this.col1 = new DoubleEndedList();
        this.col2 = new DoubleEndedList();
        this.col3 = new DoubleEndedList();
        this.col4 = new DoubleEndedList();
        this.col5 = new DoubleEndedList();
        this.col6 = new DoubleEndedList();
        this.col7 = new DoubleEndedList();
        this.col8 = new DoubleEndedList();
        this.col9 = new DoubleEndedList();
    }
    public void initMatrix(){
        this.fila.insertLast(this.col1);
        this.fila.insertLast(this.col2);
        this.fila.insertLast(this.col3);
        this.fila.insertLast(this.col4);
        this.fila.insertLast(this.col5);
        this.fila.insertLast(this.col6);
        this.fila.insertLast(this.col7);
        this.fila.insertLast(this.col8);
        this.fila.insertLast(this.col9);
        int i=1;
        while (this.fila.getCurrent() != null) {
            getCurrentCol(this.fila).inicializar(i%2);
            i++;
            this.fila.setCurrent(this.fila.getCurrent().getNext());
        }
        initCurrent();

    }

    private DoubleEndedList getCurrentCol(DoubleEndedList fila) {
        return (DoubleEndedList) fila.getCurrent().getElement();
    }

    public void moverArriba(){
        if (getCurrentElement(this.fila.getCurrent()).getClass() == Circle.class){
            this.fila.prevElement();
        }
        else{
            this.fila.prevElement();
            this.fila.prevElement();
        }
    }
    public void moverAbajo(){
        if (getCurrentElement(this.fila.getCurrent()).getClass() == Circle.class){
            this.fila.nextElement();
        }
        else{
            this.fila.nextElement();
            this.fila.nextElement();
        }
    }

    public void moverDerecha(){
        while (this.fila.getCurrent() != null) {
            if (getCurrentElement(this.fila.getCurrent()).getClass() == Circle.class && this.fila.getCurrent().getNext() != null){
                getCurrentCol(this.fila).nextElement();
            }
            else if (this.fila.getCurrent().getNext().getNext() != null){
                getCurrentCol(this.fila).nextElement();
                getCurrentCol(this.fila).nextElement();
            }
                this.fila.nextElement();
        }
    }
    public void moverIzquierda(){
        while (this.fila.getCurrent() != null) {
            if (getCurrentElement(this.fila.getCurrent()).getClass() == Circle.class){
                getCurrentCol(this.fila).prevElement();
            }
            else{
                getCurrentCol(this.fila).prevElement();
                getCurrentCol(this.fila).prevElement();
            }
            this.fila.nextElement();
        }
        this.fila.resetCurrent();
    }
    public Node actual(){
        Node col = this.fila.getCurrent();
        DoubleEndedList colum = (DoubleEndedList) col.getElement();
        return colum.getCurrent();
    }
    public void setBoxes(){
        initCurrent();
        DoubleEndedList Col;
        Node currentNod;
        Node prevNode = null;
        Node nextNode = null;
        DoubleEndedList prevCol =null;
        DoubleEndedList nextCol=null;
        Node currentCol = this.fila.getCurrent();
        while (currentCol != null) {
            Col = (DoubleEndedList) currentCol.getElement();
            currentNod= Col.getCurrent();
            if (currentCol.getPrev() !=null){prevCol= (DoubleEndedList) currentCol.getPrev().getElement();
                prevNode=prevCol.getCurrent();
            }
            if (currentCol.getNext() != null){nextCol= (DoubleEndedList) currentCol.getNext().getElement();
                nextNode=nextCol.getCurrent();
            }
            while (currentNod !=null){
                System.out.println("columna");
                Object currentEl = currentNod.getElement();
                if (currentEl.getClass() == Box.class){
                    ((Box) currentEl).setRG((LineV) currentNod.getNext().getElement());
                    ((Box) currentEl).setLF((LineV) currentNod.getPrev().getElement());
                    ((Box) currentEl).setDW((LineH) nextNode.getElement());
                    ((Box) currentEl).setUP((LineH) prevNode.getElement());
                    System.out.println("es un caja");
                }
                if (currentCol.getPrev() != null && currentCol.getNext() !=null){
                    prevNode=prevNode.getNext();
                    nextNode=nextNode.getNext();
                }
                currentNod=currentNod.getNext();
            }
            prevCol=Col;
            currentCol=currentCol.getNext();
            if (currentCol != null && currentCol.getNext() != null){
                nextCol= (DoubleEndedList) currentCol.getNext().getElement();
            }
        }
        System.out.println("fin");
    }
    public void CheckBoxes(String playerName){


    }

    public Object getCurrentElement(Node currentCol){
        DoubleEndedList cLL = (DoubleEndedList) currentCol.getNext().getElement();
        return cLL.getCurrent().getElement();
    }
    public void printMat(){
        while (this.fila.getCurrent() != null) {
            getCurrentCol(this.fila).displayList();
            this.fila.setCurrent(this.fila.getCurrent().getNext());
        }
        initCurrent();
    }
    public void initCurrent(){
        this.fila.setCurrent(this.fila.getHead());
        while (this.fila.getCurrent() != null) {
            getCurrentCol(this.fila).initCurrent();
            this.fila.setCurrent(this.fila.getCurrent().getNext());
        }
        this.fila.setCurrent(this.fila.getHead());
    }

}
