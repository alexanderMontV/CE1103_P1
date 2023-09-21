package com.serial;

import com.fazecast.jSerialComm.SerialPort;

import static java.nio.charset.StandardCharsets.UTF_8;

public class TestSerialNOUSO {
    public static void main(String[] args) {
        int BaudRate = 115200;
        int DataBits = 8;
        int StopBits = SerialPort.ONE_STOP_BIT;
        int Parity   = SerialPort.NO_PARITY;
        SerialPort [] AvailablePorts = SerialPort.getCommPorts();

        //Open the first Available port
        SerialPort MySerialPort = AvailablePorts[0];

        MySerialPort.openPort(); //open the port
        //Arduino May get reset

        if (MySerialPort.isOpen())//Check whether port open/not
            System.out.println("is Open ");
        else
            System.out.println(" Port not open ");


        if (MySerialPort.isOpen())
            System.out.println(" is Open ");
        else
            System.out.println("\n Port not open ");
//Sets all serial port parameters at one time
        MySerialPort.setComPortParameters(BaudRate,
                DataBits,
                StopBits,
                Parity);

//Set Read Time outs
        MySerialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING,
                1000,
                10000);

        MySerialPort.openPort();

        try
        {
            while (true)
            {

                byte[] readBuffer = new byte[100];

                int numRead = MySerialPort.readBytes(readBuffer,
                        readBuffer.length);
                if (numRead>0){
                    System.out.print("Read " + numRead + " bytes -");

                    //Convert bytes to String
                    String S = new String(readBuffer, UTF_8);

                    System.out.println("Received -> "+ S);}

            }
        }
        catch (Exception e)
        {

            e.printStackTrace();
        }

        MySerialPort.closePort();
    }

}
