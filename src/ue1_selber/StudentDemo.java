package ue1_selber;

import java.util.ArrayList;

public class StudentDemo {

    public static void main(String[] args) {
        StudentLoader sl = new StudentLoader();
        ArrayList<Student> students = new ArrayList<>();

        try {
            students = sl.loadStudents("C:\\Users\\Mario\\IdeaProjects\\PruefungUebungenII\\src\\ue1_selber\\students.csv");
        } catch (StudentLoadException e) {
            throw new RuntimeException(e);
        }

        students.sort(new AlterComparator());

        for (Student student : students) {
            System.out.println(student);

        }



    }
}
