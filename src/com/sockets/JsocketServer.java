package com.sockets;

import com.estructuras.Matriz;
import com.estructuras.jugador;
import com.seleccionables.Seleccionable;
import com.serial.SerialClient;

public class JsocketServer {
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
                    } else if (mensajeR.equals("IZ")) {
                        Seleccionable tempc = (Seleccionable) mat.actual().getElement();
                        tempc.setTemp(false);
                        mat.moverIzquierda();
                        Seleccionable tempn = (Seleccionable) mat.actual().getElement();
                        tempn.setTemp(true);
                        runserver.sendMensaje("IZ");
                    } else if (mensajeR.equals("UP")) {
                        Seleccionable tempc = (Seleccionable) mat.actual().getElement();
                        tempc.setTemp(false);
                        mat.moverArriba();
                        Seleccionable tempn = (Seleccionable) mat.actual().getElement();
                        tempn.setTemp(true);
                        runserver.sendMensaje("UP");
                    } else if (mensajeR.equals("DW")) {
                        Seleccionable tempc = (Seleccionable) mat.actual().getElement();
                        tempc.setTemp(false);
                        mat.moverAbajo();
                        Seleccionable tempn = (Seleccionable) mat.actual().getElement();
                        tempn.setTemp(true);
                        runserver.sendMensaje("DW");
                    } else if (mensajeR.equals("OK"))

                        if (mat.CheckBoxes("nombre")){
                        Seleccionable select = (Seleccionable) mat.actual().getElement();
                        select.setSelect(true);
                        if (!mat.CheckBoxes(templayer.getNombre())){;
                            runserver.sendMensaje("OK");}
                        else if (mat.CheckFull()){
                            runserver.sendMensaje("gameover");
                        }
                        else{
                            runserver.sendMensaje("ganoCaja");
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
