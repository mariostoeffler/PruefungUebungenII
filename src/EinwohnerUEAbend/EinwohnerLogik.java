package EinwohnerUEAbend;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;

public class EinwohnerLogik {

    //Kommunikation mit dem Server wird hier abgebildet

    private Socket client;

    public EinwohnerLogik(Socket client) {
        this.client = client;
    }

    public void process() throws CommunicationException, DataFileException {
        //vom Client lesen -> inputStream
        //com Client senden -> outputStream

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));


            ArrayList<Einwohner> einwohners = new EinwohnerManager().loadEinwohner();

            String clientInput;

            while ((clientInput = br.readLine()) != null) {
                // bei GET Bundesland -> retourniere Einwohner für das Bundesland
                // bei GET Geburtsjahr order by name -> retourniere Einwohner für das Geburtsjahr
                // bei EXIT -> schließe Verbindung
                //bei anderem Input -> schicke "falscher Input"

                if (clientInput.startsWith("get")) {
                    ArrayList<Einwohner> einwohnerFiltered = new ArrayList<>();
                    String[] fields = clientInput.split(" ");
                    if (fields.length == 2) {
                        einwohnerFiltered = getByBundesland(fields[1], einwohners);

                    }

                    else {
                        einwohnerFiltered = getbyGeburtsjahr(Integer.parseInt(fields[1]), einwohners);
                    }
                    for (Einwohner einwohner : einwohnerFiltered) {
                        bw.write(einwohner.toString());
                        bw.newLine();

                    }
                }


                else if (clientInput.equalsIgnoreCase("exit")) {
                    break;
                }

                else {
                    bw.write("falscher Input!");
                }

                bw.newLine();
                bw.flush();


            }


        } catch (IOException e) {
            throw new CommunicationException("Fehler beim Zugriff auf die Datei");
        }


    }

    private ArrayList<Einwohner> getByBundesland(String bundesland, ArrayList<Einwohner> einwohners) {
        ArrayList<Einwohner> einwohnerFiltered = new ArrayList<>();
        for (Einwohner einwohner : einwohners) {
            if (einwohner.getBundesland().equalsIgnoreCase(bundesland))
                einwohnerFiltered.add(einwohner);
        }
        return einwohnerFiltered;
    }

    private ArrayList<Einwohner> getbyGeburtsjahr(int geburtsjahr, ArrayList<Einwohner> einwohners) {
        ArrayList<Einwohner> einwohnerGeburtsjahr = new ArrayList<>();
        for (Einwohner einwohner : einwohners) {
            if (einwohner.getGeburtsjahr()== geburtsjahr) {
                einwohnerGeburtsjahr.add(einwohner);

            }

        }

        Collections.sort(einwohnerGeburtsjahr);
        return einwohnerGeburtsjahr;
    }
}
