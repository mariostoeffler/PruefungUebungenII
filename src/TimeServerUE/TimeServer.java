package TimeServerUE;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(1111);

        while (true) {
            System.out.println("waiting for Client");
            Socket client = ss.accept();
            System.out.println("Client hat sich verbunden");
            LocalDateTime datetime = LocalDateTime.now();

            long startTime = System.currentTimeMillis();
            long elapsedTime = 0;


            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {
                while (elapsedTime < 1000) {

                    bw.write(datetime.toString());
                    bw.flush();
                    elapsedTime = System.currentTimeMillis() - startTime;

                }
                bw.flush();
            }



        }
    }
}
