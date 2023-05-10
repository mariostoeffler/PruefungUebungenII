package PersonsUEAbend;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class PersonClient {

    public static void main(String[] args) {
        try (Socket server = new Socket("localhost", 1234);


             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));

             ObjectInputStream ois = new ObjectInputStream(server.getInputStream())) {

            //schicke id 25 und schreibe Person auf die Kommandozeile
            bw.write("get 25");
            bw.newLine(); //nicht vergessen
            bw.flush();

            //command an Server gesendet

            Person person;
            while ((person = (Person) ois.readObject()) != null) {
                System.out.println(person);

            }


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
