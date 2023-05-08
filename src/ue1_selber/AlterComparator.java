package ue1_selber;

import java.util.Comparator;

public class AlterComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int alterComparator = Integer.compare(o2.getAlter(), o1.getAlter());

        if (alterComparator != 0) {
            return alterComparator;
        }
        return o2.getVorname().compareTo(o1.getVorname());



    }
}
