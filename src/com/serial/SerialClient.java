package com.serial;

import com.fazecast.jSerialComm.SerialPort;

import java.nio.charset.StandardCharsets;

public class SerialClient {
    int BaudRate;
    int DataBits;
    int StopBits;
    int Parity;
    SerialPort MySerialPort;
    public SerialClient() {
        this.BaudRate = 9600;
        this.DataBits = 8;
        this.StopBits = SerialPort.ONE_STOP_BIT;
        this.Parity   = SerialPort.NO_PARITY;
        SerialPort[] AvailablePorts = SerialPort.getCommPorts();
        this.MySerialPort = AvailablePorts[0];
    }
    public void open(){
        MySerialPort.setComPortParameters(this.BaudRate,
                this.DataBits,
                this.StopBits,
                this.Parity);
        MySerialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING,
                50,
                10000);
        MySerialPort.openPort();
    }
    public String getMesg() {
        String data = null;
        if (MySerialPort.bytesAvailable() > 0) { //Se verifica que haya bytes disponibles para leer en el puerto
            byte[] readBuffer = new byte[MySerialPort.bytesAvailable()]; //Se crea un buffer el cual permite tener un control de los bytes que son recibidos del arduino
            int bytesRead = MySerialPort.readBytes(readBuffer, readBuffer.length); //Se leen los datos recibidos
            data = new String(readBuffer, StandardCharsets.UTF_8); //Se "traducen" los bytes recibidos para poder ser analizados
        }
        return data;
    }
    public void CloseConn(){
        MySerialPort.closePort();
    }
}
