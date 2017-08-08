package com.distributedsystem.client;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
This class define implementation of TCP client to send requests to TCP server
 */
public class TcpClientMain {

    private static final Logger LOGGER = Logger.getLogger(TcpClientMain.class.getName());

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in, "UTF-8");

        System.out.println("Enter number of client instances that you need to run ");
        int noOfClientInstances = scanner.nextInt();

        for (int i = 1; i <= noOfClientInstances; i++) {

            TcpClientThread tcpClientThread = new TcpClientThread();
            tcpClientThread.start();
            LOGGER.log(Level.FINE, "processing " + i + "entries in loop");

        }


    }
}
