package EinwohnerUEAbend;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class EinwohnerManager {

    public static void main(String[] args) throws DataFileException {
        ArrayList<Einwohner> list = new EinwohnerManager().loadEinwohner();
        for (Einwohner einwohner : list) {
            System.out.println(einwohner);



        }


    }

    public ArrayList<Einwohner> loadEinwohner() throws DataFileException {
        String file = "src/EinwohnerUEAbend/testdata-einwohner.csv";


        ArrayList<Einwohner> einwohners = new ArrayList<>();
        String line = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine(); //liest erste Zeile ein
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");

                if (fields.length != 4) {
                    throw new DataFileException("falsches Format!");
                }

                int id = Integer.parseInt(fields[0]);
                int gebDatum = Integer.parseInt(fields[3]);


                einwohners.add(new Einwohner(id, fields[1], fields[2], gebDatum));




            }

            einwohners.sort(new GeburtenJahrComparator());
            return einwohners;

        } catch (FileNotFoundException e) {
            throw new DataFileException("File not found", e);
        } catch (IOException e) {
            throw new DataFileException("Fehler beim Einlesen", e);
        }


    }
}
