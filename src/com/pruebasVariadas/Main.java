package com.pruebasVariadas;

import com.estructuras.Matriz;


public class Main {
    public static void main(String[] args) {
        Matriz mat = new Matriz();
        System.out.println(mat.isEmpty());
        mat.initMatrix();
        System.out.println(mat.isEmpty());
        mat.printMat();
        mat.setBoxes();
        System.out.println(mat.actual().getElement());
        System.out.println("- - - - - - ");
        System.out.println("mover derecha y abajo (BX EXPECTED)");
        mat.moverDerecha();
        System.out.println(mat.actual());
        mat.moverAbajo();
        System.out.println(mat.actual());


        //System.out.println(mat.actual().getElement());
    }
}
