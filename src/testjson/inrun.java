package testjson;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class inrun implements Runnable {
    public inrun() {
        Thread escucho = new Thread(this);
        escucho.start();
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(9999); //Socket de entrada que recibe los mensajes

            //paqueteDato paqueteR;

            while (true) {//queda a la espera de un nuevo mensaje

                Socket mysocket = server.accept();
                ObjectInputStream paqueteEntrada = new ObjectInputStream(mysocket.getInputStream()); //Flujo de datos usando mysocket inputStreamReader (Json String)
                String msg = (String) paqueteEntrada.readObject();
                System.out.println(msg);
                JsonObject jobj = new JsonParser().parse(msg).getAsJsonObject();
                String mensajeRecivido = jobj.get("mensaje").getAsString();

                if (mensajeRecivido.equals("online")){
                    System.out.println("El cliente está online");
                    System.out.println("puerto del cliente:"+ jobj.get("puerto").getAsString());
                    Socket socketDestino = new Socket("localhost", jobj.get("puerto").getAsInt()); //Socket salida
                    ObjectOutputStream paqueteE = new ObjectOutputStream(socketDestino.getOutputStream());
                    paqueteE.writeObject("Hola socket destino, gracias por jugar");
                    paqueteE.close();
                    socketDestino.close();
                    mysocket.close();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
