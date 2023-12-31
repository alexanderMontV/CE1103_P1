package com.estructuras;

import com.seleccionables.Box;
import com.seleccionables.Circle;
import com.seleccionables.LineH;
import com.seleccionables.LineV;

public class Matriz {

    private final DoubleEndedList fila;
    private final DoubleEndedList col1;
    private final DoubleEndedList col2;
    private final DoubleEndedList col3;
    private final DoubleEndedList col4;
    private final DoubleEndedList col5;
    private final DoubleEndedList col6;
    private final DoubleEndedList col7;
    private final DoubleEndedList col8;
    private final DoubleEndedList col9;

    private int cajasLlenas;

    private boolean empty;

    private int pos;

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
        this.empty=true;
        this.cajasLlenas=0;
        this.pos=01;
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
        this.empty=false;
    }
    private DoubleEndedList getCurrentCol(DoubleEndedList fila) {
        return (DoubleEndedList) fila.getCurrent().getElement();
    }

    private DoubleEndedList getCol(Node fila) {
        return (DoubleEndedList) fila.getElement();
    }

    //COMPROBACIONES DE NULL PARA getNext
    public void moverArriba(){
        if (getCurrentElement(this.fila.getCurrent()).getClass() == Circle.class){
            this.fila.prevElement();
            this.pos-=10;
        }
        else{
            this.fila.prevElement();
            this.fila.prevElement();
            this.pos-=20;
        }
    }
    public void moverAbajo(){
        if (this.fila.getCurrent().getNext() !=null){
                if (getCurrentElement(this.fila.getCurrent()).getClass() != LineH.class){
                    this.fila.nextElement();
                    this.pos +=10;
                }
                else{
                    this.fila.nextElement();
                    this.fila.nextElement();
                    this.pos +=20;
        }}
    }

    /**
     * Mover derecha funcional
     */
    public void moverDerecha(){
        Node current=this.fila.getHead();
        if (this.fila.getCurrent().getNext() != null){

            //System.out.println("com.estructuras.Matriz.MD getcurrentElement class" + getCurrentElement(this.fila.getCurrent()).getClass());
                if (getCurrentElement(this.fila.getCurrent()).getClass() != LineV.class){
                    this.pos+=1;
                    while (current != null) {
                        getCol(current).nextElement();
                        current=current.getNext();

                    }
                }
                else {
                    this.pos+=2;
                    while (current != null) {
                        getCol(current).nextElement();
                        getCol(current).nextElement();
                        current=current.getNext();

                    }
                }
        }
    }
    /**f
     * Mover Izquierda funcional
     * */
    public void moverIzquierda(){
        Node current=this.fila.getHead();
        if (this.fila.getCurrent().getNext() != null){
            if (getCurrentElement(this.fila.getCurrent()).getClass() != LineV.class){
                this.pos-=1;
                while (current != null) {
                    getCol(current).prevElement();
                    current=current.getNext();
                }
            }
            else{
                this.pos-=2;
                while (current != null) {
                    getCol(current).prevElement();
                    getCol(current).prevElement();
                    current=current.getNext();
                }
            }
        }
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
                Object currentEl = currentNod.getElement();
                if (currentEl.getClass() == Box.class){
                    ((Box) currentEl).setRG((LineV) currentNod.getNext().getElement());
                    ((Box) currentEl).setLF((LineV) currentNod.getPrev().getElement());
                    ((Box) currentEl).setDW((LineH) nextNode.getElement());
                    ((Box) currentEl).setUP((LineH) prevNode.getElement());
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
        System.out.println("CAJAS INICIALIZADAS - LINEAS DEFINIDAS");
    }

    /*
    *
    * TODO: IMPLEMENTAR CHECKBOXES
    *
    * */
    public Boolean CheckBoxes(String playerName){
        Node current = fila.getHead();
        while (current !=null) {
            DoubleEndedList col = getCol(current);
            Node currentNode = col.getHead();
            while (currentNode !=null){
                if (currentNode.getElement().getClass() == Box.class){
                    Box cajatemp = (Box) currentNode.getElement();
                    if (!cajatemp.isFull() && cajatemp.getSides()){
                        cajatemp.setName(playerName);
                        return true;
                    }
                }
                currentNode=currentNode.getNext();
            }
            current=current.getNext();
        }
        return false;


    }

    public Boolean CheckFull(){
        Node current = fila.getHead();
        while (current !=null) {
            DoubleEndedList col = getCol(current);
            Node currentNode = col.getHead();
            while (currentNode !=null){
                if (currentNode.getElement().getClass() == Box.class){
                    Box cajatemp = (Box) currentNode.getElement();
                    if (!cajatemp.isFull()){
                        return false;
                    }
                }
                currentNode=currentNode.getNext();
            }
            current=current.getNext();
        }
        return true;


    }

    public Object getCurrentElement(Node currentCol){
        DoubleEndedList cLL = (DoubleEndedList) currentCol.getElement();
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
    public DoubleEndedList getFila(){
        return this.fila;
    }

    public Boolean isEmpty(){
        return this.empty;
    }

    public int getPos() {
        return pos;
    }
}
