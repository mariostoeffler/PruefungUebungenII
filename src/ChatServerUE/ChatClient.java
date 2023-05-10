package ChatServerUE;

import java.net.Socket;

public class ChatClient implements Runnable{

    private Socket client = new Socket();

    public ChatClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {





    }
}
