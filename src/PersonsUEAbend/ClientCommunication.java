package PersonsUEAbend;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientCommunication implements Runnable {

    private Socket client;

    public ClientCommunication(Socket socket) {
        this.client = socket;
    }

    public void handleCommunications() {

        PersonLoader pl = new PersonLoader("C:\\Users\\Mario\\IdeaProjects\\PruefungUebungenII\\src\\PersonsUEAbend\\persons.csv");
        try {
            ArrayList<Person> newlist = pl.load();

            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());

            //zum Schreiben von Objekten verwenden wir den Objectoutputstream
            //zum Schreiben von Textdaten verwenden wir den Bufferedwriter/PrintWriter

            String line;
            ArrayList<Person> temp = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");

                if (line.length() == 2) {
                    temp = getIDnew(Integer.parseInt(fields[0]), newlist);
                    oos.writeObject(temp);

                }

                if (line.equalsIgnoreCase("exit")) {
                    System.out.println("clients wants to exit");
                    oos.flush();
                    break;
                }

                if (line.equalsIgnoreCase("getall")) {
                    oos.writeObject(pl);
                }

                 else {
                    System.out.println("falsche Eingabe!");
                    oos.writeObject(null);
                }

                oos.flush();

            }


        } catch (PersonLoadException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            try {
                throw new PersonLoadException("Fehler beim Einlesen", e);
            } catch (PersonLoadException ex) {
                throw new RuntimeException(ex);
            }
        }


    }

    private ArrayList<Person> getIDnew(int id, ArrayList<Person> list) {
        ArrayList<Person> temp = new ArrayList<>();

        for (Person person : list) {
            if (person.getId() == id) {
                temp.add(person);
            }

        }
        return temp;

    }


    @Override
    public void run() {
        handleCommunications();
    }

}
