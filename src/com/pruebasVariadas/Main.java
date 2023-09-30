package com.pruebasVariadas;

import com.estructuras.Matriz;
import com.interfaz.GameScreen;


public class Main {
    public static void main(String[] args) throws Exception {
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
        GameScreen hola = new GameScreen();
        hola.init();


        //System.out.println(mat.actual().getElement());
    }
}
