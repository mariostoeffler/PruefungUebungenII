package EinwohnerUEAbend;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EinwohnerServer {

    public static void main(String[] args) throws CommunicationException, DataFileException {
        try {
            ServerSocket serverSocket = new ServerSocket(1111);
            while (true) {
                System.out.println("warte auf Client");

                Socket client = serverSocket.accept();
                int port = serverSocket.getLocalPort();
                System.out.println("client hat sich verbunden");
                System.out.println("Der verbundene Port lautet "+port);

                EinwohnerLogik einwohnerLogik = new EinwohnerLogik(client);
                einwohnerLogik.process();



            }




        } catch (IOException e) {
            throw new CommunicationException("nicht gefunden!");
        }

    }
}
