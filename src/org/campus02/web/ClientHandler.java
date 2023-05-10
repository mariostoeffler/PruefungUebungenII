package org.campus02.web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket client;
    private WebProxy proxy;

    public ClientHandler(Socket client, WebProxy proxy) {
        this.client = client;
        this.proxy = proxy;
    }

    @Override
    public void run() {

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
             BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.equalsIgnoreCase("bye")) {
                    break;
                }



            }
        }

    }
}
