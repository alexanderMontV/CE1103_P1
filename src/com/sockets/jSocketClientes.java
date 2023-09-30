package com.sockets;

import com.estructuras.jugador;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * Clase que comunica datos especificos de un cliente con el servidor
 * @author Alex M., Bryan S., Ernesto Z.
 */
public class jSocketClientes {
    /**
     * Metodo principal de la clase
     */
    public static void main(String[] args) {
        clientesRun clienteescucha = new clientesRun();
        try {
            while(clienteescucha.getMyPort() ==0){
                System.out.println("waitig....");
                TimeUnit.SECONDS.sleep(1);
            }
            int myPort=clienteescucha.getMyPort();
            String player = new Gson().toJson(new jugador("player:"+myPort,myPort,0));
            JsonObject jdor = new Gson().fromJson(player, JsonObject.class);
            //System.out.println(player);
            Socket mysocket = new Socket("localhost", 9999); //envía el paquete offline al server para indicar que el cliente está en se desconectó
            JsonObject jobj = new JsonObject();

            jobj.addProperty("puerto",myPort);
            jobj.addProperty("mensaje","online");
            jobj.add("data",jdor);
            String jsonO = String.valueOf(jobj);

            ObjectOutputStream flujo = new ObjectOutputStream(mysocket.getOutputStream());
            flujo.writeObject(jsonO);

            mysocket.close();

            //NOTA: Se añade System.exit a todas las exepciones para evitar que el app no ser cierre si encuentra un error
        } catch (UnknownHostException ex) {
            System.exit(0);
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            System.exit(0);
            throw new RuntimeException(ex);
        }catch (Exception e2) {
            System.exit(0);
            System.out.println("Error desconocido 2");
        }
    }
}
