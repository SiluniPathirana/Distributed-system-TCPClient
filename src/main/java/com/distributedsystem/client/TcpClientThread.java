package com.distributedsystem.client;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
This Class implemets a thread of a TCP Client
 */
public class TcpClientThread extends Thread {

    private static final Logger LOGGER = Logger.getLogger(TcpClientThread.class.getName());
    private String host = "localhost";
    private int port = 25000;
    private Socket clientSocket;

    public void run() {
        try {
            InetAddress address = InetAddress.getByName(host);
            clientSocket = new Socket(address, port);
            OutputStream outputStream = clientSocket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("Hello");
            bufferedWriter.flush();

        } catch (Exception exception) {
            LOGGER.log(Level.SEVERE, exception.toString(), exception);
        }
    }
}
