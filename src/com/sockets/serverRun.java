package com.sockets;

import com.estructuras.DoubleEndedList;
import com.estructuras.Node;
import com.estructuras.Queue;
import com.estructuras.jugador;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serverRun implements Runnable {

    Queue listaJugadores= new Queue();
    public serverRun() {
        Thread escucho = new Thread(this);
        escucho.start();
    }

    @Override
    public void run() {
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
                mysocket.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void sendMensaje(String key) throws IOException {
            //mensaje genérico jugadores espera.
            if (key.equals("OK")) {
                DoubleEndedList listatodos = this.listaJugadores.getList();
                Node current = listatodos.getHead();
                while (current != null) {
                    jugador tempJugador = (jugador) current.getElement();
                    Socket socketDestino = new Socket("localhost", tempJugador.getPuerto()); //Socket salida
                    ObjectOutputStream paqueteE = new ObjectOutputStream(socketDestino.getOutputStream());
                    //TODO Enviar para Actualizar las matrices clientes
                    JsonObject jobj = new JsonObject();
                    jobj.addProperty("mensaje", "OK");
                    jobj.addProperty("data", "actualizar");
                    String jsonO = String.valueOf(jobj);
                    paqueteE.writeObject("paqueteR");
                    paqueteE.close();
                    socketDestino.close();
                    System.out.println("boton OK en SR");
                    current = current.getNext();
                }
                listaJugadores.enqueue(listaJugadores.getFirst());
                listaJugadores.dequeue();

            }
            else if (key.equals("ganoCaja")){
                DoubleEndedList listatodos = this.listaJugadores.getList();
                Node current = listatodos.getHead();
                while (current != null) {
                    jugador tempJugador = (jugador) current.getElement();
                    Socket socketDestino = new Socket("localhost", tempJugador.getPuerto()); //Socket salida

                    ObjectOutputStream paqueteE = new ObjectOutputStream(socketDestino.getOutputStream());

                    //TODO Enviar para Actualizar las matrices clientes
                    JsonObject jobj = new JsonObject();
                    jobj.addProperty("mensaje", "OK");
                    jobj.addProperty("data", "actualizar");
                    String jsonO = String.valueOf(jobj);
                    paqueteE.writeObject("paqueteR");

                    paqueteE.close();

                    socketDestino.close();
                    System.out.println("boton OK en SR");

                    current = current.getNext();
                }
            } else if (key.equals("gameover")) {
                DoubleEndedList listatodos = this.listaJugadores.getList();
                Node current = listatodos.getHead();
                while (current != null) {
                    jugador tempJugador = (jugador) current.getElement();
                    Socket socketDestino = new Socket("localhost", tempJugador.getPuerto()); //Socket salida

                    ObjectOutputStream paqueteE = new ObjectOutputStream(socketDestino.getOutputStream());

                    //TODO Enviar para Actualizar las matrices clientes
                    JsonObject jobj = new JsonObject();
                    jobj.addProperty("mensaje", "OK");
                    jobj.addProperty("data", "gameover");
                    String jsonO = String.valueOf(jobj);
                    paqueteE.writeObject("paqueteR");

                    paqueteE.close();

                    socketDestino.close();
                    System.out.println("boton OK en SR");

                    current = current.getNext();
                }
            }
            else {
                DoubleEndedList listatodos = this.listaJugadores.getList();
                Node current = listatodos.getHead();
                while (current != null) {
                    jugador tempJugador = (jugador) current.getElement();
                    Socket socketDestino = new Socket("localhost", tempJugador.getPuerto()); //Socket salida

                    ObjectOutputStream paqueteE = new ObjectOutputStream(socketDestino.getOutputStream());

                    //TODO Enviar para Actualizar las matrices clientes
                    JsonObject jobj = new JsonObject();
                    jobj.addProperty("mensaje", "OK");
                    jobj.addProperty("data", "actualizar");
                    String jsonO = String.valueOf(jobj);
                    paqueteE.writeObject("paqueteR");

                    paqueteE.close();

                    socketDestino.close();
                    System.out.println("boton OK en SR");

                    current = current.getNext();
                }
                //Mensaje especial al jugador de turno
                jugador primerJugador = (jugador) this.listaJugadores.getFirst().getElement();
                Socket socketDestino = new Socket("localhost", primerJugador.getPuerto()); //Socket salida

                ObjectOutputStream paqueteE = new ObjectOutputStream(socketDestino.getOutputStream());

                //TODO envio JSON
                JsonObject jobj = new JsonObject();

                jobj.addProperty("mensaje", "yourturn");
                jobj.addProperty("data", key);
                String jsonO = String.valueOf(jobj);

                paqueteE.writeObject("Se ha movido");

                paqueteE.close();

                socketDestino.close();
            }
    }
}
