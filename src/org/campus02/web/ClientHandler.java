package org.campus02.web;

import java.io.*;
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
                String[] fields = line.split(" ");
                if (line.equalsIgnoreCase("bye")) {
                    client.close();
                }

                if  (fields.length != 2)  {
                    bw.write("error: command invalid");
                    bw.newLine();
                    bw.flush();
                    continue;

                }

                if (line.startsWith("fetch")) {
                    String url = fields[1];
                    try {
                        WebPage page = proxy.fetch(fields[1]);
                    } catch (UrlLoaderException e) {
                        throw new RuntimeException(e);
                    } catch (CacheMissException e) {
                        e.printStackTrace();
                    }
                    bw.newLine();
                    bw.flush();

                }

                if (line.startsWith("stats")) {
                    if (line.contains("hits")) {
                        bw.write(proxy.statHits());
                    }
                    if(line.contains("misses")) {
                        bw.write(proxy.statsMisses());
                    }
                    else {
                        bw.write("invalid command / hits or misses required");
                    }
                }







            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
