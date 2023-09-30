package com.sockets;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class outrun implements Runnable{
    private int myPort;

    public outrun(){
        Thread escucho = new Thread(this);
        escucho.start();
    }

    public int getMyPort() {
        return myPort;
    }

    @Override
    public void run() {
        try {
            System.out.println("se ha abierto el socket");
            /**
             * @see https://docs.oracle.com/javase/8/docs/api/java/net/ServerSocket.html#ServerSocket-int-
             * */
            ServerSocket server = new ServerSocket(0);//puerto del cliente a la espera de recibir mensajes, el puerto abre en el que encuentre disponible
            this.myPort= server.getLocalPort();//obtiene el valor del puerto que abre automáticamente para poder emplearlo en el servidor
            System.out.println("puerto del socket:"+myPort);

            Socket cliente;


            while (true) { //siempre ejecutandose para esperar un nuevo mensaje

                cliente = server.accept();

                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());

                //TODO JSON
                String msg = (String) flujoEntrada.readObject();
                //verifica si no es un mensaje de estado, entonces añade el mensaje recibido al area de chat
                if (msg != null){
                    System.out.println(msg);

                    //si es un mensaje de estado se actualiza la lista de dirección desplegable
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
