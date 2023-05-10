package TimeServerUE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TimeClient {

    public static void main(String[] args) throws IOException {
        Socket c = new Socket("localhost", 1111);

        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()))) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            c.close();

        }
    }
}
