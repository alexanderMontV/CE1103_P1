package com.sockets;

import com.estructuras.Matriz;
import com.estructuras.jugador;
import com.seleccionables.Seleccionable;
import com.serial.SerialClient;

/**
 * Clase que inicializa el servidor y maneja logica del juego
 * @author Alex M., Bryan S., Ernesto Z.
 */
public class JsocketServer {
    /**
     * Clase que inicializa el servidor y maneja logica del juego
     * @author Alex M., Bryan S., Ernesto Z.
     */
    public static void main(String[] args) {
        serverRun runserver = new serverRun();
        SerialClient msc = new SerialClient();
        msc.open();
        Matriz mat = new Matriz();
        mat.initMatrix();
        mat.printMat();
        mat.setBoxes();
        try {
            while (true) {
                String mensajeR = msc.getMesg();
                if (mensajeR != null) {
                    jugador templayer= (jugador) runserver.listaJugadores.getFirst().getElement();
                    if (mensajeR.equals("DR")){
                        Seleccionable tempc = (Seleccionable) mat.actual().getElement();
                        tempc.setTemp(false);
                        mat.moverDerecha();
                        Seleccionable tempn = (Seleccionable) mat.actual().getElement();
                        tempn.setTemp(true);
                        runserver.sendMensaje("DR");
                        runserver.setActual(mat.getPos());
                    } else if (mensajeR.equals("IZ")) {
                        Seleccionable tempc = (Seleccionable) mat.actual().getElement();
                        tempc.setTemp(false);
                        mat.moverIzquierda();
                        Seleccionable tempn = (Seleccionable) mat.actual().getElement();
                        tempn.setTemp(true);
                        runserver.sendMensaje("IZ");
                        runserver.setActual(mat.getPos());
                    } else if (mensajeR.equals("UP")) {
                        Seleccionable tempc = (Seleccionable) mat.actual().getElement();
                        tempc.setTemp(false);
                        mat.moverArriba();
                        Seleccionable tempn = (Seleccionable) mat.actual().getElement();
                        tempn.setTemp(true);
                        runserver.sendMensaje("UP");
                        runserver.setActual(mat.getPos());
                    } else if (mensajeR.equals("DW")) {
                        Seleccionable tempc = (Seleccionable) mat.actual().getElement();
                        tempc.setTemp(false);
                        mat.moverAbajo();
                        Seleccionable tempn = (Seleccionable) mat.actual().getElement();
                        tempn.setTemp(true);
                        runserver.sendMensaje("DW");
                        runserver.setActual(mat.getPos());
                    } else if (mensajeR.equals("OK"))

                        if (mat.CheckBoxes("nombre")){
                        Seleccionable select = (Seleccionable) mat.actual().getElement();
                        select.setSelect(true);
                        if (!mat.CheckBoxes(templayer.getNombre())){;
                            runserver.sendMensaje("OK");
                            runserver.setActual(mat.getPos());}
                        else if (mat.CheckFull()){
                            runserver.sendMensaje("gameover");
                            runserver.setActual(mat.getPos());
                        }
                        else{
                            runserver.sendMensaje("ganoCaja");
                            runserver.setActual(mat.getPos());
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
