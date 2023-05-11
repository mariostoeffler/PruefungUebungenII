package org.campus02.web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        WebProxy webProxy = new WebProxy();

        try (ServerSocket ss = new ServerSocket(5678))
        {

            while (true) {
                System.out.println("warte auf Client");
                Socket client = ss.accept();
                System.out.println("Client connected");
                Thread th = new Thread(new ClientHandler(client, webProxy));
                th.start();

            }
        }

    }
}
