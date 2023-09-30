package com.estructuras;

import com.seleccionables.Box;
import com.seleccionables.Circle;
import com.seleccionables.LineH;
import com.seleccionables.LineV;

/**
 * Clase que crea la matriz de juego
 * @author Alex M., Bryan S., Ernesto Z.
 */
public class Matriz {

    /**
     * Propiedad que representa una fila de la matriz
     */
    private final DoubleEndedList fila;
    /**
     * Propiedad que representa una de las columnas de la matriz
     */
    private final DoubleEndedList col1;
    /**
     * Propiedad que representa una de las columnas de la matriz
     */
    private final DoubleEndedList col2;
    /**
     * Propiedad que representa una de las columnas de la matriz
     */
    private final DoubleEndedList col3;
    /**
     * Propiedad que representa una de las columnas de la matriz
     */
    private final DoubleEndedList col4;
    /**
     * Propiedad que representa una de las columnas de la matriz
     */
    private final DoubleEndedList col5;
    /**
     * Propiedad que representa una de las columnas de la matriz
     */
    private final DoubleEndedList col6;
    /**
     * Propiedad que representa una de las columnas de la matriz
     */
    private final DoubleEndedList col7;
    /**
     * Propiedad que representa una de las columnas de la matriz
     */
    private final DoubleEndedList col8;
    /**
     * Propiedad que representa una de las columnas de la matriz
     */
    private final DoubleEndedList col9;

    /**
     * Propiedad que representa la cantidad de cajas que se han llenado
     */
    private int cajasLlenas;

    /**
     * Propiedad que representa si la matriz esta vacia o no
     */
    private boolean empty;

    /**
     * Constructor de la matriz
     */
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
    }

    /**
     * Metodo que inicializa los componentes de la matriz
     */
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

    /**
     * Metodo que obtiene la columna donde se esta posicionado
     * @param fila una fila de la matriz
     * @return columna actual
     */
    private DoubleEndedList getCurrentCol(DoubleEndedList fila) {
        return (DoubleEndedList) fila.getCurrent().getElement();
    }

    /**
     * Metodo que obtiene una columna de la matriz
     * @param fila una fila de la matriz
     * @return columna pedida
     */
    private DoubleEndedList getCol(Node fila) {
        return (DoubleEndedList) fila.getElement();
    }

    //COMPROBACIONES DE NULL PARA getNext

    /**
     * Metodo para moverse hacia arriba en la matriz
     */
    public void moverArriba(){
        if (getCurrentElement(this.fila.getCurrent()).getClass() == Circle.class){
            this.fila.prevElement();
        }
        else{
            this.fila.prevElement();
            this.fila.prevElement();
        }
    }

    /**
     * Metodo para moverse hacia abajo en la matriz
     */
    public void moverAbajo(){
        if (this.fila.getCurrent().getNext() !=null){
                if (getCurrentElement(this.fila.getCurrent()).getClass() != LineH.class){
                    this.fila.nextElement();
                }
                else{
                    this.fila.nextElement();
                    this.fila.nextElement();
        }}
    }

    /**
     * Metodo para moverse hacia la derecha en la matriz
     */
    public void moverDerecha(){
        Node current=this.fila.getHead();
        if (this.fila.getCurrent().getNext() != null){

            //System.out.println("com.estructuras.Matriz.MD getcurrentElement class" + getCurrentElement(this.fila.getCurrent()).getClass());
                if (getCurrentElement(this.fila.getCurrent()).getClass() != LineV.class){
                    while (current != null) {
                        getCol(current).nextElement();
                        current=current.getNext();
                    }
                }
                else {
                    while (current != null) {
                        getCol(current).nextElement();
                        getCol(current).nextElement();
                        current=current.getNext();
                    }
                }
        }
    }
    /**
     * Metodo para moverse hacia la izquierda en la matriz
     * */
    public void moverIzquierda(){
        Node current=this.fila.getHead();
        if (this.fila.getCurrent().getNext() != null){
            if (getCurrentElement(this.fila.getCurrent()).getClass() != LineV.class){
                while (current != null) {
                    getCol(current).prevElement();
                    current=current.getNext();
                }
            }
            else{
                while (current != null) {
                    getCol(current).prevElement();
                    getCol(current).prevElement();
                    current=current.getNext();
                }
            }
        }
    }

    /**
     * Metodo que retorna la columna actual
     * @return columna actual
     */
    public Node actual(){
        Node col = this.fila.getCurrent();
        DoubleEndedList colum = (DoubleEndedList) col.getElement();
        return colum.getCurrent();
    }

    /**
     * Metodo que pone las cajas dentro de la matriz
     */
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

    /**
     * Metodo que revisa si una caja se lleno
     * @param playerName nombre del jugador
     * @return True o False
     */
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

    /**
     * Metodo que retorna el elemento actual
     * @param currentCol columna actual
     * @return elemento actual
     */
    public Object getCurrentElement(Node currentCol){
        DoubleEndedList cLL = (DoubleEndedList) currentCol.getElement();
        return cLL.getCurrent().getElement();
    }
    /**
     * Metodo que imprime la matriz
     */
    public void printMat(){
        while (this.fila.getCurrent() != null) {
            getCurrentCol(this.fila).displayList();
            this.fila.setCurrent(this.fila.getCurrent().getNext());
        }
        initCurrent();
    }

    /**
     * Metodo que inicializa las filas
     */
    public void initCurrent(){
        this.fila.setCurrent(this.fila.getHead());
        while (this.fila.getCurrent() != null) {
            getCurrentCol(this.fila).initCurrent();
            this.fila.setCurrent(this.fila.getCurrent().getNext());
        }
        this.fila.setCurrent(this.fila.getHead());
    }

    /**
     * Metodo que retorna una fila
     * @return fila
     */
    public DoubleEndedList getFila(){
        return this.fila;
    }

    /**
     * Metodo que revisa si la matriz esta vacia
     * @return True o False
     */
    public Boolean isEmpty(){
        return this.empty;
    }

}
