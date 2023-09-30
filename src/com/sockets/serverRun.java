package com.sockets;

import com.estructuras.Queue;
import com.estructuras.jugador;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serverRun implements Runnable {
    public serverRun() {
        Thread escucho = new Thread(this);
        escucho.start();
    }

    @Override
    public void run() {
        Queue listaJugadores= new Queue();
        try {
            ServerSocket server = new ServerSocket(9999); //Socket de entrada que recibe los mensajes

            while (true) {//queda a la espera de un nuevo mensaje

                Socket mysocket = server.accept();
                ObjectInputStream paqueteEntrada = new ObjectInputStream(mysocket.getInputStream()); //Flujo de datos usando mysocket inputStreamReader (Json String)
                String msg = (String) paqueteEntrada.readObject();
                JsonObject jobj = new JsonParser().parse(msg).getAsJsonObject();
                String mensajeRecibido = jobj.get("mensaje").getAsString();

                if (mensajeRecibido.equals("online") && jobj.get("puerto").getAsInt()!=0){
                    JsonObject juga = jobj.get("data").getAsJsonObject();
                    System.out.println(juga);
                    listaJugadores.enqueue(new jugador(juga.get("Nombre").getAsString(),juga.get("puerto").getAsInt(),juga.get("cuadrosGanados").getAsInt()));
                    System.out.println(listaJugadores.getFirst().getElement());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
