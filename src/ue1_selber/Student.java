package ue1_selber;

public class Student {

    private String vorname;
    private String nachname;
    private double matrikelnummer;
    private double gebdatum;
    private String studiengang;
    private String studienfach;
    private int semester;
    private String adresse;

    private int alter;

    public Student(String vorname, String nachname, double matrikelnummer, double gebdatum, String studiengang, String studienfach, int semester, String adresse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.matrikelnummer = matrikelnummer;
        this.gebdatum = gebdatum;
        this.studiengang = studiengang;
        this.studienfach = studienfach;
        this.semester = semester;
        this.adresse = adresse;
    }

    public Student(String vorname, int alter) {
        this.vorname = vorname;
        this.alter = alter;
    }


    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public double getMatrikelnummer() {
        return matrikelnummer;
    }

    public double getGebdatum() {
        return gebdatum;
    }

    public String getStudiengang() {
        return studiengang;
    }

    public String getStudienfach() {
        return studienfach;
    }

    public int getSemester() {
        return semester;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getAlter() {
        return alter;
    }

    @Override
    public String toString() {
        return "Student{" +
                "vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", matrikelnummer=" + matrikelnummer +
                ", gebdatum=" + gebdatum +
                ", studiengang='" + studiengang + '\'' +
                ", studienfach='" + studienfach + '\'' +
                ", semester=" + semester +
                ", adresse='" + adresse + '\'' +
                ", alter=" + alter +
                '}';
    }
}
