package testjson;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class jSocketOut {
    public static void main(String[] args) {
        outrun clienteescucha = new outrun();
        try {
            Socket mysocket = new Socket("localhost", 9999); //envía el paquete offline al server para indicar que el cliente está en se desconectó
            JsonObject jobj = new JsonObject();
            jobj.addProperty("puerto",clienteescucha.getMyPort());
            jobj.addProperty("mensaje","online");
            jobj.addProperty("nombre","nombre");
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
