package testjson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class jSocketOut {
    public static void main(String[] args) {
        try {
            Socket mysocket = new Socket("localhost", 9999); //envía el paquete offline al server para indicar que el cliente está en se desconectó
            String a = "Hola enviado a traves de gson";
            Gson gson = new GsonBuilder().create();
            Object msg = gson.toJson(a);

            ObjectOutputStream flujo = new ObjectOutputStream(mysocket.getOutputStream());
            flujo.writeObject(msg);

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
