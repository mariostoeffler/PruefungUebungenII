package ue1_selber;

import java.io.*;
import java.util.ArrayList;

public class StudentLoader {


    public ArrayList<Student> loadStudents(String path) throws StudentLoadException {
        ArrayList<Student> students = new ArrayList<>();
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;


        try {
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length != 2) {
                    throw new StudentLoadException("Falsches Format");
                }
                String name = fields[0];
                int alter = Integer.parseInt(fields[1]);

                Student student = new Student(name, alter);
                students.add(student);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;
    }


}









