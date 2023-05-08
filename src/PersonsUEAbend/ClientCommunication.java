package PersonsUEAbend;

import java.net.Socket;

public class ClientCommunication implements Runnable {

    private Socket socket;

    public ClientCommunication(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {

    }
}
