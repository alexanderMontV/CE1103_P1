package com.interfaz;

import com.estructuras.jugador;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Interfaz extends JFrame implements Runnable{

    public static Integer getMyPort() {return myport;
    }

    private static Integer myport;
    public Interfaz(){

    }
    private JLabel[][] dots = new JLabel[5][5];
    private JLabel[][] herizontalLines = new JLabel[5][5];
    private JLabel[][] verticallLines = new JLabel[5][4];

    private int myPort;

    public Interfaz(String title) {

        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620, 640);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

        JPanel pantalla=new JPanel();
        pantalla.setLayout(null);
        pantalla.setSize(600,600);
        add(pantalla);

        Thread hilo = new Thread(this);
        hilo.start();



        for (int i = 0; i < dots.length; i++) {
            for (int j = 0; j < dots.length; j++) {
                dots[i][j] = new JLabel();
                dots[i][j].setBounds(20 + i * (20 + 50), 20 + j * (20 + 50), 20, 20);
                dots[i][j].setOpaque(true);
                dots[i][j].setBackground(Color.red);
                pantalla.add(dots[i][j]);
                pantalla.repaint();
            }
        }
        for (int i = 0; i < herizontalLines.length; i++) {
            for (int j = 0; j < herizontalLines[0].length; j++) {
                herizontalLines[i][j] = new JLabel();
                herizontalLines[i][j].setBounds(40 + j * (20 + 50), 20 + i * (20 + 50), 50, 20);
                herizontalLines[i][j].setOpaque(true);
                herizontalLines[i][j].setBackground(Color.green);
                herizontalLines[i][j].setVisible(false);
                pantalla.add(herizontalLines[i][j]);
                pantalla.repaint();
            }
        }
        for (int i = 0; i < verticallLines.length; i++) {
            for (int j = 0; j < verticallLines[0].length; j++) {
                verticallLines[i][j] = new JLabel();
                verticallLines[i][j].setBounds(20 + i * (20 + 50), 40 + j * (20 + 50), 20, 50);
                verticallLines[i][j].setOpaque(true);
                verticallLines[i][j].setBackground(Color.green);
                verticallLines[i][j].setVisible(false);
                pantalla.add(verticallLines[i][j]);
                pantalla.repaint();
            }
        }
        pantalla.addMouseListener(new MouseInputAdapter() {
            int count = 0;
            @Override
            public void mouseClicked(MouseEvent e) {
                int mX = e.getX();
                int mY = e.getY();
                System.out.println(mX);
                System.out.println(mY);
                boolean b = false;
                for (JLabel[] l : herizontalLines) {
                    for (JLabel l1 : l) {
                        b = checkBounds(l1, mX, mY);
                        if (b) {
                            l1.setVisible(true);
                            break;
                        }
                    }
                }
                if (!b) {
                    for (JLabel[] l : verticallLines) {
                        for (JLabel l1 : l) {
                            b = checkBounds(l1, mX, mY);
                            if (b) {
                                l1.setVisible(true);
                                break;
                            }
                        }
                    }
                }
                System.out.println(b + " metodo finalizado " + count);
                pantalla.revalidate();
                pantalla.repaint();
                count++;
            }
        });
        pantalla.revalidate();
        pantalla.repaint();
    }

    public boolean checkBounds(JLabel l, int x, int y) {
        return (x >= l.getX() && x <= l.getX() + l.getWidth()) && (y >= l.getY() && y <= l.getY() + l.getHeight());
    }

    public static   void main(String[] args) {
        new Interfaz("Juego");
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
                    System.out.println(mensajeRecibido);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
