package com.interfaz;

import com.estructuras.jugador;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameScreen extends Application implements Runnable{
    private Parent root;
    private int myPort;

    private int posS;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

         this.root = FXMLLoader.load(getClass().getResource("grafica.fxml"));

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Connect Dots CE1103-P1");
        stage.setScene(scene);
        stage.show();
        Thread hilo = new Thread(this);
        hilo.start();

    }

    @Override
    public void run() {
        try {
            /**
             * @see https://docs.oracle.com/javase/8/docs/api/java/net/ServerSocket.html#ServerSocket-int-
             * */
            ServerSocket server = new ServerSocket(0);//puerto del cliente a la espera de recibir mensajes, el puerto abre en el que encuentre disponible
            this.myPort= server.getLocalPort();//obtiene el valor del puerto que abre automáticamente para poder emplearlo en el servidor
            //System.out.println("puerto del socket:"+myPort);

            try {
                Socket mysocket = new Socket("localhost", 9999); //envia el paquete online con el dato "ONLINE" al servidor
                String player = new Gson().toJson(new jugador("player:"+myPort,myPort,0));
                JsonObject jdor = new Gson().fromJson(player, JsonObject.class);

                JsonObject jobj = new JsonObject();

                jobj.addProperty("puerto",myPort);
                jobj.addProperty("mensaje","online");
                jobj.add("data",jdor);
                String jsonO = String.valueOf(jobj);

                ObjectOutputStream flujo = new ObjectOutputStream(mysocket.getOutputStream());
                flujo.writeObject(jsonO);
                this.posS=0;
                Pane prime = (Pane) root.lookup("#0");
                prime.setBackground(new Background(new BackgroundFill(Color.web("#" + "00FF00"), CornerRadii.EMPTY, Insets.EMPTY)));


                mysocket.close();

            } catch (UnknownHostException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }catch (Exception e2) {
                System.out.println("Error desconocido 2");
            }

            Socket cliente;

            while (true) { //siempre ejecutandose para esperar un nuevo mensaje

                cliente = server.accept();

                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());

                //TODO JSON
                String msg = (String) flujoEntrada.readObject();
                JsonObject jobj = new JsonParser().parse(msg).getAsJsonObject();
                String mensajeRecibido = jobj.get("mensaje").getAsString();
                //verifica si no es un mensaje de estado, entonces añade el mensaje recibido al area de chat
                if (msg != null){
                    Pane prime = (Pane) root.lookup("#"+this.posS);
                    prime.setBackground(new Background(new BackgroundFill(Color.web("#" + "0000FF"), CornerRadii.EMPTY, Insets.EMPTY)));
                    this.posS=jobj.get("actualpos").getAsInt();
                    Pane nprime = (Pane) root.lookup("#"+this.posS);
                   nprime.setBackground(new Background(new BackgroundFill(Color.web("#" + "00FFOO"), CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}