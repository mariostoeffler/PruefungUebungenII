package PersonsUEAbend;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PersonServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket newS = new ServerSocket(1234))
        {


            while (true) {

                System.out.println("warte auf Verbindung");
                Socket client = newS.accept(); //warte auf client, listener
                System.out.println("Client hat sich verbunden");

                ClientCommunication clientCommunication = new ClientCommunication(client);
                new Thread(clientCommunication).start(); //starte communication handler


            }


        }
    }

}
