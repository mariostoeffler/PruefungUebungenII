package PersonsUEAbend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PersonLoader {


    private String path;

    public PersonLoader(String path) {
        this.path = path;
    }

    public ArrayList<Person> load() throws PersonLoadException, IOException {

        ArrayList<Person> temp = new ArrayList<>();
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] fields = line.split(";");

                if (fields.length != 3) {
                    throw new PersonLoadException("Falsches Format!");
                }
                    Person person = new Person(Integer.parseInt(fields[0]), fields[1], fields[2]);
                    temp.add(person);

            }

        } catch (FileNotFoundException e) {
            throw new PersonLoadException("Datei nicht gefunden", e);
        }

return temp;
    }

}
